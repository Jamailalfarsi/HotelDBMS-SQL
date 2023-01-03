import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Hotels {
 
	
	// Java Program to Establish Connection in JDBC


    // Main class

    // Main driver method
	
	
		// Creating the connection using Oracle DB
        // Note: url syntax is standard, so do grasp
        String url = "jdbc:mysql://localhost:3306/HotelDBMS";

        // Username and password to access DB
        // Custom initialization
        String user = "root";
        String pass = "root";
        
        public static void HotelTable(){
        String sql = "CREATE TABLE Hotels " +
                "(id INTEGER , " +
                " hotel_name VARCHAR(8) NOT NULL, " + 
                " hotel_location VARCHAR(250), " + 
                " created_date DATE NOT NULL, " + 
                " updated_date DATE , " + 
                " is_Active Boolean NOT NULL, " + 
                " PRIMARY KEY ( id ))";
        }
        public static void readFromTable(){
     // Entering the data
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter id");
        Integer id = scanner.nextInt();

        System.out.println("enter hotel_name");
        String hotelName = scanner.next();

        System.out.println("enter hotel_location");
        String hotelLocation = scanner.next();
        
        System.out.println("enter created_date");
        String createdDate = scanner.next();
        
        System.out.println("enter updated_date");
        String updatedDate = scanner.next();
        
        System.out.println("enter is_Active");
        String active = scanner.next();

        

       // Inserting data using SQL query
        
		
		

        String url = "jdbc:mysql://localhost:3306/HotelDBMS";

        // Username and password to access DB
        // Custom initialization
        String user = "root";
        String pass = "root";
        
        // Connection class object
        Connection con = null;

        // Try block to check for exceptions
        try {
        	String in = "INSERT INTO Hotels VALUES(" + id
                    + ",'" + hotelName + "','" + hotelLocation + "','" +createdDate+"','"+updatedDate+"',"+active+")";
      		
            Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            // Registering drivers
            DriverManager.registerDriver(driver);

            // Reference to connection interface
            con = DriverManager.getConnection(url, user,
                    pass);

            // Creating a statement
            Statement st = con.createStatement();

            String sql1 = null;
			// Executing query
          // int m = st.executeUpdate(sql1);
           int m = st.executeUpdate(in);
            if (m >=  1)
                System.out.println(
                        "inserted successfully : " + m);
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
    

