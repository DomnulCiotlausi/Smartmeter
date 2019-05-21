
public class Refrigerator extends Appliance{
	
	private static int defaultElectricityUse = 1;
	private static int defaultGasUse = 0;
	private static int defaultWaterUse = 0;

	public Refrigerator(int electricityUse, int gasUse, int waterUse) {
		super(electricityUse>=0? electricityUse : defaultElectricityUse,
				gasUse>=0? gasUse : defaultGasUse,
				waterUse>=0? waterUse : defaultWaterUse);
		timeOn = -1;
	}
	
	public boolean canUse(){
		return true;
	}

	public boolean OnOff() {
		return true;
	}
	
	public String getName() {
		return "Refrigerator";
	}
	
	public void turnOnRefrigerator(){
		timeOn = -1;
	}
	
	public void turnOffRefrigerator(){
		timeOn = 0;
	}
}
