package linkedList;

public class Test {

	public static void main(String[] args) {
	
		LinkedList<String> list = new LinkedList<String>(true);
		
	
		list.add("$A$");

		 
		 list.add(1, "$B$");
	      list.add(0, "$C$");
	      list.add(2, "$D$");
	      list.set(2, "$X$");
	      list.set(2, "$Y$");
	      System.out.println(list);
	      
	      list.remove(0);
	      System.out.println(list);
	      list.remove("$Y$");
	      System.out.println(list.get(0));
	      
	      
	      
	}	

}
