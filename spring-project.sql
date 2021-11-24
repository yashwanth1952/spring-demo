-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema spring-project
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `spring-project` ;

-- -----------------------------------------------------
-- Schema spring-project
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `spring-project` ;
USE `spring-project` ;

-- -----------------------------------------------------
-- Table `spring-project`.`movie`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spring-project`.`movie` ;

CREATE TABLE IF NOT EXISTS `spring-project`.`movie` (
  `movie_id` INT NOT NULL AUTO_INCREMENT,
  `movie_name` VARCHAR(45) NULL UNIQUE,
  `movie_rating` DOUBLE(2,1) NULL,
  `movie_summary` VARCHAR(300) NULL,
  PRIMARY KEY (`movie_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spring-project`.`platform`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spring-project`.`platform` ;

CREATE TABLE IF NOT EXISTS `spring-project`.`platform` (
  `platform_id` INT NOT NULL AUTO_INCREMENT,
  `platform_name` VARCHAR(45) NULL UNIQUE,
  PRIMARY KEY (`platform_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spring-project`.`movies_on_platforms`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spring-project`.`movies_on_platforms` ;

CREATE TABLE IF NOT EXISTS `spring-project`.`movies_on_platforms` (
  `movie_movie_id` INT NOT NULL,
  `platform_platform_id` INT NOT NULL,
  PRIMARY KEY (`movie_movie_id`, `platform_platform_id`),
  INDEX `fk_movies-on-platforms_platform1_idx` (`platform_platform_id` ASC) VISIBLE,
  CONSTRAINT `fk_movies-on-platforms_movie`
    FOREIGN KEY (`movie_movie_id`)
    REFERENCES `spring-project`.`movie` (`movie_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_movies-on-platforms_platform1`
    FOREIGN KEY (`platform_platform_id`)
    REFERENCES `spring-project`.`platform` (`platform_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `movie` VALUES 
	(1,'Avengers',8.8,'Avengers Summary'),
	(2,'Inception',9.1,'Inception Summary'),
	(3,'Spiderman',6.5,'Spiderman Summary');


INSERT INTO `platform` VALUES 
	(1,'Prime'),
	(2,'Netflix'),
	(3,'Hotstar'),
	(4,'Voot');

INSERT INTO `movies_on_platforms` VALUES 
	(1,2),
	(2,2),
	(3,4),
	(1,1);
--
-- 


-- security tables

create table users(
	username varchar(50) not null primary key,
	password varchar(68) not null,
	enabled boolean not null
);

create table authorities (
	username varchar(50) not null,
	authority varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);

INSERT INTO `users` VALUES 
	('ram','{bcrypt}$2a$04$qXYI4J5gaQmyD8vmQO4v0OW5VKJiDoTimswBPpot/ymCsMCNowM.G',1),
    ('mike','{bcrypt}$2a$04$qXYI4J5gaQmyD8vmQO4v0OW5VKJiDoTimswBPpot/ymCsMCNowM.G',1),
	('sam','{bcrypt}$2a$04$qXYI4J5gaQmyD8vmQO4v0OW5VKJiDoTimswBPpot/ymCsMCNowM.G',1);
    
INSERT INTO `authorities` VALUES 
	('ram','ROLE_ADMIN'),
	('sam','ROLE_USER'),
    ('mike','ROLE_ADMIN'),
	('mike','ROLE_USER');
 