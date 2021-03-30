---Exercice 1

--Question 1
--EXECUTE clientLPL;
--GO


--Question 2
--EXECUTE activiteLPL;
--GO

--Question 3 (version 1)
--EXECUTE clientPremium 7000.0;
--GO


--Question 3 (version 2)
--EXECUTE clientPremium2 7000.0;
--GO


--Question 4
--EXECUTE clientStatut 3, 7000;
--GO

--Question 5
--EXECUTE stationActiviteLigne 2;
--GO

--EXECUTE stationActiviteLigne 4;
--GO

--EXECUTE stationActiviteLigne 10;
--GO

--Question 6
--EXECUTE deleteStationActivite 2;
--GO
--SELECT * FROM STATION;

--Question 7
--EXECUTE avgActivites;
--GO
--SELECT * FROM STATIONAVG;

--Question 8
EXECUTE ajusteActivitesStation 100, 120;
GO
SELECT * FROM ACTIVITES
SELECT * FROM STATION

EXECUTE ajusteActivitesStation 120, 100
GO