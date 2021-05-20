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
