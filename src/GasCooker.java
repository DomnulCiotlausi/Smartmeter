
public class GasCooker extends Cooker{
	
	private static int defaultElectricityUse = 0;
	private static int defaultGasUse = 4;
	private static int defaultWaterUse = 0;

	public GasCooker(int electricityUse, int gasUse, int waterUse) {
		super(electricityUse>=0? electricityUse : defaultElectricityUse,
				gasUse>=0? gasUse : defaultGasUse,
				waterUse>=0? waterUse : defaultWaterUse);
	}
	
	public boolean canUse(){
		return false;
	}

	public boolean OnOff() {
		return false;
	}
	
	public String getName() {
		return "GasCooker";
	}
}
