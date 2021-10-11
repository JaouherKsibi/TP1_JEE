<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>connexion</title>
</head>
<body>
	<h1>Gestion des Etudiants </h1>
	<hr>
	<h2>Entrer votre identité</h2>
	<form action="Verification" method="post">
		<label for="utilisateur">Utilisateur:</label><input type="text" name="utilisateur" id="utilisateur">
		<label for="mdp">Mot de passe:</label><input type="text" name="mdp" id="mdp">
		<input type="submit" value="se connecter">
	</form>
</body>
</html>