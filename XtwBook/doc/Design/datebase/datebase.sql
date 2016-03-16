CREATE SCHEMA `xtwBook` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `xtwuser` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `userName` VARCHAR(20) NULL,
  `password` VARCHAR(20) NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE `xtwBook`.`author` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `realName` VARCHAR(20) NULL,
  `userID` INT NULL,
  `IDCard` VARCHAR(20) NULL,
  PRIMARY KEY (`id`));
  
