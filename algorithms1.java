package com.LeeGainer.arrayStructures;
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
			theArray[i] = (int)(Math.random()* 20) + 1;
		}
	}
	
	/*
	 * Print array horizontally within a frame of pipes
	 * void -> void
	 */	
	public void printArray() {
		for(int i = 0; i < arraySize; i++) {
			if(theArray[i] < 10) {
				System.out.print("|  " + theArray[i] + " ");
			} else {
				System.out.print("| " + theArray[i] + " ");
			}			
		}
		System.out.print("|\n");
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
			x = theArray[i];		}
		return x;		
	}
	
	/*
	 * Checks array for value
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
	 * int -> String
	 */	
	public String linearSearchforValue(int value) {
		boolean valueInArray = false;		
		String indexesWithValue = "";
		
		for(int i = 0; i < arraySize; i++) {
			if(theArray[i] == value) {
				valueInArray = true;
				indexesWithValue+= i + " ";
			}
		}
		if(!valueInArray) {
			indexesWithValue = "not found";
		}		
		return indexesWithValue;
	}
	
	/*
	 * Bubble Sort, ascending
	 * void -> void
	 */
	public void bubbleSort() {
		for(int i = arraySize - 1; i >= 1; i--) {
			for(int j = 0; j < i; j++) {
				if(theArray[j] > theArray[j + 1]) {
					swap(j, j + 1);					
				}
			}
		}
	}
	
	/*
	 * Bubble Sort, descending
	 * void -> void
	 */
	public void bubbleSortDescending() {
		for(int i = arraySize - 1; i >= 1; i--) {
			for(int j = 0; j < i; j++) {
				if(theArray[j] < theArray[j + 1]) {
					swap(j, j + 1);					
				}
			}
		}
	}
	
	/*
	 * Swap values at 2 indexes
	 * int, int -> void
	 */	
	public void swap(int index1, int index2) {
		int swap = theArray[index1];
		theArray[index1] = theArray[index2];
		theArray[index2] = swap;
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
			if(value > theArray[midIndex]) {
				lowIndex = midIndex + 1;
			}
			else if(value < theArray[midIndex]) {
				highIndex = midIndex - 1;				
			} 
			else {				
				lowIndex = highIndex + 1;
			}
		}
		if(theArray[midIndex] == value) {
			System.out.println("Binary Search: found a match for " + value + " at index " + midIndex + ".");
		} else {
			System.out.println("Binary Search: " + value + " was not found in the array.");
		}
	}
	
	/*
	 * Selection Sort
	 * the CS50 "filing papers" sort
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
		
		System.out.println("Bubble Sort, ascending");
		myArray.bubbleSort();
		myArray.printArray();
		
		System.out.println("Bubble Sort, descending");
		myArray.bubbleSortDescending();
		myArray.printArray();
		
		// Create a new unsorted array object following sort examples
		ArrayStructure secondArray = new ArrayStructure();
		secondArray.generateRandomArray();
		
		secondArray.binarySearchForValue(14);
		secondArray.printArray();
		
		System.out.println("Selection Sort");
		secondArray.selectionSort();
		secondArray.printArray();
	}
}
