<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Inscription</title>
</head>
<body>
	<h1>Inscription</h1>
	<form action="inscription" method="post">
	<label for="username">username:</label><br>
		<input type="text" id="username" name="username"><br>
		<label for="login">Login:</label><br>
		<input type="text" id="login" name="login"><br>
		<label for="password">Mot de passe:</label><br>
		<input type="password" id="password" name="password"><br><br>
		<input type="submit" value="REGISTER">
	</form>
</body>
</html>