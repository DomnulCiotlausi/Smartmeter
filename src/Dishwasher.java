
public class Dishwasher extends Appliance{
	
	private static int defaultElectricityUse = 2;
	private static int defaultGasUse = 0;
	private static int defaultWaterUse = 1;

	public Dishwasher(int electricityUse, int gasUse, int waterUse) {
		super(electricityUse>=0? electricityUse : defaultElectricityUse,
				gasUse>=0? gasUse : defaultGasUse,
				waterUse>=0? waterUse : defaultWaterUse);
	}
	
	public void washDishes(){
		timeOn = 6;
	}
	
	public boolean canUse(){
		return true;
	}

	public boolean OnOff() {
		return false;
	}
	
	public String getName() {
		return "Dishwasher";
	}
}
