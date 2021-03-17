CREATE TABLE Estado_Prueba (
  id_estado_prueba   BIGSERIAL NOT NULL, 
  nombre             varchar(300) NOT NULL UNIQUE, 
  descripcion        varchar(1200000), 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             char(1) NOT NULL, 
  PRIMARY KEY (id_estado_prueba));
CREATE TABLE Facultad (
  id_facultad        BIGSERIAL NOT NULL, 
  nombre             varchar(300) NOT NULL UNIQUE, 
  descripcion        varchar(1200000), 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             char(1) NOT NULL, 
  PRIMARY KEY (id_facultad));
CREATE TABLE Grupo_Opcion (
  id_grupo_opcion    BIGSERIAL NOT NULL, 
  nombre             varchar(300) NOT NULL, 
  descripcion        varchar(1200000), 
  icon               varchar(100), 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             char(1) NOT NULL, 
  PRIMARY KEY (id_grupo_opcion));
CREATE TABLE Imagen (
  id_imagen          BIGSERIAL NOT NULL, 
  nombre             varchar(300) NOT NULL, 
  descripcion        varchar(1200000), 
  ruta               varchar(3000000), 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             char(1) NOT NULL, 
  id_pregunta        int8 NOT NULL, 
  PRIMARY KEY (id_imagen));
CREATE TABLE Matricula (
  id_matricula       BIGSERIAL NOT NULL, 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             char(1) NOT NULL, 
  id_usuario         int8 NOT NULL, 
  id_prueba_real     int8 NOT NULL, 
  PRIMARY KEY (id_matricula));
CREATE TABLE Modulo (
  id_modulo          BIGSERIAL NOT NULL, 
  nombre             varchar(300) NOT NULL UNIQUE, 
  descripcion        varchar(1200000), 
  prioridad          int8 NOT NULL, 
  cantidad_preguntas int8 NOT NULL, 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             char(1) NOT NULL, 
  id_tipo_modulo     int8 NOT NULL, 
  PRIMARY KEY (id_modulo));
CREATE TABLE Opcion (
  id_opcion          BIGSERIAL NOT NULL, 
  nombre             varchar(300) NOT NULL UNIQUE, 
  descripcion        varchar(1200000), 
  ruta               varchar(3000000), 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             char(1) NOT NULL, 
  id_grupo_opcion    int8 NOT NULL, 
  PRIMARY KEY (id_opcion));
CREATE TABLE Parametro (
  id_parametro       BIGSERIAL NOT NULL, 
  nombre             varchar(300) NOT NULL, 
  descripcion        varchar(1200000), 
  valor              varchar(3000000) NOT NULL, 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             char(1) NOT NULL, 
  PRIMARY KEY (id_parametro));
CREATE TABLE Permiso (
  id_permiso         BIGSERIAL NOT NULL, 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             char(1) NOT NULL, 
  id_tipo_usuario    int8 NOT NULL, 
  id_grupo_opcion    int8 NOT NULL, 
  PRIMARY KEY (id_permiso));
CREATE TABLE Pregunta (
  id_pregunta          BIGSERIAL NOT NULL, 
  descripcion_pregunta varchar(3000000) NOT NULL, 
  retroalimentacion    varchar(3000000), 
  fecha_creacion       timestamp NOT NULL, 
  fecha_modificacion   timestamp, 
  usu_creador          int8 NOT NULL, 
  usu_modificador      int8, 
  activo               char(1) NOT NULL, 
  id_modulo            int8 NOT NULL, 
  id_tipo_pregunta     int8 NOT NULL, 
  PRIMARY KEY (id_pregunta));
CREATE TABLE Programa (
  id_programa        BIGSERIAL NOT NULL, 
  nombre             varchar(300) NOT NULL UNIQUE, 
  descripcion        varchar(1200000), 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             char(1) NOT NULL, 
  id_facultad        int8 NOT NULL, 
  PRIMARY KEY (id_programa));
CREATE TABLE Programa_Modulo (
  id_programa_modulo BIGSERIAL NOT NULL, 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             char(1) NOT NULL, 
  id_programa        int8 NOT NULL, 
  id_modulo          int8 NOT NULL, 
  PRIMARY KEY (id_programa_modulo));
CREATE TABLE Programa_Usuario (
  id_programa_usuario BIGSERIAL NOT NULL, 
  fecha_creacion      timestamp NOT NULL, 
  fecha_modificacion  timestamp, 
  usu_creador         int8 NOT NULL, 
  usu_modificador     int8, 
  activo              char(1) NOT NULL, 
  id_programa         int8 NOT NULL, 
  id_usuario          int8 NOT NULL, 
  PRIMARY KEY (id_programa_usuario));
CREATE TABLE Prueba (
  id_prueba          BIGSERIAL NOT NULL, 
  fecha_inicial      date, 
  fecha_final        date, 
  tiempo             int8, 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             char(1) NOT NULL, 
  id_tipo_prueba     int8 NOT NULL, 
  PRIMARY KEY (id_prueba));
CREATE TABLE Prueba_Modulo (
  id_prueba_modulo   BIGSERIAL NOT NULL, 
  numero_preguntas   int8 NOT NULL, 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             char(1) NOT NULL, 
  id_prueba          int8 NOT NULL, 
  id_modulo          int8 NOT NULL, 
  PRIMARY KEY (id_prueba_modulo));
CREATE TABLE Prueba_Programa_Usuario (
  id_prueba_programa_usuario BIGSERIAL NOT NULL, 
  fecha_creacion             timestamp NOT NULL, 
  fecha_modificacion         timestamp, 
  usu_creador                int8 NOT NULL, 
  usu_modificador            int8, 
  activo                     char(1) NOT NULL, 
  id_prueba                  int8 NOT NULL, 
  id_programa_usuario        int8, 
  id_estado_prueba           int8 NOT NULL, 
  PRIMARY KEY (id_prueba_programa_usuario));
CREATE TABLE Prueba_Programa_Usuario_Pregunta (
  id_prueba_programa_usuario_pregunta BIGSERIAL NOT NULL, 
  fecha_creacion                      timestamp NOT NULL, 
  fecha_modificacion                  timestamp, 
  usu_creador                         int8 NOT NULL, 
  usu_modificador                     int8, 
  activo                              char(1) NOT NULL, 
  id_prueba_programa_usuario          int8, 
  id_pregunta                         int8 NOT NULL, 
  PRIMARY KEY (id_prueba_programa_usuario_pregunta));
CREATE TABLE Prueba_Real (
  id_prueba_real     BIGSERIAL NOT NULL, 
  fecha              timestamp NOT NULL, 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             char(1) NOT NULL, 
  PRIMARY KEY (id_prueba_real));
CREATE TABLE Respuesta (
  id_respuesta          BIGSERIAL NOT NULL, 
  descripcion_respuesta varchar(3000000), 
  ruta_imagen           varchar(3000000), 
  porcentaje_acierto    int4 NOT NULL, 
  fecha_creacion        timestamp NOT NULL, 
  fecha_modificacion    timestamp, 
  usu_creador           int8 NOT NULL, 
  usu_modificador       int8, 
  activo                char(1) NOT NULL, 
  id_pregunta           int8 NOT NULL, 
  PRIMARY KEY (id_respuesta));
CREATE TABLE Respuesta_Prueba_Programa_Usuario_Pregunta (
  id_Respuesta_Prueba_Programa_Usuario_Pregunta BIGSERIAL NOT NULL, 
  porcentaje_asignado                           int8 NOT NULL, 
  fecha_creacion                                timestamp NOT NULL, 
  fecha_modificacion                            timestamp, 
  usu_creador                                   int8 NOT NULL, 
  usu_modificador                               int8, 
  activo                                        char(1) NOT NULL, 
  id_respuesta                                  int8, 
  id_prueba_programa_usuario_pregunta           int8 NOT NULL, 
  PRIMARY KEY (id_Respuesta_Prueba_Programa_Usuario_Pregunta));
CREATE TABLE Resultado_Real (
  id_resultado_real  BIGSERIAL NOT NULL, 
  percentil_grupo    int8, 
  percentil_nacional int8, 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             char(1) NOT NULL, 
  id_matricula       int8, 
  id_modulo          int8 NOT NULL, 
  PRIMARY KEY (id_resultado_real));
CREATE TABLE Tipo_Modulo (
  id_tipo_modulo     BIGSERIAL NOT NULL, 
  nombre             varchar(300) NOT NULL UNIQUE, 
  descripcion        varchar(1200000), 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             char(1) NOT NULL, 
  PRIMARY KEY (id_tipo_modulo));
CREATE TABLE Tipo_pregunta (
  id_tipo_pregunta   BIGSERIAL NOT NULL, 
  nombre             varchar(300) NOT NULL UNIQUE, 
  descripcion        varchar(1200000), 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             char(1) NOT NULL, 
  PRIMARY KEY (id_tipo_pregunta));
CREATE TABLE Tipo_Prueba (
  id_tipo_prueba     BIGSERIAL NOT NULL, 
  nombre             varchar(300) NOT NULL UNIQUE, 
  descripcion        varchar(1200000), 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             char(1) NOT NULL, 
  PRIMARY KEY (id_tipo_prueba));
CREATE TABLE Tipo_Usuario (
  id_tipo_usuario    BIGSERIAL NOT NULL, 
  nombre             varchar(300) NOT NULL UNIQUE, 
  descripcion        varchar(1200000), 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             char(1) NOT NULL, 
  PRIMARY KEY (id_tipo_usuario));
CREATE TABLE Usuario (
  id_usuario         BIGSERIAL NOT NULL, 
  nombre             varchar(300) NOT NULL, 
  apellido           varchar(300) NOT NULL, 
  genero             char(1) NOT NULL, 
  codigo             int8 NOT NULL UNIQUE, 
  identificacion     int8 NOT NULL UNIQUE, 
  celular            int8 NOT NULL UNIQUE, 
  correo             varchar(1200) NOT NULL UNIQUE, 
  password           varchar(1200) NOT NULL, 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             char(1) NOT NULL, 
  id_tipo_usuario    int8 NOT NULL, 
  PRIMARY KEY (id_usuario));
CREATE INDEX Facultad_id_facultad 
  ON Facultad (id_facultad);
CREATE INDEX Imagen_id_pregunta 
  ON Imagen (id_pregunta);
CREATE INDEX Matricula_id_usuario 
  ON Matricula (id_usuario);
CREATE INDEX Matricula_id_prueba_real 
  ON Matricula (id_prueba_real);
CREATE INDEX Modulo_id_tipo_modulo 
  ON Modulo (id_tipo_modulo);
CREATE INDEX Opcion_id_grupo_opcion 
  ON Opcion (id_grupo_opcion);
CREATE INDEX Permiso_id_tipo_usuario 
  ON Permiso (id_tipo_usuario);
CREATE INDEX Permiso_id_grupo_opcion 
  ON Permiso (id_grupo_opcion);
CREATE INDEX Pregunta_id_modulo 
  ON Pregunta (id_modulo);
CREATE INDEX Pregunta_id_tipo_pregunta 
  ON Pregunta (id_tipo_pregunta);
CREATE INDEX Programa_id_facultad 
  ON Programa (id_facultad);
CREATE INDEX Programa_Modulo_id_programa 
  ON Programa_Modulo (id_programa);
CREATE INDEX Programa_Modulo_id_modulo 
  ON Programa_Modulo (id_modulo);
CREATE INDEX Programa_Usuario_id_programa 
  ON Programa_Usuario (id_programa);
CREATE INDEX Programa_Usuario_id_usuario 
  ON Programa_Usuario (id_usuario);
CREATE INDEX Prueba_id_tipo_prueba 
  ON Prueba (id_tipo_prueba);
CREATE INDEX Prueba_Modulo_id_prueba 
  ON Prueba_Modulo (id_prueba);
CREATE INDEX Prueba_Modulo_id_modulo 
  ON Prueba_Modulo (id_modulo);
CREATE INDEX Prueba_Programa_Usuario_id_prueba 
  ON Prueba_Programa_Usuario (id_prueba);
CREATE INDEX Prueba_Programa_Usuario_id_programa_usuario 
  ON Prueba_Programa_Usuario (id_programa_usuario);
CREATE INDEX Prueba_Programa_Usuario_id_estado_prueba 
  ON Prueba_Programa_Usuario (id_estado_prueba);
CREATE INDEX Prueba_Programa_Usuario_Pregunta_id_prueba_programa_usuario 
  ON Prueba_Programa_Usuario_Pregunta (id_prueba_programa_usuario);
CREATE INDEX Prueba_Programa_Usuario_Pregunta_id_pregunta 
  ON Prueba_Programa_Usuario_Pregunta (id_pregunta);
CREATE INDEX Respuesta_id_pregunta 
  ON Respuesta (id_pregunta);
CREATE INDEX Respuesta_Prueba_Programa_Usuario_Pregunta_id_respuesta 
  ON Respuesta_Prueba_Programa_Usuario_Pregunta (id_respuesta);
CREATE INDEX Respuesta_Prueba_Programa_Usuario_Pregunta_id_prueba_programa_usuario_pregunta 
  ON Respuesta_Prueba_Programa_Usuario_Pregunta (id_prueba_programa_usuario_pregunta);
CREATE INDEX Resultado_Real_id_matricula 
  ON Resultado_Real (id_matricula);
CREATE INDEX Resultado_Real_id_modulo 
  ON Resultado_Real (id_modulo);
CREATE INDEX Usuario_id_tipo_usuario 
  ON Usuario (id_tipo_usuario);
ALTER TABLE Imagen ADD CONSTRAINT FKImagen211656 FOREIGN KEY (id_pregunta) REFERENCES Pregunta (id_pregunta);
ALTER TABLE Prueba_Programa_Usuario ADD CONSTRAINT FKPrueba_Pro963603 FOREIGN KEY (id_estado_prueba) REFERENCES Estado_Prueba (id_estado_prueba);
ALTER TABLE Respuesta_Prueba_Programa_Usuario_Pregunta ADD CONSTRAINT FKRespuesta_860917 FOREIGN KEY (id_prueba_programa_usuario_pregunta) REFERENCES Prueba_Programa_Usuario_Pregunta (id_prueba_programa_usuario_pregunta);
ALTER TABLE Respuesta_Prueba_Programa_Usuario_Pregunta ADD CONSTRAINT FKRespuesta_550839 FOREIGN KEY (id_respuesta) REFERENCES Respuesta (id_respuesta);
ALTER TABLE Prueba_Programa_Usuario_Pregunta ADD CONSTRAINT FKPrueba_Pro708530 FOREIGN KEY (id_pregunta) REFERENCES Pregunta (id_pregunta);
ALTER TABLE Prueba_Programa_Usuario_Pregunta ADD CONSTRAINT FKPrueba_Pro965592 FOREIGN KEY (id_prueba_programa_usuario) REFERENCES Prueba_Programa_Usuario (id_prueba_programa_usuario);
ALTER TABLE Prueba_Programa_Usuario ADD CONSTRAINT FKPrueba_Pro448518 FOREIGN KEY (id_programa_usuario) REFERENCES Programa_Usuario (id_programa_usuario);
ALTER TABLE Prueba_Programa_Usuario ADD CONSTRAINT FKPrueba_Pro62717 FOREIGN KEY (id_prueba) REFERENCES Prueba (id_prueba);
ALTER TABLE Prueba ADD CONSTRAINT FKPrueba881316 FOREIGN KEY (id_tipo_prueba) REFERENCES Tipo_Prueba (id_tipo_prueba);
ALTER TABLE Prueba_Modulo ADD CONSTRAINT FKPrueba_Mod371291 FOREIGN KEY (id_modulo) REFERENCES Modulo (id_modulo);
ALTER TABLE Prueba_Modulo ADD CONSTRAINT FKPrueba_Mod924734 FOREIGN KEY (id_prueba) REFERENCES Prueba (id_prueba);
ALTER TABLE Respuesta ADD CONSTRAINT FKRespuesta329003 FOREIGN KEY (id_pregunta) REFERENCES Pregunta (id_pregunta);
ALTER TABLE Pregunta ADD CONSTRAINT FKPregunta566309 FOREIGN KEY (id_tipo_pregunta) REFERENCES Tipo_pregunta (id_tipo_pregunta);
ALTER TABLE Pregunta ADD CONSTRAINT FKPregunta770318 FOREIGN KEY (id_modulo) REFERENCES Modulo (id_modulo);
ALTER TABLE Resultado_Real ADD CONSTRAINT FKResultado_660041 FOREIGN KEY (id_modulo) REFERENCES Modulo (id_modulo);
ALTER TABLE Resultado_Real ADD CONSTRAINT FKResultado_42940 FOREIGN KEY (id_matricula) REFERENCES Matricula (id_matricula);
ALTER TABLE Matricula ADD CONSTRAINT FKMatricula219651 FOREIGN KEY (id_prueba_real) REFERENCES Prueba_Real (id_prueba_real);
ALTER TABLE Matricula ADD CONSTRAINT FKMatricula639937 FOREIGN KEY (id_usuario) REFERENCES Usuario (id_usuario);
ALTER TABLE Opcion ADD CONSTRAINT FKOpcion285869 FOREIGN KEY (id_grupo_opcion) REFERENCES Grupo_Opcion (id_grupo_opcion);
ALTER TABLE Permiso ADD CONSTRAINT FKPermiso521186 FOREIGN KEY (id_grupo_opcion) REFERENCES Grupo_Opcion (id_grupo_opcion);
ALTER TABLE Permiso ADD CONSTRAINT FKPermiso793993 FOREIGN KEY (id_tipo_usuario) REFERENCES Tipo_Usuario (id_tipo_usuario);
ALTER TABLE Modulo ADD CONSTRAINT FKModulo476725 FOREIGN KEY (id_tipo_modulo) REFERENCES Tipo_Modulo (id_tipo_modulo);
ALTER TABLE Usuario ADD CONSTRAINT FKUsuario12815 FOREIGN KEY (id_tipo_usuario) REFERENCES Tipo_Usuario (id_tipo_usuario);
ALTER TABLE Programa_Modulo ADD CONSTRAINT FKPrograma_M109512 FOREIGN KEY (id_modulo) REFERENCES Modulo (id_modulo);
ALTER TABLE Programa_Modulo ADD CONSTRAINT FKPrograma_M775127 FOREIGN KEY (id_programa) REFERENCES Programa (id_programa);
ALTER TABLE Programa_Usuario ADD CONSTRAINT FKPrograma_U742836 FOREIGN KEY (id_usuario) REFERENCES Usuario (id_usuario);
ALTER TABLE Programa_Usuario ADD CONSTRAINT FKPrograma_U800424 FOREIGN KEY (id_programa) REFERENCES Programa (id_programa);
ALTER TABLE Programa ADD CONSTRAINT FKPrograma210184 FOREIGN KEY (id_facultad) REFERENCES Facultad (id_facultad);

create or replace function sinacentos (text) returns text AS $$
select translate($1,'áéíóúÁÉÍÓÚäëïöüÄËÏÖÜ','aeiouAEIOUaeiouAEIOU');
$$ language sql;



