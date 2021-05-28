--Question 1
--Create or Alter view info_client AS 
--Select CLIENT.Nom_Client, Client.Prenom_Client, Client.Adresse_Client FROM Client;
--Go


--Question 2
--INSERT INTO info_client(Nom_Client, Prenom_Client, Adresse_Client) VALUES ('Tureaud', 'Laurence', 'Nice')
--Select * From CLIENT
--On peut voir que Tureaud Laurence a été ajoutée dans la table Client


--Question 3
--Premiere Méthode
--Alter view info_client AS 
--Select Nom_Client AS "Nom", Prenom_Client AS "Prenom", Adresse_Client as "Adresse" FROM CLIENT
--Go

--Deuxieme Méthode
--Alter view info_client("Nom", "Prenom", "Adresse") AS
--Select Nom_client, Prenom_client, Adresse_Client FROM CLIENT
--Go


--Question 4
--ALTER VIEW info_client AS
--Select client.Nom_Client AS "Nom", client.Prenom_Client AS "Prenom", client.Adresse_Client as "Adresse", COUNT(Billet.Id_billet) As "Nombre de billet achetés" FROM CLIENT join BILLET ON client.Id_client=billet.id_client GROUP BY nom_client, prenom_client, adresse_client;
--go


--Question 5
--INSERT INTO info_client(Nom, Prenom, Adresse) VALUES ('Norris', 'Chuck', 'Lyon')
--Ce n'est pas possible d'inserer des informations dans une vue si elle possède une aggrégation


--Question 6
--Create or alter view info_client_Lyon As
--Select Nom_client as "Nom", Prenom_client as "Prenom", Adresse_Client as "Adresse" FROM CLIENT WHERE Adresse_client = 'Lyon'
--go


--Question 7
--INSERT INTO info_client_lyon(Nom, Prenom, Adresse) VALUES ('Norris', 'Chuck', 'Lyon')
--Select * From CLIENT
--On peut voir que Chuck Norris a été ajoutée dans la table Client


--Question 8
--Create or alter view info_salle AS
--Select Nom_salle as "Nom", capacité_salle as "Capacité", type_salle as "Type", adresse_salle as "Adresse" from salle
--go


--Question 9
--Delete from info_salle WHERE Adresse = 'Angers' AND Nom = 'Centre des congrès'
--Select * from salle
--Oui c'est possible de supprimer la salle Centre des Congrès de Angers


--Question 10
--create or alter view info_salle_paris as
--Select Nom_salle as "Nom", capacité_salle as "Capacité", type_salle as "Type" FROM Salle WHERE Adresse_salle = 'Paris'
--go


--Question 11
--INSERT INTO info_salle_paris(Nom, Capacité, Type) VALUES ('Arena', '8000', 'Concert')
--Select * from salle
--Oui c'est possible mais l'adresse =n'étant pas renseigné  va mettre NULL


--Question 12
--Alter view info_salle as
--Select Nom_salle as "Nom", capacité_salle/1000 as "Capacité en millier de personnes", type_salle as "Type", adresse_salle as "Adresse" from salle
--go


--Question 13
--UPDATE info_salle SET [Capacité en millier de personnes]=2 WHERE nom = 'Olympia' AND Adresse = 'Paris'
--Ce n'est pas possible d'update info_salle puisqu'elle contient des informations dérivé (pour info_salle_paris)


--Question 14
--UPDATE info_salle SET Adresse='Nantes' WHERE nom = 'Olympia' AND Adresse = 'Paris'
--Select * FROM Salle
--Oui c'est possible car, la valeur ne fait plus partie de la table info_salle_paris puisqu'elle n'est plus à Paris


--Question 15
--UPDATE info_salle SET type='Arène' WHERE type = 'Stade' AND [Capacité en millier de personnes] > 20
--Select * from salle
--Oui c'est possible de changer toutes les salle de type stade en Arène quand la capacité est superieur à 20 000 personnes



--Partie 2 :

--Question 16
--Drop view info_client, info_client_lyon, info_salle, info_salle_paris


--Question 17
--create or alter view client_spectacle as
--select client.Nom_Client, CLIENT.Prenom_Client, SPECTACLE.Nom_Spectacle, calendrier.Date_Spectacle, spectacle.Type_Spectacle FROM client inner join billet on billet.id_client=client.Id_Client inner join calendrier on calendrier.id_date=billet.id_date inner join spectacle on spectacle.id_spectacle=calendrier.Id_Spectacle
--go


--Question 18
--create or alter view spectacle_info as
--select spectacle.Nom_Spectacle, calendrier.Date_Spectacle, spectacle.Duree_Spectacle, salle.Nom_Salle, COUNT(billet.id_billet) as "Nb_billets_vendus" FROM spectacle inner join calendrier on spectacle.id_spectacle=calendrier.id_spectacle inner join salle on salle.id_salle=calendrier.id_salle inner join billet on billet.id_date=calendrier.id_date group by nom_spectacle, date_spectacle, duree_spectacle, nom_salle
--go


--Question 19
--INSERT INTO client_spectacle(Nom_Client, Prenom_Client) VALUES ('Smith', 'Paul')
--Select * from client
--Oui c'est possible


--Question 20
--UPDATE client_spectacle SET Type_Spectacle='Show' WHERE Nom_Spectacle = 'AC/DC'
--Select * from spectacle
--Oui c'est possible


--Question 21
--UPDATE client_spectacle SET Type_Spectacle='Concert', Date_Spectacle = '2017-10-11' WHERE Nom_Spectacle = 'AC/DC' AND Date_Spectacle = '2002-06-12'
--Select * from spectacle
--Select * from calendrier
--Ce n'est pas possible car la modification aura lieu sur plusieurs tables


--Question 22
--UPDATE spectacle_info SET Duree_Spectacle='3:10:00' WHERE Nom_Spectacle = 'Genesis' AND Nom_Salle = 'Stade de France'
--Select * from spectacle
--Select * from spectacle_info
--Ce n'est pas possible car il y a des agrégat sur la vue spectacle_info


--Question 23
--alter view spectacle_info as
--select spectacle.Nom_Spectacle, calendrier.Date_Spectacle, spectacle.Duree_Spectacle, salle.Nom_Salle FROM spectacle inner join calendrier on spectacle.id_spectacle=calendrier.id_spectacle inner join salle on salle.id_salle=calendrier.id_salle
--go


--Question 24
--UPDATE spectacle_info SET Duree_Spectacle='3:10:00' WHERE Nom_Spectacle = 'Genesis' AND Nom_Salle = 'Stade de France'
--Select * from spectacle
--Select * from spectacle_info
--Cette commande fonctionne car l'agregation avec le count a été enlevé


--Question 25
--INSERT INTO client_spectacle(Nom_Client, Prenom_Client, Type_Spectacle, Nom_Spectacle, Date_Spectacle) VALUES ('Star', 'George', 'Concert', 'Garbage', '2016-08-09')
--Non ce n'est pas possible car la modification porte sur plusieurs tables (client et spectacle)


--Question 26
--Delete from client_spectacle WHERE Nom_Spectacle = 'AC/DC'
--Non ce n'est pas possible car la modification porte sur plusieurs tables (client et spectacle)


--Question 27
--Ce n'est pas possible d'inserer, supprimer, modifier des données si la vue comporte un group by.



--Partie 3 :

--Question 28
--Create OR alter view info_salle_N as
--Select Nom_Salle, Capacité_Salle, Adresse_Salle, Type_Salle FROM SALLE WHERE Adresse_Salle LIKE 'N%';
--GO


--Question 29
--UPDATE info_salle_N SET Capacité_Salle='10000' WHERE Nom_Salle = 'Zenith' AND Adresse_Salle = 'Nantes'
--Select * from Salle
--La capacité a été modifié puisque la vue marche sur les adresse commençant par N et l'adresse fourni est Nantes.


--Question 30
--UPDATE info_salle_N SET Capacité_Salle='9500' WHERE Nom_Salle = 'Zenith' AND Adresse_Salle = 'Lille'
--Select * from Salle
--La capacité n'est pas modifié car l'adresse fourni ne commence pas par N


--Question 31
--Create or alter view info_billet_sup70 as
--Select Id_billet, Tarif_billet FROM BILLET Where tarif_billet > 70
--GO


--Question 32
--UPDATE info_billet_sup70 SET Tarif_billet='50' WHERE Id_Billet = '17'
--Select * from billet
--Le tarif est changé car avant le changement le tarif était superieur à 70


--Question 33
--Alter view info_billet_sup70 as
--Select Id_billet, Tarif_billet FROM BILLET Where tarif_billet > 70 with Check Option
--Go


--Question 34
--Create OR alter view info_spectacle_concert as
--Select Nom_Spectacle, Duree_Spectacle, Type_Spectacle From Spectacle Where Type_Spectacle = 'Concert'
--GO


--Question 35
--INSERT INTO info_spectacle_concert(Nom_Spectacle, Duree_Spectacle, Type_Spectacle) VALUES ('Hamlet', '01:20:00', 'Théatre')
--Select * from info_spectacle_concert
--Select * from SPECTACLE
--Le spectacle a été ajouté dans la table SPECTACLE mais on ne le voit pas depuis la vue vu que ce n'est pas un théatre