import java.util.ArrayList;
import java.util.Iterator;

public abstract class Appliance {
	
	private int electricityUse, gasUse, waterUse;
	protected int timeOn;
	private boolean isUsed = false; // checks if the appliance is being used
	
	ArrayList<Meter> meterList = new ArrayList<Meter>();
	
	public Appliance (int electricityUse, int gasUse, int waterUse){
		this.electricityUse = electricityUse;
		this.gasUse = gasUse;
		this.waterUse = waterUse; 
	}
	
	public void setMeterReference(ArrayList<Meter> newMeterList){ // set the meters reference
		meterList =  newMeterList;
	}
	
	public int getTimeOn(){ // returns for how much the appliance will be on
		return timeOn;
	}
	
	public void resetIsUsed(){ // sets the current state of the appliance to not used
		isUsed = false;
	}
	
	public boolean getIsUsed(){ // return the appliance's current state
		return isUsed;
	}
	
	public abstract boolean OnOff(); // return if the appliance is an on/off appliance type
	
	public void timePasses(int timeOn){
		if(timeOn != 0 && !isUsed){ // if the appliance is hasn't finished it's task and is not being used by somebody else
			isUsed = true; // set the current state as being in use
			Iterator<Meter> it = meterList.iterator();
			while(it.hasNext()){
				Meter myMeter = it.next();
				switch(myMeter.getType()){
					case "electric":
						myMeter.incrementConsumed(electricityUse); // increment the various meters
						break;
					case "gas":
						myMeter.incrementConsumed(gasUse);
						break;
					case "water":
						myMeter.incrementConsumed(waterUse);
						break;
				}
			}
			if (timeOn != -1){ // if timeOn is -1, that means that the appliance is constantly on
				timeOn--;
			}
			this.timeOn = timeOn;
		}
	}
	
	public abstract boolean canUse(); // all the "harmful" appliances return false, this is to check if the appliance is being used by a child
	
	public abstract String getName(); // return the name of the appliance
	
	public int getElectricityUse(){ // return how much energy was used
		return electricityUse;
	}
	
	public int getGasUse(){
		return gasUse;
	}
	
	public int getWaterUse(){
		return waterUse;
	}
}
