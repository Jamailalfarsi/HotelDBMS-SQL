import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;
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
                " is_Active bit NOT NULL, " + 
                " PRIMARY KEY ( id ))";
        }
        public static void readFromTable(){
     // Entering the data
        Scanner scanner = new Scanner(System.in);

        } 

       // Inserting data using SQL query
        
		
		
        public static void insertIntoTable(){
        String url = "jdbc:mysql://localhost:3306/HotelDBMS";

        // Username and password to access DB
        // Custom initialization
        String user = "root";
        String pass = "root";
        
      
        	 Scanner scanner = new Scanner(System.in);
             
         	System.out.println ("Enter the number of Hotels:");
             Integer number=scanner.nextInt();
             
            //int id = 0;
  		    String hotel_name="MM";
  		    String hotel_location="Muscut";
  		    String created_date="2022-02-02";
  		    String updated_date="2022-12-12";
  		    int is_Active=1;
             
     		
     			
     			   Random rn = new Random();
     		       Integer numberToAdd = rn.nextInt(100);
     		       
     		      
     		for(int i=1;i<=number;i++) {
     			String in = "insert into Hotels values ("+i+", '"+hotel_name+i+"', '"+hotel_location+i+"', '"+created_date+"', '"+updated_date+"', '"+is_Active+"')";
//         	String in = "INSERT INTO Hotels VALUES("+id+i+","+hotel_name+i+","+hotel_location+i+","
//         			+ ""+created_date+","+updated_date+","+is_Active+i+")";
//                     System.out.println(hotel_name);
            Connection con1 = null;
        	
            try {
            	
            Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            // Registering drivers
            DriverManager.registerDriver(driver);

            // Reference to connection interface
            con1 = DriverManager.getConnection(url, user,
                    pass);

            // Creating a statement
            Statement st = con1.createStatement();

    
           int m = st.executeUpdate(in);
            if (m >=  0)
                System.out.println(
                        "inserted successfully : " + m);
            else
                System.out.println("insertion failed");

            // Closing the connections
            con1.close();
        }

        // Catch block to handle exceptions
        catch (Exception ex) {
            // Display message when exceptions occurs
            System.err.println(ex);
        }

        }}
}
    

