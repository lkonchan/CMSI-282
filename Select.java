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

		// int p = randomP(data);
		// System.out.println("Random element for partion selected: " + p);

		System.out.println("Partition attempt: " + partition(data));


	}	

	public static int randomP(ArrayList<Integer> data) {
		int random = new Random().nextInt(data.size());
		//might be taking this a step too far since it's placement is still relevant to list 
    	//return data.get(random);
    	return random;
	}

	public static ArrayList<Integer> partition(ArrayList<Integer> data) {
		//step 1: swap p with last integer of list
		int temp = data.get(data.size() - 1);
		int pPlace = randomP(data);
		int pValue = data.get(pPlace);

		System.out.println("Rand element = " + pValue);
		
		data.set(data.size() - 1, pValue); //set value of p to last spot in array 
		data.set(pPlace, temp); //swap last value in array with p's spot

		//step 2: going left to right, swap p's place with anything larger
		boolean seekingHigher = true;
		for (int j = 0; j < data.size()/2; j++) {
			while (seekingHigher) {
				for (int i = 0; i < data.size(); i++) {
					if (pValue < data.get(i) && seekingHigher) { //sorting highers on right 
						temp = data.get(i);
						pPlace = data.lastIndexOf(pValue);
						data.set(i, pValue);
						data.set(pPlace, temp);
						System.out.println(data);
						seekingHigher = false; //now want to sort lowers on left
				    }
				}
			}

			while (!seekingHigher) {
				for (int i = data.size() - 1; i > 0; i--) {
					if (pValue > data.get(i) && !seekingHigher) { //sorting lowers on left
						temp = data.get(i);
						pPlace = data.lastIndexOf(pValue);
						data.set(i, pValue);
						data.set(pPlace, temp);
						System.out.println(data);
						seekingHigher = true;
					}
				}
			}

		}
		
		return data;
	}
		

	// public static int Select(int k, int[] data) {
	// }
}

