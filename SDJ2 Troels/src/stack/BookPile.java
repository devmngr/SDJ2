package stack;

import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

import util.Cin;

public class BookPile {
	private ArrayStack<Book> bookPile;

	public BookPile() {
		bookPile = new ArrayStack<Book>();
	}

	public void addBook(Book book) {
		bookPile.push(book);
	}

	public Book peekBook() {
		return bookPile.peek();
	}
	public Book popBook()
	{
		return bookPile.pop();
	}
	public boolean isBookPileEmpty()
	{
		return bookPile.isEmpty();
	}
	public int getNumberOfBooks()
	{
		return bookPile.size();
	}

	public String toString() {
		return bookPile.toString();
	}

	public static void main(String[] args) {

		BookPile bookStack = new BookPile();

		int choice;

		do {
			menu();
			choice = Cin.readInt();

			switch (choice) {

			case 1:
				System.out.println("\nAdd Book");

				System.out.println("Book \nTitle: ");
				String title = Cin.readString();
				System.out.println("Year: ");
				int year = Cin.readInt();

				System.out.println("Author \nFirst name: ");
				String firstName = Cin.readString();
				System.out.println("Last name: ");
				String lastName = Cin.readString();

				Author author = new Author(firstName, lastName);
				Book book = new Book(title, author, year);
				bookStack.addBook(book);

				System.out.println("\nDone!");
				System.out.println(book);

				System.out.println();
				System.out.println(bookStack);

				break;

			case 2:
				System.out.println();
				System.out.println("Last Book in stack: "
						+ bookStack.peekBook().getTitle());

				break;
				
			case 3:
				System.out.println();
				System.out.println(bookStack.popBook());
				System.out.println();
				break;
				
			case 4:
				System.out.println();
				System.out.println("Empty: " + bookStack.isBookPileEmpty());
				System.out.println();
				break;

			case 5:
				System.out.println();
				System.out.println("NR of Books: " + bookStack.getNumberOfBooks());
				System.out.println();
				break;
			}

		} while (choice > 0);
		System.out.println("** End **");

	}
	private static void menu() {
		System.out.println(" MENU");
		System.out.println(" 1) Add a book onto the stack");
		System.out
				.println(" 2) See the title of the book at the top of the stack");
		System.out
				.println(" 3) Get and remove the book at the top of the stack");
		System.out.println(" 4) Check if the stack is empty");
		System.out.println(" 5) Get the number of books in the stack");
		System.out.println(" 0) Quit");
		System.out.print(" Type your choice: ");
	}
}
