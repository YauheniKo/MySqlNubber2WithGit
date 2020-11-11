-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydbtest2
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydbtest2` ;

-- -----------------------------------------------------
-- Schema mydbtest2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydbtest2` DEFAULT CHARACTER SET utf8 ;
USE `mydbtest2` ;

-- -----------------------------------------------------
-- Table `mydbtest2`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydbtest2`.`roles` ;

CREATE TABLE IF NOT EXISTS `mydbtest2`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydbtest2`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydbtest2`.`user` ;

CREATE TABLE IF NOT EXISTS `mydbtest2`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_roles_idx` (`roles_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `mydbtest2`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydbtest2`.`auto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydbtest2`.`auto` ;

CREATE TABLE IF NOT EXISTS `mydbtest2`.`auto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `model` VARCHAR(45) NULL,
  `type` VARCHAR(45) NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_auto_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_auto_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydbtest2`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `mydbtest2`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydbtest2`;
INSERT INTO `mydbtest2`.`roles` (`id`, `user`) VALUES (DEFAULT, 'Administrstor');
INSERT INTO `mydbtest2`.`roles` (`id`, `user`) VALUES (DEFAULT, 'User');
INSERT INTO `mydbtest2`.`roles` (`id`, `user`) VALUES (DEFAULT, 'Guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydbtest2`.`user`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydbtest2`;
INSERT INTO `mydbtest2`.`user` (`id`, `login`, `password`, `roles_id`) VALUES (DEFAULT, 'admin', 'padmin', 1);
INSERT INTO `mydbtest2`.`user` (`id`, `login`, `password`, `roles_id`) VALUES (DEFAULT, 'user', 'puser', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydbtest2`.`auto`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydbtest2`;
INSERT INTO `mydbtest2`.`auto` (`id`, `model`, `type`, `user_id`) VALUES (DEFAULT, 'mersedes', 'sedan', 1);

COMMIT;

