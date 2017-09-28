package singleton;

import java.sql.ResultSet;
import java.sql.SQLException;

import adaptor.Adaptor;
import model.Employee;


/** A class that checks correct credentials of  User Username and Password
 * @author Alexandru
 *
 */
public class Login {
	private static Login singleton;
	
	/**
	 * No-argument constructor 
	 */
	private Login(){
	}
	
	public synchronized static Login getInstance(){
		if(singleton == null) {
			singleton = new Login();
	      }
	      return singleton;
	}
	
	
	/**	Method that compares UserName and Password with the list 
	 * @param checkUser
	 * 			checkUser of username
	 * @param checkPassword
	 * 			checkPassword of password
	 * @return
	 * 		Either manager or employee
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static String CheckEmployeeLogin(String checkUser, String checkPassword)throws  SQLException, ClassNotFoundException {
		Adaptor<Employee> emp= new Adaptor<Employee>();
		ResultSet rs = emp.getAll("employee");
		String username = "", password = "", mngrSSN="", ssn="";
		
		while (rs.next()) {
			ssn = rs.getString(1);
			mngrSSN = rs.getString(4);
			username = rs.getString(5);
			password = rs.getString(6);
			
			if(checkUser.equals(username)&&checkPassword.equals(password)){
				if(mngrSSN.equals(ssn))
					return "manager";
				else return "employee"; 
			}
		}
		return "denied";
		
}
	
}
