import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {
	public Scanner getRead(){
		File file = new File("Input");
		Scanner input = null;
		try{
			input = new Scanner(file); // scan the input file
		} 
		catch (FileNotFoundException e){
			System.err.println("Error with the input file.");
		}
		return input; // return the input
	}
}
