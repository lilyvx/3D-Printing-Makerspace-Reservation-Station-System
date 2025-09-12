package makerspace.classModels;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Reservation {
	private String reservationId;
    private String userId;
    private String equipmentId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status; //pending, approved, cancelled, in_progress, completed
    private LocalDateTime createdAt;
    private double cost;

    public String getReservationId() { return reservationId; }
    public String getUserId() { return userId; }
    public String getEquipmentId() { return equipmentId; }
    public String getStatus() { return status; }
    public LocalDateTime getStartTime() { return startTime; }
    public LocalDateTime getEndTime() { return endTime; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public double getCost() { return cost; }

    public void setStatus(String status) { this.status = status; }//~
    public void setCost(double cost) { this.cost = cost;}

    //constructor
    public Reservation (String reservationId, String userId, String equipmentId, LocalDateTime startTime, LocalDateTime endTime) 
     { this.reservationId = reservationId; 
       this.userId = userId;
       this.equipmentId = equipmentId;
       this.startTime = startTime;
       this.endTime = endTime;
       this.status = "Pending"; 
       this.createdAt = LocalDateTime.now();
       }
    //should implement validation if can be cancelled or approved
    public void cancel() { this.status = "cancelled"; }
    public void approve() { this.status = "approved"; }
    public void complete() { this.status = "completed"; }
    
    public int getDuration()
    {
    	return (int) Duration.between(startTime, endTime).toHours(); //body type is long converted to integer
    }
	
    @Override
    public String toString()
    {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    	return String.format("Reservation ID: %s, Equipment ID: %s, Time: %s to %s, Status: %s, Total Cost: $%.2f",
    			reservationId,
    			equipmentId,
    			startTime.format(formatter),
    			endTime.format(formatter),
    			status,
    			cost);
    }
}
