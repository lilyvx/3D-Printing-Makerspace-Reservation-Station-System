package makerspace.utils;
import java.util.regex.Pattern;

public class InputValidation{
	
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
    
    public static boolean isValidEmail(String email) 
    {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }
    
    public static boolean isValidPassword(String password) {
        return password != null && password.length() >= 6;
    }
    
    public static boolean isValidUsername(String username) 
    {
        return username != null && username.trim().length() >= 3 &&  username.trim().length() <= 20 && username.matches("^[a-zA-Z0-9_]+$");
    }
    
    public static boolean isPositiveNumber(double number) 
    {
        return number > 0;
    }
    
    public static boolean isValidEquipmentId(String equipmentId) 
    {
        return equipmentId != null && equipmentId.startsWith("EQ_") && equipmentId.length() > 3;
    }
}
