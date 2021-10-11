<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion etudiant </title>
</head>
<body>
	<h1>Liste des Etudiants </h1>
	<%@page import="java.util.List" %>
    <%@page import="model.Etudiant" %>
    <%@page import="dao.Gestiondb" %>
    <%!List<Etudiant> l;%>
    <%!Etudiant cl;%>
    <%!String url;%>
    
    <%
    Gestiondb g=new Gestiondb();
   	l=g.getAllEtudiant();
    %>
	<table class='table1' border='1' style='font-size: 20px '>
		<tr>
		<th>Nom</th><th>Prenom</th><th>tel</th><th>Action</th></tr>
		
		<% for (Etudiant cl:l){%>
		<tr>
			<%--request.setAttribute("id",); --%>
			
			<td><%=cl.getNom() %><br/></td>
			<td><%=cl.getPrenom() %><br/></td>
			<td><%=cl.getNum_telephone() %><br/></td>
			<td><a href='Supprimer?id=<%=cl.getId() %>'>supprimer</a><br/></td>
			
			</tr>
		<% } %>
		
		
		
		
		
		
	</table>
	<hr>
	<h2>Ajouter un etudiant</h2>
	<form action="Ajouter" method="post">
		<label for="num">Numero:</label><input type="number" name="num" id="num">
		<label for="prenom">Prenom:</label><input type="text" name="prenom" id="prenom">
		<label for="nom">nom:</label><input type="text" name="nom" id="nom">
		<label for="telephone">nom:</label><input type="tel" name="telephone" id="telephone">
		<input type="submit" value="Enregistrer">
	</form>
</body>
</html>