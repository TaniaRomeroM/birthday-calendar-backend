CREATE SCHEMA IF NOT EXISTS calendar DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci;

CREATE TABLE IF NOT EXISTS calendar.usuario (
usuario_id BIGINT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(40) NOT NULL,
apellido VARCHAR(40) NULL,
fechanac DATE NOT NULL,
email VARCHAR(40) NOT NULL,
nombreusuario VARCHAR(40) NOT NULL, /* HACER UNICA */ /**//***//****/
password VARCHAR(255) NOT NULL,
PRIMARY KEY (usuario_id)
) engine=innodb;

CREATE TABLE IF NOT EXISTS calendar.contacto (
contacto_id BIGINT NOT NULL AUTO_INCREMENT,
usuario_id BIGINT NOT NULL, /*Clave Ajena*/
nombre VARCHAR(40) NOT NULL,
apellido VARCHAR(40) NULL,
fechanac DATE NOT NULL,
email VARCHAR(40) NULL,
PRIMARY KEY (contacto_id),
CONSTRAINT contacto_usuarioFK FOREIGN KEY (usuario_id) REFERENCES usuario (usuario_id) ON DELETE NO ACTION ON UPDATE NO ACTION
) engine=innodb;

CREATE TABLE IF NOT EXISTS calendar.fiesta (
fiesta_id BIGINT NOT NULL AUTO_INCREMENT,
contacto_id BIGINT NOT NULL,
usuario_id BIGINT NOT NULL,
fechafiesta DATE NULL,
tipo VARCHAR(40) NULL,
PRIMARY KEY (fiesta_id),
CONSTRAINT fiesta_contactoFK FOREIGN KEY (contacto_id) REFERENCES contacto (contacto_id) ON DELETE NO ACTION ON UPDATE NO ACTION,
CONSTRAINT fiesta_usuarioFK FOREIGN KEY (usuario_id) REFERENCES usuario (usuario_id) ON DELETE NO ACTION ON UPDATE NO ACTION
) engine=innodb;

CREATE TABLE IF NOT EXISTS calendar.fiestainvitado (
finvitado_id BIGINT NOT NULL AUTO_INCREMENT,
fiesta_id BIGINT NOT NULL, /*Clave Ajena*/
nombre VARCHAR(40) NOT NULL,
PRIMARY KEY (finvitado_id),
CONSTRAINT fiestainvitado_fiestaFK FOREIGN KEY (fiesta_id) REFERENCES fiesta (fiesta_id) ON DELETE NO ACTION ON UPDATE NO ACTION
) engine=innodb;

CREATE TABLE IF NOT EXISTS calendar.fiestacompra (
fcompra_id BIGINT NOT NULL AUTO_INCREMENT,
fiesta_id BIGINT NOT NULL, /*Clave Ajena*/
nombre VARCHAR(40) NOT NULL,
PRIMARY KEY (fcompra_id),
CONSTRAINT fiestacompra_fiestaFK FOREIGN KEY (fiesta_id) REFERENCES fiesta (fiesta_id) ON DELETE NO ACTION ON UPDATE NO ACTION
) engine=innodb;

CREATE TABLE IF NOT EXISTS calendar.notificacion (
notificacion_id BIGINT NOT NULL AUTO_INCREMENT,
usuario_id BIGINT NOT NULL, /*Clave Ajena*/
nombre VARCHAR(40) NOT NULL,
descripcion VARCHAR(255) NOT NULL,
PRIMARY KEY (notificacion_id),
CONSTRAINT notificacion_usuarioFK FOREIGN KEY (usuario_id) REFERENCES usuario (usuario_id) ON DELETE NO ACTION ON UPDATE NO ACTION
) engine=innodb;

CREATE TABLE IF NOT EXISTS calendar.sugerencia (
sugerencia_id BIGINT NOT NULL AUTO_INCREMENT,
usuario_id BIGINT NOT NULL, /*Clave Ajena*/
nombre VARCHAR(40) NOT NULL,
descripcion VARCHAR(255) NOT NULL,
PRIMARY KEY (sugerencia_id),
CONSTRAINT sugerencia_usuarioFK FOREIGN KEY (usuario_id) REFERENCES usuario (usuario_id) ON DELETE NO ACTION ON UPDATE NO ACTION
) engine=innodb;

/* Insertar Usuarios */
INSERT INTO calendar.usuario VALUES (NULL, 'Tania', 'Romero', '2010/05/10','taniaromero@outlook.com', 'tromero', '0000');
INSERT INTO calendar.usuario VALUES (NULL, 'Valeria', 'Saez', '1996/02/07','valeriasaez@outlook.com', 'vsaez', '0000');

/* Insertar Contactos */
INSERT INTO calendar.contacto VALUES (NULL, 1, 'Manuel', 'Perez', '2001/04/02','manuel@outlook.com');
INSERT INTO calendar.contacto VALUES (NULL, 1, 'Estela', 'Sanz', '2001/07/28','estela@outlook.com');
INSERT INTO calendar.contacto VALUES (NULL, 2, 'Carmela', 'Garcia', '1996/06/24','carmela@outlook.com');
INSERT INTO calendar.contacto VALUES (NULL, 2, 'Juan', 'Sanchez', '1994/10/16','juan@outlook.com');
INSERT INTO calendar.contacto VALUES (NULL, 1, 'Maria', 'Perez', '2001/04/02','manuel@outlook.com');
INSERT INTO calendar.contacto VALUES (NULL, 1, 'Pepa', 'Sanz', '2001/07/28','estela@outlook.com');
INSERT INTO calendar.contacto VALUES (NULL, 1, 'Santiago', 'Garcia', '1996/06/24','carmela@outlook.com');
INSERT INTO calendar.contacto VALUES (NULL, 1, 'Sofia', 'Sanchez', '1994/10/16','juan@outlook.com');
INSERT INTO calendar.contacto VALUES (NULL, 1, 'Ester', 'Perez', '2001/04/02','manuel@outlook.com');
INSERT INTO calendar.contacto VALUES (NULL, 1, 'Miguel', 'Sanz', '2001/07/28','estela@outlook.com');
INSERT INTO calendar.contacto VALUES (NULL, 1, 'Nicole', 'Garcia', '1996/06/24','carmela@outlook.com');
INSERT INTO calendar.contacto VALUES (NULL, 1, 'Estefania', 'Sanchez', '1994/10/16','juan@outlook.com');
INSERT INTO calendar.contacto VALUES (NULL, 1, 'Inma', 'Perez', '2001/04/02','manuel@outlook.com');
INSERT INTO calendar.contacto VALUES (NULL, 1, 'Angeles', 'Sanz', '2001/07/28','estela@outlook.com');
INSERT INTO calendar.contacto VALUES (NULL, 1, 'Carlota', 'Garcia', '1996/06/24','carmela@outlook.com');
INSERT INTO calendar.contacto VALUES (NULL, 1, 'Juan', 'Sanchez', '1994/10/16','juan@outlook.com');

INSERT INTO calendar.fiesta VALUES (NULL, 6, 1, '1994/10/16', 'Disfraces');

INSERT INTO calendar.fiestacompra VALUES (NULL, 1, 'Jamon');
