
public class PowerShower extends Shower{
	
	private static int defaultElectricityUse = 0;
	private static int defaultGasUse = 10;
	private static int defaultWaterUse = 5;

	public PowerShower(int electricityUse, int gasUse, int waterUse) {
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
		return "PowerShower";
	}
}
