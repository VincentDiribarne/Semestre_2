-- Question 1

--IF EXISTS (SELECT * FROM sysobjects WHERE name='displayArg')
--DROP PROCEDURE displayArg;
--GO

--CREATE PROCEDURE displayArg
--@nom VARCHAR(30) OUTPUT,
--@nombre FLOAT OUTPUT,
--@date DATE OUT
--AS
--SET NOCOUNT ON
--BEGIN

--SELECT @nom, @nombre, @date;

--END 
--GO


-- Question 2

--IF EXISTS (SELECT * FROM sysobjects WHERE name='mult2')
--DROP PROCEDURE mult2;
--GO

--CREATE PROCEDURE mult2
--@nombre INT
--AS
--SET NOCOUNT ON
--BEGIN
--IF @nombre % 2 = 0
--	BEGIN
--	SELECT 'Multiple de 2';
--	END
--	ELSE
--	BEGIN
--	SELECT 'Non multiple de 2';
--	END
--END
--GO


-- Question 3

--IF EXISTS (SELECT * FROM sysobjects WHERE name='mult23')
--DROP PROCEDURE mult23;
--GO

--CREATE PROCEDURE mult23
--@nombre INT
--AS
--SET NOCOUNT ON
--BEGIN
--IF @nombre % 2 = 0 AND @nombre % 3 = 0
--	BEGIN
--	SELECT 'Multiple de 2 et de 3';
--	END	
--	ELSE
--	BEGIN
--	SELECT 'Non multiple de 2 et de 3';
--	END
--END
--GO


-- Question 4

--IF EXISTS (SELECT * FROM sysobjects WHERE name='calcPrixTTC')
--DROP PROCEDURE calcPrixTTC;
--GO

--CREATE PROCEDURE calcPrixTTC
--@prixHT FLOAT
--AS 
--SET NOCOUNT ON
--BEGIN
--DECLARE @tva FLOAT;
--SET @tva=1.2;
--SELECT HT=@prixHT, TTV=@prixHT*@tva, TVA='20%';
--END
--GO


-- Question 5

--IF EXISTS (SELECT * FROM sysobjects WHERE name='reducTTC')
--DROP PROCEDURE reducTTC;
--GO

--CREATE PROCEDURE reducTTC
--@prixHT FLOAT
--AS 
--SET NOCOUNT ON
--BEGIN
--DECLARE @tva FLOAT;
--DECLARE @difference FLOAT;
--DECLARE @prixTTC FLOAT;
--SET @tva=1.2;
--SET @prixTTC = @prixHT * @tva;
--SET @difference = @prixTTC - @prixHT;
--SELECT 'difference avec une TVA à 20%'=@difference;
--IF @difference > 50
--	BEGIN
--	SET @tva=1.1;
--	SET @prixTTC = @prixHT * @tva;
--	SELECT HT=@prixHT, TTV=@prixHT*@tva, TVA='10%';
--	END
--END
--GO


---- Question 6

--IF EXISTS (SELECT * FROM sysobjects WHERE name='mult235')
--DROP PROCEDURE mult235;
--GO

--CREATE PROCEDURE mult235
--@nombre INT
--AS 
--SET NOCOUNT ON
--BEGIN
--DECLARE @mult2 VARCHAR(100);
--DECLARE @mult3 VARCHAR(100);
--DECLARE @mult5 VARCHAR(100);
--SET @mult2 = 'faux';
--SET @mult3 = 'faux';
--SET @mult5 = 'faux';

--IF @nombre % 2 = 0
--	BEGIN
--	SELECT 'Multiple de 2';
--	SET @mult2 = 'Vrai';
--	END

--	IF @nombre % 3 = 0
--	BEGIN
--	SELECT 'Multiple de 3';
--	SET @mult3 = 'Vrai';
--	END

--	IF @nombre % 5 = 0
--	BEGIN
--	SELECT 'Multiple de 5';
--	SET @mult5 = 'Vrai';
--	END

--	IF (@mult2 <> 'Vrai') AND (@mult3 <> 'Vrai') AND (@mult5 <> 'Vrai')
--	BEGIN
--	SELECT 'Ni multiple de 2, de 3 et de 5';
--	RETURN 1;
--	END
--END
--GO 


-- Question 7

--IF EXISTS (SELECT * FROM sysobjects WHERE name='calcPrixCarte')
--DROP PROCEDURE calcPrixCarte;
--GO

--CREATE PROCEDURE calcPrixCarte 
--@prixBillet INT,
--@nomCarteAbo VARCHAR(100)
--AS
--SET NOCOUNT ON
--BEGIN
--DECLARE @reduc FLOAT;
--DECLARE @prixReduit FLOAT;
--SET @reduc = 0;

--IF @nomCarteAbo='jeune'
--	BEGIN
--	SET @reduc = 0.70;
--	END

--IF @nomCarteAbo='week-end'
--	BEGIN
--	SET @reduc = 0.75;
--	END

--IF @nomCarteAbo='senior+'
--	BEGIN
--	SET @reduc = 0.50;
--	END

--IF @nomCarteAbo='enfant+'
--	BEGIN
--	SET @reduc = 0.50;
--	END

--IF @reduc = 0
--	BEGIN 
--	SET @prixReduit = @prixBillet;
--	END
--	ELSE 
--	BEGIN
--	SET @prixReduit = @prixBillet * @reduc
--	END

--SELECT 'Prix de depart' = @prixBillet, 'Reduction' = @reduc * 100, 'Prix reduit' = @prixReduit;
--END
--GO


-- Question 8

--IF EXISTS (SELECT * FROM sysobjects WHERE name='affPourReduc')
--DROP PROCEDURE affPourReduc;
--GO

--CREATE PROCEDURE affPourReduc
--@prix INT,
--@reduc INT
--AS
--SET NOCOUNT ON
--BEGIN
--DECLARE @deuxiemePrix INT;
--DECLARE @chaine VARCHAR(100);
--SET @deuxiemeprix = @prix - @reduc;
--IF @prix<0 OR @reduc<0 OR @prix < @reduc
--	BEGIN
--	SELECT 'Erreur, paramètres incorrects'
--	END
--ELSE
--BEGIN
--	SET @chaine=CASE
--		WHEN @deuxiemeprix <= 10 THEN 'Inferieur à 10%'
--		WHEN @deuxiemeprix > 10 AND @deuxiemeprix <= 20 THEN 'Superieur à 10%'
--		WHEN @deuxiemeprix > 20 AND @deuxiemeprix <= 40 THEN 'Superieur à 20%'
--		WHEN @deuxiemeprix > 40 AND @deuxiemeprix <= 50 THEN 'Superieur à 40%'
--		WHEN @deuxiemeprix > 50 AND @deuxiemeprix <= 70 THEN 'Superieur à 50%'
--		WHEN @deuxiemeprix > 70 AND @deuxiemeprix <= 90 THEN 'Superieur à 70%'
--		WHEN @deuxiemeprix > 90 THEN 'Superieur à 90%'
--	END
--	SELECT '%' = @deuxiemePrix, 'Reduction'= @chaine;
--END
--END
--GO

-- Question 9

--IF EXISTS (SELECT * FROM sysobjects WHERE name='estPremier')
--DROP PROCEDURE estPremier;
--GO

--CREATE PROCEDURE estPremier
--@nombre INT
--AS
--SET NOCOUNT ON
--BEGIN

--DECLARE @i INT;
--DECLARE @capacité INT;

--SET @i = 1;
--SET @capacité = 0;

--WHILE (@i <= @nombre)
--BEGIN
--    IF @nombre % @i = 0
--    BEGIN
--        SET @capacité = @capacité + 1;
--    END
--    SET @i = @i + 1;
--END
--IF @capacité > 2
--BEGIN
--	SELECT CAST(@nombre AS varchar(10)) + ' n est pas premier';
--	RETURN 1
--END
--ELSE
--BEGIN
--	SELECT CAST(@nombre AS varchar(10)) + ' est premier';
--	RETURN 0
--END
--END
--GO


----Question 10

--IF EXISTS (SELECT * FROM sysobjects WHERE name='mult235exo10')
--DROP PROCEDURE mult235exo10;
--GO

--CREATE PROCEDURE mult235exo10
--@nombre INT
--AS 
--SET NOCOUNT ON
--BEGIN
--DECLARE @mult2 VARCHAR(100);
--DECLARE @mult3 VARCHAR(100);
--DECLARE @mult5 VARCHAR(100);
--DECLARE @result INT
--SET @result = 0
--SET @mult2 = 'faux';
--SET @mult3 = 'faux';
--SET @mult5 = 'faux';

--IF @nombre % 2 = 0
--	BEGIN
--	SELECT 'Multiple de 2';
--	SET @mult2 = 'Vrai';
--	SET @result = 0;
--	END

--	IF @nombre % 3 = 0
--	BEGIN
--	SELECT 'Multiple de 3';
--	SET @mult3 = 'Vrai';
--	SET @result = 0;
--	END

--	IF @nombre % 5 = 0
--	BEGIN
--	SELECT 'Multiple de 5';
--	SET @mult5 = 'Vrai';
--	SET @result = 0;
--	END

--	IF (@mult2 <> 'Vrai') AND (@mult3 <> 'Vrai') AND (@mult5 <> 'Vrai')
--	BEGIN
--		set @result=1;
--	END

--RETURN @result;
--END
--GO

--IF EXISTS (SELECT * FROM sysobjects WHERE name='estPremierexo10')
--DROP PROCEDURE estPremierexo10;
--GO

--CREATE PROCEDURE estPremierexo10
--@nombre INT
--AS
--SET NOCOUNT ON
--BEGIN

--DECLARE @i INT;
--DECLARE @capacité INT;

--SET @i = 1;
--SET @capacité = 0;

--WHILE (@i <= @nombre)
--BEGIN
--    IF @nombre % @i = 0
--    BEGIN
--        SET @capacité = @capacité + 1;
--    END
--    SET @i = @i + 1;
--END
--IF @capacité > 2
--BEGIN
--	SELECT CAST(@nombre AS varchar(10)) + ' n est pas premier';
--END
--ELSE
--BEGIN
--	SELECT CAST(@nombre AS varchar(10)) + ' est premier';
--END
--END
--GO

--IF EXISTS (SELECT * FROM sysobjects WHERE name='mult235Premier')
--DROP PROCEDURE mult235Premier;
--GO

--CREATE PROCEDURE mult235Premier 
--@nombre INT
--AS
--SET NOCOUNT ON
--BEGIN
--DECLARE @returnMult INT;
--	execute @returnMult=mult235exo10 @nombre;
--	IF (@returnMult = 1)
--		BEGIN
--		execute estPremierexo10 @nombre;
--		END
--END
--GO


--EXERCICE 2


--Question 1

--IF EXISTS (SELECT * FROM sysobjects WHERE name='clientStationActivités')
--DROP PROCEDURE clientStationActivités;
--GO

--CREATE PROCEDURE clientStationActivités 
--AS
--SET NOCOUNT ON
--BEGIN
--	SELECT CLIENT.nom, CLIENT.Prénom, STATION.Nom_station, ACTIVITES.libellé FROM CLIENT INNER JOIN SEJOUR ON client.Id_client=sejour.Id_client INNER JOIN STATION ON SEJOUR.Nom_station=STATION.Nom_station INNER JOIN ACTIVITES ON SEJOUR.Nom_station=ACTIVITES.Nom_station;
--END
--GO


--Question 2

--IF EXISTS (SELECT * FROM sysobjects WHERE name='clientActivités')
--DROP PROCEDURE clientActivités;
--GO

--CREATE PROCEDURE clientActivités 
--@nom_station VARCHAR(100),
--@libelle VARCHAR(100)
--AS
--SET NOCOUNT ON
--BEGIN
--	SELECT CLIENT.nom, CLIENT.Prénom, STATION.Nom_station, ACTIVITES.libellé FROM CLIENT INNER JOIN SEJOUR ON client.Id_client=sejour.Id_client INNER JOIN STATION ON SEJOUR.Nom_station=STATION.Nom_station INNER JOIN ACTIVITES ON SEJOUR.Nom_station=ACTIVITES.Nom_station WHERE STATION.Nom_station=@nom_station AND ACTIVITES.libellé=@libelle;
--END
--GO


--Question 3

--IF EXISTS (SELECT * FROM sysobjects WHERE name='clientNbActivités')
--DROP PROCEDURE clientNbActivités;
--GO

--CREATE PROCEDURE clientNbActivités 
--@nbActivite INT
--AS
--SET NOCOUNT ON
--BEGIN
--	SELECT CLIENT.nom AS Nom, CLIENT.Prénom, STATION.Nom_station, COUNT(ACTIVITES.libellé) AS NbActivités FROM CLIENT INNER JOIN SEJOUR ON client.Id_client=sejour.Id_client INNER JOIN STATION ON SEJOUR.Nom_station=STATION.Nom_station INNER JOIN ACTIVITES ON SEJOUR.Nom_station=ACTIVITES.Nom_station GROUP BY nom, CLIENT.Prénom, STATION.Nom_station HAVING COUNT(ACTIVITES.libellé) >= @nbActivite;
--END
--GO


--Question 4 

--IF EXISTS (SELECT * FROM sysobjects WHERE name='etatCapacitéStation')
--DROP PROCEDURE etatCapacitéStation;
--GO

--CREATE PROCEDURE etatCapacitéStation 
--@tarif INT
--AS
--SET NOCOUNT ON
--BEGIN

--SELECT STATION.Nom_station, STATION.capacité, Etat_Capacité=CASE
--		WHEN capacité <= 50 THEN 'Modeste'
--		WHEN capacité > 50 AND capacité <= 150 THEN 'Normal'
--		WHEN capacité > 150 AND capacité <= 250 THEN 'Haut'
--		WHEN capacité > 250 THEN 'Très haute'
--	END 
--	,STATION.lieu, STATION.région, STATION.tarif FROM STATION WHERE STATION.tarif > @tarif;
--END
--GO


--Question 5 

--IF EXISTS (SELECT * FROM sysobjects WHERE name='reductionStation')
--DROP PROCEDURE reductionStation;
--GO

--CREATE PROCEDURE reductionStation 
--@region VARCHAR(100),
--@reduc FLOAT
--AS
--SET NOCOUNT ON
--BEGIN
--SET @reduc = (100 - @reduc) / 100; 

--SELECT STATION.Nom_station, STATION.capacité, STATION.lieu, STATION.région, STATION.tarif FROM STATION WHERE STATION.région=@region;
--UPDATE STATION SET tarif = @reduc*tarif;
--SELECT STATION.Nom_station, STATION.capacité, STATION.lieu, STATION.région, STATION.tarif FROM STATION WHERE STATION.région=@region;
--END
--GO

--Question 6

--IF EXISTS (SELECT * FROM sysobjects WHERE name='delLowCostStation')
--DROP PROCEDURE delLowCostStation;
--GO

--CREATE PROCEDURE delLowCostStation 
--@tarif int
--AS
--SET NOCOUNT ON
--BEGIN
--SELECT STATION.Nom_station, STATION.capacité, STATION.lieu, STATION.région, STATION.tarif FROM STATION;
--DELETE FROM dbo.STATION WHERE tarif < @tarif;
--SELECT STATION.Nom_station, STATION.capacité, STATION.lieu, STATION.région, STATION.tarif FROM STATION;
--END
--GO


--Question 7 

--IF EXISTS (SELECT * FROM sysobjects WHERE name='checkNoActiviteStation')
--DROP PROCEDURE checkNoActiviteStation;
--GO

--CREATE PROCEDURE checkNoActiviteStation 
--@station VARCHAR(100)
--AS
--SET NOCOUNT ON
--BEGIN
--	IF EXISTS (SELECT Nom_station FROM STATION WHERE Nom_station=@station) 
--	BEGIN
--		IF EXISTS (SELECT libellé FROM ACTIVITES INNER JOIN STATION ON STATION.Nom_station=ACTIVITES.Nom_station WHERE STATION.Nom_station=@station)
--			BEGIN
--			SELECT ACTIVITES.Nom_station, ACTIVITES.libellé, ACTIVITES.prix FROM ACTIVITES WHERE ACTIVITES.Nom_station=@station;
--			END
--		ELSE 
--			BEGIN
--			SELECT 'La station ne possède pas aucune activités, on la supprime';
--			DELETE FROM dbo.STATION WHERE STATION.Nom_station = @station;
--			SELECT STATION.Nom_station, STATION.capacité, STATION.lieu, STATION.région, STATION.tarif FROM STATION;
--			END
--	END
--END
--GO


--Question 8 

--IF EXISTS (SELECT * FROM sysobjects WHERE name='insertStation')
--DROP PROCEDURE insertStation;
--GO

--CREATE PROCEDURE insertStation
--@nom VARCHAR(100),
--@capacité INT,
--@lieu VARCHAR(100),
--@région VARCHAR(100),
--@tarif INT
--AS
--SET NOCOUNT ON
--DECLARE @tarifvar VARCHAR(100)
--DECLARE @capacitevar VARCHAR(100);
--DECLARE @texte1 VARCHAR(100);
--DECLARE @texte2 VARCHAR(100);
--DECLARE @texte3 VARCHAR(100);
--DECLARE @nombre INT
--BEGIN
--SET @nombre = (SELECT COUNT(@région) FROM STATION WHERE @région=région);

--	IF ((@tarif >= 1000) AND (@capacité >= 50 OR @capacité <= 500) AND (@nombre < 2))
--		BEGIN
--		IF EXISTS (SELECT NOM_Station FROM STATION WHERE STATION.Nom_station=@nom)
--			BEGIN
--			DELETE FROM dbo.STATION WHERE STATION.Nom_station = @nom;
--			END
--		SELECT STATION.Nom_station, STATION.capacité, STATION.lieu, STATION.région, STATION.tarif FROM STATION;
--		INSERT INTO STATION VALUES (@nom, @capacité, @lieu, @région, @tarif);
--		SELECT STATION.Nom_station, STATION.capacité, STATION.lieu, STATION.région, STATION.tarif FROM STATION;
--		END
--	ELSE
--		BEGIN
--		SELECT STATION.Nom_station, STATION.capacité, STATION.lieu, STATION.région, STATION.tarif FROM STATION;
--		SET @tarifvar = CAST(@tarif AS VARCHAR(100));
--		SET @capacitevar = CAST(@capacité AS VARCHAR(100));

--		IF (@tarif < 1000)
--			BEGIN
--			SET @texte1 = ('Tarif : ' +@tarifvar+ ' <= 1000');
--			END
--		ELSE
--			BEGIN
--			SET @texte1 = ('Tarif : OK');
--			END

--		IF (@capacité < 50 OR @capacité > 500)
--			BEGIN
--			SET @texte2 = ('Capacité : ' +@capacitevar+ ' non comprise entre 50 et 500');
--			END
--		ELSE
--			BEGIN
--			SET @texte2 = ('Capacité : OK');
--			END

--		IF (@nombre >= 2)
--			BEGIN
--			SET @texte3 = ('Il y a deux stations dans la même région que ' +@région);
--			END
--		ELSE
--			BEGIN
--			SET @texte3 = ('Région : OK');
--			END

--		SELECT 'Paramètres Incorrects : ' + @texte1 + ', ' + @texte2 + ', ' + @texte3;
--	END
--END
--GO

--Question 9 

--IF EXISTS (SELECT * FROM sysobjects WHERE name='checkActiviteStation')
--DROP PROCEDURE checkActiviteStation;
--GO

--CREATE PROCEDURE checkActiviteStation 
--@nom VARCHAR(100),
--@activité VARCHAR(100)
--AS
--SET NOCOUNT ON
--BEGIN
--	IF EXISTS (SELECT STATION.Nom_Station FROM STATION INNER JOIN ACTIVITES ON ACTIVITES.Nom_station=STATION.Nom_station WHERE STATION.Nom_station=@nom AND ACTIVITES.libellé= @activité)
--		BEGIN
--		SELECT 'Nom de la station' = @nom, 'Nom activité' = @activité, 'Nombre de Clients' = (SELECT SUM(SEJOUR.nbplaces) FROM SEJOUR WHERE Nom_station=@nom);
--		END
--	ELSE
--		BEGIN
--		SELECT 'Cette activité ' +@activité+ ' dans cette station ' +@nom+ ' ou cette station existe pas';
--		END
--END
--GO

--Question 10

--IF EXISTS (SELECT * FROM sysobjects WHERE name='checkCapaciteStation')
--DROP PROCEDURE checkCapaciteStation;
--GO

--CREATE PROCEDURE checkCapaciteStation 
--@nom VARCHAR(100)
--AS
--SET NOCOUNT ON
--BEGIN
--DECLARE @complet VARCHAR(100);
--DECLARE @capacite INT;
--DECLARE @nbClient INT;

--SET @capacite = (SELECT capacité FROM STATION WHERE @nom=STATION.Nom_station);
--SET @nbClient = (SELECT SUM(SEJOUR.nbplaces) FROM SEJOUR INNER JOIN STATION ON STATION.Nom_station=SEJOUR.Nom_station WHERE @nom=STATION.Nom_station);
--	IF (@capacite > @nbClient)
--		BEGIN
--		SET @complet = 'Non'
--		END
--	ELSE
--		BEGIN
--		SET @complet = 'Oui'
--		END
--	SELECT 'Nom de la station' = @nom, 'Capacité' = @capacite, 'Nombre de Clients' = @nbClient, 'Complets ?' = @complet;
--END
--GO