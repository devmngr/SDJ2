package linkedStack;

public class test {

	public static void main(String[] args) {
		
		LinkedStack<String> link = new LinkedStack<>(false);
		
		String str = "AAA";
		link.push(str);
		link.push("ABC");
		link.size();
		System.out.println(link.indexOf("ABC"));
		
	}

}
