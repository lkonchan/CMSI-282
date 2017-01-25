import java.util.Arrays;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
// import java.io.File;
// import java.io.FileNotFoundException;
// import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.Random;

public class Select {

	public static void main (String[] args) throws Exception {
		java.io.BufferedReader input = new java.io.BufferedReader ( new java.io.InputStreamReader (System.in) );
		
		String s = "";	
		try {
			s = input.readLine();
		} catch (IOException e){
			System.out.println("Whoopsie");
		}

		ArrayList<Integer> data = new ArrayList<Integer>(); 
		while ( s != null ) {
			data.add(Integer.parseInt(s));

			try {
				s = input.readLine();
			} catch (IOException e){
				System.out.println("Whoopsie");
			}
		}

		//Data stored into array
		System.out.println("Array created from text file: " + data);

		int p = randomP(data);
		System.out.println("Random element for partion selected: " + p);
	}	

	public static int randomP(ArrayList<Integer> data) {
		int random = new Random().nextInt(data.size());
    	return data.get(random);
	}

	// public static ArrayList<Integer> partition(int p, ArrayList<Integer> data) {
		
	// }
		

	// public static int Select(int k, int[] data) {
	// }
}

