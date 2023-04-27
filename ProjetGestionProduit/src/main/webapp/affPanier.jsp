<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>votre paniet</title>
 <link rel="stylesheet" href="css/StylePanier.css">
 <link rel="stylesheet" href="css/bootstrap.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Mrch6ZFYLLABL+NEUVF1A7sXsPIUуJop4YLESFAP+3c"></script>

</head>


<body>
    <h1>Votre panier</h1>
   <table>
        <tr>
            <th>Nom du produit</th>
            <th>Quantité commandée</th>
        </tr>
        <c:forEach var="p" items="${listeP}">
            <tr>
                <td>${produit.nom}</td>
                <td>${produit.quantite}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="/ProjetGestionProduit/listeProduit">
        <button type="button" class="btn btn-primary">Retour</button>
    </a>
    
</body>


</html>