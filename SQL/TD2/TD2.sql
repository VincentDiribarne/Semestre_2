--Exercice 1

--Question 1

--IF EXISTS (SELECT * FROM sysobjects WHERE name='clientLPL')
--DROP PROCEDURE clientLPL;
--GO

--CREATE PROCEDURE clientLPL 
--AS
--SET NOCOUNT ON
--BEGIN
--	DECLARE @Nom VARCHAR(100), @Prenom VARCHAR(100), @solde INT;
--	DECLARE AffInfoClient CURSOR LOCAL FOR SELECT CLIENT.nom, CLIENT.Prénom, CLIENT.solde FROM CLIENT;	
--	OPEN AffInfoClient;
--	FETCH AffInfoClient INTO @Nom, @Prenom, @solde;
--	WHILE @@FETCH_STATUS=0
--	BEGIN
--		SELECT @Nom, @Prenom, @solde;
--		FETCH AffInfoClient INTO @Nom, @Prenom, @solde;
--	END
--	CLOSE AffInfoClient
--	DEALLOCATE AffInfoClient
--END
--GO

--Question 2

--IF EXISTS (SELECT * FROM sysobjects WHERE name='activiteLPL')
--DROP PROCEDURE activiteLPL;
--GO

--CREATE PROCEDURE activiteLPL 
--AS
--SET NOCOUNT ON
--BEGIN
--	DECLARE @Nom VARCHAR(100), @Libellé VARCHAR(100), @prix INT;
--	DECLARE @temp VARCHAR(100), @temp2 VARCHAR(100);
--	DECLARE AffInfoActivites CURSOR LOCAL FOR SELECT ACTIVITES.Nom_station, ACTIVITES.libellé, ACTIVITES.prix FROM ACTIVITES ORDER BY ACTIVITES.Nom_station;	
--	OPEN AffInfoActivites;
--	FETCH AffInfoActivites INTO @Nom, @Libellé, @prix;
--	SELECT @Nom, @Libellé, @prix;
--	SET @temp=@Nom;
--	WHILE @@FETCH_STATUS=0
--	BEGIN
--	FETCH AffInfoActivites INTO @Nom, @Libellé, @prix;
--		IF @temp<>@nom
--			BEGIN
--			SELECT @Nom, @Libellé, @prix;
--			END
--	SET @temp=@nom;
--	END
--	CLOSE AffInfoActivites
--	DEALLOCATE AffInfoActivites
--END
--GO


--Question 3

--IF EXISTS (SELECT * FROM sysobjects WHERE name='clientPremium')
--DROP PROCEDURE clientPremium;
--GO

--CREATE PROCEDURE clientPremium 
--@solde_min FLOAT
--AS
--SET NOCOUNT ON
--BEGIN
--	DECLARE @clientPremium TABLE (
--		Nom VARCHAR(100),
--		Prenom VARCHAR(100),
--		Solde INT
--	);
	
--	DECLARE @Nom VARCHAR(100), @prenom VARCHAR(100), @prix INT;
--	DECLARE AffInfoActivites CURSOR LOCAL FOR SELECT CLIENT.nom, CLIENT.Prénom, CLIENT.solde FROM CLIENT;
--	OPEN AffInfoActivites;
--	FETCH AffInfoActivites INTO @Nom, @prenom, @prix;
--	WHILE @@FETCH_STATUS=0
--	BEGIN
--	IF @prix >= @solde_min
--		INSERT INTO @clientPremium (Nom, Prenom, Solde) VALUES (@Nom, @prenom, @prix);
--		FETCH AffInfoActivites INTO @Nom, @prenom, @prix;
--	END
--	CLOSE AffInfoActivites
--	DEALLOCATE AffInfoActivites
--	SELECT * FROM @clientPremium;
--END
--GO


--Question 3 (version 2)

--IF EXISTS (SELECT * FROM sysobjects WHERE name='clientPremium2')
--DROP PROCEDURE clientPremium2;
--GO

--CREATE PROCEDURE clientPremium2 
--@solde_min FLOAT
--AS
--SET NOCOUNT ON
--BEGIN
--	DECLARE @clientPremium TABLE (
--		Nom VARCHAR(100),
--		Prenom VARCHAR(100),
--		Solde INT
--	);
--	INSERT INTO @clientPremium SELECT nom, prénom, solde FROM CLIENT WHERE solde >= @solde_min	
--	SELECT * FROM @clientPremium;
--END
--GO

--Question 4 

--IF EXISTS (SELECT * FROM sysobjects WHERE name='clientStatut')
--DROP PROCEDURE clientStatut;
--GO

--CREATE PROCEDURE clientStatut 
--@min_sejour INT,
--@solde_min FLOAT
--AS
--SET NOCOUNT ON
--BEGIN
--	DECLARE @clientStatut TABLE (
--		Nom VARCHAR(100),
--		Prenom VARCHAR(100),
--		Statut VARCHAR(100)
--	);
--	DECLARE @Nom VARCHAR(100), @prenom VARCHAR(100), @solde INT, @sejour INT, @Statut VARCHAR(100);
--	DECLARE AffInfoStatut CURSOR LOCAL FOR SELECT CLIENT.nom, CLIENT.Prénom, CLIENT.solde, COUNT(SEJOUR.Id_client) FROM CLIENT INNER JOIN SEJOUR ON SEJOUR.Id_client=CLIENT.Id_client GROUP BY CLIENT.nom, CLIENT.Prénom, CLIENT.solde;
--	OPEN AffInfoStatut;
--	FETCH AffInfoStatut INTO @Nom, @prenom, @solde, @sejour;
--	WHILE @@FETCH_STATUS=0
--	BEGIN
--		SET @Statut=CASE
--			WHEN @solde >= @solde_min AND @sejour >= @min_sejour THEN 'Premium et Actif'
--			WHEN @sejour >= @min_sejour THEN 'Actif'
--			WHEN @solde >= @solde_min THEN 'Premium'
--			ELSE 'Occasionnel'
--		END
--		INSERT INTO @clientStatut (Nom, Prenom, Statut) VALUES (@Nom, @prenom, @Statut);
--		FETCH AffInfoStatut INTO @Nom, @prenom, @solde, @sejour;
--	END
--	CLOSE AffInfoStatut
--	DEALLOCATE AffInfoStatut
--	SELECT * FROM @clientStatut;
--END
--GO

--QUESTION 5
--IF EXISTS (SELECT * FROM sysobjects WHERE name='stationActiviteLigne')
--DROP PROCEDURE stationActiviteLigne;
--GO

--CREATE PROCEDURE stationActiviteLigne 
--@nbLigne INT
--AS
--SET NOCOUNT ON
--BEGIN
--	DECLARE @stationActivite TABLE (
--		Ligne VARCHAR(100),
--		NomStation VARCHAR(100),
--		Lieu VARCHAR(100),
--		Tarif FLOAT,
--		Libelle VARCHAR(100),
--		Prix INT
--	);
--	DECLARE @Ligne VARCHAR(100), @NomStation VARCHAR(100), @Lieu VARCHAR(100), @Tarif FLOAT, @Libelle VARCHAR(100), @Prix INT;
--	DECLARE @NombreLigne INT;
--	SET @NombreLigne=0;
--	DECLARE AffInfoStatut CURSOR LOCAL FOR SELECT STATION.Nom_station, STATION.lieu, STATION.tarif, ACTIVITES.libellé, ACTIVITES.prix FROM STATION INNER JOIN ACTIVITES ON STATION.Nom_station=ACTIVITES.Nom_station;
--	OPEN AffInfoStatut;
--	FETCH AffInfoStatut INTO @NomStation, @Lieu, @Tarif, @Libelle, @Prix;
--	WHILE @@FETCH_STATUS=0
--	BEGIN
--	PRINT @NombreLigne;
--		IF @NombreLigne < @nbLigne
--		BEGIN
--			SET @Ligne = 'Ligne ' + CAST(@NombreLigne AS VARCHAR(100));
--			INSERT INTO @stationActivite (Ligne, NomStation, Lieu, Tarif, Libelle, Prix) VALUES (@Ligne, @NomStation, @Lieu, @Tarif, @Libelle, @Prix);
--		END
--		SET @NombreLigne = @NombreLigne + 1;
--		FETCH AffInfoStatut INTO @NomStation, @Lieu, @Tarif, @Libelle, @Prix;
--	END
--	CLOSE AffInfoStatut
--	DEALLOCATE AffInfoStatut
--	SELECT * FROM @stationActivite;
--END
--GO

--QUESTION 6
--IF EXISTS (SELECT * FROM sysobjects WHERE name='deleteStationActivite')
--DROP PROCEDURE deleteStationActivite;
--GO

--CREATE PROCEDURE deleteStationActivite 
--@nbLigne INT
--AS
--SET NOCOUNT ON
--BEGIN
--	DECLARE @NomStation VARCHAR(100), @Lieu VARCHAR(100), @Tarif FLOAT, @region VARCHAR(100), @capacité INT, @count INT, @activites VARCHAR(100);
--	DECLARE AffInfoStatut CURSOR LOCAL FOR SELECT STATION.Nom_station, STATION.capacité, STATION.lieu, STATION.région, STATION.tarif FROM STATION
--	OPEN AffInfoStatut;
--	FETCH AffInfoStatut INTO @NomStation, @capacité, @Lieu, @region, @Tarif;
--	SELECT * FROM STATION;
--	WHILE @@FETCH_STATUS=0
--	BEGIN
--		SET @count = (SELECT COUNT(ACTIVITES.libellé) FROM ACTIVITES WHERE Nom_station=@NomStation) 
--		PRINT @count
--		IF @count < @nbLigne
--		BEGIN
--			DELETE FROM dbo.STATION WHERE Nom_station=@NomStation
--		END
--		FETCH AffInfoStatut INTO @NomStation, @capacité, @Lieu, @region, @Tarif;
--	END
--	CLOSE AffInfoStatut
--	DEALLOCATE AffInfoStatut
--END
--GO


--Question 7
--IF OBJECT_ID('STATIONAVG') IS NOT NULL
--	DROP TABLE STATIONAVG
--GO

--SELECT *, MoyenneActivités=0 INTO STATIONAVG FROM dbo.STATION
--ALTER TABLE STATIONAVG
--ALTER COLUMN MoyenneActivités float;
--SELECT * FROM STATIONAVG

--IF EXISTS (SELECT * FROM sysobjects WHERE name='avgActivites')
--DROP PROCEDURE avgActivites;
--GO

--CREATE PROCEDURE avgActivites 
--AS
--SET NOCOUNT ON
--BEGIN
--	DECLARE @NomStation VARCHAR(100), @avg FLOAT;
--	DECLARE AffInfoStatut CURSOR LOCAL FOR SELECT Nom_station, AVG(prix) FROM ACTIVITES GROUP BY Nom_station
--	OPEN AffInfoStatut;
--	FETCH AffInfoStatut INTO @NomStation, @avg
--	WHILE @@FETCH_STATUS=0
--	BEGIN
--		UPDATE STATIONAVG SET MoyenneActivités = @avg WHERE Nom_station=@NomStation;	
--		FETCH AffInfoStatut INTO @NomStation, @avg
--	END
--	CLOSE AffInfoStatut
--	DEALLOCATE AffInfoStatut
--END
--GO


--Question 8

IF EXISTS (SELECT * FROM sysobjects WHERE name='ajusteActivitesStation')
DROP PROCEDURE ajusteActivitesStation;
GO

CREATE PROCEDURE ajusteActivitesStation
@moyenneLimiteSuppr FLOAT,
@moyenneLimiteUpdate INT
AS
SET NOCOUNT ON
BEGIN
	DECLARE @NomStation VARCHAR(100), @avg FLOAT, @prix FLOAT, @libelle VARCHAR(100);
	DECLARE AffInfoStatut CURSOR LOCAL FOR SELECT STATIONAVG.Nom_station, STATIONAVG.MoyenneActivités FROM STATIONAVG;
	OPEN AffInfoStatut;
	FETCH AffInfoStatut INTO @NomStation, @avg;
	WHILE @@FETCH_STATUS=0
	BEGIN
		IF @moyenneLimiteSuppr >= @moyenneLimiteUpdate
		BEGIN
			SELECT 'Erreur, moyenneLimiteSuppr >= moyenneLimiteUpdate';
		END
		ELSE IF @avg < @moyenneLimiteSuppr
		BEGIN
			DELETE FROM dbo.STATION WHERE @NomStation=Nom_station
			DELETE FROM dbo.ACTIVITES WHERE @NomStation=Nom_station
			DELETE FROM dbo.SEJOUR WHERE @NomStation=Nom_station
		END
		ELSE IF @avg > @moyenneLimiteUpdate
		BEGIN
			DECLARE AffActivite CURSOR LOCAL FOR SELECT ACTIVITES.libellé, ACTIVITES.prix FROM ACTIVITES WHERE @NomStation=Nom_station
			OPEN AffActivite;
			FETCH AffActivite INTO @libelle, @prix;
			WHILE @@FETCH_STATUS=0
			BEGIN
				SET @prix = @prix/2;
				UPDATE ACTIVITES SET prix = @prix WHERE @NomStation=Nom_Station AND @libelle=libellé;
				FETCH AffActivite INTO  @libelle, @prix
			END
			CLOSE AffActivite
			DEALLOCATE AffActivite
		END
	FETCH AffInfoStatut INTO @NomStation, @avg;
	END
	CLOSE AffInfoStatut
	DEALLOCATE AffInfoStatut
END
GO