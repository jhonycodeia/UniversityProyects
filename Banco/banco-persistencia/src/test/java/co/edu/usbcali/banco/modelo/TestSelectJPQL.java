package co.edu.usbcali.banco.modelo;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.edu.usbcali.banco.dto.ClienteCuenta;
import co.edu.usbcali.banco.dto.ClienteCuentaRegistrada;
//import co.edu.usbcali.banco.dto.CalculosCuentas;
import co.edu.usbcali.banco.modelo.Cliente;
import co.edu.usbcali.banco.modelo.Cuenta;
import co.edu.usbcali.banco.modelo.TipoDocumento;
import co.edu.usbcali.banco.modelo.Transaccion;

public class TestSelectJPQL {

	private final static Logger log = LoggerFactory.getLogger(TestSelectJPQL.class);
	private final static String persistenceUnit = "banco-persistencia";

	EntityManagerFactory entityManagerFactory = null;
	EntityManager entityManager = null;

	Character activo = 'S';
	String nombre = "Damien Hanbidge";

	@Before
	public void antes() {
		log.info("Ejecuto antes");
		entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnit);
		entityManager = entityManagerFactory.createEntityManager();
	}

	@After
	public void despues() {
		log.info("Ejecuto despues");
		entityManager.close();
		entityManagerFactory.close();
	}

	@Test
	public void testSelectAll() {
		log.info("Ejecuto testSelectAll");
		String jpql = "SELECT cli FROM Cliente cli";
		assertNotEquals("El jpql esta vacio", jpql, "");

		List<Cliente> losClientes = entityManager.createQuery(jpql).getResultList();

		for (Cliente cliente : losClientes) {
			log.info("id:" + cliente.getClieId());
			log.info("Nombre:" + cliente.getNombre());
		}

	}

	@Test
	public void testSelectWhereActivo() {
		log.info("Ejecuto testSelectWhere");
		String jpql = "SELECT cli FROM Cliente cli WHERE cli.activo='S'";
		assertNotEquals("El jpql esta vacio", jpql, "");

		List<Cliente> losClientes = entityManager.createQuery(jpql).getResultList();

		for (Cliente cliente : losClientes) {
			log.info("id:" + cliente.getClieId());
			log.info("Nombre:" + cliente.getNombre());
		}

	}

	@Test
	public void testSelectWhereTipoDocumento() {
		log.info("Ejecuto testSelectWhere");
		String jpql = "SELECT cli FROM Cliente cli WHERE cli.tipoDocumento.nombre='CC'";
		assertNotEquals("El jpql esta vacio", jpql, "");

		List<Cliente> losClientes = entityManager.createQuery(jpql).getResultList();

		for (Cliente cliente : losClientes) {
			log.info("id:" + cliente.getClieId());
			log.info("Nombre:" + cliente.getNombre());
		}

	}

	@Test
	public void testSelectWhereActivoParametro() {
		log.info("Ejecuto testSelectWhere");
		String jpql = "SELECT cli FROM Cliente cli WHERE cli.activo=:lolita AND cli.nombre=:elNombre";
		assertNotEquals("El jpql esta vacio", jpql, "");

		List<Cliente> losClientes = entityManager.createQuery(jpql).setParameter("lolita", activo)
				.setParameter("elNombre", nombre).getResultList();

		for (Cliente cliente : losClientes) {
			log.info("id:" + cliente.getClieId());
			log.info("Nombre:" + cliente.getNombre());
		}
	}

	@Test
	public void testSelectFuncionCount() {
		log.info("Ejecuto testSelectWhere");
		String jpql = "SELECT count(cue) FROM Cuenta cue";
		assertNotEquals("El jpql esta vacio", jpql, "");

		Long numeroDeCuentas = (Long) entityManager.createQuery(jpql).getSingleResult();

		log.info("Numero de Cuentas:" + numeroDeCuentas);
	}

	@Test
	public void testSelectFuncionSum() {
		log.info("Ejecuto testSelectWhere");
		String jpql = "SELECT SUM(cue.saldo) FROM Cuenta cue";
		assertNotEquals("El jpql esta vacio", jpql, "");

		BigDecimal suma = (BigDecimal) entityManager.createQuery(jpql).getSingleResult();

		log.info("Numero de Cuentas:" + suma);
	}

	@Test
	public void testSelectFuncionAvg() {
		log.info("Ejecuto testSelectWhere");
		String jpql = "SELECT AVG(cue.saldo) FROM Cuenta cue";
		assertNotEquals("El jpql esta vacio", jpql, "");

		Double suma = (Double) entityManager.createQuery(jpql).getSingleResult();

		log.info("Promedio:" + suma);
	}

	@Test
	public void testSelectFunciones() {
		log.info("Ejecuto testSelectFunciones");
		String jpql = "SELECT  count(cue), SUM(cue.saldo), AVG(cue.saldo), MIN(cue.saldo), MAX(cue.saldo) FROM Cuenta cue";
		assertNotEquals("El jpql esta vacio", jpql, "");

		Object[] object = (Object[]) entityManager.createQuery(jpql).getSingleResult();

		log.info("" + object[0]);
		log.info("" + object[1]);
		log.info("" + object[2]);
		log.info("" + object[3]);
		log.info("" + object[4]);

	}

	/*
	 * @Test public void testSelectFuncionesDTO() {
	 * log.info("Ejecuto testSelectFunciones"); String
	 * jpql="SELECT new  co.edu.usbcali.banco.dto.CalculosCuentas( count(cue), SUM(cue.saldo), AVG(cue.saldo), MIN(cue.saldo), MAX(cue.saldo)) FROM Cuenta cue"
	 * ; assertNotEquals("El jpql esta vacio", jpql,"");
	 * 
	 * CalculosCuentas
	 * calculosCuentas=(CalculosCuentas)entityManager.createQuery(jpql).
	 * getSingleResult();
	 * 
	 * assertNotNull(calculosCuentas);
	 * 
	 * log.info(""+calculosCuentas.getSum());
	 * 
	 * 
	 * }
	 */

	@Test
	public void testSelectCollection() {
		log.info("Ejecuto testSelectFunciones");
		String jpql = "SELECT cli FROM Cliente cli WHERE cli.cuentas.size>10";
		assertNotEquals("El jpql esta vacio", jpql, "");

		List<Cliente> losClientes = (List<Cliente>) entityManager.createQuery(jpql).getResultList();

		for (Cliente cliente : losClientes) {
			log.info("id:" + cliente.getClieId());
			log.info(cliente.getNombre());
		}

	}

	/* Consultar la cuenta que tiene mas dinero. Use MAX */
	@Test
	public void testSelectCuentaMax() {
		log.info("Ejecuto testSelectFunciones");
		String jpql = "SELECT cue FROM Cuenta cue where cue.saldo=(SELECT MAX(cue.saldo) FROM cue)";
		// String jpql = "SELECT cue FROM Cuenta cue ORDER BY cue.saldo DESC";
		assertNotEquals("El jpql esta vacio", jpql, "");

		Cuenta cuenta = (Cuenta) entityManager.createQuery(jpql).setMaxResults(1).getSingleResult();

		log.info(cuenta.toString());

	}

	/* Consultar la cuenta que tiene menos dinero. Use MIN. */
	@Test
	public void testSelectCuentaMin() {
		log.info("Ejecuto testSelectFunciones");
		String jpql = "SELECT cue FROM Cuenta cue where cue.saldo=(SELECT MIN(cue.saldo) FROM cue)";
		// String jpql = "SELECT cue FROM Cuenta cue ORDER BY cue.saldo";
		assertNotEquals("El jpql esta vacio", jpql, "");

		Cuenta cuenta = (Cuenta) entityManager.createQuery(jpql).setMaxResults(1).getSingleResult();

		log.info(cuenta.toString());

	}

	/* Consultar la suma de los saldos disponibles en las cuentas del banco. Use SUM */
	@Test
	public void testSelectCuentaSum() {
		log.info("Ejecuto testSelectFunciones");
		String jpql = "SELECT SUM(cue.saldo) FROM Cuenta cue";

		assertNotEquals("El jpql esta vacio", jpql, "");

		BigDecimal sumCuenta = (BigDecimal) entityManager.createQuery(jpql).getSingleResult();

		log.info("la suma de todos los saldos de las cuentas es: " + sumCuenta.toString());

	}

	/* Consultar el total de dinero que tiene un cliente sumando el saldo de todas las cuentas que le pertenecen. Use SUM*/
	@Test
	public void testSelectCuentaSumCliente() {
		log.info("Ejecuto testSelectFunciones");
		/*
		 * String jpql =
		 * "SELECT new co.edu.usbcali.banco.dto.ClienteCuenta(cli.clieId,cli.nombre,"
		 * +
		 * "(SELECT SUM(cue.saldo) FROM Cuenta cue where cue.cliente.clieId=cli.clieId)) "
		 * + " FROM Cliente cli";
		 */

		String jpql = "SELECT new co.edu.usbcali.banco.dto.ClienteCuenta(cue.cliente.clieId,cue.cliente.nombre,"
				+ "SUM(cue.saldo)) " + " FROM Cuenta cue GROUP BY cue.cliente.clieId,cue.cliente.nombre";

		assertNotEquals("El jpql esta vacio", jpql, "");

		List<ClienteCuenta> losClientes = entityManager.createQuery(jpql).getResultList();

		for (ClienteCuenta cliente : losClientes) {
			log.info("id: " + cliente.getClieId() + " Nombre: " + cliente.getNombre() + " SaldoTotal: "
					+ cliente.getSaldoTotal());
		}

		log.info("cantidad de clientes: " + losClientes.size());

	}

	/* Consultar el promedio de los saldos disponibles en las cuentas del banco. Use AVG */
	@Test
	public void testSelectCuentaAvg() {
		log.info("Ejecuto testSelectFunciones");
		String jpql = "SELECT AVG(cue.saldo) FROM Cuenta cue";

		assertNotEquals("El jpql esta vacio", jpql, "");

		Double avgCuenta =  (Double)entityManager.createQuery(jpql).getSingleResult();

		log.info("El promedio de los saldos de las cuentas es: " + avgCuenta.toString());

	}
	
	/* Consultar todos los retiros cuya cantidad este entre 100.000 y 150.000. Use Between */
	@Test
	public void testSelectTransacionBetween() {
		log.info("Ejecuto testSelectFunciones");
		String jpql = "SELECT tran FROM Transaccion tran where tran.tipoTransaccion.nombre=:tipo and"
				+ " tran.valor BETWEEN :menor AND :mayor";
		String tipo = "RETIRO";
		BigDecimal menor = new BigDecimal(100000),mayor = new BigDecimal(150000);

		assertNotEquals("El jpql esta vacio", jpql, "");
		
		Query query = entityManager.createQuery(jpql);
		query.setParameter("tipo",tipo);
		query.setParameter("menor",menor);
		query.setParameter("mayor",mayor);
		
		List<Transaccion> listTransaccion =  query.getResultList();

		for (Transaccion transaccion : listTransaccion) {
			log.info(transaccion.toString());
		}

	}
	
	/* Consultar todos los clientes que tengan en el nombre una o mas apariciones de la letra a. Use LIKE */
	@Test
	public void testSelectALike() {
		log.info("Ejecuto testSelectFunciones");
		String jpql = "SELECT cli FROM Cliente cli where cli.nombre LIKE :letra";
		String letra = "%a%";
		

		assertNotEquals("El jpql esta vacio", jpql, "");
		
		Query query = entityManager.createQuery(jpql);
		query.setParameter("letra",letra);
		
		
		List<Cliente> listTransaccion =  query.getResultList();

		for (Cliente cliente : listTransaccion) {
			log.info(cliente.toString());
		}

	}
	
	/* Consultar todos los clientes que tienen mas de una cuenta */
	@Test
	public void testSelectClienteCuentaCount() {
		log.info("Ejecuto testSelectFunciones");
		//String jpql = "SELECT cli FROM Cliente cli where cli.cuentas.size > 1";
		String jpql = "SELECT cli FROM Cliente cli where (SELECT count(cue.cuenId) "
				+ " FROM Cuenta cue where cue.cliente.clieId=cli.clieId) > 1";		

		assertNotEquals("El jpql esta vacio", jpql, "");		
		
		List<Cliente> listTransaccion =  entityManager.createQuery(jpql).getResultList();

		for (Cliente cliente : listTransaccion) {
			log.info(cliente.toString());
		}

	}
	
	/* Consultar todas las consignaciones por numero de cuenta. */
	@Test
	public void testSelectClienteCuentaConsigon() {
		log.info("Ejecuto testSelectFunciones");
		String jpql = "SELECT tran FROM Transaccion tran where tran.tipoTransaccion.nombre=:tipo and"
				+ " tran.cuenta.cuenId =:numero ";
		
		String tipo = "CONSIGNACION",numero = "4640-0341-9387-5781";
		

		assertNotEquals("El jpql esta vacio", jpql, "");
		
		Query query = entityManager.createQuery(jpql);
		query.setParameter("tipo",tipo);
		query.setParameter("numero",numero);		
		
		List<Transaccion> listTransaccion =  query.getResultList();

		for (Transaccion transaccion : listTransaccion) {
			log.info(transaccion.toString());
		}

	}
	
	/* Consultar las consignaciones realizadas en las cuentas de un cliente por el id del cliente. */
	@Test
	public void testSelectClienteConsigon() {
		log.info("Ejecuto testSelectFunciones");
		String jpql = "SELECT tran FROM Transaccion tran where tran.tipoTransaccion.nombre=:tipo and"
				+ " tran.cuenta.cliente.clieId =:numero ";
		
		String tipo = "CONSIGNACION";
		BigDecimal numero = new BigDecimal(1000);
		

		assertNotEquals("El jpql esta vacio", jpql, "");
		
		Query query = entityManager.createQuery(jpql);
		query.setParameter("tipo",tipo);
		query.setParameter("numero",numero);		
		
		List<Transaccion> listTransaccion =  query.getResultList();

		for (Transaccion transaccion : listTransaccion) {
			log.info(transaccion.toString());
		}

	}
	
	/* Consultar los retiros mayores a 100.000. */
	@Test
	public void testSelectClienteRetiro() {
		log.info("Ejecuto testSelectFunciones");
		String jpql = "SELECT tran FROM Transaccion tran where tran.tipoTransaccion.nombre=:tipo and"
				+ " tran.valor >:numero ";
		
		String tipo = "RETIRO";
		BigDecimal numero = new BigDecimal(100000);
		

		assertNotEquals("El jpql esta vacio", jpql, "");
		
		Query query = entityManager.createQuery(jpql);
		query.setParameter("tipo",tipo);
		query.setParameter("numero",numero);		
		
		List<Transaccion> listTransaccion =  query.getResultList();

		for (Transaccion transaccion : listTransaccion) {
			log.info(transaccion.toString());
		}

	}
	
	/* Consultar el número de las cuentas y el nombre del propietario de las cuentas registradas por 
	 * identificación de cliente que registro la cuenta*/
	@Test
	public void testSelectClienteRegistrado() {
		log.info("Ejecuto testSelectFunciones");
		String jpql = "SELECT new co.edu.usbcali.banco.dto.ClienteCuentaRegistrada(cue.cuenta.cuenId,cue.cliente.nombre,cue.cliente.clieId)"
				+ " FROM CuentaRegistrada cue";
		
		assertNotEquals("El jpql esta vacio", jpql, "");

		List<ClienteCuentaRegistrada> listRegistrado =entityManager.createQuery(jpql).getResultList();
		
		for (ClienteCuentaRegistrada clienteCuentaRegistrada : listRegistrado) {
			log.info(clienteCuentaRegistrada.toString());
		}

	
	}
}
