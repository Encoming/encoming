/*
SQLyog Ultimate v9.63 
MySQL - 5.1.66-community : Database - encoming
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`encoming` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `encoming`;

/*Table structure for table `administrator` */

DROP TABLE IF EXISTS `administrator`;

CREATE TABLE `administrator` (
  `idAdministrator` int(11) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `Person_idPerson` int(11) DEFAULT NULL,
  PRIMARY KEY (`idAdministrator`),
  KEY `FK_administrator_Person_idPerson` (`Person_idPerson`),
  CONSTRAINT `FK_administrator_Person_idPerson` FOREIGN KEY (`Person_idPerson`) REFERENCES `person` (`idPerson`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `administrator` */

LOCK TABLES `administrator` WRITE;

insert  into `administrator`(`idAdministrator`,`password`,`username`,`Person_idPerson`) values (1001,'admin','admin',1034786695);

UNLOCK TABLES;

/*Table structure for table `driver` */

DROP TABLE IF EXISTS `driver`;

CREATE TABLE `driver` (
  `idDriver` int(11) NOT NULL,
  `license` varchar(255) DEFAULT NULL,
  `Person_idPerson` int(11) DEFAULT NULL,
  PRIMARY KEY (`idDriver`),
  KEY `FK_driver_Person_idPerson` (`Person_idPerson`),
  CONSTRAINT `FK_driver_Person_idPerson` FOREIGN KEY (`Person_idPerson`) REFERENCES `person` (`idPerson`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `driver` */

LOCK TABLES `driver` WRITE;

insert  into `driver`(`idDriver`,`license`,`Person_idPerson`) values (1,'800988',102435675),(2,'888998',107658896),(3,'7778765',109856734);

UNLOCK TABLES;

/*Table structure for table `encoming` */

DROP TABLE IF EXISTS `encoming`;

CREATE TABLE `encoming` (
  `idPackage` int(11) NOT NULL AUTO_INCREMENT,
  `priority` varchar(255) DEFAULT NULL,
  `received_packet` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `volume` varchar(255) DEFAULT NULL,
  `weight` float DEFAULT NULL,
  PRIMARY KEY (`idPackage`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `encoming` */

LOCK TABLES `encoming` WRITE;

insert  into `encoming`(`idPackage`,`priority`,`received_packet`,`type`,`volume`,`weight`) values (1,'Alta','30/11/2012  11:38:20  AM','Caja','12',23);

UNLOCK TABLES;

/*Table structure for table `invoice` */

DROP TABLE IF EXISTS `invoice`;

CREATE TABLE `invoice` (
  `idInvoice` int(11) NOT NULL AUTO_INCREMENT,
  `moment` date DEFAULT NULL,
  `receiver` varchar(255) DEFAULT NULL,
  `sender` varchar(255) DEFAULT NULL,
  `Package_idPackage` int(11) DEFAULT NULL,
  `Shipping_idShipping` int(11) DEFAULT NULL,
  PRIMARY KEY (`idInvoice`),
  KEY `FK_Invoice_Shipping_idShipping` (`Shipping_idShipping`),
  KEY `FK_Invoice_Package_idPackage` (`Package_idPackage`),
  CONSTRAINT `FK_Invoice_Package_idPackage` FOREIGN KEY (`Package_idPackage`) REFERENCES `encoming` (`idPackage`),
  CONSTRAINT `FK_Invoice_Shipping_idShipping` FOREIGN KEY (`Shipping_idShipping`) REFERENCES `shipping` (`idShipping`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `invoice` */

LOCK TABLES `invoice` WRITE;

insert  into `invoice`(`idInvoice`,`moment`,`receiver`,`sender`,`Package_idPackage`,`Shipping_idShipping`) values (1,'2012-11-30','Sandra','camilo',1,1);

UNLOCK TABLES;

/*Table structure for table `person` */

DROP TABLE IF EXISTS `person`;

CREATE TABLE `person` (
  `idPerson` int(11) NOT NULL,
  `adress` varchar(255) DEFAULT NULL,
  `lastanames` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPerson`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `person` */

LOCK TABLES `person` WRITE;

insert  into `person`(`idPerson`,`adress`,`lastanames`,`mail`,`name`,`phone`) values (102365434,'calle 16 n 78 9','hernandez','camilo@gmail.com','camilo',4774843),(102435675,'calle 67 n 78 09','gonzales','jaime@gmail.com','jame',NULL),(106734552,'cll 19 n 168 90','Jimenez','sandraa@gmail.com','Sandra',4554216),(107658896,'calle 78 n 09 09','Rodriguez','danielrodri@gmail.com','Daniel',NULL),(109856734,'carrera 34 n 8 09','Duque','marlondu@hotmail.com','Marlon',NULL),(1034786695,'calle 93 n 15 67','Prieto','nicoprieto@gmail.com','Nicolas',7566346);

UNLOCK TABLES;

/*Table structure for table `point` */

DROP TABLE IF EXISTS `point`;

CREATE TABLE `point` (
  `idPoint` int(11) NOT NULL AUTO_INCREMENT,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `route` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPoint`),
  KEY `FK_Point_route` (`route`),
  CONSTRAINT `FK_Point_route` FOREIGN KEY (`route`) REFERENCES `route` (`idRoute`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `point` */

LOCK TABLES `point` WRITE;

insert  into `point`(`idPoint`,`latitude`,`longitude`,`name`,`route`) values (1,4.64646260741007,-74.0786393510644,'campin',NULL),(2,4.61352562603273,-74.1051610338036,'puente aranda',NULL),(3,4.55767264588146,-74.1216103249462,'molinos',NULL),(4,4.58363941718723,-74.1415230446728,'fatima',NULL);

UNLOCK TABLES;

/*Table structure for table `route` */

DROP TABLE IF EXISTS `route`;

CREATE TABLE `route` (
  `idRoute` int(11) NOT NULL AUTO_INCREMENT,
  `numberKilometers` double DEFAULT NULL,
  `DESTINATIONPOINT_idPoint` int(11) DEFAULT NULL,
  `ORIGINPOINT_idPoint` int(11) DEFAULT NULL,
  PRIMARY KEY (`idRoute`),
  KEY `FK_route_DESTINATIONPOINT_idPoint` (`DESTINATIONPOINT_idPoint`),
  KEY `FK_route_ORIGINPOINT_idPoint` (`ORIGINPOINT_idPoint`),
  CONSTRAINT `FK_route_ORIGINPOINT_idPoint` FOREIGN KEY (`ORIGINPOINT_idPoint`) REFERENCES `point` (`idPoint`),
  CONSTRAINT `FK_route_DESTINATIONPOINT_idPoint` FOREIGN KEY (`DESTINATIONPOINT_idPoint`) REFERENCES `point` (`idPoint`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `route` */

LOCK TABLES `route` WRITE;

insert  into `route`(`idRoute`,`numberKilometers`,`DESTINATIONPOINT_idPoint`,`ORIGINPOINT_idPoint`) values (1,-1,3,1);

UNLOCK TABLES;

/*Table structure for table `shipping` */

DROP TABLE IF EXISTS `shipping`;

CREATE TABLE `shipping` (
  `idShipping` int(11) NOT NULL AUTO_INCREMENT,
  `arrivedDate` varchar(255) DEFAULT NULL,
  `cost` double DEFAULT NULL,
  `idReceiver` int(11) DEFAULT NULL,
  `sendedDate` varchar(255) DEFAULT NULL,
  `Package_idPackage` int(11) DEFAULT NULL,
  `Person_idPerson` int(11) DEFAULT NULL,
  `Route_idRoute` int(11) DEFAULT NULL,
  `Vehicle_idVehicle` int(11) DEFAULT NULL,
  PRIMARY KEY (`idShipping`),
  KEY `FK_Shipping_Package_idPackage` (`Package_idPackage`),
  KEY `FK_Shipping_Vehicle_idVehicle` (`Vehicle_idVehicle`),
  KEY `FK_Shipping_Person_idPerson` (`Person_idPerson`),
  KEY `FK_Shipping_Route_idRoute` (`Route_idRoute`),
  CONSTRAINT `FK_Shipping_Route_idRoute` FOREIGN KEY (`Route_idRoute`) REFERENCES `route` (`idRoute`),
  CONSTRAINT `FK_Shipping_Package_idPackage` FOREIGN KEY (`Package_idPackage`) REFERENCES `encoming` (`idPackage`),
  CONSTRAINT `FK_Shipping_Person_idPerson` FOREIGN KEY (`Person_idPerson`) REFERENCES `person` (`idPerson`),
  CONSTRAINT `FK_Shipping_Vehicle_idVehicle` FOREIGN KEY (`Vehicle_idVehicle`) REFERENCES `vehicle` (`idVehicle`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `shipping` */

LOCK TABLES `shipping` WRITE;

insert  into `shipping`(`idShipping`,`arrivedDate`,`cost`,`idReceiver`,`sendedDate`,`Package_idPackage`,`Person_idPerson`,`Route_idRoute`,`Vehicle_idVehicle`) values (1,NULL,25.76,106734552,NULL,1,102365434,1,2);

UNLOCK TABLES;

/*Table structure for table `vehicle` */

DROP TABLE IF EXISTS `vehicle`;

CREATE TABLE `vehicle` (
  `idVehicle` int(11) NOT NULL AUTO_INCREMENT,
  `capacity` varchar(255) DEFAULT NULL,
  `destinationCity` varchar(255) DEFAULT NULL,
  `manufacturer` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `plateLetters` varchar(255) DEFAULT NULL,
  `plateNumber` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `Driver_idDriver` int(11) DEFAULT NULL,
  `Point_idPoint` int(11) DEFAULT NULL,
  PRIMARY KEY (`idVehicle`),
  KEY `FK_Vehicle_Point_idPoint` (`Point_idPoint`),
  KEY `FK_Vehicle_Driver_idDriver` (`Driver_idDriver`),
  CONSTRAINT `FK_Vehicle_Driver_idDriver` FOREIGN KEY (`Driver_idDriver`) REFERENCES `driver` (`idDriver`),
  CONSTRAINT `FK_Vehicle_Point_idPoint` FOREIGN KEY (`Point_idPoint`) REFERENCES `point` (`idPoint`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `vehicle` */

LOCK TABLES `vehicle` WRITE;

insert  into `vehicle`(`idVehicle`,`capacity`,`destinationCity`,`manufacturer`,`model`,`plateLetters`,`plateNumber`,`status`,`type`,`Driver_idDriver`,`Point_idPoint`) values (1,'3 Ton',NULL,'Baw','2005','abc',123,'Disponible','Camioneta',1,4),(2,'3 Ton',NULL,'Mazda','2013','fff',999,'Disponible','Camioneta',1,1),(3,'3 Ton',NULL,'Land Rover','2013','ven',243,'Disponible','Reparto',2,3),(4,'3 Ton',NULL,'Beijing','2010','vui',453,'Disponible','Furgon',3,2);

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
