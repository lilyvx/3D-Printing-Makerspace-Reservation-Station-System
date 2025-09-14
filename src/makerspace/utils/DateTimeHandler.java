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
	
	public static boolean isValidDateTimeString(String dateTimeStr)
	{
		try {
			LocalDateTime.parse(dateTimeStr, formatter);
			return true;
		}
		catch(DateTimeParseException err)
		{
			throw err;
		}
	}
	
	public static LocalDateTime roundToNextHour(LocalDateTime dateTime)
	{
		return dateTime.withMinute(0).withSecond(0).withNano(0);
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
