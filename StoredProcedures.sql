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
DROP procedure IF EXISTS `SP_I_Persona`;
DELIMITER $$
USE `clase1`$$
CREATE PROCEDURE `SP_I_Persona` (
PNombre varchar(45),
PApellido varchar(45),
PEdad int(11),
PSexo varchar(45)
)
BEGIN
	INSERT INTO persona(Nombre, Apellido, Edad, Sexo) value (PNombre, PApellido, PEdad, PSexo);
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
DROP procedure IF EXISTS `SP_U_Persona`;
DELIMITER $$
USE `clase1`$$
CREATE PROCEDURE `SP_U_Persona` (
PIdPersona int(11),
PNombre varchar(45),
PApellido varchar(45),
PEdad int(11),
PSexo varchar(45)
)
BEGIN
	UPDATE persona set Nombre=PNombre, Apellido=PApellido, Edad=PEdad, Sexo=PSexo where idPersona=PIdPersona;
END$$
DELIMITER ;