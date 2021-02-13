CREATE DATABASE  IF NOT EXISTS `tattoo_studio_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `tattoo_studio_db`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: tattoo_studio_db
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cita`
--

DROP TABLE IF EXISTS `cita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cita` (
  `idCita` int unsigned NOT NULL AUTO_INCREMENT,
  `nomClienteCita` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `dia` int NOT NULL,
  `mes` int NOT NULL,
  `anio` int NOT NULL,
  `hora` int DEFAULT NULL,
  `minutos` int DEFAULT NULL,
  `idTatuadorCita` int DEFAULT NULL,
  PRIMARY KEY (`idCita`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cita`
--

LOCK TABLES `cita` WRITE;
/*!40000 ALTER TABLE `cita` DISABLE KEYS */;
/*!40000 ALTER TABLE `cita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudio`
--

DROP TABLE IF EXISTS `estudio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudio` (
  `idEstudio` int NOT NULL,
  `ganancia` double DEFAULT NULL,
  `reinversion` double DEFAULT NULL,
  `pagoProveedores` double DEFAULT NULL,
  `clip` double NOT NULL,
  PRIMARY KEY (`idEstudio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudio`
--

LOCK TABLES `estudio` WRITE;
/*!40000 ALTER TABLE `estudio` DISABLE KEYS */;
INSERT INTO `estudio` VALUES (1,0,0,0,0.0417);
/*!40000 ALTER TABLE `estudio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `idProducto` int unsigned NOT NULL AUTO_INCREMENT,
  `modeloPro` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `tipoPro` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `cantidadPro` int DEFAULT NULL,
  `precioPro` double NOT NULL,
  `costoPro` double NOT NULL,
  `perfo` tinyint NOT NULL,
  `idProveedorProducto` int DEFAULT NULL,
  `eliminado` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor` (
  `idProveedor` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `contacto` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `total` double DEFAULT NULL,
  `eliminado` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`idProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `socio`
--

DROP TABLE IF EXISTS `socio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `socio` (
  `idSocio` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `contacto` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `rango` tinyint NOT NULL,
  `total` double DEFAULT NULL,
  PRIMARY KEY (`idSocio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socio`
--

LOCK TABLES `socio` WRITE;
/*!40000 ALTER TABLE `socio` DISABLE KEYS */;
/*!40000 ALTER TABLE `socio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tatuador`
--

DROP TABLE IF EXISTS `tatuador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tatuador` (
  `idTatuador` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ap_paterno` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ap_materno` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `contacto` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `rango` int DEFAULT NULL,
  `total` double DEFAULT NULL,
  `eliminado` tinyint DEFAULT '0',
  PRIMARY KEY (`idTatuador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tatuador`
--

LOCK TABLES `tatuador` WRITE;
/*!40000 ALTER TABLE `tatuador` DISABLE KEYS */;
/*!40000 ALTER TABLE `tatuador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `idTicket` int unsigned NOT NULL AUTO_INCREMENT,
  `clip` tinyint DEFAULT NULL,
  `prod` tinyint DEFAULT NULL,
  `subtotalTatuaje` double DEFAULT NULL,
  `subtotalPerforacion` double DEFAULT NULL,
  `pagoTatuador` double DEFAULT NULL,
  `pagoPerforador` double DEFAULT NULL,
  `total` double DEFAULT NULL,
  `totalClip` double DEFAULT '0',
  `visita` tinyint DEFAULT NULL,
  `dia` int DEFAULT NULL,
  `mes` int DEFAULT NULL,
  `anio` int DEFAULT NULL,
  `idTatuadorTicket` int DEFAULT NULL,
  `idPerforadorTicket` int DEFAULT NULL,
  PRIMARY KEY (`idTicket`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idUsuario` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `ap_paterno` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `ap_materno` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `super` tinyint DEFAULT '0',
  `pass` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'','','',1,'admin','admin');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta` (
  `idVenta` int unsigned NOT NULL AUTO_INCREMENT,
  `cantidad` int DEFAULT NULL,
  `idProductoVenta` int DEFAULT NULL,
  `idTicketVenta` int DEFAULT NULL,
  `costoTotal` double DEFAULT NULL,
  `precioTotal` double DEFAULT NULL,
  PRIMARY KEY (`idVenta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'tattoo_studio_db'
--
/*!50003 DROP PROCEDURE IF EXISTS `insertar_ticket` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_ticket`(IN clip TINYINT, 
									IN prod TINYINT, 
                                    IN subTat DOUBLE, 
                                    IN subPerf DOUBLE, 
                                    IN pagoT DOUBLE,
                                    IN pagoP DOUBLE,
                                    IN total DOUBLE,
                                    IN visita TINYINT,
                                    IN dia INT,
                                    IN mes INT,
                                    IN anio INT,
                                    IN idTatuador INT,
                                    IN idPerforador INT)
BEGIN
	INSERT INTO ticket (clip, prod, subtotalTatuaje, subtotalPerforacion, pagoTatuador, pagoPerforador, total, visita, dia, mes, anio, idTatuadorTicket, idPerforadorTicket) 
    VALUES(clip,prod,subTat,subPerf,pagoT,pagoP,total,visita,dia,mes,anio,idTatuador,idPerforador);
    
    SELECT MAX(idTicket) AS max
    FROM ticket;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `obtener_comisiones` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtener_comisiones`(IN v_dia INT, IN v_mes INT, IN v_anio INT)
BEGIN
	IF v_dia = 0 AND v_mes = 0 THEN
		SELECT SUM(pagoTatuador)suma, idTatuadorTicket, nombre, ap_paterno, ap_materno
		FROM ticket
		INNER JOIN tatuador
		ON idTatuadorTicket = idTatuador
        WHERE anio = v_anio
        GROUP BY idTatuadorTicket;
			
	ELSEIF v_dia = 0 AND v_mes <> 0 THEN
		SELECT SUM(pagoTatuador)suma, idTatuadorTicket, nombre, ap_paterno, ap_materno
		FROM ticket
		INNER JOIN tatuador
		ON idTatuadorTicket = idTatuador
        WHERE anio = v_anio AND mes = v_mes
        GROUP BY idTatuadorTicket;
    ELSE
		SELECT SUM(pagoTatuador)suma, idTatuadorTicket, nombre, ap_paterno, ap_materno
		FROM ticket
		INNER JOIN tatuador
		ON idTatuadorTicket = idTatuador
        WHERE anio = v_anio AND mes = v_mes AND dia = v_dia
        GROUP BY idTatuadorTicket;
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `obtener_comision_perforadores` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtener_comision_perforadores`(IN v_dia INT, IN v_mes INT, IN v_anio INT)
BEGIN
	IF v_dia = 0 AND v_mes = 0 THEN
		SELECT SUM(t.pagoPerforador)suma, t.total, t.idPerforadorTicket, nombre
		FROM ticket t
		INNER JOIN proveedor
		ON idPerforadorTicket = idProveedor
        WHERE anio = v_anio
        GROUP BY idPerforadorTicket
        ORDER BY idProveedor;
			
	ELSEIF v_dia = 0 AND v_mes <> 0 THEN
		SELECT SUM(t.pagoPerforador)suma, t.total, t.idPerforadorTicket, nombre
		FROM ticket t
		INNER JOIN proveedor
		ON idPerforadorTicket = idProveedor
        WHERE anio = v_anio AND mes = v_mes
        GROUP BY idPerforadorTicket
        ORDER BY idProveedor;
    ELSE
		SELECT SUM(t.pagoPerforador)suma, t.total, t.idPerforadorTicket, nombre
		FROM ticket t
		INNER JOIN proveedor
		ON idPerforadorTicket = idProveedor
        WHERE anio = v_anio AND mes = v_mes AND dia = v_dia
        GROUP BY idPerforadorTicket
        ORDER BY idProveedor;
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `obtener_comision_tatuador` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtener_comision_tatuador`(IN v_dia INT, IN v_mes INT, IN v_anio INT)
BEGIN
	IF v_dia = 0 AND v_mes = 0 THEN
		SELECT SUM(t.pagoTatuador)suma, t.total, t.idTatuadorTicket, nombre, ap_paterno, ap_materno
		FROM ticket t
		INNER JOIN tatuador
		ON idTatuadorTicket = idTatuador
        WHERE anio = v_anio
        GROUP BY idTatuadorTicket
        ORDER BY idTatuador;
			
	ELSEIF v_dia = 0 AND v_mes <> 0 THEN
		SELECT SUM(t.pagoTatuador)suma, t.total, t.idTatuadorTicket, nombre, ap_paterno, ap_materno
		FROM ticket t
		INNER JOIN tatuador
		ON idTatuadorTicket = idTatuador
        WHERE anio = v_anio AND mes = v_mes
        GROUP BY idTatuadorTicket
        ORDER BY idTatuador;

    ELSE
		SELECT SUM(t.pagoTatuador)suma, t.total, t.idTatuadorTicket, nombre, ap_paterno, ap_materno
		FROM ticket t
		INNER JOIN tatuador
		ON idTatuadorTicket = idTatuador
        WHERE anio = v_anio AND mes = v_mes AND dia = v_dia
        GROUP BY idTatuadorTicket
        ORDER BY idTatuador;

    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `obtener_ganancias` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtener_ganancias`(IN v_dia INT, IN v_mes INT, IN v_anio INT)
BEGIN
	IF v_dia = 0 AND v_mes = 0 THEN
		SELECT SUM(t.total)-SUM(t.pagoTatuador)-SUM(t.pagoPerforador)-SUM(v.costoTotal)-SUM(t.totalClip)ganancias
		FROM ticket t
		INNER JOIN venta v
		ON idTicket = idTicketVenta
		WHERE anio = v_anio;
			
	ELSEIF v_dia = 0 AND v_mes <> 0 THEN
		SELECT SUM(t.total)-SUM(t.pagoTatuador)-SUM(t.pagoPerforador)-SUM(v.costoTotal)-SUM(t.totalClip)ganancias
		FROM ticket t
		INNER JOIN venta v
		ON idTicket = idTicketVenta
		WHERE anio = v_anio AND mes = v_mes;
	ELSE
		SELECT SUM(t.total)-SUM(t.pagoTatuador)-SUM(t.pagoPerforador)-SUM(v.costoTotal)-SUM(t.totalClip)ganancias
		FROM ticket t
		INNER JOIN venta v
		ON idTicket = idTicketVenta
		WHERE anio = v_anio AND mes = v_mes AND dia = v_dia;
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `obtener_total` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtener_total`(IN v_dia INT, IN v_mes INT, IN v_anio INT)
BEGIN
	IF v_dia = 0 AND v_mes = 0 THEN
		SELECT SUM(total) FROM ticket WHERE anio = v_anio;
	ELSEIF v_dia = 0 AND v_mes <> 0 THEN
		SELECT SUM(total) FROM ticket WHERE mes = v_mes AND anio = v_anio;
	ELSE
		SELECT SUM(total) FROM ticket WHERE dia = v_dia AND mes = v_mes AND anio = v_anio;
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-02-12 18:47:19
