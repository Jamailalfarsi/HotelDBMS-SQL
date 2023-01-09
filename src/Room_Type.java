import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Room_Type {

	// Java Program to Establish Connection in JDBC


    // Main class

    // Main driver method
	
	public static void RoomTypeFunction() {
		// Creating the connection using Oracle DB
        // Note: url syntax is standard, so do grasp
        String url = "jdbc:mysql://localhost:3306/HotelDBMS";

        // Username and password to access DB
        // Custom initialization
        String user = "root";
        String pass = "root";
        
       
        String sql = "CREATE TABLE Room_Type " +
                "(id int NOT NULL AUTO_INCREMENT , " +
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
	public static void insertIntoTable3() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";

		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter How many you want of Room Type:");
		Integer number = scanner.nextInt();
		
		Random rn = new Random();
		Integer numberToAdd = rn.nextInt(100);
		
		
		
		
		// int id = 0;
		String room_type_name = "Special" + numberToAdd;
		String created_date = "2022-02-02";
		String updated_date = "2022-12-12";
		Boolean is_Active = true;

		

		for (int i = 1; i <= number; i++) {
			String in = "insert into Room_Type values (" + i + ", '" + room_type_name + "', '" 
					+ created_date + "', '" + updated_date + "'," + is_Active + ")";
        	
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
	public static void readFromTable3() {

		String url = "jdbc:mysql://localhost:3306/HotelDBMS";

		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter How many you want to read room type from table: ");
		Integer numberOfRoomType = scanner.nextInt();

		String sql2 = "SELECT * FROM Room_type";

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
				String room_type_name = resultSet.getString("room_type_name");
				Date created_date = resultSet.getDate("created_date");
				Date updated_date = resultSet.getDate("created_date");
				Boolean is_Active = resultSet.getBoolean("is_Active");

				System.out.println(id + ", " + room_type_name + ", " + created_date + " ,"
						+ updated_date + ", " + is_Active);
			}

		}

		// Catch block to handle exceptions
		catch (Exception ex) {
			// Display message when exceptions occurs
			System.err.println(ex);
		}

	}
	public static void getById3() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";

		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id: ");
		Integer idInput = scanner.nextInt();

		String sql2 = "select * from Room_Type where id='" + idInput + "'";

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
				String room_type_name = resultSet.getString("room_type_name");
				Date created_date = resultSet.getDate("created_date");
				Date updated_date = resultSet.getDate("created_date");
				int is_Active = resultSet.getInt("is_Active");

				System.out.println(id + ", " + room_type_name+ ", " + created_date + " ,"
						+ updated_date + ", " + is_Active);
			}

		}

		// Catch block to handle exceptions
		catch (Exception ex) {
			// Display message when exceptions occurs
			System.err.println(ex);
		}

	}
	public static void updateById3() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";

		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id: ");
		Integer idInput = scanner.nextInt();

		System.out.println("Enter Room Type: ");
		String roomTypeInput = scanner.next();

		String sql2 = "UPDATE Room_Type SET hotel_name='" + roomTypeInput+ "' WHERE id='" + idInput + "'";
		
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
	
	public static void deleteById3() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";

		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id: ");
		Integer idInput = scanner.nextInt();

		String sql2 = "delete from Room_Type where id ='"+idInput + "'";
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
	public static void makeIsActiveFalseById3( ) {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";

		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id: ");
		Integer idInput = scanner.nextInt();

		System.out.println("Enter Room_Type is active=0 ");
		Integer falseInput = scanner.nextInt();

		String sql2 = "UPDATE Room_Type SET is_Active=" + falseInput + " WHERE id=" + idInput ;
		
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
