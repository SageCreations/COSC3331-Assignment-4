import java.util.Random;

public class Main {
	
	public static void main(String[] args) {
		// Declare an array of type int and of size 100 called dataArray.
		int[] dataArray = new int[100];
		
		// random import for random number generation
		Random rand = new Random();
		
		// Declaration for the random number to initialize every iteration
		int randomDigit;
		
		// Populate this array with random 3-digit numbers, duplicates are allowed.
		for (int i = 0; i < dataArray.length; i++) {
			randomDigit = rand.nextInt(899) + 100;
			dataArray[i] = randomDigit;
			//System.out.println(dataArray[i] + "->" + randomDigit%10);
		}

		// Declartion of QArray with size 10
		LinkQueue[] QArray = new LinkQueue[10];
		for (int i = 0; i < QArray.length; i++) {
			QArray[i] = new LinkQueue();
		}

		// Iterate over dataArray
		// Add numbers to their proper queue by basing it off of their 
		// indivisual digit. 
		for (int i = 0; i < dataArray.length; i++) {
			// first round
			// least sig digit (most right)
			QArray[dataArray[i]%10].insert(dataArray[i]);
			//System.out.println(element%10);
		}
		
		// add the flag to the queues and display them.	
		for (int i = 0; i < QArray.length; i++) { 
			QArray[i].insert(-1);			
			QArray[i].displayQueue();
		}

		System.out.println("\n");

		// second round of sorting
		for (int i = 0; i < QArray.length; i++) {
			while (!QArray[i].isEmpty()) {	
				int value = QArray[i].remove();
				if (value == -1) {break;}
				int num = value	% 100;				
				QArray[num / 10].insert(value);
			}

			// removes current flags and inserts it back at the end for the next rounds use.
			QArray[i].insert(-1);
		
		}

		//display
		for (int i =0; i<QArray.length; i++)
			QArray[i].displayQueue();	

		System.out.println("\n");

		// third round
		for (int i = 0; i < QArray.length; i++) {
			while (!QArray[i].isEmpty()) {
				int value = QArray[i].remove();
				if (value == -1)
					continue;
				QArray[value / 100].insert(value);
			}	
		}

		for (int i=0; i<QArray.length; i++)
			QArray[i].displayQueue();	
	
		System.out.println("\n");
	}


}























