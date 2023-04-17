<%@page import="com.dao.Produit"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

   

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des produits</title>
<style type="text/css">

</style>
 <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/StyleVue.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Mrch6ZFYLLABL+NEUVF1A7sXsPIUуJop4YLESFAP+3c"></script>

<script>
	function deleteItem(id) {
		if (confirm("Êtes-vous sûr de vouloir supprimer cet élément?")) {
			// si l'utilisateur confirme, supprime l'élément
			window.location.href = "/delete-item?id=" + id;
		}
	}
</script>
</head>
<body>

<div class="text-end">
    Bienvenue ${sessionScope.username} | <a href="${pageContext.request.contextPath}/logout" class="btn btn-danger"">Déconnexion</a>
    <c:if test="${sessionScope.username == 'user'}">
 <a href="affPanier" type="button" class="btn btn-warning">Votre Pannier</a>
    </c:if>
 </div>
    

<div class="container">
<h1>Liste des produit</h1>
<hr>
 <c:if test="${sessionScope.username == 'admin'}">
 
<a href="addProduit" class="btn btn-primary">Ajouter un nouveau produit</a>
<hr>

</c:if>


  <form action="findProduit" method="post">
   <label>Mot Cle: </label> <input type="text" name="nom" >
    <button type="submit" class="btn btn-secondary" >Recherche par nom</button>
   </form>
 <hr> 
      <c:if test="${ok == 'ok'}">
            <div class="alert alert-success alert-dismissible">
                <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                Produit est ajouter au panier avec succes
            </div>
        </c:if>
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


 <c:if test="${sessionScope.username == 'admin'}">
<a href="modifProduit?id=${p.id} "  class="btn btn-success">MODIDFIER</a>
<a href="supprimeProduit?id=${p.id} " class="btn btn-warning" onclick="deleteItem(${item.id})">SUPPRIMER</a>
</c:if>

 <c:if test="${sessionScope.username == 'user'}">
 
  <form method="post" action="addPanier">
  <input type="number" name="action" value="1" />
  <input type="hidden" name="idPanier" value="${p.id}"/>

   <button type="submit" class="btn btn-info"">Ajouter au panier</button>

<span id="message"></span>
</form>
</c:if>

</td>
</tr>
</tbody>
</c:forEach>


</table>
</div>
</body>
</html>