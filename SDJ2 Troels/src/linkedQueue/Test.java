package linkedQueue;

import linkedList.LinearNode;

public class Test {

	public static void main(String[] args) {
		
		LinkedQueue<String> linkedQueue = new LinkedQueue<String>(false);
		
		linkedQueue.enqueue("A");
		linkedQueue.enqueue("B");
		
		System.out.println(linkedQueue);
	}

}
