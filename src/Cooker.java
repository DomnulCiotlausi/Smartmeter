
public abstract class Cooker extends Appliance{

	public Cooker(int electricityUse, int gasUse, int waterUse) {
		super(electricityUse, gasUse, waterUse);
	}
	
	public void cook(){
		timeOn = 4;
	}

}
