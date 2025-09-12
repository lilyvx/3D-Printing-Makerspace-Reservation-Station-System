package makerspace.exceptions;

public class UserException extends Exception {
	public UserException(String errorMessage) { super(errorMessage); }
	
	public UserException(String errorMessage, Throwable err) { super(errorMessage, err); }

}
