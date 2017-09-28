import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;



public class Insert {
	
public static void main(String[] args) {
	

    Connection c = null;
    Statement stmt = null;
    try {
    Class.forName("org.postgresql.Driver");
      c = DriverManager
         .getConnection("jdbc:postgresql://localhost:5432/postgres",
         		"postgres", "postgres");
  
      System.out.println("Database open ok");

      stmt = c.createStatement();
      String sql = " INSERT INTO \"workshop\".employee (ssn, name, phoneNr,mngrSsn) values(110892, 'Bogdan', 29844097, 110892);";
    //  String sql = "INSERT INTO \"workshop\".tabletest1 (id, name, age, address, salary) values(1, 'Morten', 23, 'Horsens C', 50000);";
      stmt.executeUpdate(sql);

 

      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName()+": "+ e.getMessage() );
      System.exit(0);
    }
    System.out.println("Database update ok");
  }
	
}

