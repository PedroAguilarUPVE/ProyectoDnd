/*
Use master
Go
Drop Database Dnd
Go
Create Database Dnd
Go
*/
Use Dnd
Go

Create Table Clases (
    Id_Clase INT PRIMARY KEY Identity,
    Nombre VARCHAR(20) NOT NULL UNIQUE,
	Descripcion Text,
	Tipo Varchar(10) Check (Tipo in ('Marcial','Magica','Mixta')) Default 'Marcial',
	DadoDano int NOT NULL,
);


Create Table Subclases (
	Id_Subclase INT PRIMARY KEY Identity,
	Id_Clase Int NOT NULL,
	Nombre NVARCHAR(50) NOT NULL UNIQUE,
	Descripcion Text
)

Create Table Razas (
	Id_Raza INT PRIMARY KEY Identity,
	NombreRaza NVARCHAR(50) NOT NULL UNIQUE,
	--Variante Varchar(50) Null,
	DescripcionRaza Text,
	TamanoRaza Varchar(10) Check (TamanoRaza in ('Pequeno','Mediano','Grande','Enorme')) Default 'Mediano',
	VelocidadRaza int Default (30) ,
)

Create Table EstadisticasRaza (
	Id_EstadisticasRaza int Primary Key Identity,
	--TipoEstadisticas Varchar(10) Check (TipoEstadisticas in ('Personaje','Raza','Clase')),
	Id_Raza int Not Null Unique,
	Fuerza Int,
	Destreza int,
	Constitucion int,
	Inteligencia int,
	Sabiduria int,
	Carisma int,
)


Create Table Competencias (
	Id_Competencia INT PRIMARY KEY Identity,
	NombreCompetencia Varchar(50) NOT NULL UNIQUE,
	TipoCompetencia Varchar(20) Check (TipoCompetencia in ('Herramienta','Arma','Armadura','Instrumento','Otro')) Default 'Arma',
	DescripcionCompetencia Text,
)

Create Table CompetenciasClase (
	Id_CompetenciaClase INT PRIMARY KEY Identity,
	Id_Competencia INT,
	Id_Clase INT
)

CREATE TABLE AtributosClase (
    Id_AtributoClase INT PRIMARY KEY IDENTITY,
    Id_Clase INT,
    NombreAtributo VARCHAR(50) NOT NULL,
    Descripcion TEXT,
    Nivel INT
);

CREATE TABLE AtributosSubclase (
    Id_AtributoSubclase INT PRIMARY KEY IDENTITY,
    Id_Subclase INT,
    NombreAtributo VARCHAR(50) NOT NULL,
    Descripcion TEXT,
    Nivel INT
);

CREATE TABLE AtributosRaza (
    Id_AtributoRaza INT PRIMARY KEY IDENTITY,
    Id_Raza INT,
    NombreAtributo VARCHAR(50) NOT NULL,
    Descripcion TEXT,
    Nivel INT DEFAULT (1)
);

--Create Table Armas (
--	Id_Arma INT PRIMARY KEY,
--	NombreArma VARCHAR (30),
--	Distancia INT,
--	Dano INT,
--	DadoDano INT,
--	PrecioOro INT,
--)

--Create Table EquipoClase(
--	Id_EquipoClase INT PRIMARY KEY,
--	Id_Clase INT,
--	Id_Arma INT,
--)

Create Table Personajes (
	Id_Personaje Int PRIMARY KEY Identity,
	NombrePersonaje Varchar(30) Not Null UNIQUE,
	Nivel Int Default(1) Not Null,
	--VidaTotal int not null check (VidaTotal > 0),
	--VidaActual int Default (VidaTotal) ,
	Id_Clase Int Default(8) Not Null,
	Id_Subclase Int ,
	Id_Raza int Default(1) Not Null,
--	id_Estadisticas Int,
	BonusCompetencia Int Default(2),
)

Create Table EstadisticasPersonaje (
	Id_EstadisticasPersonaje int Primary Key Identity,
	--TipoEstadisticas Varchar(10) Check (TipoEstadisticas in ('Personaje','Raza','Clase')),
	Id_Personaje int,
	Fuerza Int,
	Destreza int,
	Constitucion int,
	Inteligencia int,
	Sabiduria int,
	Carisma int,
)

Create Table Partidas (
	Id_Partida int Primary KEY Identity,
	Titulo Varchar(50),
	FechaInicio Date
)

Create Table PersonajesPartida(
	Id_Partida int,
	Id_Personaje int
)

Create Table Enemigos (
	Id_Enemigo int Primary Key Identity,
	Nombre Varchar(100) Not Null Unique,
	Tipo Varchar(100),
	Descripcion Varchar (200),
	VidaMax int,
	VidaAct int

)



ALTER TABLE Subclases
ADD CONSTRAINT FK_Clase_Subclase FOREIGN KEY (ID_Clase) 
REFERENCES Clases(Id_Clase);

ALTER TABLE CompetenciasClase
ADD CONSTRAINT FK_Clase_CompetenciaClase FOREIGN KEY (ID_Clase) 
REFERENCES Clases(Id_Clase);
ALTER TABLE CompetenciasClase
ADD CONSTRAINT FK_Competencia_CompetenciaClase FOREIGN KEY (ID_Competencia) 
REFERENCES Competencias(Id_Competencia);

ALTER TABLE Personajes
ADD CONSTRAINT FK_Clase_Personaje FOREIGN KEY (ID_Clase)
REFERENCES Clases (Id_Clase);
ALTER TABLE Personajes
ADD CONSTRAINT FK_Subclase_Personaje FOREIGN KEY (ID_Subclase)
REFERENCES Subclases (Id_Subclase);
ALTER TABLE Personajes
ADD CONSTRAINT FK_Raza_Personaje FOREIGN KEY (ID_Raza)
REFERENCES Razas (Id_Raza);

ALTER TABLE AtributosClase
ADD CONSTRAINT FK_Clase_AtributoClase FOREIGN KEY (ID_Clase) 
REFERENCES Clases(Id_Clase);

ALTER TABLE AtributosSubclase
ADD CONSTRAINT FK_Subclase_AtributoSubclase FOREIGN KEY (ID_Subclase) 
REFERENCES Subclases(Id_Subclase);

ALTER TABLE AtributosRaza
ADD CONSTRAINT FK_Raza_AtributoRaza FOREIGN KEY (ID_Raza) 
REFERENCES Razas(Id_Raza);

ALTER TABLE EstadisticasPersonaje
ADD CONSTRAINT FK_Personaje_Estadisticas FOREIGN KEY (ID_Personaje) 
REFERENCES Personajes(Id_Personaje);

ALTER TABLE EstadisticasRaza
ADD CONSTRAINT FK_Raza_Estadisticas FOREIGN KEY (ID_Raza) 
REFERENCES Razas(Id_Raza);

GO

--Procesos Almacenados
Create Procedure PA_ComprobarClases
--Alter Procedure PA_ComprobarClases
AS
BEGIN
	DECLARE @MensajeError Varchar(50)
	IF EXISTS (SELECT * FROM Clases)
	BEGIN 
		SELECT ('true')
	END
	ELSE
	BEGIN
		SET @MensajeError = 'Error: No existe ninguna clase todavia, cree una primero'
		SELECT ('false')
	END
END
EXEC PA_ComprobarClases
GO

Create Procedure PA_ComprobarRazas
--Alter Procedure PA_ComprobarRazas
AS
BEGIN
	DECLARE @MensajeError Varchar(50)
	IF EXISTS (SELECT * FROM Razas)
	BEGIN 
		SELECT ('true')
	END
	ELSE
	BEGIN
		SET @MensajeError = 'Error: No existe ninguna raza todavia, cree una primero'
		SELECT ('false')
	END
END
GO

Create Procedure PA_ComprobarSubclases
--Alter Procedure PA_ComprobarSubclases
AS
BEGIN
	DECLARE @MensajeError Varchar(50)
	IF EXISTS (SELECT * FROM Subclases)
	BEGIN 
		SELECT ('true')
	END
	ELSE
	BEGIN
		SET @MensajeError = 'Error: No existe ninguna subclase todavia, cree una primero'
		SELECT ('false')
	END
END
GO