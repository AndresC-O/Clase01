CREATE TABLE `clase1`.`profesor` (
  `idProfesor` INT NOT NULL AUTO_INCREMENT,
  `idPersona` INT NULL,
  `Dui` VARCHAR(45) NULL,
  `Usuario` VARCHAR(45) NULL,
  `Pass` VARCHAR(600) NULL,
  PRIMARY KEY (`idProfesor`));

ALTER TABLE `clase1`.`profesor` 
ADD INDEX `FK_idPersona_idx` (`idPersona` ASC) VISIBLE;
;
ALTER TABLE `clase1`.`profesor` 
ADD CONSTRAINT `FK_idPersona`
  FOREIGN KEY (`idPersona`)
  REFERENCES `clase1`.`persona` (`idPersona`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


USE `clase1`;
DROP procedure IF EXISTS `SP_S_LOGINPROFESOR`;
DELIMITER $$
USE `clase1`$$
CREATE PROCEDURE `SP_S_LOGINPROFESOR` (pUsuario varchar(45), pPass varchar(600))
BEGIN
	Select * from profesor where Usuario = pUsuario AND Pass = sha2(pPass, 512);
END$$
DELIMITER ;

USE `clase1`;
DROP procedure IF EXISTS `SP_S_CRIPPROFESOR`;
DELIMITER $$
USE `clase1`$$
CREATE PROCEDURE `SP_S_CRIPPROFESOR` (pPass varchar(600))
BEGIN
	Select sha2(pPass, 512) as crip;
END$$
DELIMITER ;

USE `clase1`;
DROP procedure IF EXISTS `SP_I_PROFESOR`;
DELIMITER $$
USE `clase1`$$
CREATE PROCEDURE `SP_I_PROFESOR`(pIdPersona int, pDui varchar(45), pUsuario varchar(45), pPass varchar(50))
BEGIN
	Insert into profesor(idPersona, Dui, Usuario, Pass) values (pIdPersona, pDui, pUsuario, sha2(pPass, 512));
END$$
DELIMITER ;

USE `clase1`;
DROP procedure IF EXISTS `SP_U_PROFESOR`;
DELIMITER $$
USE `clase1`$$
CREATE PROCEDURE `SP_U_PROFESOR` (pIdProfesor int, pIdPersona int, pDui varchar(45), pUsuario varchar(45), pPass varchar(50))
BEGIN
Update profesor set idPersona=pIdPersona, Dui=pDui, Usuario=pUsuario, Pass= sha2(pPass, 512) where idProfesor=pIdProfesor;
END$$
DELIMITER ;

USE `clase1`;
DROP procedure IF EXISTS `SP_D_PROFESOR`;
DELIMITER $$
USE `clase1`$$
CREATE PROCEDURE `SP_D_PROFESOR` (pIdProfesor int)
BEGIN
	Delete from profesor where idProfesor = pIdProfesor;
END$$
DELIMITER ;