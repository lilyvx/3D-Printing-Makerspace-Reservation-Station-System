package makerspace.service;
import makerspace.classModels.*;
import java.io.*;
import java.util.*;

public class DbService {
	private static final String DATA_DIRECTORY = "data/";
	private static final String USERS_FILE = DATA_DIRECTORY + "users.txt";
	private static final String EQUIPMENT_FILE = DATA_DIRECTORY + "equipment.txt";
	private static final String RESERVATIONS_FILE = DATA_DIRECTORY + "reservations.txt";
	
	public DbService()
	{
		createDataDirectory();
	}
	
	private void createDataDirectory()
	{
		File dir = new File(DATA_DIRECTORY);
		if (!dir.exists())
		{
			dir.mkdirs();
		}
	}
	private String userToString(User user) {
		if (user instanceof Admin) {
			Admin admin = (Admin) user;
			return String.format("Admin|%s|%s|%s|%s|%s", 
					admin.getUserId(),
					admin.getUsername(), 
					admin.getEmail(),
					"****",
					admin.getAdminTier());
		} else if (user instanceof Client) {
			Client client = (Client) user;
			return String.format("Client|%s|%s|%s|%s|%.2f|%s", 
					client.getUserId(),
					client.getUsername(), 
					client.getEmail(),
					"****",
					client.getAccountBalance(),
					client.getUserType());
		}
		return "";
	}
	
	 private User stringToUser(String line) {
	        String[] parts = line.split("\\|");
	        if (parts.length < 6) return null;
	        
	        String type = parts[0];
	        String id = parts[1];
	        String username = parts[2];
	        String email = parts[3];
	        String password = "password"; // Default password for loaded users
	        
	        if ("Client".equals(type) && parts.length >= 7) {
	            Client client = new Client(id, username, email, password);
	            client.updateAccountBalance(Double.parseDouble(parts[6]));
	            if (parts.length >= 8) {
	                client.setUserLevel(parts[7]);
	            }
	            return client;
	        } else if ("Admin".equals(type) && parts.length >= 7) {
	            return new Admin(id, username, email, password, parts[6]);
	        }
	        
	        return null;
	    }
	
	public void saveUser(User user) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(USERS_FILE, true))) {
			writer.println(userToString(user));
		} catch (IOException e) {
			System.err.println("Error saving user: " + e.getMessage());
		}
	}
	
	 public Map<String, User> loadUsers() {
	        Map<String, User> users = new HashMap<>();
	        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                User user = stringToUser(line);
	                if (user != null) {
	                    users.put(user.getUserId(), user);
	                }
	            }
	        } catch (FileNotFoundException e) {
	            // File doesn't exist yet, return empty map
	        } catch (IOException e) {
	            System.err.println("Error loading users: " + e.getMessage());
	        }
	        return users;
	        
	 }
	 
	private String equipmentToString(Equipment equipment) {
        if (equipment instanceof Printer3D) {
            Printer3D printer = (Printer3D) equipment;
            return String.format("3D_PRINTER|%s|%s|%.2f|%s|%s|%s",
                               printer.getEquipmentId(), printer.getName(),
                               printer.getHourCost(), printer.getLocation(),
                               printer.getPrintTech(), printer.getPrintVolume());
        } else {
            return String.format("EQUIPMENT|%s|%s|%s|%.2f|%s",
                               equipment.getEquipmentId(), equipment.getName(),
                               equipment.getEquipmentType(), equipment.getHourCost(),
                               equipment.getLocation());
        }
	}
	
	public void saveEquipment(Equipment equipment) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(EQUIPMENT_FILE, true))) {
            writer.println(equipmentToString(equipment));
        } catch (IOException e) {
            System.err.println("Error saving equipment: " + e.getMessage());
        }
    }
    
    public void updateEquipment(Equipment equipment) {
        //append the updated equipment to file
        saveEquipment(equipment);
    }
	
}

