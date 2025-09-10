package makerspace.classModels;
import java.util.ArrayList;
import java.util.List;

public class Admin extends User {
	
	private String adminTier;
	public String getAdminTier() { return adminTier; }
	
	private List<String> permissions;
	public List<String> getPermissions() { return permissions; }
	
	public Admin(String userId, String username, String password, String adminTier)
	{
		super(userId, username, password);
		this.adminTier = adminTier;
		this.permissions = getDefaultPermissions(adminTier);
	}
	
	@Override
	public String getUserType() { return "Admin";}
	
	private List<String> getDefaultPermissions(String level) {
		List<String> perm = new ArrayList<>();
		switch (level) {
		case "prime":
			perm.addAll(List.of("User Management", "Equipment Management", "System Config", "Reports", "Billing"));
			break;
		case "manager":
			perm.addAll(List.of("Equipment Management", "Reports", "Billing"));
			break;
		case "assistant":
			perm.addAll(List.of("User Management", "Basic Reports"));
			break;
		default:
			perm.add("No permissions assigned");
			break;
		}
		
		return perm;
	}
}
