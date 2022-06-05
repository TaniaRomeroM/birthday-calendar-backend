-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.25 - MySQL Community Server - GPL
-- SO del servidor:              Linux
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para calendar
CREATE DATABASE IF NOT EXISTS `calendar` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `calendar`;

-- Volcando estructura para tabla calendar.contacto
CREATE TABLE IF NOT EXISTS `contacto` (
  `contacto_id` bigint NOT NULL AUTO_INCREMENT,
  `usuario_id` bigint NOT NULL,
  `nombre` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `apellido` varchar(40) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `fechanac` date NOT NULL,
  `email` varchar(40) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`contacto_id`),
  KEY `contacto_usuarioFK` (`usuario_id`),
  CONSTRAINT `contacto_usuarioFK` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`usuario_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- Volcando datos para la tabla calendar.contacto: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `contacto` DISABLE KEYS */;
INSERT IGNORE INTO `contacto` (`contacto_id`, `usuario_id`, `nombre`, `apellido`, `fechanac`, `email`) VALUES
	(7, 3, 'Nacho', 'Perez', '2006-06-23', 'nacho@hotmail.com'),
	(8, 3, 'María', 'Sarrió', '2004-06-14', 'maria@gmail.com'),
	(14, 3, 'Estela', 'García', '1997-06-03', 'estela@outlook.com');
/*!40000 ALTER TABLE `contacto` ENABLE KEYS */;

-- Volcando estructura para tabla calendar.fiesta
CREATE TABLE IF NOT EXISTS `fiesta` (
  `fiesta_id` bigint NOT NULL AUTO_INCREMENT,
  `contacto_id` bigint NOT NULL,
  `usuario_id` bigint NOT NULL,
  `fechafiesta` date DEFAULT NULL,
  `tipo` varchar(40) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`fiesta_id`),
  KEY `fiesta_contactoFK` (`contacto_id`),
  KEY `fiesta_usuarioFK` (`usuario_id`),
  CONSTRAINT `fiesta_contactoFK` FOREIGN KEY (`contacto_id`) REFERENCES `contacto` (`contacto_id`) ON DELETE CASCADE,
  CONSTRAINT `fiesta_usuarioFK` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`usuario_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- Volcando datos para la tabla calendar.fiesta: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `fiesta` DISABLE KEYS */;
INSERT IGNORE INTO `fiesta` (`fiesta_id`, `contacto_id`, `usuario_id`, `fechafiesta`, `tipo`) VALUES
	(12, 7, 3, '2022-06-25', 'Disfraces'),
	(16, 14, 3, '2022-06-04', 'Medieval'),
	(18, 8, 3, '2022-06-16', 'Años 70 Disco');
/*!40000 ALTER TABLE `fiesta` ENABLE KEYS */;

-- Volcando estructura para tabla calendar.fiestacompra
CREATE TABLE IF NOT EXISTS `fiestacompra` (
  `fcompra_id` bigint NOT NULL AUTO_INCREMENT,
  `fiesta_id` bigint NOT NULL,
  `nombre` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  PRIMARY KEY (`fcompra_id`),
  KEY `fiestacompra_fiestaFK` (`fiesta_id`),
  CONSTRAINT `fiestacompra_fiestaFK` FOREIGN KEY (`fiesta_id`) REFERENCES `fiesta` (`fiesta_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- Volcando datos para la tabla calendar.fiestacompra: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `fiestacompra` DISABLE KEYS */;
INSERT IGNORE INTO `fiestacompra` (`fcompra_id`, `fiesta_id`, `nombre`) VALUES
	(8, 12, 'Queso'),
	(9, 12, 'Pan'),
	(11, 16, 'Vasos'),
	(12, 16, 'Cubiertos'),
	(13, 16, 'Mantel'),
	(14, 18, 'Pelucas'),
	(15, 18, 'Altavoces');
/*!40000 ALTER TABLE `fiestacompra` ENABLE KEYS */;

-- Volcando estructura para tabla calendar.fiestainvitado
CREATE TABLE IF NOT EXISTS `fiestainvitado` (
  `finvitado_id` bigint NOT NULL AUTO_INCREMENT,
  `fiesta_id` bigint NOT NULL,
  `nombre` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  PRIMARY KEY (`finvitado_id`),
  KEY `fiestainvitado_fiestaFK` (`fiesta_id`),
  CONSTRAINT `fiestainvitado_fiestaFK` FOREIGN KEY (`fiesta_id`) REFERENCES `fiesta` (`fiesta_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- Volcando datos para la tabla calendar.fiestainvitado: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `fiestainvitado` DISABLE KEYS */;
INSERT IGNORE INTO `fiestainvitado` (`finvitado_id`, `fiesta_id`, `nombre`) VALUES
	(10, 12, 'Sara'),
	(12, 12, 'Juan Pérez'),
	(14, 16, 'Sergio'),
	(15, 16, 'Sofía'),
	(16, 18, 'Alicia'),
	(17, 18, 'Jorge');
/*!40000 ALTER TABLE `fiestainvitado` ENABLE KEYS */;

-- Volcando estructura para tabla calendar.roles
CREATE TABLE IF NOT EXISTS `roles` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `rol_nombre` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- Volcando datos para la tabla calendar.roles: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT IGNORE INTO `roles` (`id`, `rol_nombre`) VALUES
	(1, 'ROLE_ADMIN'),
	(2, 'ROLE_USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;

-- Volcando estructura para tabla calendar.sugerencia
CREATE TABLE IF NOT EXISTS `sugerencia` (
  `sugerencia_id` bigint NOT NULL AUTO_INCREMENT,
  `usuario_id` bigint NOT NULL,
  `nombre` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `descripcion` varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `estado` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  PRIMARY KEY (`sugerencia_id`),
  KEY `sugerencia_usuarioFK` (`usuario_id`),
  CONSTRAINT `sugerencia_usuarioFK` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`usuario_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- Volcando datos para la tabla calendar.sugerencia: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `sugerencia` DISABLE KEYS */;
INSERT IGNORE INTO `sugerencia` (`sugerencia_id`, `usuario_id`, `nombre`, `descripcion`, `estado`) VALUES
	(5, 3, 'Cambio colores', 'Poder cambiar los colores del calendario', 'PENDIENTE'),
	(6, 9, 'Eliminar usuario', 'Me gustaría poder eliminar mi perfil de usuario cuando ya no lo necesite.', 'REALIZADA'),
	(7, 9, 'Recuperar contraseña', 'Quiero que haya una opción de recuperar la contraseña en la página de iniciar sesión.', 'ACEPTADA'),
	(8, 3, 'Cumpleaños del usuario', 'Quiero que también aparezca mi propio cumpleaños en el calendario.', 'RECHAZADA');
/*!40000 ALTER TABLE `sugerencia` ENABLE KEYS */;

-- Volcando estructura para tabla calendar.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `usuario_id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `apellido` varchar(40) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `fechanac` date NOT NULL,
  `email` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `nombreusuario` varchar(40) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_spanish2_ci NOT NULL,
  PRIMARY KEY (`usuario_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- Volcando datos para la tabla calendar.usuario: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT IGNORE INTO `usuario` (`usuario_id`, `nombre`, `apellido`, `fechanac`, `email`, `nombreusuario`, `password`) VALUES
	(2, 'admin', 'admin', '2010-05-10', 'admin@admin.com', 'admin', '$2a$10$mNtkiaFBSgInSJbYfX4dH.ZfFzKPGDR7hlUaofrFEi.PquiTqKQ0O'),
	(3, 'Sandra', 'Soler', '2006-05-20', 'sandra@outlook.com', 'sandraS', '$2a$10$aviCyMxPPM88OsDksye4z.o91YmN3hLVP9a1L8Le7GkdS0NOWXiU2'),
	(9, 'Eduardo', 'Soler', '2006-05-20', 'edu@outlook.com', 'edu', '$2a$10$aviCyMxPPM88OsDksye4z.o91YmN3hLVP9a1L8Le7GkdS0NOWXiU2');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

-- Volcando estructura para tabla calendar.usuario_rol
CREATE TABLE IF NOT EXISTS `usuario_rol` (
  `rol_id` bigint NOT NULL,
  `usuario_id` bigint NOT NULL,
  KEY `usuariorol_usuarioFK` (`usuario_id`),
  KEY `usuariorol_rolesFK` (`rol_id`),
  CONSTRAINT `usuariorol_rolesFK` FOREIGN KEY (`rol_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `usuariorol_usuarioFK` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`usuario_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- Volcando datos para la tabla calendar.usuario_rol: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario_rol` DISABLE KEYS */;
INSERT IGNORE INTO `usuario_rol` (`rol_id`, `usuario_id`) VALUES
	(1, 2),
	(2, 2),
	(2, 3),
	(2, 9);
/*!40000 ALTER TABLE `usuario_rol` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
