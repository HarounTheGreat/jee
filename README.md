# jee

## ConnectionBD:

```java
package com.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnexionBD {

	private static Connection connection;

	private ConnexionBD()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost/gestioncommv2","root","");
			System.out.println("connexion établie...");
		} catch (ClassNotFoundException e) {
			System.out.println("Problème chargement pilote...");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Problème établissement connexion...");
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

```

---

## Produit

```java

package com.dao;

public class Produit {

	private int id;
	private String nom;
	private double prix;
	private int quantite;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Produit(int id, String nom, double prix, int quantite) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.quantite = quantite;
	}
	public Produit(String nom, double prix, int quantite) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.quantite = quantite;
	}
	public Produit() {
		super();
	}




}

```

---

## IGestionProduit

```java

package com.dao;

import java.util.List;

public interface IGestionProduit {

public void ajoutProduit(Produit p);

public void supprimeProduit(int id);

public Produit rechercheParId(int id);

public List<Produit> getAllProduits();

public List<Produit> getProduitParNom(String nom);

public void modifProduit(Produit p);

}

```

## GestionProduitImp

```java

package com.dao;

import java.sql.Connection;
import java.util.List;
public class Gestion Produit Imp implements IGestionProduit{
Connection connection ConnexionBD.getConnection();
}
@Override
public void ajoutProduit (Produit p) {
}
@Override
public void supprimeProduit (int id) {
}
@Override
public Produit rechercheParId(int id) {
}
@Override
public List<Produit> getAllProduits() {
return null;
}
return null;
@Override
public List<Produit> getProduitParNom (String nom) {
return null;
}
@Override
public void modifProduit (Produit p) {
}

```

Class Name
IGestionProduit
FirstServlet

```java

package com.web;

import jakarta.servlet.Servlet;

public class FirstServlet extends HttpServlet {
private static final long serial VersionUID = 1L;
public FirstServlet() {
	super();
}
}

protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
// TODO Auto-generated method stub
response.getWriter().append("Served at: ").append(request.getContextPath());
}

protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
// TODO Auto-generated method stub
doGet (request, response);
}

```
