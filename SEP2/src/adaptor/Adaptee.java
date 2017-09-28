package adaptor;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import utill.SetADT;

public class Adaptee {
	private String url;
	private String user;
	private String pw;
	private Connection connection;

	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
	private static final String USER = "postgres";
	private static final String PASSWORD = "postgres";

	String sql = "INSERT INTO \"workshop\".employee (ssn, name, phoneNr,mngrSsn) values(110892, 'Bogdan', 29844097, 110892);";

	public Adaptee(String driver, String url, String user, String pw)
			throws ClassNotFoundException {
		this.url = url;
		this.user = user;
		this.pw = pw;
		connection = null;
		Class.forName(driver);
	}

	public Adaptee(String databaseName, String user, String pw)
			throws ClassNotFoundException {
		this(DRIVER, URL + databaseName, user, pw);
	}

	public Adaptee(String databaseName) throws ClassNotFoundException {
		this(DRIVER, URL + databaseName, USER, PASSWORD);
	}

	public Adaptee() throws ClassNotFoundException {
		this(DRIVER, URL, USER, PASSWORD);
	}

	public void update(String sql) throws SQLException {
		openDatabase();
		Statement stm = connection.createStatement();
		stm.executeUpdate(sql);
		closeDatabase();

	}

	private void openDatabase() throws SQLException {
		connection = DriverManager.getConnection(url, user, pw);
	}

	private void closeDatabase() throws SQLException {
		connection.close();
	}

	public ResultSet query(String sql) throws SQLException {
		openDatabase();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		closeDatabase();
		return rs;

	}

}
