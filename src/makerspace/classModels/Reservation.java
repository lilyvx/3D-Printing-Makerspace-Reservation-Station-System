package makerspace.classModels;
import java.time.LocalDateTime;

public class Reservation {

	private int resvid;
    private User user;
    private Equipment equipment;
    private LocalDateTime starttime;
    private LocalDateTime endtime;
    private String status; //pending, approved, canceled

    public String getResvid() { return resvid; }
    public String getUser() { return user; }
    public String getEquipment() { return equipment; }
    public LocalDateTime getStarttime() { return starttime; }
    public LocalDateTime getEndtime() { return endtime; 
    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    //constructor
    public Reservation (String resvid, User user, Equipment equipment, LocalDateTime starttime, LocalDateTime endtime, String status) 
     { this.resvid = resvid; 
       this.user = user;
       this.equipment = equipment;
       this.starttime = starttime;
       this.endtime = endtime;
       this.status = "pending"; }

    public void cancel() {
        this.status = "cancel";
    }

    public void approve() {
        this.status = "approved
        ";
    }
	
}
