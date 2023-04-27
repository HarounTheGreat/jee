package com.dao;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//GestionProduitImp Gs= new GestionProduitImp();
		//Gs.ajoutProduit(new Produit("sumsunc", 2000, 2));
		
		//System.out.println(Gs.getAllProduits());
		//Produit p = new Produit(3, "tablette HP", 1150, 2);
		
		//Gs.supprimeProduit(1);
		
		
		GestionProduitImp g = new GestionProduitImp();
		Produit p = new Produit("pc", 1200, 5);
		g.ajoutProduit(p);
		g.supprimeProduit(1);
		System.out.println(g.getAllProduits());
		
	/*	Produit p=g.rechercheParId(2);
		  p.SetNom("Imprimante hp");
		  p.setPrix(482);*/
		 
		
	
		

	}

}
