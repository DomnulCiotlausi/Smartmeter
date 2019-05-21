
public class Kettle extends Appliance{
	
	private static int defaultElectricityUse = 20;
	private static int defaultGasUse = 0;
	private static int defaultWaterUse = 1;

	public Kettle(int electricityUse, int gasUse, int waterUse) {
		super(electricityUse>=0? electricityUse : defaultElectricityUse,
				gasUse>=0? gasUse : defaultGasUse,
				waterUse>=0? waterUse : defaultWaterUse);
	}
	
	public void boil(){
		timeOn = 1;
	}
	
	public boolean canUse(){
		return false;
	}

	public boolean OnOff() {
		return false;
	}
	
	public String getName() {
		return "Kettle";
	}

}
