# Bank Simulation #

#### Arquitectura

![arquitectura](asset/arquitectura.PNG)

#### Database

![database](asset/database.PNG)

#### Requisitos ###

##### Modulo de administracion
- Numero de cuenta automatico (4560-3456-9999-8921)
- Clave cuenta automatica
- Crear cliente automaticamente se le crea una cuenta
- Consignacion 200.000 activa la cuenta
- Ingreso usuario y password

###### Cajero
- consignaciones Listo
- retiros

###### Asesor comercial
- crea clientes Listo
- modifica clientes Listo
- consulta Listo
- inhabilita Listo
- crea cuentas Listo

###### Administrador
- gestion todas tablas
- no retiros
- no consignaciones

##### Modulo clientes
- ingreso identificacion,cuenta y clave cuenta (cuenta activada)
-  informacion sobre retiros, consignaciones, traslados y saldos de las cuentas
- al realizar traslados solo puede ser entre sus cuenta
- se cobra 900 por traslado cuenta 9999-9999-9999-9999
- cliente puede cambiar su clave
- cliente solo podra modificar la dirección, email y teléfono
- el cliente podra registrar cuentas de otro cliente
- cuenta registrada debe el tipo de documento, número de identificación y número de cuenta a registrar
- registrar sus propias cuentas para realizar traslados

##### Modulo de cajero
- realizar retiros envia  el número de cuenta, clave, valor a retirar.
- El servicio debe retornar si se puede entregar el dinero al cliente y el nuevo saldo de la cuenta

#### Demo

##### Modulo Seguridad

###### Login Usuario

![login](asset/login.PNG)

###### Login Cliente

![login](asset/loginCliente.PNG)

##### Modulo Administrativo

###### Crear Un Usuario

![administradorCrearUser](asset/administradorCrearUser.PNG)

###### Buscar Usuarios

![administradorSearchUser](asset/administradorSearchUser.PNG)

###### Consultar Movimientos

![administradorSearchTransaciones](asset/administradorSearchTransaciones.PNG)

###### Administrar Tipo De Documento

![administracionTipoDoc](asset/administracionTipoDoc.PNG)

###### Administrar Tipo De Usuario

![administradorTipoUser](asset/administradorTipoUser.PNG)

###### Administrar Tipo De Transación

![administracionTipoTrasacion](asset/administracionTipoTrasacion.PNG)

##### Modulo Asesor

###### Crear Un Cliente

![asesorCreateCliente](asset/asesorCreateCliente.PNG)

###### Consultar Un Cliente

![asesorSearchCliente](asset/asesorSearchCliente.PNG)

###### Crear Una Cuenta

![asesorCreateAccount](asset/asesorCreateAccount.PNG)


##### Modulo Cajero

###### Consignacion

![cajeroConsignacion](asset/cajeroConsignacion.PNG)

###### Retiros

![cajeroRetiro](asset/cajeroRetiro.PNG)

##### Modulo Cliente

###### Mi Perfil

![clienteProfile](asset/clienteProfile.PNG)

###### Mis Cuentas

![clienteAccount](asset/clienteAccount.PNG)

###### Mis Transaciones

![clienteAccount](asset/clienteTrasaciones.PNG)

###### Mis Cuentas Registrada

![clienteRegisterAccount](asset/clienteRegisterAccount.PNG)

###### Trasferencias

![clienteTrasferencia](asset/clienteTrasferencia.PNG)
