package makerspace.classModels;
import java.time.LocalDateTime;

public abstract class User {
   
	protected String userId;
	public String getUserId() { return userId; }
	
	protected String username;
	public String getUsername() { return username; }
	
    protected String password;
    public String getPassword() { return password; }
    
    protected LocalDateTime registrationDate;
    
    public abstract String getUserType();
    
    public User(String userId, String username, String password)
    {
    	this.userId = userId;
    	this.username = username;
    	this.password = password;
    	this.registrationDate = LocalDateTime.now();
    }
    
}
