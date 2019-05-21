
public abstract class Shower extends Appliance{

	public Shower(int electricityUse, int gasUse, int waterUse) {
		super(electricityUse, gasUse, waterUse);
	}
	
	public void shower(){
		timeOn = 1;
	}
	
}
