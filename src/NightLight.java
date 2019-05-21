
public class NightLight extends Appliance{
	
	private static int defaultElectricityUse = 1;
	private static int defaultGasUse = 0;
	private static int defaultWaterUse = 0;

	public NightLight(int electricityUse, int gasUse, int waterUse) {
		super(electricityUse>=0? electricityUse : defaultElectricityUse,
				gasUse>=0? gasUse : defaultGasUse,
				waterUse>=0? waterUse : defaultWaterUse);
	}
	
	public void turnOnNightLamp(){
		timeOn = -1;
	}
	
	public void turnOffNightLamp(){
		timeOn = 0;
	}
	
	public boolean canUse(){
		return true;
	}

	public boolean OnOff() {
		return true;
	}
	
	public String getName() {
		return "NightLamp";
	}
}
