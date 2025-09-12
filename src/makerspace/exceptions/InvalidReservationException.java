package makerspace.exceptions;

public class InvalidReservationException extends Exception {
	public InvalidReservationException(String errorMessage) { super(errorMessage); }
	
	public InvalidReservationException(String errorMessage, Throwable err) { super(errorMessage, err); }
}
