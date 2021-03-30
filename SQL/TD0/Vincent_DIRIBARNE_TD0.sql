--DROP TABLE IF EXISTS SALLE;
--CREATE TABLE SALLE (
--Id_Sa int PRIMARY KEY,
--Nom_Sa varchar(50),
--Type_Sa varchar(50),
--Surf_Sa int,
--Adr_Sa varchar(50) );
--GO

--DROP TABLE IF EXISTS SIEGE;
--CREATE TABLE SIEGE(
--Id_Salle int PRIMARY KEY,
--Type_Si varchar(50),
--Id_Sa int REFERENCES SALLE(Id_Sa)
--);

--DROP TABLE IF EXISTS MANISESTATION;
--CREATE TABLE MANIFESTATION(
--Id_Ma int PRIMARY KEY,
--Nom_Ma varchar(50),
--Type_Ma varchar(50),
--Date_Ma date,
--Id_Sa int REFERENCES SALLE(Id_Sa)
--);
--GO

--INSERT INTO SALLE VALUES ('1', 'Jean Bouin', 'Th��tre', '400', 'La Roche sur Yon'), ('2', 'Herv� Bio', 'Salle communale', '700', 'Angers'), ('3', 'George Errand', 'Stade', '2000', 'Nantes'),
--						('4', 'Trabendo', 'Salle Spectacle', '1000', 'Le Mans'), ('5', 'De la Pleine', 'Salle communale', '100', 'La Roche sur Yon'), (6, 'Izidor', 'Th�atre', 300, 'Nantes'), (7, 'Zenith', 'Salle de spectacle', 800, 'Angers'),
--						(8, 'Shumekan', 'Complexe sportif', 500, 'Saint Nazaire'), (9, 'Jacques Sega', 'Salle communale', 200, 'Cholet'), (10, 'Multiglobal', 'Complexe sportif', 700, 'Allones');

--INSERT INTO SIEGE VALUES ('1', '3�me Classe', '2'), ('2', '2�me classe', '5'), ('3', '2�me classe', '5'), ('4', '3�me classe', '4'), ('5', '3�me classe', '1'), ('6', '3�me classe', '7'), ('7', '1�re classe', '8'), ('8', '2�me classe', '6'), ('9', '3�me classe', '5'), ('10', '1�re classe', '4'); 

--INSERT INTO MANIFESTATION VALUES ('1', 'Garbage', 'Concert', '10/02/2016', '7'), ('2', 'Mariage H et L', 'Mariage', '01/03/2016', '2'), ('3', 'Laval VS Nantes', 'Rencontre Sportive', '12/10/2016', '3'), ('4', 'Ph�dre', 'Pi�ce', '20/12/2016', '6'), ('5', 'Eric Antoine', 'One man show', '14/09/2016', '1'), ('6','Le P�re no�l est une ordure','Pi�ce','12-07-2016', '4'), ('7','Rouen VS Le Mans','Rencontre sportive','24-08-2016','8'), ('8','Metallica','Concert','08-09-2016','3'), ('9','Forum des associations','Forum','05-04-2016','5'), ('10', 'Forum des metiers', 'Forum', '09/03/2016', '9');

--UPDATE SALLE SET Type_Sa='Th��tre' WHERE Id_Sa = 6;

--Q1
--SELECT manifestation.Nom_Ma, salle.Adr_Sa FROM MANIFESTATION INNER JOIN SALLE ON manifestation.Id_Sa=salle.Id_Sa WHERE manifestation.Type_Ma IN ('Rencontre Sportive', 'One man show', 'Pi�ce', 'Concert');

--Q2
--SELECT DISTINCT manifestation.Nom_Ma, manifestation.Date_Ma, salle.Adr_Sa FROM MANIFESTATION INNER JOIN SALLE ON manifestation.Id_Sa=salle.Id_Sa INNER JOIN SIEGE ON siege.Id_Sa=salle.Id_Sa WHERE siege.Type_Si='1�re classe';

--Q3
--SELECT Type_Siege, COUNT(Type_Siege) FROM SIEGE INNER JOIN SALLE ON SIEGE.Id_Sa=SALLE.Id_Sa WHERE Nom_Sa ='Jean Bouin' GROUP BY Type_Siege;

--Q4
--SELECT Type_Sa, AVG(salle.Surf_Sa) AS Moyenne FROM SALLE WHERE Adr_Sa ='Nantes' GROUP BY salle.Type_Sa HAVING AVG(salle.Surf_Sa) > 200;

--Q5
--SELECT Nom_Ma FROM MANIFESTATION WHERE NOT EXISTS (SELECT * FROM SIEGE WHERE MANIFESTATION.Id_Sa=SIEGE.Id_Sa AND Type_Siege='3�me classe');
--SELECT Nom_Ma FROM MANIFESTATION INNER JOIN SIEGE ON MANIFESTATION.Id_Sa=SIEGE.Id_Sa WHERE Type_Siege<>'3�me classe';

--Q6
--UPDATE MANIFESTATION SET Date_Ma='30/09/2016' WHERE Nom_Ma = 'Mariage H et L';
--SELECT * FROM MANIFESTATION;

--Q7
--DELETE FROM SIEGE WHERE SIEGE.Id_Sa IN (SELECT SIEGE.Id_Sa FROM SIEGE INNER JOIN SALLE ON SIEGE.Id_Sa=SALLE.Id_Sa WHERE SALLE.Nom_Sa='De la pleine');
--SELECT * FROM SIEGE;

--Q8
--ALTER TABLE MANIFESTATION ADD CONSTRAINT date_a_mettre CHECK (Date_Ma IS NOT NULL);

--Q9
--ALTER TABLE MANIFESTATION ADD CONSTRAINT SUPP_SALLE FOREIGN KEY(Id_Sa) REFERENCES SALLE(Id_Sa) ON DELETE SET NULL;

--Q10
--SELECT * FROM MANIFESTATION INNER JOIN SALLE ON MANIFESTATION.Id_Sa = SALLE.Id_Sa WHERE Surf_Sa > (SELECT MAX(Surf_Sa) FROM SALLE WHERE Type_Sa = 'Th��tre'); 