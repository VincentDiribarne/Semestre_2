--Question 1
--INSERT INTO CLIENT VALUES ('EuroMoto','Chateauroux',22,'Filtre',940,'2016-02-22');

--IF EXISTS (SELECT * FROM sysobjects WHERE name='warningClientInsertion')
--	DROP TRIGGER warningClientInsertion;
--GO


--Question 2
--INSERT INTO CLIENT VALUES ('Car Fur','Angers',18,'Piston',940,'2015-08-01'),
--	('FranceVélo','La roche sur yon',9,'Tuyau',1210,'2017-04-17'),
--		('Le clair automobile','Glomel',38,'Valve',710,'2015-11-24');

--IF EXISTS (SELECT * FROM sysobjects WHERE name='warningClientInsertion')
--	DROP TRIGGER warningClientInsertion;
--GO


--Question 3
--INSERT INTO CLIENT VALUES ('EuroMoto','Chateauroux',22,'Filtre',940,'2016-02-22'),
--	('FranceVélo','La roche sur yon',9,'Tuyau',1210,'2017-04-17'),
--		('Le clair automobile','Glomel',38,'Valve',710,'2015-11-24');

--IF EXISTS (SELECT * FROM sysobjects WHERE name='countClientInsertion')
--	DROP TRIGGER countClientInsertion;
--GO


--Question 4
--UPDATE CLIENT SET Cl_En_cours*=2 WHERE Cl_Nom LIKE 'L%';
--SELECT * FROM CLIENT;
--GO

--IF EXISTS (SELECT * FROM sysobjects WHERE name='infoClientUpdate')
--	DROP TRIGGER infoClientUpdate;
--GO


--Question 5
--DELETE FROM CLIENT WHERE Cl_Nom='Best CAR Buy';
--SELECT * FROM CLIENT;

--IF EXISTS (SELECT * FROM sysobjects WHERE name='nullClientDelete')
--	DROP TRIGGER nullClientDelete;
--GO


--Question 6
--INSERT INTO CLIENT VALUES ( 'Cl1', 'Ville1', 22, 'Filtre', 0, '2016-02-22'), 
--    ( 'Cl2', 'Ville2', 22, 'Filtre', 0, '2016-02-22'),
--    ( 'Cl3', 'Ville3', 22, 'Filtre', 0, '2016-02-22'),
--    ( 'Cl4', 'Ville4', 22, 'Filtre', 0, '2016-02-22'),
--    ( 'Cl5', 'Ville5', 22, 'Filtre', 0, '2016-02-22'),
--    ( 'Cl6', 'Ville6', 22, 'Filtre', 0, '2016-02-22'),
--    ( 'Cl7', 'Ville7', 22, 'Filtre', 0, '2016-02-22'),
--    ( 'Cl8', 'Ville8', 22, 'Filtre', 0, '2016-02-22'),
--    ( 'Cl9', 'Ville9', 22, 'Filtre', 0, '2016-02-22');
--SELECT * FROM CLIENT;

--INSERT INTO CLIENT VALUES ( 'Cl1', 'Ville1', 22, 'Filtre', 0, '2016-02-22'), 
--    ( 'Cl2', 'Ville2', 22, 'Filtre', 0, '2016-02-22'),
--    ( 'Cl3', 'Ville3', 22, 'Filtre', 0, '2016-02-22'),
--    ( 'Cl4', 'Ville4', 22, 'Filtre', 0, '2016-02-22'),
--    ( 'Cl5', 'Ville5', 22, 'Filtre', 0, '2016-02-22'),
--    ( 'Cl6', 'Ville6', 22, 'Filtre', 0, '2016-02-22'),
--    ( 'Cl7', 'Ville7', 22, 'Filtre', 0, '2016-02-22'),
--    ( 'Cl8', 'Ville8', 22, 'Filtre', 0, '2016-02-22'),
--    ( 'Cl9', 'Ville9', 22, 'Filtre', 0, '2016-02-22'),
--    ( 'Cl10', 'Ville10', 22, 'Filtre', 0, '2016-02-22');
--SELECT * FROM CLIENT;


--Question 7
--UPDATE CLIENT SET Cl_Adresse='Paris' WHERE Cl_Nom='HieCarchy';


--Question 8

UPDATE CLIENT SET Cl_Adresse='Paris' WHERE Cl_Nom='HieCarchy';