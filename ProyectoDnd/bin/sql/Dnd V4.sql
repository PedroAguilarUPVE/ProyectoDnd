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
    NombreClase VARCHAR(20) NOT NULL UNIQUE,
	DescripcionClase Text,
	TipoClase Varchar(10) Check (TipoClase in ('Marcial','Magica','Mixta')) Default 'Marcial',
	DadoDa�o int NOT NULL,
);


Create Table Subclases (
	Id_Subclase INT PRIMARY KEY Identity,
	Id_Clase Int NOT NULL,
	NombreSubclase NVARCHAR(50) NOT NULL UNIQUE,
	DescripcionSubclase Text,
)

Create Table Razas (
	Id_Raza INT PRIMARY KEY Identity,
	NombreRaza NVARCHAR(50) NOT NULL UNIQUE,
	Variante Varchar(50) Null,
	DescripcionRaza Text,
	Tama�oRaza Varchar(10) Check (Tama�oRaza in ('Peque�o','Mediano','Grande','Enorme')) Default 'Mediano',
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
--	Da�o INT,
--	DadoDa�o INT,
--	PrecioOro INT,
--)

--Create Table EquipoClase(
--	Id_EquipoClase INT PRIMARY KEY,
--	Id_Clase INT,
--	Id_Arma INT,
--)


Create Table Personajes(
	Id_Personaje Int PRIMARY KEY Identity,
	NombrePersonaje Varchar(30) Not Null UNIQUE,
	Nivel Int Default(1) Not Null,
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

--				Llenar Datos

--	Clases

INSERT INTO Clases ( NombreClase, DescripcionClase, TipoClase, DadoDa�o) VALUES
('Barbaro', 'Un guerrero feroz impulsado por la furia.', 'Marcial', 12),
('Bardo', 'Un m�sico y narrador con magia.', 'Mixta', 8),
('Brujo', 'Un mago que obtiene poder de un pacto oscuro.', 'Magica', 8),
('Clerigo', 'Un devoto con poderes divinos.', 'Magica', 8),
('Druida', 'Un guardi�n de la naturaleza con magia.', 'Magica', 8),
('Explorador', 'Un rastreador y combatiente �gil.', 'Mixta', 10),
('Hechicero', 'Un lanzador de conjuros con magia innata.', 'Magica', 6),
('Guerrero', 'Un maestro de las armas y la t�ctica.', 'Marcial', 10),
('Monje', 'Un guerrero autodisciplinado con energ�a Ki.', 'Marcial', 8),
( 'Mago', 'Un estudioso de la magia arcana.', 'Magica', 6),
( 'Paladin', 'Un guerrero sagrado con magia divina.', 'Mixta', 10),
( 'Picaro', 'Un especialista en sigilo y precisi�n.', 'Marcial', 8),
( 'Artifice', 'Un inventor y creador de magia.', 'Mixta', 8);

INSERT INTO AtributosClase (Id_Clase, NombreAtributo, Descripcion, Nivel) VALUES  
-- B�rbaro  
(1, 'Furia', 'Puedes entrar en un estado de rabia en combate para aumentar el da�o.', 1),  
(1, 'Defensa sin Armadura', 'CA = 10 + CON + DEX si no llevas armadura.', 1),  
(1, 'Ataque Temerario', 'Puedes obtener ventaja en ataques cuerpo a cuerpo a cambio de desventaja al recibir ataques.', 2),  
(1, 'Ataque Adicional', 'Puedes atacar dos veces en tu turno en lugar de una.', 5),  
-- Bardo  
(2, 'Inspiraci�n B�rdica', 'Otorgas un dado de inspiraci�n a un aliado para mejorar sus tiradas.', 1),  
(2, 'Repertorio de Hechizos', 'Aprendes y puedes lanzar conjuros de la lista de Bardo.', 2),  
(2, 'Fuente de Inspiraci�n', 'Recuperas los usos de Inspiraci�n B�rdica tras un descanso corto o largo.', 5),  
-- Brujo  
(3, 'Patr�n M�stico', 'Haces un pacto con una entidad poderosa.', 1),  
(3, 'Magia de Pacto', 'Tienes conjuros y ranuras de magia especiales.', 1),  
(3, 'Eldritch Invocations', 'Accedes a invocaciones m�sticas para personalizar tu poder.', 2),  
(3, 'Maleficio Mejorado', 'Tu Maldici�n de Pacto gana mejoras adicionales.', 5),  
-- Cl�rigo  
(4, 'Lanzamiento de Conjuros Divinos', 'Aprendes y puedes lanzar conjuros de la lista de Cl�rigo.', 1),  
(4, 'Dominio Divino', 'Obtienes un dominio divino con habilidades adicionales.', 1),  
(4, 'Canalizar Divinidad', 'Usas poder divino para obtener efectos especiales.', 2),  
(4, 'Golpe Potenciado', 'Aumentas el da�o de un ataque cuerpo a cuerpo con energ�a divina.', 5),  
-- Druida  
(5, 'Forma Salvaje', 'Puedes transformarte en una bestia.', 2),  
(5, 'Recuperaci�n Natural', 'Recuperas ranuras de conjuro tras un descanso corto.', 2),  
(5, 'Sentidos Mejorados', 'Tu vista y o�do mejoran cuando est�s en forma salvaje.', 2),  
(5, 'Conexi�n con la Naturaleza', 'Puedes comunicarte con animales y plantas.', 3),  
-- Explorador  
(6, 'Explorador Natural', 'Eres experto en moverte en ciertos terrenos.', 1),  
(6, 'Enemigo Predilecto', 'Obtienes ventajas contra criaturas espec�ficas.', 1),  
(6, 'Estilo de Combate', 'Eliges una especializaci�n de combate.', 2),  
(6, 'Ataque del Cazador', 'Haces m�s da�o en ciertas condiciones.', 5),  
-- Hechicero  
(7, 'Or�genes de la Magia', 'Tu magia proviene de una fuente innata.', 1),  
(7, 'Poder M�gico', 'Obtienes puntos de Hechicer�a para mejorar conjuros.', 1),  
(7, 'Metamagia', 'Puedes modificar conjuros con efectos especiales.', 3),  
(7, 'Reservorio Arcano', 'Aumentas el da�o o curaci�n de un conjuro.', 5),  
-- Guerrero  
(8, 'Estilo de Combate', 'Eliges un estilo de combate especializado.', 1),  
(8, 'Acci�n Adicional', 'Obtienes un turno extra en combate.', 2),  
(8, 'Segundo Aliento', 'Puedes usar un recurso para recuperar puntos de golpe.', 2),  
(8, 'Indomable', 'Puedes repetir una tirada de salvaci�n fallida una vez por descanso largo.', 5),  
-- Monje  
(9, 'Defensa sin Armadura', 'CA = 10 + DEX + SAB si no llevas armadura.', 1),  
(9, 'Artes Marciales', 'Tus golpes sin armas son m�s fuertes.', 1),  
(9, 'Ki', 'Obtienes puntos de Ki para realizar habilidades especiales.', 2),  
(9, 'Deflexi�n de Proyectiles', 'Reduces el da�o de ataques a distancia.', 5),  
-- Mago  
(10, 'Preparaci�n de Hechizos', 'El mago puede preparar un n�mero de conjuros de su lista de conjuros de mago.', 1),  
(10, 'Conjuro de Concentraci�n', 'El mago es capaz de mantener un conjuro de concentraci�n durante m�s tiempo.', 2),  
-- Palad�n  
(11, 'Imponer Manos', 'Sanaci�n divina mediante la imposici�n de manos.', 1),  
(11, 'Sentir el Mal', 'Detectas presencias malignas y celestiales a tu alrededor.', 1),  
(11, 'Estilo de Combate', 'Eliges una especializaci�n de combate.', 2),  
(11, 'Golpe Divino', 'Puedes gastar ranuras de conjuro para hacer da�o extra en un ataque cuerpo a cuerpo.', 5),  
-- P�caro  
(12, 'Ataque Furtivo', 'Haces da�o extra cuando tienes ventaja o un aliado cerca.', 1),  
(12, 'Esquiva Sobrenatural', 'Reduces el da�o de un ataque que te impacta.', 2),  
(12, 'Evasi�n', 'Los efectos de �rea que requieran salvaci�n de Destreza te afectan menos.', 3),  
(12, 'H�bil', 'Obtienes competencia en m�s habilidades.', 5),  
-- Art�fice  
(13, 'Infusi�n M�gica', 'Puedes imbuir objetos con magia temporalmente.', 1),  
(13, 'Herrero M�gico', 'Puedes crear y mejorar equipo con propiedades m�gicas.', 2),  
(13, 'Creador de Prodigios', 'Dise�as artilugios m�gicos y herramientas.', 3),  
(13, 'Mejora Experimental', 'Otorgas a un objeto propiedades m�gicas especiales.', 5);  

--	Subclases:

INSERT INTO Subclases ( Id_Clase, NombreSubclase, DescripcionSubclase) VALUES
-- B�rbaro
( 1, 'Berserker', 'Un guerrero impulsado por la furia, capaz de entrar en un estado de locura durante la batalla, ganando gran poder f�sico.'),
( 1, 'Camino del T�tem', 'Un guerrero que sigue el camino de un esp�ritu animal, obteniendo poderes especiales de su t�tem elegido.'),
-- Bardo
( 2, 'College of Lore', 'Un bardo erudito, experto en historia y magia arcana, que utiliza su conocimiento para influir en el mundo.'),
( 2, 'College of Valor', 'Un bardo guerrero, inspirado por la valent�a, que incita a sus aliados a la acci�n y combate de manera valiente.'),
-- Brujo
( 3, 'El Pacto de la Llama Eterna', 'Un brujo que obtiene poder a trav�s de un pacto con una entidad elemental de fuego, dominando la magia destructiva.'),
( 3, 'El Pacto de la Sombras', 'Un brujo que hace un pacto con una entidad oscura, obteniendo poderes sobre la oscuridad y la manipulaci�n de la mente.'),
-- Cl�rigo
( 4, 'Dominio de la Luz', 'Un cl�rigo que se dedica a la lucha contra el mal, utilizando la luz y la sanaci�n para proteger a los inocentes.'),
( 4, 'Dominio de la Guerra', 'Un cl�rigo guerrero que mezcla sus poderes divinos con habilidades marciales para proteger a sus compa�eros en la batalla.'),
( 4, 'Dominio de la Vida', 'Un cl�rigo sanador, enfocado en curar y proteger a los heridos y necesitados.'),
-- Druida
( 5, 'C�rculo de la Luna', 'Un druida con la habilidad de transformarse en poderosas bestias, tomando formas animales para afrontar cualquier desaf�o.'),
( 5, 'C�rculo de la Tierra', 'Un druida profundamente conectado con la naturaleza, capaz de manipular la tierra y las criaturas de la tierra.'),
-- Explorador
( 6, 'Cazador', 'Un experto en la caza, el rastreo y el combate a distancia, capaz de usar diversas t�cticas en la naturaleza.'),
( 6, 'Explorador de la Selva', 'Un explorador h�bil en moverse por la selva y en enfrentarse a los peligros que presenta el entorno selv�tico.'),
-- Hechicero
( 7, 'Linaje drac�nico', 'Un hechicero que tiene sangre de drag�n, obteniendo poderes especiales relacionados con los dragones.'),
( 7, 'Hechicer�a salvaje', 'Un hechicero cuyo poder es err�tico y descontrolado, con efectos m�gicos impredecibles pero poderosos.'),
--Guerrero
( 8, 'Maestro de Batalla', 'Un guerrero experto en t�cticas de combate y habilidades marciales, que se adapta a cualquier situaci�n en la batalla.'),
( 8, 'Cruzado', 'Un guerrero dedicado al combate sagrado y a la lucha contra los enemigos de su causa.'),
-- Monje
( 9, 'Camino del Pu�o de Hierro', 'Un monje que perfecciona su cuerpo y su disciplina en combate cuerpo a cuerpo, volvi�ndose una fuerza de la naturaleza.'),
( 9, 'Camino de la Sombra', 'Un monje entrenado en el sigilo y en el control de la energ�a espiritual, capaz de moverse en las sombras sin ser detectado.'),
-- Mago
( 10, 'Escuela de la Evocaci�n', 'Un mago que se especializa en la creaci�n y manipulaci�n de energ�a arcana para causar efectos destructivos.'),
( 10, 'Escuela de la Ilusi�n', 'Un mago experto en crear ilusiones y enga�ar a sus enemigos, confundi�ndolos y manipulando sus percepciones.'),
-- Palad�n
(11, 'Juramento de Devoci�n', 'Un palad�n que sigue el juramento de la devoci�n, buscando la pureza, la bondad y la justicia en todo lo que hace.'),
(11, 'Juramento de los Vengadores', 'Un palad�n que busca venganza contra aquellos que han hecho da�o a su causa o a sus seres queridos.'),
-- P�caro
( 12, 'Ladr�n', 'Un p�caro experto en el sigilo y el robo, siempre en busca de la pr�xima gran oportunidad.'),
( 12, 'Asesino', 'Un p�caro letal en el combate, entrenado en el arte de eliminar a sus enemigos r�pidamente y sin ser detectado.'),
-- Art�fice
( 13, 'Alquimista', 'Un art�fice que usa la ciencia y la magia para crear pociones y elixires con propiedades extraordinarias.'),
( 13, 'Art�fice de guerra', 'Un art�fice enfocado en el uso de la ingenier�a y la magia para construir poderosas m�quinas de guerra.');


-- Atributos Subclases
-- B�rbaro
INSERT INTO AtributosSubclase (Id_Subclase, NombreAtributo, Descripcion, Nivel) VALUES
(1, 'Furia Imparable', 'El berserker entra en un estado de furia que le otorga ventaja en las tiradas de ataque y resistencia a los da�os durante 1 minuto. Este efecto se activa al entrar en combate.', 3),
(2, 'Esp�ritu del T�tem', 'El b�rbaro puede invocar el poder de su esp�ritu animal, otorg�ndole resistencia a un tipo de da�o espec�fico (fuego, fr�o, etc.) dependiendo del t�tem elegido.', 3),
-- Bardo
(3, 'Conocimiento Encantado', 'El bardo puede utilizar su conocimiento para lanzar hechizos con mayor efectividad, ganando un bono a la dificultad de los hechizos de enga�o y manipulaci�n.', 3),
(4, 'Valor Inspirador', 'El bardo puede inspirar a sus aliados, otorg�ndoles un bono de moral a las tiradas de ataque y salvaci�n durante 1 minuto.', 3),
-- Brujo
(5, 'Llama Desgarradora', 'El brujo puede invocar una llama ardiente en su mano, causando da�o de fuego a los enemigos cercanos con un ataque de �rea.', 3),
(6, 'Manipulaci�n Sombr�a', 'El brujo puede manipular sombras a su alrededor, otorg�ndose invisibilidad parcial por 1 minuto, dificultando que los enemigos lo detecten.', 3),
-- Cl�rigo
(7, 'Luz Pura', 'El cl�rigo puede canalizar energ�a radiante para purificar �reas de oscuridad y curar a los aliados cercanos con da�o radiante.', 1),
(8, 'Fuerza Divina', 'El cl�rigo puede canalizar su energ�a divina para mejorar su destreza en combate, otorg�ndole un bono a la tirada de ataque y da�o en combate cuerpo a cuerpo.', 1),
(9, 'Toque Sanador', 'El cl�rigo puede curar una cantidad de puntos de golpe adicionales a un objetivo con un toque divino.', 1),
-- Druida
(10, 'Bendici�n de la Tierra', 'El druida puede invocar una bendici�n de la tierra para aumentar la resistencia de sus aliados a un tipo de da�o (f�sico, elemental, etc.).', 3),
(11, 'Transformaci�n Bestial', 'El druida obtiene una forma bestial mejorada, lo que le permite transformarse en criaturas m�s poderosas y con habilidades adicionales al usar su forma salvaje.', 2),
-- Explorador
(12, 'T�cnica de Caza', 'El cazador obtiene un bono de da�o adicional cuando ataca a criaturas que ya hayan sido marcadas por su rastreo o caza.', 3),
(13, 'Camuflaje Natural', 'El explorador puede camuflarse en la jungla o vegetaci�n, volvi�ndose pr�cticamente invisible en ese entorno.', 3),
-- Hechicero
(14, 'Aliento Drac�nico', 'El hechicero puede utilizar un aliento de drag�n, causando da�o de un tipo espec�fico (fuego, hielo, �cido, etc.) en un cono frente a �l.', 1),
(15, 'Descontrol M�gico', 'Los hechizos del hechicero pueden tener efectos aleatorios, pero tambi�n se vuelve m�s fuerte, obteniendo un bono al da�o o al n�mero de objetivos de sus hechizos.', 1),
-- Guerrero
(16, 'T�cticas de Guerra', 'El guerrero puede usar su acci�n para analizar el campo de batalla, obteniendo ventaja en las tiradas de ataque contra un enemigo espec�fico durante el resto del turno.', 3),
(17, 'Juramento Sagrado', 'El guerrero puede invocar un juramento sagrado, obteniendo resistencia a todos los tipos de da�o mientras protege a sus aliados.', 3),
-- Monje
(18, 'Golpe Mortal', 'El monje puede canalizar su energ�a espiritual para realizar un golpe devastador, ignorando resistencias y causando da�o adicional.', 3),
(19, 'Desplazamiento Sombr�o', 'El monje puede moverse en las sombras a gran velocidad, teletransport�ndose a un �rea oscura que haya visto antes.', 3),
-- Mago
(20, 'Explosi�n Arcana', 'El mago puede crear una explosi�n de energ�a arcana que causa da�o a todos los enemigos en un �rea, con una mayor cantidad de da�o si el objetivo est� cerca de la fuente.', 2),
(21, 'Distorsi�n Mental', 'El mago puede crear ilusiones tan realistas que desorientan a sus enemigos, d�ndoles desventaja en sus ataques y salvaciones.', 2),
-- Palad�n
(22, 'Aura de Pureza', 'El palad�n crea un aura que purifica a sus aliados de efectos negativos y les otorga resistencia a la necrosis y la energ�a oscura.', 3),
(23, 'Juramento de Venganza', 'El palad�n puede canalizar su ira para hacer un da�o adicional a los enemigos que haya marcado como objetivo de su venganza.', 3),
-- P�caro
(24, 'Reflejos R�pidos', 'El p�caro puede usar su acci�n de bonificaci�n para esquivar un ataque o moverse sin provocar ataques de oportunidad.', 3),
(25, 'Matanza Silenciosa', 'El p�caro puede eliminar a un enemigo con un ataque sorpresa instant�neo si no ha sido detectado.', 3),
-- Art�fice
(26, 'Elixir Mejorado', 'El art�fice puede crear elixires que aumentan las habilidades de sus aliados, otorg�ndoles bonificaciones temporales a la fuerza, agilidad o resistencia.', 3),
(27, 'Artilugio de Guerra', 'El art�fice puede construir dispositivos m�gicos y mec�nicos que le permiten aumentar su capacidad en combate, proporcionando armas o herramientas avanzadas.', 3);

--	Razas
INSERT INTO Razas ( NombreRaza, DescripcionRaza, Tama�oRaza, VelocidadRaza) VALUES
( 'Humano', 'Vers�til y adaptable.', 'Mediano', 30),
( 'Elfo', '�giles y longevos.', 'Mediano', 40),
( 'Enano', 'Resistentes y tenaces.', 'Mediano', 25),
( 'Mediano', 'Peque�os pero �giles.', 'Peque�o', 25),
( 'Drac�nido', 'Descendientes de dragones.', 'Mediano', 30),
( 'Gnomo', 'Peque�os y astutos.', 'Peque�o', 25),
( 'Semi-Orco', 'Fuerza bruta y ferocidad.', 'Grande', 30),
( 'Tiefling', 'De ascendencia infernal.', 'Mediano', 35),
( 'Semielfo', 'Agiles y versatiles', 'Mediano', 35)

INSERT INTO EstadisticasRaza (Id_Raza, Fuerza, Destreza, Constitucion, Inteligencia, Sabiduria, Carisma) VALUES
(1, 1, 1, 1, 1, 1, 1), -- Humanos: +1 en todo
(2, 0, 2, 0, 0, 1, 0), -- Elfos: +2 Destreza, +1 Sabidur�a
(3, 0, 0, 2, 0, 0, 0), -- Enanos: +2 Constituci�n
(4, 0, 2, 0, 0, 0, 0), -- Medianos: +2 Destreza
(5, 2, 0, 0, 0, 0, 1), -- Drac�nidos: +2 Fuerza, +1 Carisma
(6, 0, 0, 0, 2, 0, 0), -- Gnomos: +2 Inteligencia
(7, 2, 0, 1, 0, 0, 0), -- Semi-Orcos: +2 Fuerza, +1 Constituci�n
(8, 0, 0, 0, 1, 0, 2), -- Tieflings: +1 Inteligencia, +2 Carisma
(9, 0, 2, 0, 0, 1, 0) -- Semielfos: +1 Destreza, +1 Sabidur�a, +1 Inteligencia

-- Insertar Atributos de Raza con la nueva estructura  
INSERT INTO AtributosRaza (Id_Raza, NombreAtributo, Descripcion, Nivel) VALUES  
-- Humanos  
(1, 'Maestr�a en Habilidades', 'Obtienes competencia en una o m�s habilidades.', 1),  

-- Elfos  
(2, 'Visi�n en la Oscuridad', 'Puedes ver en la oscuridad en un rango de 60 pies.', 1),  
(2, 'Maestr�a en Habilidades', 'Obtienes competencia en una o m�s habilidades.', 1),  
(2, 'Linaje Fe�rico', 'Ventaja en tiradas de salvaci�n contra encantamientos; la magia no puede hacerte dormir.', 1),  

-- Enanos  
(3, 'Visi�n en la Oscuridad', 'Puedes ver en la oscuridad en un rango de 60 pies.', 1),  
(3, 'Resistencia a Da�o', 'Tienes resistencia a un tipo de da�o espec�fico seg�n tu raza.', 1),  
(3, 'Maestr�a en Habilidades', 'Obtienes competencia en una o m�s habilidades.', 1),  
(3, 'Afinidad con la Piedra', 'Eres competente en Historia cuando eval�as construcciones de piedra.', 1),  

-- Medianos  
(4, 'Velocidad Aumentada', 'Tu velocidad base es mayor que la de otras razas.', 1),  
(4, 'Maestr�a en Habilidades', 'Obtienes competencia en una o m�s habilidades.', 1),  
(4, 'Suerte Mediana', 'Cuando sacas un 1 en una tirada de ataque, habilidad o salvaci�n, puedes repetir la tirada.', 1),  

-- Drac�nidos  
(5, 'Visi�n en la Oscuridad', 'Puedes ver en la oscuridad en un rango de 60 pies.', 1),  
(5, 'Resistencia a Da�o', 'Tienes resistencia a un tipo de da�o espec�fico seg�n tu raza.', 1),  
(5, 'Arma de Aliento', 'Puedes exhalar un aliento elemental seg�n tu ascendencia drac�nica.', 1),  
(5, 'Resistencia Drac�nica', 'Tienes resistencia a un tipo de da�o seg�n tu ascendencia drac�nica.', 1),  

-- Gnomos  
(6, 'Maestr�a en Habilidades', 'Obtienes competencia en una o m�s habilidades.', 1),  
(6, 'Astucia Gn�mica', 'Ventaja en tiradas de salvaci�n de Inteligencia, Sabidur�a y Carisma contra magia.', 1),  

-- Semi-Orcos  
(7, 'Visi�n en la Oscuridad', 'Puedes ver en la oscuridad en un rango de 60 pies.', 1),  
(7, 'Tolerancia de Semiorco', 'Cuando caes a 0 puntos de golpe, puedes quedarte en 1 en lugar de caer inconsciente.', 1),  
(7, 'Ataque Salvaje', 'Cuando sacas un cr�tico con un ataque cuerpo a cuerpo, sumas un dado extra de da�o.', 1),  

-- Tieflings  
(8, 'Visi�n en la Oscuridad', 'Puedes ver en la oscuridad en un rango de 60 pies.', 1),  
(8, 'Resistencia Infernal', 'Tienes resistencia al da�o de fuego.', 1),  
(8, 'Legado Infernal', 'Conoces el truco *Taumaturgia* y obtienes m�s conjuros a niveles superiores.', 1);  


--Competencias
INSERT INTO Competencias (NombreCompetencia, TipoCompetencia, DescripcionCompetencia) VALUES
-- Armas
('Armas Ligeras', 'Arma', 'Un conjunto de armas peque�as y f�ciles de usar, como dagas, dardos, etc.'),
('Armas Marciales', 'Arma', 'Armas m�s grandes y poderosas, como espadas largas, hachas de batalla y lanzas.'),
('Armas a Distancia', 'Arma', 'Armas que permiten atacar a distancia, como arcos y ballestas.'),

-- Armaduras
('Armaduras Ligeras', 'Armadura', 'Armaduras que proporcionan una protecci�n m�nima pero permiten gran movilidad, como cueros y cotas de malla.'),
('Armaduras Medianas', 'Armadura', 'Armaduras que ofrecen un equilibrio entre protecci�n y movilidad, como cota de malla reforzada y armaduras de escamas.'),
('Armaduras Pesadas', 'Armadura', 'Armaduras que ofrecen una alta protecci�n a costa de la movilidad, como placas y armaduras de placas.'),
('Escudos', 'Armadura', 'Protecci�n adicional para bloquear ataques, que se lleva en la mano.'),

-- Herramientas
('Herramientas de Artesano', 'Herramienta', 'Conjunto de herramientas especializadas para realizar trabajos artesanales, como herrer�a o carpinter�a.'),
('Herramientas de Alquimista', 'Herramienta', 'Herramientas necesarias para la creaci�n de pociones y elixires.'),
('Herramientas de Ladr�n', 'Herramienta', 'Herramientas utilizadas para el robo y el sigilo, como ganz�as y herramientas de desactivaci�n de trampas.'),
('Herramientas de Tinker', 'Herramienta', 'Herramientas utilizadas para la creaci�n de dispositivos mec�nicos, como relojes y peque�as m�quinas.'),

-- Otros
('Juegos de Mesa', 'Otro', 'Competencia en juegos de azar o juegos de mesa como el ajedrez, damas o el p�ker.'),
('Veh�culos (terrestres)', 'Otro', 'Competencia en el manejo de veh�culos como carretas o carros tirados por caballos.'),

-- Instrumentos Musicales
('Instrumentos de Cuerda', 'Herramienta', 'Competencia con instrumentos de cuerda como la�d, viol�n, arpa y guitarra.'),
('Instrumentos de Viento', 'Herramienta', 'Competencia con instrumentos de viento como flauta, trompeta y gaita.'),
('Instrumentos de Percusi�n', 'Herramienta', 'Competencia con instrumentos de percusi�n como tambores, bong�s y xil�fono.'),
('Kit de Disfraz', 'Herramienta', 'Conjunto de maquillajes, vestimentas y accesorios para cambiar de apariencia e identidad.'),
('Kit de Medicina', 'Herramienta', 'Instrumentos y suministros m�dicos b�sicos para tratar heridas y enfermedades.');

-- Insertar las relaciones entre competencias y clases
INSERT INTO CompetenciasClase (Id_Competencia, Id_Clase) VALUES
-- B�rbaro
(1, 1), -- Armas Ligeras
(2, 1), -- Armas Marciales
(4, 1), -- Armaduras Ligeras
(5, 1), -- Armaduras Medianas
(6, 1), -- Escudos

-- Bardo
(1, 2), -- Armas Ligeras
(4, 2), -- Armaduras Ligeras
(6, 2), -- Escudos
(7, 2), -- Herramientas de Artesano

-- Brujo
(2, 3), -- Armas Marciales
(4, 3), -- Armaduras Ligeras
(6, 3), -- Escudos

-- Cl�rigo
(1, 4), -- Armas Ligeras
(4, 4), -- Armaduras Ligeras
(5, 4), -- Armaduras Medianas
(6, 4), -- Escudos
(7, 4), -- Herramientas de Artesano

-- Druida
(1, 5), -- Armas Ligeras
(4, 5), -- Armaduras Ligeras
(5, 5), -- Armaduras Medianas
(6, 5), -- Escudos
(8, 5), -- Herramientas de Alquimista

-- Explorador
(1, 6), -- Armas Ligeras
(2, 6), -- Armas Marciales
(4, 6), -- Armaduras Ligera
(5, 6), -- Armaduras Medianas
(6, 6), -- Escudos

-- Hechicero
(1, 7), -- Armas Ligeras
(4, 7), -- Armaduras Ligeras

-- Guerrero
(1, 8), -- Armas Ligeras
(2, 8), -- Armas Marciales
(4, 8), -- Armaduras Ligeras
(5, 8), -- Armaduras Medianas
(6, 8), -- Escudos

-- Monje
(1, 9), -- Armas Ligeras
(2, 9), -- Armas Marciales
(4, 9), -- Armaduras Ligeras

-- Mago
(1, 10), -- Armas Ligeras
(4, 10), -- Armaduras Ligeras

-- Palad�n
(1, 11), -- Armas Ligeras
(2, 11), -- Armas Marciales
(4, 11), -- Armaduras Ligeras
(5, 11), -- Armaduras Medianas
(6, 11), -- Escudos

-- P�caro
(1, 12), -- Armas Ligeras
(4, 12), -- Armaduras Ligeras
(7, 12), -- Herramientas de Ladr�n

-- Art�fice
(1, 13), -- Armas Ligeras
(4, 13), -- Armaduras Ligeras
(5, 13), -- Armaduras Medianas
(6, 13), -- Escudos
(8, 13), -- Herramientas de Alquimista
(9, 13); -- Herramientas de Tinker

--Select * From Razas
--Select * From Clases
--Select * From Subclases Where Id_Clase = 13

-- Insertar personajes con Id_Personaje
INSERT INTO Personajes (NombrePersonaje, Nivel, Id_Clase, Id_Subclase, Id_Raza, BonusCompetencia) VALUES
('Tareen Stonelog', 3, 13, 27, 3, 2), -- Art�fice, Art�fice de guerra, raza Enano
('Phoebe Lyre', 3, 13, 27, 5, 2), -- Art�fice, Herrero de guerra, raza Drac�nida
('Meliza', 2, 2, 4, 4, 1), -- Bardo, College of Valor, raza Humano
('Mico Loamir', 1, 5, 10, 8, 2), -- Druida, C�rculo de la Tierra, raza Firbolg
('Lydia Blackthorn', 5, 8, 16, 6, 3), -- Guerrero, Maestro de Batalla, raza Semielfo
('Kaelen Dawnstrike', 4, 11, 22, 4, 2),  -- Palad�n, Juramento de Devoci�n, Humano
('Zyra Nightwhisper', 5, 12, 25, 7, 3),  -- P�caro, Asesino, Elfo
('Thorin Ironfist', 3, 1, 1, 3, 2),      -- B�rbaro, Berserker, Enano
('Selene Moonshadow', 5, 10, 21, 7, 3),  -- Mago, Ilusi�n, Elfo
( 'Vex Stormborn', 3, 7, 14, 6, 2),      -- Hechicero, Linaje drac�nico, Semielfo
( 'Garruk Bearheart', 4, 9, 18, 3, 2),   -- Monje, Pu�o de Hierro, Enano
( 'Eldrin Starfall', 2, 6, 12, 7, 1),    -- Explorador, Cazador, Elfo
( 'Mira Emberflare', 5, 3, 5, 6, 3),     -- Brujo, Pacto de la Llama Eterna, Semielfo
( 'Lyra Windwhisper', 4, 2, 3, 7, 2) ,    -- Bardo, College of Lore, Elfo
( 'Darius Ironwood', 3, 8, 16, 2, 2),    -- Guerrero, Maestro de Batalla, Mediano
( 'Roland Blackthorn', 3, 11, 23, 6, 2), -- Palad�n, Vengadores, Semielfo
( 'Nalia Swiftblade', 2, 12, 24, 2, 1),  -- P�caro, Ladr�n, Mediano
( 'Korin Thunderfist', 4, 1, 2, 3, 2),   -- B�rbaro, Camino del T�tem, Enano
( 'Soren Duskrunner', 5, 9, 19, 7, 3),   -- Monje, Camino de la Sombra, Elfo
( 'Isolde Frostbane', 3, 4, 8, 5, 2);    -- Cl�rigo, Dominio de la Guerra, Tiefling


--Select * From Personajes

-- Insertar estad�sticas para los personajes
INSERT INTO EstadisticasPersonaje (Id_Personaje, Fuerza, Destreza, Constitucion, Inteligencia, Sabiduria, Carisma) VALUES
(1, 14, 12, 13, 10, 15, 8),  -- Tareen 
(2, 10, 14, 12, 16, 11, 10), -- Phoebe Lyre
(3, 8, 14, 10, 14, 13, 16), -- Meliza
(4, 12, 14, 13, 10, 16, 9),  -- Mico Loamir
(5, 16, 14, 14, 10, 13, 12), -- Lydia Blackthorn
(6, 16, 12, 14, 10, 13, 15),  -- Kaelen Dawnstrike
(7, 10, 16, 12, 14, 11, 13),  -- Zyra Nightwhisper
(8, 17, 14, 15, 8, 10, 9),    -- Thorin Ironfist
(9, 8, 14, 12, 16, 10, 13),   -- Selene Moonshadow
(10, 9, 13, 11, 15, 14, 16),  -- Vex Stormborn
(11, 14, 16, 13, 10, 15, 8),  -- Garruk Bearheart
(12, 11, 15, 13, 12, 14, 10), -- Eldrin Starfall
(13, 8, 12, 11, 14, 10, 17),  -- Mira Emberflare
(14, 16, 12, 14, 10, 13, 11), -- Darius Ironwood
(15, 10, 14, 12, 16, 13, 14), -- Lyra Windwhisper
(16, 14, 10, 13, 8, 12, 16),  -- Roland Blackthorn
(17, 8, 16, 12, 14, 10, 13),  -- Nalia Swiftblade
(18, 17, 14, 15, 8, 12, 10),  -- Korin Thunderfist
(19, 12, 16, 14, 10, 15, 9),  -- Soren Duskrunner
(20, 14, 12, 13, 8, 16, 10);  -- Isolde Frostbane

Go

--UPDATES
SELECT * FROM Personajes;
SELECT * FROM EstadisticasPersonaje;

-- 1. Reducir a nivel 1 los personajes de nivel mayor a 3 
UPDATE Personajes SET Nivel = 1 WHERE Nivel > 3;
-- 2. Mejorar la Fuerza de todos los b�rbaros en +1.
UPDATE EstadisticasPersonaje SET Fuerza = Fuerza + 1 WHERE Id_Personaje IN (SELECT Id_Personaje FROM Personajes WHERE Id_Clase = 1);
-- 3. Reducir en 1 el Carisma de todos los magos 
UPDATE EstadisticasPersonaje SET Carisma = Carisma - 1 WHERE Id_Personaje IN (SELECT Id_Personaje FROM Personajes WHERE Id_Clase = 10);
-- 4. Aumentar en 1 la Inteligencia de todos los artificieros.
UPDATE EstadisticasPersonaje SET Inteligencia = Inteligencia + 1 WHERE Id_Personaje IN (SELECT Id_Personaje FROM Personajes WHERE Id_Clase = 13);
-- 5. Cambiar la subclase de Phoebe Lyre a la de "Alquimista".
UPDATE Personajes SET Id_Subclase = 26 WHERE NombrePersonaje = 'Phoebe Lyre';
-- 6. Aumentar el nivel de todos los paladines en +1.
UPDATE Personajes SET Nivel = Nivel + 1 WHERE Id_Clase = 11;
-- 7. Cambiar la raza de Lydia Blackthorn a "Semielfo" porque se descubri� que tiene ascendencia �lfica.
UPDATE Personajes SET Id_Raza = 7 WHERE NombrePersonaje = 'Lydia Blackthorn';
-- 8. Subir en 2 puntos la Destreza de todos los p�caros.
UPDATE EstadisticasPersonaje SET Destreza = Destreza + 2 WHERE Id_Personaje IN (SELECT Id_Personaje FROM Personajes WHERE Id_Clase = 12);
-- 9. Reducir la Constituci�n en 1 de todos los personajes que no sean b�rbaros.
UPDATE EstadisticasPersonaje SET Constitucion = Constitucion - 1 WHERE Id_Personaje NOT IN (SELECT Id_Personaje FROM Personajes WHERE Id_Clase = 1);
-- 10. Cambiar el nombre de Meliza a "Meliza Moonfire" porque adopt� un nuevo nombre.
UPDATE Personajes SET NombrePersonaje = 'Meliza Moonfire' WHERE NombrePersonaje = 'Meliza';

-- 11. Subir el nivel de los personajes que tienen m�s de 14 en Sabidur�a.
UPDATE Personajes 
SET Nivel = Nivel + 1 
WHERE Id_Personaje IN (SELECT Id_Personaje FROM EstadisticasPersonaje WHERE Sabiduria > 14);

-- 12. Cambiar la subclase de todos los p�caros que tengan Destreza mayor a 15 a "Trickster".
UPDATE Subclases 
SET NombreSubclase = 'Trickster', 
    DescripcionSubclase = 'Un p�caro astuto y habilidoso, experto en enga�os y distracciones, utilizando su ingenio y astucia para manipular a sus enemigos.'
WHERE NombreSubclase = 'Ladr�n' AND Id_Clase = 12;

-- 13. Aumentar en 1 la Inteligencia de los personajes cuya raza sea elfo.
UPDATE EstadisticasPersonaje 
SET Inteligencia = Inteligencia + 1 
WHERE Id_Personaje IN (SELECT Id_Personaje FROM Personajes WHERE Id_Raza = 7);
Select * from Subclases
-- 14. Cambiar la subclase cruzado de los guerreros a Campeon
UPDATE Subclases
SET NombreSubclase = 'Campeon'
WHERE Id_Subclase = 17 
select * from Subclases
-- 15. Aumentar en 1 el Carisma de los personajes cuyo nombre contenga "Blackthorn".
UPDATE EstadisticasPersonaje 
SET Carisma = Carisma + 1 
WHERE Id_Personaje IN (SELECT Id_Personaje FROM Personajes WHERE NombrePersonaje LIKE '%Blackthorn%');

-- 16. Reducir en 1 la Inteligencia de los b�rbaros, porque conf�an m�s en su instinto que en la l�gica.
UPDATE EstadisticasPersonaje 
SET Inteligencia = Inteligencia - 1 
WHERE Id_Personaje IN (SELECT Id_Personaje FROM Personajes WHERE Id_Clase = 1);

-- 17. Aumentar en 2 la Constituci�n de los enanos porque son resistentes.
UPDATE EstadisticasPersonaje 
SET Constitucion = Constitucion + 2 
WHERE Id_Personaje IN (SELECT Id_Personaje FROM Personajes WHERE Id_Raza = 3);

-- 18. Cambia el nivel de los atributos de subclase de clerido a nivel 1
UPDATE AtributosSubclase 
Set Nivel = 1
WHERE Id_Subclase in (Select Id_Subclase From Subclases Where Id_Clase = 4)

-- 19. Reducir en 1 la Sabidur�a de los personajes con menos de 10 en Inteligencia.
UPDATE EstadisticasPersonaje 
SET Sabiduria = Sabiduria - 1 
WHERE Id_Personaje IN (SELECT Id_Personaje FROM EstadisticasPersonaje WHERE Inteligencia < 10);

-- 20. Cambiar la raza de los personajes con m�s de 15 en Destreza a "Medio elfo".
UPDATE Personajes 
SET Id_Raza = 7 
WHERE Id_Personaje IN (SELECT Id_Personaje FROM EstadisticasPersonaje WHERE Destreza > 15);

SELECT * FROM Personajes;
SELECT * FROM EstadisticasPersonaje;

-- 1. Eliminar personajes de nivel 1 (para limpiar personajes de prueba)
BEGIN TRAN
DELETE FROM EstadisticasPersonaje WHERE id_Personaje  in (Select Id_Personaje from Personajes WHERE Nivel = 1);
DELETE FROM Personajes WHERE Nivel = 1;
SELECT * FROM Personajes;
ROLLBACK TRAN;

-- 2. Eliminar estad�sticas de personajes que ya no existen en la tabla Personajes
BEGIN TRAN
DELETE FROM EstadisticasPersonaje 
WHERE Id_Personaje NOT IN (SELECT Id_Personaje FROM Personajes);
SELECT * FROM EstadisticasPersonaje;
ROLLBACK TRAN;

-- 3. Eliminar competencias que no est�n asociadas a ninguna clase
BEGIN TRAN
DELETE FROM Competencias 
WHERE Id_Competencia NOT IN (SELECT Id_Competencia FROM Clases);
SELECT * FROM Competencias;
ROLLBACK TRAN;

-- 4. Eliminar clases sin personajes asociados
BEGIN TRAN
DELETE FROM Clases 
WHERE Id_Clase NOT IN (SELECT DISTINCT Id_Clase FROM Personajes);
SELECT * FROM Clases;
ROLLBACK TRAN;

-- 5. Eliminar subclases sin personajes asociados
BEGIN TRAN
DELETE FROM AtributosSubclase WHERE Id_Subclase NOT IN (SELECT DISTINCT Id_Subclase FROM Personajes);
DELETE FROM Subclases 
WHERE Id_Subclase NOT IN (SELECT DISTINCT Id_Subclase FROM Personajes);
SELECT * FROM Subclases;
SELECT * FROM AtributosSubclase;
ROLLBACK TRAN;

-- 6. Eliminar razas sin personajes asociados
BEGIN TRAN
SELECT * FROM Razas;
DELETE FROM AtributosRaza
WHERE Id_Raza NOT IN (SELECT DISTINCT Id_Raza FROM Personajes);
DELETE FROM EstadisticasRaza
WHERE Id_Raza NOT IN (SELECT DISTINCT Id_Raza FROM Personajes);
DELETE FROM Razas 
WHERE Id_Raza NOT IN (SELECT DISTINCT Id_Raza FROM Personajes);
SELECT * FROM Razas;
SELECT * FROM AtributosRaza;
SELECT * FROM EstadisticasRaza;

ROLLBACK TRAN;

-- 7. Eliminar personajes sin estad�sticas registradas
BEGIN TRAN
DELETE FROM Personajes 
WHERE Id_Personaje NOT IN (SELECT Id_Personaje FROM EstadisticasPersonaje);
SELECT * FROM Personajes;
ROLLBACK TRAN;

-- 8. Eliminar competencias que no est�n asociadas a ninguna subclase
BEGIN TRAN
DELETE FROM Competencias 
WHERE Id_Competencia NOT IN (SELECT Id_Competencia FROM Subclases);
SELECT * FROM Competencias;
ROLLBACK TRAN;

-- 9. Eliminar personajes sin clase v�lida
BEGIN TRAN
DELETE FROM Personajes 
WHERE Id_Clase NOT IN (SELECT Id_Clase FROM Clases);
SELECT * FROM Personajes;
ROLLBACK TRAN;

-- 10. Eliminar personajes sin subclase v�lida
BEGIN TRAN
DELETE FROM Personajes 
WHERE Id_Subclase NOT IN (SELECT Id_Subclase FROM Subclases);
SELECT * FROM Personajes;
ROLLBACK TRAN;

-- 11. Eliminar subclases sin clase v�lida
BEGIN TRAN
DELETE FROM Subclases 
WHERE Id_Clase NOT IN (SELECT Id_Clase FROM Clases);
SELECT * FROM Subclases;
ROLLBACK TRAN;

-- 12. Eliminar estad�sticas que tengan valores inv�lidos (menores a 1 o mayores a 20)
BEGIN TRAN
DELETE FROM EstadisticasPersonaje 
WHERE Fuerza < 1 OR Destreza < 1 OR Constitucion < 1 
OR Inteligencia < 1 OR Sabiduria < 1 OR Carisma < 1 
OR Fuerza > 20 OR Destreza > 20 OR Constitucion > 20 
OR Inteligencia > 20 OR Sabiduria > 20 OR Carisma > 20;
SELECT * FROM EstadisticasPersonaje;
ROLLBACK TRAN;

-- 13. Eliminar personajes con BonusCompetencia fuera del rango v�lido (1-6)
BEGIN TRAN
DELETE FROM Personajes 
WHERE BonusCompetencia < 1 OR BonusCompetencia > 6;
SELECT * FROM Personajes;
ROLLBACK TRAN;

-- 14. Eliminar personajes que no tienen ninguna competencia asignada
BEGIN TRAN
DELETE FROM Personajes 
WHERE Id_Personaje NOT IN (SELECT DISTINCT Id_Personaje FROM Competencias);
SELECT * FROM Personajes;
ROLLBACK TRAN;

-- 15. Eliminar clases que no tienen ninguna subclase asignada
BEGIN TRAN
DELETE FROM Clases 
WHERE Id_Clase NOT IN (SELECT DISTINCT Id_Clase FROM Subclases);
SELECT * FROM Clases;
ROLLBACK TRAN;


/*
-- Declarar la variable
DECLARE @IdPersonaje INT;

-- Asignar el valor del Id_Personaje
SET @IdPersonaje = 2;  -- Cambia el 1 por el Id_Personaje que desees

Select NombrePersonaje From Personajes Where Id_Personaje = @IdPersonaje
-- Obtener la clase del personaje
SELECT NombreClase FROM Clases WHERE Id_Clase = (SELECT Id_Clase FROM Personajes WHERE Id_Personaje = @IdPersonaje);
Select NombreAtributo,Descripcion From AtributosClase Where Id_Clase in (Select Id_Clase FROM Personajes WHERE Id_Personaje = @IdPersonaje);

-- Obtener la subclase del personaje
SELECT NombreSubclase FROM Subclases WHERE Id_Subclase = (SELECT Id_Subclase FROM Personajes WHERE Id_Personaje = @IdPersonaje);
Select NombreAtributo,Descripcion From AtributosSubclase Where Id_Subclase in (Select Id_Subclase FROM Personajes WHERE Id_Personaje = @IdPersonaje);

-- Obtener la raza del personaje
SELECT NombreRaza FROM Razas WHERE Id_Raza = (SELECT Id_Raza FROM Personajes WHERE Id_Personaje = @IdPersonaje);
Select NombreAtributo,Descripcion From AtributosRaza Where Id_Raza in (Select Id_Raza FROM Personajes WHERE Id_Personaje = @IdPersonaje);

-- Obtener las estad�sticas del personaje
SELECT Fuerza, Destreza, Constitucion, Inteligencia, Sabiduria, Carisma FROM EstadisticasPersonaje WHERE Id_Personaje = @IdPersonaje;

-- Obtener las competencias del personaje (por clase)
SELECT NombreCompetencia FROM Competencias WHERE Id_Competencia IN (    SELECT Id_Competencia    FROM CompetenciasClase
WHERE Id_Clase = (SELECT Id_Clase FROM Personajes WHERE Id_Personaje = @IdPersonaje)
);
Go
*/

Select P.NombrePersonaje, P.Nivel, C.NombreClase, SC.NombreSubclase, R.NombreRaza
From Personajes P
INNER JOIN Clases C On C.Id_Clase=P.Id_Clase
Inner Join Subclases SC On SC.Id_Subclase = P.Id_Subclase
Inner Join Razas R On R.Id_Raza=P.Id_Raza 

Begin Tran
Delete From EstadisticasPersonaje Where id_Personaje in (Select Id_Personaje from Personajes Where Id_Raza in (4,6) )
Delete From Personajes Where Id_Personaje Not In (Select Id_Personaje From EstadisticasPersonaje)
RollBack Tran
--Generar consultas SQL a las tablas de su base de datos, clasificadas de la siguiente manera: 

-- 3 consultas que contengan DISTINCT

	--Mostrar las distintas convinaciones de de tipo de clase, y dados de da�o y cantidad de clases con esa convinacion
	Select Distinct  TipoClase, DadoDa�o, Count(*) as 'No De Clases' From Clases Group By TipoClase,DadoDa�o;
	
	-- Mostar los distintas razas con las que se han creado personajes
	Select Distinct P.Id_Raza, R.NombreRaza From Personajes P
	Join Razas R on R.Id_Raza = P.Id_Raza

	Select Distinct P.Id_Clase, C.NombreClase From Personajes P
	Join Clases C on C.Id_Clase = P.Id_Clase

-- 3 consultas que contengan AND/OR/NOT 

	--selecciona las clases magicas quen da�o mayor o igual a 8
	SELECT NombreClase, TipoClase, DadoDa�o
	FROM Clases
	WHERE TipoClase = 'Magica' AND DadoDa�o >= 8;

	--selecciona todas las razas que sean de tama�o mediano o grande
	SELECT NombreRaza, Tama�oRaza, VelocidadRaza
	FROM Razas
	WHERE Tama�oRaza = 'Mediano' OR Tama�oRaza = 'Grande';

	--selecciona todas aqueyas competencias que no sean de tipo armadura
	SELECT NombreCompetencia, TipoCompetencia,DescripcionCompetencia
	FROM Competencias
	WHERE NOT TipoCompetencia = 'Armadura';

-- 3 consultas que contengan ORDER BY 

	--
	Select NombreClase, DadoDa�o, TipoClase, DescripcionClase From Clases 
	Order By DadoDa�o DESC
	--
	Select P.NombrePersonaje, P.Nivel, P.BonusCompetencia,C.NombreClase,R.NombreRaza  From Personajes  P
	Inner Join Clases C On C.Id_Clase = P.Id_Clase
	Join Razas R on R.Id_Raza = P.Id_Raza
	Order By Nivel ASC
	--
	Select R.NombreRaza, R.VelocidadRaza,R.Tama�oRaza From Razas R
	Order By VelocidadRaza DESC

-- 3 consultas que contengan MIN 

	SELECT* FROM Clases
	SELECT NombreClase,TipoClase,DadoDa�o FROM Clases WHERE DadoDa�o = (SELECT MIN(DadoDa�o) FROM Clases);

	SELECT* FROM Razas
	SELECT NombreRaza, DescripcionRaza, Tama�oRaza,  VelocidadRaza FROM Razas WHERE VelocidadRaza = (SELECT MIN(VelocidadRaza) FROM Razas);

	SELECT* FROM Personajes
	SELECT NombrePersonaje, Nivel FROM Personajes WHERE Nivel = (SELECT MIN(Nivel) FROM Personajes);

-- 3 consultas que contengan MAX 
	SELECT * FROM Clases
	SELECT NombreClase,TipoClase,DadoDa�o FROM Clases WHERE DadoDa�o = (SELECT MAX(DadoDa�o) FROM Clases);

	SELECT* FROM Razas
	SELECT NombreRaza, DescripcionRaza, Tama�oRaza,  VelocidadRaza FROM Razas WHERE VelocidadRaza = (SELECT MAX(VelocidadRaza) FROM Razas);

	SELECT * FROM Personajes
	SELECT NombrePersonaje, Nivel FROM Personajes WHERE Nivel = (SELECT MAX(Nivel) FROM Personajes);

-- 3 consultas que contengan COUNT 
	--Contar Personajes de Raza Gnomo
	Select Count(*) As 'No. de Gnomos' From Personajes Where Id_Raza = (Select Id_Raza From Razas Where NombreRaza = 'Gnomo')
	--Contar Personajes de clase 
	Select Count(*) As 'No. De Artifices' From Personajes Where Id_Clase = (Select Id_Clase From Clases Where NombreClase = 'Artifice')
	--Contar Sublases
	Select Count(*) As 'No. De Subclases' From Subclases


-- 3 consultas que contengan AVG 
	--Obtener estadisticas medias entre los personajes
	Select Avg(Fuerza) As 'Fuerza Media',Avg(Destreza) As 'Destreza Media',Avg(Constitucion) As 'Constitucion Media',Avg(Inteligencia) As 'Inteligencia Media',Avg(Sabiduria) as 'Sabiduria Media',Avg(Carisma) as 'Carisma Media'
	From EstadisticasPersonaje
	--Obtener nivel medio de los personajes
	Select AVG(Nivel)  As 'Nivel Medio' From Personajes
	--Obtener
	Select AVG(VelocidadRaza) As 'Velocidad Media' From Razas

-- 3 consultas que contengan SUM

	-- suma da todas las velosidades de las razas
	SELECT SUM(VelocidadRaza) AS TotalVelocidad
	FROM Razas;

	--Suma de da�o de todas las clases:
	SELECT SUM(DadoDa�o) AS Da�oTotal
	FROM Clases;

	--Suma del total de atributos de todas las estad�sticas raciales:
	SELECT SUM(EP.Fuerza + EP.Destreza + EP.Constitucion + EP.Inteligencia + EP.Sabiduria + EP.Carisma) AS TotalAtributosRaciales
	FROM EstadisticasPersonaje EP
	Join Personajes P On P.Id_Personaje=Ep.Id_Personaje

-- 3 consultas que involucren TOP 

	--Las 3 clases con mayor dado de da�o:
	SELECT TOP 3 NombreClase, DadoDa�o
	FROM Clases
	ORDER BY DadoDa�o DESC;

	--Las 5 primeras razas seg�n su velocidad:
	SELECT TOP 5 NombreRaza, VelocidadRaza
	FROM Razas
	ORDER BY VelocidadRaza DESC;

	--Los primeros 3 personajes creados:
	SELECT TOP 3 NombrePersonaje, Nivel
	FROM Personajes
	ORDER BY Id_Personaje ASC;


-- 3 consultas que contengan LIKE
	--selecciona razas que incluyan "elf" en su nombre:
	SELECT * FROM Razas
	WHERE NombreRaza LIKE '%elf%';

	--selecciona clases cuyo nombre empiece con "Ba":
	SELECT * FROM Clases
	WHERE NombreClase LIKE 'Ba%';

	-- selecciona Subclases que terminan en "ista":
	SELECT * FROM Subclases
	WHERE NombreSubclase LIKE 'Dominio%';

-- 3 consultas que contengan IN 

	--Personajes que son de clases espec�ficas (por ejemplo, 1, 2 y 3):
	SELECT NombrePersonaje, Id_Clase
	FROM Personajes
	WHERE Id_Clase IN (1, 2, 3);

	--Razas con tama�o espec�fico:
	SELECT *
	FROM Razas
	WHERE Tama�oRaza IN ('Mediano', 'Grande');

	--Clases que tienen dado de da�o en esta lista:
	SELECT NombreClase, DadoDa�o
	FROM Clases
	WHERE DadoDa�o IN (6, 8, 10);

-- 3 consultas que contengan BETWEEN


	--Personajes con nivel entre 3 y 7:
	SELECT NombrePersonaje, Nivel
	FROM Personajes
	WHERE Nivel BETWEEN 3 AND 7;

	--Dado de da�o de clases entre 4 y 10:
	SELECT NombreClase, DadoDa�o
	FROM Clases
	WHERE DadoDa�o BETWEEN 4 AND 10;

	--Velocidad de raza entre 25 y 35:
	SELECT NombreRaza, VelocidadRaza
	FROM Razas
	WHERE VelocidadRaza BETWEEN 25 AND 35;
