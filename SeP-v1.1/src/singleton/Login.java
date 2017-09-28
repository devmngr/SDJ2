package singleton;
import java.sql.ResultSet;
import java.sql.SQLException;
import adaptor.Adaptor;
import model.Employee;

public class Login {

	private Login() {
	}
	
	public synchronized static String CheckEmployeeLogin(String checkUser,
			String checkPassword) throws SQLException, ClassNotFoundException {
		Adaptor<Employee> emp = new Adaptor<Employee>();
		ResultSet rs = emp.getAll("employee");
		String username = "", password = "", mngrSSN = "", ssn = "";

		while (rs.next()) {
			ssn = rs.getString(1);
			mngrSSN = rs.getString(4);
			username = rs.getString(5);
			password = rs.getString(6);

			if (checkUser.equals(username) && checkPassword.equals(password)) {
				if (mngrSSN.equals(ssn))
					return "manager";
				else
					return "employee";
			}
		}
		return "denied";
	}
}
