import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Writer {
	
	private int line;
	
	public String[] createOutput(House myHouse){ // create the output as String[]
		String[] output = new String[100]; // we set the maximum of line to 100
		output[0] = "House:"; // print House at the beginning
		line = 0; // count how many lines we are going to have
		for (Meter m : myHouse.getMeters()){
			output[++line] = m.getName() + ":" + m.getConsumed() + "," + m.getGenerated() + "," + m.canGenerate(); // print the meters and all the parameters 
		}
		
		for (Appliance a : myHouse.getAppliances()){
			output[++line] = a.getName() + ":" + a.getElectricityUse() + "," + a.getGasUse() + "," + a.getWaterUse(); // print the appliances
		}
		
		for (Person p : myHouse.getPersons()){
			output[++line] = "Person:" + p.getName() + "," + p.getAge() + "," + p.getGender(); // print the persons
			
			int[] startTime = new int[100];
			String[] taskName = new String[100];
			int j=0, size; // use size to count how many tasks each person has
			for (int i : p.getTasks().keySet()){ // save the start times of each task
				startTime[++j] = i;
			}
			size = j;
			j=0;
			for (String s : p.getTasks().values()){ // save the name of each task
				taskName[++j] = s;
			}
			for (int i=1; i<=size; i++){
				output[++line] = taskName[i] + ":" + startTime[i]; // print the tasks and when each starts
			}
		}
		return output;
	}
	
	public void write(String[] output){
		File file = new File("Input"); // take the file
		PrintWriter writer = null; // create the printer
		try {
			writer = new PrintWriter(file); // initialize the printer 
		} catch (FileNotFoundException e) {
			System.err.println("");
		}
		for (int i=0; i<=line; i++){
			writer.println(output[i]); // print the lines
		}
		writer.close(); // close the printer
	}
}
