package com.LeeGainer.arrayStructures;
/*
 * Writing out some of the built in array methods.
 * Magic numbers are used as I am not using any of the
 * built in methods (setInt, getInt, newInstance, etc).
 */

public class ArrayStructure {
	
	private int[] theArray = new int[50];
	private int arraySize = 10;
	
	/*
	 * Generate an array of random ints
	 * void -> void
	 */	
	public void generateRandomArray() {
		for(int i = 0; i < arraySize; i++) {
			theArray[i] = (int)(Math.random()* 10) + 10;
		}
	}
	
	/*
	 * Print array within a frame of pipes
	 * void -> void
	 */	
	public void printArray() {
		System.out.println("---------");
		for(int i = 0; i < arraySize; i++) {
			System.out.print("| " + i + " | ");
			System.out.println(theArray[i] + " |");
			System.out.println("---------");
		}
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
		
		System.out.println("The value was found in the following: ");
		
		for(int i = 0; i < arraySize; i++) {
			if(theArray[i] == value) {
				valueInArray = true;
				System.out.println(i + " ");
				indexesWithValue+= i + " ";
			}
		}
		if(!valueInArray) {
			indexesWithValue = "None";
			System.out.println(indexesWithValue);		
		}		
		System.out.println();
		return indexesWithValue;
	}
	
	
	
	public static void main(String[] args) {
		
		ArrayStructure myArray = new ArrayStructure();
		
		myArray.generateRandomArray();
		
		myArray.printArray();
		
		System.out.println(myArray.getElementAtIndex(3));
		
		System.out.println(myArray.doesArrayContain(33));
		
		myArray.deleteElementInArray(7);
		
		myArray.printArray();
		
		myArray.insertElementAtEnd(45);
		
		myArray.printArray();
		
		String indexList = myArray.linearSearchforValue(9);
		System.out.println(indexList);		
	}

}
