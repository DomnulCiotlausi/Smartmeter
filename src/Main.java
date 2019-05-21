import java.util.Scanner;

public class Main {
	public static void main (String[] args){
		Interpreter interpreter = new Interpreter(); // create the interpreter
		interpreter.readFile(); // read the file
		House myHouse = interpreter.getHouse(); // get the newly created house
		Scanner in = new Scanner(System.in);
		
		int day = 1;
		do{
			System.out.println("Day " + day++);
			for (int currentTime = 1; currentTime <= 96; currentTime++){ // 96 here means one day
				myHouse.timePasses(currentTime); // do all the tasks given at the current time
				myHouse.timePasses(); // generate resources if there are any generate appliances
				myHouse.resetIsUsed(); // reset the appliances
		}
		myHouse.showConsumed(); // show the consumption
		myHouse.showGenerated(); // show the generated resources
		} while (!in.nextLine().equalsIgnoreCase("quit")); // quit the program
		
		Writer writer = new Writer(); // writer is for writing in the Input file the new input after the program run (one of the extensions) 
		writer.write(writer.createOutput(myHouse)); // write in the file
	}
}
