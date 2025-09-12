package makerspace.classModels;

public class Printer3D extends Equipment{
	private String printTech;
	private String printVolume;
	private String nozzleTemp;
	
	
	public Printer3D(String equipmentId, String name, double hourCost, String location, String printTech, String printVolume) 
	{
		super(equipmentId, name, "3D_PRINTER", hourCost, location);
		this.printTech = printTech;
		this.printVolume = printVolume;
		this.nozzleTemp = "200-250C";
	}
}
