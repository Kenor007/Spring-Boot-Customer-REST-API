DROP SCHEMA IF EXISTS `customer_db` ;

CREATE SCHEMA IF NOT EXISTS `customer_db` DEFAULT CHARACTER SET utf8 ;
USE `customer_db` ;

DROP TABLE IF EXISTS `customer_db`.`customer` ;

CREATE TABLE IF NOT EXISTS `customer_db`.`customer` (
    `customer_id` INT NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(45) NULL,
    `last_name` VARCHAR(45) NULL,
    `email` VARCHAR(45) NULL,
    `age` INT NULL,
    `gender` VARCHAR(45) NULL,
    PRIMARY KEY (`customer_id`))
    ENGINE = InnoDB;

DROP TABLE IF EXISTS `customer_db`.`product` ;

CREATE TABLE IF NOT EXISTS `customer_db`.`product` (
    `product_id` INT NOT NULL AUTO_INCREMENT,
    `product_name` VARCHAR(45) NULL,
    `product_model` VARCHAR(45) NULL,
    `product_color` VARCHAR(45) NULL,
    `quantity` INT NULL,
    `price` INT NULL,
    `customer_id_fk` INT NULL,
    PRIMARY KEY (`product_id`),
    INDEX `fk_products_customers_idx` (`customer_id_fk` ASC) VISIBLE,
    CONSTRAINT `fk_products_customers`
    FOREIGN KEY (`customer_id_fk`)
    REFERENCES `customer_db`.`customer` (`customer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;