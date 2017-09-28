package stack;

import java.lang.reflect.Array;

import util.Cin;

public class bracesAndChar {
	private ArrayStack<Character> chars;

	public bracesAndChar() {
		chars = new ArrayStack<Character>();
	}

	public void pushElement(char element) {
		chars.push(element);
	}

	public char popElement() {
		return chars.pop();
	}

	public char peekElement() {
		return chars.peek();
	}

	public boolean equals(char element) {
		return peekElement() == element;
	}

	public String toString() {
		return chars.toString();
	}

	public static void main(String[] args) throws Exception {

		bracesAndChar chars = new bracesAndChar();
		char[] left = { '{', '[', '(' };
		char[] right = { ')', ']', '}' };
		char ch;
		boolean found = false;

		chars.pushElement('(');
		chars.pushElement('[');
		chars.pushElement('[');
		chars.pushElement('{');
		chars.pushElement('(');
		chars.pushElement('{');
System.out.println(chars);
		System.out.println("Enter one of this characters");
		System.out.println(arrayAsString(left) + "\t" + arrayAsString(right));
		ch = Cin.readChar();

		for (int i = 0; i < left.length; i++) {
			if (ch == left[i]) {

				chars.pushElement(ch);
				System.out.println("pushed to the stack");
				found = true;
			} else if (ch == right[i]) {
				found = true;
				if (ch == chars.peekElement()) {
					chars.popElement();
					System.out.println(ch
							+ "EQUAL to last element in the stack \n last element was popped from the stack");
					
				} else
					chars.popElement();
					System.out
							.println("NOT EQUAL to last element in the stack \n last element was popped from the stack");
				
			}
		}
		System.out.println(chars);
		if (found != true) {
			System.out.println("Character not valid! TRY AGAIN!");
			
		}

	}



	public static String arrayAsString(char[] arr) {
		String str = "";
		for (int i = 0; i < arr.length; i++) {
			str += arr[i];
			if (i < arr.length - 1) {
				str += "\t";
			}
		}
		return str;
	}

}
