package arrayStructures;
/*
 * Writing out some of the built in array methods.
 * Magic numbers are used as I am not using any of the
 * built in methods (setInt, getInt, newInstance, etc).
 */

public class ArrayStructure {
	
	// Fields w/ magic numbers
	private int[] theArray = new int[50];
	private int arraySize = 10;
	
	/*
	 * Generate an array of random ints
	 * void -> void
	 */				     
	public void generateRandomArray() {
		for(int i = 0; i < arraySize; i++) {
			theArray[i] = (int)(Math.random()* 30) + 1;
		}
	}
	
	/*
	 * Print array horizontally within a frame of pipes
	 * void -> void
	 */	
	public void printArray() {
		// print elements
		for(int i = 0; i < arraySize; i++) {
			if(theArray[i] < 10) {
				System.out.print("|  " + theArray[i] + " ");
			} else {
				System.out.print("| " + theArray[i] + " ");
			}			
		}
		System.out.print("|\n");
		// print indexes
		for(int i = 0; i < arraySize; i++) {
			System.out.print("|  " + i + " ");
		}
		System.out.println("|\n");		
	}
		
	/*
	 * Return element found at index
	 * int -> int
	 */	
	public int getElementAtIndex(int i) {
		int x = 0;
		if(i < arraySize) {
			x = theArray[i];		
		}
		return x;		
	}
	
	/*
	 * Checks if array contains value
	 * int -> boolean
	 */	
	public boolean doesArrayContain(int i) {
		boolean inArray = false;
		for(int x = 0; x < arraySize; x++) {
			if(theArray[x] == i) {
				inArray = true;
			}
		}
		return inArray;		
	}
	
	/*
	 * Deletes an element and moves all
	 * elements behind that element up
	 * int -> void
	 */	
	public void deleteElementInArray(int index) {
		if(index < arraySize) {
			for(int i = index; i < arraySize - 1; i++) {
				theArray[i] = theArray[i + 1];
			}			
		}
		arraySize--;
	}
	
	/*
	 * Insert new element at the end of the array
	 * int -> void
	 */	
	public void insertElementAtEnd(int value) {
		if(arraySize < 50) {
			theArray[arraySize] = value;
			arraySize++;	
		}
	}
	
	/*
	 * Linear Search
     * Checks every element in array agaisnt the value
	 * int -> String
	 */	
	public String linearSearchforValue(int value) {
		boolean valueInArray = false;		
		String indexesWithValue = "";
		
		for(int i = 0; i < arraySize; i++) {
			if(theArray[i] == value) {
				valueInArray = true;
				indexesWithValue += i + " ";
			}
		}
		if(!valueInArray) {
			indexesWithValue = "not found";
		}		
		return indexesWithValue;
	}
	
	/*
	 * Bubble Sort, ascending
	 * int -> void
	 */
	public int bubbleSort() {
		int swaps = 0;
        int totalSwaps = 0;
       
        for(int i = 0; i < arraySize; i++) {
            swaps = 0;
            for(int j = 0; j < arraySize - 1; j++) {
                if(theArray[j] > theArray[j+1]) {
                    // swap indexes
                    swap(j, j+1);
                    swaps++;
                }            
            }            
            totalSwaps += swaps; 
            
            if(swaps == 0) {
            		break;
            }
        }
		return totalSwaps;
	}
	
	/*
	 * Bubble Sort, descending
	 * int -> void
	 */
	public int bubbleSortDescending() {
		int swaps = 0;
        int totalSwaps = 0;
       
        for(int i = 0; i < arraySize; i++) {
            swaps = 0;
            for(int j = 0; j < arraySize - 1; j++) {
                if(theArray[j] < theArray[j+1]) {
                    // swap indexes
                    swap(j, j+1);
                    swaps++;
                }            
            }            
            totalSwaps += swaps; 
            
            if(swaps == 0) {
            		break;
            }
        }
		return totalSwaps;
	}
	
	/*
	 * Swap array elements
	 * int, int -> void
	 */	
	public void swap(int x, int y) {
		int temp = theArray[x];
		theArray[x] = theArray[y];
		theArray[y] = temp;
	}
	
	/*
	 * Binary search for value
	 * the CS50 "Phonebook search"
	 * int -> void
	 */
	public void binarySearchForValue(int value) {
		int lowIndex = 0;
		int highIndex = arraySize - 1;
		int midIndex = 0;
		
		while(lowIndex <= highIndex) {
			midIndex = lowIndex + (highIndex - lowIndex) / 2;
			if(value == theArray[midIndex]) {
				break;
			}
			// Limit search to left side of array
			else if(value < theArray[midIndex]) {
				highIndex = midIndex - 1;
			}
			// Limit search to right side of array
			else {
				lowIndex = midIndex + 1;
			}
		}
		
		if(theArray[midIndex] == value) {
			System.out.println("Binary Search: " + value + " was found at index" + midIndex + ".");
		} else {
			System.out.println("Binary Search: " + value + " was not found in the array.");
		}
	}
	
	/*
	 * Selection Sort
	 * void -> void
	 */	
	public void selectionSort() {
		for(int i = 0; i < arraySize; i++) {
			int min = i;
			for(int j = i; j < arraySize; j++) {
				if(theArray[min] > theArray[j]) {
					min = j;
				}
			}
			swap(i, min);
		}		
	}
	
	/*
	 * Insertion Sort
	 * the CS50 "exam booklets" sort
	 * void -> void
	 */
	public void insertionSort() {
		// i = 1 because theArray[i] is already sorted
		// sorted: item is higher then all items to its left
		for(int i = 1; i < arraySize; i++) {
			
			// j is the iterator inside the while loop
			int j = i;
			
			// key hold s a value outside the array
			int key = theArray[i];
			
			while(j > 0 && theArray[j - 1] > key) {
				// change elements in array
				theArray[j] = theArray[j - 1];
				theArray[j - 1] = key;
				j--;
			}			
		}
	}	
	
	
	public static void main(String[] args) {
		
		ArrayStructure myArray = new ArrayStructure();
		
		myArray.generateRandomArray();
		System.out.println("Generate array of random numbers.");
		myArray.printArray();
		
		System.out.println("The element at index 3 is " + myArray.getElementAtIndex(3) + ".\n");
		
		System.out.println("Does the array contain 14: " + myArray.doesArrayContain(14) + "\n");
		
		System.out.println("Delete element at index 7.");
		myArray.deleteElementInArray(7);		
		myArray.printArray();
		
		System.out.println("Insert 44 at end of array.");		
		myArray.insertElementAtEnd(44);		
		myArray.printArray();
		
		String indexList = myArray.linearSearchforValue(19);
		if(indexList.contains("not found")) {
			System.out.println("The value 19 was not found.\n");
		} else {
			System.out.print("Linear Search: the value 19 was found at index(es): " + indexList + "\n\n");	
		}
		
		System.out.println("Bubble Sort, descending");
		int totalSwaps = myArray.bubbleSortDescending();
		myArray.printArray();
		System.out.println("Total number of swaps: " + totalSwaps + "\n");
		
		System.out.println("Bubble Sort, ascending");
		totalSwaps = myArray.bubbleSort();
		myArray.printArray();
		System.out.println("Total number of swaps: " + totalSwaps + "\n");		
		
		myArray.binarySearchForValue(14);
		myArray.printArray();
		
		// Create a new unsorted array object for the following sort examples
		ArrayStructure secondArray = new ArrayStructure();
		secondArray.generateRandomArray();
		
		System.out.println("Selection Sort with new array");
		secondArray.selectionSort();
		secondArray.printArray();
		
		System.out.println("Insertion Sort with a new array");
		// Create a new unsorted array object for insertion sort example
		ArrayStructure thirdArray = new ArrayStructure();
		thirdArray.generateRandomArray();
		thirdArray.insertionSort();
		thirdArray.printArray();
	}
}
