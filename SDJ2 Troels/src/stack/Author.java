package stack;

public class Author {

	private String firstName;
	private String lastName;
	
	public Author(String firstName, String lastname)
	{
		this.firstName=firstName;
		this.lastName=lastname;
	}
	public String getName()
	
	{
		return firstName +" " + lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String toString()
	{
		return firstName + " " + lastName;
	}
}
