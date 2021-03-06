package com.saberpro.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Constantes {

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
	public static final long USER_TYPE_ESTUDIANTE = 1L;
	public static final long USER_TYPE_DOCENTE = 2L;
	public static final long USER_TYPE_DIRECTOR = 3L;
	public static final long USER_TYPE_DECANO = 4L;
	public static final long USER_TYPE_ADMIN = 5L;
	
	//Los tipo de modulo que hay en el sistema
	public static final long MODULO_TYPE_GENERICO = 1L;
	public static final long MODULO_TYPE_ESPECIFICO = 2L;
	
	//Los tipo de pregunta que hay en el sistema
	public static final long PREGUNTA_TYPE_ABIERTA = 1L;
	public static final long PREGUNTA_TYPE_MULTIPLE = 2L;
	
	//Los tipo de prueba que hay en el sistema
	public static final long PRUEBA_TYPE_SIMULACRO = 1L;
	public static final long PRUEBA_TYPE_ENTRENAMIENTO = 2L;
	
	//Los estados posibles para una pruebaProgramaUsuario en el sistema
	public static final long PRUEBA_ESTADO_INICIADO = 1L;
	public static final long PRUEBA_ESTADO_PAUSADA = 2L;
	public static final long PRUEBA_ESTADO_FINALIZADA = 3L;
	public static final long PRUEBA_ESTADO_REINICIADA = 4L;
	public static final long PRUEBA_ESTADO_PENDIENTE = 5L;
	
	//Los Formatos utilizados en el sistema
	 public static final String FORMATO_FECHA_SIMPLE = "dd/MM/yyyy";
	 public static final String FORMATO_EXCEL_XLS = ".xls";
	 public static final String FORMATO_EXCEL_XLSX = ".xlsx";
	 
	//Parametros
	 public static final long TIME_PRUEBA = 3600L;
	 public static final long PARAMETRO_WEB_RUTA = 1L;
	 public static final long PARAMETRO_WEB_PREGUNTA = 2L;
	 public static final long PARAMETRO_WEB_RESPUESTA = 3L;
	 public static final long PARAMETRO_REPORTES = 4L;
}
