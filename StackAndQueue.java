import java.util.*;

/*
 * This example uses a stack and a queue
 * Ultimately, it checks a word to see if it's a palindrone
 * (ie. returns a boolean)
 */

public class StackAndQueue {
	Stack<String> myStack = new Stack();
	LinkedList<String> myQueue = new LinkedList();
	
	public static void main(String[] args) {
		
		StackAndQueue mySQ = new StackAndQueue();
		mySQ.begin();		
	}
	
	void begin() {
		String word;
		
		// Get word from user
		Scanner s = new Scanner();
		word = s.next("Please enter a word: ");
		
		// place word in queue, stack
		for(char c : word) {
			myStack.push(c);
			myQueue.add(c);
		}
		
		// get char for comparison
		
		
		
	}

}
