create database clase1;
use clase1;

CREATE TABLE `clase1`.`persona` (
  `idPersona` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NULL,
  `Apellido` VARCHAR(45) NULL,
  `Edad` INT NULL,
  `Sexo` VARCHAR(45) NULL,
  PRIMARY KEY (`idPersona`));
  
  INSERT INTO `clase1`.`persona` (`Nombre`, `Apellido`, `Edad`, `Sexo`) VALUES ('Andres', 'Cordova', '19', 'M');
  
  ALTER TABLE `clase1`.`persona` 
ADD COLUMN `Fecha` DATE NULL AFTER `Sexo`;
  
  /*Clase 27/08/2020----------------------------------*/
  CREATE TABLE `clase1`.`estudiante` (
  `idEstudiante` INT NOT NULL,
  `matricula` INT NULL,
  `idPersona` INT NULL,
  PRIMARY KEY (`idEstudiante`));
  
  ALTER TABLE `clase1`.`estudiante` 
ADD INDEX `idPersona_idx` (`idPersona` ASC) VISIBLE;
;
ALTER TABLE `clase1`.`estudiante` 
ADD CONSTRAINT `idPersona`
  FOREIGN KEY (`idPersona`)
  REFERENCES `clase1`.`persona` (`idPersona`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
  /*Clase 03/09/2020----------------------------------*/
  ALTER TABLE `clase1`.`estudiante` 
ADD COLUMN `USU` VARCHAR(45) NULL AFTER `idPersona`,
ADD COLUMN `PASS` VARCHAR(45) NULL AFTER `USU`;

ALTER TABLE `clase1`.`estudiante` 
CHANGE COLUMN `idEstudiante` `idEstudiante` INT NOT NULL AUTO_INCREMENT ;