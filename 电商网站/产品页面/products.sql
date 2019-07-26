-- MySQL dump 10.13  Distrib 5.6.30, for Win64 (x86_64)
--
-- Host: localhost    Database: cInformation
-- ------------------------------------------------------
-- Server version	5.6.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `id` int(5) NOT NULL,
  `proname` varchar(30) DEFAULT NULL,
  `price` int(5) DEFAULT NULL,
  `proIntro` varchar(200) DEFAULT NULL,
  `numbers` int(10) DEFAULT NULL,
  `pictures` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (0,'DIY',520,'This is a special musix box which is made by our company.',50,'DIYBox.jpg'),(11,'Merry Go Round-1',100,'This is the first merry-go-round music  box of our company.',20,'merryGoRound1.jpg'),(12,'Merry Go Round-2',70,'This is the second merry-go-round music  box of our company.',10,'merryGoRound2.jpg'),(13,'Merry Go Round-3',60,'This is the third merry-go-round music  box of our company.',50,'merryGoRound3.jpg'),(21,'Crystal-1',120,'This is the first crystal music  box of our company.',50,'crystalBox1.jpg'),(22,'Crystal-2',150,'This is the second crystal music  box of our company.',123,'crystalBox2.jpg'),(23,'Crystal-3',100,'This is the third crystal music  box of our company.',56,'crystalBox3.jpg'),(24,'Crystal-4',100,'This is the forth crystal music  box of our company.',521,'crystalBox4.jpg'),(25,'Crystal-5',180,'This is the fifth crystal music  box of our company.',58,'crystalBox5.jpg'),(26,'Crystal-6',80,'This is the sixth crystal music  box of our company.',74,'crystalBox6.jpg'),(31,'Piano-1',100,'This is the first piano music  box of our company.',564,'pianoBox1.jpg'),(32,'Piano-2',130,'This is the second piano music  box of our company.',52,'pianoBox2.jpg'),(33,'Piano-3',80,'This is the third piano music  box of our company.',128,'pianoBox3.jpg'),(34,'Piano-4',60,'This is the forth piano music  box of our company.',95,'pianoBox4.jpg'),(35,'Piano-5',90,'This is the fifth piano music  box of our company.',233,'pianoBox5.jpg'),(36,'Piano-6',88,'This is the sixth piano music  box of our company.',54,'pianoBox6.jpg'),(41,'Carbin-1',88,'This is the first carbin music  box of our company.',46,'cabinBox1.jpg'),(42,'Carbin-2',58,'This is the second carbin music  box of our company.',95,'cabinBox2.jpg'),(43,'Carbin-3',98,'This is the third carbin music  box of our company.',258,'cabinBox3.jpg'),(51,'Wood-1',48,'This is the first wood music  box of our company.',35,'woodBox1.jpg'),(52,'Wood-2',28,'This is the second wood music  box of our company.',68,'woodBox2.jpg'),(53,'Wood-3',68,'This is the third wood music  box of our company.',92,'woodBox3.jpg');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-19  8:08:05
