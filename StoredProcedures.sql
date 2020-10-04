USE `clase1`;
/*-----------SELECT----------*/
DROP procedure IF EXISTS `SP_S_Persona`;
DELIMITER $$
USE `clase1`$$
CREATE PROCEDURE `SP_S_Persona` ()
BEGIN
	SELECT * FROM clase1.persona;
END$$
DELIMITER ;

/*-----------INSERT----------*/
USE `clase1`;
DROP procedure IF EXISTS `SP_I_Persona`;
DELIMITER $$
USE `clase1`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_I_Persona`(
PNombre varchar(45),
PApellido varchar(45),
PEdad int(11),
PSexo varchar(45),
PFecha date
)
BEGIN
	INSERT INTO persona(Nombre, Apellido, Edad, Sexo, Fecha) value (PNombre, PApellido, PEdad, PSexo, PFecha);
END$$
DELIMITER ;

/*-----------DELETE----------*/
DROP procedure IF EXISTS `SP_D_Persona`;
DELIMITER $$
USE `clase1`$$
CREATE PROCEDURE `SP_D_Persona` (
PIdPersona int(11)
)
BEGIN
	DELETE FROM persona where idPersona=PIdPersona;
END$$
DELIMITER ;

/*-----------UPDATE----------*/
USE `clase1`;
DROP procedure IF EXISTS `SP_U_Persona`;
DELIMITER $$
USE `clase1`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_U_Persona`(
PIdPersona int(11),
PNombre varchar(45),
PApellido varchar(45),
PEdad int(11),
PSexo varchar(45),
PFecha date
)
BEGIN
	UPDATE persona set Nombre=PNombre, Apellido=PApellido, Edad=PEdad, Sexo=PSexo, Fecha=PFecha where idPersona=PIdPersona;
END$$
DELIMITER ;

 /*Clase 03/09/2020----------------------------------*/
USE `clase1`;
DROP procedure IF EXISTS `SP_S_LOGINESTUDIANTE`;
DELIMITER $$
USE `clase1`$$
CREATE PROCEDURE `SP_S_LOGINESTUDIANTE`(pusuario varchar(50), ppass varchar(50))
BEGIN
	Select * from estudiante where USU = pusuario AND PASS = md5(ppass);
END$$
DELIMITER ;

DROP procedure IF EXISTS `SP_S_INNERESTUDIANTEPERSONA`;
DELIMITER $$
USE `clase1`$$
CREATE PROCEDURE `SP_S_INNERESTUDIANTEPERSONA` ()
BEGIN
	SELECT a.Nombre, a.Apellido, b.matricula from Persona as a
	inner join estudiante as b on a.idPersona = b.idPersona;
END$$
DELIMITER ;