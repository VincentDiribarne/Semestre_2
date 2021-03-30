--Question 1
--IF EXISTS (SELECT * FROM sysobjects WHERE name='warningClientInsertion')
--	DROP TRIGGER warningClientInsertion;
--GO

--CREATE TRIGGER warningClientInsertion
--ON CLIENT
--AFTER INSERT
--AS
--SET  NOCOUNT ON
--BEGIN
--	SELECT 'Un 
--END
--GO


--Question 2
--IF EXISTS (SELECT * FROM sysobjects WHERE name='infoClientInsertion')
--	DROP TRIGGER infoClientInsertion;
--GO

--CREATE TRIGGER infoClientInsertion
--ON CLIENT
--AFTER INSERT
--AS
--SET NOCOUNT ON
--BEGIN
--	SELECT * FROM inserted;
--	SELECT * FROM deleted;
--END
--GO


--Question 3
--IF EXISTS (SELECT * FROM sysobjects WHERE name='countClientInsertion')
--	DROP TRIGGER countClientInsertion;
--GO

--CREATE TRIGGER countClientInsertion
--ON CLIENT
--AFTER INSERT
--AS
--SET NOCOUNT ON
--BEGIN
--	SELECT CONCAT(COUNT(Cl_Nom), ', nouveau(x) client(s) inséré(s) dans la table CLIENT') FROM INSERTED
--END
--GO


--Question 4
--IF EXISTS (SELECT * FROM sysobjects WHERE name='infoClientUpdate')
--	DROP TRIGGER infoClientUpdate;
--GO
--CREATE TRIGGER infoClientUpdate
--ON CLIENT
--AFTER UPDATE
--AS
--SET NOCOUNT ON
--BEGIN
--	SELECT * FROM inserted;
--	SELECT * FROM deleted;
--END
--GO


--Question 5
--IF EXISTS (SELECT * FROM sysobjects WHERE name='nullClientDelete')
--	DROP TRIGGER nullClientDelete;
--GO

--CREATE TRIGGER nullClientDelete
--ON CLIENT
--INSTEAD OF DELETE
--AS
--SET NOCOUNT ON
--BEGIN
--	SELECT 'Commande Delete Inactive';
--END
--GO


--Question 6
--IF EXISTS (SELECT * FROM sysobjects WHERE name='tooMuchClientInsertion')
--	DROP TRIGGER tooMuchClientInsertion;
--GO

--CREATE TRIGGER tooMuchClientInsertion
--ON CLIENT
--AFTER INSERT
--AS
--SET NOCOUNT ON
--BEGIN
--	DECLARE @nombreIns INT;
--    SET @nombreIns = (SELECT COUNT(*) FROM INSERTED);
--    IF (@nombreIns >= 10)
--	BEGIN
--		ROLLBACK TRANSACTION;
--		SELECT 'La commande a été interrompue';
--	END
--END 
--GO


--Question 7 
--IF EXISTS (SELECT * FROM sysobjects WHERE name='nullClientUpdate')
--	DROP TRIGGER nullClientUpdate;
--GO

--CREATE TRIGGER nullClientUpdate
--ON CLIENT
--AFTER UPDATE
--AS
--SET NOCOUNT ON
--BEGIN
--	DECLARE @client VARCHAR(100);
--	SELECT @client=Cl_nom FROM INSERTED;
--	SELECT 'La commande update est inactive : veuillez supprimer le client ' + @client + ' puis inserez un nouveau client avec les bonnes données';	
--	ROLLBACK TRANSACTION;
--END 
--GO


--Question 8

IF EXISTS(SELECT * FROM sysobjects WHERE name='comNullClientUpdate ')
	DROP TRIGGER comNullClientUpdate;	
GO

CREATE TRIGGER comNullClientUpdate
ON CLIENT
INSTEAD OF UPDATE
AS 
SET NOCOUNT ON 
BEGIN
	DECLARE @suppr VARCHAR(1000) = 'DELETE FROM CLIENT WHERE Cl_Nom=''';
	DECLARE @creer VARCHAR(1000) = 'INSERT INTO CLIENT VALUES (''';
	SET @suppr = @suppr + (SELECT Cl_Nom FROM INSERTED)+ '''';
	SET @creer = 
		@creer
		+ (SELECT Cl_Nom FROM INSERTED) 
		+ ''', ''' 
		+ (SELECT Cl_Adresse FROM INSERTED)
		+ ''', ' 
		+ CAST( (SELECT Cl_Ref_Piece FROM INSERTED) as VARCHAR(5) ) 
		+ ', ''' 
		+ (SELECT Cl_Nom_Piece FROM INSERTED)
		+ ''', '
		+ CAST( (SELECT Cl_En_Cours FROM INSERTED) as VARCHAR(10) )
		+ ', '''
		+ CAST( (SELECT Cl_Echeance FROM INSERTED) as VARCHAR(20) )
		+ ''');'
	SELECT 'La commande update est inactive : veuillez exécuter les deux commandes suivantes :'
	SELECT @suppr;
	SELECT @creer;
END 