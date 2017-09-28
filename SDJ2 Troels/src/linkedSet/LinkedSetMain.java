package linkedSet;

public class LinkedSetMain {

	public static void main(String[] args) {

		LinkedSet<String> set = new LinkedSet<>(false);

		set.add("A");
		set.add("B");
		set.add("C");
		set.add("D");

		LinkedSet<String> set2 = new LinkedSet<>(false);
		set2.add("q");
		set2.add("w");
		set2.add("e");
		set2.add("r");
		set2.add("t");
		set2.add("A");
		set2.add("D");
		
		LinkedSet<String> set3 = new LinkedSet<>(true);
		set3.add("q");
		set3.add("w");
		set3.add("e");

		
		System.out.println("Set\n"+ set);
		System.out.println("Set3\n"+set2);

		System.out.println("Union set+set3\n" + set2.union(set) );
		System.out.println("Set3 subset of Set2: "+set3.isSubset(set2));
		System.out.println("Set2 subset of Set3: "+set2.isSubset(set3));
		
		
		
	/*	
	  OK!!!
	  	System.out.println("Set1: "+set);
		System.out.println("Set2: "+set2);
		System.out.println("Set3: " +set3);
		System.out.println("Set1 intersecting Set2: " + set.intersection(set2));
		System.out.println("Set2 intersecting Set1: " + set2.intersection(set));
		System.out.println("Set3 subset of Set2: "+set3.isSubset(set2));
		System.out.println("Set2 subset of Set3: "+set2.isSubset(set3));
		*/	
	}
}
