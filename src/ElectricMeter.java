
public class ElectricMeter extends Meter{
	
	public ElectricMeter(int consumed, int generated, boolean canGenerate) {
		super(consumed, generated, canGenerate);
	}

	public String getType(){
		return "electric";
	}

	public void show() {
		System.out.println("Electricity: " + consumed);
	}

	public String getName() {
		return "ElectricMeter";
	}
}
