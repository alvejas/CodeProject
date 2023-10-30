-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: dbtcapp
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `cdr`
--

DROP TABLE IF EXISTS `cdr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cdr` (
  `identifier` int NOT NULL,
  `bucket1` int NOT NULL,
  `bucket2` int NOT NULL,
  `bucket3` int NOT NULL,
  `charging_reply` varchar(255) DEFAULT NULL,
  `charging_request` varchar(255) DEFAULT NULL,
  `countera` int NOT NULL,
  `counterb` int NOT NULL,
  `counterc` int NOT NULL,
  `counterd` int NOT NULL,
  `msisdn` int NOT NULL,
  `service` varchar(255) DEFAULT NULL,
  `time_stamp` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`identifier`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cdr`
--

LOCK TABLES `cdr` WRITE;
/*!40000 ALTER TABLE `cdr` DISABLE KEYS */;
INSERT INTO `cdr` VALUES (1,1,100,2,'com.CodeProject.TelecomunicationApp.ChargingReply@eec70ce','com.CodeProject.TelecomunicationApp.ChargingRequest@5d9061f1',1321,1,21,12,123,'A','2016-01-25 08:34:55.000000'),(2,100,100,2,'com.CodeProject.TelecomunicationApp.ChargingReply@5be2487d','com.CodeProject.TelecomunicationApp.ChargingRequest@1935e695',1321,1,21,12,123,'A','2016-01-25 08:34:55.000000'),(3,100,100,2,'com.CodeProject.TelecomunicationApp.ChargingReply@5ff4c860','com.CodeProject.TelecomunicationApp.ChargingRequest@2c9c6ee2',1321,1,21,12,123,'A','2016-01-25 08:34:55.000000'),(4,1,100,2,'com.CodeProject.TelecomunicationApp.ChargingReply@271d5733','com.CodeProject.TelecomunicationApp.ChargingRequest@4fe736a0',1321,1,21,12,123,'A','2016-01-25 08:34:55.000000'),(5,1,100,2,'com.CodeProject.TelecomunicationApp.ChargingReply@1ed13970','com.CodeProject.TelecomunicationApp.ChargingRequest@28b10d2b',1321,1,21,12,123,'A','2016-01-25 08:34:55.000000'),(6,1,100,2,'com.CodeProject.TelecomunicationApp.ChargingReply@5d9a5fb1','com.CodeProject.TelecomunicationApp.ChargingRequest@5caf3405',1321,1,21,12,123,'A','2016-01-25 08:34:55.000000'),(7,1,100,2,'com.CodeProject.TelecomunicationApp.ChargingReply@d5fafa6','com.CodeProject.TelecomunicationApp.ChargingRequest@5dc5333',1321,1,21,12,123,'A','2016-01-25 08:34:55.000000');
/*!40000 ALTER TABLE `cdr` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-30  0:50:11
