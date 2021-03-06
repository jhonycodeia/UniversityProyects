package com.green.utility;

import java.text.SimpleDateFormat;

public class Constantes {
	
	//Bucket
	public static final String BUCKET_NAME = "green-data-multimedia";
	
	// Son los tipos de estados posibles para cada objeto del sistema son del atributo activo
	public static final String ESTADO_ACTIVO = "S";
	public static final String ESTADO_INACTIVO = "N";
	public static final String ESTADO_PENDIENTE= "P";
	public static final String ESTADO_ASIGNADO= "A";
	public static final String ESTADO_MASTER= "M";
	
	//Los genero de los usuario
	public static String GENERO_MASCULINO = "M";
	public static String GENERO_FEMENINO = "F";
	
	//Los roles que hay en el sistema
	public static final long USER_TYPE_JUGADOR = 1L;
	public static final long USER_TYPE_LIDER = 2L;
	public static final long USER_TYPE_ADMIN = 3L;
		
	//Los tipo de capsula
	public static final long CAPSULA_TYPE_ESTANDAR = 1L;
	public static final long CAPSULA_TYPE_TOOL = 2L;
	public static final long CAPSULA_TYPE_GUIA = 3L;
	public static final long CAPSULA_TYPE_DIVULGACION = 4L;
	
	//Los tipo de notificacion
	public static final long NOTIFICACION_TYPE_SOCIAL = 1L;
	public static final long NOTIFICACION_TYPE_PERSONAL = 2L;
	public static final long NOTIFICACION_TYPE_VALIDACION = 3L;
	public static final long NOTIFICACION_TYPE_RECOMPENSA = 4L;
	
	//Los tipo de documento
	public static final long DOCUMENTO_TYPE_IMAGEN = 1L;
	public static final long DOCUMENTO_TYPE_AUDIO = 2L;
	public static final long DOCUMENTO_TYPE_VIDEO = 3L;
	public static final long DOCUMENTO_TYPE_FILES = 4L;
	
	//Los tipo de puntos
	public static final long PUNTOS_TYPE_TOTAL = 1L;
	public static final long PUNTOS_TYPE_GANADO = 2L;
	public static final long PUNTOS_TYPE_CANJEADOS = 3L;
	public static final long PUNTOS_TYPE_PUBLICAR = 4L;
	public static final long PUNTOS_TYPE_COMENTAR = 5L;
	public static final long PUNTOS_TYPE_TRASFERIR = 6L;
	public static final long PUNTOS_TYPE_VER_CONTENIDO = 7L;
	
	//Los areas
	public static final long AREA_FUNCIONAL = 1L;
	public static final long AREA_NO_FUNCIONAL = 2L;
	public static final long AREA_AUTOMATIZACION = 3L;
	public static final long AREA_TECNOLOGIA = 4L;
	
	//Los Formatos utilizados en el sistema
	 public static final SimpleDateFormat FORMATO_FECHA_SIMPLE = new SimpleDateFormat("dd/MM/yyyy");
	 
	 
	//Trofeos
	 public static final long LLAVE_BRONCE = 1L;
	 public static final long LLAVE_PLATA = 2L;
	 public static final long LLAVE_ORO = 3L;
	 public static final long LLAVE_GREEN = 4L;
	 
	 
	//Parametros	 
	 public static final long PARAMETRO_WEB_RUTA_LLAVES = 1L;
	 public static final long PARAMETRO_WEB_RUTA_RECOMPENSA= 2L;
	 public static final long PARAMETRO_WEB_REDENCION = 3L;
	 public static final long PARAMETRO_REPORTES = 4L;
}
