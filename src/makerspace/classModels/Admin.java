package makerspace.classModels;

public class Admin extends User {
	
	public Admin(String userId, String username, String password)
	{
		super(userId, username, password);
	}
	
	@Override
	public String getUserType() { return "Admin";}
}
