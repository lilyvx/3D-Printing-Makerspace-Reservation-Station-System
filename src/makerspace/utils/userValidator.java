package makerspace.utils;
import java.util.HashMap;
import java.util.Scanner;

public class userValidator {
	private static HashMap<String, String> accounts = new HashMap<String, String>();
	private static Scanner scanner = new Scanner(System.in); 
	
	public void main(String[] args) {
		int choice = 0;
		
		while(choice !=3) {
			System.out.println("3D Reservation System");
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("3. Exit");
			System.out.println("Choose an option: "); 
			
			choice = scanner.nextInt();
			scanner.nextLine();
			
			switch (choice){
			case 1 : loginUser(scanner); break;
			case 2 : registerUser(scanner); break;
			case 3 : break;
			default : System.out.println("Invalid choice."); break;
			
			}	
		}  
	}

	private void loginUser(Scanner scanner) {
		System.out.println("Enter your username: ");
		String username = scanner.nextLine();
		
		System.out.println("Enter your password: ");
		String password = scanner.nextLine();
		
		if (accounts.containsKey(username) && accounts.get(username).equals(password)){
			System.out.println("Login suceesful!");
			
		}
		else {
			System.out.println("Invalid username or password.");
		}
	}

	private void registerUser(Scanner scanner) {
		System.out.println("Enter a username: ");
		String username = scanner.nextLine();
		System.out.println("Enter a password: ");
		String password = scanner.nextLine();
		
		if(accounts.containsKey(username)) {
			System.out.println("Username already exists. Please choose another,");
			
		}else {
			accounts.put(username, password);
			System.out.println("Register successful.");
			
		}
		
		
	}
}
