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
		}

		// Declaration of QArray with size 10
		LinkQueue[] QArray = new LinkQueue[10];
		for (int i = 0; i < QArray.length; i++) {
			QArray[i] = new LinkQueue();
		}

		// Iterate over dataArray
		// Add numbers to their proper queue by basing it off of their 
		// individual digit.
        for (int j : dataArray) {
            QArray[j % 10].insert(j);
        }
		
			

		// add flag to populated arrays
        for (LinkQueue linkQueue : QArray) {
            if (!linkQueue.isEmpty()) {
                linkQueue.insert(-1);
            }
            linkQueue.displayQueue();
        }

		System.out.println("\n");

		// second round of sorting.
        for (int i = 0; i < QArray.length; i++) {
            LinkQueue queue = QArray[i];
            while (!queue.isEmpty()) {
                int value = queue.remove();

                if (value == -1) {
                    break;
                }

                int num = value % 100;
                int index = num / 10;
				// add flag if it gets added to an unpopulated queue ahead of the current one, otherwise infinite loop
                if (QArray[index].isEmpty() && index > i) {
                    QArray[index].insert(-1);
                    QArray[index].insert(value);
                } else {
                    QArray[index].insert(value);
                }
            }


        }

		// add flag to populated arrays
        for (LinkQueue linkQueue : QArray) {
            if (!linkQueue.isEmpty()) {
                linkQueue.insert(-1);
            }
            linkQueue.displayQueue();
        }

		System.out.println("\n");

		// third round
        for (int i = 0; i < QArray.length; i++) {
            LinkQueue linkQueue = QArray[i];

            while (!linkQueue.isEmpty()) {
                int value = linkQueue.remove();

                if (value == -1) {
                    break;
                } else {
                    int index = value / 100;
                    if (QArray[index].isEmpty() && index > i) {
                        QArray[index].insert(-1);
                        QArray[index].insert(value);
                    } else {
                        QArray[index].insert(value);
                    }
                }
            }
        }

        for (LinkQueue linkQueue : QArray) linkQueue.displayQueue();
	
		System.out.println("\n");

		int i = 0;
		for (LinkQueue queue : QArray) {
			while (!queue.isEmpty()) {
				int data = queue.remove();
				dataArray[i] = data;
				System.out.println(dataArray[i++]); // i didnt want 
			}
		}

		//for (int data : dataArray) System.out.println(data);
	}


	void recursiveLoop(boolean isSecondRound, int count, LinkQueue[] queue) {
		
		if (isSecondRound) {
			
		}
	

		if (count == 0) {
			return;
		}

		recursiveLoop(count - 1);
	}
}























