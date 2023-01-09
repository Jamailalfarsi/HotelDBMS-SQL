import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Rooms {

	// Java Program to Establish Connection in JDBC


    // Main class

    // Main driver method
	
	public static void createRoomsTable() {
		// Creating the connection using Oracle DB
        // Note: url syntax is standard, so do grasp
        String url = "jdbc:mysql://localhost:3306/HotelDBMS";

        // Username and password to access DB
        // Custom initialization
        String user = "root";
        String pass = "root";
        
       
        String sql = "CREATE TABLE Rooms " +
                "(id int NOT NULL AUTO_INCREMENT , " +
                " room_type_id INTEGER , " + 
                "FOREIGN KEY ( room_type_id) REFERENCES Room_Type(id) ON DELETE CASCADE ,"+
                " hotel_id INTEGER , " + 
                "FOREIGN KEY ( hotel_id) REFERENCES Hotels(id) ON DELETE CASCADE ,"+

                " created_date DATE NOT NULL, " + 
                " updated_date DATE , " + 
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
	
	public static void insertIntoTable4() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";

		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter How many you want of Rooms:");
		Integer number = scanner.nextInt();
		
		Random rn = new Random();
		Integer numberToAdd = rn.nextInt(100);
		
		
		Integer room_type_id =1;
		Integer hotel_id =1;
		String created_date = "2022-02-02";
		String updated_date = "2022-12-12";
		Boolean is_Active = true;

		

		for (int i = 0; i <= number; i++) {
			//String in = "insert into Rooms values (" + i + ", '" + room_type_id + "', '" +
					//hotel_id + created_date + "', '" + updated_date + "'," + is_Active + ")";
		//String in=SELECT id FROM Rooms INNER JOIN Room_Type ON Rooms.room_type_id=Room_type.id WHERE Room_Type.
			String in = "Insert into rooms values(" + i  + "," + room_type_id + "," + hotel_id + ",'"
					  + created_date + "','" + updated_date + "'," +is_Active+ ")";
        	
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

		}}
	public static void readFromTable4() {

		String url = "jdbc:mysql://localhost:3306/HotelDBMS";

		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter How many you want to read rooms from table: ");
		Integer numberOfRoomType = scanner.nextInt();

		String sql2 = "SELECT * FROM Rooms";

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
				Integer room_type_id=resultSet.getInt("room_type_id");
				Integer hotel_id=resultSet.getInt("hotel_id");
				Date created_date = resultSet.getDate("created_date");
				Date updated_date = resultSet.getDate("created_date");
				Boolean is_Active = resultSet.getBoolean("is_Active");

				System.out.println(id + ", " + room_type_id + ", "+hotel_id+", " + created_date + " ,"
						+ updated_date + ", " + is_Active);
			}

		}

		// Catch block to handle exceptions
		catch (Exception ex) {
			// Display message when exceptions occurs
			System.err.println(ex);
		}

	}
	public static void getById4() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";

		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id: ");
		Integer idInput = scanner.nextInt();

		String sql2 = "select * from Rooms where id='" + idInput + "'";

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
				Integer room_type_id=resultSet.getInt("room_type_id");
				Integer hotel_id=resultSet.getInt("hotel_id");
				Date created_date = resultSet.getDate("created_date");
				Date updated_date = resultSet.getDate("created_date");
				Boolean is_Active = resultSet.getBoolean("is_Active");

				System.out.println(id + ", " + room_type_id + ", "+hotel_id+", " + created_date + " ,"
						+ updated_date + ", " + is_Active);
			}

		}

		// Catch block to handle exceptions
		catch (Exception ex) {
			// Display message when exceptions occurs
			System.err.println(ex);
		}

	}
	public static void updateById4() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";

		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id: ");
		Integer idInput = scanner.nextInt();

		System.out.println("Enter Rooms: ");
		String roomsInput = scanner.next();

		String sql2 = "UPDATE Rooms SET hotel_name='" + roomsInput+ "' WHERE id='" + idInput + "'";
		
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
	public static void deleteById4() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";

		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id: ");
		Integer idInput = scanner.nextInt();

		String sql2 = "delete from Rooms where id ='"+idInput + "'";
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
	public static void makeIsActiveFalseById4( ) {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";

		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id: ");
		Integer idInput = scanner.nextInt();

		System.out.println("Enter Rooms is active=0 ");
		Integer falseInput = scanner.nextInt();

		String sql2 = "UPDATE Rooms SET is_Active=" + falseInput + " WHERE id=" + idInput ;
		
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


   
