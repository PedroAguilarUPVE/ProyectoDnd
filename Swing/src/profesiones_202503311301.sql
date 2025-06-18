-- POO.dbo.profesiones definition

-- Drop table

-- DROP TABLE POO.dbo.profesiones;

CREATE TABLE POO.dbo.profesiones (
	IdProfesion int NOT NULL,
	profesion varchar(100) COLLATE Modern_Spanish_CI_AS NOT NULL
);

INSERT INTO POO.dbo.profesiones (IdProfesion,profesion) VALUES
	 (1,N'Docente'),
	 (2,N'Alumno'),
	 (3,N'Administrativo'),
	 (4,N'Externo');
