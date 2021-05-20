IF OBJECT_ID('dbo.BILLET') IS NOT NULL
	DROP TABLE dbo.BILLET;
GO

IF OBJECT_ID('dbo.CALENDRIER') IS NOT NULL
	DROP TABLE dbo.CALENDRIER;
GO


IF OBJECT_ID('dbo.SPECTACLE') IS NOT NULL
	DROP TABLE dbo.SPECTACLE;
GO

IF OBJECT_ID('dbo.SALLE') IS NOT NULL
	DROP TABLE dbo.SALLE;
GO

IF OBJECT_ID('dbo.CLIENT') IS NOT NULL
	DROP TABLE dbo.CLIENT;
GO

-- Tables Section
-- _____________ 

create table BILLET (
     Id_Billet int  IDENTITY(1,1),
     Tarif_Billet int ,
     Id_Client int ,
     Id_Date int ,
     constraint IDBILLET primary key (Id_Billet));

create table CALENDRIER (
     Id_Date int  IDENTITY(1,1),
     Date_Spectacle date ,
     Date_Complet int ,
     Id_Spectacle int ,
     Id_Salle int ,
     constraint IDCALENDRIER primary key (Id_Date));

create table CLIENT (
     Id_Client int  IDENTITY(1,1),
     Nom_Client varchar(100) ,
     Prenom_Client varchar(100) ,
     Adresse_Client varchar(100),
     constraint IDCLIENT_ID primary key (Id_Client));

create table SALLE (
     Id_Salle int  IDENTITY(1,1),
     Nom_Salle varchar(100) ,
     Capacité_Salle int ,
     Adresse_Salle varchar(100) ,
     Type_Salle varchar(50) ,
     constraint IDSALLE primary key (Id_Salle));

create table SPECTACLE (
     Id_Spectacle int  IDENTITY(1,1),
     Nom_Spectacle varchar(100) ,
     Duree_Spectacle time ,
     Type_Spectacle varchar(50),
     constraint IDSPECTACLE primary key (Id_Spectacle));


-- Constraints Section
-- ___________________ 

alter table BILLET add constraint FKACHETER
     foreign key (Id_Client)
     references CLIENT (Id_Client);

alter table BILLET add constraint FKREFERENCER
     foreign key (Id_Date)
     references CALENDRIER (Id_Date);

alter table CALENDRIER add constraint FKAVOIR_LIEU
     foreign key (Id_Spectacle)
     references SPECTACLE (Id_Spectacle);

alter table CALENDRIER add constraint FKDEROULER
     foreign key (Id_Salle)
     references SALLE (Id_Salle);

-- Not implemented
-- alter table CLIENT add constraint IDCLIENT_CHK
--     check(exists(select * from BILLET
--                  where BILLET.Id_Client = Id_Client)); 




-- DATA INSERTION
-- _____________ 



INSERT INTO CLIENT VALUES ('Wood', 'Julia', 'Lyon');
INSERT INTO CLIENT VALUES ('Reese', 'Neil', 'Toulouse');
INSERT INTO CLIENT VALUES ('Sutton', 'Harry', 'Lille');
INSERT INTO CLIENT VALUES ('Waters', 'Vernon', 'Nice');
INSERT INTO CLIENT VALUES ('Mclaughlin', 'Clifford', 'Paris');
INSERT INTO CLIENT VALUES ('Peters', 'Bobby', 'Nantes');
INSERT INTO CLIENT VALUES ('Drake', 'Winifred', 'Nancy');
INSERT INTO CLIENT VALUES ('Singleton', 'Laura', 'Marseille');
INSERT INTO CLIENT VALUES ('Carson', 'Jaime', 'Bordeaux');
INSERT INTO CLIENT VALUES ('Collier', 'Jennie', 'Saint-Etienne');

INSERT INTO SALLE VALUES ('Zenith', 8000, 'Lille', 'Concert');
INSERT INTO SALLE VALUES ('Bercy', 17000, 'Paris', 'Stade');
INSERT INTO SALLE VALUES ('Stade de France', 90000, 'Paris', 'Stade');
INSERT INTO SALLE VALUES ('Trabendo', 700, 'Paris','Concert');
INSERT INTO SALLE VALUES ('Olympia', 1996, 'Paris', 'Théatre');
INSERT INTO SALLE VALUES ('Clisson', 140000, 'Clisson', 'Terrain');
INSERT INTO SALLE VALUES ('Zenith', 12079, 'Strasbourg', 'Concert');
INSERT INTO SALLE VALUES ('Arènes de Nîmes', 25000, 'Nîmes', 'Stade');
INSERT INTO SALLE VALUES ('Centre des Congrès', 4000, 'Nantes', 'Spectacle');
INSERT INTO SALLE VALUES ('Carhaix',268000, 'Carhaix', 'Terrain');
INSERT INTO SALLE VALUES ('Zenith', 9000, 'Nantes', 'Concert');
INSERT INTO SALLE VALUES ('Saint-Cloud Paris', 120000, 'Paris', 'Terrain');
INSERT INTO SALLE VALUES ('Centre des congrès', 300, 'Angers', 'Spectacle');



INSERT INTO SPECTACLE VALUES ('Vieilles Charues', '00:00:00','Festival');