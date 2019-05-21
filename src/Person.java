import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Person {
	private String name;
	private int age;
	private char gender;
	private ArrayList<Appliance> applianceList = new ArrayList<Appliance>();
	private HashMap<Integer, String> tasks = new HashMap<Integer, String>();
	
	public Person(String name, int age, char gender){
		this.name = name;
		this.age = age;
		this.gender = gender; // the gender is saved as a character, 'M' being male and 'F' being female
	}
	
	public String getName(){ // return the name of the person
		return name;
	}
	
	public int getAge(){ // return the age of the person
		return age;
	}
	
	public char getGender(){ // return the gender of the person
		return gender;
	}
	
	public void addTask(int startTime, String taskName){ // add a new task to the person
		tasks.put(startTime, taskName); // in the task HashMap we are saving when the task will start and the actual name of the task
	}
	
	public HashMap<Integer, String> getTasks(){ // return all the tasks of a person
		return tasks;
	}
	
	public void setApplianceList(ArrayList<Appliance> applianceList){ // set the reference of all the appliances
		this.applianceList = applianceList;
	}
	
	public void timePasses(int currentTime){
		for (Appliance myAppliance : applianceList){ // decrement the usage time of an appliance
			if (myAppliance.getTimeOn() != 0){
				myAppliance.timePasses(myAppliance.getTimeOn());
			}
		}
		boolean canUse = true; 
		for (int startTime: tasks.keySet()){	// we take all the task which should start at the current time
			if (startTime == currentTime){
				for (Appliance myAppliance : applianceList){
					if (age < 18){	// check if a child can use the appliance
						if (!myAppliance.canUse()){
							canUse = false;
						}
					}
					if ((!myAppliance.getIsUsed() && canUse) || (myAppliance.OnOff() && canUse)){ // if the appliance is not being used and if the person can use the appliance or the appliance is on/off or that person can turn on/off the appliance (this allows for a another person to turn off an appliance)
						Method[] methodToFind = myAppliance.getClass().getMethods(); // returns all the methods of an appliance and saves them
						for (Method m : methodToFind){
							if (m.getName().equalsIgnoreCase(tasks.get(startTime))){ // if we find the method we are looking for, invoke the method
								try{
									m.invoke(myAppliance, null); // invoke takes as parameters the appliance and the parameters required by the method, in our case we are not using any parameter, so we use null

								} catch (Exception e){
									System.err.println("Invalid task.");
								}
							}
						}
					}
				}
			}
		}
	}
}
