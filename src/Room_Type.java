import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class Room_Type {

	// Java Program to Establish Connection in JDBC


    // Main class

    // Main driver method
	
	public static void main(String[] args) {
		// Creating the connection using Oracle DB
        // Note: url syntax is standard, so do grasp
        String url = "jdbc:mysql://localhost:3306/HotelDBMS";

        // Username and password to access DB
        // Custom initialization
        String user = "root";
        String pass = "root";
        
       
        String sql = "CREATE TABLE Room_Type " +
                "(id INTEGER , " +
                " room_type_name VARCHAR(20) NOT NULL, " + 
                " created_date DATE, " + 
                " updated_date DATE, " + 
                
                " is_Active Boolean NOT NULL, " + 
                " PRIMARY KEY ( id ))";

        // Entering the data
       

        
        // Connection class object
        Connection con = null;

        // Try block to check for exceptions
        try {

            Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            // Registering drivers
            DriverManager.registerDriver(driver);

            // Reference to connection interface
            con = DriverManager.getConnection(url, user,
                    pass);

            // Creating a statement
            Statement st = con.createStatement();

            // Executing query
            int m = st.executeUpdate(sql);
            if (m >=  0)
                System.out.println(
                        "inserted successfully : " + sql);
            else
                System.out.println("insertion failed");

            // Closing the connections
            con.close();
        }

        // Catch block to handle exceptions
        catch (Exception ex) {
            // Display message when exceptions occurs
            System.err.println(ex);
        }
    }
}
