
package com.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestionUtilisateurImp  implements IGestionUtilisateur{

	Connection connection = ConnexionBD.getConnection();

  //  private Connection connection; // Injected from the Servlet

    public GestionUtilisateurImp(Connection connection) {
    	super();
        this.connection = connection;
    }
    
    
	public GestionUtilisateurImp() {
		// TODO Auto-generated constructor stub
	}




	@Override
	public String verification(utilisateur u) {
		 String username = null;
	        try {
	            PreparedStatement statement = connection.prepareStatement("SELECT role FROM user WHERE login = ? AND password = ?");
	            statement.setString(1, u.getLogin());
	            statement.setString(2, u.getPassword());
	            ResultSet result = statement.executeQuery();
	            if (result.next()) {
	                username = result.getString("role");
	            }
	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return username;
	}

	@Override
	public void registration(utilisateur u) {
			
		try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO user (username, login, password) VALUES (?, ?, ?)");
            statement.setString(1, u.getUsername());
            statement.setString(2, u.getLogin());
            statement.setString(3, u.getPassword());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		
	}


	@Override
	public String fonctionRole(utilisateur u) {
		String role = null ;
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT role FROM user WHERE login = ? AND password = ?");
			statement.setString(1, u.getLogin());
			statement.setString(2, u.getPassword());
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				role = result.getString("role");
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return role;
	}
	






}
