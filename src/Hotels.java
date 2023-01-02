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
        public static Void readFromTable(){
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
        String sql = "insert into Hotels values('" + id
             + "'," + hotelName + ",'" + hotelLocation + "'," +createdDate+",'"+updatedDate+"',"+active+")";
        
        //String sql = "insert into Hotels values(  (1,'math','mathmatic',5.5),"
		 	//	+ "(7,'skills','skills',1.6)";

        String url = "jdbc:mysql://localhost:3306/HotelDBMS";

        // Username and password to access DB
        // Custom initialization
        String user = "root";
        String pass = "root";
        
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

            String sql1 = null;
			// Executing query
            int m = st.executeUpdate(sql1);
            if (m >=  0)
                System.out.println(
                        "inserted successfully : " + sql1);
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
		return null;
        }
}
    

