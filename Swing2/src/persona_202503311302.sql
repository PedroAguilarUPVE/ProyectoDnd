-- POO.dbo.persona definition

-- Drop table

-- DROP TABLE POO.dbo.persona;

CREATE TABLE POO.dbo.persona (
	Id int NULL,
	Nombre varchar(100) COLLATE Modern_Spanish_CI_AS NULL,
	Edad int NULL,
	Profesion int NULL,
	Telefono varchar(100) COLLATE Modern_Spanish_CI_AS NULL,
	Email varchar(100) COLLATE Modern_Spanish_CI_AS NULL,
	FechaNac date NULL,
	TerCon binary(100) NULL
);

INSERT INTO POO.dbo.persona (Id,Nombre,Edad,Profesion,Telefono,Email,FechaNac,TerCon) VALUES
	 (3,N'maria',4,1,N'(999) 999-9999',N'maria@gmail.com','2025-03-31',0x00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001);
