import java.util.ArrayList;
import java.util.Iterator;

public class House {
	
	private ArrayList<Appliance> applianceList = new ArrayList<Appliance>();
	private ArrayList<Generate> generateList = new ArrayList<Generate>();
	private ArrayList<Meter> meterList = new ArrayList<Meter>();
	private ArrayList<Person> personList = new ArrayList<Person>();
	private int numofAppliances = 0;
	
	public void addAppliance(Appliance newAppliance){ // add a new appliance
		newAppliance.setMeterReference(meterList); // set the meters reference, so the appliance will know what meters to use
		applianceList.add(newAppliance);
		numofAppliances ++; // increment the numbers of appliances
	}
	
	public void removeApplince(Appliance myAppliance){ // remove the appliance
		if (numofAppliances != 0){ // first check that there are appliances to be removed
			Iterator<Appliance> it = applianceList.iterator();
			while (it.hasNext()){
				if (it.next().equals(myAppliance)){
					it.remove();
					break;
				}
			}
			numofAppliances --;
		}
		else {
			System.err.println("The appliance list is empty. Cannot remove an appliance.");
		}
	}
	
	public int numAppliances(){ // return the number of appliances in the house
		return numofAppliances;
	}
	
	public void addMeter(Meter myMeter){ // add the entered meter to the meter list
		meterList.add(myMeter);
	}
	
	public void timePasses(int currentTime){ // take the current time
		Iterator<Person> it = personList.iterator(); // go through all the persons 
		while(it.hasNext()){
			it.next().timePasses(currentTime); // and check if it has a task to do at the current time
		}
	}
	
	public void addPerson(Person newPerson){ // add the person given to the person list
		personList.add(newPerson);
	}
	
	public ArrayList<Person> getPersons(){ // return the person list
		return personList;
	}
	
	public ArrayList<Appliance> getAppliances(){ // return the appliance list
		return applianceList;
	}
	
	public ArrayList<Meter> getMeters(){ // return the meter list
		return meterList;
	}
	
	public void showConsumed(){ // show how much was consumed 
		for (Meter m : meterList){
			if (m.getType().equals("electric")){
				System.out.println("Electricity consumed: " + m.getConsumed()); // electricity consumption
			}
			if (m.getType().equals("gas")){
				System.out.println("Gas consumed: " + m.getConsumed()); // gas consumption
			}
			if (m.getType().equals("water")){
				System.out.println("Water consumed: " + m.getConsumed()); // water consumption
			}
		}
		System.out.println();
	}
	
	public void resetIsUsed(){ // if a task is finished, set the being used variable from the appliance false
		Iterator<Appliance> it = applianceList.iterator();
		while (it.hasNext()){
			it.next().resetIsUsed();
		}
	}
	
	public void addGenerate(Generate myGenerate){
		myGenerate.setMeterReference(meterList);
		generateList.add(myGenerate);
	}
	
	public ArrayList<Generate> getGenerate(){
		return generateList;
	}
	
	public void timePasses(){
		Iterator<Generate> it = generateList.iterator();
		while(it.hasNext()){
			it.next().timePasses();
		}
	}
	
	public void showGenerated(){
		for (Meter m : meterList){
			if (m.getType().equals("electric")){
				System.out.println("Electricity generated: " + m.getGenerated()); // electricity consumption
			}
			if (m.getType().equals("gas")){
				System.out.println("Gas generated: " + m.getGenerated()); // gas consumption
			}
			if (m.getType().equals("water")){
				System.out.println("Water generated: " + m.getGenerated()); // water consumption
			}
		}
		System.out.println();
	}
}
