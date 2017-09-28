package linkedList;

public class TestArrayListMAIN {
sdasdasdas
	public static void main(String[] args) {

		ArrayList<String> arr = new ArrayList<String>(true);
		System.out.println(arr.size());
		arr.add("A");
		arr.add("B");
		arr.add("C");

		System.out.println("ARR: " + arr);
		System.out.println("Size: " + arr.size());
		//System.out.println("index of B: "+ arr.indexOf("B"));
		//System.out.println("arr contains 'B': "+ arr.contains("B"));

		System.out.println("Be:   "+ arr.get(2));
		arr.remove(2);
		System.out.println("AF:   "+ arr.get(2));
		
		System.out.println("ARR: " + arr);
		System.out.println("Size: " + arr.size());
	}

}
