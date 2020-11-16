-- MySQL dump 10.13  Distrib 8.0.22, for Linux (x86_64)
--
-- Host: localhost    Database: cs532
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Equipment`
--

DROP TABLE IF EXISTS `Equipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Equipment` (
  `eqid` int DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `departmentholding` int DEFAULT NULL,
  `ownedleased` varchar(10) DEFAULT NULL,
  `datepurchased` date DEFAULT NULL,
  `termsoflease` varchar(100) DEFAULT NULL,
  `maintenancehistory` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Equipment`
--

LOCK TABLES `Equipment` WRITE;
/*!40000 ALTER TABLE `Equipment` DISABLE KEYS */;
/*!40000 ALTER TABLE `Equipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Events`
--

DROP TABLE IF EXISTS `Events`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Events` (
  `eventid` int NOT NULL,
  `patientid` int DEFAULT NULL,
  `doctorid` int DEFAULT NULL,
  `eventtype` varchar(25) DEFAULT NULL,
  `start` datetime DEFAULT NULL,
  `end` datetime DEFAULT NULL,
  PRIMARY KEY (`eventid`),
  UNIQUE KEY `eventid` (`eventid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Events`
--

LOCK TABLES `Events` WRITE;
/*!40000 ALTER TABLE `Events` DISABLE KEYS */;
INSERT INTO `Events` VALUES (1,1,1,'Routine','2020-12-20 10:30:00','2020-12-20 11:30:00');
/*!40000 ALTER TABLE `Events` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Insurance_Carriers`
--

DROP TABLE IF EXISTS `Insurance_Carriers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Insurance_Carriers` (
  `iid` int DEFAULT NULL,
  `cname` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Insurance_Carriers`
--

LOCK TABLES `Insurance_Carriers` WRITE;
/*!40000 ALTER TABLE `Insurance_Carriers` DISABLE KEYS */;
INSERT INTO `Insurance_Carriers` VALUES (1,'Oregon Insurance','101 Health Dr, Portland OR','Active'),(2,'California Insurance','101 Health Dr, San Diego CA','Active'),(3,'Best Insurance','223 Health Dr, San Diego CA','Active');
/*!40000 ALTER TABLE `Insurance_Carriers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LabOrder`
--

DROP TABLE IF EXISTS `LabOrder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `LabOrder` (
  `eidperformed` int DEFAULT NULL,
  `dateperformed` int DEFAULT NULL,
  `oid` int DEFAULT NULL,
  `pid` int DEFAULT NULL,
  `eid` int DEFAULT NULL,
  `lid` int DEFAULT NULL,
  `labresults` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LabOrder`
--

LOCK TABLES `LabOrder` WRITE;
/*!40000 ALTER TABLE `LabOrder` DISABLE KEYS */;
/*!40000 ALTER TABLE `LabOrder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LabTest`
--

DROP TABLE IF EXISTS `LabTest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `LabTest` (
  `lid` int DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `rangenormalvalues` varchar(20) DEFAULT NULL,
  `rangeurgentvalues` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LabTest`
--

LOCK TABLES `LabTest` WRITE;
/*!40000 ALTER TABLE `LabTest` DISABLE KEYS */;
/*!40000 ALTER TABLE `LabTest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MedicalEncounter`
--

DROP TABLE IF EXISTS `MedicalEncounter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `MedicalEncounter` (
  `dateinput` date DEFAULT NULL,
  `eidinput` int DEFAULT NULL,
  `dateseen` date DEFAULT NULL,
  `eidseen` int DEFAULT NULL,
  `pid` int DEFAULT NULL,
  `sid` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MedicalEncounter`
--

LOCK TABLES `MedicalEncounter` WRITE;
/*!40000 ALTER TABLE `MedicalEncounter` DISABLE KEYS */;
/*!40000 ALTER TABLE `MedicalEncounter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Medications`
--

DROP TABLE IF EXISTS `Medications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Medications` (
  `mid` int DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `dosage` varchar(10) DEFAULT NULL,
  `frequencytaken` varchar(20) DEFAULT NULL,
  `potentialsideeffects` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Medications`
--

LOCK TABLES `Medications` WRITE;
/*!40000 ALTER TABLE `Medications` DISABLE KEYS */;
INSERT INTO `Medications` VALUES (1,'Methodrone','Idk pain relief or smth','50mg','2 times daily','Headaches, Dizzyness, Coughing');
/*!40000 ALTER TABLE `Medications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Patients`
--

DROP TABLE IF EXISTS `Patients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Patients` (
  `pid` int DEFAULT NULL,
  `pfirstname` varchar(30) DEFAULT NULL,
  `plastname` varchar(30) DEFAULT NULL,
  `tnumber` int DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `iid` int DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `pcp` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Patients`
--

LOCK TABLES `Patients` WRITE;
/*!40000 ALTER TABLE `Patients` DISABLE KEYS */;
INSERT INTO `Patients` VALUES (1,'Dom','Skulec',2068509072,'1113 E 7th St, Newberg OR 97132',1,'1998-02-25','male',1),(2,'John','Smith',2064448867,'9987 E 1st St, Townsville CA 90117',1,'2000-07-29','male',1),(3,'Jane','Doe',2065559878,'555 E Street, San Diego CA 92115',2,'2000-05-15','female',2),(4,'Carl','Norton',2065550001,'1000 E 1st St, Portland OR 97105',1,'2000-08-17','male',1),(5,'Krystain','Woods',2065550002,'1001 E 1st St, Portland OR 97105',2,'1999-02-25','female',5),(6,'Katlyn','Galloway',2065550003,'1002 E 1st St, Portland OR 97105',3,'1996-05-24','female',4),(7,'Yousif','Huerta',2065550004,'1003 E 1st St, Portland OR 97105',1,'1992-07-16','male',2),(8,'Zahara','Goodwin',2065550005,'1004 E 1st St, Portland OR 97105',3,'1995-10-10','female',3),(9,'Aroush','Bloggs',2065550006,'1005 E 1st St, Portland OR 97105',2,'2000-12-15','male',5),(10,'Marion','Parry',2065550007,'1006 E 1st St, Portland OR 97105',1,'1999-09-17','female',1),(11,'Leen','Ferreira',2065550008,'1007 E 1st St, Portland OR 97105',3,'1996-10-17','female',4),(12,'Ella','Blundell',2065550009,'1008 E 1st St, Portland OR 97105',2,'2001-05-24','female',2),(13,'Lillian','Clayton',2065550010,'1009 E 1st St, Portland OR 97105',1,'2002-04-16','female',5),(14,'Dion','Bowers',2065550011,'1010 E 1st St, Portland OR 97105',3,'2003-04-17','male',3),(15,'Jaidan','Galloway',2065550012,'1011 E 1st St, Portland OR 97105',2,'2000-11-16','male',5),(16,'Landon','Hutton',2065550013,'1012 E 1st St, Portland OR 97105',1,'2001-09-17','male',4),(17,'Gregory','Dalby',2065550014,'1013 E 1st St, Portland OR 97105',3,'2010-09-19','male',2),(18,'Mike','Forester',2065550015,'1014 E 1st St, Portland OR 97105',2,'2000-06-19','male',4),(19,'Phillip','Fry',2065550016,'1015 E 1st St, Portland OR 97105',3,'2000-04-06','male',1),(20,'Bender','Rodriguez',2065550017,'1016 E 1st St, Portland OR 97105',2,'2005-06-17','male',5);
/*!40000 ALTER TABLE `Patients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Physicians`
--

DROP TABLE IF EXISTS `Physicians`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Physicians` (
  `eid` int DEFAULT NULL,
  `efirstname` varchar(30) DEFAULT NULL,
  `elastname` varchar(30) DEFAULT NULL,
  `cnumber` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Physicians`
--

LOCK TABLES `Physicians` WRITE;
/*!40000 ALTER TABLE `Physicians` DISABLE KEYS */;
INSERT INTO `Physicians` VALUES (1,'David','Doctorson',911),(2,'Denise','Doctorvich',811),(3,'Brandon','Healthi',555911),(4,'Matt','Damon',123456),(5,'Zoid','Berg',3000);
/*!40000 ALTER TABLE `Physicians` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Prescriptions`
--

DROP TABLE IF EXISTS `Prescriptions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Prescriptions` (
  `ptid` int DEFAULT NULL,
  `pid` int DEFAULT NULL,
  `eid` int DEFAULT NULL,
  `mid` int DEFAULT NULL,
  `dosage` varchar(10) DEFAULT NULL,
  `frequencytaken` varchar(20) DEFAULT NULL,
  `datefilled` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Prescriptions`
--

LOCK TABLES `Prescriptions` WRITE;
/*!40000 ALTER TABLE `Prescriptions` DISABLE KEYS */;
INSERT INTO `Prescriptions` VALUES (1,1,1,1,'50mg','2 times daily','2020-10-20');
/*!40000 ALTER TABLE `Prescriptions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Services`
--

DROP TABLE IF EXISTS `Services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Services` (
  `sid` int DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `billablecost` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Services`
--

LOCK TABLES `Services` WRITE;
/*!40000 ALTER TABLE `Services` DISABLE KEYS */;
INSERT INTO `Services` VALUES (1,'Wisdom Teeth Removal',1500);
/*!40000 ALTER TABLE `Services` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-06 16:42:35