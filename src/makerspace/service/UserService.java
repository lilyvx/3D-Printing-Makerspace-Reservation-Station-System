package makerspace.service;
import makerspace.classModels.*;
import makerspace.exceptions.*;
import java.util.*;

public class UserService {
    private Map<String, User> users;
    private DbService dbService;
    
    public UserService() {
        this.users = new HashMap<>();
        this.dbService = new DbService();
        loadUsersFromDatabase();
    }
    
    public String registerClient(String username, String email, String password) throws InvalidReservationException 
    {
        validateUserInput(username, email, password);
        
        String userId = generateUserId();
        Client client = new Client(userId, username, email, password);
        
        users.put(userId, client);
        dbService.saveUser(client);
        
        return userId;
    }
    
    public String registerAdmin(String username, String email, String password, String adminTier) throws InvalidReservationException 
    {
        validateUserInput(username, email, password);
        
        String userId = generateUserId();
        Admin admin = new Admin(userId, username, email, password, adminTier);
        
        users.put(userId, admin);
        dbService.saveUser(admin);
        
        return userId;
    }
    
    public User authenticate(String username, String password) throws UserException
    {
        User user = findUserByUsername(username);
        if (user == null) {
            throw new UserException("User not found: " + username);
        }
        
        if (!user.authentication(password)) {
            throw new UserException("Invalid password");
        }
        
        return user;
    }
    
    public User getUserById(String userId) throws UserException 
    {
        User user = users.get(userId);
        if (user == null) {
            throw new UserException("User not found with ID: " + userId);
        }
        return user;
    }
    
    public List<User> getAllUsers()
    {
        return new ArrayList<>(users.values());
    }
    
    public List<Client> getAllClients() 
    {
        return users.values().stream()
                   .filter(user -> user instanceof Client)
                   .map(user -> (Client) user)
                   .collect(java.util.stream.Collectors.toList());
    }
    
    private User findUserByUsername(String username) 
    {
        return users.values().stream()
                   .filter(user -> user.getUsername().equals(username))
                   .findFirst()
                   .orElse(null);
    }
    
    private void validateUserInput(String username, String email, String password) 
            throws InvalidReservationException {
        if (username == null || username.trim().isEmpty()) {
            throw new InvalidReservationException("Username Can't Be Empty");
        }
        if (email == null || !email.contains("@")) {
            throw new InvalidReservationException("Invalid Email Format");
        }
        if (password == null || password.length() < 6) {
            throw new InvalidReservationException("Password Must Be At Least 6 Characters Long");
        }
        if (findUserByUsername(username) != null) {
            throw new InvalidReservationException("Username Already Exists");
        }
    }
    
    public void updateUserEmail(String userId, String newEmail) throws UserException, InvalidReservationException {
		User user = getUserById(userId);
		if (newEmail == null || !newEmail.contains("@")) {
		throw new InvalidReservationException("Invalid Email Format");
		}
		user.setEmail(newEmail);
		dbService.updateUser(user);
	}
    
    public void updateUserPassword(String userId, String newPassword) throws UserException, InvalidReservationException {
    	User user = getUserById(userId);
    	if (newPassword == null || newPassword.length() < 6) {
    	throw new InvalidReservationException("Password Must Be At Least 6 Characters Long");
    	}
    	user.setPassword(newPassword);
    	dbService.updateUser(user);
    }
    
    public void deleteUser(String userId) throws UserException {
		User user = getUserById(userId);
		users.remove(userId);
		dbService.deleteUser(userId);
	}
    
    private String generateUserId() {
        return "USER_" + System.currentTimeMillis();
    }
    
    private void loadUsersFromDatabase() {
        // Load users from file
        users.putAll(dbService.loadUsers());
    }
}