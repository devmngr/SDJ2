package adaptor;

import java.io.ObjectInputStream.GetField;
import java.rmi.RemoteException;
import java.rmi.server.ServerCloneException;
import java.sql.SQLException;
import java.util.ArrayList;

import rmi.RmiClient;
import rmi.RmiServer;
import rmi.ServerInterface;
import model.Employee;
import model.Location;
import model.ModelManager;
import model.Part;

/** Class made for testing methods and objects
 * @author Bogdan
 *
 */
public class tst {
	public static void main(String[] args) throws ClassNotFoundException,
			SQLException, RemoteException {

		//Adaptor<Employee> employeessss = new Adaptor<Employee>();
		
		Employee emp2 = new Employee("BOG", 123456, 298, 123456, "usr", "pss");	
		
	
		//employeessss.insert(emp);
	//	employeessss.remove(emp);
		//employeessss.update(emp2);
		
		//Adaptor<Part> partssss = new Adaptor<Part>();

		//Part part = new Part(1, "a", "a", "a", "a", 1,1,1);
		//Part part = new Part(10, "NAme", "x", "z", "cat", 30,2,2);
		Part part = new Part(100, "zzzz", "a", "a", "a", 39, 6, 6);
		//part.setNrOfParts(30);
		//partssss.update(part);
		//System.out.println(part);
		//partssss.remove(part);
		/*try {
			partssss.insert(part);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	*/
		
		
		//Adaptor<Location> locationsssss = new Adaptor<Location>();
		//Location loc = new Location(1, 1);
		//locationsssss.updateLocations();
		//Location loc = new Location(1, 1, );
		//locationsssss.insert(loc);
		//locationsssss.updateLocation(loc);
	//	System.out.println(locationsssss.remove(loc));
		//System.out.println(partssss.getPartAtLocation(loc));
		//System.out.println(employeessss.getEmployeeByUsername("usr"));
		
		//System.out.println(employeessss.getAll("part"));
		//System.out.println(employeessss.getAllAAAAAAA("part"));
		
		ModelManager mngr = new ModelManager();
		
		//System.out.println(mngr.getAllLocations());

		System.out.println(part);
		
		
	}
}
