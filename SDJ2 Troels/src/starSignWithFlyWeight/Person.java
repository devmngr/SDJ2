package starSignWithFlyWeight;

public class Person {
	private String name;
	private StarSign starSign;

	public Person(String name, String starSign) {
		this.name = name;
		this.starSign = StarSignFactory.getStarSign(starSign);
	}

	public String getName() {
		return name;
	}

	public StarSign getStarSign() {
		return starSign;
	}

	public String toString() {
		return "Name: " + name;
	}
}
