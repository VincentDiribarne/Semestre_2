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
--SELECT 'difference avec une TVA � 20%'=@difference;
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
--	SELECT 'Erreur, param�tres incorrects'
--	END
--ELSE
--BEGIN
--	SET @chaine=CASE
--		WHEN @deuxiemeprix <= 10 THEN 'Inferieur � 10%'
--		WHEN @deuxiemeprix > 10 AND @deuxiemeprix <= 20 THEN 'Superieur � 10%'
--		WHEN @deuxiemeprix > 20 AND @deuxiemeprix <= 40 THEN 'Superieur � 20%'
--		WHEN @deuxiemeprix > 40 AND @deuxiemeprix <= 50 THEN 'Superieur � 40%'
--		WHEN @deuxiemeprix > 50 AND @deuxiemeprix <= 70 THEN 'Superieur � 50%'
--		WHEN @deuxiemeprix > 70 AND @deuxiemeprix <= 90 THEN 'Superieur � 70%'
--		WHEN @deuxiemeprix > 90 THEN 'Superieur � 90%'
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
--DECLARE @capacit� INT;

--SET @i = 1;
--SET @capacit� = 0;

--WHILE (@i <= @nombre)
--BEGIN
--    IF @nombre % @i = 0
--    BEGIN
--        SET @capacit� = @capacit� + 1;
--    END
--    SET @i = @i + 1;
--END
--IF @capacit� > 2
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
--DECLARE @capacit� INT;

--SET @i = 1;
--SET @capacit� = 0;

--WHILE (@i <= @nombre)
--BEGIN
--    IF @nombre % @i = 0
--    BEGIN
--        SET @capacit� = @capacit� + 1;
--    END
--    SET @i = @i + 1;
--END
--IF @capacit� > 2
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

--IF EXISTS (SELECT * FROM sysobjects WHERE name='clientStationActivit�s')
--DROP PROCEDURE clientStationActivit�s;
--GO

--CREATE PROCEDURE clientStationActivit�s 
--AS
--SET NOCOUNT ON
--BEGIN
--	SELECT CLIENT.nom, CLIENT.Pr�nom, STATION.Nom_station, ACTIVITES.libell� FROM CLIENT INNER JOIN SEJOUR ON client.Id_client=sejour.Id_client INNER JOIN STATION ON SEJOUR.Nom_station=STATION.Nom_station INNER JOIN ACTIVITES ON SEJOUR.Nom_station=ACTIVITES.Nom_station;
--END
--GO


--Question 2

--IF EXISTS (SELECT * FROM sysobjects WHERE name='clientActivit�s')
--DROP PROCEDURE clientActivit�s;
--GO

--CREATE PROCEDURE clientActivit�s 
--@nom_station VARCHAR(100),
--@libelle VARCHAR(100)
--AS
--SET NOCOUNT ON
--BEGIN
--	SELECT CLIENT.nom, CLIENT.Pr�nom, STATION.Nom_station, ACTIVITES.libell� FROM CLIENT INNER JOIN SEJOUR ON client.Id_client=sejour.Id_client INNER JOIN STATION ON SEJOUR.Nom_station=STATION.Nom_station INNER JOIN ACTIVITES ON SEJOUR.Nom_station=ACTIVITES.Nom_station WHERE STATION.Nom_station=@nom_station AND ACTIVITES.libell�=@libelle;
--END
--GO


--Question 3

--IF EXISTS (SELECT * FROM sysobjects WHERE name='clientNbActivit�s')
--DROP PROCEDURE clientNbActivit�s;
--GO

--CREATE PROCEDURE clientNbActivit�s 
--@nbActivite INT
--AS
--SET NOCOUNT ON
--BEGIN
--	SELECT CLIENT.nom AS Nom, CLIENT.Pr�nom, STATION.Nom_station, COUNT(ACTIVITES.libell�) AS NbActivit�s FROM CLIENT INNER JOIN SEJOUR ON client.Id_client=sejour.Id_client INNER JOIN STATION ON SEJOUR.Nom_station=STATION.Nom_station INNER JOIN ACTIVITES ON SEJOUR.Nom_station=ACTIVITES.Nom_station GROUP BY nom, CLIENT.Pr�nom, STATION.Nom_station HAVING COUNT(ACTIVITES.libell�) >= @nbActivite;
--END
--GO


--Question 4 

--IF EXISTS (SELECT * FROM sysobjects WHERE name='etatCapacit�Station')
--DROP PROCEDURE etatCapacit�Station;
--GO

--CREATE PROCEDURE etatCapacit�Station 
--@tarif INT
--AS
--SET NOCOUNT ON
--BEGIN

--SELECT STATION.Nom_station, STATION.capacit�, Etat_Capacit�=CASE
--		WHEN capacit� <= 50 THEN 'Modeste'
--		WHEN capacit� > 50 AND capacit� <= 150 THEN 'Normal'
--		WHEN capacit� > 150 AND capacit� <= 250 THEN 'Haut'
--		WHEN capacit� > 250 THEN 'Tr�s haute'
--	END 
--	,STATION.lieu, STATION.r�gion, STATION.tarif FROM STATION WHERE STATION.tarif > @tarif;
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

--SELECT STATION.Nom_station, STATION.capacit�, STATION.lieu, STATION.r�gion, STATION.tarif FROM STATION WHERE STATION.r�gion=@region;
--UPDATE STATION SET tarif = @reduc*tarif;
--SELECT STATION.Nom_station, STATION.capacit�, STATION.lieu, STATION.r�gion, STATION.tarif FROM STATION WHERE STATION.r�gion=@region;
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
--SELECT STATION.Nom_station, STATION.capacit�, STATION.lieu, STATION.r�gion, STATION.tarif FROM STATION;
--DELETE FROM dbo.STATION WHERE tarif < @tarif;
--SELECT STATION.Nom_station, STATION.capacit�, STATION.lieu, STATION.r�gion, STATION.tarif FROM STATION;
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
--		IF EXISTS (SELECT libell� FROM ACTIVITES INNER JOIN STATION ON STATION.Nom_station=ACTIVITES.Nom_station WHERE STATION.Nom_station=@station)
--			BEGIN
--			SELECT ACTIVITES.Nom_station, ACTIVITES.libell�, ACTIVITES.prix FROM ACTIVITES WHERE ACTIVITES.Nom_station=@station;
--			END
--		ELSE 
--			BEGIN
--			SELECT 'La station ne poss�de pas aucune activit�s, on la supprime';
--			DELETE FROM dbo.STATION WHERE STATION.Nom_station = @station;
--			SELECT STATION.Nom_station, STATION.capacit�, STATION.lieu, STATION.r�gion, STATION.tarif FROM STATION;
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
--@capacit� INT,
--@lieu VARCHAR(100),
--@r�gion VARCHAR(100),
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
--SET @nombre = (SELECT COUNT(@r�gion) FROM STATION WHERE @r�gion=r�gion);

--	IF ((@tarif >= 1000) AND (@capacit� >= 50 OR @capacit� <= 500) AND (@nombre < 2))
--		BEGIN
--		IF EXISTS (SELECT NOM_Station FROM STATION WHERE STATION.Nom_station=@nom)
--			BEGIN
--			DELETE FROM dbo.STATION WHERE STATION.Nom_station = @nom;
--			END
--		SELECT STATION.Nom_station, STATION.capacit�, STATION.lieu, STATION.r�gion, STATION.tarif FROM STATION;
--		INSERT INTO STATION VALUES (@nom, @capacit�, @lieu, @r�gion, @tarif);
--		SELECT STATION.Nom_station, STATION.capacit�, STATION.lieu, STATION.r�gion, STATION.tarif FROM STATION;
--		END
--	ELSE
--		BEGIN
--		SELECT STATION.Nom_station, STATION.capacit�, STATION.lieu, STATION.r�gion, STATION.tarif FROM STATION;
--		SET @tarifvar = CAST(@tarif AS VARCHAR(100));
--		SET @capacitevar = CAST(@capacit� AS VARCHAR(100));

--		IF (@tarif < 1000)
--			BEGIN
--			SET @texte1 = ('Tarif : ' +@tarifvar+ ' <= 1000');
--			END
--		ELSE
--			BEGIN
--			SET @texte1 = ('Tarif : OK');
--			END

--		IF (@capacit� < 50 OR @capacit� > 500)
--			BEGIN
--			SET @texte2 = ('Capacit� : ' +@capacitevar+ ' non comprise entre 50 et 500');
--			END
--		ELSE
--			BEGIN
--			SET @texte2 = ('Capacit� : OK');
--			END

--		IF (@nombre >= 2)
--			BEGIN
--			SET @texte3 = ('Il y a deux stations dans la m�me r�gion que ' +@r�gion);
--			END
--		ELSE
--			BEGIN
--			SET @texte3 = ('R�gion : OK');
--			END

--		SELECT 'Param�tres Incorrects : ' + @texte1 + ', ' + @texte2 + ', ' + @texte3;
--	END
--END
--GO

--Question 9 

--IF EXISTS (SELECT * FROM sysobjects WHERE name='checkActiviteStation')
--DROP PROCEDURE checkActiviteStation;
--GO

--CREATE PROCEDURE checkActiviteStation 
--@nom VARCHAR(100),
--@activit� VARCHAR(100)
--AS
--SET NOCOUNT ON
--BEGIN
--	IF EXISTS (SELECT STATION.Nom_Station FROM STATION INNER JOIN ACTIVITES ON ACTIVITES.Nom_station=STATION.Nom_station WHERE STATION.Nom_station=@nom AND ACTIVITES.libell�= @activit�)
--		BEGIN
--		SELECT 'Nom de la station' = @nom, 'Nom activit�' = @activit�, 'Nombre de Clients' = (SELECT SUM(SEJOUR.nbplaces) FROM SEJOUR WHERE Nom_station=@nom);
--		END
--	ELSE
--		BEGIN
--		SELECT 'Cette activit� ' +@activit�+ ' dans cette station ' +@nom+ ' ou cette station existe pas';
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

--SET @capacite = (SELECT capacit� FROM STATION WHERE @nom=STATION.Nom_station);
--SET @nbClient = (SELECT SUM(SEJOUR.nbplaces) FROM SEJOUR INNER JOIN STATION ON STATION.Nom_station=SEJOUR.Nom_station WHERE @nom=STATION.Nom_station);
--	IF (@capacite > @nbClient)
--		BEGIN
--		SET @complet = 'Non'
--		END
--	ELSE
--		BEGIN
--		SET @complet = 'Oui'
--		END
--	SELECT 'Nom de la station' = @nom, 'Capacit�' = @capacite, 'Nombre de Clients' = @nbClient, 'Complets ?' = @complet;
--END
--GO