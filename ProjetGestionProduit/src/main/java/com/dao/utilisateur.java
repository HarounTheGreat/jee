package com.dao;

public class utilisateur {
	private int id;
	 private String username;
	    private String login;
	    private String password;
	    private String role;
	    
	    public utilisateur(int id,String username, String login, String password,String role) {
	    	super();
	    	this.id=id;
	        this.username = username;
	        this.login = login;
	        this.password = password;
	        this.role = role;
	    }

	    public utilisateur(String username,String login, String password) {
	    	super();
	    	
	        this.username = username;
	        this.login = login;
	        this.password = password;
	    }

	   
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getLogin() {
	        return login;
	    }

	    public void setLogin(String login) {
	        this.login = login;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }
	    public String getRole() {
	        return role;
	    }

	    public void setRole(String role) {
	        this.role = role;
	    }
	    
		 public utilisateur() {
			 super();	
			 }
			
		

		@Override
		public String toString() {
			return "utilisateur [id=" + id + ", username=" + username + ", login=" + login + ", password=" + password
					+ "]";
		}

	
	    

}
