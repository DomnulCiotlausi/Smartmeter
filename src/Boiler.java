
public class Boiler extends Appliance{

	private static int defaultElectricityUse = 0;
	private static int defaultGasUse = 1;
	private static int defaultWaterUse = 0;
		
	public Boiler(int electricityUse, int gasUse, int waterUse) {
		// this explanation is valid for all the appliances
		// the super here checks if the electricity/gas/water usage is bigger than 0
		// if it is, then use the value from the input
		// if not, use the default value which is being set in each appliance class
		// this allows us to use the default values if not is being inputed  
		super(electricityUse>=0? electricityUse : defaultElectricityUse, 
				gasUse>=0? gasUse : defaultGasUse,	
				waterUse>=0? waterUse : defaultWaterUse);
		timeOn = -1;
	}
	
	
	public void turnOnBoiler(){
		timeOn = -1;
	}
	
	// turn the boiler on/off
	// if timeOn = -1, then we consider that the appliance is always on
	
	public void turnOffBoiler(){
		timeOn = 0;
	}

	public boolean canUse() {
		return false;
	}

	public boolean OnOff() {
		return true;
	}

	public String getName() {
		return "Boiler";
	}
}
