-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydbtest3
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydbtest3` ;

-- -----------------------------------------------------
-- Schema mydbtest3
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydbtest3` DEFAULT CHARACTER SET utf8 ;
USE `mydbtest3` ;

-- -----------------------------------------------------
-- Table `mydbtest3`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydbtest3`.`role` ;

CREATE TABLE IF NOT EXISTS `mydbtest3`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydbtest3`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydbtest3`.`user` ;

CREATE TABLE IF NOT EXISTS `mydbtest3`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `role_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_role_idx` (`role_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_role`
    FOREIGN KEY (`role_id`)
    REFERENCES `mydbtest3`.`role` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydbtest3`.`auto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydbtest3`.`auto` ;

CREATE TABLE IF NOT EXISTS `mydbtest3`.`auto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `model` VARCHAR(45) NULL,
  `type` VARCHAR(45) NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_auto_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_auto_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydbtest3`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `mydbtest3`.`role`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydbtest3`;
INSERT INTO `mydbtest3`.`role` (`id`, `role`) VALUES (DEFAULT, 'Administrator');
INSERT INTO `mydbtest3`.`role` (`id`, `role`) VALUES (DEFAULT, 'User');

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydbtest3`.`user`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydbtest3`;
INSERT INTO `mydbtest3`.`user` (`id`, `login`, `password`, `role_id`) VALUES (DEFAULT, 'admin', 'padmin', 1);
INSERT INTO `mydbtest3`.`user` (`id`, `login`, `password`, `role_id`) VALUES (DEFAULT, 'user', 'puser', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mydbtest3`.`auto`
-- -----------------------------------------------------
START TRANSACTION;
USE `mydbtest3`;
INSERT INTO `mydbtest3`.`auto` (`id`, `model`, `type`, `user_id`) VALUES (DEFAULT, 'volvo', 'universal', 1);

COMMIT;

