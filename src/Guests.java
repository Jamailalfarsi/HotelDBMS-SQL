import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

public class Guests {

		// Java Program to Establish Connection in JDBC


	    // Main class

	    // Main driver method
		
		public static void GuestsTable(){
			// Creating the connection using Oracle DB
	        // Note: url syntax is standard, so do grasp
	        String url = "jdbc:mysql://localhost:3306/HotelDBMS";

	        // Username and password to access DB
	        // Custom initialization
	        String user = "root";
	        String pass = "root";
	        
	       
	        String sql = "CREATE TABLE Guests " +
	                "(id int NOT NULL AUTO_INCREMENT , " +
	                " guest_name VARCHAR(20) NOT NULL, " + 
	                " guest_phone VARCHAR(20) NOT NULL , " + 
	                " guest_accompanying_members INTEGER NOT NULL, " + 
	                " guest_payment_amount INTEGER NOT NULL , " + 
	                " room_id INTEGER  , " + 
	                "FOREIGN KEY (room_id) REFERENCES Rooms(id) ON DELETE CASCADE ,"+
	                " hotel_id INTEGER , " + 
	                "FOREIGN KEY (hotel_id) REFERENCES Hotels(id) ON DELETE CASCADE ,"+
	                " created_date  DATE NOT NULL , " +
	                " updated_date  DATE  , " + 
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
		public static void readFromTable5() {

			String url = "jdbc:mysql://localhost:3306/HotelDBMS";

			// Username and password to access DB
			// Custom initialization
			String user = "root";
			String pass = "root";

			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter How many you want to read Guests from table: ");
			Integer numberOfGuests = scanner.nextInt();

			String sql2 = "SELECT * FROM Guests";

			Connection con1 = null;

			try {

				Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				// Registering drivers
				DriverManager.registerDriver(driver);

				// Reference to connection interface
				con1 = DriverManager.getConnection(url, user, pass);

				// Creating a statement
				Statement st = con1.createStatement();
				ResultSet resultSet = st.executeQuery(sql2);
				// System.out.println(resultSet);
				while (resultSet.next()) {
					Integer id = resultSet.getInt("id");
					String guest_name = resultSet.getString("guest_name");
					String guest_phone = resultSet.getString("guest_phone");
					Integer guest_accompanying_members=resultSet.getInt("guest_accompanying_members");
					Integer guest_payment_amount=resultSet.getInt("guest_payment_amount");
					Integer room_id=resultSet.getInt(" room_id");
					Integer hotel_id =resultSet.getInt("hotel_id");
					Date created_date = resultSet.getDate("created_date");
					Date updated_date = resultSet.getDate("created_date");
					Boolean is_Active = resultSet.getBoolean("is_Active");

					System.out.println(id + ", " + guest_name + ", " + guest_phone + ", "+guest_accompanying_members+", "
					+ created_date + " ,"
						+guest_payment_amount+" ,"+room_id+" ,"+hotel_id+" ,"+created_date+" ,"+updated_date + ", " + is_Active);
				}

			}

			// Catch block to handle exceptions
			catch (Exception ex) {
				// Display message when exceptions occurs
				System.err.println(ex);
			}

		}
		public static void getById5() {
			String url = "jdbc:mysql://localhost:3306/HotelDBMS";

			// Username and password to access DB
			// Custom initialization
			String user = "root";
			String pass = "root";

			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter id: ");
			Integer idInput = scanner.nextInt();

			String sql2 = "select * from Guests where id='" + idInput + "'";

			Connection con1 = null;

			try {

				Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				// Registering drivers
				DriverManager.registerDriver(driver);

				// Reference to connection interface
				con1 = DriverManager.getConnection(url, user, pass);

				// Creating a statement
				Statement st = con1.createStatement();
				ResultSet resultSet = st.executeQuery(sql2);
				// System.out.println(resultSet);
				while (resultSet.next()) {
					Integer id = resultSet.getInt("id");
					String guest_name = resultSet.getString("guest_name");
					String guest_phone = resultSet.getString("guest_phone");
					Integer guest_accompanying_members=resultSet.getInt("guest_accompanying_members");
					Integer guest_payment_amount=resultSet.getInt("guest_payment_amount");
					Integer room_id=resultSet.getInt(" room_id");
					Integer hotel_id =resultSet.getInt("hotel_id");
					Date created_date = resultSet.getDate("created_date");
					Date updated_date = resultSet.getDate("created_date");
					Boolean is_Active = resultSet.getBoolean("is_Active");

					System.out.println(id + ", " + guest_name + ", " + guest_phone + ", "+guest_accompanying_members+", "
					+ created_date + " ,"
						+guest_payment_amount+" ,"+room_id+" ,"+hotel_id+" ,"+created_date+" ,"+updated_date + ", " + is_Active);
				}

			}

			// Catch block to handle exceptions
			catch (Exception ex) {
				// Display message when exceptions occurs
				System.err.println(ex);
			}

		}
		public static void updateById5() {
			String url = "jdbc:mysql://localhost:3306/HotelDBMS";

			// Username and password to access DB
			// Custom initialization
			String user = "root";
			String pass = "root";

			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter id: ");
			Integer idInput = scanner.nextInt();

			System.out.println("Enter Guests name: ");
			String guestsInput = scanner.next();

			String sql2 = "UPDATE Guests SET guest_name='" +guestsInput+ "' WHERE id='" + idInput + "'";
			
			Connection con1 = null;

			try {

				Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				// Registering drivers
				DriverManager.registerDriver(driver);

				// Reference to connection interface
				con1 = DriverManager.getConnection(url, user, pass);

				// Creating a statement
				Statement st = con1.createStatement();
				int m = st.executeUpdate(sql2);

				

			}

			// Catch block to handle exceptions
			catch (Exception ex) {
				// Display message when exceptions occurs
				System.err.println(ex);
			}
		}
		public static void deleteById5() {
			String url = "jdbc:mysql://localhost:3306/HotelDBMS";

			// Username and password to access DB
			// Custom initialization
			String user = "root";
			String pass = "root";

			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter id: ");
			Integer idInput = scanner.nextInt();

			String sql2 = "delete from Guests where id ='"+idInput + "'";
			Connection con1 = null;

			try {

				Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				// Registering drivers
				DriverManager.registerDriver(driver);

				// Reference to connection interface
				con1 = DriverManager.getConnection(url, user, pass);

				// Creating a statement
				Statement st = con1.createStatement();
				int m = st.executeUpdate(sql2);

			}

			// Catch block to handle exceptions
			catch (Exception ex) {
				// Display message when exceptions occurs
				System.err.println(ex);
			}
		}
		public static void makeIsActiveFalseById5( ) {
			String url = "jdbc:mysql://localhost:3306/HotelDBMS";

			// Username and password to access DB
			// Custom initialization
			String user = "root";
			String pass = "root";

			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter id: ");
			Integer idInput = scanner.nextInt();

			System.out.println("Enter Guest is active=0 ");
			Integer falseInput = scanner.nextInt();

			String sql2 = "UPDATE Guests SET is_Active=" + falseInput + " WHERE id=" + idInput ;
			
			Connection con1 = null;

			try {

				Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				// Registering drivers
				DriverManager.registerDriver(driver);

				// Reference to connection interface
				con1 = DriverManager.getConnection(url, user, pass);

				// Creating a statement
				Statement st = con1.createStatement();
				int m = st.executeUpdate(sql2);

				

			}

			// Catch block to handle exceptions
			catch (Exception ex) {
				// Display message when exceptions occurs
				System.err.println(ex);
			}
			
		}



	}
	   
