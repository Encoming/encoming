SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `Actividad1_7` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `Actividad1_7` ;

-- -----------------------------------------------------
-- Table `Actividad1_7`.`Tipos_Productos`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Actividad1_7`.`Tipos_Productos` (
  `ID` INT(10) NOT NULL ,
  `NOMBRE` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Actividad1_7`.`Productos`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Actividad1_7`.`Productos` (
  `ID` INT(10) NOT NULL ,
  `NOMBRE` VARCHAR(45) NOT NULL ,
  `CANTIDAD` INT(10) NOT NULL ,
  `PRECIO_VENTA` BIGINT(20) NOT NULL ,
  `UNIDAD` VARCHAR(45) NOT NULL ,
  `Tipo_Producto_ID` INT(10) NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `fk_Productos_Tipos_Productos_idx` (`Tipo_Producto_ID` ASC) ,
  CONSTRAINT `fk_Productos_Tipos_Productos`
    FOREIGN KEY (`Tipo_Producto_ID` )
    REFERENCES `Actividad1_7`.`Tipos_Productos` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Actividad1_7`.`Clientes`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Actividad1_7`.`Clientes` (
  `ID` INT(10) NOT NULL ,
  `NOMBRE_COMPLETO` VARCHAR(255) NOT NULL ,
  `DOCUMENTO` VARCHAR(15) NOT NULL ,
  `TELEFONO` INT(10) NOT NULL ,
  `EMAIL` VARCHAR(45) NOT NULL ,
  `TIPO` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Actividad1_7`.`Facturas`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Actividad1_7`.`Facturas` (
  `ID` INT(10) NOT NULL ,
  `FECHA` DATE NOT NULL ,
  `Cliente_ID` INT(10) NOT NULL ,
  PRIMARY KEY (`ID`) ,
  INDEX `fk_Facturas_Clientes1_idx` (`Cliente_ID` ASC) ,
  CONSTRAINT `fk_Facturas_Clientes1`
    FOREIGN KEY (`Cliente_ID` )
    REFERENCES `Actividad1_7`.`Clientes` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Actividad1_7`.`Clientes_Frecuentes`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Actividad1_7`.`Clientes_Frecuentes` (
  `NUM_CUENTA` VARCHAR(45) NOT NULL ,
  `DIRECCION` VARCHAR(45) NOT NULL ,
  `Cliente_ID` INT(10) NOT NULL ,
  INDEX `fk_Clientes_Frecuentes_Clientes1_idx` (`Cliente_ID` ASC) ,
  CONSTRAINT `fk_Clientes_Frecuentes_Clientes1`
    FOREIGN KEY (`Cliente_ID` )
    REFERENCES `Actividad1_7`.`Clientes` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Actividad1_7`.`Materias_Primas`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Actividad1_7`.`Materias_Primas` (
  `ID` INT(10) NOT NULL ,
  `NOMBRE` VARCHAR(45) NOT NULL ,
  `CANTIDAD` INT(10) NOT NULL ,
  `PRECIO` BIGINT(20) NOT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Actividad1_7`.`Facturas_Productos`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Actividad1_7`.`Facturas_Productos` (
  `Factura_ID` INT(10) NOT NULL ,
  `Producto_ID` INT(10) NOT NULL ,
  `cantidad` INT(10) NOT NULL ,
  `Factura_Producto_ID` INT(10) NOT NULL ,
  PRIMARY KEY (`Factura_Producto_ID`) ,
  INDEX `fk_Facturas_has_Productos_Productos1_idx` (`Producto_ID` ASC) ,
  INDEX `fk_Facturas_has_Productos_Facturas1_idx` (`Factura_ID` ASC) ,
  CONSTRAINT `fk_Facturas_has_Productos_Facturas1`
    FOREIGN KEY (`Factura_ID` )
    REFERENCES `Actividad1_7`.`Facturas` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Facturas_has_Productos_Productos1`
    FOREIGN KEY (`Producto_ID` )
    REFERENCES `Actividad1_7`.`Productos` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Actividad1_7`.`Productos_Materias_Primas`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Actividad1_7`.`Productos_Materias_Primas` (
  `Producto_ID` INT(10) NOT NULL ,
  `Materia_Prima_ID` INT(10) NOT NULL ,
  PRIMARY KEY (`Producto_ID`, `Materia_Prima_ID`) ,
  INDEX `fk_Productos_has_Materias_Primas_Materias_Primas1_idx` (`Materia_Prima_ID` ASC) ,
  INDEX `fk_Productos_has_Materias_Primas_Productos1_idx` (`Producto_ID` ASC) ,
  CONSTRAINT `fk_Productos_has_Materias_Primas_Productos1`
    FOREIGN KEY (`Producto_ID` )
    REFERENCES `Actividad1_7`.`Productos` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Productos_has_Materias_Primas_Materias_Primas1`
    FOREIGN KEY (`Materia_Prima_ID` )
    REFERENCES `Actividad1_7`.`Materias_Primas` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Actividad1_7`.`Proveedores`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Actividad1_7`.`Proveedores` (
  `ID` INT(10) NOT NULL ,
  `NOMBRE` VARCHAR(100) NOT NULL ,
  `TELEFONO` VARCHAR(45) NOT NULL ,
  `DIRECCION` VARCHAR(255) NOT NULL ,
  `EMAIL` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Actividad1_7`.`Proveedor_Materia_Prima`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Actividad1_7`.`Proveedor_Materia_Prima` (
  `Proveedor_ID` INT(10) NOT NULL ,
  `Materia_Prima_ID` INT(10) NOT NULL ,
  `precio` INT(10) NOT NULL ,
  `Proveedor_Materia_Prima_ID` INT(10) NOT NULL ,
  PRIMARY KEY (`Proveedor_Materia_Prima_ID`) ,
  INDEX `fk_Proveedores_has_Materias_Primas_Materias_Primas1_idx` (`Materia_Prima_ID` ASC) ,
  INDEX `fk_Proveedores_has_Materias_Primas_Proveedores1_idx` (`Proveedor_ID` ASC) ,
  CONSTRAINT `fk_Proveedores_has_Materias_Primas_Proveedores1`
    FOREIGN KEY (`Proveedor_ID` )
    REFERENCES `Actividad1_7`.`Proveedores` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Proveedores_has_Materias_Primas_Materias_Primas1`
    FOREIGN KEY (`Materia_Prima_ID` )
    REFERENCES `Actividad1_7`.`Materias_Primas` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
