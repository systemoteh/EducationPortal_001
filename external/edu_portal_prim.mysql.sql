CREATE DATABASE  IF NOT EXISTS `edu_portal_prim` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `edu_portal_prim`;
-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: edu_portal_prim
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
  `image` varchar(50) NOT NULL DEFAULT 'course.png',
  `description` text NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `course_name_eng_uindex` (`name_eng`),
  UNIQUE KEY `course_name_rus_uindex` (`name_rus`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'T-SQL','T-SQL','sql','course.png',''),(2,'Java','Java','java','course.png',''),(3,'PostgreSQL','PostgreSQL','postgresql','course.png','PostgreSQL'),(4,'MySQL','MySQL','mysql','course.png','MySQL');
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
  `course_id` int(11) NOT NULL DEFAULT '1',
  `order_by` int(11) NOT NULL,
  `name_eng` varchar(50) NOT NULL,
  `name_rus` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `conspectus` mediumtext,
  `test_type_id` int(11) NOT NULL DEFAULT '1',
  `cost` int(11) NOT NULL DEFAULT '50',
  `link` varchar(50) NOT NULL DEFAULT 'intro',
  `image` varchar(50) NOT NULL DEFAULT 'lecture.png',
  `description` text NOT NULL,
  PRIMARY KEY (`course_id`,`order_by`),
  UNIQUE KEY `lecture_name_eng_uindex` (`name_eng`),
  UNIQUE KEY `lecture_name_rus_uindex` (`name_rus`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `lecture_course_id_fk` (`course_id`),
  KEY `lecture_test_id_fk_idx` (`test_type_id`),
  CONSTRAINT `lecture_course_id_fk` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`),
  CONSTRAINT `lecture_test_type_id_fk` FOREIGN KEY (`test_type_id`) REFERENCES `test_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lecture`
--

LOCK TABLES `lecture` WRITE;
/*!40000 ALTER TABLE `lecture` DISABLE KEYS */;
INSERT INTO `lecture` VALUES (9,1,0,'sql-intro','sql-intro','<h1><sup>d</sup><sub>d</sub></h1>',1,200,'sql-intro','lecture.png','sql-intro'),(1,1,1,'sql lecture 01','sql 1',NULL,1,50,'sql-lecture-01','lecture.png',''),(2,1,2,'sql lecture 02','sql 2',NULL,1,50,'sql-lecture-02','lecture.png',''),(10,2,0,'java-intro','java-intro',NULL,1,50,'java-intro','lecture.png','java-intro'),(6,2,1,'java lecture 01','java lecture 01',NULL,1,50,'java-lecture-01','lecture.png','java lecture 01'),(7,2,2,'java lecture 02','java lecture 02',NULL,1,50,'java-lecture-02','lecture.png','java lecture 02');
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
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name_eng` varchar(45) NOT NULL,
  `name_rus` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`,`name_eng`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='Statuses for courses, lectures, tests';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (1,'Blocked','Заблокировано'),(2,'Unblocked','Разблокировано'),(3,'Finished','Завершено');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lecture_id` int(11) NOT NULL DEFAULT '1',
  `order_by` int(11) NOT NULL,
  `type_id` int(11) NOT NULL,
  `name_eng` varchar(50) NOT NULL,
  `name_rus` varchar(50) NOT NULL,
  `task` mediumtext NOT NULL,
  `solution` mediumtext,
  PRIMARY KEY (`lecture_id`,`order_by`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `test_test_type_id_idx` (`type_id`),
  KEY `test_lecture_id_fk_idx` (`lecture_id`),
  CONSTRAINT `test_lecture_id_fk` FOREIGN KEY (`lecture_id`) REFERENCES `lecture` (`id`),
  CONSTRAINT `test_test_type_id_fk` FOREIGN KEY (`type_id`) REFERENCES `test_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='The values of the order_by column start with 0';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` VALUES (1,1,0,1,'sql 01 - 1','select 01','sql 01 - 1','select * from employee'),(2,1,1,1,'sql 01 - 2','select 02','sql 01 - 2',NULL),(3,1,2,1,'sql 01 - 3','java 01','sql 01 - 3',NULL),(4,2,0,1,'sql 02 - 1','sql','sql 02 - 1',NULL),(5,2,1,1,'sql 02 - 2','sql','sql 02 - 2',NULL),(6,2,2,1,'sql 02 - 3','sql','sql 02 - 3',NULL),(14,6,0,1,'java lecture 01 - 01','java lecture 01 - 01','java lecture 01 - 01',NULL),(15,6,1,1,'java lecture 01 - 02','java lecture 01 - 02','java lecture 01 - 02',NULL),(16,6,2,1,'java lecture 01 - 03','java lecture 01 - 03','java lecture 01 - 03',NULL),(17,7,0,1,'java lecture 02 - 01','java lecture 02 - 01','java lecture 02 - 01',NULL),(18,7,1,1,'java lecture 02 - 02','java lecture 02 - 02','java lecture 02 - 02',NULL),(19,7,2,1,'java lecture 02 - 03','java lecture 02 - 03','java lecture 02 - 03',NULL),(7,9,0,1,'sql-intro - 1','sql','sql-intro - 1',NULL),(8,9,1,1,'sql-intro - 2','sql','sql-intro - 2',NULL),(9,9,2,1,'sql-intro - 3','sql','sql-intro - 3',NULL),(11,10,0,1,'java-intro - 1','java-intro - 1','java-intro - 1',NULL),(12,10,1,1,'java-intro - 2','java-intro - 2','java-intro - 2',NULL),(13,10,2,1,'java-intro - 3','java-intro - 3','java-intro - 3',NULL);
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test_type`
--

DROP TABLE IF EXISTS `test_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `test_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test_type`
--

LOCK TABLES `test_type` WRITE;
/*!40000 ALTER TABLE `test_type` DISABLE KEYS */;
INSERT INTO `test_type` VALUES (1,'select');
/*!40000 ALTER TABLE `test_type` ENABLE KEYS */;
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
-- Table structure for table `user___course`
--

DROP TABLE IF EXISTS `user___course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user___course` (
  `user_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `certificate` blob,
  PRIMARY KEY (`user_id`,`course_id`),
  KEY `user___course_course_id_idx` (`course_id`),
  CONSTRAINT `user___course_course_id` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user___course_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user___course`
--

LOCK TABLES `user___course` WRITE;
/*!40000 ALTER TABLE `user___course` DISABLE KEYS */;
INSERT INTO `user___course` VALUES (1,1,NULL),(1,2,NULL),(2,1,NULL),(2,2,NULL);
/*!40000 ALTER TABLE `user___course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user___lecture`
--

DROP TABLE IF EXISTS `user___lecture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user___lecture` (
  `user_id` int(11) NOT NULL,
  `lecture_id` int(11) NOT NULL,
  `status_id` int(11) NOT NULL DEFAULT '2',
  `rating` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`lecture_id`),
  KEY `user_lecture-lecture_fk_idx` (`lecture_id`),
  KEY `user___lecture_status_fk_idx` (`status_id`),
  CONSTRAINT `user___lecture_lecture_fk` FOREIGN KEY (`lecture_id`) REFERENCES `lecture` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user___lecture_status_fk` FOREIGN KEY (`status_id`) REFERENCES `status` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `user___lecture_user_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user___lecture`
--

LOCK TABLES `user___lecture` WRITE;
/*!40000 ALTER TABLE `user___lecture` DISABLE KEYS */;
INSERT INTO `user___lecture` VALUES (1,1,2,NULL),(1,2,2,NULL),(1,6,2,NULL),(1,7,2,NULL),(1,9,2,NULL),(1,10,2,NULL),(2,1,2,NULL),(2,9,2,NULL);
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
  PRIMARY KEY (`user_id`,`role_id`),
  UNIQUE KEY `user_id` (`user_id`,`role_id`),
  KEY `user___role_ibfk_2` (`role_id`),
  CONSTRAINT `user___role_role_id_fk` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user___role_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
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
-- Table structure for table `user___test`
--

DROP TABLE IF EXISTS `user___test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user___test` (
  `user_id` int(11) NOT NULL,
  `test_id` int(11) NOT NULL,
  `user_solution` mediumtext,
  `date_solution` datetime DEFAULT NULL,
  `status_id` int(11) DEFAULT '2',
  PRIMARY KEY (`user_id`,`test_id`),
  KEY `user___test_user_id_fk_idx` (`user_id`),
  KEY `user___test_test_id_fk_idx` (`test_id`),
  KEY `user___test_status_id_fk_idx` (`status_id`),
  CONSTRAINT `user___test_status_id_fk` FOREIGN KEY (`status_id`) REFERENCES `status` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `user___test_test_id_fk` FOREIGN KEY (`test_id`) REFERENCES `test` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user___test_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user___test`
--

LOCK TABLES `user___test` WRITE;
/*!40000 ALTER TABLE `user___test` DISABLE KEYS */;
INSERT INTO `user___test` VALUES (1,1,NULL,NULL,2),(1,2,NULL,NULL,2),(1,3,NULL,NULL,2),(1,4,NULL,NULL,2),(1,5,NULL,NULL,2),(1,6,NULL,NULL,2),(1,7,'SELECT * FROM employee \nWHERE id > 20 AND id < 30\nORDER BY first_name',NULL,2),(1,8,'    \n\n\n\n\n\nДОКУМЕНТАЦИЯ\nРАЗРАБОТЧИКА\n\n\n\n\n0. Серверная часть (SV26)\n\"0 часть\" - серверная часть (https://clients.netlab.ru:443). Код, с помощью которого desktop клиент обращается к базе данных SQL. Также используется и для веб версии (модули nldealer-model и nldealer-services нужно подкладывать в проект).\n\nПуть: находится на сервере SV26. С:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\nldealer.war\n\nСборка серверной части\n•	В Maven выполнить ‘Clean’.\n•	Собирается вся серверная часть через Maven nldealer-server (root) командой install.\n•	В каждой серверной части (dao, services, core, model, hessian и просто в корне) есть свой pom.xml. В каждом таком pom.xml в двух местах в начале есть  <version>1.7.130</version> \n•	Всего нужно поменять в шести (6) pom.xml по два раза, т.е. 12 раз нужно изменить версию на единичку серверной части.\n•	После этого не забыть поменять в pom.xml для Nldealer client и NLdealer web в pom.xml соответствующую строчку на новую версию. Иначе приложение не увидит изменения в серверной части. \n•	Файл, который мы выкладываем на 26 сервер, находится \\nldealer-server\\nldealer-hessian\\target\\nldealer.war. Нужен только этот.\n\nLauncher (SV26)\nНа момент написания,  верный путь –\nSV26-lob.netlab.ru:v \\glassfish3\\glassfish\\domains\\domain1\\applications\\JWebStart2\\nldealer\n\nВнимание: при обновлении лаунчера, его лучше не обновлять на клиенте, это ни на что не влияет, а только может сломать обновление. Подписанный лаунчер важен только для JWebStart на 26 сервере. Их нужно собрать, отдельно подписать и положить в репозиторий под новой версией. Затем эти лаунчеры упаковываются в war файл приложения JWebStart и разворачиваются на 26 сервере. \n*по идее можно просто положить подписанные лаунчеры в нужное место и не останавливать сервер и не менять JWebStart, но его лучше заготовить на всякий случай\n\n\n3. Клиентская часть DESKTOP (SV16/SV10)\n\"3я часть\" - desktop Java клиент. Тот, который устанавливается, как отдельное приложение.\n\nВАЖНО: Конкретно на моем компьютере после перехода на другую версию Идеи проект перестал сам ребилдиться, после сборки мавеном. Обязательно перед обновлением версии, перед тем как собрать, нужно сделать clean – build (с закомментаренными ресурсами в пом файле) - install\n\nПуть:\nNLDealer: SV16 > C:\\www\\nldealer\\update\nNorbelClient: SV10 > С:\\www\\norbelclient\\update.  \n*Еще есть аналогичная папка на сайте www.norbel.ru/norbelclient/update. \nДокументация находится на сервере SV16. C:\\www\\nldealer\\docs \n\n-Сборка 3й версии\nВыполнить команду maven clean\npom.xml:\nВ самом начале поменять\n<version>3.0.215</version>\n<name>nldealer-client-3.0.215</name>\n\nЧуть ниже есть надпись:\n\n   <!--Для сборки проекта, должны быть все закомментированы. Для запуска версии NLDealer раскоментировать NLDealer, для Norbel - включить resources-NorbelClient\nИспользуется при подключении к локальному серверу, см dependent_config.properties -->\n\n   <!--<resource>-->\n  	<!--<directory>${basedir}/src/main/resources-NLDealer</directory>-->\n   <!--</resource>-->\n\n            \n    <!--<resource>-->\n     <!--<directory>${basedir}/src/main/resources-NorbelClient</directory>-->\n    <!--</resource>-->\n\nТак и оставить - для сборки проекта (команда install для maven) нужно чтобы ресурсы были закоментированы. В результате будет создано две папки NLDealer и Norbel в \\target\\. Именно их содержимое нужно выкладывать для обновления версий в каталоги C:\\www\\nldealer\\update  (или norbelclient\\update), указанные выше в начале.\n\nЛокально разрабатываемая третья часть (desktop клиент) может подключаться как к локально развернутому серверу (в другом окне среды разработки) либо к основному (тот, к которому клиенты подключаются и он онлайн). Это настраивается в \nsrc/main/resources-NLDealer или src/main/resources-NorbelClient в dependent_config.properties:\n\nЕсли это раскоментировать, то будет покдлючаться к локально развернутому серверу.\n#for local tomcat\n#server.url1=https://localhost/nldealer/remoting\n#server.url2=https://localhost/nldealer/remoting\n\nЭто означает что будет подключаться к основной базе\nserver.url1=https://clients.netlab.ru/nldealer/remoting\nserver.url2=https://clients1.netlab.ru/nldealer/remoting\n\n\nПри обновлении версии у клиента выскакивает окошко \"Что нового\". Это указывается в changelog_netlab.html и description_netlab.html (для норбела в changelog_netlab.html и description_norbel.html).\n\nОБЯЗАТЕЛЬНО ДЕЛАТЬ БЭКАП	\n\n4. WEB версия (SV28/SV23)\n\"4я часть\" - Web версия.\nNLDealer: https://web-nld.netlab.ru/\nНаходится на сервере SV28 (ранее в SV22). С:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\nldealer.war (не в папке webapps)*. \nNorbel: https://client.norbel.ru/\nНаходится на сервере SV23. C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\nldealer.war (не в папке webapps)*.\n*настройка что загружается не из папки webapps лежит в С:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\conf\\Catalina\\localhost\\Root.xml\n\nВажно: перед обновлением делать ребилд проекта и проверять на локальном томакте, тот ли тип получился на выходе.\n-Сборка 4й версии \nВ целом всё аналогично 3й.\nОсобенности:\nв pom.xml поменять \n<project.title>nldealer online 4.74</project.title>\nДалее com/resources/nldealer/configs.properties и com/resources/norbelclient/configs.properties поменять\nprojectTitle=NLDealer online 4.74\nprojectVersion=4.74  --вот это используется в базе данных в таблице dealers.NLDealerAuthorizationLog и параметр обязательно должен быть 4.% (на 4ю версию проверяется при авторизации).\n\nВ зависимости от того что здесь ниже будет раскоментировано будет собираться либо NLdealer web, либо NorbelClient web. Назваться файлы в target\\ будут одинаков - nldealer.war.\n<resource>\n<directory>src\\main\\resources\\com\\resources\\nldealer</directory>\n</resource>\n\n                <!--<resource>-->\n                 <!--<directory>src\\main\\resources\\com\\resources\\norbelclient</directory>-->\n                <!--</resource>-->\n\nЗдесь так же есть \"Что нового\". Находится в файле whatNewsEntities.xhtml.\nПри обновлении всегда чистить папку webapps\n\nВажно!!!: На 23 сервере, где расположен client.norbel установлена только java7, поэтому собирать проект нужно на 7-ой или не будет работать библиотека, выводящая pdf документа. Как вариант установить java8 на 23 сервер.\n\nОБЯЗАТЕЛЬНО ДЕЛАТЬ БЭКАП	\n\nВеб-сервисы/API (SV21)\n\"Веб-сервисы. API\"\nМы предоставлением несколько видов интеграции: выгрузка прайсов (xml), находятся на s004; Restful (json и xml ответы) и SOAP веб-сервисы (xml ответы)\n\nДокументация находится на сервере SV16. C:\\www\\nldealer\\docs\nhttp://www.netlab.ru/nldealer/docs/web_services_netlab_how_to_start.pdf\nhttp://www.netlab.ru/nldealer/docs/IntegrationGuide.pdf\nhttp://www.netlab.ru/nldealer/docs/web_services_netlab_documentation_1.0.pdf\n\nПриложение Java находится на сервере SV21.\nC:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\nlservices.war\n\nДля изменения подключения к основной/тестовой БД нужно поменять в файле\napplicationContext.xml :\n\n<bean id=\"nlprim\" parent=\"parentDataSource\">\n        <!--<property name=\"url\" value=\"jdbc:jtds:sqlserver://nlprim:1433/NL_DB\"/>-->\n        <property name=\"url\" value=\"jdbc:jtds:sqlserver://S008-LOB:1433/NL_DB\"/>\n    </bean>\n \n    <bean id=\"nlprim_dealers\" parent=\"parentDataSource\">\n        <!--<property name=\"url\" value=\"jdbc:jtds:sqlserver://nlprim:1433/Dealers\"/>-->\n        <property name=\"url\" value=\"jdbc:jtds:sqlserver://S008-LOB:1433/Dealers\"/>\n    </bean>\n\nОБЯЗАТЕЛЬНО ДЕЛАТЬ БЭКАП	\n\nПрайс-генераторы и выгрузки на www.norbel.ru (S004/013)\nВсё генерируется на S004/S013. Названия папок отражают их содержимое (XLS_PG – Прайс-генератор XLS формата, XML_DPG4 – Прайс-генератор XML с 4-уровневой иерархией и т.п.).\nКак они создаются. В каждом генераторе есть папка lib\\generator.jar. Он запускается с помощью run.bat (внутри указано какой config.xml файл брать). Что именно запрашивать находится в папке config (обычно есть config.xml и data.xml). \nДля создания xml или xls файлов используется Apache Velocity (шаблонизатор). Сами шаблоны находятся в папке templates (расширение .vm). Правятся они просто с помощью текстового редактора.\nJava приложение \'generator.jar\' находится\\компилируется в SVN в папках price-generator2. \nНо для генерации .xlsx документов использовать xls_pg src папку (код java). Vip и обычные xlsx генераторы не отличаются, там просто запросы разные в config.xml\\data.xml.\nЭти документы создаются на s004/005, архивируются (иногда переименовываются) и потом переносятся на другие сервера (sv16, папка www/products) . Как известно Макарову Виктору.\n\nВажно!\nВсе прайсы и выгрузки можно протестировать и сгенерировать на локальном компьютере, либо в идее, либо запустив bat-ник.\nНужно обратить внимание, что при локальном запуске со своей машины генератор прайсов нельзя, чтобы в run.bat запускалась процедура \"set ansi_nulls on set ansi_warnings on exec nl_db.dbo.spXML_For_VIPDealers\" -U PriceGen002 -S nlprim -P 11-13-PG002\nДанная процедура обновляет таблицу цен, из которой и берется информация для формирования прайс-листов. Ее можно закомментировать оператором rem.\nНа локальной машине нужно вообще ее удалить и запускать в .bat что-то вроде\njava -jar -Xmx1536m lib\\generator.jar > \"logs/lastLog.txt\". Как пример:\n \nГотовые прайс-листы и выгрузки после переноса находятся на sv16/www/products.\nВыгрузка на норбел – это файл norbel_site.xml. Генерится на s004 XML_NORBEL_SRV.\n\n\nПодробное описание генерируемых файлов\nXLS_PG – (s004) – генерируются обычные прайсы в формате xls\nXLS_SPECIAL – (s004) – какие-то спец файлы\nXLS_VIPPG – (s013) – генерируются прайсы для вип клиентов в формате xls (в файле data.xml нужно задавать новых клиентов, если им нужны прайсы.\n\n<select id=\"Parameters\" resultClass=\"java.util.HashMap\">\n        select P1 as id, name, company, URL, Telephone, EMail, FileName, rate4 as usdRate\n        from vXML_Header_For_VIPDealers\n		where P1 IN (100105427, 100109099, 100100520, \n				100112323, 100112602, 100125579,\n				100126466, 100143230, 114944, 152518,\n				100202206, 100121439, 100154533) \n    </select>\n\nВажно: прайс генерится только на группу организаций, а не на конкретную\n\nXLSX_100205879 – (s013) – спец прайс для ключевого клиента в формате xlsx\n\nXLSX_PG – (s004) – обычные прайсы в формате xlsx\n\nXLSX_VIPPG – (s013) – прайсы для вип клиентов. Также нужно заносить новых в файл data.xml\n\nXML_Compatible – (s013) – какой-то файл конфигурации в формате xml\n\nXML_Competera – (s013) – аналогично\n\nXML_DPG – (s004) – трёхуровневый прайс xml\n\nXML_DPG4 – (s004) – четырёхуровневый прайс xml (отличается наличием дополнительной категории посередине)\n\nXML_GM – (s013) - файлы для Computer Market в формате xml\nXML_GP – (s004) – описания товаров к xml прайсам в формате xml\n\nXML_GP_NORBEL – (s004) – описания к товарам для Norbel  вформате xml\n\nXML_NORBEL_RS – (s004) – какая-то выгрузка для Norbel\n\nXML_NORBEL_SRV – (s013) – основные выгрузки для Norbel и YML файлы\n\nXML_PG… - (s013) – файлы для Computer Market\n\nXML_VENDOR – (s013) – файлы с производителями \n\nXML_VIPPG – (s013) – вип прайсы в формате xml. Также нужно добавлять в список новых клиентов, кому нужен прайс. \n\nНа запуск все эти прайсы ставит Макаров Виктор. В папке config должны содержаться 4 файла (config.xml – в нём указываются какие запросы выполнять, какой шаблон использовать, какие параметры и информация о выходном файле; data.xml – содержится информация о запросах, log4j.properties – логирование; SqlMapConfig – задаются настройки подключения к БД и путь к файлу data.xml) В папке lib находятся необходимые для генерации библиотеки. Папка лог хранит в себе логи генерации файлов. В папку res кладутся сгенерированные файлы. В папке templates содержаться шаблоны. Блокнотовский файл с именем типа PriceGen005 обозначает какой «пользователь» запускает процедуры в БД. Это также видно в файле SqlMapConfig.xml. Файл run.bat содержит в себе настройки запуска генератора. Для xml/xls генератора можно задать параметры внутри .bat файла.\n\nОсобенности сборки и разработки NLDealer\\Norbel\n\n-Подключение к тестовой или основной базе данных.\nПри запуске Tomcat ищется файл в корне диска С:\\\\config.properties. В нем указано к какой базе данных будет подключаться приложение, какое количество соединений разрешено и др.\nТаким образом, чтобы подключить локально развернутый сервер к базе данных (основной или тестовой, через среду разработки) (серверная часть - \"0я\"), нужно в C:\\\\config.properties выбрать в первых двух вхождениях \"основной\" или \"тестовый\" сервер. При такой записи как ниже будет подключаться к тестовой базе.\n#branch.center.jdbc.url=jdbc:jtds:sqlserver://nlprim:1433/NL_DB \nbranch.center.jdbc.url=jdbc:jtds:sqlserver://S008-LOB:1433/NL_DB\nА так к основной.\nbranch.center.jdbc.url=jdbc:jtds:sqlserver://nlprim:1433/NL_DB \n#branch.center.jdbc.url=jdbc:jtds:sqlserver://S008-LOB:1433/NL_DB\n\nЛокально разрабатываемая третья часть (desktop клиент) может подключаться как к локально развернутому серверу (в другом окне среды разработки) либо к основному (тот, к которому клиенты подключаются и он онлайн). Это настраивается в \nsrc/main/resources-NLDealer или src/main/resources-NorbelClient в dependent_config.properties:\n\nЕсли это раскоментировать, то будет покдлючаться к локально развернутому серверу.\n#for local tomcat\n#server.url1=https://localhost/nldealer/remoting\n#server.url2=https://localhost/nldealer/remoting\n\nЭто означает что будет подключаться к основной базе\nserver.url1=https://clients.netlab.ru/nldealer/remoting\nserver.url2=https://clients1.netlab.ru/nldealer/remoting\n\nКак запустить в Intellij IDEA desktop-клиент показано в папке C:\\projects\\Netlab\\nldealer-client\\nlDealer-troubleshooting\\IntelliJ IDEA settings.\n\nОсобенности работы с базой\nПосле обновления базы данных будет ошибка при входе с дочернего пользователя\nServer \'NLPRIM\' is not configured for RPC. Нужно:\nВ процедуре  NL_DB. spWEB_CheckPassword\nстрочку\nNLPRIM.Dealers.dbo.spCheckPassword \nпоменять имя на\nDealers.dbo.spCheckPassword\n\nПри попытке создать дочерние учетки будет ошибка. Необходимо \nВ базе Dealers, процедура [dbo].[spNLDealerClientUsers]\nУдалить NLPRIM	(Dealers почти никогда не обновляется!!!)\n--Проверка на основном сервере\n		exec @r = NLPRIM.NL_DB.dbo.spWEBNLDealerCheckNewLogin @login, @password, @msg output;\n\nОсновные таблицы (процедура)\nНастройки колонок пользователя в каталоге:\n\nNLDealerTableSettings       (spNLDealerSettings)\n\nПрава пользователя (для добавления новых кнопок в меню, как пример):\n\ndbo.ClientObjects         (spGetUserPermission)\n\nНастройки Tomcat\n-Настройки Tomcat 7.0.7 для Nldealer и Norbel web.\nTomcat был установлен с помощью exe. Поэтому в его настройки вызываются через меню пуск Configure Tomcat Properties. Если у кого-то нет этого файла, то он находится по пути \"C:\\Users\\VinnikN\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Apache Tomcat 7.0 Tomcat7\" \nи запускает по ярлыку:\ntarget: \"C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\bin\\Tomcat7w.exe\" //ES//Tomcat7\n(Устанавливать через RPC)\n\nПосле запуска в окне \"Apache Tomcat 7.0 Properties\" открыть вкладку Java.\nJava Options:\n-Dcatalina.home=C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0 \n-Dcatalina.base=C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0 \n-Djava.endorsed.dirs=C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\endorsed \n-Djava.io.tmpdir=C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\temp \n-Djava.util.logging.manager=org.apache.juli.ClassLoaderLogManager \n-Djava.util.logging.config.file=C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\conf\\logging.properties \n-Xms1024m \n-Xmx1536m \n-XX:MaxPermSize=256M \n-XX:PermSize=256M \n-XX:+DisableExplicitGC \n\nВАЖНО: в начале марта Веб версия НЛДилера начала класть томкат и зависать. Была увеличина оперативная память до 8 Гб и самое важное, изменены настройки выделяемой памяти и сборщика мусора сервера на:\n\n-Dcatalina.home=C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\n-Dcatalina.base=C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\n-Djava.endorsed.dirs=C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\endorsed\n-Djava.io.tmpdir=C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\temp\n-Djava.util.logging.manager=org.apache.juli.ClassLoaderLogManager\n-Djava.util.logging.config.file=C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\conf\\logging.properties\n-Xms2048m\n-Xmx6048m\n-XX:MaxPermSize=1024M\n-XX:PermSize=1024M\n-XX:+UseTLAB\n-XX:+UseConcMarkSweepGC\n-XX:+CMSClassUnloadingEnabled\n\nВажны параметры запуска (от  -Xms1024m до -XX:+DisableExplicitGC).\nВАЖНО! Параметры Initial memory pool, Maximum mermory pool, Thread stack trace - оставить незаполненными! \n\nProgram files\\Apache Sowtware Foundation\n1) В это папке необходимо положить nldealer_fonts (arial.TTF, arial_W7.ttf, arialbd.TTF, arialbd_W7.ttf). Используются при печати.\n2) В папку bin положить tomcat-native (tcnative-1.dll, tcnative-1-src.pdb). Нужны для повышения производительности и работы с SSL и сетью. (смотреть разрядность)\n3) Добавить папку cert с сертификатом. Путь к нему прописывается в conf\\server.xml\n4) настройки в server.xml:\n  <Connector port=\"8080\" protocol=\"HTTP/1.1\" \n  connectionTimeout=\"20000\" \n  redirectPort=\"443\" /> \n\n  <Connector port=\"80\" protocol=\"HTTP/1.1\" \n  connectionTimeout=\"20000\" \n  redirectPort=\"443\" /> \n\n <Connector protocol=\"org.apache.coyote.http11.Http11Protocol\" port=\"443\" SSLEnabled=\"true\" \n  maxThreads=\"150\" scheme=\"https\" secure=\"true\" \n  clientAuth=\"false\" sslProtocol=\"TLS\" \n  keystoreFile=\"C:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\cert\\webnldstore2016\" \nkeyAlias=\"tomcat\" \n  keystorePass=\"netlabkeypassword567\" \n  compression=\"on\" compressionMinSize=\"1024\" compressableMimeType=\"text/html,text/xml,text/javascript,text/css\" \n  noCompressionUserAgents=\"gozilla, traviata\" \n\n/>\nТак же закомментировать\n <!-- <Valve className=\"org.apache.catalina.valves.AccessLogValve\" directory=\"logs\" \n  prefix=\"localhost_access_log.\" suffix=\".txt\" \n  pattern=\"%h %l %u %t &quot;%r&quot; %s %b\" /> \n-->\nЭто уберет логирования любого запроса и действия на сервере. Инфа бесполезная, но нагружается и диск и процессор.\nОстальное стандартное.\n\n5) Настройка что nldealer.war загружается не из папки webapps лежит в С:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\conf\\Catalina\\localhost\\Root.xml.\nЭто позволяет в браузере не вбивать лишний путь вроде https://web-nld.netlab.ru/nldealer/faces/common/login.xhtml, а использовать\nhttps://web-nld.netlab.ru/faces/common/login.xhtml\n\n* Сертификат нужен, если HTTP. Всегда делать back up!\n\nБекапы и софт\n\nБекапы и софт разных версий (старых) находится в Departments (у меня диск J) в папке PRG\\DevSoft.\n\nПодключение к тестовой базе проектов\n\nНа диске С на локальном компьютере (и на удаленных серверах 23 и 28) есть файл config.properties. В нем указаны параметры подключения к базе. Тестовая база есть только для branch.center.name=Бусиново: branch.center.jdbc.url=jdbc:jtds:sqlserver://S008-LOB:1433/NL_DB\nИ для branch.centerDealers.name=centerDealers:\nbranch.centerDealers.jdbc.url=jdbc:jtds:sqlserver://S008-LOB:1433/Dealers\nВНИМАНИЕ!!! Для следующих баз тестовых нет. \nbranch.nlntPD.name=nlntPD\nbranch.kurskaya.name=Бауманская\nbranch.kaluzhskaya.name=Профсоюзная\nЭто значит, что если в NLDealer сменить филиал c Бусиново, то работа с документами будет вестись на основной базе.\n\nНастройка проектов в среде IntellijIDEA\n\nПоскольку для старта работы с проектами их нужно загрузить из SVN, возможна такая проблема, что при открытии нового проекта в среде IntellijIDEA, русские символы преобразуются в иероглифы. Поскольку в базе есть один класс, в котором эти слова ставятся в соответствие с тем, что приходит из базы, ломается вкладка документов на клиенте. Класс на сервере CatalogType. Посмотреть, что проблема связана с ним, можно, зайдя в него через клиент и увидев иероглифы вместо слов «Прайс-лист», «Новинки» и т.д.\n\nРешение проблемы:\n\nВ 3 версии нужно указать класс main и в Run Maven Goal выбрать ‘process-resources’\n\n \n\n\nВыставить на клиенте вот такие кодировки:\n\n \n\nНа сервере выбрать Tomcat 7.0.41 с библиотекой внутри spring-tomcat-weaver.jar\nВАЖНО! на машине А любая другая версия 8.0.27 и аналоги – НЕ ЗАПУСКАЮТСЯ (точнее деплоится, но 3-я к нему не подключается.\nИ настроить конфигурацию развертывания war-ника\n \n \n\nКодировки на сервере:\n\n \n\nПроблема с кодировкой в целом:\nПри создании проекта в IntelliJIDEA кодировка в классах может отличаться от той, в которой они сохранены в SVN, вследствие чего, все русские символы превращаются в иероглифы. Для решения данной проблемы, необходимо зайти в SVN, посмотреть какая кодировка стоит у сохраненного класса и поставить такую же в Идее. Затем полностью скопировать текст файла из SVN в проект.\n\n\n \nПодробное описание работы методов клиент-серверной части и процедур \n1.	NLdealer 3.*\n1.1	Получение полей описания пользователя:\n	Описание:\n	Класс:\n	SQL:\n1.2	etc\n1.3	etc \n2.	NLdealer 4.*\n3.	NLservices\n \n4.	PriceGenerator’s\n	PriceGenerators – проект, который получает из базы описание товаров, дочерних и основных категорий, после чего генерируется документ формата xls, xlsx, xml – зависит все от наименования генератора и шаблона.\n	Генераторы расположены на двух серверах, называются в соответствие с типом возвращаемого результата (формат файла).\n4.1	Price generator: XLSX-PG\nДанный генератор, через файл sql-config устанавливает соединение с nlprim/NL_DB.\nОбрабатываются селект:\n- получение рутовых категорий\n	ifXML_For_Dealers(#id#, #templateId#)\n- получение дочерних категорий \n	from ifXML_For_Dealers(#id#, #templateId#) \n	as a inner join ifXML_For_Dealers(#id#, #templateId#)\n- получение товаров\n	from ifXML_For_Dealers(#id#, #templateId#)\n- получение уцененных товаров \n	from vWEBS02 as a\n	    inner join vWEBS02 as b on a.ParentSID = b.SID\n	    inner join vWEBS02 as c on b.ParentSID = c.SID\n4.2	Price generator: XLS-PG\n\n \n5.	Установка настроек для пользователей дочерних учетных записей.\nНа примере задачи # 880 из Redmine рассмотрим каким образом возможно добавить дополнительные настройки для дочерних учетных записей. \nЦель: Для дочерних учетных записей ограничить видимость колонок «Категории цен» в таблицах «Каталог», «Поиск» и «Совместимое оборудование». Только одну из категорий цен возможно предоставить пользователю для видимости.\n5.1	На клиентской части проекта \nВ классе ClientUserViewPanel добавим несколько графических элементов (JLabel и JComboBox):\nВ теле класса объявляем переменные:\nprivate javax.swing.JLabel lPriceType; \nprivate javax.swing.JComboBox cbPriceType;\n\nВ методе initComponents() инициализируем их и заполним значениями:\nlPriceType = new JLabel();  \ncbPriceType = new JComboBox();\n\nlPriceType.setText(Dictionary.getString(\"ClientUserViewPanel.priceCategory\"));\ncbPriceType.setModel(new DefaultComboBoxModel(new String[]{Dictionary.getString(\"ClientUserViewPanel.nonPriceType\"),\n        Dictionary.getString(\"CatalogPanel.catB\"),\n        Dictionary.getString(\"CatalogPanel.catC\"),\n        Dictionary.getString(\"CatalogPanel.catD\"),\n        Dictionary.getString(\"CatalogPanel.catE\"),\n        Dictionary.getString(\"CatalogPanel.catF\")}));\n\nОбозначим местоположение на форме среди однотипных и схожих по логике  элементов:\n.addGroup(pPriceLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)\n        .addGroup(pPriceLayout.createSequentialGroup()\n                .addGroup(pPriceLayout.createParallelGroup(GroupLayout.Alignment.LEADING)\n                        .addComponent(lPriceType)   // #880\n                        .addComponent(lPriceTemplate)\n                        .addComponent(lPriceFormat))\n                .addGap(42, 42, 42)\n                .addGroup(pPriceLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)\n                        .addComponent(cbPriceType)  // #880\n                        .addComponent(cbPriceFormat, 0, 250, Short.MAX_VALUE)\n                        .addComponent(cbPriceTemplate, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))\n\n.addGroup(pPriceLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)\n        .addComponent(lPriceType)\n        .addComponent(cbPriceType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))\n.addGap(18, 18, 18)\n\nУстановим значение по умолчанию, при сохранении новой учетной записи:\ncbPriceType.setSelectedItem(model.getUser().getPriceType() != null ? model.getUser().getPriceType() : Dictionary.getString(\"CatalogPanel.catD\"));\n\nТ.к. для всех вновь созданных дочерних учетных записей устанавливается категория цен D, то установим выбранной именно ее. Есть возможность запретить видимость всех категорий цен (значение nonPriceType).\nВ методе lockControls() добавим наш элемент cbPriceType. А в методе saveDocument() добавим значение cbPriceType.getSelectedItem().toString() в качестве предаваемого параметра для model.saveUser(…) .\nТаким образом, мы добились отображения нового выпадающего списка (рис.1)\n \nРис. 1 Добавленные новые элементы  JLabel и JComboBox.\nВ классе ClientUserModel  в методе  saveUser(…) добавим принимаемый параметр String priceType. Установим принимаемое значение в свойствах пользователя:\nuser.setPriceType(priceType); \n\nОбращаем внимание на тот сервис, которые производит сохранение настроек через маппер. В нашем случае это:\nservices.getClientUser1Service().saveUser(parentUser, user);\n\nПрокликивая по цепочке вызываемых методов, мы придем к интерфейсу-мапперу ClientUser1Mapper и его методу saveUser().\n5.2	На серверной части проекта \nВ классе ClientUser добавляем переменную класса, геттер и сеттер к ней:\nprivate String priceType;\n\n public String getPriceType() {\n    return priceType;\n}\n\npublic void setPriceType(String priceType) {\n    this.priceType = priceType;\n}\n\nКласс ClientUser1Mapper в метод saveUser(…) добавляем параметр user.priceType :\n@Results({\n        @Result(column = \"id\", property = \"id\"),\n        @Result(column = \"descript\", property = \"descript\")\n})\n@Select(\"{call spNLDealerClientUsers(#{action},#{parent.uid},#{parent.username},#{parent.password},#{userId}, \" +\n        \"#{user.username},#{user.password},#{user.permissionsLine},#{user.comment},0, #{user.webOnlyInt},\" +\n        \"#{user.wsAllowedInt},#{user.separateDocsInt},#{user.priceFormat},#{priceRanges},#{user.clientOrganisationUid},\" +\n        \"#{user.priceType})}\")\n@Options(statementType = StatementType.CALLABLE)\npublic List<ClientUsersResult> saveUser(@Param(\"action\") String action, @Param(\"parent\") User parent, @Param(\"user\") ClientUser user, @Param(\"priceRanges\") String priceRanges, @Param(\"userId\") String userId);\n\nТак же в метод getUsers(…) устанавливаем переменную, принимающую результат запроса: \n@Select(\"{call spNLDealerClientUsers(0, #{user.uid}, #{user.username}, #{user.password})}\")\n@Results({\n        @Result(column = \"user_id\", property = \"uid\"),\n        @Result(column = \"username\", property = \"username\"),\n        @Result(column = \"password\", property = \"password\"),\n        @Result(column = \"descr\", property = \"comment\"),\n        @Result(column = \"ws_enabled\", property = \"wsAllowed\"),\n        @Result(column = \"separate_docs\", property = \"separateDocs\"),\n        @Result(column = \"web_only\", property = \"webOnly\"),\n        @Result(column = \"price_format\", property = \"priceFormat\"),\n        @Result(column = \"clientOrganisation\", property = \"clientOrganisationUid\"),\n        @Result(column = \"price_type\", property = \"priceType\")\n})\n@Options(statementType = StatementType.CALLABLE)\npublic List<ClientUser> getUsers(@Param(\"user\") User user);\n\n5.3	На SQL сервере \nВ таблицу ClientUsers добавим новое поле price_type типа varchar(50).\nВ процедуре spNLDealerClientUsers добавляем новую переменную price_type. Всего слово price_type упоминается 6 раз:  объявление, в SELECT, в UPDATE 2 раза и в INSERT 2 раза.\nТаким образом, мы добились сохранения и получения значения priceType из базы данных как признак дочерней учетной записи для отображения при создании/редактировании этой учетной записи.\nТеперь займемся реализацией получения значения priceType как часть прав дочерней учетной записи при аунтификации пользователя под этой учетной записью.\n5.4  На SQL сервере \nВ процедуре spGetUserPermissions добавляем переменную @price_type varchar(50) = null output. Всего слово price_type упоминается 3 раза:  объявление и в SELECT 2 раза.\n5.5	На серверной части проекта \nВ классе UserMapper в методе spGetUserPermissions добавляем параметр priceType:\n@Results({\n        @Result(column = \"id\", property = \"id\" ),\n        @Result(column = \"descript\", property = \"descript\" )\n})\n@Select(\"{call spGetUserPermissions(#{user.username},#{user.password}, \" +\n        \"#{user.clientUserId,mode=OUT,jdbcType=INTEGER,javaType=java.lang.Integer}, \" +\n        \"#{user.clientSeparateDocs,mode=OUT,jdbcType=INTEGER,javaType=java.lang.Integer}, \" +\n        \"#{user.clientPriceFormat,mode=OUT,jdbcType=VARCHAR,javaType=java.lang.String}, #{user.uid},\" +\n        \"#{user.clientOrganisationUid,mode=OUT,jdbcType=INTEGER,javaType=java.lang.Integer},\" +\n        \"#{user.priceType,mode=OUT,jdbcType=VARCHAR,javaType=java.lang.String})}\"  // #880\n)\n\nВ классе User добавить переменную класса priceType (геттер и сеттер):\nprivate String priceType;\nВ классе IBatisUserDao в методе getInfo(…) добавить строку:\ninfo.setPriceType(user.getPriceType());\n\nВ классе UserAdapter в конструкторе класса добавить строку:\nsuper.setPriceType(user.getPriceType());\n\nВ классе AuthenticationServiceHessian в методе authenticate (…) добавить строку:\nuser.setPriceType(info.getPriceType());\nТаким образом, мы добились  получения значения priceType из базы данных как часть прав дочерней учетной записи при аунтификации пользователя под этой учетной записью.\nТеперь займемся реализацией фильтрования всех колонок «Категория цен» на основе данных, которые приходят из базы данных в переменной priceType.\n5.6	На клиентской части проекта \nВ классе NLDealerCatalogTable в методе updateColumns(…) делаем проверку и добавляем метод hidePriceCategory(…):\nif (user.getPriceType() != null) {  // for child users only one PriceType column\n    hidePriceCategory(name);\n}\n\npublic void hidePriceCategory(String name) {\n    String[] priceTypes = {Dictionary.getString(\"CatalogPanel.catB\"),\n            Dictionary.getString(\"CatalogPanel.catC\"),\n            Dictionary.getString(\"CatalogPanel.catD\"),\n            Dictionary.getString(\"CatalogPanel.catE\"),\n            Dictionary.getString(\"CatalogPanel.catF\")};\n\n    for (String priceType : priceTypes) {\n        if (name.equals(priceType) && !user.getPriceType().equals(name)) {\n            hideColumn(name);\n        }\n    }\n\n}\n\n Это скроет отличные от значения priceType колонки с категориями цен в таблице «Каталог».\nВ классе NLCatalogTable в методе acceptColumnSetting (…) делаем проверку и добавляем метод hidePriceCategory(…):\nif (user.getPriceType() != null) {  // for child users only one PriceType column\n    hidePriceCategory(column, user);\n}\n\npublic void hidePriceCategory(ColumnSettings column, User user) {\n    String[] priceTypes = {Dictionary.getString(\"CatalogPanel.catB\"),\n            Dictionary.getString(\"CatalogPanel.catC\"),\n            Dictionary.getString(\"CatalogPanel.catD\"),\n            Dictionary.getString(\"CatalogPanel.catE\"),\n            Dictionary.getString(\"CatalogPanel.catF\")};\n\n    String name = column.getName().getColumnName();\n    TableColumnExt te = getColumnExt(name);\n\n    for (String priceType : priceTypes) {\n        if (name.equals(priceType) && !user.getPriceType().equals(name)) {\n            this.columnModel.removeColumn(te);\n        }\n    }\n}\nНа этом реализация данной задачи закончена.\n',NULL,2),(1,9,NULL,NULL,2),(1,11,NULL,NULL,2),(1,12,NULL,NULL,2),(1,13,NULL,NULL,2),(1,14,NULL,NULL,2),(1,15,NULL,NULL,2),(1,16,NULL,NULL,2),(1,17,NULL,NULL,2),(1,18,NULL,NULL,2),(1,19,NULL,NULL,2),(2,1,NULL,NULL,2),(2,2,NULL,NULL,2),(2,3,NULL,NULL,2),(2,7,NULL,NULL,2),(2,8,NULL,NULL,2),(2,9,NULL,NULL,2);
/*!40000 ALTER TABLE `user___test` ENABLE KEYS */;
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
  `gender` tinyint(1) DEFAULT '0',
  `coins` int(11) NOT NULL DEFAULT '150',
  `experience` int(11) NOT NULL DEFAULT '0',
  `country` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  `first_visit` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_visit` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `e_mail_UNIQUE` (`e_mail`),
  CONSTRAINT `user_detail___user___fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_detail`
--

LOCK TABLES `user_detail` WRITE;
/*!40000 ALTER TABLE `user_detail` DISABLE KEYS */;
INSERT INTO `user_detail` VALUES (1,1,'Alexey','Ogrenich','aleksei_0888@mail.ru','1988-08-15 00:00:00',0,1900,1120,'Russia','Moscow',1,'2018-10-05 16:46:51','2018-10-09 12:54:41'),(2,2,'Ivan','Ivanov','aleksei_0888@mail.ru1','1990-09-17 00:00:00',0,1000,1380,'Byelorussia','Minsk',1,'2018-10-05 16:46:51','2018-10-05 16:46:51'),(5,37,'Alexey','Another','aleksei_0888@gmail.com','1989-08-15 00:00:00',0,60,85,'Russia','Moscow',1,'2018-10-10 10:37:12','2018-10-10 10:37:12'),(6,38,'useruseruser',NULL,NULL,NULL,0,210,85,NULL,NULL,1,'2018-10-10 12:36:39','2018-10-10 12:36:39'),(7,39,'rerwerwerwe',NULL,NULL,NULL,0,210,85,NULL,NULL,1,'2018-10-10 16:28:25','2018-10-10 16:28:25'),(8,40,'gdgdfgdfgdfg','gdgdfgdfgdfg','gdgdfgdfgdfg',NULL,0,210,85,'gdgdfgdfgdfg','gdgdfgdfgdfg',1,'2018-10-11 13:09:24','2018-10-11 13:09:24'),(9,41,'dsddasdqweqweqwdas',NULL,NULL,NULL,0,210,85,NULL,NULL,1,'2018-10-12 11:17:54','2018-10-12 11:17:54');
/*!40000 ALTER TABLE `user_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'edu_portal_prim'
--

--
-- Dumping routines for database 'edu_portal_prim'
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
                                  IN in_e_mail  varchar(45), IN in_gender tinyint(1), IN in_birth_date datetime,
                                  IN in_counrty varchar(45), IN in_city varchar(45), OUT out_result tinyint(1))
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
          gender     = in_gender,
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
    DECLARE temp_lecture_cost INT;
    DECLARE temp_user_id_lecture_id INT;
    DECLARE temp_user_id_test_id INT;
    SET temp_user_coins = 0;
    SET temp_lecture_cost = 1000000;
    SET temp_user_id_lecture_id = 0;
    SET temp_user_id_test_id = 0;
    SET out_result = FALSE;
    SET autocommit = 0;
    START TRANSACTION;
    -- Check whether the database already has such a line
    SELECT COUNT(1)
        INTO temp_user_id_lecture_id
    FROM user___lecture
    WHERE user_id = in_user_id
      AND lecture_id = in_lecture_id;
    -- Check whether the database already has such a line
    SELECT COUNT(1)
        INTO temp_user_id_test_id
    FROM user___test ut
           INNER JOIN test t ON ut.test_id = t.id
    WHERE user_id = in_user_id
      AND t.lecture_id = in_lecture_id;
    SELECT coins
        INTO temp_user_coins FROM user_detail WHERE user_id = in_user_id;
    SELECT cost
        INTO temp_lecture_cost FROM lecture WHERE id = in_lecture_id;
    IF (temp_user_coins >= temp_lecture_cost AND temp_user_id_lecture_id = 0 AND temp_user_id_test_id = 0)
    THEN
      INSERT INTO user___lecture (user_id, lecture_id) VALUES (in_user_id, in_lecture_id);
      INSERT INTO user___test (user_id, test_id) SELECT in_user_id, id FROM test t WHERE t.lecture_id = in_lecture_id;
      UPDATE user_detail SET coins = (temp_user_coins - temp_lecture_cost) WHERE user_id = in_user_id;
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

-- Dump completed on 2018-12-28 18:27:23
