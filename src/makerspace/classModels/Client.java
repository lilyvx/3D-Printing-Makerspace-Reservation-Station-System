package makerspace.classModels;
import java.util.ArrayList;
import java.util.List;

public class Client extends User {
	
	private List<Reservation> reservationHistory;
	public List<Reservation> getReservationHistory() { return reservationHistory; }
	
	public Client(String userId, String username, String password)
	{
		super(userId, username, password);
		this.reservationHistory = new ArrayList<>();
	}
	
	@Override
	public String getUserType() { return "Client"; }
	
	public void addReservation(Reservation reservation)
	{
		reservationHistory.add(reservation);
	}
}
