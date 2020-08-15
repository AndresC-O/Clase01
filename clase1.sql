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