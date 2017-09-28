package linkedSet;

public class ArraySetMain {

	public static void main(String[] args) {
		ArraySet<String> set = new ArraySet<String>(true);
		set.add("x");
		set.add("y");
		set.add("z");
		set.add("q");
	
		
		ArraySet<String> set2 = new ArraySet<String>(true);
		set2.add("A");
		set2.add("B");
		set2.add("C");
		set2.add("D");
		set2.add("E");
		set2.add("F");
		
		
		
		System.out.println("Set\n"+set);
		System.out.println("Set2\n"+set2);
		/*System.out.println("Intersection setwith set2\n"+set.intersection(set2));
		System.out.println("set subset of set2\n"+set.isSubset(set2));
		System.out.println("set2 subset of set\n"+set2.isSubset(set));
		*/
		System.out.println("Union set+set2\n"+set.union(set2));
	}

}
