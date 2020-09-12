ALTER TABLE `clase1`.`estudiante` 
ADD COLUMN `NIE` int NULL AFTER `PASS`;

USE `clase1`;
DROP procedure IF EXISTS `SP_I_ESTUDIANTE`;
DELIMITER $$
USE `clase1`$$
CREATE PROCEDURE `SP_I_ESTUDIANTE`(pmatricula int, pidPersona int, pusuario varchar(45), ppass varchar(600), pnie int)
BEGIN
	Insert into estudiante(matricula, idPersona, USU, PASS, NIE) values(pmatricula, pidPersona, pusuario, md5(ppass), pnie);
END$$
DELIMITER ;

USE `clase1`;
DROP procedure IF EXISTS `SP_U_ESTUDIANTE`;
DELIMITER $$
USE `clase1`$$
CREATE PROCEDURE `SP_U_ESTUDIANTE` (pIdEstudiante int, pmatricula int, pIdPersona int, pUsuario varchar(45), pPass varchar(45), pNie int)
BEGIN
	Update estudiante set matricula=pmatricula, idPersona= pIdPersona, USU=pUsuario, PASS=pPass, NIE=pNie
    where idEstudiante=pIdEstudiante;
END$$
DELIMITER ;

USE `clase1`;
DROP procedure IF EXISTS `SP_D_ESTUDIANTE`;
DELIMITER $$
USE `clase1`$$
CREATE PROCEDURE `SP_D_ESTUDIANTE` (pIdEstudiante int)
BEGIN
	Delete from estudiante where idEstudiante=pIdEstudiante;
END$$
DELIMITER ;

USE `clase1`;
DROP procedure IF EXISTS `SP_S_INNERESTUDIANTE`;
DELIMITER $$
USE `clase1`$$
CREATE PROCEDURE `SP_S_INNERESTUDIANTE` ()
BEGIN
	Select a.idEstudiante, a.matricula, b.idPersona, b.Nombre, a.USU, a.PASS, a.NIE from estudiante as a
	inner join  persona as b on a.idPersona=b.idPersona;
END$$
DELIMITER ;

USE `clase1`;
DROP procedure IF EXISTS `SP_S_CRIP`;
DELIMITER $$
USE `clase1`$$
CREATE PROCEDURE `SP_S_CRIP` (PcripPass varchar(600))
BEGIN
	Select md5(PcripPass) as crip;
END$$
DELIMITER ;