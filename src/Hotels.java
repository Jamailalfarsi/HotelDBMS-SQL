import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Hotels {

	public static void HotelTable() {
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
		String sql = "CREATE TABLE Hotels " + "(id int NOT NULL AUTO_INCREMENT , " + " hotel_name VARCHAR(8) NOT NULL, "
				+ " hotel_location VARCHAR(250), " + " created_date DATE NOT NULL, " + " updated_date DATE , "
				+ " is_Active bit NOT NULL, " + " PRIMARY KEY ( id ))";
		// Connection class object
        Connection con = null;

        // Try block to check for exceptions
        try {

            Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            // Registering drivers
            DriverManager.registerDriver(driver);

            // Reference to connection interface
            con = DriverManager.getConnection(url, user, pass);

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
	

	public static void readFromTable() {

		String url = "jdbc:mysql://localhost:3306/HotelDBMS";

		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter How many you want to read hotels from table: ");
		Integer numberOfHotels = scanner.nextInt();

		String sql2 = "SELECT * FROM hotels";

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
				String hotel_name = resultSet.getString("hotel_name");
				String hotel_location = resultSet.getString("hotel_location");
				Date created_date = resultSet.getDate("created_date");
				Date updated_date = resultSet.getDate("created_date");
				Boolean is_Active = resultSet.getBoolean("is_Active");

				System.out.println(id + ", " + hotel_name + ", " + hotel_location + ", " + created_date + " ,"
						+ updated_date + ", " + is_Active);
			}

		}

		// Catch block to handle exceptions
		catch (Exception ex) {
			// Display message when exceptions occurs
			System.err.println(ex);
		}

	}

	public static void insertIntoTable() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";

		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the number of Hotels:");
		Integer number = scanner.nextInt();

		// int id = 0;
		String hotel_name = "MM";
		String hotel_location = "Muscut";
		String created_date = "2022-02-02";
		String updated_date = "2022-12-12";
		Boolean is_Active = true;

		Random rn = new Random();
		Integer numberToAdd = rn.nextInt(100);

		for (int i = 1; i <= number; i++) {
			String in = "insert into Hotels values (" +i + ", '" + hotel_name + i + "', '" + hotel_location + i
					+ "', '" + created_date + "', '" + updated_date + "'," + is_Active + ")";
//         	
			Connection con1 = null;

			try {

				Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				// Registering drivers
				DriverManager.registerDriver(driver);

				// Reference to connection interface
				con1 = DriverManager.getConnection(url, user, pass);

				// Creating a statement
				Statement st = con1.createStatement();

				int m = st.executeUpdate(in);
				if (m >= 0)
					System.out.println("inserted successfully : " + m);
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

		}
	}

	public static void getById() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";

		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id: ");
		Integer idInput = scanner.nextInt();

		String sql2 = "select * from Hotels where id='" + idInput + "'";

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
				String hotel_name = resultSet.getString("hotel_name");
				String hotel_location = resultSet.getString("hotel_location");
				Date created_date = resultSet.getDate("created_date");
				Date updated_date = resultSet.getDate("created_date");
				int is_Active = resultSet.getInt("is_Active");

				System.out.println(id + ", " + hotel_name + ", " + hotel_location + ", " + created_date + " ,"
						+ updated_date + ", " + is_Active);
			}

		}

		// Catch block to handle exceptions
		catch (Exception ex) {
			// Display message when exceptions occurs
			System.err.println(ex);
		}

	}

	public static void updateById() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";

		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id: ");
		Integer idInput = scanner.nextInt();

		System.out.println("Enter Hotel Name: ");
		String hotelNameInput = scanner.next();

		System.out.println("Enter Hotel Location: ");
		String hotelLocatoinInput = scanner.next();

		String sql2 = "UPDATE Hotels SET hotel_name='" + hotelNameInput + "',hotel_location='" + hotelLocatoinInput
				+ "' WHERE id='" + idInput + "'";
		
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
	public static void deleteById() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";

		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id: ");
		Integer idInput = scanner.nextInt();

		String sql2 = "delete from Hotels where id ='"+idInput + "'";
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
	public static void makeIsActiveFalseById( ) {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";

		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id: ");
		Integer idInput = scanner.nextInt();

		System.out.println("Enter hotel is active=0 ");
		Integer falseInput = scanner.nextInt();

		String sql2 = "UPDATE Hotels SET is_Active=" + falseInput + " WHERE id=" + idInput ;
		
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
	

	
	
	

