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
	DadoDano int NOT NULL,
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

INSERT INTO Clases ( NombreClase, DescripcionClase, TipoClase, DadoDano) VALUES
('Barbaro', 'Un guerrero feroz impulsado por la furia.', 'Marcial', 12),
('Bardo', 'Un musico y narrador con magia.', 'Mixta', 8),
('Brujo', 'Un mago que obtiene poder de un pacto oscuro.', 'Magica', 8),
('Clerigo', 'Un devoto con poderes divinos.', 'Magica', 8),
('Druida', 'Un guardian de la naturaleza con magia.', 'Magica', 8),
('Explorador', 'Un rastreador y combatiente agil.', 'Mixta', 10),
('Hechicero', 'Un lanzador de conjuros con magia innata.', 'Magica', 6),
('Guerrero', 'Un maestro de las armas y la tactica.', 'Marcial', 10),
('Monje', 'Un guerrero autodisciplinado con energia Ki.', 'Marcial', 8),
( 'Mago', 'Un estudioso de la magia arcana.', 'Magica', 6),
( 'Paladin', 'Un guerrero sagrado con magia divina.', 'Mixta', 10),
( 'Picaro', 'Un especialista en sigilo y precision.', 'Marcial', 8),
( 'Artifice', 'Un inventor y creador de magia.', 'Mixta', 8);

INSERT INTO AtributosClase (Id_Clase, NombreAtributo, Descripcion, Nivel) VALUES  
-- Barbaro  
(1, 'Furia', 'Puedes entrar en un estado de rabia en combate para aumentar el dano.', 1),  
(1, 'Defensa sin Armadura', 'CA = 10 + CON + DEX si no llevas armadura.', 1),  
(1, 'Ataque Temerario', 'Puedes obtener ventaja en ataques cuerpo a cuerpo a cambio de desventaja al recibir ataques.', 2),  
(1, 'Ataque Adicional', 'Puedes atacar dos veces en tu turno en lugar de una.', 5),  
-- Bardo  
(2, 'Inspiracion Bardica', 'Otorgas un dado de inspiracion a un aliado para mejorar sus tiradas.', 1),  
(2, 'Repertorio de Hechizos', 'Aprendes y puedes lanzar conjuros de la lista de Bardo.', 2),  
(2, 'Fuente de Inspiracion', 'Recuperas los usos de Inspiracion Bardica tras un descanso corto o largo.', 5),  
-- Brujo  
(3, 'Patron Mistico', 'Haces un pacto con una entidad poderosa.', 1),  
(3, 'Magia de Pacto', 'Tienes conjuros y ranuras de magia especiales.', 1),  
(3, 'Eldritch Invocations', 'Accedes a invocaciones misticas para personalizar tu poder.', 2),  
(3, 'Maleficio Mejorado', 'Tu Maldicion de Pacto gana mejoras adicionales.', 5),  
-- Clerigo  
(4, 'Lanzamiento de Conjuros Divinos', 'Aprendes y puedes lanzar conjuros de la lista de Clerigo.', 1),  
(4, 'Dominio Divino', 'Obtienes un dominio divino con habilidades adicionales.', 1),  
(4, 'Canalizar Divinidad', 'Usas poder divino para obtener efectos especiales.', 2),  
(4, 'Golpe Potenciado', 'Aumentas el dano de un ataque cuerpo a cuerpo con energia divina.', 5),  
-- Druida  
(5, 'Forma Salvaje', 'Puedes transformarte en una bestia.', 2),  
(5, 'Recuperacion Natural', 'Recuperas ranuras de conjuro tras un descanso corto.', 2),  
(5, 'Sentidos Mejorados', 'Tu vista y oido mejoran cuando estas en forma salvaje.', 2),  
(5, 'Conexion con la Naturaleza', 'Puedes comunicarte con animales y plantas.', 3),  
-- Explorador  
(6, 'Explorador Natural', 'Eres experto en moverte en ciertos terrenos.', 1),  
(6, 'Enemigo Predilecto', 'Obtienes ventajas contra criaturas especificas.', 1),  
(6, 'Estilo de Combate', 'Eliges una especializacion de combate.', 2),  
(6, 'Ataque del Cazador', 'Haces mas dano en ciertas condiciones.', 5),  
-- Hechicero  
(7, 'Origenes de la Magia', 'Tu magia proviene de una fuente innata.', 1),  
(7, 'Poder Magico', 'Obtienes puntos de Hechiceria para mejorar conjuros.', 1),  
(7, 'Metamagia', 'Puedes modificar conjuros con efectos especiales.', 3),  
(7, 'Reservorio Arcano', 'Aumentas el dano o curacion de un conjuro.', 5),  
-- Guerrero  
(8, 'Estilo de Combate', 'Eliges un estilo de combate especializado.', 1),  
(8, 'Accion Adicional', 'Obtienes un turno extra en combate.', 2),  
(8, 'Segundo Aliento', 'Puedes usar un recurso para recuperar puntos de golpe.', 2),  
(8, 'Indomable', 'Puedes repetir una tirada de salvacion fallida una vez por descanso largo.', 5),  
-- Monje  
(9, 'Defensa sin Armadura', 'CA = 10 + DEX + SAB si no llevas armadura.', 1),  
(9, 'Artes Marciales', 'Tus golpes sin armas son mas fuertes.', 1),  
(9, 'Ki', 'Obtienes puntos de Ki para realizar habilidades especiales.', 2),  
(9, 'Deflexion de Proyectiles', 'Reduces el dano de ataques a distancia.', 5),  
-- Mago  
(10, 'Preparacion de Hechizos', 'El mago puede preparar un numero de conjuros de su lista de conjuros de mago.', 1),  
(10, 'Conjuro de Concentracion', 'El mago es capaz de mantener un conjuro de concentracion durante mas tiempo.', 2),  
-- Paladin  
(11, 'Imponer Manos', 'Sanacion divina mediante la imposicion de manos.', 1),  
(11, 'Sentir el Mal', 'Detectas presencias malignas y celestiales a tu alrededor.', 1),  
(11, 'Estilo de Combate', 'Eliges una especializacion de combate.', 2),  
(11, 'Golpe Divino', 'Puedes gastar ranuras de conjuro para hacer dano extra en un ataque cuerpo a cuerpo.', 5),  
-- Picaro  
(12, 'Ataque Furtivo', 'Haces dano extra cuando tienes ventaja o un aliado cerca.', 1),  
(12, 'Esquiva Sobrenatural', 'Reduces el dano de un ataque que te impacta.', 2),  
(12, 'Evasion', 'Los efectos de area que requieran salvacion de Destreza te afectan menos.', 3),  
(12, 'Habil', 'Obtienes competencia en mas habilidades.', 5),  
-- Artifice  
(13, 'Infusion Magica', 'Puedes imbuir objetos con magia temporalmente.', 1),  
(13, 'Herrero Magico', 'Puedes crear y mejorar equipo con propiedades magicas.', 2),  
(13, 'Creador de Prodigios', 'Disenas artilugios magicos y herramientas.', 3),  
(13, 'Mejora Experimental', 'Otorgas a un objeto propiedades magicas especiales.', 5);  

--	Subclases:

INSERT INTO Subclases ( Id_Clase, NombreSubclase, DescripcionSubclase) VALUES
-- Barbaro
( 1, 'Berserker', 'Un guerrero impulsado por la furia, capaz de entrar en un estado de locura durante la batalla, ganando gran poder fisico.'),
( 1, 'Camino del Totem', 'Un guerrero que sigue el camino de un espiritu animal, obteniendo poderes especiales de su totem elegido.'),
-- Bardo
( 2, 'College of Lore', 'Un bardo erudito, experto en historia y magia arcana, que utiliza su conocimiento para influir en el mundo.'),
( 2, 'College of Valor', 'Un bardo guerrero, inspirado por la valentia, que incita a sus aliados a la accion y combate de manera valiente.'),
-- Brujo
( 3, 'El Pacto de la Llama Eterna', 'Un brujo que obtiene poder a traves de un pacto con una entidad elemental de fuego, dominando la magia destructiva.'),
( 3, 'El Pacto de la Sombras', 'Un brujo que hace un pacto con una entidad oscura, obteniendo poderes sobre la oscuridad y la manipulacion de la mente.'),
-- Clerigo
( 4, 'Dominio de la Luz', 'Un clerigo que se dedica a la lucha contra el mal, utilizando la luz y la sanacion para proteger a los inocentes.'),
( 4, 'Dominio de la Guerra', 'Un clerigo guerrero que mezcla sus poderes divinos con habilidades marciales para proteger a sus companeros en la batalla.'),
( 4, 'Dominio de la Vida', 'Un clerigo sanador, enfocado en curar y proteger a los heridos y necesitados.'),
-- Druida
( 5, 'Circulo de la Luna', 'Un druida con la habilidad de transformarse en poderosas bestias, tomando formas animales para afrontar cualquier desafio.'),
( 5, 'Circulo de la Tierra', 'Un druida profundamente conectado con la naturaleza, capaz de manipular la tierra y las criaturas de la tierra.'),
-- Explorador
( 6, 'Cazador', 'Un experto en la caza, el rastreo y el combate a distancia, capaz de usar diversas tacticas en la naturaleza.'),
( 6, 'Explorador de la Selva', 'Un explorador habil en moverse por la selva y en enfrentarse a los peligros que presenta el entorno selvatico.'),
-- Hechicero
( 7, 'Linaje draconico', 'Un hechicero que tiene sangre de dragon, obteniendo poderes especiales relacionados con los dragones.'),
( 7, 'Hechiceria salvaje', 'Un hechicero cuyo poder es erratico y descontrolado, con efectos magicos impredecibles pero poderosos.'),
--Guerrero
( 8, 'Maestro de Batalla', 'Un guerrero experto en tacticas de combate y habilidades marciales, que se adapta a cualquier situacion en la batalla.'),
( 8, 'Cruzado', 'Un guerrero dedicado al combate sagrado y a la lucha contra los enemigos de su causa.'),
-- Monje
( 9, 'Camino del Puno de Hierro', 'Un monje que perfecciona su cuerpo y su disciplina en combate cuerpo a cuerpo, volviendose una fuerza de la naturaleza.'),
( 9, 'Camino de la Sombra', 'Un monje entrenado en el sigilo y en el control de la energia espiritual, capaz de moverse en las sombras sin ser detectado.'),
-- Mago
( 10, 'Escuela de la Evocacion', 'Un mago que se especializa en la creacion y manipulacion de energia arcana para causar efectos destructivos.'),
( 10, 'Escuela de la Ilusion', 'Un mago experto en crear ilusiones y enganar a sus enemigos, confundiendolos y manipulando sus percepciones.'),
-- Paladin
(11, 'Juramento de Devocion', 'Un paladin que sigue el juramento de la devocion, buscando la pureza, la bondad y la justicia en todo lo que hace.'),
(11, 'Juramento de los Vengadores', 'Un paladin que busca venganza contra aquellos que han hecho dano a su causa o a sus seres queridos.'),
-- Picaro
( 12, 'Ladron', 'Un picaro experto en el sigilo y el robo, siempre en busca de la proxima gran oportunidad.'),
( 12, 'Asesino', 'Un picaro letal en el combate, entrenado en el arte de eliminar a sus enemigos rapidamente y sin ser detectado.'),
-- Artifice
( 13, 'Alquimista', 'Un artifice que usa la ciencia y la magia para crear pociones y elixires con propiedades extraordinarias.'),
( 13, 'Artifice de guerra', 'Un artifice enfocado en el uso de la ingenieria y la magia para construir poderosas maquinas de guerra.');


-- Atributos Subclases
-- Barbaro
INSERT INTO AtributosSubclase (Id_Subclase, NombreAtributo, Descripcion, Nivel) VALUES
(1, 'Furia Imparable', 'El berserker entra en un estado de furia que le otorga ventaja en las tiradas de ataque y resistencia a los danos durante 1 minuto. Este efecto se activa al entrar en combate.', 3),
(2, 'Espiritu del Totem', 'El barbaro puede invocar el poder de su espiritu animal, otorgandole resistencia a un tipo de dano especifico (fuego, frio, etc.) dependiendo del totem elegido.', 3),
-- Bardo
(3, 'Conocimiento Encantado', 'El bardo puede utilizar su conocimiento para lanzar hechizos con mayor efectividad, ganando un bono a la dificultad de los hechizos de engano y manipulacion.', 3),
(4, 'Valor Inspirador', 'El bardo puede inspirar a sus aliados, otorgandoles un bono de moral a las tiradas de ataque y salvacion durante 1 minuto.', 3),
-- Brujo
(5, 'Llama Desgarradora', 'El brujo puede invocar una llama ardiente en su mano, causando dano de fuego a los enemigos cercanos con un ataque de area.', 3),
(6, 'Manipulacion Sombria', 'El brujo puede manipular sombras a su alrededor, otorgandose invisibilidad parcial por 1 minuto, dificultando que los enemigos lo detecten.', 3),
-- Clerigo
(7, 'Luz Pura', 'El clerigo puede canalizar energia radiante para purificar areas de oscuridad y curar a los aliados cercanos con dano radiante.', 1),
(8, 'Fuerza Divina', 'El clerigo puede canalizar su energia divina para mejorar su destreza en combate, otorgandole un bono a la tirada de ataque y dano en combate cuerpo a cuerpo.', 1),
(9, 'Toque Sanador', 'El clerigo puede curar una cantidad de puntos de golpe adicionales a un objetivo con un toque divino.', 1),
-- Druida
(10, 'Bendicion de la Tierra', 'El druida puede invocar una bendicion de la tierra para aumentar la resistencia de sus aliados a un tipo de dano (fisico, elemental, etc.).', 3),
(11, 'Transformacion Bestial', 'El druida obtiene una forma bestial mejorada, lo que le permite transformarse en criaturas mas poderosas y con habilidades adicionales al usar su forma salvaje.', 2),
-- Explorador
(12, 'Tecnica de Caza', 'El cazador obtiene un bono de dano adicional cuando ataca a criaturas que ya hayan sido marcadas por su rastreo o caza.', 3),
(13, 'Camuflaje Natural', 'El explorador puede camuflarse en la jungla o vegetacion, volviendose practicamente invisible en ese entorno.', 3),
-- Hechicero
(14, 'Aliento Draconico', 'El hechicero puede utilizar un aliento de dragon, causando dano de un tipo especifico (fuego, hielo, acido, etc.) en un cono frente a el.', 1),
(15, 'Descontrol Magico', 'Los hechizos del hechicero pueden tener efectos aleatorios, pero tambien se vuelve mas fuerte, obteniendo un bono al dano o al numero de objetivos de sus hechizos.', 1),
-- Guerrero
(16, 'Tacticas de Guerra', 'El guerrero puede usar su accion para analizar el campo de batalla, obteniendo ventaja en las tiradas de ataque contra un enemigo especifico durante el resto del turno.', 3),
(17, 'Juramento Sagrado', 'El guerrero puede invocar un juramento sagrado, obteniendo resistencia a todos los tipos de dano mientras protege a sus aliados.', 3),
-- Monje
(18, 'Golpe Mortal', 'El monje puede canalizar su energia espiritual para realizar un golpe devastador, ignorando resistencias y causando dano adicional.', 3),
(19, 'Desplazamiento Sombrio', 'El monje puede moverse en las sombras a gran velocidad, teletransportandose a un area oscura que haya visto antes.', 3),
-- Mago
(20, 'Explosion Arcana', 'El mago puede crear una explosion de energia arcana que causa dano a todos los enemigos en un area, con una mayor cantidad de dano si el objetivo esta cerca de la fuente.', 2),
(21, 'Distorsion Mental', 'El mago puede crear ilusiones tan realistas que desorientan a sus enemigos, dandoles desventaja en sus ataques y salvaciones.', 2),
-- Paladin
(22, 'Aura de Pureza', 'El paladin crea un aura que purifica a sus aliados de efectos negativos y les otorga resistencia a la necrosis y la energia oscura.', 3),
(23, 'Juramento de Venganza', 'El paladin puede canalizar su ira para hacer un dano adicional a los enemigos que haya marcado como objetivo de su venganza.', 3),
-- Picaro
(24, 'Reflejos Rapidos', 'El picaro puede usar su accion de bonificacion para esquivar un ataque o moverse sin provocar ataques de oportunidad.', 3),
(25, 'Matanza Silenciosa', 'El picaro puede eliminar a un enemigo con un ataque sorpresa instantaneo si no ha sido detectado.', 3),
-- Artifice
(26, 'Elixir Mejorado', 'El artifice puede crear elixires que aumentan las habilidades de sus aliados, otorgandoles bonificaciones temporales a la fuerza, agilidad o resistencia.', 3),
(27, 'Artilugio de Guerra', 'El artifice puede construir dispositivos magicos y mecanicos que le permiten aumentar su capacidad en combate, proporcionando armas o herramientas avanzadas.', 3);

--	Razas
INSERT INTO Razas ( NombreRaza, DescripcionRaza, TamanoRaza, VelocidadRaza) VALUES
( 'Humano', 'Versatil y adaptable.', 'Mediano', 30),
( 'Elfo', 'agiles y longevos.', 'Mediano', 40),
( 'Enano', 'Resistentes y tenaces.', 'Mediano', 25),
( 'Mediano', 'Pequenos pero agiles.', 'Pequeno', 25),
( 'Draconido', 'Descendientes de dragones.', 'Mediano', 30),
( 'Gnomo', 'Pequenos y astutos.', 'Pequeno', 25),
( 'Semi-Orco', 'Fuerza bruta y ferocidad.', 'Grande', 30),
( 'Tiefling', 'De ascendencia infernal.', 'Mediano', 35),
( 'Semielfo', 'Agiles y versatiles', 'Mediano', 35)

INSERT INTO EstadisticasRaza (Id_Raza, Fuerza, Destreza, Constitucion, Inteligencia, Sabiduria, Carisma) VALUES
(1, 1, 1, 1, 1, 1, 1), -- Humanos: +1 en todo
(2, 0, 2, 0, 0, 1, 0), -- Elfos: +2 Destreza, +1 Sabiduria
(3, 0, 0, 2, 0, 0, 0), -- Enanos: +2 Constitucion
(4, 0, 2, 0, 0, 0, 0), -- Medianos: +2 Destreza
(5, 2, 0, 0, 0, 0, 1), -- Draconidos: +2 Fuerza, +1 Carisma
(6, 0, 0, 0, 2, 0, 0), -- Gnomos: +2 Inteligencia
(7, 2, 0, 1, 0, 0, 0), -- Semi-Orcos: +2 Fuerza, +1 Constitucion
(8, 0, 0, 0, 1, 0, 2), -- Tieflings: +1 Inteligencia, +2 Carisma
(9, 0, 2, 0, 0, 1, 0) -- Semielfos: +1 Destreza, +1 Sabiduria, +1 Inteligencia

-- Insertar Atributos de Raza con la nueva estructura  
INSERT INTO AtributosRaza (Id_Raza, NombreAtributo, Descripcion, Nivel) VALUES  
-- Humanos  
(1, 'Maestria en Habilidades', 'Obtienes competencia en una o mas habilidades.', 1),  

-- Elfos  
(2, 'Vision en la Oscuridad', 'Puedes ver en la oscuridad en un rango de 60 pies.', 1),  
(2, 'Maestria en Habilidades', 'Obtienes competencia en una o mas habilidades.', 1),  
(2, 'Linaje Feerico', 'Ventaja en tiradas de salvacion contra encantamientos; la magia no puede hacerte dormir.', 1),  

-- Enanos  
(3, 'Vision en la Oscuridad', 'Puedes ver en la oscuridad en un rango de 60 pies.', 1),  
(3, 'Resistencia a Dano', 'Tienes resistencia a un tipo de dano especifico segun tu raza.', 1),  
(3, 'Maestria en Habilidades', 'Obtienes competencia en una o mas habilidades.', 1),  
(3, 'Afinidad con la Piedra', 'Eres competente en Historia cuando evaluas construcciones de piedra.', 1),  

-- Medianos  
(4, 'Velocidad Aumentada', 'Tu velocidad base es mayor que la de otras razas.', 1),  
(4, 'Maestria en Habilidades', 'Obtienes competencia en una o mas habilidades.', 1),  
(4, 'Suerte Mediana', 'Cuando sacas un 1 en una tirada de ataque, habilidad o salvacion, puedes repetir la tirada.', 1),  

-- Draconidos  
(5, 'Vision en la Oscuridad', 'Puedes ver en la oscuridad en un rango de 60 pies.', 1),  
(5, 'Resistencia a Dano', 'Tienes resistencia a un tipo de dano especifico segun tu raza.', 1),  
(5, 'Arma de Aliento', 'Puedes exhalar un aliento elemental segun tu ascendencia draconica.', 1),  
(5, 'Resistencia Draconica', 'Tienes resistencia a un tipo de dano segun tu ascendencia draconica.', 1),  

-- Gnomos  
(6, 'Maestria en Habilidades', 'Obtienes competencia en una o mas habilidades.', 1),  
(6, 'Astucia Gnomica', 'Ventaja en tiradas de salvacion de Inteligencia, Sabiduria y Carisma contra magia.', 1),  

-- Semi-Orcos  
(7, 'Vision en la Oscuridad', 'Puedes ver en la oscuridad en un rango de 60 pies.', 1),  
(7, 'Tolerancia de Semiorco', 'Cuando caes a 0 puntos de golpe, puedes quedarte en 1 en lugar de caer inconsciente.', 1),  
(7, 'Ataque Salvaje', 'Cuando sacas un critico con un ataque cuerpo a cuerpo, sumas un dado extra de dano.', 1),  

-- Tieflings  
(8, 'Vision en la Oscuridad', 'Puedes ver en la oscuridad en un rango de 60 pies.', 1),  
(8, 'Resistencia Infernal', 'Tienes resistencia al dano de fuego.', 1),  
(8, 'Legado Infernal', 'Conoces el truco *Taumaturgia* y obtienes mas conjuros a niveles superiores.', 1);  


--Competencias
INSERT INTO Competencias (NombreCompetencia, TipoCompetencia, DescripcionCompetencia) VALUES
-- Armas
('Armas Ligeras', 'Arma', 'Un conjunto de armas pequenas y faciles de usar, como dagas, dardos, etc.'),
('Armas Marciales', 'Arma', 'Armas mas grandes y poderosas, como espadas largas, hachas de batalla y lanzas.'),
('Armas a Distancia', 'Arma', 'Armas que permiten atacar a distancia, como arcos y ballestas.'),

-- Armaduras
('Armaduras Ligeras', 'Armadura', 'Armaduras que proporcionan una proteccion minima pero permiten gran movilidad, como cueros y cotas de malla.'),
('Armaduras Medianas', 'Armadura', 'Armaduras que ofrecen un equilibrio entre proteccion y movilidad, como cota de malla reforzada y armaduras de escamas.'),
('Armaduras Pesadas', 'Armadura', 'Armaduras que ofrecen una alta proteccion a costa de la movilidad, como placas y armaduras de placas.'),
('Escudos', 'Armadura', 'Proteccion adicional para bloquear ataques, que se lleva en la mano.'),

-- Herramientas
('Herramientas de Artesano', 'Herramienta', 'Conjunto de herramientas especializadas para realizar trabajos artesanales, como herreria o carpinteria.'),
('Herramientas de Alquimista', 'Herramienta', 'Herramientas necesarias para la creacion de pociones y elixires.'),
('Herramientas de Ladron', 'Herramienta', 'Herramientas utilizadas para el robo y el sigilo, como ganzuas y herramientas de desactivacion de trampas.'),
('Herramientas de Tinker', 'Herramienta', 'Herramientas utilizadas para la creacion de dispositivos mecanicos, como relojes y pequenas maquinas.'),

-- Otros
('Juegos de Mesa', 'Otro', 'Competencia en juegos de azar o juegos de mesa como el ajedrez, damas o el poker.'),
('Vehiculos (terrestres)', 'Otro', 'Competencia en el manejo de vehiculos como carretas o carros tirados por caballos.'),

-- Instrumentos Musicales
('Instrumentos de Cuerda', 'Herramienta', 'Competencia con instrumentos de cuerda como laud, violin, arpa y guitarra.'),
('Instrumentos de Viento', 'Herramienta', 'Competencia con instrumentos de viento como flauta, trompeta y gaita.'),
('Instrumentos de Percusion', 'Herramienta', 'Competencia con instrumentos de percusion como tambores, bongos y xilofono.'),
('Kit de Disfraz', 'Herramienta', 'Conjunto de maquillajes, vestimentas y accesorios para cambiar de apariencia e identidad.'),
('Kit de Medicina', 'Herramienta', 'Instrumentos y suministros medicos basicos para tratar heridas y enfermedades.');

-- Insertar las relaciones entre competencias y clases
INSERT INTO CompetenciasClase (Id_Competencia, Id_Clase) VALUES
-- Barbaro
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

-- Clerigo
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

-- Paladin
(1, 11), -- Armas Ligeras
(2, 11), -- Armas Marciales
(4, 11), -- Armaduras Ligeras
(5, 11), -- Armaduras Medianas
(6, 11), -- Escudos

-- Picaro
(1, 12), -- Armas Ligeras
(4, 12), -- Armaduras Ligeras
(7, 12), -- Herramientas de Ladron

-- Artifice
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
('Tareen Stonelog', 3, 13, 27, 3, 2), -- Artifice, Artifice de guerra, raza Enano
('Phoebe Lyre', 3, 13, 27, 5, 2), -- Artifice, Herrero de guerra, raza Draconida
('Meliza', 2, 2, 4, 4, 1), -- Bardo, College of Valor, raza Humano
('Mico Loamir', 1, 5, 10, 8, 2), -- Druida, Circulo de la Tierra, raza Firbolg
('Lydia Blackthorn', 5, 8, 16, 6, 3), -- Guerrero, Maestro de Batalla, raza Semielfo
('Kaelen Dawnstrike', 4, 11, 22, 4, 2),  -- Paladin, Juramento de Devocion, Humano
('Zyra Nightwhisper', 5, 12, 25, 7, 3),  -- Picaro, Asesino, Elfo
('Thorin Ironfist', 3, 1, 1, 3, 2),      -- Barbaro, Berserker, Enano
('Selene Moonshadow', 5, 10, 21, 7, 3),  -- Mago, Ilusion, Elfo
( 'Vex Stormborn', 3, 7, 14, 6, 2),      -- Hechicero, Linaje draconico, Semielfo
( 'Garruk Bearheart', 4, 9, 18, 3, 2),   -- Monje, Puno de Hierro, Enano
( 'Eldrin Starfall', 2, 6, 12, 7, 1),    -- Explorador, Cazador, Elfo
( 'Mira Emberflare', 5, 3, 5, 6, 3),     -- Brujo, Pacto de la Llama Eterna, Semielfo
( 'Lyra Windwhisper', 4, 2, 3, 7, 2) ,    -- Bardo, College of Lore, Elfo
( 'Darius Ironwood', 3, 8, 16, 2, 2),    -- Guerrero, Maestro de Batalla, Mediano
( 'Roland Blackthorn', 3, 11, 23, 6, 2), -- Paladin, Vengadores, Semielfo
( 'Nalia Swiftblade', 2, 12, 24, 2, 1),  -- Picaro, Ladron, Mediano
( 'Korin Thunderfist', 4, 1, 2, 3, 2),   -- Barbaro, Camino del Totem, Enano
( 'Soren Duskrunner', 5, 9, 19, 7, 3),   -- Monje, Camino de la Sombra, Elfo
( 'Isolde Frostbane', 3, 4, 8, 5, 2);    -- Clerigo, Dominio de la Guerra, Tiefling


--Select * From Personajes

-- Insertar estadisticas para los personajes
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

SELECT * FROM Personajes;
SELECT * FROM EstadisticasPersonaje;

Select P.NombrePersonaje, P.Nivel, C.NombreClase, SC.NombreSubclase, R.NombreRaza
From Personajes P
INNER JOIN Clases C On C.Id_Clase=P.Id_Clase
Inner Join Subclases SC On SC.Id_Subclase = P.Id_Subclase
Inner Join Razas R On R.Id_Raza=P.Id_Raza 
