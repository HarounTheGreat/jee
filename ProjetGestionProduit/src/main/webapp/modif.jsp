<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="container">
<h1>Modifier un produit</h1>


<form method="Post" action="modifProduit">

<input type="hidden" name="id" value="${produit.id}">

<div class="mb-3 mt-3">

<label for="nom" class="form-label">Nom :</label>

<input type="text" class="form-control" id="nom" value="${produit.nom}" name="nom" required>

</div>

<div class="mb-3 mt-3">

<label class="form-label">Prix:</label>

<input type="number" name="prix" id="prix" class="form-control" value="${produit.prix}" required  >

</div>

<div class="mb-3 mt-3">

<label class="form-label">Quantit�:</label>

<input type="number" name="quantite"  id="quantite" class="form-control" value="${produit.quantite}" required>

</div>

<div class="mb-3 mt-3">

<input type="submit" class="btn btn-primary" value="Modifier">

</div>

</form>
</div>

</body>
</html>