IF OBJECT_ID('dbo.ACTIVITES') IS NOT NULL
	DROP TABLE dbo.ACTIVITES
GO

IF OBJECT_ID('dbo.SEJOUR') IS NOT NULL
	DROP TABLE dbo.SEJOUR
GO


IF OBJECT_ID('dbo.CLIENT') IS NOT NULL
	DROP TABLE dbo.CLIENT
GO


IF OBJECT_ID('dbo.STATION') IS NOT NULL
	DROP TABLE dbo.STATION
GO


CREATE TABLE STATION (
  Nom_station varchar(100) PRIMARY KEY,
  capacité smallint,
  lieu varchar(100),
  région varchar(100),
  tarif float
);

CREATE TABLE ACTIVITES (
  Nom_station varchar(100),
  libellé varchar(100),
  prix float,
  CONSTRAINT cle_primaire_activites PRIMARY KEY (Nom_station,libellé),
  -- CONSTRAINT cle_etrangere_activites FOREIGN KEY (Nom_station) REFERENCES STATION(Nom_station)
);


CREATE TABLE CLIENT (
  Id_client SMALLINT PRIMARY KEY,
  nom varchar(100),
  Prénom varchar(100),
  ville varchar(100),
  région varchar(100),
  solde float
);

CREATE TABLE SEJOUR (
  Id_client SMALLINT,
  Nom_station varchar(100),
  début DATE,
  nbplaces SMALLINT,
  CONSTRAINT cle_primaire_sejour PRIMARY KEY (Id_client,Nom_station,début,nbplaces),
  -- CONSTRAINT cle_etrangere_Nom_station FOREIGN KEY (Nom_station) REFERENCES STATION(Nom_station),
  CONSTRAINT cle_etrangere_Id_client FOREIGN KEY (Id_client) REFERENCES CLIENT(Id_client)
);
GO

INSERT INTO STATION VALUES ('Venusa',350,'Guadeloupe','Antilles',1200);
INSERT INTO STATION VALUES ('Farniente',200,'Seychelles','Océan Indien',1500);
INSERT INTO STATION VALUES ('Santalba',150,'Martinique','Antilles',2000);
INSERT INTO STATION VALUES ('Pessac',250,'Alpes','Europe',1000);
INSERT INTO STATION VALUES ('Adriana',250,'Adriatique','Europe',1000);

INSERT INTO ACTIVITES VALUES ('Venusa','Voile',150);
INSERT INTO ACTIVITES VALUES ('Venusa','Plongée',120);
INSERT INTO ACTIVITES VALUES ('Farniente','Plongée',130);
INSERT INTO ACTIVITES VALUES ('Pessac','Ski',200);
INSERT INTO ACTIVITES VALUES ('Pessac','Piscine',20);
INSERT INTO ACTIVITES VALUES ('Santalba','Kayac',50);

INSERT INTO CLIENT VALUES (10,'Fogg','Phileas','Londres','Europe',12465);
INSERT INTO CLIENT VALUES (20,'Pascal','Blaise','Paris','Europe',6763);
INSERT INTO CLIENT VALUES (30,'Kerouac','Jack','New York','Amérique',9812);

INSERT INTO SEJOUR VALUES (10,'Pessac','2008-07-01',2);
INSERT INTO SEJOUR VALUES (30,'Santalba','2006-08-14',5);
INSERT INTO SEJOUR VALUES (20,'Santalba','2008-08-03',4);
INSERT INTO SEJOUR VALUES (30,'Pessac','2008-08-15',3);
INSERT INTO SEJOUR VALUES (30,'Venusa','2008-08-03',3);
INSERT INTO SEJOUR VALUES (20,'Venusa','2008-10-03',6);
INSERT INTO SEJOUR VALUES (30,'Farniente','2009-06-24',5);
INSERT INTO SEJOUR VALUES (10,'Farniente','2008-09-05',3);