package model;

public class UserProfile extends Observable {
	private boolean loggedIn = false;
	private String username;
	
	public void setUser(String user) {
		username = user;
		loggedIn = true;
	}
	
	public String getUser() {
		if( loggedIn )
			return username;
		
		return null;
	}
}
