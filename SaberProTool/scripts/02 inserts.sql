/* Limpiar tablas */
DELETE FROM resultado_real;
DELETE FROM opcion;
DELETE FROM permiso;
DELETE FROM grupo_opcion;
DELETE FROM matricula;
DELETE FROM prueba_real;
DELETE FROM respuesta_prueba_programa_usuario_pregunta;
DELETE FROM prueba_programa_usuario_pregunta;
DELETE FROM prueba_programa_usuario;
DELETE FROM programa_modulo;
DELETE FROM programa_usuario;
DELETE FROM programa;
DELETE FROM facultad;
DELETE FROM prueba_modulo;
DELETE FROM prueba;
DELETE FROM tipo_prueba;
DELETE FROM estado_prueba;
DELETE FROM respuesta;
DELETE FROM pregunta;
DELETE FROM usuario;
DELETE FROM tipo_usuario;
DELETE FROM modulo;
DELETE FROM tipo_modulo;
DELETE FROM tipo_pregunta;
DELETE FROM parametro;


/*Facultad*/

ALTER SEQUENCE facultad_id_facultad_seq MINVALUE 1 START WITH 1 RESTART WITH 1;

insert into facultad(nombre,descripcion,fecha_creacion,usu_creador,activo) values('INGENÍERIA','Aplica los conocimientos científicos a la invención, diseño, perfeccionamiento y manejo de nuevos procedimientos en la industria y otros campos de aplicación científicos',now(),0,'S');
insert into facultad(nombre,descripcion,fecha_creacion,usu_creador,activo) values('EDUCACIÓN','Formación destinada a desarrollar la capacidad intelectual, moral y afectiva de las personas de acuerdo con la cultura y las normas de convivencia de la sociedad a la que pertenecen',now(),0,'S');
insert into facultad(nombre,descripcion,fecha_creacion,usu_creador,activo) values('PSICOLOGÍA','Ciencia que estudia los procesos mentales, las sensaciones, las percepciones y el comportamiento del ser humano, en relación con el medio ambiente físico y social que lo rodea',now(),0,'S');
insert into facultad(nombre,descripcion,fecha_creacion,usu_creador,activo) values('DERECHO y CÍENCIAS POLÍTICAS','Estudia la manera en que se ejerce el poder y los fenómenos derivados del mismo, como punto de partida es necesario definir el panorama de estudio de la ciencia politica así como el concepto de la misma, se entiende por ciencia politica',now(),0,'S');
insert into facultad(nombre,descripcion,fecha_creacion,usu_creador,activo) values('ECÓNOMICAS','Ciencia que estudia los recursos, la creación de riqueza y la producción, distribución y consumo de bienes y servicios, para satisfacer las necesidades humanas',now(),0,'S');
insert into facultad(nombre,descripcion,fecha_creacion,usu_creador,activo) values('ARQUITECTURA,ARTE y DÍSEÑO','La forma, transformación y el significado implícito en la obra, su ambigua apreciación no puede determinarse si un diseño es un proceso estético correspondiente al arte cuando lo accesorio o superfluo se antepone a la función o solución del problema',now(),0,'S');

/* Programa */

ALTER SEQUENCE programa_id_programa_seq MINVALUE 1 START WITH 1 RESTART WITH 1;

insert into programa(nombre,descripcion,fecha_creacion,usu_creador,activo,id_facultad) values('INGENIERÍA AGROINDUSTRIAL','Formamos profesionales éticos e integrales, con un alto sentido de responsabilidad y una activa creatividad para diseñar, administrar, mejorar, optimizar e innovar nuevos procesos de producción, transformación y mercadeo, integrando el factor humano y ambiental, que les permitan liderar negocios y crear o dirigir empresas agroindustriales, dando respuesta a un mundo cambiante y en pleno avance tecnológico',now(),0,'S',1);
insert into programa(nombre,descripcion,fecha_creacion,usu_creador,activo,id_facultad) values('INGENIERÍA ELECTRÓNICA','Formamos profesionales en la Ingeniería Electrónica con actitud crítica y recursiva frente al futuro ejercicio de su profesión y dentro de un marco de formación en valores y principios, que contribuyan con el aumento de la competitividad y optimización de los sectores industrial y comercial, a través de aplicaciones electrónicas en los campos de las telecomunicaciones, automatización, control industrial, seguridad electrónica y sistemas electrónicos de sonido que den respuesta a problemas tecnológicos de nuestro entorno enmarcados con las necesidades y proyecciones regionales, nacionales e internacionales',now(),0,'S',1);
insert into programa(nombre,descripcion,fecha_creacion,usu_creador,activo,id_facultad) values('INGENIERÍA INDUSTRIAL','Formamos profesionales capaces de generar proyectos que promuevan el desarrollo sostenible de las organizaciones por medio del mejoramiento de la competitividad, a través de la calidad y la innovación a lo largo de toda la cadena productiva y de servicios, desde su concepción, diseño, requerimientos de maquinaria, materias primas, recursos humanos, información y demás factores de producción, incluida la gestión de los procesos logísticos y de mercadeo',now(),0,'S',1);
insert into programa(nombre,descripcion,fecha_creacion,usu_creador,activo,id_facultad) values('INGENIERÍA MULTIMEDIA','Formamos profesionales con amplias competencias humanas, técnicas y conceptuales en la gestión de información a nivel organizacional, gubernamental y social por medio de la tecnología y los procesos multimediales como canal de integración, manteniéndose a la vanguardia del entorno global que rodea esta disciplina.

El programa de Ingeniería Multimedia forma personas y profesionales conscientes, responsables, con formación integral y disciplinar, con sólida cultura humanística, espiritual y científica que les permite seguir educándose por sí mismos; capaces de adaptar sus conocimientos a las continuas transformaciones de la ciencia y la tecnología.',now(),0,'S',1);
insert into programa(nombre,descripcion,fecha_creacion,usu_creador,activo,id_facultad) values('INGENIERÍA DE SISTEMAS','Formamos profesionales profesionales para analizar, diseñar y desarrollar sistemas informáticos mediante la construcción y aplicación de métodos, herramientas y procesos que conforman la ingeniería de software, fundamentados en la aplicación de las ciencias naturales, matemáticas, computación y tecnologías de información, que brindan soluciones a problemas de la administración y operación de las organizaciones, generando un impacto social y estratégico en ellas',now(),0,'S',1);
insert into programa(nombre,descripcion,fecha_creacion,usu_creador,activo,id_facultad) values('LICENCIATURA EN LITERATURA Y LENGUA CASTELLANA','Formar profesionales de la educación con una sólida fundamentación pedagógica y didáctica en Literatura y Lengua Castellana  que les permita desempeñarse en este campo, generando conocimiento pertinente e innovador; con competencias investigativas que lo lleven a indagar sobre la enseñanza y el aprendizaje de la lengua materna y, de la literatura para enfrentar los nuevos desafíos educativos, asumiendo  la educación como un proceso social, cultural y político que promueve el desarrollo humano',now(),0,'S',2);
insert into programa(nombre,descripcion,fecha_creacion,usu_creador,activo,id_facultad) values('LICENCIATURA EN EDUCACIÓN INFANTIL','Formar profesionales en educación infantil como agentes educativos de cambio social con el más alto desempeño humano y profesional, que reconozcan al niño desde la gestación hasta los ocho años como sujeto de derechos y entiendan que la educación es un proceso social, cultural y político ininterrumpido y relacional, cuya finalidad es la promoción del desarrollo humano',now(),0,'S',2);
insert into programa(nombre,descripcion,fecha_creacion,usu_creador,activo,id_facultad) values('PSICOLOGÍA','Formar psicólogos en competencias clínicas y sociales para la solución y abordaje de situaciones y fenómenos psicológicos, integrando métodos y herramientas investigativas acordes con los contextos socioculturales y en diálogo con las ciencias sociales y de la salud',now(),0,'S',3);
insert into programa(nombre,descripcion,fecha_creacion,usu_creador,activo,id_facultad) values('PSICOANALISIS','Formar psicólogos en competencias clínicas y sociales para la solución y abordaje de situaciones y fenómenos psicológicos, integrando métodos y herramientas investigativas acordes con los contextos socioculturales y en diálogo con las ciencias sociales y de la salud',now(),0,'S',3);
insert into programa(nombre,descripcion,fecha_creacion,usu_creador,activo,id_facultad) values('GOBIERNO Y RELACIONES INTERNACIONALES','Formar profesionales con alta calidad académica en el conocimiento de los diferentes paradigmas de la política y las relaciones internacionales, desde el contexto del Derecho, la Economía, la Administración y de las demás ciencias sociales, en diálogo con otros saberes, orientados por principios éticos, ecológicos y sociales para el ejercicio de la profesión con actitud humanística, dialógica, y orientada hacia el emprendimiento en lo local-global',now(),0,'S',4);
insert into programa(nombre,descripcion,fecha_creacion,usu_creador,activo,id_facultad) values('DERECHO','El programa de Derecho de la Universidad de San Buenaventura Cali, con más de 40 años de existencia, propende por la formación integral del estudiante, en procura del desarrollo armónico de todas sus dimensiones individuales, en beneficio de su crecimiento auténtico y autónomo para que sea capaz, dentro de la sociedad, de discernir y tomar decisiones responsables. La formación integral se traduce en el desarrollo de competencias profesionales, investigativas, individuales y sociales encaminadas a la búsqueda de la excelencia académica y humana',now(),0,'S',4);
insert into programa(nombre,descripcion,fecha_creacion,usu_creador,activo,id_facultad) values('ADMINISTRACIÓN DE NEGOCIOS','Formar al individuo en la adquisición de fortalezas y habilidades gerenciales, con énfasis en el mundo de los negocios, para que gestione la optimización de los recursos en las organizaciones. Así mismo, formar un profesional con espíritu emprendedor para la creación de empresas o la innovación y creatividad de proyectos en las organizaciones',now(),0,'S',5);
insert into programa(nombre,descripcion,fecha_creacion,usu_creador,activo,id_facultad) values('CONTADURÍA PÚBLICA','El objetivo del Programa de Contaduría Pública de la Universidad de San Buenaventura Cali es formar profesionales con visión global y liderazgo gerencial, que desde el desempeño ético en las organizaciones generen valor agregado, producto de la innovación, la productividad y la capacidad de gestión, para la dirección estratégica de las finanzas, el aseguramiento de la información, la contabilidad, los aspectos tributarios y el gobierno corporativo, con sentido de responsabilidad social y ambiental',now(),0,'S',5);
insert into programa(nombre,descripcion,fecha_creacion,usu_creador,activo,id_facultad) values('ECONOMÍA','Formar economistas con una sólida fundamentación en teoría y política económica y en los campos de formalización que permiten desarrollar el análisis y la investigación de dichos componentes. Este propósito considera la formación integral de profesionales de la ciencia económica con capacidad analítica y compromiso ético; con habilidad para identificar, comprender, analizar y resolver situaciones del ámbito socioeconómico orientadas a optimizar el desempeño de las organizaciones y contribuir al mejoramiento de la calidad de vida de las comunidades en los contextos local, regional, nacional e internacional',now(),0,'S',5);
insert into programa(nombre,descripcion,fecha_creacion,usu_creador,activo,id_facultad) values('DISEÑO DE VESTUARIO','Crear una nueva generación de líderes en el medio del diseño, con la capacidad de identificar y resolver problemáticas asociadas al vestuario y establecer soluciones innovadoras que se fundamenten en procesos investigativos. Así mismo, el programa busca apoyar la creatividad y el desarrollo empresarial en la región y el país al formar profesionales que hagan la diferencia en el mercado laboral local e internacional, por su alta capacidad para el diseño y la gestión',now(),0,'S',6);
insert into programa(nombre,descripcion,fecha_creacion,usu_creador,activo,id_facultad) values('ARQUITECTURA','Formar un arquitecto proyectista, gestor y líder de procesos, capaz de reconocer, interpretar, proponer y materializar una visión cultural del espacio habitable en busca del bienestar social',now(),0,'S',6);

/* Tipo prueba*/

ALTER SEQUENCE tipo_prueba_id_tipo_prueba_seq MINVALUE 1 START WITH 1 RESTART WITH 1;

insert into tipo_prueba(nombre,descripcion,fecha_creacion,usu_creador,activo) values('SIMULACRO','Prueba que se evaluan todos los modulos del los dos tipo los genericos y especificos con un tiempo limite para finalizarla',now(),0,'S');
insert into tipo_prueba(nombre,descripcion,fecha_creacion,usu_creador,activo) values('ENTRENAMIENTO','Prueba que se los modulos que se eligen sin tiempo limite y se puede decidir si finalizarla,generarla,reiniciarla y pausarla',now(),0,'S');

/* Estado prueba*/

ALTER SEQUENCE estado_prueba_id_estado_prueba_seq MINVALUE 1 START WITH 1 RESTART WITH 1;

insert into estado_prueba(nombre,descripcion,fecha_creacion,usu_creador,activo) values('INICIADO','Estado de la prueba cuando la esta realizando',now(),0,'S');
insert into estado_prueba(nombre,descripcion,fecha_creacion,usu_creador,activo) values('PAUSADA','Estado de la pruea cuando decide parar o dejarla pendiente solo aplica para entrenamientos',now(),0,'S');
insert into estado_prueba(nombre,descripcion,fecha_creacion,usu_creador,activo) values('FINALIZADA','Estado de la prueba cuando la termina y ve sus resultados',now(),0,'S');
insert into estado_prueba(nombre,descripcion,fecha_creacion,usu_creador,activo) values('REINICIADA','Estado cuando decide repetir una prueba para mejorar resultado',now(),0,'S');
insert into estado_prueba(nombre,descripcion,fecha_creacion,usu_creador,activo) values('PENDIENTE','Estado cuando solicita la prueba',now(),0,'S');

/* Tipo usuario*/

ALTER SEQUENCE tipo_usuario_id_tipo_usuario_seq MINVALUE 1 START WITH 1 RESTART WITH 1;

insert into tipo_usuario(nombre,descripcion,fecha_creacion,usu_creador,activo) values('ESTUDIANTE','Rol que realiza pruebas de modulos acuerdo a su programa',now(),0,'S');
insert into tipo_usuario(nombre,descripcion,fecha_creacion,usu_creador,activo) values('DOCENTE','Rol que alimenta el banco de preguntas del programa que este asignado',now(),0,'S');
insert into tipo_usuario(nombre,descripcion,fecha_creacion,usu_creador,activo) values('DIRECTOR','Rol que administra todo refente a un programa que este asignado,puede consultar y ver informes especificos',now(),0,'A');
insert into tipo_usuario(nombre,descripcion,fecha_creacion,usu_creador,activo) values('DECANO','Rol que administra todo referente a una facultad,puede consultar y ver informes generales',now(),0,'A');
insert into tipo_usuario(nombre,descripcion,fecha_creacion,usu_creador,activo) values('ADMIN','Rol que administra todo el sistema',now(),0,'A');

/* Tipo modulo*/

ALTER SEQUENCE tipo_modulo_id_tipo_modulo_seq MINVALUE 1 START WITH 1 RESTART WITH 1;

insert into tipo_modulo(nombre,descripcion,fecha_creacion,usu_creador,activo) values('COMPETENCIA GENERICA','Categoria de modulos aplicada todas por igual a todos los programas',now(),0,'S');
insert into tipo_modulo(nombre,descripcion,fecha_creacion,usu_creador,activo) values('COMPETENCIA ESPECIFICA','Categoria de modulos aplicada de acuerdo al programa',now(),0,'S');

/* Tipo pregunta */

ALTER SEQUENCE tipo_pregunta_id_tipo_pregunta_seq MINVALUE 1 START WITH 1 RESTART WITH 1;

insert into tipo_pregunta(nombre,descripcion,fecha_creacion,usu_creador,activo) values('PREGUNTA ABIERTA','Tipo de pregunta con una respuesta en texto escrita por el estudiante',now(),0,'S');
insert into tipo_pregunta(nombre,descripcion,fecha_creacion,usu_creador,activo) values('PREGUNTA DE SELECCIÓN MULTIPLE','Tipo de pregunta que tiene las respuestas ya definidas se seleciona una unica',now(),0,'S');

/* Modulo*/

ALTER SEQUENCE modulo_id_modulo_seq MINVALUE 1 START WITH 1 RESTART WITH 1;

insert into modulo(nombre,descripcion,prioridad,cantidad_preguntas,fecha_creacion,usu_creador,activo,id_tipo_modulo) values('MODULO COMPETENCIAS CIUDADANAS','Las competencias ciudadanas son un conjunto de habilidades cognitivas, emocionales y comunicativas, que debemos desarrollar desde pequeños para saber vivir con los otros y sobre todo, para actuar de manera constructiva en la sociedad',1,2,now(),0,'S',1);
insert into modulo(nombre,descripcion,prioridad,cantidad_preguntas,fecha_creacion,usu_creador,activo,id_tipo_modulo) values('MODULO DE COMUNICACION ESCRITA','La comunicación escrita es el proceso escrito mediante el cual un emisor (periodista, escritor, poeta etc.) dirige un mensaje a un receptor',1,2,now(),0,'N',1);
insert into modulo(nombre,descripcion,prioridad,cantidad_preguntas,fecha_creacion,usu_creador,activo,id_tipo_modulo) values('MODULO DE INGLÉS','El modulo de inglé es para evaluar las capacidades frente al conocimiento que posean frente a la lenguaje o idioma',1,2,now(),0,'S',1);
insert into modulo(nombre,descripcion,prioridad,cantidad_preguntas,fecha_creacion,usu_creador,activo,id_tipo_modulo) values('MODULO DE LECTURA CRÍTICA','La lectura crítica es la lectura realizada de un modo analítico. Esto significa que además de comprender los que se dice en un texto determinado, se intentará analizar lo expresado para verificar sus aciertos, sus errores y los modos en que se presenta la información',1,2,now(),0,'S',1);
insert into modulo(nombre,descripcion,prioridad,cantidad_preguntas,fecha_creacion,usu_creador,activo,id_tipo_modulo) values('MODULO DE DISEÑO DE SOFTWARE','El diseño de sistemas es el arte de definir la arquitectura de hardware y software, componentes, módulos y datos de un sistema de cómputo, a efectos de satisfacer ciertos requerimientos. ... La importancia del software multiplataforma ha incrementado la ingeniería de software a costa de los diseños de sistemas',1,2,now(),0,'S',2);
insert into modulo(nombre,descripcion,prioridad,cantidad_preguntas,fecha_creacion,usu_creador,activo,id_tipo_modulo) values('MODULO DE FORMULACION DE PROJECTOS','CONCEPTO DE FORMULACIÓN Y EVALUACIÓN DE PROYECTOS. “Es el conjunto organizado de acciones, realizadas ordenadamente durante un período de tiempo determinado, que responden a una demanda o problema, con el propósito de ofrecer una solución.',1,2,now(),0,'S',2);
insert into modulo(nombre,descripcion,prioridad,cantidad_preguntas,fecha_creacion,usu_creador,activo,id_tipo_modulo) values('MODULO DE PENSAMIENTO CIENTÍFICO,MATEMÁTICO Y ESTADÍSTICO','La ciencia es un conjunto de técnicas y métodos que permiten organizar el conocimiento sobre la estructura de hechos objetivos y accesibles a distintos observadores. El pensamiento, por su parte, es el producto de la mente, aquello traído a la existencia por medio de la actividad intelectual,onocimiento matemático; teorema matemático; cálculo matemático y conocimientos de estadistica',1,2,now(),0,'S',2);
insert into modulo(nombre,descripcion,prioridad,cantidad_preguntas,fecha_creacion,usu_creador,activo,id_tipo_modulo) values('MODULO DE RAZONAMIENTO CUANTITATIVO','El razonamiento cuantitativo. 2. En esta área se analizan las capacidades de utilización de números y términos matemáticos para resolver problemas cuantitativos, y la capacidad de analizar datos presentados bajo diversas formas tales como tablas y gráficos',1,2,now(),0,'S',2);
insert into modulo(nombre,descripcion,prioridad,cantidad_preguntas,fecha_creacion,usu_creador,activo,id_tipo_modulo) values('MODULO DE DISEÑO','',1,2,now(),0,'S',2);
insert into modulo(nombre,descripcion,prioridad,cantidad_preguntas,fecha_creacion,usu_creador,activo,id_tipo_modulo) values('MODULO DE ARGUMENTACION','',1,2,now(),0,'S',2);
insert into modulo(nombre,descripcion,prioridad,cantidad_preguntas,fecha_creacion,usu_creador,activo,id_tipo_modulo) values('MODULO DE FILOSOFIA','',1,2,now(),0,'S',2);

/* Programa modulo */

ALTER SEQUENCE programa_modulo_id_programa_modulo_seq MINVALUE 1 START WITH 1 RESTART WITH 1;

insert into programa_modulo(fecha_creacion,usu_creador,activo,id_programa,id_modulo) values(now(),0,'S',5,5);
insert into programa_modulo(fecha_creacion,usu_creador,activo,id_programa,id_modulo) values(now(),0,'S',5,6);
insert into programa_modulo(fecha_creacion,usu_creador,activo,id_programa,id_modulo) values(now(),0,'S',5,7);
insert into programa_modulo(fecha_creacion,usu_creador,activo,id_programa,id_modulo) values(now(),0,'S',5,8);

/* Pregunta */

ALTER SEQUENCE pregunta_id_pregunta_seq MINVALUE 1 START WITH 1 RESTART WITH 1;

insert into pregunta(descripcion_pregunta,fecha_creacion,usu_creador,activo,id_modulo,id_tipo_pregunta) values('En una ciudad los habitantes enfrentan un grave problema de tráfico. Las vías no
son suficientes para la cantidad de carros que tienen los habitantes de la ciudad
y la oferta de transporte público es limitada y de mala calidad. El gobierno de la
ciudad decide que para solucionar el problema de tráfico va a limitar la cantidad
de carros particulares que pueden circular diariamente, de acuerdo con el último
número de la placa.
En lo que concierne al transporte de los ciudadanos, ¿qué efectos no deseados
podría traer la medida?',now(),0,'S',1,2);
insert into pregunta(descripcion_pregunta,fecha_creacion,usu_creador,activo,id_modulo,id_tipo_pregunta) values('Cuando Rosa estaba terminando su formación profesional sufrió un accidente
que le produjo una parálisis que la obliga a desplazarse en silla de ruedas. Ahora
tiene 28 años, se graduó como ingeniera de sistemas, y está buscando trabajo.
Envió su hoja de vida a una empresa, la cual le manifestó que cumplía con el perfil
requerido y la citó a una entrevista. Durante la entrevista, le dijeron a Rosa que
desafortunadamente no la podrán emplear pues la empresa se vería obligada a
adaptar su infraestructura física para que ella pudiera trabajar allí.
En lo que concierne a la Constitución, ¿cuál de las siguientes afirmaciones aplica
a la situación presentada?',now(),0,'S',1,2);
insert into pregunta(descripcion_pregunta,fecha_creacion,usu_creador,activo,id_modulo,id_tipo_pregunta) values('La entrada a un museo de la ciudad no tiene el mismo valor para todos los
ciudadanos, pues para los menores de edad hay una reducción de la tarifa a la
mitad.
La diferencia en la tarifa es',now(),0,'S',1,2);
insert into pregunta(descripcion_pregunta,fecha_creacion,usu_creador,activo,id_modulo,id_tipo_pregunta) values('Para atender a todos los niños en edad escolar que no están recibiendo educación,
la Secretaría de Educación de un municipio decide ordenarles a los colegios públicos
que aumenten a 50 la cantidad de estudiantes en cada salón.
¿Cuál de las siguientes es una probable consecuencia no deseada de esta medida?',now(),0,'S',1,2);


/* Respuesta */

ALTER SEQUENCE respuesta_id_respuesta_seq MINVALUE 1 START WITH 1 RESTART WITH 1;

insert into respuesta(descripcion_respuesta,porcentaje_acierto,fecha_creacion,usu_creador,activo,id_pregunta) values('Que disminuya el número de carros particulares en circulación y aumente el
número de usuarios de transporte público',0,now(),0,'S',1);
insert into respuesta(descripcion_respuesta,porcentaje_acierto,fecha_creacion,usu_creador,activo,id_pregunta) values('Que aumente el número total de carros particulares y el servicio de transporte
público se vuelva aún más deficiente.',100,now(),0,'S',1);
insert into respuesta(descripcion_respuesta,porcentaje_acierto,fecha_creacion,usu_creador,activo,id_pregunta) values('Que disminuya la contaminación del aire y se debiliten los controles al nivel
de contaminación máximo permitido por tipo de vehículo.',0,now(),0,'S',1);
insert into respuesta(descripcion_respuesta,porcentaje_acierto,fecha_creacion,usu_creador,activo,id_pregunta) values('Que aumente el precio de los vehículos particulares y los vehículos de
transporte público no circulen con pocos pasajeros.',0,now(),0,'S',1);
insert into respuesta(descripcion_respuesta,porcentaje_acierto,fecha_creacion,usu_creador,activo,id_pregunta) values('La empresa carece de recursos para adaptar su infraestructura de manera
que Rosa pueda trabajar allí. ',0,now(),0,'S',2);
insert into respuesta(descripcion_respuesta,porcentaje_acierto,fecha_creacion,usu_creador,activo,id_pregunta) values('La empresa podría recibir deducciones de impuestos por emplear a personas
en situación de discapacidad',0,now(),0,'S',2);
insert into respuesta(descripcion_respuesta,porcentaje_acierto,fecha_creacion,usu_creador,activo,id_pregunta) values('La empresa puede justificar sobre la base de sus estatutos el no emplear
a Rosa',0,now(),0,'S',2);
insert into respuesta(descripcion_respuesta,porcentaje_acierto,fecha_creacion,usu_creador,activo,id_pregunta) values('La empresa está vulnerando el derecho a tener igualdad de oportunidades
para trabajar',100,now(),0,'S',2);
insert into respuesta(descripcion_respuesta,porcentaje_acierto,fecha_creacion,usu_creador,activo,id_pregunta) values('injusta, porque el museo invierte la misma cantidad de recursos en prestarles
un buen servicio a todos.',0,now(),0,'S',3);
insert into respuesta(descripcion_respuesta,porcentaje_acierto,fecha_creacion,usu_creador,activo,id_pregunta) values('justa, porque los menores de edad generalmente no cuentan con recursos
económicos propios y su acceso a la cultura debe promoverse.',100,now(),0,'S',3);
insert into respuesta(descripcion_respuesta,porcentaje_acierto,fecha_creacion,usu_creador,activo,id_pregunta) values('justa, porque únicamente debe promoverse el acceso a la cultura de las
personas que se encuentren en edad de aprender',0,now(),0,'S',3);
insert into respuesta(descripcion_respuesta,porcentaje_acierto,fecha_creacion,usu_creador,activo,id_pregunta) values('injusta, porque al haber tarifas reducidas el museo recibe menos ingresos
de los que recibiría si todos pagaran la tarifa completa',0,now(),0,'S',3);
insert into respuesta(descripcion_respuesta,porcentaje_acierto,fecha_creacion,usu_creador,activo,id_pregunta) values('Que la Secretaría de Educación se quede sin presupuesto para continuar
pagándoles el salario a los profesores.',0,now(),0,'S',4);
insert into respuesta(descripcion_respuesta,porcentaje_acierto,fecha_creacion,usu_creador,activo,id_pregunta) values('Que desde el preescolar la educación se reduzca a un mero entrenamiento
para el trabajo.',0,now(),0,'S',4);
insert into respuesta(descripcion_respuesta,porcentaje_acierto,fecha_creacion,usu_creador,activo,id_pregunta) values('Que con el aumento demográfico haya cada vez más niños que requieran
educación y que no puedan ser atendidos.',0,now(),0,'S',4);
insert into respuesta(descripcion_respuesta,porcentaje_acierto,fecha_creacion,usu_creador,activo,id_pregunta) values('Que disminuya la atención que el profesor puede prestar a cada niño y con
ello la calidad de la educación prestada.',100,now(),0,'S',4);

/* Usuario */

ALTER SEQUENCE usuario_id_usuario_seq MINVALUE 1 START WITH 1 RESTART WITH 1;
insert into usuario(nombre,apellido,genero,codigo,identificacion,celular,correo,password,fecha_creacion,usu_creador,activo,id_tipo_usuario) values('ADMIN','ADMINISTRADOR','M',9999999,9999999999,9999999999,'jhonypk18@gmail.com','0f58a4a53a053ec2daf30b1593cfde03fbed1594852845bd88c2cb111355b185f72813cf8ebffaa5',now(),0,'S',5);
insert into usuario(nombre,apellido,genero,codigo,identificacion,celular,correo,password,fecha_creacion,usu_creador,activo,id_tipo_usuario) values('JHONY','SARRIA REVELO','M',1148248,1133567234,3125466543,'jhonypk24@gmail.com','0f58a4a53a053ec2daf30b1593cfde03fbed1594852845bd88c2cb111355b185f72813cf8ebffaa5',now(),0,'S',1);
insert into usuario(nombre,apellido,genero,codigo,identificacion,celular,correo,password,fecha_creacion,usu_creador,activo,id_tipo_usuario) values('CAMILO','LOPEZ SERNA','M',1156248,1154567234,3105466543,'camilopk24@gmail.com','0f58a4a53a053ec2daf30b1593cfde03fbed1594852845bd88c2cb111355b185f72813cf8ebffaa5',now(),0,'S',1);
insert into usuario(nombre,apellido,genero,codigo,identificacion,celular,correo,password,fecha_creacion,usu_creador,activo,id_tipo_usuario) values('ANDRES','SALAZAR ZAPATA','M',1160248,1160567234,3185466543,'andrespk24@gmail.com','0f58a4a53a053ec2daf30b1593cfde03fbed1594852845bd88c2cb111355b185f72813cf8ebffaa5',now(),0,'S',2);
insert into usuario(nombre,apellido,genero,codigo,identificacion,celular,correo,password,fecha_creacion,usu_creador,activo,id_tipo_usuario) values('BEATRIZ','GOMEZ SALAZAR','M',1178248,1183567234,3025466543,'beatrizpk24@gmail.com','0f58a4a53a053ec2daf30b1593cfde03fbed1594852845bd88c2cb111355b185f72813cf8ebffaa5',now(),0,'S',3);
insert into usuario(nombre,apellido,genero,codigo,identificacion,celular,correo,password,fecha_creacion,usu_creador,activo,id_tipo_usuario) values('MARIO JULIAN','GOMEZ CARVAGAL','M',1198248,1193567234,3125766543,'mariok24@gmail.com','0f58a4a53a053ec2daf30b1593cfde03fbed1594852845bd88c2cb111355b185f72813cf8ebffaa5',now(),0,'S',4);
insert into usuario(nombre,apellido,genero,codigo,identificacion,celular,correo,password,fecha_creacion,usu_creador,activo,id_tipo_usuario) values('MARIO ANDRES','GOMEZ CARVAGAL','M',1198246,1193567288,3125766156,'mariok2458@gmail.com','0f58a4a53a053ec2daf30b1593cfde03fbed1594852845bd88c2cb111355b185f72813cf8ebffaa5',now(),0,'S',2);
insert into usuario(nombre,apellido,genero,codigo,identificacion,celular,correo,password,fecha_creacion,usu_creador,activo,id_tipo_usuario) values('MARIO LOPEZ','GOMEZ CARVAGAL','M',3338246,3333567288,3335766156,'mario31k2458@gmail.com','0f58a4a53a053ec2daf30b1593cfde03fbed1594852845bd88c2cb111355b185f72813cf8ebffaa5',now(),0,'S',2);
/* Usuarios para pruebas */
insert into usuario(nombre,apellido,genero,codigo,identificacion,celular,correo,password,fecha_creacion,usu_creador,activo,id_tipo_usuario) values('CAMILO','SARRIA REVELO','M',1148217,1133567217,3125466517,'jhonypk2417@gmail.com','0f58a4a53a053ec2daf30b1593cfde03fbed1594852845bd88c2cb111355b185f72813cf8ebffaa5',now(),0,'S',1);
insert into usuario(nombre,apellido,genero,codigo,identificacion,celular,correo,password,fecha_creacion,usu_creador,activo,id_tipo_usuario) values('JOHAN','SARRIA REVELO','M',1148218,1133567218,3125466518,'jhonypk2418@gmail.com','0f58a4a53a053ec2daf30b1593cfde03fbed1594852845bd88c2cb111355b185f72813cf8ebffaa5',now(),0,'S',1);
insert into usuario(nombre,apellido,genero,codigo,identificacion,celular,correo,password,fecha_creacion,usu_creador,activo,id_tipo_usuario) values('CARLOS','SARRIA REVELO','M',1148219,1133567219,3125466519,'jhonypk2419@gmail.com','0f58a4a53a053ec2daf30b1593cfde03fbed1594852845bd88c2cb111355b185f72813cf8ebffaa5',now(),0,'S',1);
insert into usuario(nombre,apellido,genero,codigo,identificacion,celular,correo,password,fecha_creacion,usu_creador,activo,id_tipo_usuario) values('WILSON','SARRIA REVELO','M',1148220,1133567220,3125466520,'jhonypk2420@gmail.com','0f58a4a53a053ec2daf30b1593cfde03fbed1594852845bd88c2cb111355b185f72813cf8ebffaa5',now(),0,'S',1);
insert into usuario(nombre,apellido,genero,codigo,identificacion,celular,correo,password,fecha_creacion,usu_creador,activo,id_tipo_usuario) values('STIWAR','SARRIA REVELO','M',1148221,1133567221,3125466521,'jhonypk2421@gmail.com','0f58a4a53a053ec2daf30b1593cfde03fbed1594852845bd88c2cb111355b185f72813cf8ebffaa5',now(),0,'S',1);
/* Programa usuario */

ALTER SEQUENCE programa_usuario_id_programa_usuario_seq MINVALUE 1 START WITH 1 RESTART WITH 1;

insert into programa_usuario(fecha_creacion,usu_creador,activo,id_programa,id_usuario) values(now(),0,'S',1,1);
insert into programa_usuario(fecha_creacion,usu_creador,activo,id_programa,id_usuario) values(now(),0,'A',2,1);
insert into programa_usuario(fecha_creacion,usu_creador,activo,id_programa,id_usuario) values(now(),0,'A',3,1);
insert into programa_usuario(fecha_creacion,usu_creador,activo,id_programa,id_usuario) values(now(),0,'A',4,1);
insert into programa_usuario(fecha_creacion,usu_creador,activo,id_programa,id_usuario) values(now(),0,'A',5,1);
insert into programa_usuario(fecha_creacion,usu_creador,activo,id_programa,id_usuario) values(now(),0,'S',5,2);
insert into programa_usuario(fecha_creacion,usu_creador,activo,id_programa,id_usuario) values(now(),0,'S',5,3);
insert into programa_usuario(fecha_creacion,usu_creador,activo,id_programa,id_usuario) values(now(),0,'S',5,4);
insert into programa_usuario(fecha_creacion,usu_creador,activo,id_programa,id_usuario) values(now(),0,'S',5,5);
insert into programa_usuario(fecha_creacion,usu_creador,activo,id_programa,id_usuario) values(now(),0,'S',1,6);
insert into programa_usuario(fecha_creacion,usu_creador,activo,id_programa,id_usuario) values(now(),0,'A',2,6);
insert into programa_usuario(fecha_creacion,usu_creador,activo,id_programa,id_usuario) values(now(),0,'A',3,6);
insert into programa_usuario(fecha_creacion,usu_creador,activo,id_programa,id_usuario) values(now(),0,'A',4,6);
insert into programa_usuario(fecha_creacion,usu_creador,activo,id_programa,id_usuario) values(now(),0,'A',5,6);
insert into programa_usuario(fecha_creacion,usu_creador,activo,id_programa,id_usuario) values(now(),0,'S',8,7);
insert into programa_usuario(fecha_creacion,usu_creador,activo,id_programa,id_usuario) values(now(),0,'S',8,8);
insert into programa_usuario(fecha_creacion,usu_creador,activo,id_programa,id_usuario) values(now(),0,'S',5,9);
insert into programa_usuario(fecha_creacion,usu_creador,activo,id_programa,id_usuario) values(now(),0,'S',5,10);
insert into programa_usuario(fecha_creacion,usu_creador,activo,id_programa,id_usuario) values(now(),0,'S',5,11);
insert into programa_usuario(fecha_creacion,usu_creador,activo,id_programa,id_usuario) values(now(),0,'S',5,12);
insert into programa_usuario(fecha_creacion,usu_creador,activo,id_programa,id_usuario) values(now(),0,'S',5,13);

/* Prueba */

ALTER SEQUENCE prueba_id_prueba_seq MINVALUE 1 START WITH 1 RESTART WITH 1;

insert into prueba(fecha_creacion,usu_creador,activo,id_tipo_prueba) values(now(),0,'S',2);

/* Prueba modulo */

ALTER SEQUENCE prueba_modulo_id_prueba_modulo_seq MINVALUE 1 START WITH 1 RESTART WITH 1;

insert into prueba_modulo(numero_preguntas,fecha_creacion,usu_creador,activo,id_prueba,id_modulo) values(4,now(),0,'S',1,1);

/* Prueba programa usuario */

ALTER SEQUENCE prueba_programa_usuario_id_prueba_programa_usuario_seq MINVALUE 1 START WITH 1 RESTART WITH 1;

insert into prueba_programa_usuario(fecha_creacion,usu_creador,activo,id_prueba,id_programa_usuario,id_estado_prueba) values(now(),0,'S',1,1,3);
insert into prueba_programa_usuario(fecha_creacion,usu_creador,activo,id_prueba,id_programa_usuario,id_estado_prueba) values(now(),0,'S',1,2,3);

/* Prueba programa usuario pregunta */

ALTER SEQUENCE prueba_programa_usuario_pregu_id_prueba_programa_usuario_pr_seq MINVALUE 1 START WITH 1 RESTART WITH 1;

insert into prueba_programa_usuario_pregunta(fecha_creacion,usu_creador,activo,id_prueba_programa_usuario,id_pregunta) values(now(),0,'S',1,1);
insert into prueba_programa_usuario_pregunta(fecha_creacion,usu_creador,activo,id_prueba_programa_usuario,id_pregunta) values(now(),0,'S',1,2);
insert into prueba_programa_usuario_pregunta(fecha_creacion,usu_creador,activo,id_prueba_programa_usuario,id_pregunta) values(now(),0,'S',1,3);
insert into prueba_programa_usuario_pregunta(fecha_creacion,usu_creador,activo,id_prueba_programa_usuario,id_pregunta) values(now(),0,'S',1,4);

/* Respuesta prueba programa usuario pregunta */

ALTER SEQUENCE respuesta_prueba_programa_usu_id_respuesta_prueba_programa__seq MINVALUE 1 START WITH 1 RESTART WITH 1;

insert into respuesta_prueba_programa_usuario_pregunta(porcentaje_asignado,fecha_creacion,usu_creador,activo,id_respuesta,id_prueba_programa_usuario_pregunta) values(100,now(),0,'S',2,1);
insert into respuesta_prueba_programa_usuario_pregunta(porcentaje_asignado,fecha_creacion,usu_creador,activo,id_respuesta,id_prueba_programa_usuario_pregunta) values(100,now(),0,'S',8,2);
insert into respuesta_prueba_programa_usuario_pregunta(porcentaje_asignado,fecha_creacion,usu_creador,activo,id_respuesta,id_prueba_programa_usuario_pregunta) values(100,now(),0,'S',10,3);
insert into respuesta_prueba_programa_usuario_pregunta(porcentaje_asignado,fecha_creacion,usu_creador,activo,id_respuesta,id_prueba_programa_usuario_pregunta) values(100,now(),0,'S',16,4);

/* Prueba_real */

ALTER SEQUENCE prueba_real_id_prueba_real_seq MINVALUE 1 START WITH 1 RESTART WITH 1;

insert into prueba_real(fecha,fecha_creacion,usu_creador,activo) values('2018-04-01',now(),0,'S');

/* Matricula */

ALTER SEQUENCE matricula_id_matricula_seq MINVALUE 1 START WITH 1 RESTART WITH 1;

insert into matricula(fecha_creacion,usu_creador,activo,id_usuario,id_prueba_real) values(now(),0,'S',1,1);
insert into matricula(fecha_creacion,usu_creador,activo,id_usuario,id_prueba_real) values(now(),0,'S',2,1);

/* Resultado real */

ALTER SEQUENCE resultado_real_id_resultado_real_seq MINVALUE 1 START WITH 1 RESTART WITH 1;

insert into resultado_real(percentil_grupo,percentil_nacional,fecha_creacion,usu_creador,activo,id_matricula,id_modulo) values(80,70,now(),0,'S',1,1);

/* Grupo opcion */

ALTER SEQUENCE grupo_opcion_id_grupo_opcion_seq MINVALUE 1 START WITH 1 RESTART WITH 1;

insert into grupo_opcion(nombre,icon,fecha_creacion,usu_creador,activo) values('Cuenta','fa fa-user',now(),0,'N');
insert into grupo_opcion(nombre,icon,fecha_creacion,usu_creador,activo) values('Prueba','fa fa-list-alt',now(),0,'S');
insert into grupo_opcion(nombre,icon,fecha_creacion,usu_creador,activo) values('Usuario','fa fa-group',now(),0,'S');
insert into grupo_opcion(nombre,icon,fecha_creacion,usu_creador,activo) values('Pregunta','fa fa-exclamation-circle',now(),0,'S');
insert into grupo_opcion(nombre,icon,fecha_creacion,usu_creador,activo) values('Director','fa fa-graduation-cap',now(),0,'S');
insert into grupo_opcion(nombre,icon,fecha_creacion,usu_creador,activo) values('Decano','fa fa-university',now(),0,'S');
insert into grupo_opcion(nombre,icon,fecha_creacion,usu_creador,activo) values('Administrar','fa fa-gears',now(),0,'S');




/* Parametro */

ALTER SEQUENCE parametro_id_parametro_seq MINVALUE 1 START WITH 1 RESTART WITH 1;

insert into parametro(nombre,valor,fecha_creacion,usu_creador,activo) values('RUTA DE LA APLICACION','http://localhost:8080/saber-pro-app/',now(),0,'S');
insert into parametro(nombre,valor,fecha_creacion,usu_creador,activo) values('RUTA DE LAS PREGUNTAS','http://localhost:8080/saber-pro-app/pregunta/',now(),0,'S');
insert into parametro(nombre,valor,fecha_creacion,usu_creador,activo) values('RUTA DE LAS RESPUESTAS','http://localhost:8080/saber-pro-app/respuesta/',now(),0,'S');
insert into parametro(nombre,valor,fecha_creacion,usu_creador,activo) values('RUTA DE LAS REPORTE','/home/jhony/git/SaberProTool/saber-pro-reports/',now(),0,'S');




/* Opcion */

ALTER SEQUENCE opcion_id_opcion_seq MINVALUE 1 START WITH 1 RESTART WITH 1;

insert into opcion(nombre,ruta,fecha_creacion,usu_creador,activo,id_grupo_opcion) values('ESTADO DE PRUEBA','/XHTML/Administrador/estadoPrueba.xhtml',now(),0,'S',7);
insert into opcion(nombre,ruta,fecha_creacion,usu_creador,activo,id_grupo_opcion) values('FACULTAD','/XHTML/Administrador/facultad.xhtml',now(),0,'S',7);
insert into opcion(nombre,ruta,fecha_creacion,usu_creador,activo,id_grupo_opcion) values('MODULO','/XHTML/Administrador/modulo.xhtml',now(),0,'S',7);
insert into opcion(nombre,ruta,fecha_creacion,usu_creador,activo,id_grupo_opcion) values('PROGRAMA','/XHTML/Administrador/programa.xhtml',now(),0,'S',7);
insert into opcion(nombre,ruta,fecha_creacion,usu_creador,activo,id_grupo_opcion) values('TIPO MODULO','/XHTML/Administrador/tipoModulo.xhtml',now(),0,'S',7);
insert into opcion(nombre,ruta,fecha_creacion,usu_creador,activo,id_grupo_opcion) values('TIPO PREGUNTA','/XHTML/Administrador/tipoPregunta.xhtml',now(),0,'S',7);
insert into opcion(nombre,ruta,fecha_creacion,usu_creador,activo,id_grupo_opcion) values('TIPO PRUEBA','/XHTML/Administrador/tipoPrueba.xhtml',now(),0,'S',7);
insert into opcion(nombre,ruta,fecha_creacion,usu_creador,activo,id_grupo_opcion) values('TIPO USUARIO','/XHTML/Administrador/tipoUsuario.xhtml',now(),0,'S',7);
insert into opcion(nombre,ruta,fecha_creacion,usu_creador,activo,id_grupo_opcion) values('PREGUNTA','/XHTML/Pregunta/pregunta.xhtml',now(),0,'S',4);
insert into opcion(nombre,ruta,fecha_creacion,usu_creador,activo,id_grupo_opcion) values('VER PREGUNTA','/XHTML/Pregunta/verPregunta.xhtml',now(),0,'S',4);
insert into opcion(nombre,ruta,fecha_creacion,usu_creador,activo,id_grupo_opcion) values('PRUEBA','/XHTML/Prueba/prueba.xhtml',now(),0,'S',2);
insert into opcion(nombre,ruta,fecha_creacion,usu_creador,activo,id_grupo_opcion) values('USUARIO','/XHTML/Usuario/usuario.xhtml',now(),0,'S',3);
insert into opcion(nombre,ruta,fecha_creacion,usu_creador,activo,id_grupo_opcion) values('SALIR','/j_spring_security_logout',now(),0,'S',1);
insert into opcion(nombre,ruta,fecha_creacion,usu_creador,activo,id_grupo_opcion) values('SELECIONAR MODULOS','/XHTML/Director/programaModulo.xhtml',now(),0,'S',5);
insert into opcion(nombre,ruta,fecha_creacion,usu_creador,activo,id_grupo_opcion) values('SIMULACROS','/XHTML/Director/programaSimulacro.xhtml',now(),0,'S',5);
insert into opcion(nombre,ruta,fecha_creacion,usu_creador,activo,id_grupo_opcion) values('INFORME ESTUDIANTE','/XHTML/Director/programaInformeEstudiante.xhtml',now(),0,'S',5);
insert into opcion(nombre,ruta,fecha_creacion,usu_creador,activo,id_grupo_opcion) values('INFORME GRUPO','/XHTML/Director/programaInformeGrupo.xhtml',now(),0,'S',5);
insert into opcion(nombre,ruta,fecha_creacion,usu_creador,activo,id_grupo_opcion) values('INFORME PREGUNTAS','/XHTML/Director/programaInformePregunta.xhtml',now(),0,'S',5);
insert into opcion(nombre,ruta,fecha_creacion,usu_creador,activo,id_grupo_opcion) values('ASIGNAR DIRECTOR','/XHTML/Decano/AsignarDirector.xhtml',now(),0,'S',6);
insert into opcion(nombre,ruta,fecha_creacion,usu_creador,activo,id_grupo_opcion) values('ASIGNAR DECANO','/XHTML/Administrador/AsignarDecano.xhtml',now(),0,'S',7);


/* Permiso */

ALTER SEQUENCE permiso_id_permiso_seq MINVALUE 1 START WITH 1 RESTART WITH 1;

insert into permiso(fecha_creacion,usu_creador,activo,id_tipo_usuario,id_grupo_opcion) values(now(),0,'S',5,1);
insert into permiso(fecha_creacion,usu_creador,activo,id_tipo_usuario,id_grupo_opcion) values(now(),0,'S',5,2);
insert into permiso(fecha_creacion,usu_creador,activo,id_tipo_usuario,id_grupo_opcion) values(now(),0,'S',5,3);
insert into permiso(fecha_creacion,usu_creador,activo,id_tipo_usuario,id_grupo_opcion) values(now(),0,'S',5,4);
insert into permiso(fecha_creacion,usu_creador,activo,id_tipo_usuario,id_grupo_opcion) values(now(),0,'S',5,7);
insert into permiso(fecha_creacion,usu_creador,activo,id_tipo_usuario,id_grupo_opcion) values(now(),0,'S',4,1);
insert into permiso(fecha_creacion,usu_creador,activo,id_tipo_usuario,id_grupo_opcion) values(now(),0,'S',4,6);
insert into permiso(fecha_creacion,usu_creador,activo,id_tipo_usuario,id_grupo_opcion) values(now(),0,'S',3,1);
insert into permiso(fecha_creacion,usu_creador,activo,id_tipo_usuario,id_grupo_opcion) values(now(),0,'S',3,3);
insert into permiso(fecha_creacion,usu_creador,activo,id_tipo_usuario,id_grupo_opcion) values(now(),0,'S',3,4);
insert into permiso(fecha_creacion,usu_creador,activo,id_tipo_usuario,id_grupo_opcion) values(now(),0,'S',3,5);
insert into permiso(fecha_creacion,usu_creador,activo,id_tipo_usuario,id_grupo_opcion) values(now(),0,'S',2,1);
insert into permiso(fecha_creacion,usu_creador,activo,id_tipo_usuario,id_grupo_opcion) values(now(),0,'S',2,4);
insert into permiso(fecha_creacion,usu_creador,activo,id_tipo_usuario,id_grupo_opcion) values(now(),0,'S',1,1);
insert into permiso(fecha_creacion,usu_creador,activo,id_tipo_usuario,id_grupo_opcion) values(now(),0,'S',1,2);


