package queue;

public class Test {

	public static  void main(String[] args) {
		BoundedArrayQueue<String> queue = new BoundedArrayQueue<String>(5);
		
		String el =  "1";
		String el1 = "2";
		String el2= "3";
		String el3 =  "4";
		String el4 =  "5";
		String el5 =  "6";
		String el6 = "7";
		//System.out.println(queue.isEmpty());
		
		
		queue.enqueue("X");
		queue.enqueue("y");
		queue.enqueue("z");
		queue.enqueue("e");
		
		System.out.println(queue);

		
		queue.dequeue();
		queue.dequeue();
		System.out.println(queue);
	}

}
