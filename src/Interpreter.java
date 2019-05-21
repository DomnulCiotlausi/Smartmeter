import java.lang.reflect.Constructor;
import java.util.Scanner;

public class Interpreter {
	Reader reader = new Reader();
	Scanner input = reader.getRead();
	House myHouse = new House();
	
	public void readFile(){
		while(input.hasNextLine()){
			String[] words = input.nextLine().split(":|\\,"); // separate the line by ":" and "," characters
			
			switch (words[0].toLowerCase()){ // we are using toLowerCase so the user doesn't need to worry about the program being case sensitive
				case "house": 	
					this.myHouse = new House(); // create a new house
					break;
				
				case "electricmeter": case "gasmeter": case "watermeter":
					try {
						int consumed = 0, generated =0;
						boolean canGenerate = false; // we start with the assumption that the resource cannot be generated
						int j;
						boolean ok = false; // we are using ok so we can check if the line shows if the resource can be generated or not
						for (j=1; j<words.length; j++){ // go through each word/number of the line 
							if (words[j].equals("true") || words[j].equals("false")){ // if we find that resource can/cannot be generated, make ok true
								ok = true;
								break;
							}
						}
						// Integer.parseInt(String) transforms the string into an int
						if (ok){ // if we have the true/false value
							for (int k=1; k<=j-1; k++){ // go through all the numbers, but stop before reaching the true/false bit
								if (k==1){
									consumed = Integer.parseInt(words[k]); 
								}
								if (k==2){
									generated = Integer.parseInt(words[k]);
								}
							}
							if (words[j].equals("true")){
								canGenerate = true; 
							}
						}
						else{
							for (int k=1; k<words.length; k++){ // go through all the line because we know that the true/false bit is not given
								if (k==1){
									consumed = Integer.parseInt(words[k]);
								}
								if (k==2){
									generated = Integer.parseInt(words[k]);
								}
							}
						}
						
						// check what kind of meter we are using, create the meter and then add it to my house
						if (words[0].toLowerCase().equals("electricmeter")){
							ElectricMeter myElectricMeter = new ElectricMeter(consumed, generated, canGenerate);
							myHouse.addMeter(myElectricMeter);
						}
						if (words[0].toLowerCase().equals("watermeter")){
							WaterMeter myWaterMeter = new WaterMeter(consumed, generated, canGenerate);
							myHouse.addMeter(myWaterMeter);
						}
						if (words[0].toLowerCase().equals("gasmeter")){
							GasMeter myGasMeter = new GasMeter(consumed, generated, canGenerate);
							myHouse.addMeter(myGasMeter);
						}
					}
					catch (Exception e){
						System.err.println("Invalid meter.");
					}
					break;
					
				case "person":
					try{
						String name;
						int age;
						char gender;
						
						name = words[1];
						age = Integer.parseInt(words[2]);
						gender = words[3].charAt(0); // take the first character of the last word and save it in the gender variable
						if (!(gender == 'M' || gender == 'F')){ // if we have an invalid gender (not M/F)
							System.err.println("Invalid gender.");
							break;
						}
						
						if (age>=18){ // create an adult/child (based on the age) and add it to the house
							GrownUp Adult = new GrownUp(name, age, gender); 
							myHouse.addPerson(Adult);
						}
						else{
							Child Kid = new Child (name, age, gender);
							myHouse.addPerson(Kid);
						}
						myHouse.getPersons().get(myHouse.getPersons().size() - 1).setApplianceList(myHouse.getAppliances());
					}
					catch (Exception e){
						System.err.println("Invalid person.");
					}
					break;
					
				case "boiler": case "dishwasher": case "electriccooker": case "electricshower": case "gascooker":
				case "kettle": case "nightlight": case "powershower": case "refrigerator": case "tv": case "washingmachine":
					try{
						if (myHouse.numAppliances() > 25){ // if we enter too many appliances (the limit is 25), print an error message
							System.err.println("Too many appliances");
							break;
						}
							int electricityUse = -1, gasUse = -1, waterUse = -1; // we declare those as -1 because if we don't enter the value, the subclass will not to use the default value
							for (int l=1; l<words.length; l++){
								switch (l){
									case 1 :
										electricityUse = Integer.parseInt(words[1]);
										break;
									case 2:
										gasUse = Integer.parseInt(words[2]);
										break;
									case 3:
										waterUse = Integer.parseInt(words[3]);
										break;
									default:
										System.err.println("Too many values.");
										break;
								}
							}
							Class<?> cl = Class.forName(words[0]); // we create a new class with the entered name
							// this means we do not have to enter another switch method just to know what kind of appliance to create
							Constructor<?> con = cl.getConstructor(int.class, int.class, int.class); // create a new constructor based on the newly created appliance
							Appliance newAppliance = (Appliance) con.newInstance(electricityUse, gasUse, waterUse); // create a new instance of the appliance
							myHouse.addAppliance(newAppliance); // add the appliance to the house
					}
					catch (Exception e){
						System.err.println("Invalid appliance.");
					}
					
					break;
					
				case "solarcell": case "windturbine":
					try{
						int electricityGenerated = 0, gasGenerated = 0, waterGenerated = 0; // we declare those as -1 because if we don't enter the value, the subclass will not to use the default value
						for (int l=1; l<words.length; l++){
							switch (l){
								case 1 :
									electricityGenerated = Integer.parseInt(words[1]);
									break;
								case 2:
									gasGenerated = Integer.parseInt(words[2]);
									break;
								case 3:
									waterGenerated = Integer.parseInt(words[3]);
									break;
								default:
									System.err.println("Too many values.");
									break;
							}
						}
						Class<?> cl = Class.forName(words[0]);
						Constructor<?> con = cl.getConstructor(int.class, int.class, int.class);
						Generate newGenerate = (Generate) con.newInstance(electricityGenerated, gasGenerated, waterGenerated);
						myHouse.addGenerate(newGenerate);
					}
					catch (Exception e){
						System.err.println("Invalid appliance.");
					}
					break;
					
					
				case "dowashing": case "boil": case "turnontv": case "turnofftv": case "washdishes": case "turnonboiler": case "turnoffboiler": 
				case "turnonnightlamp": case "turnoffnightlamp": case "cook": case "shower":
					try{
						Person lastPerson = myHouse.getPersons().get(myHouse.getPersons().size() - 1);
						int startTime = Integer.parseInt(words[1]);
						lastPerson.addTask(startTime, words[0]);
					}
					catch (Exception e){
						System.err.println("Invalid task.");
					}
					break;
			}						
		}
	}
	
	public House getHouse(){ // return the newly created house, with all the appliances, meters and persons
		return this.myHouse;
	}
}
