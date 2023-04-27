<%@page import="com.dao.Produit"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des produits</title>
 <link rel="stylesheet" href="css/bootstrap.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Mrch6ZFYLLABL+NEUVF1A7sXsPIUуJop4YLESFAP+3c"></script>
</head>
<body>



<div class="text-end">
    Bienvenue ${sessionScope.username} | <a href="${pageContext.request.contextPath}/logout" class="btn btn-danger"">Déconnexion</a>
    <button type="button" class="btn btn-warning">Votre panier</button>
</div>


<div class="container">


<h1>Liste des produit</h1>
 
<form action="findProduit" method="get">
   <label>Mot Cle: </label> <input type="text" name="nom" >
    <button type="submit" class="btn btn-secondary" >Recherche par nom</button>
</form>
<table class="table">
  <thead class="thead-dark">
<tr>
<th scope="col">#</th>
<th scope="col">Nom</th>
<th scope="col">Prix</th>
<th scope="col">Quantite</th>
<th scope="col">Action</th>
</tr>
</thead>

 <c:forEach var="p" items="${listeP}">

  <tbody>
 
<tr>

<td>${p.id} </td>
<td>${p.nom} </td>
<td>${p.prix} </td>
<td>${p.quantite} </td>
<td>
<input type="number" name="number"/>
<a href=""  class="btn btn-success">Ajouter au panier</a>

</td>
</tr>
</tbody>
</c:forEach>

</table>

</div>
</body>
</html>












