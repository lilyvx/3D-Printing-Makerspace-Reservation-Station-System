package makerspace.exceptions;

public class EquipmentUnavailableException extends Exception {
	public EquipmentUnavailableException(String errorMessage) { super(errorMessage); }
	
	public EquipmentUnavailableException(String errorMessage, Throwable err) { super(errorMessage, err); } 

}
