
public class WashingMachine extends Appliance{
	
	private static int defaultElectricityUse = 2;
	private static int defaultGasUse = 0;
	private static int defaultWaterUse = 1;

	public WashingMachine(int electricityUse, int gasUse, int waterUse) {
		super(electricityUse>=0? electricityUse : defaultElectricityUse,
				gasUse>=0? gasUse : defaultGasUse,
				waterUse>=0? waterUse : defaultWaterUse);
	}
	
	public void doWashing(){
		timeOn = 8;
	}
	
	public boolean canUse(){
		return true;
	}

	public boolean OnOff() {
		return false;
	}
	
	public String getName() {
		return "WashingMachine";
	}
}

