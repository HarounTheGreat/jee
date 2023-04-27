r<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter un produit</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1A3CqpJLINov@YzIzteQTuf">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Mrch6ZFYLLABL+NEUVF1A7sXsPIUуJop4YLESFAP+3c"></script>
</head>
<body >
    <div class="container">
        <h1>Ajouter un produit</h1>
        <form method="post" action="addProduit">
            <div class="mb-3">
                <label for="nom" class="form-label">Nom du produit</label>
                <input type="text" class="form-control" id="nom" name="nom" required>
            </div>
            <div class="mb-3">
                <label for="prix" class="form-label">Prix du produit</label>
                <input type="number" class="form-control" id="prix" name="prix" min="0" step="0.01" required>
            </div>
            <div class="mb-3">
                <label for="quantite" class="form-label">Quantité du produit</label>
                <input type="number" class="form-control" id="quantite" name="quantite" min="0" required>
            </div>
            <button type="submit" class="btn btn-primary">Ajouter</button>
        </form>
    </div>
</body>
</html>