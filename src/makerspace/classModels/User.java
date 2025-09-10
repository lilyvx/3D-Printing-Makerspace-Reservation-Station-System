package makerspace.classModels;
import java.time.LocalDateTime;

public abstract class User {
   
	protected String userId;
	public String getUserId() { return userId; }
	
	protected String username;
	public String getUsername() { return username; }
	
    protected String password;
    public void setPassword(String password) { this.password = password; }
    
    protected LocalDateTime registrationDate;
    public LocalDateTime getRegistrationDate() { return registrationDate; }
    
    // Abstract method to get user type
    public abstract String getUserType();
    // Constructor to initialize user attributes
    public User(String userId, String username, String password)
    {
    	this.userId = userId;
    	this.username = username;
    	this.password = password;
    	this.registrationDate = LocalDateTime.now();
    }
    
    public boolean authentication(String username, String password)
    {
    	return this.username.equals(username) && this.password.equals(password);
    }
    
}
