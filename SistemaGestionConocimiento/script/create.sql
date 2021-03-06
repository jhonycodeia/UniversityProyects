CREATE TABLE AREA (
  id_area            BIGSERIAL NOT NULL, 
  nombre             varchar(300) NOT NULL, 
  descripcion        varchar(1000), 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             varchar(1) NOT NULL, 
  PRIMARY KEY (id_area));
CREATE TABLE CALIFICACION (
  id_calificacion    BIGSERIAL NOT NULL, 
  valor              int8, 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             varchar(1) NOT NULL, 
  id_capsula         int8 NOT NULL, 
  id_usuario         int8 NOT NULL, 
  PRIMARY KEY (id_calificacion));
CREATE TABLE CAPSULA (
  id_capsula         BIGSERIAL NOT NULL, 
  titulo             varchar(300) NOT NULL, 
  descripcion        varchar(1000), 
  valor              varchar(10485760) NOT NULL, 
  disparador         varchar(10485760), 
  situacion          varchar(10485760), 
  resolucion         varchar(10485760), 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             varchar(1) NOT NULL, 
  parent             int8, 
  id_subproceso      int8, 
  id_usuario         int8, 
  id_categoria       int8, 
  id_proceso         int8, 
  id_tipo_capsula    int8, 
  PRIMARY KEY (id_capsula));
CREATE TABLE CAPSULA_PALABRAS_CLAVE (
  id_capsula_palabra_clave BIGSERIAL NOT NULL, 
  nombre                   varchar(300) NOT NULL, 
  descripcion              varchar(1000), 
  fecha_creacion           timestamp NOT NULL, 
  fecha_modificacion       timestamp, 
  usu_creador              int8 NOT NULL, 
  usu_modificador          int8, 
  activo                   varchar(1) NOT NULL, 
  id_capsula               int8 NOT NULL, 
  id_palabra_clave         int8 NOT NULL, 
  PRIMARY KEY (id_capsula_palabra_clave));
CREATE TABLE CATEGORIA (
  id_categoria       BIGSERIAL NOT NULL, 
  nombre             varchar(300) NOT NULL, 
  descripcion        varchar(1000), 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             varchar(1) NOT NULL, 
  PRIMARY KEY (id_categoria));
CREATE TABLE COMENTARIO (
  id_comentario      BIGSERIAL NOT NULL, 
  valor              varchar(10485760) NOT NULL, 
  calificacion       int8 NOT NULL, 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             varchar(1) NOT NULL, 
  id_capsula         int8 NOT NULL, 
  id_usuario         int8 NOT NULL, 
  PRIMARY KEY (id_comentario));
CREATE TABLE DOCUMENTO (
  id_documento       BIGSERIAL NOT NULL, 
  nombre             varchar(300) NOT NULL, 
  descripcion        varchar(1000), 
  ruta               varchar(10485760) NOT NULL, 
  valor              varchar(10485760), 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             varchar(1) NOT NULL, 
  id_tipo_documento  int8 NOT NULL, 
  id_capsula         int8 NOT NULL, 
  PRIMARY KEY (id_documento));
CREATE TABLE NOTIFICACION (
  id_notificacion      BIGSERIAL NOT NULL, 
  nombre               varchar(300) NOT NULL, 
  descripcion          varchar(1000), 
  valor                varchar(10485760) NOT NULL, 
  fecha_creacion       timestamp NOT NULL, 
  fecha_modificacion   timestamp, 
  usu_creador          int8 NOT NULL, 
  usu_modificador      int8, 
  activo               varchar(1) NOT NULL, 
  id_capsula           int8 NOT NULL, 
  id_tipo_notificacion int8 NOT NULL, 
  id_usuario           int8 NOT NULL, 
  PRIMARY KEY (id_notificacion));
CREATE TABLE PALABRAS_CLAVE (
  id_palabra_clave   BIGSERIAL NOT NULL, 
  nombre             varchar(300) NOT NULL, 
  descripcion        varchar(1000), 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             varchar(1) NOT NULL, 
  PRIMARY KEY (id_palabra_clave));
CREATE TABLE PARAMETRO (
  id_parametro       BIGSERIAL NOT NULL, 
  nombre             varchar(300) NOT NULL, 
  descripcion        varchar(1000), 
  valor              varchar(10485760) NOT NULL, 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             varchar(1) NOT NULL, 
  PRIMARY KEY (id_parametro));
CREATE TABLE PROCESO (
  id_proceso         BIGSERIAL NOT NULL, 
  nombre             varchar(300) NOT NULL, 
  descripcion        varchar(1000), 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             varchar(1) NOT NULL, 
  PRIMARY KEY (id_proceso));
CREATE TABLE PUNTOS (
  id_puntos          BIGSERIAL NOT NULL, 
  puntos             int8 NOT NULL, 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             varchar(1) NOT NULL, 
  id_usuario         int8 NOT NULL, 
  id_tipo_puntos     int8 NOT NULL, 
  PRIMARY KEY (id_puntos));
CREATE TABLE RECOMPENSA (
  id_recompensa      BIGSERIAL NOT NULL, 
  nombre             varchar(300) NOT NULL, 
  requisito          int8 NOT NULL, 
  descripcion        varchar(1000), 
  valor              varchar(10485760) NOT NULL, 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             varchar(1) NOT NULL, 
  PRIMARY KEY (id_recompensa));
CREATE TABLE RECOMPENSA_USUARIO (
  id_recompensa_usuario BIGSERIAL NOT NULL, 
  fecha_creacion        timestamp NOT NULL, 
  fecha_modificacion    timestamp, 
  usu_creador           int8 NOT NULL, 
  usu_modificador       int8, 
  activo                varchar(1) NOT NULL, 
  id_recompensa         int8 NOT NULL, 
  id_usuario            int8 NOT NULL, 
  PRIMARY KEY (id_recompensa_usuario));
CREATE TABLE SUBPROCESO (
  id_subproceso      BIGSERIAL NOT NULL, 
  nombre             varchar(300) NOT NULL, 
  descripcion        varchar(1000), 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             varchar(1) NOT NULL, 
  id_proceso         int8 NOT NULL, 
  PRIMARY KEY (id_subproceso));
CREATE TABLE TIPO_CAPSULA (
  id_tipo_capsula    BIGSERIAL NOT NULL, 
  nombre             varchar(300) NOT NULL, 
  descripcion        varchar(1000), 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             varchar(1) NOT NULL, 
  PRIMARY KEY (id_tipo_capsula));
CREATE TABLE TIPO_DOCUMENTO (
  id_tipo_documento  BIGSERIAL NOT NULL, 
  nombre             varchar(300) NOT NULL, 
  descripcion        varchar(1000), 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             varchar(1) NOT NULL, 
  PRIMARY KEY (id_tipo_documento));
CREATE TABLE TIPO_NOTIFICACION (
  id_tipo_notificacion BIGSERIAL NOT NULL, 
  nombre               varchar(300) NOT NULL, 
  descripcion          varchar(1000), 
  fecha_creacion       timestamp NOT NULL, 
  fecha_modificacion   timestamp, 
  usu_creador          int8 NOT NULL, 
  usu_modificador      int8, 
  activo               varchar(1) NOT NULL, 
  PRIMARY KEY (id_tipo_notificacion));
CREATE TABLE TIPO_PUNTOS (
  id_tipo_puntos     BIGSERIAL NOT NULL, 
  nombre             varchar(300) NOT NULL, 
  descripcion        varchar(1000), 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             varchar(1) NOT NULL, 
  PRIMARY KEY (id_tipo_puntos));
CREATE TABLE TIPO_USUARIO (
  id_tipo_usuario    BIGSERIAL NOT NULL, 
  nombre             varchar(300) NOT NULL, 
  descripcion        varchar(1000), 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             varchar(1) NOT NULL, 
  PRIMARY KEY (id_tipo_usuario));
CREATE TABLE TROFEO (
  id_trofeo          BIGSERIAL NOT NULL, 
  nombre             varchar(300) NOT NULL, 
  requisito          int8 NOT NULL, 
  descripcion        varchar(1000), 
  valor              varchar(10485760) NOT NULL, 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             varchar(1) NOT NULL, 
  PRIMARY KEY (id_trofeo));
CREATE TABLE USUARIO (
  id_usuario         BIGSERIAL NOT NULL, 
  nombre             varchar(100) NOT NULL, 
  apellido           varchar(100) NOT NULL, 
  genero             varchar(10), 
  correo             varchar(300) NOT NULL, 
  clave              varchar(10485760) NOT NULL, 
  fecha_nacimiento   timestamp, 
  puntos             int8, 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             varchar(1) NOT NULL, 
  id_tipo_usuario    int8 NOT NULL, 
  id_area            int8 NOT NULL, 
  PRIMARY KEY (id_usuario));
CREATE TABLE USUARIO_TROFEO (
  id_usuario_trofeo  BIGSERIAL NOT NULL, 
  fecha_creacion     timestamp NOT NULL, 
  fecha_modificacion timestamp, 
  usu_creador        int8 NOT NULL, 
  usu_modificador    int8, 
  activo             varchar(1) NOT NULL, 
  id_trofeo          int8 NOT NULL, 
  id_usuario         int8 NOT NULL, 
  PRIMARY KEY (id_usuario_trofeo));
CREATE INDEX AREA_id_area 
  ON AREA (id_area);
CREATE INDEX CALIFICACION_id_calificacion 
  ON CALIFICACION (id_calificacion);
CREATE INDEX CALIFICACION_id_capsula 
  ON CALIFICACION (id_capsula);
CREATE INDEX CALIFICACION_id_usuario 
  ON CALIFICACION (id_usuario);
CREATE INDEX CAPSULA_id_capsula 
  ON CAPSULA (id_capsula);
CREATE INDEX CAPSULA_id_subproceso 
  ON CAPSULA (id_subproceso);
CREATE INDEX CAPSULA_id_usuario 
  ON CAPSULA (id_usuario);
CREATE INDEX CAPSULA_id_categoria 
  ON CAPSULA (id_categoria);
CREATE INDEX CAPSULA_id_proceso 
  ON CAPSULA (id_proceso);
CREATE INDEX CAPSULA_id_tipo_capsula 
  ON CAPSULA (id_tipo_capsula);
CREATE INDEX CAPSULA_PALABRAS_CLAVE_id_capsula_palabra_clave 
  ON CAPSULA_PALABRAS_CLAVE (id_capsula_palabra_clave);
CREATE INDEX CAPSULA_PALABRAS_CLAVE_id_capsula 
  ON CAPSULA_PALABRAS_CLAVE (id_capsula);
CREATE INDEX CAPSULA_PALABRAS_CLAVE_id_palabra_clave 
  ON CAPSULA_PALABRAS_CLAVE (id_palabra_clave);
CREATE INDEX CATEGORIA_id_categoria 
  ON CATEGORIA (id_categoria);
CREATE INDEX COMENTARIO_id_comentario 
  ON COMENTARIO (id_comentario);
CREATE INDEX COMENTARIO_id_capsula 
  ON COMENTARIO (id_capsula);
CREATE INDEX COMENTARIO_id_usuario 
  ON COMENTARIO (id_usuario);
CREATE INDEX DOCUMENTO_id_documento 
  ON DOCUMENTO (id_documento);
CREATE INDEX DOCUMENTO_id_tipo_documento 
  ON DOCUMENTO (id_tipo_documento);
CREATE INDEX DOCUMENTO_id_capsula 
  ON DOCUMENTO (id_capsula);
CREATE INDEX NOTIFICACION_id_notificacion 
  ON NOTIFICACION (id_notificacion);
CREATE INDEX NOTIFICACION_id_capsula 
  ON NOTIFICACION (id_capsula);
CREATE INDEX NOTIFICACION_id_tipo_notificacion 
  ON NOTIFICACION (id_tipo_notificacion);
CREATE INDEX NOTIFICACION_id_usuario 
  ON NOTIFICACION (id_usuario);
CREATE INDEX PALABRAS_CLAVE_id_palabra_clave 
  ON PALABRAS_CLAVE (id_palabra_clave);
CREATE INDEX PARAMETRO_id_parametro 
  ON PARAMETRO (id_parametro);
CREATE INDEX PROCESO_id_proceso 
  ON PROCESO (id_proceso);
CREATE INDEX PUNTOS_id_puntos 
  ON PUNTOS (id_puntos);
CREATE INDEX RECOMPENSA_id_recompensa 
  ON RECOMPENSA (id_recompensa);
CREATE INDEX RECOMPENSA_USUARIO_id_recompensa_usuario 
  ON RECOMPENSA_USUARIO (id_recompensa_usuario);
CREATE INDEX RECOMPENSA_USUARIO_id_recompensa 
  ON RECOMPENSA_USUARIO (id_recompensa);
CREATE INDEX RECOMPENSA_USUARIO_id_usuario 
  ON RECOMPENSA_USUARIO (id_usuario);
CREATE INDEX SUBPROCESO_id_subproceso 
  ON SUBPROCESO (id_subproceso);
CREATE INDEX SUBPROCESO_id_proceso 
  ON SUBPROCESO (id_proceso);
CREATE INDEX TIPO_CAPSULA_id_tipo_capsula 
  ON TIPO_CAPSULA (id_tipo_capsula);
CREATE INDEX TIPO_DOCUMENTO_id_tipo_documento 
  ON TIPO_DOCUMENTO (id_tipo_documento);
CREATE INDEX TIPO_NOTIFICACION_id_tipo_notificacion 
  ON TIPO_NOTIFICACION (id_tipo_notificacion);
CREATE INDEX TIPO_PUNTOS_id_tipo_puntos 
  ON TIPO_PUNTOS (id_tipo_puntos);
CREATE INDEX TIPO_USUARIO_id_tipo_usuario 
  ON TIPO_USUARIO (id_tipo_usuario);
CREATE INDEX TROFEO_id_trofeo 
  ON TROFEO (id_trofeo);
CREATE INDEX USUARIO_id_usuario 
  ON USUARIO (id_usuario);
CREATE INDEX USUARIO_id_tipo_usuario 
  ON USUARIO (id_tipo_usuario);
CREATE INDEX USUARIO_id_area 
  ON USUARIO (id_area);
CREATE INDEX USUARIO_TROFEO_id_usuario_trofeo 
  ON USUARIO_TROFEO (id_usuario_trofeo);
CREATE INDEX USUARIO_TROFEO_id_trofeo 
  ON USUARIO_TROFEO (id_trofeo);
CREATE INDEX USUARIO_TROFEO_id_usuario 
  ON USUARIO_TROFEO (id_usuario);
ALTER TABLE USUARIO ADD CONSTRAINT FKUSUARIO296150 FOREIGN KEY (id_area) REFERENCES AREA (id_area);
ALTER TABLE NOTIFICACION ADD CONSTRAINT FKNOTIFICACI168324 FOREIGN KEY (id_usuario) REFERENCES USUARIO (id_usuario);
ALTER TABLE NOTIFICACION ADD CONSTRAINT FKNOTIFICACI601801 FOREIGN KEY (id_capsula) REFERENCES CAPSULA (id_capsula);
ALTER TABLE NOTIFICACION ADD CONSTRAINT FKNOTIFICACI777724 FOREIGN KEY (id_tipo_notificacion) REFERENCES TIPO_NOTIFICACION (id_tipo_notificacion);
ALTER TABLE CALIFICACION ADD CONSTRAINT FKCALIFICACI118755 FOREIGN KEY (id_usuario) REFERENCES USUARIO (id_usuario);
ALTER TABLE CALIFICACION ADD CONSTRAINT FKCALIFICACI82710 FOREIGN KEY (id_capsula) REFERENCES CAPSULA (id_capsula);
ALTER TABLE PUNTOS ADD CONSTRAINT FKPUNTOS540008 FOREIGN KEY (id_tipo_puntos) REFERENCES TIPO_PUNTOS (id_tipo_puntos);
ALTER TABLE DOCUMENTO ADD CONSTRAINT FKDOCUMENTO471071 FOREIGN KEY (id_capsula) REFERENCES CAPSULA (id_capsula);
ALTER TABLE CAPSULA_PALABRAS_CLAVE ADD CONSTRAINT FKCAPSULA_PA95146 FOREIGN KEY (id_palabra_clave) REFERENCES PALABRAS_CLAVE (id_palabra_clave);
ALTER TABLE CAPSULA_PALABRAS_CLAVE ADD CONSTRAINT FKCAPSULA_PA440539 FOREIGN KEY (id_capsula) REFERENCES CAPSULA (id_capsula);
ALTER TABLE COMENTARIO ADD CONSTRAINT FKCOMENTARIO805603 FOREIGN KEY (id_capsula) REFERENCES CAPSULA (id_capsula);
ALTER TABLE PUNTOS ADD CONSTRAINT FKPUNTOS601733 FOREIGN KEY (id_usuario) REFERENCES USUARIO (id_usuario);
ALTER TABLE CAPSULA ADD CONSTRAINT FKCAPSULA474526 FOREIGN KEY (id_subproceso) REFERENCES SUBPROCESO (id_subproceso);
ALTER TABLE SUBPROCESO ADD CONSTRAINT FKSUBPROCESO592955 FOREIGN KEY (id_proceso) REFERENCES PROCESO (id_proceso);
ALTER TABLE CAPSULA ADD CONSTRAINT FKCAPSULA550174 FOREIGN KEY (id_categoria) REFERENCES CATEGORIA (id_categoria);
ALTER TABLE COMENTARIO ADD CONSTRAINT FKCOMENTARIO964521 FOREIGN KEY (id_usuario) REFERENCES USUARIO (id_usuario);
ALTER TABLE USUARIO ADD CONSTRAINT FKUSUARIO20346 FOREIGN KEY (id_tipo_usuario) REFERENCES TIPO_USUARIO (id_tipo_usuario);
ALTER TABLE CAPSULA ADD CONSTRAINT FKCAPSULA581607 FOREIGN KEY (id_tipo_capsula) REFERENCES TIPO_CAPSULA (id_tipo_capsula);
ALTER TABLE CAPSULA ADD CONSTRAINT FKCAPSULA325907 FOREIGN KEY (id_proceso) REFERENCES PROCESO (id_proceso);
ALTER TABLE CAPSULA ADD CONSTRAINT FKCAPSULA303416 FOREIGN KEY (id_usuario) REFERENCES USUARIO (id_usuario);
ALTER TABLE RECOMPENSA_USUARIO ADD CONSTRAINT FKRECOMPENSA83114 FOREIGN KEY (id_usuario) REFERENCES USUARIO (id_usuario);
ALTER TABLE RECOMPENSA_USUARIO ADD CONSTRAINT FKRECOMPENSA611807 FOREIGN KEY (id_recompensa) REFERENCES RECOMPENSA (id_recompensa);
ALTER TABLE USUARIO_TROFEO ADD CONSTRAINT FKUSUARIO_TR93961 FOREIGN KEY (id_trofeo) REFERENCES TROFEO (id_trofeo);
ALTER TABLE USUARIO_TROFEO ADD CONSTRAINT FKUSUARIO_TR749158 FOREIGN KEY (id_usuario) REFERENCES USUARIO (id_usuario);
ALTER TABLE DOCUMENTO ADD CONSTRAINT FKDOCUMENTO185029 FOREIGN KEY (id_tipo_documento) REFERENCES TIPO_DOCUMENTO (id_tipo_documento);
