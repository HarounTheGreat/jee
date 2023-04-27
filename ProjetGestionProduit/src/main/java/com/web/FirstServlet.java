package com.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.dao.GestionProduitImp;
import com.dao.IGestionProduit;
import com.dao.Produit;

@WebServlet(urlPatterns={ "/listeProduit","/addProduit","/modifProduit","/supprimeProduit","/findProduit","/affPanier","/addPanier"})
/**
 * Servlet implementation class FirstServlet
 */
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ArrayList<Produit> listeProduitPanier;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
       listeProduitPanier = new ArrayList<Produit>();
    }
    IGestionProduit gestion;
    
    @Override
    public void init() throws ServletException{
    	gestion =new GestionProduitImp();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException
	{
	//List<Produit> liste = gestion.getAllProduits();
//	PrintWriter out=response.getWriter();
//
//	out.print("<html>");
//
//	out.print("<body>"); out.print("<table border=1>");
//
//	for (Produit p:liste) {
//
//	out.print("<tr><td>"+p.getId()+"</td><td>"+p.getNom()+"</td><td>"+p.getPrix()+"</td><td>"+p.getQuantite()+"</td></tr>");
//
//	} out.print("</table>");
//
//	out.print("</body>");
//
//	out.print("</html>");
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		
	
		
		String path = request.getServletPath();
		if(path.equals("/listeProduit")) {
			List<Produit> liste = gestion.getAllProduits();
			request.setAttribute("listeP", liste);
			request.getRequestDispatcher("vue.jsp").forward(request, response);
	
			
		}else if (path.equals("/addProduit")) {
			request.getRequestDispatcher("ajout.jsp").forward(request, response);
		}
		else if(path.equals("/supprimeProduit")) {
			int id  = Integer.parseInt(request.getParameter("id"));
			gestion.supprimeProduit(id);
		   request.setAttribute("message", "Le produit a été supprimé avec succès !");
			response.sendRedirect(request.getContextPath()+"/listeProduit");
		}
		else if(path.equals("/modifProduit")) {
			int id  = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("produit", gestion.rechercheParId(id));
			request.getRequestDispatcher("modif.jsp").forward(request, response);;
		}
		else if(path.equals("/findProduit")) {
		    String nom = request.getParameter("nom");
		   // List<Produit> liste = gestion.getProduitParNom(nom);
		    request.setAttribute("listeP",gestion.getProduitParNom(nom));
		    request.getRequestDispatcher("vue.jsp").forward(request, response);
		}
		else if(path.equals("/affPanier")){
			request.setAttribute("message", "Produit ajouté au panier avec succès !");
			request.setAttribute("liste",listeProduitPanier);
		request.getRequestDispatcher("affPanier.jsp").forward(request, response);
		}
		
	
	
	
	

	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		
		String path = request.getServletPath();
		
		if(path.equals("/addProduit")) {
			
			String nom = request.getParameter("nom");
			Double prix= Double.parseDouble(request.getParameter("prix"));
			int quantite= Integer.parseInt(request.getParameter("quantite"));
			gestion.ajoutProduit(new Produit(nom, prix, quantite));
			response.sendRedirect(request.getContextPath()+"/listeProduit");
			
			
		}
		else if( path.equals("/modifProduit")){
			int id = Integer.parseInt(request.getParameter("id"));
			String nom = request.getParameter("nom");
			double prix = Double.parseDouble(request.getParameter("prix"));
			int quantite = Integer.parseInt(request.getParameter("quantite"));
			gestion.modifProduit(new Produit(id,nom, prix, quantite));
			response.sendRedirect(request.getContextPath()+"/listeProduit");
			
			
		}else if(path.equals("/findProduit")) {
		    String nom = request.getParameter("nom");
		    List<Produit> liste = gestion.getProduitParNom(nom);
		    request.setAttribute("listeP",gestion.getProduitParNom(nom));
		    request.getRequestDispatcher("vue.jsp").forward(request, response);
		}
		
		
		else if(path.equals("/addPanier")){
			int action=Integer.parseInt(request.getParameter("action"));
			int idPanier=Integer.parseInt(request.getParameter("idPanier"));
			Produit p=gestion.rechercheParId(idPanier);
			p.setQuantite(action);
			
			listeProduitPanier.add(p);
			request.setAttribute("ok", "ok");
			List<Produit> liste=gestion.getAllProduits();
			request.setAttribute("listep", liste);
			request.getRequestDispatcher("vue.jsp").forward(request,response);
		}
	
	}
	
}
