package co.edu.usbcali.arquitectura.dataaccess.dao;

import co.edu.usbcali.arquitectura.dataaccess.api.Dao;
import co.edu.usbcali.arquitectura.dataaccess.api.DaoException;
import co.edu.usbcali.arquitectura.modelo.Saludo;
import co.edu.usbcali.arquitectura.modelo.dto.SaludoNombreDTO;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Interface for   SaludoDAO.
*
*/
public interface ISaludoDAO extends Dao<Saludo, Integer> {
	public SaludoNombreDTO SaludoNombre(String nombre) throws DaoException ;
}
