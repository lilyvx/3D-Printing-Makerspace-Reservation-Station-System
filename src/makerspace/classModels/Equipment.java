package makerspace.classModels;

import java.time.LocalDateTime;

public class Equipment {
	protected String equipmentId;
	public String getEquipmentId() { return equipmentId; }
	
	protected String name;
	public String getName() { return name; }
	
	protected String equipmentType;
	public String getEquipmentType() { return equipmentType; }
	
	protected String status; //Available, In Use, Maintenance, Down
	public String getStatus() { return status; }
	public void setStatus(String status) { this.status = status; }
	
	protected String location; //which room or area (facility)
	public String getLocation() { return location; }
	
	protected double hourCost;
	public double getHourCost() { return hourCost; }
	
	protected LocalDateTime lastMaintenance;
	public LocalDateTime getLastMaintenance() { return lastMaintenance; }
	
	protected String printerSpec;
	
	
	public Equipment(String equipmentId, String name, String equipmentType, double hourCost, String location) 
	{
		this.equipmentId = equipmentId;
		this.name = name;
		this.equipmentType = equipmentType;
		this.hourCost = hourCost;
		this.status = "Available";
		this.location = location;
		this.lastMaintenance = LocalDateTime.now();
	}
	
	public boolean isAvailable() { return status.equals("Available"); }
	
	public double calculateRate(int hours) { return hourCost * hours; }
	
	public String getEquipmentInfo()
	{
		return String.format("Equipment ID: %s --- %s (%s) | $%.2f/HR",
				equipmentId,
				name,
				equipmentType,
				hourCost);
	}
	
	@Override
	public String toString()
	{
		return getEquipmentInfo();
	}
}
