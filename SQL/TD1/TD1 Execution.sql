--EXECUTE displayArg 'Hello World', 1.5, '2017-01-03';
--GO

--EXECUTE mult2 7;
--GO

--EXECUTE mult2 12;
--GO

--EXECUTE mult23 12
--GO

--EXECUTE calcPrixTTC 70;
--GO

--EXECUTE reducTTC 300;
--GO

--EXECUTE reducTTC 100;
--GO

--EXECUTE mult235 7
--GO

--EXECUTE mult235 6
--GO

--EXECUTE mult235 10
--GO

--EXECUTE mult235 30
--GO

--EXECUTE calcPrixCarte 100, 'jeune';
--GO

--EXECUTE calcPrixCarte 100, '12-25';
--GO

--EXECUTE calcPrixCarte 75, 'senior+';
--GO

--EXECUTE affPourReduc 100, 10;
--GO

--EXECUTE affPourReduc 100, 42;
--GO

--EXECUTE affPourReduc 320, 280;
--GO

--EXECUTE affPourReduc -32, 40;
--GO

--EXECUTE estPremier 15;
--GO

--EXECUTE estPremier 7;
--GO

--EXECUTE mult235Premier 15;
--GO

--EXECUTE mult235Premier 17;
--GO


--EXERCICE 2


--QUESTION 1
--EXECUTE clientStationActivités;
--GO


--QUESTION 2
--EXECUTE clientActivités 'Pessac', 'Piscine';
--GO


--QUESTION 3
--EXECUTE clientNbActivités 2;
--GO

--QUESTION 4
--EXECUTE etatCapacitéStation 1000; 
--GO

--QUESTION 5 
--EXECUTE reductionStation 'Antilles', 25;
--GO

--QUESTION 6
--EXECUTE delLowCostStation 1500;
--GO

--QUESTION 7
--EXECUTE checkNoActiviteStation 'Venusa'
--GO

--EXECUTE checkNoActiviteStation 'Adriana'
--GO

--QUESTION 8
--EXECUTE insertStation 'Majorque', 250, 'Baléare', 'Méditerranée', 1000;
--GO

--EXECUTE insertStation 'Adriana', 25, 'Adriatique', 'Antilles', 900;
--GO


--QUESTION 9
--EXECUTE checkActiviteStation 'Pessac', 'Ski';
--GO

--EXECUTE checkActiviteStation 'Pessac', 'Foot';
--GO

--EXECUTE checkActiviteStation 'Pessoc', 'Ski';
--GO

--QUESTION 10
--EXECUTE checkCapaciteStation 'Venusa';
--GO
