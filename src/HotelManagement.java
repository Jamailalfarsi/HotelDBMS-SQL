import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class HotelManagement {

	public static void hotelManagementFunction() {
		// TODO Auto-generated method stub
		// Creating the connection using Oracle DB
        // Note: url syntax is standard, so do grasp
        String url = "jdbc:mysql://localhost:3306/HotelDBMS";

        // Username and password to access DB
        // Custom initialization
        String user = "root";
        String pass = "root";
        
		String sql= "SELECT * FROM guests WHERE guest_name LIKE '%E'";
		Connection con1 = null;

		try {

			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);

			// Reference to connection interface
			con1 = DriverManager.getConnection(url, user, pass);

			// Creating a statement
			Statement st = con1.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			// System.out.println(resultSet);
			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String guest_name = resultSet.getString("guest_name");
				String guest_phone = resultSet.getString("guest_phone");
				Integer guest_accompanying_members=resultSet.getInt("guest_accompanying_members");
				Integer guest_payment_amount=resultSet.getInt("guest_payment_amount");
				Integer room_id=resultSet.getInt("room_id");
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
	public static void function2() {
		// TODO Auto-generated method stub
				// Creating the connection using Oracle DB
		        // Note: url syntax is standard, so do grasp
		        String url = "jdbc:mysql://localhost:3306/HotelDBMS";

		        // Username and password to access DB
		        // Custom initialization
		        String user = "root";
		        String pass = "root";
		        String sql= "SELECT * FROM room_Type WHERE is_Active=0 AND room_type_name='DELUXE'";
		        
		        Connection con1 = null;

				try {

					Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
					// Registering drivers
					DriverManager.registerDriver(driver);

					// Reference to connection interface
					con1 = DriverManager.getConnection(url, user, pass);

					// Creating a statement
					Statement st = con1.createStatement();
					ResultSet resultSet = st.executeQuery(sql);
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
}
