<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page de connexion</title>
<link rel="stylesheet" href="css/StyleLogin.css">
 <link rel="stylesheet" href="css/bootstrap.min.css">
 <style type="text/css">


</style>
</head>
<body>
 


<form action="Login" method="post">
  <h2>Login</h2>

  <div class="container">
 
    <label for="name"><b>Login</b></label>
    <input type="text" placeholder="Login" name="login"  id="login" required><br><br>

    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Password" name="password" id="password"  required><br><br>



	
    
     <button type="submit">Login</button>
    <label>
      <input type="checkbox" checked="checked" name="remember"> Remember me
    </label>
  </div>

</form>

</body>


</html>
   

