package makerspace.utils;
import java.util.regex.Pattern;

public class InputValidation {
	public static boolean isValidPassword(String password)
	{
		String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
		return Pattern.matches(passwordPattern, password);
	}
	
	public static boolean authPassword(String inputPassword, String storedPassord)
	{
		return inputPassword.equals(storedPassord);
	}
	
	
}
