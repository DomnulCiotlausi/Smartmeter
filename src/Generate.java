import java.util.ArrayList;
import java.util.Iterator;

public abstract class Generate {
	private int electricityGenerated, gasGenerated, waterGenerated;
	private ArrayList<Meter> meterList = new ArrayList<Meter>();
	private ArrayList<Generate> generateList = new ArrayList<Generate>();
	
	public Generate(int electricityGenerated, int gasGenerated, int waterGenerated){
		this.electricityGenerated = electricityGenerated;
		this.gasGenerated = gasGenerated;
		this.waterGenerated = waterGenerated;
	}
	
	public void setMeterReference(ArrayList<Meter> meterList){ // set the meter list reference
		this.meterList = meterList;
	}
	
	public void timePasses(){ // see how much was generated in 15 minutes
		Iterator<Meter> it = meterList.iterator();
		while (it.hasNext()){
			Meter myMeter = it.next();
			switch(myMeter.getType()){
				case "electric":
					if (myMeter.canGenerate()){
						myMeter.incrementGenerated(electricityGenerated); // increment the various resources which were generated
						myMeter.decrementConsumed(electricityGenerated); // feed back the resources back in the system
					}
					break;
				case "gas":
					if (myMeter.canGenerate()){
						myMeter.incrementGenerated(gasGenerated);
						myMeter.decrementConsumed(gasGenerated);
					}
					break;
				case "water":
					if (myMeter.canGenerate()){
						myMeter.incrementGenerated(waterGenerated);
						myMeter.decrementConsumed(waterGenerated);
					}
					break;
			}
		}
	}
}
