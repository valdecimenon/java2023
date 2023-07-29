-- MySQL Script generated by MySQL Workbench
-- Sat Jul  8 14:02:02 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema jpa
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema jpa
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `jpa` DEFAULT CHARACTER SET utf8 ;
USE `jpa` ;

-- -----------------------------------------------------
-- Table `jpa`.`Endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jpa`.`Endereco` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rua` VARCHAR(45) NULL,
  `cidade` VARCHAR(20) NOT NULL,
  `uf` CHAR(2) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jpa`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jpa`.`Cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `Endereco_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Cliente_Endereco_idx` (`Endereco_id` ASC),
  CONSTRAINT `fk_Cliente_Endereco`
    FOREIGN KEY (`Endereco_id`)
    REFERENCES `jpa`.`Endereco` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jpa`.`Produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jpa`.`Produto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `preco` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jpa`.`Pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jpa`.`Pedido` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `Cliente_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Pedido_Cliente1_idx` (`Cliente_id` ASC),
  CONSTRAINT `fk_Pedido_Cliente1`
    FOREIGN KEY (`Cliente_id`)
    REFERENCES `jpa`.`Cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jpa`.`Item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jpa`.`Item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Pedido_id` INT NOT NULL,
  `Produto_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Item_Pedido1_idx` (`Pedido_id` ASC),
  INDEX `fk_Item_Produto1_idx` (`Produto_id` ASC),
  CONSTRAINT `fk_Item_Pedido1`
    FOREIGN KEY (`Pedido_id`)
    REFERENCES `jpa`.`Pedido` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Item_Produto1`
    FOREIGN KEY (`Produto_id`)
    REFERENCES `jpa`.`Produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
