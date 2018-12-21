CREATE DATABASE  IF NOT EXISTS `edu_portal_serv01` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `edu_portal_serv01`;
-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: edu_portal_serv01
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
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employee` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `e_mail` varchar(255) DEFAULT NULL,
  `birth_date` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `salary` varchar(255) DEFAULT NULL,
  `experience` varchar(255) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `company_car` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Graiden','Garrett','dui.lectus.rutrum@justoeuarcu.net','1986-09-26 09:55:18','Finances','77000','35','Cyprus','Richmond Hill','Tata Motors'),(2,'Emerald','Joyner','Fusce@ligulaDonecluctus.org','1992-02-11 23:46:42','Public Relations','55000','33','Lithuania','Manukau','MINI'),(3,'Yoshi','Mckenzie','at@congueturpis.net','1970-03-09 03:24:47','Advertising','35000','37','Azerbaijan','Regina','Lexus'),(4,'Colorado','Jones','lorem@lorem.edu','1994-06-24 11:27:41','Media Relations','35000','30','Bhutan','Leicester','GMC'),(5,'Constance','Harrington','sociis@sapien.edu','1978-03-10 16:48:11','Tech Support','65000','7','Tunisia','Morkhoven','Maruti Suzuki'),(6,'Carter','Padilla','Phasellus.nulla.Integer@aultricies.co.uk','1987-09-18 14:20:30','Tech Support','90000','2','Guinea','Pont-ˆ-Celles','Buick'),(7,'Blythe','Holland','vel.turpis@Vestibulumut.org','1977-07-22 15:13:50','Asset Management','60000','14','Swaziland','Alva','Smart'),(8,'Leroy','Graham','sem@mollis.co.uk','1995-07-04 05:19:14','Advertising','27000','16','Lesotho','Baracaldo','Kia Motors'),(9,'Neville','Vega','massa@dolorsitamet.org','1987-05-02 04:55:00','Finances','85000','14','Ecuador','Blois','Renault'),(10,'Daria','Bryan','velit@Proin.com','1962-03-31 01:15:14','Customer Service','70000','6','Ukraine','Ranst','Ferrari'),(11,'Justin','Berry','sagittis.placerat@euismod.ca','1970-12-19 07:06:29','Finances','70000','35','Sao Tome and Principe','Riviere-du-Loup','Audi'),(12,'Channing','Martin','et@mollis.ca','1988-05-01 16:59:36','Public Relations','30000','13','Sierra Leone','Naro','Tata Motors'),(13,'Scott','Fuller','leo@liberoet.com','1960-07-30 20:42:21','Customer Service','85000','3','Algeria','Mores','Isuzu'),(14,'Uta','Patterson','auctor.quis@pede.com','1997-10-29 11:33:21','Research and Development','40000','37','French Guiana','Midnapore','Mercedes-Benz'),(15,'Thomas','Barlow','Aliquam.ultrices@sem.ca','1970-06-04 03:49:17','Tech Support','50000','14','Lebanon','Cuenca','Daimler'),(16,'Ann','Henry','vel@Innec.org','1997-06-02 12:05:23','Finances','80000','35','Palau','PiŽtrain',NULL),(17,'Caryn','Wall','molestie@consequat.com','1998-02-01 13:34:09','Sales and Marketing','70000','3','Belgium','Lochristi','Peugeot'),(18,'Deborah','Lowery','magna.a@etmagnisdis.ca','1976-06-23 21:36:15','Accounting','70000','8','Saudi Arabia','Cour-sur-Heure','Volvo'),(19,'Lisandra','Alvarez','risus.Donec.egestas@lobortisaugue.ca','1964-08-23 06:08:54','Media Relations','42000','18','Samoa','LaSalle','Infiniti'),(20,'Ashton','Mcknight','Nunc@pharetraNam.co.uk','1990-01-02 03:25:30','Accounting','100000','40','Haiti','Słupsk','Jeep'),(21,'Marah','Kim','Suspendisse@egestas.edu','1960-05-06 18:33:05','Public Relations','85000','33','Mali','Campos dos Goytacazes','Daimler'),(22,'Charles','Beasley','adipiscing.enim.mi@orci.net','1994-03-19 07:38:52','Human Resources','54000','15','Samoa','Zwijnaarde','Buick'),(23,'Diana','Huffman','at@mauris.com','1999-11-22 11:00:42','Advertising','10000','1','Philippines','North Bay','Mahindra and Mahindra'),(24,'Colin','Rivas','vestibulum@elitfermentum.com','1999-01-23 22:16:10','Legal Department','51000','6','Czech Republic','North Vancouver','JLR'),(25,'Oscar','Callahan','a.auctor.non@faucibusorci.org','1975-05-28 12:14:09','Finances','55000','30','Anguilla','Louvain-la-Neuve','Infiniti'),(26,'Quincy','Davis','non.enim@quisturpisvitae.com','1998-07-19 10:01:12','Human Resources','75000','40','Nepal','Logroño','Seat'),(27,'Oprah','Peck','venenatis@egestasligula.edu','1992-04-18 03:12:04','Quality Assurance','77000','14','Bulgaria','Gilly','Renault'),(28,'Leigh','Quinn','scelerisque@at.co.uk','1978-07-19 00:29:24','Finances','75000','15','Finland','Belmont','General Motors'),(29,'Chase','Cooley','Vestibulum.ut@viverraMaecenasiaculis.co.uk','1994-12-09 06:56:38','Media Relations','75000','17','Nigeria','Opole','Mahindra and Mahindra'),(30,'Diana','Richards','Mauris@quismassaMauris.net','1979-12-01 06:46:05','Finances','10000','16','Switzerland','Porto Alegre','Volkswagen'),(31,'Neil','Knapp','Quisque.libero.lacus@nibhPhasellus.org','1964-05-28 14:46:58','Sales and Marketing','20000','35','Georgia','Kaster','Porsche'),(32,'Yoko','Rhodes','lacinia@necmollisvitae.ca','1981-11-10 06:15:56','Quality Assurance','47000','1','Georgia','Donosti','Lincoln'),(33,'Athena','Gonzalez','Curabitur.ut.odio@Maecenaslibero.net','1963-04-17 11:56:30','Accounting','77000','33','Iraq','Roksem','Kenworth'),(34,'Julian','Slater','Sed.pharetra@etmalesuadafames.org','1999-02-02 18:40:17','Payroll','45000','2','Gibraltar','New Orleans','Jeep'),(35,'Lamar','Crosby','eleifend.vitae@ipsumdolor.co.uk','1986-06-09 17:02:23','Research and Development','70000','37','Gambia','Gandhinagar','Buick'),(36,'Palmer','Johns','purus.Maecenas.libero@Nunclaoreet.edu','1985-04-18 12:28:13','Quality Assurance','17000','1','Australia','Maple Creek','Hyundai Motors'),(37,'Yolanda','Tyson','amet.faucibus.ut@Intincidunt.edu','1974-08-25 10:54:05','Research and Development','27000','6','Serbia','Loksbergen','Ferrari'),(38,'Yardley','Cain','Mauris@SuspendisseeleifendCras.org','1967-07-09 10:55:24','Finances','50000','14','South Georgia and The South Sandwich Islands','Perk','Vauxhall'),(39,'Taylor','Frye','netus.et.malesuada@consequatnec.ca','1972-10-27 09:47:12','Finances','77000','9','Nigeria','Heist-aan-Zee','Acura'),(40,'Veronica','Young','augue.id.ante@acfeugiat.org','1985-06-06 09:59:15','Customer Relations','65000','30','Holy See (Vatican City State)','Lasnigo','Isuzu'),(41,'Orla','Harmon','amet.risus.Donec@est.net','1994-07-26 02:28:22','Payroll','95000','20','Bhutan','Amqui',NULL),(42,'Lillian','Romero','nisi.Mauris.nulla@pellentesqueSed.co.uk','1981-04-06 05:50:55','Accounting','60000','2','Bangladesh','Ponti','Chrysler'),(43,'Megan','Roman','consectetuer.adipiscing@ornaresagittis.com','1963-08-30 22:19:37','Human Resources','42000','7','Latvia','Arvier','Subaru'),(44,'Sebastian','Meyer','In@Pellentesque.com','1962-01-15 04:02:44','Research and Development','47000','19','Qatar','Newtown','Cadillac'),(45,'Ian','Wolfe','gravida.nunc.sed@fermentum.com','1972-04-02 17:37:34','Quality Assurance','85000','37','Rwanda','Baranello','Infiniti'),(46,'Ryder','Levy','feugiat@magnisdis.net','1961-07-11 10:57:31','Advertising','30000','8','Bulgaria','Glastonbury','Porsche'),(47,'Barclay','Gillespie','lobortis.tellus@maurisrhoncusid.edu','1991-06-30 03:29:54','Research and Development','51000','11','Palestine, State of','Montalto Uffugo','Citroën'),(48,'Grant','Miles','Duis.ac.arcu@dui.edu','1964-02-21 18:42:08','Payroll','30000','13','Mauritius','Hathras','MINI'),(49,'Kylynn','Salazar','mi@habitantmorbi.ca','1971-04-21 13:08:54','Sales and Marketing','85000','16','Antigua and Barbuda','Comeglians','Suzuki'),(50,'Acton','Ortiz','sagittis.lobortis@eunequepellentesque.edu','1984-07-16 17:38:59','Accounting','15000','1','Iceland','Roubaix','Daihatsu'),(51,'Tucker','Griffith','dui.semper.et@nec.com','1962-07-29 07:32:19','Human Resources','12000','25','Singapore','Greenwich','Seat'),(52,'Finn','Jones','lobortis.quis@magnisdis.com','1961-07-30 06:36:11','Payroll','50000','10','Bangladesh','De Haan','Chevrolet'),(53,'Hayley','Nash','leo@dictumultricies.co.uk','1986-06-18 02:48:05','Finances','85000','13','Djibouti','Pictou','RAM Trucks'),(54,'Paul','Leonard','convallis.ligula.Donec@vulputatedui.co.uk','1988-06-01 14:01:52','Payroll','35000','16','Costa Rica','Roxboro','Dongfeng Motor'),(55,'August','Rojas','enim.Nunc.ut@vitaenibh.net','1983-06-21 02:12:56','Accounting','54000','11','Hong Kong','Ettelgem','Renault'),(56,'Ivana','Santana','Cum.sociis.natoque@leo.edu','1995-03-10 21:38:22','Human Resources','54000','11','Portugal','Malartic','Audi'),(57,'Lydia','Weeks','magnis.dis.parturient@Maurismagna.org','1981-11-11 03:36:14','Advertising','85000','6','Guernsey','New Maryland','Jeep'),(58,'Emery','Thomas','dui@lobortismaurisSuspendisse.net','1983-07-06 10:39:18','Asset Management','27000','25','Falkland Islands','CŽroux-Mousty','Mitsubishi Motors'),(59,'Thaddeus','Clemons','pharetra.Nam@semperrutrumFusce.ca','1969-10-09 06:39:00','Quality Assurance','12000','33','Turks and Caicos Islands','Shahjahanpur','Mercedes-Benz'),(60,'Forrest','Rivers','eleifend.vitae.erat@nuncestmollis.co.uk','1981-02-11 09:06:33','Human Resources','100000','6','Kenya','Auldearn','Vauxhall'),(61,'Yoshio','Vazquez','velit.eu.sem@tinciduntvehicularisus.net','1986-03-27 14:14:37','Advertising','100000','1','Bolivia','Çermik',NULL),(62,'Rachel','Young','eget.mollis@apurus.edu','1991-08-18 21:30:13','Human Resources','45000','33','Botswana','Prato Carnico','Chevrolet'),(63,'Jakeem','Hicks','scelerisque@sitametconsectetuer.net','1968-09-26 04:51:06','Asset Management','15000','27','Palestine, State of','Helensburgh',NULL),(64,'Kirby','Bridges','rutrum.urna.nec@tellusjustosit.ca','1983-09-23 17:09:03','Quality Assurance','15000','27','Uzbekistan','Moradabad','Suzuki'),(65,'Joseph','Holden','nec.mollis@tellusnonmagna.edu','1987-05-31 23:34:11','Human Resources','25000','8','Jordan','Brest','Cadillac'),(66,'Hayden','Knowles','Aliquam.tincidunt@adipiscingMauris.edu','1999-08-05 00:48:00','Finances','75000','1','Svalbard and Jan Mayen Islands','Moncrivello','Seat'),(67,'Wanda','Haley','felis.Nulla.tempor@per.ca','1996-06-22 06:37:32','Advertising','80000','27','Albania','Los Muermos','Mercedes-Benz'),(68,'Moses','Taylor','sit@euplacerateget.net','1982-07-19 06:58:52','Quality Assurance','12000','12','Netherlands','Prince George','Infiniti'),(69,'David','Farmer','ipsum.dolor@non.com','1978-04-15 00:41:10','Research and Development','55000','35','Lithuania','Skövde','Volvo'),(70,'Daphne','Mayer','diam@eget.ca','1962-05-13 17:09:19','Asset Management','90000','14','Niger','Groot-Bijgaarden','Subaru'),(71,'Reed','Bartlett','pede.Cras.vulputate@Morbinequetellus.ca','1967-04-24 02:30:05','Media Relations','47000','11','Botswana','Poole','Lexus'),(72,'Miriam','Velasquez','nec@Nullam.ca','1974-03-19 21:37:00','Advertising','85000','15','Turks and Caicos Islands','Kilsyth','Daimler'),(73,'Graiden','Romero','lectus.pede.et@Etiamligula.com','1999-04-18 21:31:27','Finances','10000','13','United Arab Emirates','Bregenz','Vauxhall'),(74,'Athena','Bradshaw','odio.a.purus@Aliquamauctor.com','1968-02-22 18:41:58','Tech Support','25000','30','Botswana','Tiruvottiyur','Seat'),(75,'Noble','Singleton','Praesent.eu.nulla@vitaesodalesnisi.ca','1978-06-29 14:14:38','Advertising','52000','4','Cameroon','Saint-Marcel','MINI'),(76,'Geraldine','Dixon','turpis@eueuismodac.net','1965-10-04 11:22:56','Legal Department','70000','1','United Kingdom (Great Britain)','Pointe-aux-Trembles','Dodge'),(77,'Cherokee','Joseph','odio.semper.cursus@iderat.co.uk','1964-02-13 16:21:24','Public Relations','60000','6','Saint Helena, Ascension and Tristan da Cunha','Alma','Fiat'),(78,'Arthur','Kirkland','mollis.Phasellus@posuereat.edu','1963-10-26 04:30:39','Advertising','40000','4','Sweden','Cetara','Hyundai Motors'),(79,'Madison','Cline','nulla.Cras@ridiculusmus.ca','1997-03-12 12:23:15','Human Resources','65000','6','Australia','Weert','Maruti Suzuki'),(80,'Debra','Guerrero','gravida@etmagnisdis.net','1970-05-05 15:38:20','Customer Service','53000','3','American Samoa','Carleton','RAM Trucks'),(81,'Justin','Wyatt','In@vitaemauris.net','1961-12-15 15:06:38','Customer Service','51000','14','Jamaica','Bulzi','Kia Motors'),(82,'David','Delacruz','ac@sollicitudincommodoipsum.edu','1969-09-14 15:58:44','Legal Department','35000','30','Uzbekistan','Matlock','Dongfeng Motor'),(83,'Rogan','Meadows','magna.malesuada@nullaante.org','1973-02-24 04:13:46','Legal Department','80000','30','Hong Kong','Oteppe','Tata Motors'),(84,'Kerry','Stokes','lobortis.nisi@erosProinultrices.edu','1995-04-04 02:16:09','Customer Service','47000','1','Rwanda','Mobile','Volkswagen'),(85,'Penelope','Jefferson','non.arcu@ligulatortor.co.uk','1980-09-06 00:00:27','Legal Department','65000','14','Zimbabwe','Raurkela','Mahindra and Mahindra'),(86,'Jared','Abbott','Vivamus.nibh@tinciduntaliquamarcu.edu','1984-12-20 11:41:27','Legal Department','75000','37','Bahamas','Homburg','Chrysler'),(87,'Sandra','Valenzuela','in.felis@Proin.edu','1982-04-03 05:35:42','Quality Assurance','45000','11','United States','Kooigem','Volvo'),(88,'Zachery','Keith','Vivamus@molestieorcitincidunt.ca','1973-05-06 23:19:58','Accounting','12000','2','Papua New Guinea','Racine','Lexus'),(89,'Heather','Gross','malesuada@lobortismauris.org','1990-06-19 04:01:03','Human Resources','65000','6','Saint Pierre and Miquelon','Melton','Smart'),(90,'Stewart','Franks','posuere.at@acarcu.net','1976-04-23 00:18:12','Advertising','25000','18','Cook Islands','Alsemberg','Porsche'),(91,'Guy','Gilmore','a.enim.Suspendisse@laoreetlectus.ca','1992-01-19 19:56:35','Customer Service','85000','17','Mexico','Lavacherie','Acura'),(92,'Dane','Kennedy','Maecenas@ornare.org','1985-12-09 18:36:33','Sales and Marketing','51000','13','South Georgia and The South Sandwich Islands','Faridabad','General Motors'),(93,'Francesca','Potts','enim.consequat@felis.net','1970-12-03 23:27:39','Payroll','100000','33','Hong Kong','Ödemiş','Cadillac'),(94,'Sean','Webb','magna@penatibusetmagnis.org','1986-10-27 22:23:39','Asset Management','23000','2','Costa Rica','Villers-le-Peuplier','Dongfeng Motor'),(95,'Vance','Blackburn','enim@felisullamcorper.ca','1997-06-30 05:00:20','Payroll','25000','20','Saint Helena, Ascension and Tristan da Cunha','Branchon','Lexus'),(96,'Elton','Roach','eleifend.Cras.sed@idmollis.net','1978-10-22 14:59:08','Payroll','65000','3','Korea, North','Issy-les-Moulineaux','JLR'),(97,'Meghan','Pittman','sed@risusvariusorci.net','1983-09-15 01:08:46','Asset Management','12000','25','Switzerland','Coltauco','Buick'),(98,'Amaya','Parsons','vel.convallis.in@Duisrisus.ca','1986-08-07 06:53:45','Legal Department','25000','30','Micronesia','Torrejón de Ardoz','Ford'),(99,'Shelly','Strickland','arcu@amet.com','1990-07-11 07:03:21','Asset Management','51000','9','Gambia','Nancagua',NULL),(100,'Elaine','Pugh','egestas.Aliquam@sed.ca','1986-02-01 06:44:39','Finances','15000','33','Colombia','Erode','Renault');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'edu_portal_serv01'
--

--
-- Dumping routines for database 'edu_portal_serv01'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-14 16:26:57
