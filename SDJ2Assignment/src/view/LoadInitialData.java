package view;

import java.util.Date;

import controller.BookingController;
import model.Booking;
import model.BookingManager;
import model.Customer;
import model.FamilyCar;
import model.MovingTruck;
import model.Van;
import model.Vehicle;

public class LoadInitialData {
	private BookingController controller;
	public LoadInitialData(BookingController controller)
	{
		this.controller = controller;
		
		Vehicle car1 = new FamilyCar("VW", "Passat", 500, "AA0001");
		Vehicle car2 = new FamilyCar("Audi", "A4", 600, "BB0002");
		Vehicle car3 = new Van("Skoda", "Superb", 400, "CC0003", 3500, false);
		Vehicle car4 = new MovingTruck("Toyota", "Aygo", 200, "DD0004", "24 Tons", 1000);
		Vehicle car5 = new FamilyCar("Fiat", "Punto", 250, "EE0005");
		
		
		Customer customer1 = new Customer("Allan", 123, 24, 222222, 123456, "ArhusC", "@gmai.com");
		Customer customer2 = new Customer("Bolt", 1234, 24, 222222, 123456, "Vejle", "@mail.com");
		Customer customer3 = new Customer("Colin", 12345, 24, 222222, 123456, "Horsens", "@via.com");
		Customer customer4 = new Customer("Daniel", 123456, 24, 222222, 123456, "Aalborg", "@yahoo.com");
		Customer customer5 = new Customer("Ellie", 1234567, 24, 222222, 123456, "Skagen", "@msn.com");
		
		Date p1 = new Date(2016, 1, 1);
		Date p2 = new Date(2016, 2, 2);
		Date p3 = new Date(2016, 3, 3);
		Date p4 = new Date(2016, 4, 4);
		Date p5 = new Date(2016, 5, 5);
		
		
		Date d1 = new Date(2016, 6, 6);
		Date d2 = new Date(2016, 7, 7);
		Date d3 = new Date(2016, 8, 8);
		Date d4 = new Date(2016, 9, 9);
		Date d5 = new Date(2016, 10, 10);
		
		
		String pk1 = "School";
		String pk2 = "Church";
		String pk3 = "Supermarket";
		String pk4 = "Trainstation";
		String pk5 = "Airport";
		
		
		String dr1 = "Supermarket";
		String dr2 = "Airport";
		String dr3 = "Trainstation";
		String dr4 = "Church";
		String dr5 = "School";
		
		
		
		Booking b1 = new Booking(customer1, 1000, p1, d1, pk1, dr1, car1);
		Booking b2 = new Booking(customer2, 2000, p2, d2, pk2, dr2, car2);
		Booking b3 = new Booking(customer3, 3000, p3, d3, pk3, dr3, car3);
		Booking b4 = new Booking(customer4, 4000, p4, d4, pk4, dr4, car4);
		Booking b5 = new Booking(customer5, 5000, p5, d5, pk5, dr5, car5);
		
		
		controller.addBooking(b1);
		controller.addBooking(b2);
		controller.addBooking(b3);
		controller.addBooking(b4);
		controller.addBooking(b5);
	}
	
}
