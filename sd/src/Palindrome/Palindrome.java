package Palindrome;

import genclass.GenericIO;

public class Palindrome {

	public static void main(String[] args) {
		
		// read string from keyboard
		GenericIO.writelnString("Input: ");
		String s = GenericIO.readlnString();
		
		
		// fill fifo and stack
		MemStack<Character> stack = new MemStack<Character>(s.length());
		MemFIFO<Character> fifo = new MemFIFO<Character>(s.length());
		
		try {
			for (int i = 0; i < s.length(); i++) {
				stack.write(new Character(s.charAt(i)));
				fifo.write(new Character(s.charAt(i)));
			}
			
		} catch (MemException e) {
			printErrorMessage(e);
			System.exit(1);
		}
		
		// check if characters match
		try {
			for(int i = 0; i < s.length(); i++) {
				char stack_char = stack.read().charValue();
				char fifo_char = fifo.read().charValue();
				
				if (stack_char != fifo_char) {
					GenericIO.writelnString("Not a palindrome!");
					return;
				}
			}
			
			// palindrome found
			GenericIO.writelnString(s, " is a palindrome!");
			
		} catch (MemException e) {
			printErrorMessage(e);
			System.exit(1);
		}
	}
	
	private static void printErrorMessage(MemException e) {
		GenericIO.writelnString("Error: ", e.getMessage());
		GenericIO.writelnString("Error: ", e.toString());
		e.printStackTrace();
	}

}
