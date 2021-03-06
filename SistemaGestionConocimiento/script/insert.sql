
--CATEGORIA *
INSERT INTO CATEGORIA(nombre,fecha_creacion,usu_creador,activo) VALUES('ANALISIS','01/03/2019',0,'S');
INSERT INTO CATEGORIA(nombre,fecha_creacion,usu_creador,activo) VALUES('DISEÑO','01/03/2019',0,'S');
INSERT INTO CATEGORIA(nombre,fecha_creacion,usu_creador,activo) VALUES('PLANEACIÓN','01/03/2019',0,'S');
INSERT INTO CATEGORIA(nombre,fecha_creacion,usu_creador,activo) VALUES('EJECUCIÓN','01/03/2019',0,'S');
INSERT INTO CATEGORIA(nombre,fecha_creacion,usu_creador,activo) VALUES('SEGUIMIENTO','01/03/2019',0,'S');
INSERT INTO CATEGORIA(nombre,fecha_creacion,usu_creador,activo) VALUES('CIERRE','01/03/2019',0,'S');
INSERT INTO CATEGORIA(nombre,fecha_creacion,usu_creador,activo) VALUES('PRUEBAS FUNCIONALES','01/03/2019',0,'S');
INSERT INTO CATEGORIA(nombre,fecha_creacion,usu_creador,activo) VALUES('PRUEBAS NO FUNCIONALES','01/03/2019',0,'S');
INSERT INTO CATEGORIA(nombre,fecha_creacion,usu_creador,activo) VALUES('AUTOMATIZACIÓN','01/03/2019',0,'S');
INSERT INTO CATEGORIA(nombre,fecha_creacion,usu_creador,activo) VALUES('HERRAMIENTAS','01/03/2019',0,'S');
INSERT INTO CATEGORIA(nombre,fecha_creacion,usu_creador,activo) VALUES('OTROS','01/03/2019',0,'S');

--PROCESO *
INSERT INTO PROCESO(nombre,fecha_creacion,usu_creador,activo) VALUES('INTEGRACIÓN CONTINUA','01/03/2019',0,'S');
INSERT INTO PROCESO(nombre,fecha_creacion,usu_creador,activo) VALUES('ENTREGA CONTINUA','01/03/2019',0,'S');
INSERT INTO PROCESO(nombre,fecha_creacion,usu_creador,activo) VALUES('DESPLIEGUE CONTINUO','01/03/2019',0,'S');
INSERT INTO PROCESO(nombre,fecha_creacion,usu_creador,activo) VALUES('ESTANDAR','01/03/2019',0,'S');

--SUBPROCESO *
INSERT INTO SUBPROCESO(nombre,fecha_creacion,usu_creador,activo,id_proceso) VALUES('CONTROL DE VERSIONES','01/03/2019',0,'S',1);
INSERT INTO SUBPROCESO(nombre,fecha_creacion,usu_creador,activo,id_proceso) VALUES('CONSTRUCCIÓN','01/03/2019',0,'S',1);
INSERT INTO SUBPROCESO(nombre,fecha_creacion,usu_creador,activo,id_proceso) VALUES('PRUEBA DE UNIDAD','01/03/2019',0,'S',2);
INSERT INTO SUBPROCESO(nombre,fecha_creacion,usu_creador,activo,id_proceso) VALUES('PRUEBA DE INTEGRACIÓN','01/03/2019',0,'S',2);
INSERT INTO SUBPROCESO(nombre,fecha_creacion,usu_creador,activo,id_proceso) VALUES('ENTREGA PARA PUESTO EN ESCENA','01/03/2019',0,'S',2);
INSERT INTO SUBPROCESO(nombre,fecha_creacion,usu_creador,activo,id_proceso) VALUES('APLICACIÓN DE PRUEBAS DE ACEPTACIÓN','01/03/2019',0,'S',2);
INSERT INTO SUBPROCESO(nombre,fecha_creacion,usu_creador,activo,id_proceso) VALUES('DESPLIEGUE A PRODUCCIÓN','01/03/2019',0,'S',2);
INSERT INTO SUBPROCESO(nombre,fecha_creacion,usu_creador,activo,id_proceso) VALUES('PRUEBAS POST-DESPLIEGUE','01/03/2019',0,'S',2);
INSERT INTO SUBPROCESO(nombre,fecha_creacion,usu_creador,activo,id_proceso) VALUES('PRUEBA DE UNIDAD','01/03/2019',0,'S',3);
INSERT INTO SUBPROCESO(nombre,fecha_creacion,usu_creador,activo,id_proceso) VALUES('PRUEBA DE INTEGRACIÓN','01/03/2019',0,'S',3);
INSERT INTO SUBPROCESO(nombre,fecha_creacion,usu_creador,activo,id_proceso) VALUES('ENTREGA PARA PUESTO EN ESCENA','01/03/2019',0,'S',3);
INSERT INTO SUBPROCESO(nombre,fecha_creacion,usu_creador,activo,id_proceso) VALUES('APLICACIÓN DE PRUEBAS DE ACEPTACIÓN','01/03/2019',0,'S',3);
INSERT INTO SUBPROCESO(nombre,fecha_creacion,usu_creador,activo,id_proceso) VALUES('DESPLIEGUE A PRODUCCIÓN','01/03/2019',0,'S',3);
INSERT INTO SUBPROCESO(nombre,fecha_creacion,usu_creador,activo,id_proceso) VALUES('PRUEBAS POST-DESPLIEGUE','01/03/2019',0,'S',3);
INSERT INTO SUBPROCESO(nombre,fecha_creacion,usu_creador,activo,id_proceso) VALUES('INICIO','01/03/2019',0,'S',4);
INSERT INTO SUBPROCESO(nombre,fecha_creacion,usu_creador,activo,id_proceso) VALUES('PLANEACIÓN','01/03/2019',0,'S',4);
INSERT INTO SUBPROCESO(nombre,fecha_creacion,usu_creador,activo,id_proceso) VALUES('DISEÑO','01/03/2019',0,'S',4);
INSERT INTO SUBPROCESO(nombre,fecha_creacion,usu_creador,activo,id_proceso) VALUES('EJECUCIÓN','01/03/2019',0,'S',4);
INSERT INTO SUBPROCESO(nombre,fecha_creacion,usu_creador,activo,id_proceso) VALUES('CIERRE','01/03/2019',0,'S',4);

--TIPO CAPSULA *
INSERT INTO TIPO_CAPSULA(nombre,fecha_creacion,usu_creador,activo) VALUES('IDEA DE CONOCIMIENTO','01/03/2019',0,'S');
INSERT INTO TIPO_CAPSULA(nombre,fecha_creacion,usu_creador,activo) VALUES('PROTOTIPO DE CONOCIMIENTO','01/03/2019',0,'S');
INSERT INTO TIPO_CAPSULA(nombre,fecha_creacion,usu_creador,activo) VALUES('GUIA DE CONOCIMIENTO','01/03/2019',0,'S');
INSERT INTO TIPO_CAPSULA(nombre,fecha_creacion,usu_creador,activo) VALUES('DIVULGACION DE CONOCIMIENTO','01/03/2019',0,'S');

--TIPO USUARIO *
INSERT INTO TIPO_USUARIO(nombre,fecha_creacion,usu_creador,activo) VALUES('JUGADOR','01/03/2019',0,'S');
INSERT INTO TIPO_USUARIO(nombre,fecha_creacion,usu_creador,activo) VALUES('LIDER AREA','01/03/2019',0,'S');
INSERT INTO TIPO_USUARIO(nombre,fecha_creacion,usu_creador,activo) VALUES('ADMIN','01/03/2019',0,'S');

--AREA *
INSERT INTO AREA(nombre,fecha_creacion,usu_creador,activo) VALUES('FUNCIONALES','01/03/2019',0,'S');
INSERT INTO AREA(nombre,fecha_creacion,usu_creador,activo) VALUES('NO FUNCIONALES','01/03/2019',0,'S');
INSERT INTO AREA(nombre,fecha_creacion,usu_creador,activo) VALUES('AUTOMATIZACIÓN','01/03/2019',0,'S');
INSERT INTO AREA(nombre,fecha_creacion,usu_creador,activo) VALUES('TECNOLOGIA Y INOVACCION','01/03/2019',0,'S');

--TIPO NOTIFICACION *
INSERT INTO TIPO_NOTIFICACION(nombre,fecha_creacion,usu_creador,activo) VALUES('SOCIAL','01/03/2019',0,'S');
INSERT INTO TIPO_NOTIFICACION(nombre,fecha_creacion,usu_creador,activo) VALUES('PERSONAL','01/03/2019',0,'S');
INSERT INTO TIPO_NOTIFICACION(nombre,fecha_creacion,usu_creador,activo) VALUES('VALIDACION','01/03/2019',0,'S');
INSERT INTO TIPO_NOTIFICACION(nombre,fecha_creacion,usu_creador,activo) VALUES('RECOMPENSA','01/03/2019',0,'S');


-- Trofeo
INSERT INTO TROFEO(nombre,requisito,valor,fecha_creacion,usu_creador,activo) VALUES('LLAVE BRONCE',0,'keys/llave_bronce.png','01/03/2019',0,'S');
INSERT INTO TROFEO(nombre,requisito,valor,fecha_creacion,usu_creador,activo) VALUES('LLAVE PLATA',100,'keys/llave_plata.png','01/03/2019',0,'S');
INSERT INTO TROFEO(nombre,requisito,valor,fecha_creacion,usu_creador,activo) VALUES('LLAVE ORO',700,'keys/llave_oro.png','01/03/2019',0,'S');
INSERT INTO TROFEO(nombre,requisito,valor,fecha_creacion,usu_creador,activo) VALUES('LLAVE GREEN',1000,'keys/llave_green.png','01/03/2019',0,'S');

--TIPO DOCUMENTO *
INSERT INTO TIPO_DOCUMENTO(nombre,fecha_creacion,usu_creador,activo) VALUES('IMAGEN','01/03/2019',0,'S');
INSERT INTO TIPO_DOCUMENTO(nombre,fecha_creacion,usu_creador,activo) VALUES('AUDIO','01/03/2019',0,'S');
INSERT INTO TIPO_DOCUMENTO(nombre,fecha_creacion,usu_creador,activo) VALUES('VIDEO','01/03/2019',0,'S');
INSERT INTO TIPO_DOCUMENTO(nombre,fecha_creacion,usu_creador,activo) VALUES('FILES','01/03/2019',0,'S');

--TIPO PUNTOS *
INSERT INTO TIPO_PUNTOS(nombre,fecha_creacion,usu_creador,activo) VALUES('PUNTOS TOTALES','01/03/2019',0,'S');
INSERT INTO TIPO_PUNTOS(nombre,fecha_creacion,usu_creador,activo) VALUES('PUNTOS GANADOS','01/03/2019',0,'S');
INSERT INTO TIPO_PUNTOS(nombre,fecha_creacion,usu_creador,activo) VALUES('PUNTOS CANJEADOS','01/03/2019',0,'S');
INSERT INTO TIPO_PUNTOS(nombre,fecha_creacion,usu_creador,activo) VALUES('PUNTOS POR PUBLICAR','01/03/2019',0,'S');
INSERT INTO TIPO_PUNTOS(nombre,fecha_creacion,usu_creador,activo) VALUES('PUNTOS POR COMENTAR','01/03/2019',0,'S');
INSERT INTO TIPO_PUNTOS(nombre,fecha_creacion,usu_creador,activo) VALUES('PUNTOS POR TRASFERIR','01/03/2019',0,'S');


--RECOMPENSAS
INSERT INTO RECOMPENSA(nombre,requisito,descripcion,valor,fecha_creacion,usu_creador,activo) VALUES('DIA DE DESCANSO',250,'SE REDIMEN POR UNA JORNADA LABORAL DE UN DIA','redencion/dia_descanso.png','01/03/2019',0,'S');
INSERT INTO RECOMPENSA(nombre,requisito,descripcion,valor,fecha_creacion,usu_creador,activo) VALUES('BONO DE UNICENTRO POR VALOR $150.000',100,'SE REDIMEN POR UNA BONO DE CINE','redencion/bono_unicentro.png','01/03/2019',0,'S');
INSERT INTO RECOMPENSA(nombre,requisito,descripcion,valor,fecha_creacion,usu_creador,activo) VALUES('BONO RESTAURANTE CREPES POR $80.000',50,'SE REDIMEN POR UNA BONO DE ALIMENTOS','redencion/bono_crepes.png','01/03/2019',0,'S');
INSERT INTO RECOMPENSA(nombre,requisito,descripcion,valor,fecha_creacion,usu_creador,activo) VALUES('SEGURO DE VIDA POR 1 AÑO DE VALOR DE: $20.000.000',200,'SE REDIMEN POR UNA SEGURO','redencion/seguro_De_vida.png','01/03/2019',0,'S');
INSERT INTO RECOMPENSA(nombre,requisito,descripcion,valor,fecha_creacion,usu_creador,activo) VALUES('BONO DESAYUNO RESTAURANTE MARRIOTT POR $80.000',55,'SE REDIMEN POR UN BONO DE ALIMENTO','redencion/bono_marrot.png','01/03/2019',0,'S');
INSERT INTO RECOMPENSA(nombre,requisito,descripcion,valor,fecha_creacion,usu_creador,activo) VALUES('PAGO CURSO DE INGLES POR UN NIVEL',50,'SE REDIMEN POR UNA CURSO','redencion/curso_ingles.png','01/03/2019',0,'S');
INSERT INTO RECOMPENSA(nombre,requisito,descripcion,valor,fecha_creacion,usu_creador,activo) VALUES('MEMBRESIA POR TRIMESTRE EN GYM BODYTECH (EXECEPCION CATEGORIA PLATINO)',60,'SE REDIMEN POR UNA MEMBRESIA','redencion/membresia_bodytech.png','01/03/2019',0,'S');
INSERT INTO RECOMPENSA(nombre,requisito,descripcion,valor,fecha_creacion,usu_creador,activo) VALUES('BONO LA 14 POR $140.000',100,'SE REDIMEN POR UN BONO MONETARIO','redencion/bono_la14.png','01/03/2019',0,'S');
INSERT INTO RECOMPENSA(nombre,requisito,descripcion,valor,fecha_creacion,usu_creador,activo) VALUES('BONO DEL ÉXITO POR $120.000',95,'SE REDIMEN POR UN BONO MONETARIO','redencion/bono_exito.png','01/03/2019',0,'S');
INSERT INTO RECOMPENSA(nombre,requisito,descripcion,valor,fecha_creacion,usu_creador,activo) VALUES('SPA HOTEL',25,'SE REDIMEN POR UN DIA EN SPA CON masaje de relajacion masaje con piedras volcanicas chocolaterapia corporal exfoliacion de manos y pies hidratacion facial copa con vino uso de turco sauna y piscina duracion de la terapia 1 hora ','redencion/bono_spa.png','01/03/2019',0,'S');
INSERT INTO RECOMPENSA(nombre,requisito,descripcion,valor,fecha_creacion,usu_creador,activo) VALUES('2 BOLETAS DE PELICULA CINECOLOMBIA EN FORMATO 2D Y 2 COMBOS DE CONFITERIA',8,'SE REDIMEN POR UN BONO DE CINE CON (Crispeta de 46 onz + Gaseosa de 16 onz)','redencion/bono_cine.png','01/03/2019',0,'S');
INSERT INTO RECOMPENSA(nombre,requisito,descripcion,valor,fecha_creacion,usu_creador,activo) VALUES('2 BOLETAS DE PELICULA CINEMARK, ROYAL FILMS EN FORMATO 2D y 2 COMBOS DE CONFITERIA',6,'SE REDIMEN POR UN BONO DE CINE CON (Crispeta de 46 onz + Gaseosa de 16 onz)','redencion/bono_cine.png','01/03/2019',0,'S');


--Usuario
INSERT INTO USUARIO(id_usuario,nombre,apellido,correo,clave,puntos,fecha_creacion,usu_creador,activo,id_tipo_usuario,id_area) VALUES(0,'ADMIN','ADMIN','admin@gmail.com','4399cd87ad7b8f485867c16551721d0b5662ff80d327b039355342a3538bcad3ec9f01b76b49e44a',5,'01/03/2019',0,'S',3,1);
INSERT INTO USUARIO(nombre,apellido,correo,clave,puntos,fecha_creacion,usu_creador,activo,id_tipo_usuario,id_area) VALUES('MAURICIO','ARISTISABAL','mauricio@gmail.com','4399cd87ad7b8f485867c16551721d0b5662ff80d327b039355342a3538bcad3ec9f01b76b49e44a',5,'01/03/2019',0,'S',2,4);
INSERT INTO USUARIO(nombre,apellido,correo,clave,puntos,fecha_creacion,usu_creador,activo,id_tipo_usuario,id_area) VALUES('MARGARET','GOMEZ','margaret@gmail.com','4399cd87ad7b8f485867c16551721d0b5662ff80d327b039355342a3538bcad3ec9f01b76b49e44a',5,'01/03/2019',0,'S',2,3);
INSERT INTO USUARIO(nombre,apellido,correo,clave,puntos,fecha_creacion,usu_creador,activo,id_tipo_usuario,id_area) VALUES('CESAR','TAPASCO','cesar@gmail.com','4399cd87ad7b8f485867c16551721d0b5662ff80d327b039355342a3538bcad3ec9f01b76b49e44a',5,'01/03/2019',0,'S',2,2);
INSERT INTO USUARIO(nombre,apellido,correo,clave,puntos,fecha_creacion,usu_creador,activo,id_tipo_usuario,id_area) VALUES('PATRICIA','HOYOS','patricia@gmail.com','4399cd87ad7b8f485867c16551721d0b5662ff80d327b039355342a3538bcad3ec9f01b76b49e44a',5,'01/03/2019',0,'S',2,1);
INSERT INTO USUARIO(nombre,apellido,correo,clave,puntos,fecha_creacion,usu_creador,activo,id_tipo_usuario,id_area) VALUES('JHONY','SARRIA','jhonypk18@gmail.com','4399cd87ad7b8f485867c16551721d0b5662ff80d327b039355342a3538bcad3ec9f01b76b49e44a',5,'01/03/2019',0,'S',1,1);

--TrofeoUsuario

INSERT INTO USUARIO_TROFEO(fecha_creacion,usu_creador,activo,id_trofeo,id_usuario) VALUES('01/03/2019',0,'S',1,0);
INSERT INTO USUARIO_TROFEO(fecha_creacion,usu_creador,activo,id_trofeo,id_usuario) VALUES('01/03/2019',0,'S',1,1);
INSERT INTO USUARIO_TROFEO(fecha_creacion,usu_creador,activo,id_trofeo,id_usuario) VALUES('01/03/2019',0,'S',1,2);
INSERT INTO USUARIO_TROFEO(fecha_creacion,usu_creador,activo,id_trofeo,id_usuario) VALUES('01/03/2019',0,'S',1,3);
INSERT INTO USUARIO_TROFEO(fecha_creacion,usu_creador,activo,id_trofeo,id_usuario) VALUES('01/03/2019',0,'S',1,4);
INSERT INTO USUARIO_TROFEO(fecha_creacion,usu_creador,activo,id_trofeo,id_usuario) VALUES('01/03/2019',0,'S',1,5);

--Puntos
INSERT INTO PUNTOS(puntos,fecha_creacion,usu_creador,activo,id_usuario,id_tipo_puntos) VALUES(5,'01/03/2019',0,'S',1,1);
INSERT INTO PUNTOS(puntos,fecha_creacion,usu_creador,activo,id_usuario,id_tipo_puntos) VALUES(5,'01/03/2019',0,'S',1,2);
INSERT INTO PUNTOS(puntos,fecha_creacion,usu_creador,activo,id_usuario,id_tipo_puntos) VALUES(0,'01/03/2019',0,'S',1,3);
INSERT INTO PUNTOS(puntos,fecha_creacion,usu_creador,activo,id_usuario,id_tipo_puntos) VALUES(0,'01/03/2019',0,'S',1,4);
INSERT INTO PUNTOS(puntos,fecha_creacion,usu_creador,activo,id_usuario,id_tipo_puntos) VALUES(0,'01/03/2019',0,'S',1,5);
INSERT INTO PUNTOS(puntos,fecha_creacion,usu_creador,activo,id_usuario,id_tipo_puntos) VALUES(0,'01/03/2019',0,'S',1,6);
INSERT INTO PUNTOS(puntos,fecha_creacion,usu_creador,activo,id_usuario,id_tipo_puntos) VALUES(5,'01/03/2019',0,'S',2,1);
INSERT INTO PUNTOS(puntos,fecha_creacion,usu_creador,activo,id_usuario,id_tipo_puntos) VALUES(5,'01/03/2019',0,'S',2,2);
INSERT INTO PUNTOS(puntos,fecha_creacion,usu_creador,activo,id_usuario,id_tipo_puntos) VALUES(0,'01/03/2019',0,'S',2,3);
INSERT INTO PUNTOS(puntos,fecha_creacion,usu_creador,activo,id_usuario,id_tipo_puntos) VALUES(0,'01/03/2019',0,'S',2,4);
INSERT INTO PUNTOS(puntos,fecha_creacion,usu_creador,activo,id_usuario,id_tipo_puntos) VALUES(0,'01/03/2019',0,'S',2,5);
INSERT INTO PUNTOS(puntos,fecha_creacion,usu_creador,activo,id_usuario,id_tipo_puntos) VALUES(0,'01/03/2019',0,'S',2,6);
INSERT INTO PUNTOS(puntos,fecha_creacion,usu_creador,activo,id_usuario,id_tipo_puntos) VALUES(5,'01/03/2019',0,'S',3,1);
INSERT INTO PUNTOS(puntos,fecha_creacion,usu_creador,activo,id_usuario,id_tipo_puntos) VALUES(5,'01/03/2019',0,'S',3,2);
INSERT INTO PUNTOS(puntos,fecha_creacion,usu_creador,activo,id_usuario,id_tipo_puntos) VALUES(0,'01/03/2019',0,'S',3,3);
INSERT INTO PUNTOS(puntos,fecha_creacion,usu_creador,activo,id_usuario,id_tipo_puntos) VALUES(0,'01/03/2019',0,'S',3,4);
INSERT INTO PUNTOS(puntos,fecha_creacion,usu_creador,activo,id_usuario,id_tipo_puntos) VALUES(0,'01/03/2019',0,'S',3,5);
INSERT INTO PUNTOS(puntos,fecha_creacion,usu_creador,activo,id_usuario,id_tipo_puntos) VALUES(0,'01/03/2019',0,'S',3,6);
INSERT INTO PUNTOS(puntos,fecha_creacion,usu_creador,activo,id_usuario,id_tipo_puntos) VALUES(5,'01/03/2019',0,'S',4,1);
INSERT INTO PUNTOS(puntos,fecha_creacion,usu_creador,activo,id_usuario,id_tipo_puntos) VALUES(5,'01/03/2019',0,'S',4,2);
INSERT INTO PUNTOS(puntos,fecha_creacion,usu_creador,activo,id_usuario,id_tipo_puntos) VALUES(0,'01/03/2019',0,'S',4,3);
INSERT INTO PUNTOS(puntos,fecha_creacion,usu_creador,activo,id_usuario,id_tipo_puntos) VALUES(0,'01/03/2019',0,'S',4,4);
INSERT INTO PUNTOS(puntos,fecha_creacion,usu_creador,activo,id_usuario,id_tipo_puntos) VALUES(0,'01/03/2019',0,'S',4,5);
INSERT INTO PUNTOS(puntos,fecha_creacion,usu_creador,activo,id_usuario,id_tipo_puntos) VALUES(0,'01/03/2019',0,'S',4,6);
INSERT INTO PUNTOS(puntos,fecha_creacion,usu_creador,activo,id_usuario,id_tipo_puntos) VALUES(5,'01/03/2019',0,'S',5,1);
INSERT INTO PUNTOS(puntos,fecha_creacion,usu_creador,activo,id_usuario,id_tipo_puntos) VALUES(5,'01/03/2019',0,'S',5,2);
INSERT INTO PUNTOS(puntos,fecha_creacion,usu_creador,activo,id_usuario,id_tipo_puntos) VALUES(0,'01/03/2019',0,'S',5,3);
INSERT INTO PUNTOS(puntos,fecha_creacion,usu_creador,activo,id_usuario,id_tipo_puntos) VALUES(0,'01/03/2019',0,'S',5,4);
INSERT INTO PUNTOS(puntos,fecha_creacion,usu_creador,activo,id_usuario,id_tipo_puntos) VALUES(0,'01/03/2019',0,'S',5,5);
INSERT INTO PUNTOS(puntos,fecha_creacion,usu_creador,activo,id_usuario,id_tipo_puntos) VALUES(0,'01/03/2019',0,'S',5,6);

