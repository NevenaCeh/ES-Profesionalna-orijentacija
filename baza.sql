/*
SQLyog Ultimate v11.5 (64 bit)
MySQL - 5.6.17 : Database - proforijentacija
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`proforijentacija` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `proforijentacija`;

/*Table structure for table `ispitanik` */

DROP TABLE IF EXISTS `ispitanik`;

CREATE TABLE `ispitanik` (
  `jmbg` varchar(13) NOT NULL,
  `imePrezime` varchar(30) NOT NULL,
  `prosek` double NOT NULL,
  PRIMARY KEY (`jmbg`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ispitanik` */

insert  into `ispitanik`(`jmbg`,`imePrezime`,`prosek`) values ('1234567891234','test',4);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
