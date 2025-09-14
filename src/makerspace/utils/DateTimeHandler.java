package makerspace.utils;
import java.time.LocalDateTime;
import java.time.format.*;

public class DateTimeHandler {
	public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	
	public static LocalDateTime parseStringToDateTime(String dateTimeStr) throws DateTimeParseException
	{
		return LocalDateTime.parse(dateTimeStr, formatter);
	}
	
	public static String formatDateTimeToString(LocalDateTime dateTime)
	{
		return dateTime.format(formatter);
	}
	
	// Rounds to nearest hr
	public static LocalDateTime roundToNextHour(LocalDateTime dateTime)
	{
		return dateTime.withMinute(0).withSecond(0).withNano(0);
	}
	
	public static boolean isValidFutureDateTIme(LocalDateTime dateTime)
	{
		return dateTime.isAfter(LocalDateTime.now());
	}
	
	public static boolean isWorking(LocalDateTime dateTime)
	{
		int hour = dateTime.getHour();
		return hour >= 10 && hour < 20; //10AM to 8PM
	}
	
	public static String getCurrentDateTimeString()
	{
		return formatDateTimeToString(LocalDateTime.now());
	}
	
	public static LocalDateTime getCurrentDateTime()
	{
		return LocalDateTime.now();
	}
}
