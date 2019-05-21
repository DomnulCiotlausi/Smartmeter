
public class ElectricShower extends Shower{

	private static int defaultElectricityUse = 12;
	private static int defaultGasUse = 0;
	private static int defaultWaterUse = 4;
	
	public ElectricShower(int electricityUse, int gasUse, int waterUse) {
		super(electricityUse>=0? electricityUse : defaultElectricityUse,
				gasUse>=0? gasUse : defaultGasUse,
				waterUse>=0? waterUse : defaultWaterUse);
	}
	
	public boolean canUse(){
		return true;
	}

	public boolean OnOff() {
		return false;
	}
	
	public String getName() {
		return "ElectricShower";
	}
}
