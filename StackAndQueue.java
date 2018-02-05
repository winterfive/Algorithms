import java.util.*;

/*
 * This example uses a stack and a queue
 * Ultimately, it checks a word to see if it's a palindrone
 * (ie. returns a boolean)
 */

public class StackAndQueue {
	Stack<Character> myStack = new Stack();
	LinkedList<Character> myQueue = new LinkedList();
	
	public static void main(String[] args) {
		
		StackAndQueue mySQ = new StackAndQueue();
		mySQ.begin();		
	}
	
	void begin() {
		
		// Get word from user
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter a word: ");
		String word = s.nextLine();
		s.close();
		
		char[] myArray = word.toCharArray();
		
		
		// place word in queue, stack
		for(char c : myArray) {
			myStack.push(c);
			myQueue.add(c);
		}
		
		// get char for comparison
		for(char c : myArray) {
			if(myStack.pop() != myQueue.remove()) {
				System.out.println("Your word is not a palindrone");
				break;
			}
		}
		System.out.println("Your word is a palindrone.");		
	}

}
