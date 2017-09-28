package stack;

public class Book {

	
	private String title;
	private int year;
	private Author author;
	
	public Book(String title,Author author, int year) {
		this.title=title;
		this.author = author;
		this.year= year;
	}
	
	public String getTitle() {
		return title;
	}
	public int getYear() {
		return year;
	}
	public Author getAuthor() {
		return author;
	}
	
	public String toString()
	{
		return title + ", " +year + ", " + author;
	}
	
	
}
