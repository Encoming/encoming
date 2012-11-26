SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `encoming` ;
CREATE SCHEMA IF NOT EXISTS `encoming` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `encoming` ;

-- -----------------------------------------------------
-- Table `encoming`.`Person`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `encoming`.`Person` (
  `idPerson` INT UNSIGNED NOT NULL ,
  `name` VARCHAR(25) NOT NULL ,
  `lastanames` VARCHAR(25) NOT NULL ,
  `mail` VARCHAR(30) NULL ,
  `phone` INT NULL ,
  `adress` VARCHAR(25) NULL ,
  PRIMARY KEY (`idPerson`) ,
  UNIQUE INDEX `document_UNIQUE` (`idPerson` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `encoming`.`Client`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `encoming`.`Client` (
  `idClient` INT NOT NULL ,
  `sendedEncoming` INT NOT NULL ,
  `receivedEncoming` INT NOT NULL ,
  `Person_idPerson` INT UNSIGNED NOT NULL ,
  PRIMARY KEY (`idClient`) ,
  INDEX `fk_Client_Person1` (`Person_idPerson` ASC) ,
  CONSTRAINT `fk_Client_Person1`
    FOREIGN KEY (`Person_idPerson` )
    REFERENCES `encoming`.`Person` (`idPerson` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `encoming`.`Driver`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `encoming`.`Driver` (
  `idDriver` INT NOT NULL ,
  `license` VARCHAR(20) NOT NULL ,
  `Person_idPerson` INT UNSIGNED NOT NULL ,
  PRIMARY KEY (`idDriver`) ,
  INDEX `fk_Driver_Person1` (`Person_idPerson` ASC) ,
  CONSTRAINT `fk_Driver_Person1`
    FOREIGN KEY (`Person_idPerson` )
    REFERENCES `encoming`.`Person` (`idPerson` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `encoming`.`Administrator`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `encoming`.`Administrator` (
  `idAdministrator` INT NOT NULL ,
  `username` VARCHAR(20) NOT NULL ,
  `password` VARCHAR(30) NOT NULL ,
  `type` VARCHAR(20) NOT NULL ,
  `Person_idPerson` INT UNSIGNED NOT NULL ,
  PRIMARY KEY (`idAdministrator`) ,
  INDEX `fk_Administrator_Person1` (`Person_idPerson` ASC) ,
  CONSTRAINT `fk_Administrator_Person1`
    FOREIGN KEY (`Person_idPerson` )
    REFERENCES `encoming`.`Person` (`idPerson` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `encoming`.`Vehicle`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `encoming`.`Vehicle` (
  `plateNumber` INT NOT NULL ,
  `plateLetters` VARCHAR(3) NOT NULL ,
  `type` VARCHAR(20) NOT NULL ,
  `manufacturer` VARCHAR(20) NOT NULL ,
  `model` VARCHAR(10) NOT NULL ,
  `capacity` INT NOT NULL ,
  `status` VARCHAR(10) NOT NULL ,
  `Driver_idDriver` INT NOT NULL ,
  INDEX `fk_Vehicle_Driver1` (`Driver_idDriver` ASC) ,
  PRIMARY KEY (`plateNumber`, `plateLetters`) ,
  CONSTRAINT `fk_Vehicle_Driver1`
    FOREIGN KEY (`Driver_idDriver` )
    REFERENCES `encoming`.`Driver` (`idDriver` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `encoming`.`Route`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `encoming`.`Route` (
  `idRoute` INT NOT NULL ,
  `numberKilometers` INT NOT NULL ,
  `numberTolls` INT NOT NULL ,
  `destinationCity` VARCHAR(20) NOT NULL ,
  `originCity` VARCHAR(20) NOT NULL ,
  PRIMARY KEY (`idRoute`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `encoming`.`Package`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `encoming`.`Package` (
  `idPackage` INT NOT NULL AUTO_INCREMENT ,
  `type` VARCHAR(20) NOT NULL ,
  `volume` VARCHAR(20) NOT NULL ,
  `priority` VARCHAR(10) NOT NULL ,
  `weight` FLOAT NOT NULL ,
  PRIMARY KEY (`idPackage`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `encoming`.`Shipping`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `encoming`.`Shipping` (
  `idShipping` INT NOT NULL ,
  `idReceiver` INT NOT NULL ,
  `Client_idClient` INT NOT NULL ,
  `Vehicle_plateNumber` INT NOT NULL ,
  `Vehicle_plateLetters` VARCHAR(3) NOT NULL ,
  `Package_idPackage` INT NOT NULL ,
  `Route_idRoute` INT NOT NULL ,
  `sendedDate` DATETIME NOT NULL ,
  `arrivedDate` DATETIME NOT NULL ,
  PRIMARY KEY (`idShipping`) ,
  INDEX `fk_Shipping_Client1` (`Client_idClient` ASC) ,
  INDEX `fk_Shipping_Vehicle1` (`Vehicle_plateNumber` ASC, `Vehicle_plateLetters` ASC) ,
  INDEX `fk_Shipping_Package1` (`Package_idPackage` ASC) ,
  INDEX `fk_Shipping_Route1` (`Route_idRoute` ASC) ,
  CONSTRAINT `fk_Shipping_Client1`
    FOREIGN KEY (`Client_idClient` )
    REFERENCES `encoming`.`Client` (`idClient` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Shipping_Vehicle1`
    FOREIGN KEY (`Vehicle_plateNumber` , `Vehicle_plateLetters` )
    REFERENCES `encoming`.`Vehicle` (`plateNumber` , `plateLetters` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Shipping_Package1`
    FOREIGN KEY (`Package_idPackage` )
    REFERENCES `encoming`.`Package` (`idPackage` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Shipping_Route1`
    FOREIGN KEY (`Route_idRoute` )
    REFERENCES `encoming`.`Route` (`idRoute` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `encoming`.`Invoice`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `encoming`.`Invoice` (
  `idInvoice` INT NOT NULL ,
  `sender` VARCHAR(40) NOT NULL ,
  `receiver` VARCHAR(40) NOT NULL ,
  `moment` DATE NOT NULL ,
  `Package_idPackage` INT NOT NULL ,
  `Shipping_idShipping` INT NOT NULL ,
  PRIMARY KEY (`idInvoice`) ,
  INDEX `fk_Invoice_Package1` (`Package_idPackage` ASC) ,
  INDEX `fk_Invoice_Shipping1` (`Shipping_idShipping` ASC) ,
  CONSTRAINT `fk_Invoice_Package1`
    FOREIGN KEY (`Package_idPackage` )
    REFERENCES `encoming`.`Package` (`idPackage` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Invoice_Shipping1`
    FOREIGN KEY (`Shipping_idShipping` )
    REFERENCES `encoming`.`Shipping` (`idShipping` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `encoming`.`Point`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `encoming`.`Point` (
  `idPoint` INT UNSIGNED NOT NULL ,
  `name` VARCHAR(45) NULL ,
  `route` INT ,
  `latitude` DOUBLE NULL ,
  `longitude` DOUBLE NULL ,
  PRIMARY KEY (`idPoint`) ,
  UNIQUE INDEX `idPoint_UNIQUE` (`idPoint` ASC) ,
  INDEX `fk_Point_Route1` (`rounte` ASC) ,
  CONSTRAINT `fk_Point_Route1`
    FOREIGN KEY (`route` )
    REFERENCES `encoming`.`Route` (`idRoute` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;