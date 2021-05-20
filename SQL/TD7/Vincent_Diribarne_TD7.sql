--Question 1
--Create or Alter view info_client AS 
--Select CLIENT.Nom_Client, Client.Prenom_Client, Client.Adresse_Client FROM Client;
--Go


--Question 2
--INSERT INTO info_client(Nom_Client, Prenom_Client, Adresse_Client) VALUES ('Tureaud', 'Laurence', 'Nice')
--Select * From CLIENT
--On peut voir que Tureaud Laurence a �t� ajout�e dans la table Client


--Question 3
--Premiere M�thode
--Alter view info_client AS 
--Select Nom_Client AS "Nom", Prenom_Client AS "Prenom", Adresse_Client as "Adresse" FROM CLIENT
--Go

--Deuxieme M�thode
--Alter view info_client("Nom", "Prenom", "Adresse") AS
--Select Nom_client, Prenom_client, Adresse_Client FROM CLIENT
--Go


--Question 4
--ALTER VIEW info_client AS
--Select client.Nom_Client AS "Nom", client.Prenom_Client AS "Prenom", client.Adresse_Client as "Adresse", COUNT(Billet.Id_billet) As "Nombre de billet achet�s" FROM CLIENT join BILLET ON client.Id_client=billet.id_client GROUP BY nom_client, prenom_client, adresse_client;
--go


--Question 5
--INSERT INTO info_client(Nom, Prenom, Adresse) VALUES ('Norris', 'Chuck', 'Lyon')
--Ce n'est pas possible d'inserer des informations dans une vue si elle poss�de une aggr�gation


--Question 6
--Create or alter view info_client_Lyon As
--Select Nom_client as "Nom", Prenom_client as "Prenom", Adresse_Client as "Adresse" FROM CLIENT WHERE Adresse_client = 'Lyon'
--go


--Question 7
--INSERT INTO info_client_lyon(Nom, Prenom, Adresse) VALUES ('Norris', 'Chuck', 'Lyon')
--Select * From CLIENT
--On peut voir que Chuck Norris a �t� ajout�e dans la table Client


--Question 8
--Create or alter view info_salle AS
--Select Nom_salle as "Nom", capacit�_salle as "Capacit�", type_salle as "Type", adresse_salle as "Adresse" from salle
--go


--Question 9
--Delete from info_salle WHERE Adresse = 'Angers' AND Nom = 'Centre des congr�s'
--Select * from salle
--Oui c'est possible de supprimer la salle Centre des Congr�s de Angers


--Question 10
--create or alter view info_salle_paris as
--Select Nom_salle as "Nom", capacit�_salle as "Capacit�", type_salle as "Type" FROM Salle WHERE Adresse_salle = 'Paris'
--go


--Question 11
--INSERT INTO info_salle_paris(Nom, Capacit�, Type) VALUES ('Arena', '8000', 'Concert')
--Select * from salle
--Oui c'est possible mais l'adresse =n'�tant pas renseign�  va mettre NULL


--Question 12
--Alter view info_salle as
--Select Nom_salle as "Nom", capacit�_salle/1000 as "Capacit� en millier de personnes", type_salle as "Type", adresse_salle as "Adresse" from salle
--go


--Question 13
--UPDATE info_salle SET [Capacit� en millier de personnes]=2 WHERE nom = 'Olympia' AND Adresse = 'Paris'
--Ce n'est pas possible d'update info_salle puisqu'elle contient des informations d�riv� (pour info_salle_paris)


--Question 14
--UPDATE info_salle SET Adresse='Nantes' WHERE nom = 'Olympia' AND Adresse = 'Paris'
--Select * FROM Salle
--Oui c'est possible car, la valeur ne fait plus partie de la table info_salle_paris puisqu'elle n'est plus � Paris


--Question 15
--UPDATE info_salle SET type='Ar�ne' WHERE type = 'Stade' AND [Capacit� en millier de personnes] > 20
--Select * from salle
--Oui c'est possible de changer toutes les salle de type stade en Ar�ne quand la capacit� est superieur � 20 000 personnes