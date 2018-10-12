-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: education_portal
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name_eng` varchar(50) NOT NULL,
  `name_rus` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `link` varchar(50) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `course_name_eng_uindex` (`name_eng`),
  UNIQUE KEY `course_name_rus_uindex` (`name_rus`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'SQL','SQL','sql',''),(2,'Java','Java','java','');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lecture`
--

DROP TABLE IF EXISTS `lecture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lecture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name_eng` varchar(50) NOT NULL,
  `name_rus` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course_id` int(11) NOT NULL,
  `link` varchar(50) DEFAULT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `lecture_name_eng_uindex` (`name_eng`),
  UNIQUE KEY `lecture_name_rus_uindex` (`name_rus`),
  KEY `lecture_course_id_fk` (`course_id`),
  CONSTRAINT `lecture_course_id_fk` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lecture`
--

LOCK TABLES `lecture` WRITE;
/*!40000 ALTER TABLE `lecture` DISABLE KEYS */;
INSERT INTO `lecture` VALUES (1,'sql lecture 01','sql 1',1,'sql-lecture-01',''),(2,'sql lecture 02','sql 2',1,'sql-lecture-02',''),(6,'java lecture 01','java lecture 01',2,'java-lecture-01','java lecture 01'),(7,'java lecture 02','java lecture 02',2,'java-lecture-02','java lecture 02'),(9,'sql-intro','sql-intro',1,'sql-intro','sql-intro'),(10,'java-intro','java-intro',2,'java-intro','java-intro');
/*!40000 ALTER TABLE `lecture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','$2a$04$cMJ4Hhur5MQuyn41MbNRLOuYyhtq5VUucAf8uw0g.CXbjb.jtWWR2'),(2,'user','$2a$04$TA3vJwtPAcBzSXBVUFIRou9qymYuKd.qF97Ia8dc1tzRpTss9roTG'),(37,'useruseruser03','$2a$11$Z3ZiUm/csT/GtrgvnNrBsu/kUDMvVL8SHjbZD22l50e93HZ2wjdwq'),(38,'useruseruser','$2a$11$N2AyAVKC46mujGbZxkEuG.JvRSDmPl07wspl60vQDXI1A12BToA3G'),(39,'rerwerwerwe','$2a$11$51S1FlA0AmyHxFbIkeQa2.pduS3q2nIv7/5YMCNZkngbmOE3Ol3r.'),(40,'gdgdfgdfgdfg','$2a$11$eVrU7ypV5txIN5BTK2Qijech.DZpkBgfxKWRTNkmoYOm51chz.DPy'),(41,'dsddasdqweqweqwdas','$2a$11$1nd5xSZFk.aDmG0jjRfJceWCv5/.m6vKrlVgC2tEeTX4b.V6kZOHy');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `after_insert_user_trigger` AFTER INSERT ON `user` FOR EACH ROW BEGIN
INSERT INTO user_detail (user_id, first_name, last_name, e_mail, birth_date, coins, experience, gender, country, city, enabled, first_visit, last_visit)
VALUES (NEW.id, NEW.username, NULL, NULL, NULL, 150, 0, 0, NULL, NULL, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `user___lecture`
--

DROP TABLE IF EXISTS `user___lecture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user___lecture` (
  `user_id` int(11) NOT NULL,
  `lecture_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`lecture_id`),
  KEY `user_lecture-lecture_fk_idx` (`lecture_id`),
  CONSTRAINT `user_lecture-lecture_fk` FOREIGN KEY (`lecture_id`) REFERENCES `lecture` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_lecture_user_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user___lecture`
--

LOCK TABLES `user___lecture` WRITE;
/*!40000 ALTER TABLE `user___lecture` DISABLE KEYS */;
INSERT INTO `user___lecture` VALUES (1,1),(2,1),(1,2),(1,6),(1,9),(1,10);
/*!40000 ALTER TABLE `user___lecture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user___role`
--

DROP TABLE IF EXISTS `user___role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user___role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  UNIQUE KEY `user_id` (`user_id`,`role_id`),
  KEY `user___role_ibfk_2` (`role_id`),
  CONSTRAINT `user___role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user___role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user___role`
--

LOCK TABLES `user___role` WRITE;
/*!40000 ALTER TABLE `user___role` DISABLE KEYS */;
INSERT INTO `user___role` VALUES (1,1),(2,2),(37,2),(38,2),(39,2),(40,2),(41,2);
/*!40000 ALTER TABLE `user___role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_detail`
--

DROP TABLE IF EXISTS `user_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `e_mail` varchar(45) DEFAULT NULL,
  `birth_date` datetime DEFAULT NULL,
  `coins` int(11) NOT NULL DEFAULT '150',
  `experience` int(11) NOT NULL DEFAULT '0',
  `gender` tinyint(4) DEFAULT '0',
  `country` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '1',
  `first_visit` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_visit` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  UNIQUE KEY `e_mail_UNIQUE` (`e_mail`),
  CONSTRAINT `user_detail___user___fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_detail`
--

LOCK TABLES `user_detail` WRITE;
/*!40000 ALTER TABLE `user_detail` DISABLE KEYS */;
INSERT INTO `user_detail` VALUES (1,1,'Alexey','Ogrenich','aleksei_0888@mail.ru','1988-08-15 00:00:00',910,0,0,'Russia','Moscow',1,'2018-10-05 16:46:51','2018-10-09 12:54:41'),(2,2,'Ivan','Ivanov','aleksei_0888@mail.ru1','1990-09-17 00:00:00',120,85,0,'Byelorussia','Minsk',1,'2018-10-05 16:46:51','2018-10-05 16:46:51'),(5,37,'Alexey','Another','aleksei_0888@gmail.com','1989-08-15 00:00:00',210,85,0,'Russia','Moscow',1,'2018-10-10 10:37:12','2018-10-10 10:37:12'),(6,38,'useruseruser',NULL,NULL,NULL,210,85,0,NULL,NULL,1,'2018-10-10 12:36:39','2018-10-10 12:36:39'),(7,39,'rerwerwerwe',NULL,NULL,NULL,210,85,0,NULL,NULL,1,'2018-10-10 16:28:25','2018-10-10 16:28:25'),(8,40,'gdgdfgdfgdfg','gdgdfgdfgdfg','gdgdfgdfgdfg',NULL,210,85,0,'gdgdfgdfgdfg','gdgdfgdfgdfg',1,'2018-10-11 13:09:24','2018-10-11 13:09:24'),(9,41,'dsddasdqweqweqwdas',NULL,NULL,NULL,210,85,0,NULL,NULL,1,'2018-10-12 11:17:54','2018-10-12 11:17:54');
/*!40000 ALTER TABLE `user_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'education_portal'
--

--
-- Dumping routines for database 'education_portal'
--
/*!50003 DROP PROCEDURE IF EXISTS `save_user_detail` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `save_user_detail`(IN in_user_id int, IN in_first_name varchar(45), IN in_last_name varchar(45),
                                  IN in_e_mail  varchar(45), IN in_birth_date datetime, IN in_counrty varchar(45),
                                  IN in_city    varchar(45), OUT out_result tinyint(1))
BEGIN
    DECLARE temp_user_id int;
    SET temp_user_id = 0;
    SET out_result = FALSE;
    SET autocommit = 0;
    START TRANSACTION;
    SELECT COUNT(1)
        INTO temp_user_id
    FROM user_detail
    WHERE e_mail = TRIM(in_e_mail)
      AND user_id != in_user_id;
    IF (temp_user_id = 0)
    THEN
      UPDATE user_detail
      SET first_name = in_first_name,
          last_name  = in_last_name,
          e_mail     = in_e_mail,
          birth_date = in_birth_date,
          country    = in_counrty,
          city       = in_city
      WHERE user_id = in_user_id;
      COMMIT;
      SET out_result = true;
    END IF;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `unblock_lecture` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `unblock_lecture`(IN in_user_id int, IN in_lecture_id int, OUT out_result tinyint(1))
BEGIN
    DECLARE temp_user_coins INT(11);
    DECLARE temp_user_id_lecture_id INT;
    SET temp_user_coins = 0;
    SET temp_user_id_lecture_id = 0;
    SET out_result = FALSE;
    SET autocommit = 0;
    START TRANSACTION;
    SELECT coins
        INTO temp_user_coins FROM user_detail WHERE user_id = in_user_id;
    SELECT COUNT(1)
        INTO temp_user_id_lecture_id
    FROM user___lecture
    WHERE user_id = in_user_id
      AND lecture_id = in_lecture_id;
    IF (temp_user_coins >= 30 AND temp_user_id_lecture_id = 0)
    THEN
      UPDATE user_detail SET coins = temp_user_coins - 30 WHERE user_id = in_user_id;
      INSERT INTO user___lecture (user_id, lecture_id) VALUES (in_user_id, in_lecture_id);
      COMMIT;
      SET out_result = true;
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

-- Dump completed on 2018-10-12 18:47:51
