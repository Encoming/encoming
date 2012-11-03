SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `encoming` DEFAULT CHARACTER SET latin1 ;
USE `encoming` ;

-- -----------------------------------------------------
-- Table `encoming`.`Person`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `encoming`.`Person` (
  `idPerson` INT(10) UNSIGNED NOT NULL ,
  `name` VARCHAR(25) NOT NULL ,
  `lastanames` VARCHAR(25) NOT NULL ,
  `mail` VARCHAR(30) NULL DEFAULT NULL ,
  `phone` INT(11) NULL DEFAULT NULL ,
  `adress` VARCHAR(25) NULL DEFAULT NULL ,
  PRIMARY KEY (`idPerson`) ,
  UNIQUE INDEX `document_UNIQUE` (`idPerson` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `encoming`.`Administrator`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `encoming`.`Administrator` (
  `idAdministrator` INT(11) NOT NULL ,
  `username` VARCHAR(20) NOT NULL ,
  `password` VARCHAR(30) NOT NULL ,
  `Person_idPerson` INT(10) UNSIGNED NOT NULL ,
  PRIMARY KEY (`idAdministrator`) ,
  INDEX `fk_Administrator_Person1_idx` (`Person_idPerson` ASC) ,
  CONSTRAINT `fk_Administrator_Person1`
    FOREIGN KEY (`Person_idPerson` )
    REFERENCES `encoming`.`Person` (`idPerson` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `encoming`.`Client`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `encoming`.`Client` (
  `idClient` INT(11) NOT NULL ,
  `sendedEncoming` INT(11) NOT NULL ,
  `receivedEncoming` INT(11) NOT NULL ,
  `person` INT(10) UNSIGNED NOT NULL ,
  PRIMARY KEY (`idClient`) ,
  INDEX `fk_Client_Person1_idx` (`person` ASC) ,
  CONSTRAINT `fk_Client_Person1`
    FOREIGN KEY (`person` )
    REFERENCES `encoming`.`Person` (`idPerson` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `encoming`.`Driver`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `encoming`.`Driver` (
  `idDriver` INT(11) NOT NULL ,
  `license` VARCHAR(20) NOT NULL ,
  `Person_idPerson` INT(10) UNSIGNED NOT NULL ,
  PRIMARY KEY (`idDriver`) ,
  INDEX `fk_Driver_Person1_idx` (`Person_idPerson` ASC) ,
  CONSTRAINT `fk_Driver_Person1`
    FOREIGN KEY (`Person_idPerson` )
    REFERENCES `encoming`.`Person` (`idPerson` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `encoming`.`Route`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `encoming`.`Route` (
  `idRoute` INT(11) NOT NULL ,
  `numberKilometers` INT(11) NOT NULL ,
  `numberTolls` INT(11) NOT NULL ,
  PRIMARY KEY (`idRoute`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `encoming`.`Point`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `encoming`.`Point` (
  `idPoint` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `route` INT(11) NULL DEFAULT NULL ,
  `latitude` DOUBLE NOT NULL ,
  `longitude` DOUBLE NOT NULL ,
  PRIMARY KEY (`idPoint`) ,
  UNIQUE INDEX `idPoint_UNIQUE` (`idPoint` ASC) ,
  INDEX `fk_Point_Route1_idx` (`route` ASC) ,
  CONSTRAINT `fk_Point_Route1`
    FOREIGN KEY (`route` )
    REFERENCES `encoming`.`Route` (`idRoute` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 15
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `encoming`.`Vehicle`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `encoming`.`Vehicle` (
  `plateNumber` INT(11) NOT NULL ,
  `plateLetters` VARCHAR(3) NOT NULL ,
  `type` VARCHAR(20) NOT NULL ,
  `manufacturer` VARCHAR(20) NOT NULL ,
  `model` VARCHAR(10) NOT NULL ,
  `capacity` INT(11) NOT NULL ,
  `status` VARCHAR(10) NOT NULL ,
  `driver` INT(11) NOT NULL ,
  `idVehicle` INT(11) NOT NULL ,
  `Point_idPoint` INT(10) UNSIGNED NULL ,
  PRIMARY KEY (`idVehicle`) ,
  INDEX `fk_Vehiculo_Driver1_idx` (`driver` ASC) ,
  INDEX `fk_Vehicle_Point1_idx` (`Point_idPoint` ASC) ,
  CONSTRAINT `fk_Vehiculo_Driver1`
    FOREIGN KEY (`driver` )
    REFERENCES `encoming`.`Driver` (`idDriver` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vehicle_Point1`
    FOREIGN KEY (`Point_idPoint` )
    REFERENCES `encoming`.`Point` (`idPoint` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `encoming`.`Encoming`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `encoming`.`Encoming` (
  `idEncoming` INT(11) NOT NULL ,
  `type` VARCHAR(30) NOT NULL ,
  `volume` VARCHAR(20) NOT NULL ,
  `priority` VARCHAR(10) NOT NULL ,
  `origin` VARCHAR(15) NOT NULL ,
  `destiny` VARCHAR(15) NOT NULL ,
  `route` INT(11) NOT NULL ,
  `client` INT(11) NOT NULL ,
  `Vehicle_idVehicle` INT(11) NOT NULL ,
  PRIMARY KEY (`idEncoming`) ,
  INDEX `fk_Encomienda_Route1_idx` (`route` ASC) ,
  INDEX `fk_Encomienda_Client1_idx` (`client` ASC) ,
  INDEX `fk_Encoming_Vehicle1_idx` (`Vehicle_idVehicle` ASC) ,
  CONSTRAINT `fk_Encomienda_Client1`
    FOREIGN KEY (`client` )
    REFERENCES `encoming`.`Client` (`idClient` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Encomienda_Route1`
    FOREIGN KEY (`route` )
    REFERENCES `encoming`.`Route` (`idRoute` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Encoming_Vehicle1`
    FOREIGN KEY (`Vehicle_idVehicle` )
    REFERENCES `encoming`.`Vehicle` (`idVehicle` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COMMENT = '\n';


-- -----------------------------------------------------
-- Table `encoming`.`Invoice`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `encoming`.`Invoice` (
  `idInvoice` INT(11) NOT NULL ,
  `sender` VARCHAR(40) NOT NULL ,
  `receiver` VARCHAR(40) NOT NULL ,
  `moment` DATE NOT NULL ,
  `encoming` INT(11) NOT NULL ,
  PRIMARY KEY (`idInvoice`) ,
  INDEX `fk_Invoice_Encoming1_idx` (`encoming` ASC) ,
  CONSTRAINT `fk_Invoice_Encoming1`
    FOREIGN KEY (`encoming` )
    REFERENCES `encoming`.`Encoming` (`idEncoming` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
