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
	DadoDaño int NOT NULL,
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
	TamañoRaza Varchar(10) Check (TamañoRaza in ('Pequeño','Mediano','Grande','Enorme')) Default 'Mediano',
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
--	Daño INT,
--	DadoDaño INT,
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

INSERT INTO Clases ( NombreClase, DescripcionClase, TipoClase, DadoDaño) VALUES
('Barbaro', 'Un guerrero feroz impulsado por la furia.', 'Marcial', 12),
('Bardo', 'Un músico y narrador con magia.', 'Mixta', 8),
('Brujo', 'Un mago que obtiene poder de un pacto oscuro.', 'Magica', 8),
('Clerigo', 'Un devoto con poderes divinos.', 'Magica', 8),
('Druida', 'Un guardián de la naturaleza con magia.', 'Magica', 8),
('Explorador', 'Un rastreador y combatiente ágil.', 'Mixta', 10),
('Hechicero', 'Un lanzador de conjuros con magia innata.', 'Magica', 6),
('Guerrero', 'Un maestro de las armas y la táctica.', 'Marcial', 10),
('Monje', 'Un guerrero autodisciplinado con energía Ki.', 'Marcial', 8),
( 'Mago', 'Un estudioso de la magia arcana.', 'Magica', 6),
( 'Paladin', 'Un guerrero sagrado con magia divina.', 'Mixta', 10),
( 'Picaro', 'Un especialista en sigilo y precisión.', 'Marcial', 8),
( 'Artifice', 'Un inventor y creador de magia.', 'Mixta', 8);

INSERT INTO AtributosClase (Id_Clase, NombreAtributo, Descripcion, Nivel) VALUES  
-- Bárbaro  
(1, 'Furia', 'Puedes entrar en un estado de rabia en combate para aumentar el daño.', 1),  
(1, 'Defensa sin Armadura', 'CA = 10 + CON + DEX si no llevas armadura.', 1),  
(1, 'Ataque Temerario', 'Puedes obtener ventaja en ataques cuerpo a cuerpo a cambio de desventaja al recibir ataques.', 2),  
(1, 'Ataque Adicional', 'Puedes atacar dos veces en tu turno en lugar de una.', 5),  
-- Bardo  
(2, 'Inspiración Bárdica', 'Otorgas un dado de inspiración a un aliado para mejorar sus tiradas.', 1),  
(2, 'Repertorio de Hechizos', 'Aprendes y puedes lanzar conjuros de la lista de Bardo.', 2),  
(2, 'Fuente de Inspiración', 'Recuperas los usos de Inspiración Bárdica tras un descanso corto o largo.', 5),  
-- Brujo  
(3, 'Patrón Místico', 'Haces un pacto con una entidad poderosa.', 1),  
(3, 'Magia de Pacto', 'Tienes conjuros y ranuras de magia especiales.', 1),  
(3, 'Eldritch Invocations', 'Accedes a invocaciones místicas para personalizar tu poder.', 2),  
(3, 'Maleficio Mejorado', 'Tu Maldición de Pacto gana mejoras adicionales.', 5),  
-- Clérigo  
(4, 'Lanzamiento de Conjuros Divinos', 'Aprendes y puedes lanzar conjuros de la lista de Clérigo.', 1),  
(4, 'Dominio Divino', 'Obtienes un dominio divino con habilidades adicionales.', 1),  
(4, 'Canalizar Divinidad', 'Usas poder divino para obtener efectos especiales.', 2),  
(4, 'Golpe Potenciado', 'Aumentas el daño de un ataque cuerpo a cuerpo con energía divina.', 5),  
-- Druida  
(5, 'Forma Salvaje', 'Puedes transformarte en una bestia.', 2),  
(5, 'Recuperación Natural', 'Recuperas ranuras de conjuro tras un descanso corto.', 2),  
(5, 'Sentidos Mejorados', 'Tu vista y oído mejoran cuando estás en forma salvaje.', 2),  
(5, 'Conexión con la Naturaleza', 'Puedes comunicarte con animales y plantas.', 3),  
-- Explorador  
(6, 'Explorador Natural', 'Eres experto en moverte en ciertos terrenos.', 1),  
(6, 'Enemigo Predilecto', 'Obtienes ventajas contra criaturas específicas.', 1),  
(6, 'Estilo de Combate', 'Eliges una especialización de combate.', 2),  
(6, 'Ataque del Cazador', 'Haces más daño en ciertas condiciones.', 5),  
-- Hechicero  
(7, 'Orígenes de la Magia', 'Tu magia proviene de una fuente innata.', 1),  
(7, 'Poder Mágico', 'Obtienes puntos de Hechicería para mejorar conjuros.', 1),  
(7, 'Metamagia', 'Puedes modificar conjuros con efectos especiales.', 3),  
(7, 'Reservorio Arcano', 'Aumentas el daño o curación de un conjuro.', 5),  
-- Guerrero  
(8, 'Estilo de Combate', 'Eliges un estilo de combate especializado.', 1),  
(8, 'Acción Adicional', 'Obtienes un turno extra en combate.', 2),  
(8, 'Segundo Aliento', 'Puedes usar un recurso para recuperar puntos de golpe.', 2),  
(8, 'Indomable', 'Puedes repetir una tirada de salvación fallida una vez por descanso largo.', 5),  
-- Monje  
(9, 'Defensa sin Armadura', 'CA = 10 + DEX + SAB si no llevas armadura.', 1),  
(9, 'Artes Marciales', 'Tus golpes sin armas son más fuertes.', 1),  
(9, 'Ki', 'Obtienes puntos de Ki para realizar habilidades especiales.', 2),  
(9, 'Deflexión de Proyectiles', 'Reduces el daño de ataques a distancia.', 5),  
-- Mago  
(10, 'Preparación de Hechizos', 'El mago puede preparar un número de conjuros de su lista de conjuros de mago.', 1),  
(10, 'Conjuro de Concentración', 'El mago es capaz de mantener un conjuro de concentración durante más tiempo.', 2),  
-- Paladín  
(11, 'Imponer Manos', 'Sanación divina mediante la imposición de manos.', 1),  
(11, 'Sentir el Mal', 'Detectas presencias malignas y celestiales a tu alrededor.', 1),  
(11, 'Estilo de Combate', 'Eliges una especialización de combate.', 2),  
(11, 'Golpe Divino', 'Puedes gastar ranuras de conjuro para hacer daño extra en un ataque cuerpo a cuerpo.', 5),  
-- Pícaro  
(12, 'Ataque Furtivo', 'Haces daño extra cuando tienes ventaja o un aliado cerca.', 1),  
(12, 'Esquiva Sobrenatural', 'Reduces el daño de un ataque que te impacta.', 2),  
(12, 'Evasión', 'Los efectos de área que requieran salvación de Destreza te afectan menos.', 3),  
(12, 'Hábil', 'Obtienes competencia en más habilidades.', 5),  
-- Artífice  
(13, 'Infusión Mágica', 'Puedes imbuir objetos con magia temporalmente.', 1),  
(13, 'Herrero Mágico', 'Puedes crear y mejorar equipo con propiedades mágicas.', 2),  
(13, 'Creador de Prodigios', 'Diseñas artilugios mágicos y herramientas.', 3),  
(13, 'Mejora Experimental', 'Otorgas a un objeto propiedades mágicas especiales.', 5);  

--	Subclases:

INSERT INTO Subclases ( Id_Clase, NombreSubclase, DescripcionSubclase) VALUES
-- Bárbaro
( 1, 'Berserker', 'Un guerrero impulsado por la furia, capaz de entrar en un estado de locura durante la batalla, ganando gran poder físico.'),
( 1, 'Camino del Tótem', 'Un guerrero que sigue el camino de un espíritu animal, obteniendo poderes especiales de su tótem elegido.'),
-- Bardo
( 2, 'College of Lore', 'Un bardo erudito, experto en historia y magia arcana, que utiliza su conocimiento para influir en el mundo.'),
( 2, 'College of Valor', 'Un bardo guerrero, inspirado por la valentía, que incita a sus aliados a la acción y combate de manera valiente.'),
-- Brujo
( 3, 'El Pacto de la Llama Eterna', 'Un brujo que obtiene poder a través de un pacto con una entidad elemental de fuego, dominando la magia destructiva.'),
( 3, 'El Pacto de la Sombras', 'Un brujo que hace un pacto con una entidad oscura, obteniendo poderes sobre la oscuridad y la manipulación de la mente.'),
-- Clérigo
( 4, 'Dominio de la Luz', 'Un clérigo que se dedica a la lucha contra el mal, utilizando la luz y la sanación para proteger a los inocentes.'),
( 4, 'Dominio de la Guerra', 'Un clérigo guerrero que mezcla sus poderes divinos con habilidades marciales para proteger a sus compañeros en la batalla.'),
( 4, 'Dominio de la Vida', 'Un clérigo sanador, enfocado en curar y proteger a los heridos y necesitados.'),
-- Druida
( 5, 'Círculo de la Luna', 'Un druida con la habilidad de transformarse en poderosas bestias, tomando formas animales para afrontar cualquier desafío.'),
( 5, 'Círculo de la Tierra', 'Un druida profundamente conectado con la naturaleza, capaz de manipular la tierra y las criaturas de la tierra.'),
-- Explorador
( 6, 'Cazador', 'Un experto en la caza, el rastreo y el combate a distancia, capaz de usar diversas tácticas en la naturaleza.'),
( 6, 'Explorador de la Selva', 'Un explorador hábil en moverse por la selva y en enfrentarse a los peligros que presenta el entorno selvático.'),
-- Hechicero
( 7, 'Linaje dracónico', 'Un hechicero que tiene sangre de dragón, obteniendo poderes especiales relacionados con los dragones.'),
( 7, 'Hechicería salvaje', 'Un hechicero cuyo poder es errático y descontrolado, con efectos mágicos impredecibles pero poderosos.'),
--Guerrero
( 8, 'Maestro de Batalla', 'Un guerrero experto en tácticas de combate y habilidades marciales, que se adapta a cualquier situación en la batalla.'),
( 8, 'Cruzado', 'Un guerrero dedicado al combate sagrado y a la lucha contra los enemigos de su causa.'),
-- Monje
( 9, 'Camino del Puño de Hierro', 'Un monje que perfecciona su cuerpo y su disciplina en combate cuerpo a cuerpo, volviéndose una fuerza de la naturaleza.'),
( 9, 'Camino de la Sombra', 'Un monje entrenado en el sigilo y en el control de la energía espiritual, capaz de moverse en las sombras sin ser detectado.'),
-- Mago
( 10, 'Escuela de la Evocación', 'Un mago que se especializa en la creación y manipulación de energía arcana para causar efectos destructivos.'),
( 10, 'Escuela de la Ilusión', 'Un mago experto en crear ilusiones y engañar a sus enemigos, confundiéndolos y manipulando sus percepciones.'),
-- Paladín
(11, 'Juramento de Devoción', 'Un paladín que sigue el juramento de la devoción, buscando la pureza, la bondad y la justicia en todo lo que hace.'),
(11, 'Juramento de los Vengadores', 'Un paladín que busca venganza contra aquellos que han hecho daño a su causa o a sus seres queridos.'),
-- Pícaro
( 12, 'Ladrón', 'Un pícaro experto en el sigilo y el robo, siempre en busca de la próxima gran oportunidad.'),
( 12, 'Asesino', 'Un pícaro letal en el combate, entrenado en el arte de eliminar a sus enemigos rápidamente y sin ser detectado.'),
-- Artífice
( 13, 'Alquimista', 'Un artífice que usa la ciencia y la magia para crear pociones y elixires con propiedades extraordinarias.'),
( 13, 'Artífice de guerra', 'Un artífice enfocado en el uso de la ingeniería y la magia para construir poderosas máquinas de guerra.');


-- Atributos Subclases
-- Bárbaro
INSERT INTO AtributosSubclase (Id_Subclase, NombreAtributo, Descripcion, Nivel) VALUES
(1, 'Furia Imparable', 'El berserker entra en un estado de furia que le otorga ventaja en las tiradas de ataque y resistencia a los daños durante 1 minuto. Este efecto se activa al entrar en combate.', 3),
(2, 'Espíritu del Tótem', 'El bárbaro puede invocar el poder de su espíritu animal, otorgándole resistencia a un tipo de daño específico (fuego, frío, etc.) dependiendo del tótem elegido.', 3),
-- Bardo
(3, 'Conocimiento Encantado', 'El bardo puede utilizar su conocimiento para lanzar hechizos con mayor efectividad, ganando un bono a la dificultad de los hechizos de engaño y manipulación.', 3),
(4, 'Valor Inspirador', 'El bardo puede inspirar a sus aliados, otorgándoles un bono de moral a las tiradas de ataque y salvación durante 1 minuto.', 3),
-- Brujo
(5, 'Llama Desgarradora', 'El brujo puede invocar una llama ardiente en su mano, causando daño de fuego a los enemigos cercanos con un ataque de área.', 3),
(6, 'Manipulación Sombría', 'El brujo puede manipular sombras a su alrededor, otorgándose invisibilidad parcial por 1 minuto, dificultando que los enemigos lo detecten.', 3),
-- Clérigo
(7, 'Luz Pura', 'El clérigo puede canalizar energía radiante para purificar áreas de oscuridad y curar a los aliados cercanos con daño radiante.', 1),
(8, 'Fuerza Divina', 'El clérigo puede canalizar su energía divina para mejorar su destreza en combate, otorgándole un bono a la tirada de ataque y daño en combate cuerpo a cuerpo.', 1),
(9, 'Toque Sanador', 'El clérigo puede curar una cantidad de puntos de golpe adicionales a un objetivo con un toque divino.', 1),
-- Druida
(10, 'Bendición de la Tierra', 'El druida puede invocar una bendición de la tierra para aumentar la resistencia de sus aliados a un tipo de daño (físico, elemental, etc.).', 3),
(11, 'Transformación Bestial', 'El druida obtiene una forma bestial mejorada, lo que le permite transformarse en criaturas más poderosas y con habilidades adicionales al usar su forma salvaje.', 2),
-- Explorador
(12, 'Técnica de Caza', 'El cazador obtiene un bono de daño adicional cuando ataca a criaturas que ya hayan sido marcadas por su rastreo o caza.', 3),
(13, 'Camuflaje Natural', 'El explorador puede camuflarse en la jungla o vegetación, volviéndose prácticamente invisible en ese entorno.', 3),
-- Hechicero
(14, 'Aliento Dracónico', 'El hechicero puede utilizar un aliento de dragón, causando daño de un tipo específico (fuego, hielo, ácido, etc.) en un cono frente a él.', 1),
(15, 'Descontrol Mágico', 'Los hechizos del hechicero pueden tener efectos aleatorios, pero también se vuelve más fuerte, obteniendo un bono al daño o al número de objetivos de sus hechizos.', 1),
-- Guerrero
(16, 'Tácticas de Guerra', 'El guerrero puede usar su acción para analizar el campo de batalla, obteniendo ventaja en las tiradas de ataque contra un enemigo específico durante el resto del turno.', 3),
(17, 'Juramento Sagrado', 'El guerrero puede invocar un juramento sagrado, obteniendo resistencia a todos los tipos de daño mientras protege a sus aliados.', 3),
-- Monje
(18, 'Golpe Mortal', 'El monje puede canalizar su energía espiritual para realizar un golpe devastador, ignorando resistencias y causando daño adicional.', 3),
(19, 'Desplazamiento Sombrío', 'El monje puede moverse en las sombras a gran velocidad, teletransportándose a un área oscura que haya visto antes.', 3),
-- Mago
(20, 'Explosión Arcana', 'El mago puede crear una explosión de energía arcana que causa daño a todos los enemigos en un área, con una mayor cantidad de daño si el objetivo está cerca de la fuente.', 2),
(21, 'Distorsión Mental', 'El mago puede crear ilusiones tan realistas que desorientan a sus enemigos, dándoles desventaja en sus ataques y salvaciones.', 2),
-- Paladín
(22, 'Aura de Pureza', 'El paladín crea un aura que purifica a sus aliados de efectos negativos y les otorga resistencia a la necrosis y la energía oscura.', 3),
(23, 'Juramento de Venganza', 'El paladín puede canalizar su ira para hacer un daño adicional a los enemigos que haya marcado como objetivo de su venganza.', 3),
-- Pícaro
(24, 'Reflejos Rápidos', 'El pícaro puede usar su acción de bonificación para esquivar un ataque o moverse sin provocar ataques de oportunidad.', 3),
(25, 'Matanza Silenciosa', 'El pícaro puede eliminar a un enemigo con un ataque sorpresa instantáneo si no ha sido detectado.', 3),
-- Artífice
(26, 'Elixir Mejorado', 'El artífice puede crear elixires que aumentan las habilidades de sus aliados, otorgándoles bonificaciones temporales a la fuerza, agilidad o resistencia.', 3),
(27, 'Artilugio de Guerra', 'El artífice puede construir dispositivos mágicos y mecánicos que le permiten aumentar su capacidad en combate, proporcionando armas o herramientas avanzadas.', 3);

--	Razas
INSERT INTO Razas ( NombreRaza, DescripcionRaza, TamañoRaza, VelocidadRaza) VALUES
( 'Humano', 'Versátil y adaptable.', 'Mediano', 30),
( 'Elfo', 'Ágiles y longevos.', 'Mediano', 40),
( 'Enano', 'Resistentes y tenaces.', 'Mediano', 25),
( 'Mediano', 'Pequeños pero ágiles.', 'Pequeño', 25),
( 'Dracónido', 'Descendientes de dragones.', 'Mediano', 30),
( 'Gnomo', 'Pequeños y astutos.', 'Pequeño', 25),
( 'Semi-Orco', 'Fuerza bruta y ferocidad.', 'Grande', 30),
( 'Tiefling', 'De ascendencia infernal.', 'Mediano', 35),
( 'Semielfo', 'Agiles y versatiles', 'Mediano', 35)

INSERT INTO EstadisticasRaza (Id_Raza, Fuerza, Destreza, Constitucion, Inteligencia, Sabiduria, Carisma) VALUES
(1, 1, 1, 1, 1, 1, 1), -- Humanos: +1 en todo
(2, 0, 2, 0, 0, 1, 0), -- Elfos: +2 Destreza, +1 Sabiduría
(3, 0, 0, 2, 0, 0, 0), -- Enanos: +2 Constitución
(4, 0, 2, 0, 0, 0, 0), -- Medianos: +2 Destreza
(5, 2, 0, 0, 0, 0, 1), -- Dracónidos: +2 Fuerza, +1 Carisma
(6, 0, 0, 0, 2, 0, 0), -- Gnomos: +2 Inteligencia
(7, 2, 0, 1, 0, 0, 0), -- Semi-Orcos: +2 Fuerza, +1 Constitución
(8, 0, 0, 0, 1, 0, 2), -- Tieflings: +1 Inteligencia, +2 Carisma
(9, 0, 2, 0, 0, 1, 0) -- Semielfos: +1 Destreza, +1 Sabiduría, +1 Inteligencia

-- Insertar Atributos de Raza con la nueva estructura  
INSERT INTO AtributosRaza (Id_Raza, NombreAtributo, Descripcion, Nivel) VALUES  
-- Humanos  
(1, 'Maestría en Habilidades', 'Obtienes competencia en una o más habilidades.', 1),  

-- Elfos  
(2, 'Visión en la Oscuridad', 'Puedes ver en la oscuridad en un rango de 60 pies.', 1),  
(2, 'Maestría en Habilidades', 'Obtienes competencia en una o más habilidades.', 1),  
(2, 'Linaje Feérico', 'Ventaja en tiradas de salvación contra encantamientos; la magia no puede hacerte dormir.', 1),  

-- Enanos  
(3, 'Visión en la Oscuridad', 'Puedes ver en la oscuridad en un rango de 60 pies.', 1),  
(3, 'Resistencia a Daño', 'Tienes resistencia a un tipo de daño específico según tu raza.', 1),  
(3, 'Maestría en Habilidades', 'Obtienes competencia en una o más habilidades.', 1),  
(3, 'Afinidad con la Piedra', 'Eres competente en Historia cuando evalúas construcciones de piedra.', 1),  

-- Medianos  
(4, 'Velocidad Aumentada', 'Tu velocidad base es mayor que la de otras razas.', 1),  
(4, 'Maestría en Habilidades', 'Obtienes competencia en una o más habilidades.', 1),  
(4, 'Suerte Mediana', 'Cuando sacas un 1 en una tirada de ataque, habilidad o salvación, puedes repetir la tirada.', 1),  

-- Dracónidos  
(5, 'Visión en la Oscuridad', 'Puedes ver en la oscuridad en un rango de 60 pies.', 1),  
(5, 'Resistencia a Daño', 'Tienes resistencia a un tipo de daño específico según tu raza.', 1),  
(5, 'Arma de Aliento', 'Puedes exhalar un aliento elemental según tu ascendencia dracónica.', 1),  
(5, 'Resistencia Dracónica', 'Tienes resistencia a un tipo de daño según tu ascendencia dracónica.', 1),  

-- Gnomos  
(6, 'Maestría en Habilidades', 'Obtienes competencia en una o más habilidades.', 1),  
(6, 'Astucia Gnómica', 'Ventaja en tiradas de salvación de Inteligencia, Sabiduría y Carisma contra magia.', 1),  

-- Semi-Orcos  
(7, 'Visión en la Oscuridad', 'Puedes ver en la oscuridad en un rango de 60 pies.', 1),  
(7, 'Tolerancia de Semiorco', 'Cuando caes a 0 puntos de golpe, puedes quedarte en 1 en lugar de caer inconsciente.', 1),  
(7, 'Ataque Salvaje', 'Cuando sacas un crítico con un ataque cuerpo a cuerpo, sumas un dado extra de daño.', 1),  

-- Tieflings  
(8, 'Visión en la Oscuridad', 'Puedes ver en la oscuridad en un rango de 60 pies.', 1),  
(8, 'Resistencia Infernal', 'Tienes resistencia al daño de fuego.', 1),  
(8, 'Legado Infernal', 'Conoces el truco *Taumaturgia* y obtienes más conjuros a niveles superiores.', 1);  


--Competencias
INSERT INTO Competencias (NombreCompetencia, TipoCompetencia, DescripcionCompetencia) VALUES
-- Armas
('Armas Ligeras', 'Arma', 'Un conjunto de armas pequeñas y fáciles de usar, como dagas, dardos, etc.'),
('Armas Marciales', 'Arma', 'Armas más grandes y poderosas, como espadas largas, hachas de batalla y lanzas.'),
('Armas a Distancia', 'Arma', 'Armas que permiten atacar a distancia, como arcos y ballestas.'),

-- Armaduras
('Armaduras Ligeras', 'Armadura', 'Armaduras que proporcionan una protección mínima pero permiten gran movilidad, como cueros y cotas de malla.'),
('Armaduras Medianas', 'Armadura', 'Armaduras que ofrecen un equilibrio entre protección y movilidad, como cota de malla reforzada y armaduras de escamas.'),
('Armaduras Pesadas', 'Armadura', 'Armaduras que ofrecen una alta protección a costa de la movilidad, como placas y armaduras de placas.'),
('Escudos', 'Armadura', 'Protección adicional para bloquear ataques, que se lleva en la mano.'),

-- Herramientas
('Herramientas de Artesano', 'Herramienta', 'Conjunto de herramientas especializadas para realizar trabajos artesanales, como herrería o carpintería.'),
('Herramientas de Alquimista', 'Herramienta', 'Herramientas necesarias para la creación de pociones y elixires.'),
('Herramientas de Ladrón', 'Herramienta', 'Herramientas utilizadas para el robo y el sigilo, como ganzúas y herramientas de desactivación de trampas.'),
('Herramientas de Tinker', 'Herramienta', 'Herramientas utilizadas para la creación de dispositivos mecánicos, como relojes y pequeñas máquinas.'),

-- Otros
('Juegos de Mesa', 'Otro', 'Competencia en juegos de azar o juegos de mesa como el ajedrez, damas o el póker.'),
('Vehículos (terrestres)', 'Otro', 'Competencia en el manejo de vehículos como carretas o carros tirados por caballos.'),

-- Instrumentos Musicales
('Instrumentos de Cuerda', 'Herramienta', 'Competencia con instrumentos de cuerda como laúd, violín, arpa y guitarra.'),
('Instrumentos de Viento', 'Herramienta', 'Competencia con instrumentos de viento como flauta, trompeta y gaita.'),
('Instrumentos de Percusión', 'Herramienta', 'Competencia con instrumentos de percusión como tambores, bongós y xilófono.'),
('Kit de Disfraz', 'Herramienta', 'Conjunto de maquillajes, vestimentas y accesorios para cambiar de apariencia e identidad.'),
('Kit de Medicina', 'Herramienta', 'Instrumentos y suministros médicos básicos para tratar heridas y enfermedades.');

-- Insertar las relaciones entre competencias y clases
INSERT INTO CompetenciasClase (Id_Competencia, Id_Clase) VALUES
-- Bárbaro
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

-- Clérigo
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

-- Paladín
(1, 11), -- Armas Ligeras
(2, 11), -- Armas Marciales
(4, 11), -- Armaduras Ligeras
(5, 11), -- Armaduras Medianas
(6, 11), -- Escudos

-- Pícaro
(1, 12), -- Armas Ligeras
(4, 12), -- Armaduras Ligeras
(7, 12), -- Herramientas de Ladrón

-- Artífice
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
('Tareen Stonelog', 3, 13, 27, 3, 2), -- Artífice, Artífice de guerra, raza Enano
('Phoebe Lyre', 3, 13, 27, 5, 2), -- Artífice, Herrero de guerra, raza Dracónida
('Meliza', 2, 2, 4, 4, 1), -- Bardo, College of Valor, raza Humano
('Mico Loamir', 1, 5, 10, 8, 2), -- Druida, Círculo de la Tierra, raza Firbolg
('Lydia Blackthorn', 5, 8, 16, 6, 3), -- Guerrero, Maestro de Batalla, raza Semielfo
('Kaelen Dawnstrike', 4, 11, 22, 4, 2),  -- Paladín, Juramento de Devoción, Humano
('Zyra Nightwhisper', 5, 12, 25, 7, 3),  -- Pícaro, Asesino, Elfo
('Thorin Ironfist', 3, 1, 1, 3, 2),      -- Bárbaro, Berserker, Enano
('Selene Moonshadow', 5, 10, 21, 7, 3),  -- Mago, Ilusión, Elfo
( 'Vex Stormborn', 3, 7, 14, 6, 2),      -- Hechicero, Linaje dracónico, Semielfo
( 'Garruk Bearheart', 4, 9, 18, 3, 2),   -- Monje, Puño de Hierro, Enano
( 'Eldrin Starfall', 2, 6, 12, 7, 1),    -- Explorador, Cazador, Elfo
( 'Mira Emberflare', 5, 3, 5, 6, 3),     -- Brujo, Pacto de la Llama Eterna, Semielfo
( 'Lyra Windwhisper', 4, 2, 3, 7, 2) ,    -- Bardo, College of Lore, Elfo
( 'Darius Ironwood', 3, 8, 16, 2, 2),    -- Guerrero, Maestro de Batalla, Mediano
( 'Roland Blackthorn', 3, 11, 23, 6, 2), -- Paladín, Vengadores, Semielfo
( 'Nalia Swiftblade', 2, 12, 24, 2, 1),  -- Pícaro, Ladrón, Mediano
( 'Korin Thunderfist', 4, 1, 2, 3, 2),   -- Bárbaro, Camino del Tótem, Enano
( 'Soren Duskrunner', 5, 9, 19, 7, 3),   -- Monje, Camino de la Sombra, Elfo
( 'Isolde Frostbane', 3, 4, 8, 5, 2);    -- Clérigo, Dominio de la Guerra, Tiefling


--Select * From Personajes

-- Insertar estadísticas para los personajes
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
-- 2. Mejorar la Fuerza de todos los bárbaros en +1.
UPDATE EstadisticasPersonaje SET Fuerza = Fuerza + 1 WHERE Id_Personaje IN (SELECT Id_Personaje FROM Personajes WHERE Id_Clase = 1);
-- 3. Reducir en 1 el Carisma de todos los magos 
UPDATE EstadisticasPersonaje SET Carisma = Carisma - 1 WHERE Id_Personaje IN (SELECT Id_Personaje FROM Personajes WHERE Id_Clase = 10);
-- 4. Aumentar en 1 la Inteligencia de todos los artificieros.
UPDATE EstadisticasPersonaje SET Inteligencia = Inteligencia + 1 WHERE Id_Personaje IN (SELECT Id_Personaje FROM Personajes WHERE Id_Clase = 13);
-- 5. Cambiar la subclase de Phoebe Lyre a la de "Alquimista".
UPDATE Personajes SET Id_Subclase = 26 WHERE NombrePersonaje = 'Phoebe Lyre';
-- 6. Aumentar el nivel de todos los paladines en +1.
UPDATE Personajes SET Nivel = Nivel + 1 WHERE Id_Clase = 11;
-- 7. Cambiar la raza de Lydia Blackthorn a "Semielfo" porque se descubrió que tiene ascendencia élfica.
UPDATE Personajes SET Id_Raza = 7 WHERE NombrePersonaje = 'Lydia Blackthorn';
-- 8. Subir en 2 puntos la Destreza de todos los pícaros.
UPDATE EstadisticasPersonaje SET Destreza = Destreza + 2 WHERE Id_Personaje IN (SELECT Id_Personaje FROM Personajes WHERE Id_Clase = 12);
-- 9. Reducir la Constitución en 1 de todos los personajes que no sean bárbaros.
UPDATE EstadisticasPersonaje SET Constitucion = Constitucion - 1 WHERE Id_Personaje NOT IN (SELECT Id_Personaje FROM Personajes WHERE Id_Clase = 1);
-- 10. Cambiar el nombre de Meliza a "Meliza Moonfire" porque adoptó un nuevo nombre.
UPDATE Personajes SET NombrePersonaje = 'Meliza Moonfire' WHERE NombrePersonaje = 'Meliza';

-- 11. Subir el nivel de los personajes que tienen más de 14 en Sabiduría.
UPDATE Personajes 
SET Nivel = Nivel + 1 
WHERE Id_Personaje IN (SELECT Id_Personaje FROM EstadisticasPersonaje WHERE Sabiduria > 14);

-- 12. Cambiar la subclase de todos los pícaros que tengan Destreza mayor a 15 a "Trickster".
UPDATE Subclases 
SET NombreSubclase = 'Trickster', 
    DescripcionSubclase = 'Un pícaro astuto y habilidoso, experto en engaños y distracciones, utilizando su ingenio y astucia para manipular a sus enemigos.'
WHERE NombreSubclase = 'Ladrón' AND Id_Clase = 12;

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

-- 16. Reducir en 1 la Inteligencia de los bárbaros, porque confían más en su instinto que en la lógica.
UPDATE EstadisticasPersonaje 
SET Inteligencia = Inteligencia - 1 
WHERE Id_Personaje IN (SELECT Id_Personaje FROM Personajes WHERE Id_Clase = 1);

-- 17. Aumentar en 2 la Constitución de los enanos porque son resistentes.
UPDATE EstadisticasPersonaje 
SET Constitucion = Constitucion + 2 
WHERE Id_Personaje IN (SELECT Id_Personaje FROM Personajes WHERE Id_Raza = 3);

-- 18. Cambia el nivel de los atributos de subclase de clerido a nivel 1
UPDATE AtributosSubclase 
Set Nivel = 1
WHERE Id_Subclase in (Select Id_Subclase From Subclases Where Id_Clase = 4)

-- 19. Reducir en 1 la Sabiduría de los personajes con menos de 10 en Inteligencia.
UPDATE EstadisticasPersonaje 
SET Sabiduria = Sabiduria - 1 
WHERE Id_Personaje IN (SELECT Id_Personaje FROM EstadisticasPersonaje WHERE Inteligencia < 10);

-- 20. Cambiar la raza de los personajes con más de 15 en Destreza a "Medio elfo".
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

-- 2. Eliminar estadísticas de personajes que ya no existen en la tabla Personajes
BEGIN TRAN
DELETE FROM EstadisticasPersonaje 
WHERE Id_Personaje NOT IN (SELECT Id_Personaje FROM Personajes);
SELECT * FROM EstadisticasPersonaje;
ROLLBACK TRAN;

-- 3. Eliminar competencias que no están asociadas a ninguna clase
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

-- 7. Eliminar personajes sin estadísticas registradas
BEGIN TRAN
DELETE FROM Personajes 
WHERE Id_Personaje NOT IN (SELECT Id_Personaje FROM EstadisticasPersonaje);
SELECT * FROM Personajes;
ROLLBACK TRAN;

-- 8. Eliminar competencias que no están asociadas a ninguna subclase
BEGIN TRAN
DELETE FROM Competencias 
WHERE Id_Competencia NOT IN (SELECT Id_Competencia FROM Subclases);
SELECT * FROM Competencias;
ROLLBACK TRAN;

-- 9. Eliminar personajes sin clase válida
BEGIN TRAN
DELETE FROM Personajes 
WHERE Id_Clase NOT IN (SELECT Id_Clase FROM Clases);
SELECT * FROM Personajes;
ROLLBACK TRAN;

-- 10. Eliminar personajes sin subclase válida
BEGIN TRAN
DELETE FROM Personajes 
WHERE Id_Subclase NOT IN (SELECT Id_Subclase FROM Subclases);
SELECT * FROM Personajes;
ROLLBACK TRAN;

-- 11. Eliminar subclases sin clase válida
BEGIN TRAN
DELETE FROM Subclases 
WHERE Id_Clase NOT IN (SELECT Id_Clase FROM Clases);
SELECT * FROM Subclases;
ROLLBACK TRAN;

-- 12. Eliminar estadísticas que tengan valores inválidos (menores a 1 o mayores a 20)
BEGIN TRAN
DELETE FROM EstadisticasPersonaje 
WHERE Fuerza < 1 OR Destreza < 1 OR Constitucion < 1 
OR Inteligencia < 1 OR Sabiduria < 1 OR Carisma < 1 
OR Fuerza > 20 OR Destreza > 20 OR Constitucion > 20 
OR Inteligencia > 20 OR Sabiduria > 20 OR Carisma > 20;
SELECT * FROM EstadisticasPersonaje;
ROLLBACK TRAN;

-- 13. Eliminar personajes con BonusCompetencia fuera del rango válido (1-6)
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

-- Obtener las estadísticas del personaje
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

	--Mostrar las distintas convinaciones de de tipo de clase, y dados de daño y cantidad de clases con esa convinacion
	Select Distinct  TipoClase, DadoDaño, Count(*) as 'No De Clases' From Clases Group By TipoClase,DadoDaño;
	
	-- Mostar los distintas razas con las que se han creado personajes
	Select Distinct P.Id_Raza, R.NombreRaza From Personajes P
	Join Razas R on R.Id_Raza = P.Id_Raza

	Select Distinct P.Id_Clase, C.NombreClase From Personajes P
	Join Clases C on C.Id_Clase = P.Id_Clase

-- 3 consultas que contengan AND/OR/NOT 

	--selecciona las clases magicas quen daño mayor o igual a 8
	SELECT NombreClase, TipoClase, DadoDaño
	FROM Clases
	WHERE TipoClase = 'Magica' AND DadoDaño >= 8;

	--selecciona todas las razas que sean de tamaño mediano o grande
	SELECT NombreRaza, TamañoRaza, VelocidadRaza
	FROM Razas
	WHERE TamañoRaza = 'Mediano' OR TamañoRaza = 'Grande';

	--selecciona todas aqueyas competencias que no sean de tipo armadura
	SELECT NombreCompetencia, TipoCompetencia,DescripcionCompetencia
	FROM Competencias
	WHERE NOT TipoCompetencia = 'Armadura';

-- 3 consultas que contengan ORDER BY 

	--
	Select NombreClase, DadoDaño, TipoClase, DescripcionClase From Clases 
	Order By DadoDaño DESC
	--
	Select P.NombrePersonaje, P.Nivel, P.BonusCompetencia,C.NombreClase,R.NombreRaza  From Personajes  P
	Inner Join Clases C On C.Id_Clase = P.Id_Clase
	Join Razas R on R.Id_Raza = P.Id_Raza
	Order By Nivel ASC
	--
	Select R.NombreRaza, R.VelocidadRaza,R.TamañoRaza From Razas R
	Order By VelocidadRaza DESC

-- 3 consultas que contengan MIN 

	SELECT* FROM Clases
	SELECT NombreClase,TipoClase,DadoDaño FROM Clases WHERE DadoDaño = (SELECT MIN(DadoDaño) FROM Clases);

	SELECT* FROM Razas
	SELECT NombreRaza, DescripcionRaza, TamañoRaza,  VelocidadRaza FROM Razas WHERE VelocidadRaza = (SELECT MIN(VelocidadRaza) FROM Razas);

	SELECT* FROM Personajes
	SELECT NombrePersonaje, Nivel FROM Personajes WHERE Nivel = (SELECT MIN(Nivel) FROM Personajes);

-- 3 consultas que contengan MAX 
	SELECT * FROM Clases
	SELECT NombreClase,TipoClase,DadoDaño FROM Clases WHERE DadoDaño = (SELECT MAX(DadoDaño) FROM Clases);

	SELECT* FROM Razas
	SELECT NombreRaza, DescripcionRaza, TamañoRaza,  VelocidadRaza FROM Razas WHERE VelocidadRaza = (SELECT MAX(VelocidadRaza) FROM Razas);

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

	--Suma de daño de todas las clases:
	SELECT SUM(DadoDaño) AS DañoTotal
	FROM Clases;

	--Suma del total de atributos de todas las estadísticas raciales:
	SELECT SUM(EP.Fuerza + EP.Destreza + EP.Constitucion + EP.Inteligencia + EP.Sabiduria + EP.Carisma) AS TotalAtributosRaciales
	FROM EstadisticasPersonaje EP
	Join Personajes P On P.Id_Personaje=Ep.Id_Personaje

-- 3 consultas que involucren TOP 

	--Las 3 clases con mayor dado de daño:
	SELECT TOP 3 NombreClase, DadoDaño
	FROM Clases
	ORDER BY DadoDaño DESC;

	--Las 5 primeras razas según su velocidad:
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

	--Personajes que son de clases específicas (por ejemplo, 1, 2 y 3):
	SELECT NombrePersonaje, Id_Clase
	FROM Personajes
	WHERE Id_Clase IN (1, 2, 3);

	--Razas con tamaño específico:
	SELECT *
	FROM Razas
	WHERE TamañoRaza IN ('Mediano', 'Grande');

	--Clases que tienen dado de daño en esta lista:
	SELECT NombreClase, DadoDaño
	FROM Clases
	WHERE DadoDaño IN (6, 8, 10);

-- 3 consultas que contengan BETWEEN


	--Personajes con nivel entre 3 y 7:
	SELECT NombrePersonaje, Nivel
	FROM Personajes
	WHERE Nivel BETWEEN 3 AND 7;

	--Dado de daño de clases entre 4 y 10:
	SELECT NombreClase, DadoDaño
	FROM Clases
	WHERE DadoDaño BETWEEN 4 AND 10;

	--Velocidad de raza entre 25 y 35:
	SELECT NombreRaza, VelocidadRaza
	FROM Razas
	WHERE VelocidadRaza BETWEEN 25 AND 35;
