package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnexionBD {



 private static Connection connection;



 private ConnexionBD()
 {


try {

Class.forName("com.mysql.jdbc.Driver");

connection=DriverManager.getConnection("jdbc:mysql://localhost/gestioncomm","root","");
System.out.println("connexion etablie");

} catch (ClassNotFoundException e) 
{ System.out.println("Problème chargement pilote...");

e.printStackTrace();

} catch (SQLException e) 
{ System.out.println("Problème établissement connexion...");
e.printStackTrace();
}
 }
public static Connection getConnection()
{
if(connection==null) 
	new ConnexionBD(); 
return connection;
}
}
