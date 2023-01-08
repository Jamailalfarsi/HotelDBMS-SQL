import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Employees {

	// Java Program to Establish Connection in JDBC


    // Main class

    // Main driver method
	
	public static void employeesTable() {
		// Creating the connection using Oracle DB
        // Note: url syntax is standard, so do grasp
        String url = "jdbc:mysql://localhost:3306/HotelDBMS";

        // Username and password to access DB
        // Custom initialization
        String user = "root";
        String pass = "root";
        
       
        String sql = "CREATE TABLE Employees " +
                "(id int NOT NULL AUTO_INCREMENT  , " +
                " employee_type_id INTEGER NOT NULL, " + 
               "FOREIGN KEY (employee_type_id) REFERENCES Employee_Type(id) ON DELETE CASCADE ,"+
               // "CONSTRAINT employee_type_idFK foreign key (employee_type_id) REFERENCES Employee_Type(id),"+
                " room_id  INTEGER, " + 
                "FOREIGN KEY (room_id) REFERENCES Hotels(id) ON DELETE CASCADE ,"+

                " created_date DATE NOT NULL, " + 
                " updated_date DATE , " + 
                " is_Active bit NOT NULL, " + 
                " PRIMARY KEY ( id ))";

       
        
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
	public static void readFromTable1() {

		String url = "jdbc:mysql://localhost:3306/HotelDBMS";

		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter How many you want to read rows from table: ");
		Integer numberOfHotels = scanner.nextInt();

		String sql2 = "SELECT * FROM employees";

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
				Integer employee_type_id = resultSet.getInt("employee_type_id");
				Integer room_id  = resultSet.getInt("room_id ");
				Date created_date = resultSet.getDate("created_date");
				Date updated_date = resultSet.getDate("created_date");
				Integer is_Active = resultSet.getInt("is_Active");

				System.out.println(id + ", " + employee_type_id + ", " + room_id+ ", " + created_date + " ,"
						+ updated_date + ", " + is_Active);
				
			}

		}

		// Catch block to handle exceptions
		catch (Exception ex) {
			// Display message when exceptions occurs
			System.err.println(ex);
		}

	}
	public static void insertIntoTable2() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";

		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the number of employees:");
		Integer number = scanner.nextInt();

		// int id = 0;
		Integer employee_type_id = 2333;
		Integer room_id  = 1;
		String created_date = "2022-02-02";
		String updated_date = "2022-12-12";
		int is_Active = 1;

		Random rn = new Random();
		Integer numberToAdd = rn.nextInt(100);

		for (int i = 1; i <= number; i++) {
			String in = "insert into Employees values (" +i + ", " + employee_type_id +  ", " + room_id +
					 ", '" + created_date + "', '" + updated_date + "', " + is_Active + ")";
			
			

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
	public static void getById2() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";

		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id: ");
		Integer idInput = scanner.nextInt();

		String sql2 = "select * from Employees where id='" + idInput + "'";

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
				Integer employee_type_id = resultSet.getInt("employee_type_id");
				Integer room_id  = resultSet.getInt("room_id ");
				Date created_date = resultSet.getDate("created_date");
				Date updated_date = resultSet.getDate("created_date");
				Integer is_Active = resultSet.getInt("is_Active");

				System.out.println(id + ", " + employee_type_id + ", " + room_id+ ", " + created_date + " ,"
						+ updated_date + ", " + is_Active);
			}

		}

		// Catch block to handle exceptions
		catch (Exception ex) {
			// Display message when exceptions occurs
			System.err.println(ex);
		}

	}
	public static void updateById2() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";

		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id: ");
		Integer idInput = scanner.nextInt();

		System.out.println("Enter employee type id: ");
		String employeeInput = scanner.next();


		String sql2 = "UPDATE Employees SET employee_type_id='" + employeeInput 
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
	public static void deleteById2() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";

		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id: ");
		Integer idInput = scanner.nextInt();

		String sql2 = "delete from employees where id ='"+idInput + "'";
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
	public static void makeIsActiveFalseById2() {
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";

		// Username and password to access DB
		// Custom initialization
		String user = "root";
		String pass = "root";

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id: ");
		Integer idInput = scanner.nextInt();

		System.out.println("Enter employee is active=0 ");
		Integer falseInput = scanner.nextInt();

		String sql2 = "UPDATE Employees SET is_Active=" + falseInput + " WHERE id=" + idInput ;
		
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

