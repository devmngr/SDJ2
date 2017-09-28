package starSignWithFlyWeight;

public class TestOfStarSign {

	public static void main(String[] args) {
		String[] legalStarSignNames = StarSign.LEGAL_NAMES;
		System.out.println("Leagal star sign names:");
		for (int i=0; i<legalStarSignNames.length; i++)
		System.out.println(legalStarSignNames[i]);
		System.out.println();
		Person[] list = new Person[10];
		list[0] = new Person("Allan","Leo");
		list[1] = new Person("Bob", "Scorpio");
		list[2] = new Person("Carl", "Leo");
		list[3] = new Person("Dennis", "Saggitarius");
		list[4] = new Person("Eric", "Leo");
		list[5] = new Person("Franc","Leo");
		list[6] = new Person("Graham", "Sagittarius");
		list[7] = new Person("Hans", "Leo");
		list[8] = new Person("Igor","Virgo");
		list[9] = new Person("Jens", (legalStarSignNames[8]));
		System.out.println("Person objects:");
		for (int i=0; i< list.length; i++)
		{
		System.out.printf("%-40s %d\n", list[i],list[i].getStarSign().hashCode());
		}
	}

}
