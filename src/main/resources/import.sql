/*-------------INGRESANDO LAS REGIONALES------------------*/
insert into regional (reg_id,reg_nombre,reg_direccion) values(1,'Barrancabermeja','Carrera 36D # 65 – 20 barrio La Esperanza');
insert into regional (reg_id,reg_nombre,reg_direccion) values(2,'Vélez','Calle 12 #5–33 barrio La Esperanza');
insert into regional (reg_id,reg_nombre,reg_direccion) values(3,'Piedecuesta','Kilómetro 2 vía Guatiguará');
insert into regional (reg_id,reg_nombre,reg_direccion) values(4,'Bucaramanga','Calle de los estudiantes 9-82, piso 2 edificio A, Bucaramanga');

/*-------------INGRESANDO LAS FACULTADES------------------*/
insert into facultad (fac_id,fac_nombre,fac_reg_id) values(1,'FACULTAD DE CIENCIAS SOCIOECONÓMICAS Y EMPRESARIALES',4);
insert into facultad (fac_id,fac_nombre,fac_reg_id) values(2,'FACULTAD DE CIENCIAS NATURALES E INGENIERÍAS',4);
insert into facultad (fac_id,fac_nombre,fac_reg_id) values(3,'FACULTAD DE CIENCIAS SOCIOECONÓMICAS Y EMPRESARIALES',1);
insert into facultad (fac_id,fac_nombre,fac_reg_id) values(4,'FACULTAD DE CIENCIAS NATURALES E INGENIERÍAS',1);
insert into facultad (fac_id,fac_nombre,fac_reg_id) values(5,'FACULTAD DE CIENCIAS SOCIOECONÓMICAS Y EMPRESARIALES',2);
insert into facultad (fac_id,fac_nombre,fac_reg_id) values(6,'FACULTAD DE CIENCIAS NATURALES E INGENIERÍAS',2);
insert into facultad (fac_id,fac_nombre,fac_reg_id) values(7,'FACULTAD DE CIENCIAS SOCIOECONÓMICAS Y EMPRESARIALES',3);

/*-------------INGRESANDO LOS PROGRAMAS------------------*/
/*-------------BUCARAMANGA------------------*/
insert into programa (prog_id,prog_nombre,prog_serial,prog_nivel,prog_modalidad,prog_fac_id) values(1,'Tecnología en Manejo de la Información Contable','(110921)','TECNOLÓGICO','PRESENCIAL',1);
insert into programa (prog_id,prog_nombre,prog_serial,prog_nivel,prog_modalidad,prog_fac_id) values(2,'Tecnología en Gestión de la Moda','(106408)','TECNOLÓGICO','PRESENCIAL',1);
insert into programa (prog_id,prog_nombre,prog_serial,prog_nivel,prog_modalidad,prog_fac_id) values(3,'Tecnología en Gestión Bancaria y Financiera','(109548)','TECNOLÓGICO','PRESENCIAL',1);
insert into programa (prog_id,prog_nombre,prog_serial,prog_nivel,prog_modalidad,prog_fac_id) values(4,'Tecnología en Mercadeo y Gestión Comercial','(103073)','TECNOLÓGICO','PRESENCIAL',1);
insert into programa (prog_id,prog_nombre,prog_serial,prog_nivel,prog_modalidad,prog_fac_id) values(5,'Tecnología en Gestión Empresarial','(11007)','TECNOLÓGICO','PRESENCIAL',1);
insert into programa (prog_id,prog_nombre,prog_serial,prog_nivel,prog_modalidad,prog_fac_id) values(6,'Tecnología en Gestión Agroindustrial','(10349)','TECNOLÓGICO','PRESENCIAL',1);
insert into programa (prog_id,prog_nombre,prog_serial,prog_nivel,prog_modalidad,prog_fac_id) values(7,'Tecnología en Entrenamiento Deportivo','(17664)','TECNOLÓGICO','PRESENCIAL',1);
insert into programa (prog_id,prog_nombre,prog_serial,prog_nivel,prog_modalidad,prog_fac_id) values(8,'Administración de Empresas','(53456)','UNIVERSITARIO','PRESENCIAL',1);
insert into programa (prog_id,prog_nombre,prog_serial,prog_nivel,prog_modalidad,prog_fac_id) values(9,'Profesional en Cultura Física y Deporte','(110922)','UNIVERSITARIO','PRESENCIAL',1);
insert into programa (prog_id,prog_nombre,prog_serial,prog_nivel,prog_modalidad,prog_fac_id) values(10,'Administración Financiera','(109549)','UNIVERSITARIO','PRESENCIAL',1);
insert into programa (prog_id,prog_nombre,prog_serial,prog_nivel,prog_modalidad,prog_fac_id) values(11,'Profesional en Diseño de Moda','(106407)','UNIVERSITARIO','PRESENCIAL',1);
insert into programa (prog_id,prog_nombre,prog_serial,prog_nivel,prog_modalidad,prog_fac_id) values(12,'Mercadeo',' (110617)','UNIVERSITARIO','PRESENCIAL',1);
insert into programa (prog_id,prog_nombre,prog_serial,prog_nivel,prog_modalidad,prog_fac_id) values(13,'Contaduría Pública','(90894)','UNIVERSITARIO','PRESENCIAL',1);
insert into programa (prog_id,prog_nombre,prog_serial,prog_nivel,prog_modalidad,prog_fac_id) values(14,'Tecnología en Operación y Mantenimiento Electromecánico','(102378)','TECNOLÓGICO','PRESENCIAL',2);
insert into programa (prog_id,prog_nombre,prog_serial,prog_nivel,prog_modalidad,prog_fac_id) values(15,'Tecnología en Levantamientos Topográficos','(109015)','TECNOLÓGICO','PRESENCIAL',2);
insert into programa (prog_id,prog_nombre,prog_serial,prog_nivel,prog_modalidad,prog_fac_id) values(16,'Tecnología en Manejo de Recursos Ambientales','(101724)','TECNOLÓGICO','PRESENCIAL',2);
insert into programa (prog_id,prog_nombre,prog_serial,prog_nivel,prog_modalidad,prog_fac_id) values(17,'Tecnología en Electricidad Industrial','(106411)','TECNOLÓGICO','PRESENCIAL',2);
insert into programa (prog_id,prog_nombre,prog_serial,prog_nivel,prog_modalidad,prog_fac_id) values(18,'Tecnología en Implementación de Sistemas Electrónicos Industriales','(109017)','TECNOLÓGICO','PRESENCIAL',2);
insert into programa (prog_id,prog_nombre,prog_serial,prog_nivel,prog_modalidad,prog_fac_id) values(19,'Tecnología en Gestión de Sistemas de Telecomunicaciones','(108284)','TECNOLÓGICO','PRESENCIAL',2);
insert into programa (prog_id,prog_nombre,prog_serial,prog_nivel,prog_modalidad,prog_fac_id) values(20,'Tecnología en Desarrollo de Sistemas informáticos','(101597)','TECNOLÓGICO','PRESENCIAL',2);
insert into programa (prog_id,prog_nombre,prog_serial,prog_nivel,prog_modalidad,prog_fac_id) values(21,'Tecnología en Producción Industrial','(107256)','TECNOLÓGICO','PRESENCIAL',2);
insert into programa (prog_id,prog_nombre,prog_serial,prog_nivel,prog_modalidad,prog_fac_id) values(22,'Ingeniería de Telecomunicaciones','(53092)','UNIVERSITARIO','PRESENCIAL',2);
insert into programa (prog_id,prog_nombre,prog_serial,prog_nivel,prog_modalidad,prog_fac_id) values(23,'Ingeniería Electromecánica','(90937)','UNIVERSITARIO','PRESENCIAL',2);
insert into programa (prog_id,prog_nombre,prog_serial,prog_nivel,prog_modalidad,prog_fac_id) values(24,'Ingeniería Ambiental','(101707)','UNIVERSITARIO','PRESENCIAL',2);
insert into programa (prog_id,prog_nombre,prog_serial,prog_nivel,prog_modalidad,prog_fac_id) values(25,'Ingeniería Industrial','(107257)','UNIVERSITARIO','PRESENCIAL',2);
insert into programa (prog_id,prog_nombre,prog_serial,prog_nivel,prog_modalidad,prog_fac_id) values(26,'Ingeniería Electrónica','(53390)','UNIVERSITARIO','PRESENCIAL',2);
insert into programa (prog_id,prog_nombre,prog_serial,prog_nivel,prog_modalidad,prog_fac_id) values(27,'Ingeniería Eléctrica','(106412)','UNIVERSITARIO','PRESENCIAL',2);
insert into programa (prog_id,prog_nombre,prog_serial,prog_nivel,prog_modalidad,prog_fac_id) values(28,'Ingeniería de Sistemas','(101596)','UNIVERSITARIO','PRESENCIAL',2);
insert into programa (prog_id,prog_nombre,prog_serial,prog_nivel,prog_modalidad,prog_fac_id) values(29,'Ingeniería en Topografía','(109226)','UNIVERSITARIO','PRESENCIAL',2);

/*-------------------BARRANCA------------*/
insert into programa (prog_id,prog_nombre,prog_serial,prog_nivel,prog_modalidad,prog_fac_id) values(30,'Tecnología en Contabilidad Financiera','(90357)','TECNOLÓGICO','PRESENCIAL',3);
insert into programa (prog_id,prog_nombre,prog_serial,prog_nivel,prog_modalidad,prog_fac_id) values(31,'Tecnología en Gestión Empresarial','(90358)','TECNOLÓGICO','PRESENCIAL',3);
insert into programa (prog_id,prog_nombre,prog_serial,prog_nivel,prog_modalidad,prog_fac_id) values(32,'Contaduría Pública','(104081)','UNIVERSITARIO','PRESENCIAL',3);
insert into programa (prog_id,prog_nombre,prog_serial,prog_nivel,prog_modalidad,prog_fac_id) values(33,'Administración de Empresas','(103265)','UNIVERSITARIO','PRESENCIAL',3);
insert into programa (prog_id,prog_nombre,prog_serial,prog_nivel,prog_modalidad,prog_fac_id) values(34,'Tecnología en Operación y Mantenimiento Electromecánico','(90531)','TECNOLÓGICO','PRESENCIAL',4);
insert into programa (prog_id,prog_nombre,prog_serial,prog_nivel,prog_modalidad,prog_fac_id) values(35,'Ingeniería Electromecánica','(103234)','UNIVERSITARIO','PRESENCIAL',4);

/*-------------------VELEZ------------*/
insert into programa (prog_id,prog_nombre,prog_serial,prog_nivel,prog_modalidad,prog_fac_id) values(36,'Tecnología en Gestión Empresarial','(53333)','TECNOLÓGICO','PRESENCIAL',5);
insert into programa (prog_id,prog_nombre,prog_serial,prog_nivel,prog_modalidad,prog_fac_id) values(37,'Tecnología en Contabilidad Financiera','(53636)','TECNOLÓGICO','PRESENCIAL',5);

/*----INGRESANDO ROLES---*/
insert into rol (id,nombre) values(1,"Administrador");
insert into rol (id,nombre) values(2,"Usuario");


/*----INGRESANDO USUARIO---*/
insert into usuario (id, username, password,usuario_rol) values(1,'admin','$2a$12$f4RX2.ihLR5FuZqn4ElgbO3Wu//EQXMN/UMC/V59fKw9Aed8blxNG',1);
insert into usuario (id, username, password,usuario_rol) values(2,'regionalizacion','$2a$12$tG.mHQv0X4I2FuqR99vq6e3kcyTSGN977Ea0diWZjAgvs.tVE9JOG',1);



/*----INGRESANDO REPORTES SEMANALES---*/
insert into reporte (rep_id,rep_cantidad,rep_fecha,rep_prog_id) values (1,250,"2022-05-06",1);
insert into reporte (rep_id,rep_cantidad,rep_fecha,rep_prog_id) values (2,150,"2022-05-06",2);
insert into reporte (rep_id,rep_cantidad,rep_fecha,rep_prog_id) values (3,240,"2022-04-29",1);
insert into reporte (rep_id,rep_cantidad,rep_fecha,rep_prog_id) values (4,150,"2022-04-29",2);

insert into reporte (rep_id,rep_cantidad,rep_fecha,rep_prog_id) values (5,100,"2022-05-06",30);
insert into reporte (rep_id,rep_cantidad,rep_fecha,rep_prog_id) values (6,50,"2022-05-06",31);
insert into reporte (rep_id,rep_cantidad,rep_fecha,rep_prog_id) values (7,150,"2022-04-29",30);
insert into reporte (rep_id,rep_cantidad,rep_fecha,rep_prog_id) values (8,90,"2022-04-29",31);
 
insert into reporte (rep_id,rep_cantidad,rep_fecha,rep_prog_id) values (9,50,"2022-05-06",36);
insert into reporte (rep_id,rep_cantidad,rep_fecha,rep_prog_id) values (10,100,"2022-05-06",37);
insert into reporte (rep_id,rep_cantidad,rep_fecha,rep_prog_id) values (11,20,"2022-04-29",36);
insert into reporte (rep_id,rep_cantidad,rep_fecha,rep_prog_id) values (12,50,"2022-04-29",37);


/*----INGRESANDO REPORTES SEMESTRALES---*/
insert into estdocprog (estdoc_id,estdoc_cantidad_est,estdoc_cantidad_doc,estdoc_fecha,estdoc_prog_id) values(1,100,20,'2022-02-07',1);
insert into estdocprog (estdoc_id,estdoc_cantidad_est,estdoc_cantidad_doc,estdoc_fecha,estdoc_prog_id) values(2,200,30,'2022-02-07',2);
insert into estdocprog (estdoc_id,estdoc_cantidad_est,estdoc_cantidad_doc,estdoc_fecha,estdoc_prog_id) values(3,300,40,'2022-02-07',3);
insert into estdocprog (estdoc_id,estdoc_cantidad_est,estdoc_cantidad_doc,estdoc_fecha,estdoc_prog_id) values(4,400,50,'2022-02-07',4);
insert into estdocprog (estdoc_id,estdoc_cantidad_est,estdoc_cantidad_doc,estdoc_fecha,estdoc_prog_id) values(5,500,60,'2022-02-07',5);
insert into estdocprog (estdoc_id,estdoc_cantidad_est,estdoc_cantidad_doc,estdoc_fecha,estdoc_prog_id) values(6,600,70,'2022-02-07',6);
insert into estdocprog (estdoc_id,estdoc_cantidad_est,estdoc_cantidad_doc,estdoc_fecha,estdoc_prog_id) values(7,700,80,'2022-02-07',7);
insert into estdocprog (estdoc_id,estdoc_cantidad_est,estdoc_cantidad_doc,estdoc_fecha,estdoc_prog_id) values(8,800,90,'2022-02-07',8);
insert into estdocprog (estdoc_id,estdoc_cantidad_est,estdoc_cantidad_doc,estdoc_fecha,estdoc_prog_id) values(9,900,70,'2022-02-07',9);
insert into estdocprog (estdoc_id,estdoc_cantidad_est,estdoc_cantidad_doc,estdoc_fecha,estdoc_prog_id) values(10,100,10,'2022-02-07',10);

insert into estdocprog (estdoc_id,estdoc_cantidad_est,estdoc_cantidad_doc,estdoc_fecha,estdoc_prog_id) values(11,200,30,'2022-08-08',1);
insert into estdocprog (estdoc_id,estdoc_cantidad_est,estdoc_cantidad_doc,estdoc_fecha,estdoc_prog_id) values(12,300,40,'2022-08-08',2);
insert into estdocprog (estdoc_id,estdoc_cantidad_est,estdoc_cantidad_doc,estdoc_fecha,estdoc_prog_id) values(13,400,50,'2022-08-08',3);
insert into estdocprog (estdoc_id,estdoc_cantidad_est,estdoc_cantidad_doc,estdoc_fecha,estdoc_prog_id) values(14,500,60,'2022-08-08',4);
insert into estdocprog (estdoc_id,estdoc_cantidad_est,estdoc_cantidad_doc,estdoc_fecha,estdoc_prog_id) values(15,600,70,'2022-08-08',5);
insert into estdocprog (estdoc_id,estdoc_cantidad_est,estdoc_cantidad_doc,estdoc_fecha,estdoc_prog_id) values(16,700,80,'2022-08-08',6);
insert into estdocprog (estdoc_id,estdoc_cantidad_est,estdoc_cantidad_doc,estdoc_fecha,estdoc_prog_id) values(17,800,90,'2022-08-08',7);
insert into estdocprog (estdoc_id,estdoc_cantidad_est,estdoc_cantidad_doc,estdoc_fecha,estdoc_prog_id) values(18,900,70,'2022-08-08',8);
insert into estdocprog (estdoc_id,estdoc_cantidad_est,estdoc_cantidad_doc,estdoc_fecha,estdoc_prog_id) values(19,100,10,'2022-08-08',9);
insert into estdocprog (estdoc_id,estdoc_cantidad_est,estdoc_cantidad_doc,estdoc_fecha,estdoc_prog_id) values(20,200,30,'2022-08-08',10);
