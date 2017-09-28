package stack;

public class Test {

	public static <T> void main(String[] args) {

		ArrayStack<String> stack = new ArrayStack<>(5);
		String el = "1";
		String el1 = "2";
		String el2 = "3";
		String el3 = "4";
		String el4 = "5";
		String el5 = "6";
		String el6 = "7";

		stack.push(el);
		stack.push(el1);
		stack.push(el2);
	//	stack.push(el3);
		//stack.push(el4);
		//stack.push(el5);

		System.out.println(stack);
		System.out.println(stack.capacity());
		stack.push(el3);
		stack.push(el4);
		stack.push(el5);
		System.out.println(stack);
		System.out.print(stack.capacity());
		/*
		 * BoundedArrayStack<T> arrayStack = new BoundedArrayStack<T>(6);
		 * 
		 * T el = (T) "1"; T el1 = (T) "2"; T el2= (T) "3"; T el3 = (T) "4"; T
		 * el4 = (T) "5"; T el5 = (T) "6"; T el6 = (T) "7";
		 * 
		 * arrayStack.push(el); arrayStack.push(el1); arrayStack.push(el2);
		 * arrayStack.push(el3); arrayStack.push(el4); arrayStack.push(el5);
		 * //arrayStack.push(el6);
		 * 
		 * System.out.println("arr \n" + arrayStack.indexOf(el2));
		 * //System.out.println("arr \n" + arrayStack.pop());
		 * 
		 * 
		 * /*Element element1 = new Element("EL1"); Element element2 = new
		 * Element("EL2"); Element element3 = new Element("EL3"); Element
		 * element4 = new Element("EL4"); Element element5 = new Element("EL5");
		 * Element element6 = new Element("EL6");
		 * 
		 * arrayStack.push(element1);
		 */

	}

}
