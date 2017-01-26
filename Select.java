import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Select {

	public static int p = 0;

	public static void main (String[] args) throws Exception {
		int k = 0;

		//checking for a user-provided kth element as the first argument
		try {
			k = Integer.parseInt(args[0]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("BAD DATA. Please provide a kth element as your first argument.");
		}

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
		//System.out.println("Array created from text file: " + data);

		// int p = randomP(data);
		// System.out.println("Random element for partion selected: " + p);

		//System.out.println("Partition attempt: " + partition(data));

		System.out.println("Select attempt: " + select(k, data, 0, data.size()-1));
		
		


	}	

	public static int randomP(ArrayList<Integer> data, int min, int max) {
		int random = ThreadLocalRandom.current().nextInt(min, max + 1);
    	return random;
	}

	public static ArrayList<Integer> partition(ArrayList<Integer> data, int min, int max) {
		//step 1: swap p with last integer of list
		int temp = data.get(max);
		int pPlace = randomP(data, min, max);
		int pValue = data.get(pPlace);

		System.out.println("Rand element = " + pValue);
		
		data.set(max, pValue); //set value of p to last spot in array 
		data.set(pPlace, temp); //swap last value in array with p's spot

		//step 2: going left to right, swap p's place with anything larger
		boolean seekingHigher = true;
		for (int j = min; j < max; j++) {
			//System.out.println(max - min);
			while (seekingHigher) {
				for (int i = min; i <= pPlace; i++) {
					if (pValue < data.get(i) && seekingHigher) { //sorting highers on right 
						temp = data.get(i);
						pPlace = data.lastIndexOf(pValue);//does not account for repetition
						System.out.println("pPlace: " + pPlace);
						data.set(i, pValue);
						data.set(pPlace, temp);
						pPlace = i;
						System.out.println(data);
						System.out.println("pivot place: " + pPlace);
						seekingHigher = false; //now want to sort lowers on left
				    }

				    if (i == pPlace) { 
				    	seekingHigher = false; 
				    }
				}
			}

			while (!seekingHigher) {
				for (int i = max; i >= pPlace; i--) {
					if (pValue > data.get(i) && !seekingHigher) { //sorting lowers on left
						temp = data.get(i);
						pPlace = data.lastIndexOf(pValue); //does not account for repetition
						System.out.println("pPlace: " + pPlace);
						data.set(i, pValue);
						data.set(pPlace, temp);
						pPlace = i;
						System.out.println(data);
						System.out.println("pivot place: " + i);
						seekingHigher = true;
					}

					if (i == pPlace) { 
						seekingHigher=true; 
					}
				}

				//System.out.println("hang2");
			}

		}
		p = pPlace; //not sure if this works
		System.out.println("p is now: " + p);
		return data;
	}
		

	public static int select(int k, ArrayList<Integer> data, int min, int max) {
		//call partition
		ArrayList<Integer> sortedData = partition(data, min, max);


		//check cases 1, 2, 3 and call select again if 1 or 3 is true with smaller data set
		if (p == k) {
			return data.get(p);
		} else if (p < k) {
			System.out.println("Max: " + max);
			System.out.println("Min(p+1): " + p + 1);
			select(k, sortedData, p + 1, max);
			
		} else if (p > k) { 
			System.out.println("Min: " + min);
			System.out.println("Max(p-1): " + (p - 1));
			select(k, sortedData, min, p - 1);
			
		}

		return data.get(p);
	}
}

