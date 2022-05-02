CREATE SCHEMA IF NOT EXISTS calendar DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci;

CREATE TABLE IF NOT EXISTS calendar.usuario (
usuario_id BIGINT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(40) NOT NULL,
apellido VARCHAR(40) NULL,
fechanac DATE NOT NULL,
email VARCHAR(40) NOT NULL,
nombreusuario VARCHAR(40) NOT NULL,
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
CONSTRAINT contacto_usuarioFK FOREIGN KEY (usuario_id) REFERENCES usuario (usuario_id) ON DELETE CASCADE
) engine=innodb;

CREATE TABLE IF NOT EXISTS calendar.fiesta (
fiesta_id BIGINT NOT NULL AUTO_INCREMENT,
contacto_id BIGINT NOT NULL,
usuario_id BIGINT NOT NULL,
fechafiesta DATE NULL,
tipo VARCHAR(40) NULL,
PRIMARY KEY (fiesta_id),
CONSTRAINT fiesta_contactoFK FOREIGN KEY (contacto_id) REFERENCES contacto (contacto_id) ON DELETE CASCADE,
CONSTRAINT fiesta_usuarioFK FOREIGN KEY (usuario_id) REFERENCES usuario (usuario_id) ON DELETE CASCADE
) engine=innodb;

CREATE TABLE IF NOT EXISTS calendar.fiestainvitado (
finvitado_id BIGINT NOT NULL AUTO_INCREMENT,
fiesta_id BIGINT NOT NULL, /*Clave Ajena*/
nombre VARCHAR(40) NOT NULL,
PRIMARY KEY (finvitado_id),
CONSTRAINT fiestainvitado_fiestaFK FOREIGN KEY (fiesta_id) REFERENCES fiesta (fiesta_id) ON DELETE CASCADE
) engine=innodb;

CREATE TABLE IF NOT EXISTS calendar.fiestacompra (
fcompra_id BIGINT NOT NULL AUTO_INCREMENT,
fiesta_id BIGINT NOT NULL, /*Clave Ajena*/
nombre VARCHAR(40) NOT NULL,
PRIMARY KEY (fcompra_id),
CONSTRAINT fiestacompra_fiestaFK FOREIGN KEY (fiesta_id) REFERENCES fiesta (fiesta_id) ON DELETE CASCADE
) engine=innodb;

CREATE TABLE IF NOT EXISTS calendar.notificacion (
notificacion_id BIGINT NOT NULL AUTO_INCREMENT,
usuario_id BIGINT NOT NULL, /*Clave Ajena*/
nombre VARCHAR(40) NOT NULL,
descripcion VARCHAR(255) NOT NULL,
PRIMARY KEY (notificacion_id),
CONSTRAINT notificacion_usuarioFK FOREIGN KEY (usuario_id) REFERENCES usuario (usuario_id) ON DELETE CASCADE
) engine=innodb;

CREATE TABLE IF NOT EXISTS calendar.sugerencia (
sugerencia_id BIGINT NOT NULL AUTO_INCREMENT,
usuario_id BIGINT NOT NULL, /*Clave Ajena*/
nombre VARCHAR(40) NOT NULL,
descripcion VARCHAR(255) NOT NULL,
estado VARCHAR(40) NOT NULL,
PRIMARY KEY (sugerencia_id),
CONSTRAINT sugerencia_usuarioFK FOREIGN KEY (usuario_id) REFERENCES usuario (usuario_id) ON DELETE CASCADE
) engine=innodb;


/*
CREATE TABLE IF NOT EXISTS calendar.roles (
id BIGINT NOT NULL AUTO_INCREMENT,
rol_nombre VARCHAR(40) NOT NULL,
PRIMARY KEY (id)
) engine=INNODB;

CREATE TABLE IF NOT EXISTS calendar.usuario_rol (
rol_id BIGINT NOT NULL,
usuario_id BIGINT NOT NULL,
CONSTRAINT usuariorol_usuarioFK FOREIGN KEY (usuario_id) REFERENCES usuario (usuario_id),
CONSTRAINT usuariorol_rolesFK FOREIGN KEY (rol_id) REFERENCES roles (id)
) engine=INNODB;

INSERT INTO roles (id, rol_nombre) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (id, rol_nombre) VALUES (2, 'ROLE_USER');
*/



/* Insertar Usuarios */
INSERT INTO calendar.usuario VALUES (NULL, 'Tania', 'Romero', '2010/05/10','taniaromero@outlook.com', 'tromero', '0000');
INSERT INTO calendar.usuario VALUES (NULL, 'Valeria', 'Saez', '1996/02/07','valeriasaez@outlook.com', 'vsaez', '0000');

/* Insertar Contactos */
INSERT INTO calendar.contacto VALUES (NULL, 1, 'Manuel', 'Perez', '2001/04/02','manuelperez@outlook.com');
INSERT INTO calendar.contacto VALUES (NULL, 1, 'Estela', 'Sanz', '2001/07/28','estelasanz@outlook.com');
INSERT INTO calendar.contacto VALUES (NULL, 2, 'Carmela', 'Garcia', '1996/06/24','carmelagarcia@outlook.com');
INSERT INTO calendar.contacto VALUES (NULL, 2, 'Juan', 'Sanchez', '1994/10/16','juansanchez@outlook.com');
INSERT INTO calendar.contacto VALUES (NULL, 1, 'Maria', 'Perez', '2001/04/02','mariaperez@outlook.com');
INSERT INTO calendar.contacto VALUES (NULL, 1, 'Pepa', 'Sanz', '2001/07/28','pepasanz@outlook.com');
INSERT INTO calendar.contacto VALUES (NULL, 1, 'Santiago', 'Garcia', '1996/06/24','santiagogarcia@outlook.com');
INSERT INTO calendar.contacto VALUES (NULL, 1, 'Sofia', 'Sanchez', '1994/10/16','sofiasanchez@outlook.com');
INSERT INTO calendar.contacto VALUES (NULL, 1, 'Ester', 'Perez', '2001/04/02','estelaperez@outlook.com');
INSERT INTO calendar.contacto VALUES (NULL, 1, 'Miguel', 'Sanz', '2001/07/28','miguelsanz@outlook.com');
INSERT INTO calendar.contacto VALUES (NULL, 1, 'Nicole', 'Garcia', '1996/06/24','nicolegarcia@outlook.com');

INSERT INTO calendar.fiesta VALUES (NULL, 1, 1, '2022/04/02', 'Disfraces');
INSERT INTO calendar.fiesta VALUES (NULL, 2, 1, '2022/07/28', 'Baile');
INSERT INTO calendar.fiesta VALUES (NULL, 3, 1, '2022/06/24', 'Japonesa');
INSERT INTO calendar.fiesta VALUES (NULL, 4, 1, '2022/10/16', 'Mascaras');

INSERT INTO calendar.fiestacompra VALUES (NULL, 1, 'Jamon');
INSERT INTO calendar.fiestacompra VALUES (NULL, 1, 'Queso');
INSERT INTO calendar.fiestacompra VALUES (NULL, 1, 'Pan');

INSERT INTO calendar.fiestacompra VALUES (NULL, 2, 'Sardinas');
INSERT INTO calendar.fiestacompra VALUES (NULL, 2, 'Fuet');
INSERT INTO calendar.fiestacompra VALUES (NULL, 2, 'Manteles');

INSERT INTO calendar.fiestacompra VALUES (NULL, 3, 'Vasos');
INSERT INTO calendar.fiestacompra VALUES (NULL, 3, 'Servilletas');
INSERT INTO calendar.fiestacompra VALUES (NULL, 3, 'Agua');

