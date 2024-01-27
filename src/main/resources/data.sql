CREATE TABLE TMC_CLIENTE
(
id_cliente INT PRIMARY KEY AUTO_INCREMENT,
identificacion VARCHAR(15) NOT NULL,
nombre VARCHAR(100) NOT NULL,
contacto_principal VARCHAR(100) NOT NULL,
correo_contacto VARCHAR(100) NOT NULL,
telefono_contacto VARCHAR(20) NOT NULL,
fecha_inicio DATE NOT NULL,
fecha_baja DATE NULL,
logo VARCHAR(5000) NULL,
estado VARCHAR(2) NOT NULL
);

CREATE TABLE GEN_PRODUCTO_CIA
(
id_producto INT PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(100),
descripcion VARCHAR(500),
logo VARCHAR(5000),
estado VARCHAR(2)
);

CREATE TABLE TCL_PROYECTO_CLIENTE
(
id_proyecto INT PRIMARY KEY AUTO_INCREMENT,
id_producto INT NOT NULL,
id_cliente INT NOT NULL,
descripcion VARCHAR(150),
fecha_inicio DATE NOT NULL,
fecha_fin DATE NULL,
estado VARCHAR(2) NOT NULL,
FOREIGN KEY (id_producto) REFERENCES GEN_PRODUCTO_CIA(id_producto),
FOREIGN KEY (id_cliente) REFERENCES TMC_CLIENTE(id_cliente)
);

CREATE TABLE TCL_PLAN_CLIENTE
(
id_plan INT PRIMARY KEY AUTO_INCREMENT,
id_proyecto_cliente INT NOT NULL,
descripcion VARCHAR(150),
horas_contratadas DECIMAL(18, 2),
horas_consumidas DECIMAL(18, 2),
valor_hora DECIMAL(18, 2),
ultimo_consumo DATE NULL,
fecha_contratacion DATE,
fecha_fin DATE,
usuaro_registro VARCHAR(30) NOT NULL,
FOREIGN KEY (id_proyecto_cliente) REFERENCES TCL_PROYECTO_CLIENTE(id_proyecto)
);

CREATE TABLE TMS_TIPO_SOLICITUD
(
id_tipo_solicitud INT PRIMARY KEY AUTO_INCREMENT,
descripcion VARCHAR(50),
estado VARCHAR(2),
fecha_actualizacion DATE,
usuario_actualizacion VARCHAR(30)
);

CREATE TABLE TSR_SOLICITUD
(
id_solicitud INT PRIMARY KEY AUTO_INCREMENT,
id_tipo_solicitud INT NOT NULL,
id_plan_cliente INT NOT NULL,
fecha_registro DATE NOT NULL,
usuario_registro VARCHAR(30) NOT NULL,
medio_llegada VARCHAR(45) NOT NULL,
usr_funcional VARCHAR(100) NOT NULL,
dep_funcional VARCHAR(100) NOT NULL,
usr_tecnico VARCHAR(100) NOT NULL,
dep_tecnico VARCHAR(100) NOT NULL,
datos_equipo VARCHAR(150) NOT NULL,
todas_estaciones VARCHAR(2),
detalle VARCHAR(500),
fecha_asignacion DATE,
usuario_asignacion VARCHAR(30),
consultor_asignado VARCHAR(100),
estado VARCHAR(2),
FOREIGN KEY (id_tipo_solicitud) REFERENCES TMS_TIPO_SOLICITUD(id_tipo_solicitud),
FOREIGN KEY (id_plan_cliente) REFERENCES TCL_PLAN_CLIENTE(id_plan)
);

CREATE TABLE TSR_DETALLE_ADJUNTO
(
id_adjunto INT PRIMARY KEY AUTO_INCREMENT,
id_solicitud INT NOT NULL,
nombre_archivo VARCHAR(150) NOT NULL,
nombre_original VARCHAR(150) NOT NULL,
fecha_carga DATE NOT NULL,
FOREIGN KEY (id_solicitud) REFERENCES TSR_SOLICITUD(id_solicitud)
);

--insert into TMC_CLIENTE (id_cliente,identificacion,nombre,contacto_principal,correo_contacto,telefono_contacto,fecha_inicio,logo,estado)
--values(1,'0921282109001','Cobalsa S.A.','Juan Herrera','jeffdicao@hotmail.com','0982336541','2023-06-01','logojdc.jpg','A');
insert into TMC_CLIENTE (identificacion,nombre,contacto_principal,correo_contacto,telefono_contacto,fecha_inicio,logo,estado)
values('0921282109001','Cobalsa S.A.','Juan Herrera','jeffdicao@hotmail.com','0982336541','2023-06-01','logojdc.jpg','A');


--insert into GEN_PRODUCTO_CIA(id_producto,nombre,descripcion,logo,estado) values(1,'Dynamics GP','ERP Microsoft Dynamics GP','','A');
--insert into GEN_PRODUCTO_CIA(id_producto,nombre,descripcion,logo,estado) values(2,'Sinergy','Talento Humano Sinergy','','A');
--insert into GEN_PRODUCTO_CIA(id_producto,nombre,descripcion,logo,estado) values(3,'DYnamics 365 BC','Business Central','','A');

insert into GEN_PRODUCTO_CIA(nombre,descripcion,logo,estado) values('Dynamics GP','ERP Microsoft Dynamics GP','','A');
insert into GEN_PRODUCTO_CIA(nombre,descripcion,logo,estado) values('Sinergy','Talento Humano Sinergy','','A');
insert into GEN_PRODUCTO_CIA(nombre,descripcion,logo,estado) values('DYnamics 365 BC','Business Central','','A');

--insert into TCL_PROYECTO_CLIENTE(id_proyecto,id_producto,id_cliente,descripcion,fecha_inicio,estado)
--values(1,1,1,'Proyecto Dynamics GP 2023','2023-01-01','A');
--insert into TCL_PROYECTO_CLIENTE(id_proyecto,id_producto,id_cliente,descripcion,fecha_inicio,estado)
--values(2,2,1,'Proyecto Sinergy','2023-01-01','A');

insert into TCL_PROYECTO_CLIENTE(id_producto,id_cliente,descripcion,fecha_inicio,estado)
values(1,1,'Proyecto Dynamics GP 2023','2023-01-01','A');
insert into TCL_PROYECTO_CLIENTE(id_producto,id_cliente,descripcion,fecha_inicio,estado)
values(2,1,'Proyecto Sinergy','2023-01-01','A');
insert into TCL_PROYECTO_CLIENTE(id_producto,id_cliente,descripcion,fecha_inicio,estado)
values(3,1,'Proyecto Business Central','2024-01-01','A');


--insert into TMS_TIPO_SOLICITUD(id_tipo_solicitud,descripcion,estado,fecha_actualizacion,usuario_actualizacion) values(1,'Bug','A','2023-08-08','admin');
--insert into TMS_TIPO_SOLICITUD(id_tipo_solicitud,descripcion,estado,fecha_actualizacion,usuario_actualizacion) values(2,'Incidente','A','2023-08-08','admin');
--insert into TMS_TIPO_SOLICITUD(id_tipo_solicitud,descripcion,estado,fecha_actualizacion,usuario_actualizacion) values(3,'Requerimiento','A','2023-08-08','admin');

insert into TMS_TIPO_SOLICITUD(descripcion,estado,fecha_actualizacion,usuario_actualizacion) values('Bug','A','2023-08-08','admin');
insert into TMS_TIPO_SOLICITUD(descripcion,estado,fecha_actualizacion,usuario_actualizacion) values('Incidente','A','2023-08-08','admin');
insert into TMS_TIPO_SOLICITUD(descripcion,estado,fecha_actualizacion,usuario_actualizacion) values('Requerimiento','A','2023-08-08','admin');

--insert into TCL_PLAN_CLIENTE(id_plan,id_proyecto_cliente,descripcion,horas_contratadas,horas_consumidas,valor_hora,fecha_contratacion,usuaro_registro)
--values(1,1,'Plan de soporte Dynamics GP - Agosto 2023',20,0,70,'2023-08-01','admin');

insert into TCL_PLAN_CLIENTE(id_proyecto_cliente,descripcion,horas_contratadas,horas_consumidas,valor_hora,fecha_contratacion,usuaro_registro)
values(1,'Plan de soporte Dynamics GP - Agosto 2023',20,0,70,'2023-08-01','admin');
insert into TCL_PLAN_CLIENTE(id_proyecto_cliente,descripcion,horas_contratadas,horas_consumidas,valor_hora,fecha_contratacion,usuaro_registro)
values(2,'Plan de soporte Sinergy - Agosto 2023',10,2,50,'2023-10-01','admin');
insert into TCL_PLAN_CLIENTE(id_proyecto_cliente,descripcion,horas_contratadas,horas_consumidas,valor_hora,fecha_contratacion,usuaro_registro)
values(3,'Plan de soporte BC - Enero 2024',30,0,100,'2024-01-01','admin');
