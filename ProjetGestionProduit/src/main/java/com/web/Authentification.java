package com.web;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.dao.GestionProduitImp;
import com.dao.GestionUtilisateurImp;
import com.dao.IGestionProduit;
import com.dao.IGestionUtilisateur;
import com.dao.Produit;
import com.dao.utilisateur;


@WebServlet(urlPatterns = {"/Login","/logout","/inscription"})
public class Authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IGestionUtilisateur gestionUtilisateur;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authentification() {
        super();
        // TODO Auto-generated constructor stub
    }
    
 // IGestionUtilisateur gestionUtilisateur;
    
    @Override
    public void init() throws ServletException{
    	gestionUtilisateur =new GestionUtilisateurImp();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*HttpSession session = request.getSession(false);
		if(session==null)
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		else {
			//
		}
		*/
		
		
		String path = request.getServletPath();
		 HttpSession session = request.getSession(false);

		if(path.equals("/Login"))
		{
			request.getRequestDispatcher("Login.jsp").forward(request, response);
	
		
		
		}else if(path.equals("/inscription")) {
			request.getRequestDispatcher("inscription.jsp").forward(request, response);
		}
		/*
		else if(path.equals("/logout")) {
			HttpSession session = request.getSession(false);
			if(session!=null)
			{
				session.invalidate();
				response.sendRedirect(request.getContextPath()+"/Login");

				
			}
			
		
		    if (session != null) {
		        session.invalidate();
		    }
		    
		    response.sendRedirect(request.getContextPath() + "/Login");
	}*/
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	
		String path = request.getServletPath();
		HttpSession session = request.getSession();
		
		
		if(path.equals("/Login")) {
			String username = request.getParameter("username");
		    String login = request.getParameter("login");
		    String password = request.getParameter("password");
		    
		    utilisateur u = new utilisateur(username, login, password);
			String res = gestionUtilisateur.verification(u);
			String role =gestionUtilisateur.fonctionRole(u);
		
			
			  if(res != null )  {
		            
		            session.setAttribute("username", res);
		            session.setAttribute("role", role);
		            session.setAttribute("id", session.getId());
		            response.sendRedirect(request.getContextPath() + "/listeProduit");
		        } else {
		            request.setAttribute("error", "Email ou mot de passe incorrect");
		            request.getRequestDispatcher("Login.jsp").forward(request, response);
		        }
			  
			
		} else if (path.equals("/logout")) {
	        session.invalidate();
	        response.sendRedirect(request.getContextPath() + "/Login");
	    }
	
	   
	  
	}
	
	
}


	
	
			  
			/*
			   if(res == "") {
			    	
			    	
		          response.sendRedirect(request.getContextPath()+"/listeProduit");
		          request.setAttribute("error", "Email ou mot de passe incorrect");
		        } else {
		            request.setAttribute("username",res);
		            request.getRequestDispatcher("vue.jsp").forward(request, response);
		        }
				
			 */

	
	
	
