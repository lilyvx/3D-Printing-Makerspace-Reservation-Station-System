package makerspace.classModels;

public class Equipment {
	protected String equipmentId;
	public String getEquipmentId() { return equipmentId; }
	
	protected String name;
	public String getName() { return name; }
	
	protected String equipmentType;
	public String getEquipmentType() { return equipmentType; }
	
	protected String status;
	public String getStatus() { return status; }
	public void setStatus(String status) { this.status = status; }
	
	protected String location;
	public String getLocation() { return location; }
	
	public Equipment(String equipmentId, String name, String equipmentType, String status, String location) 
	{
		this.equipmentId = equipmentId;
		this.name = name;
		this.equipmentType = equipmentType;
		this.status = "Available";
		this.location = location;
	}
	
	public boolean isAvailable() { return status.equals("Available"); }
}
