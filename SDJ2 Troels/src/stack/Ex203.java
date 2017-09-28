package stack;

import util.Cin;

public class Ex203 {

	public static void main(String[] args) {
		System.out.println("Enter a string: ");
		String one = Cin.readString();
		
		ArrayStack<Character> chars = new ArrayStack<Character>();
		
		for (int i = 0; i < one.length(); i++) {
			chars.push(one.charAt(i));
			
		}
		System.out.println(chars);
		
		
	}

}
