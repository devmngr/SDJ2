package stack;

import util.Cin;

public class Ex202 {

	public static void main(String[] args) {

		
		
		System.out.println("Enter a string: ");
		String one = Cin.readString();
		System.out.println("One more:");
		String two = Cin.readString();
		System.out.println("Last:");
		String three = Cin.readString();
		
		ArrayStack<String> strings = new ArrayStack<String>();
		strings.push(one);
		strings.push(two);
		strings.push(three);
		
		System.out.println("The entered strings in reverced order\n" + strings );
		
		
		
	}

}
