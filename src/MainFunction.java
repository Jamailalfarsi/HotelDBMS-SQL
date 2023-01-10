import java.util.Scanner;



public class MainFunction {

	public static void MainFunction() {
		System.out.println("Select one of the options:");
		System.out.println("1.Create Hotels Table");
		System.out.println("2.Insert hotel Table");
		System.out.println("3.Read rows From Table ");
		System.out.println("4.Read rows From Table by Id");
		System.out.println("5.Updat table by Id");
		System.out.println("6.delete row from table by id");
		System.out.println("7.Make hotel Active is false");
		System.out.println("8.Create Room_Type Table");
		System.out.println("9.Create Room Table");
		System.out.println("10.Create Guests Table");
		System.out.println("11.Create Employee_type Table");
		System.out.println("12.Create Employee Table");
		System.out.println("13.Insert into room_Type");
		System.out.println("14.Insert into Rooms Table");
		System.out.println("15.Insert into Guests Table");
		System.out.println("16.Create Employee_type Table");
		//System.out.println("13.Insert into Employees Table");
		
		
		
		 }
	public static void submenueFunction() {
		System.out.println("Select one of the options:");
	}
		public static void main(String[] args) {
			
			 
			   
			// TODO Auto-generated method stub
			
			boolean MenuExit = true;
			boolean subMenuExit = true;
			
			while( MenuExit ) {
				Scanner sc = new Scanner(System.in);
				MainFunction();
			
			do {
				

				int SubMenue1 = sc.nextInt();
				switch(SubMenue1) {
				case 1:
					
					Hotels hotelTable1=new Hotels();
					hotelTable1.HotelTable();
					
					 break;
				case 2:
					Hotels hotelTable3=new Hotels();
					hotelTable3.insertIntoTable();	
					
					break;
				case 3:
					Hotels hotelTable2=new Hotels();
					hotelTable2.readFromTable();
					break;	
					
                case 4:
                	Hotels readId=new Hotels();
					readId.getById();
					break;	
                	
					
                case 5:
                	Hotels updateTable=new Hotels();
                	updateTable.updateById();
					break;	
					
                case 6:
                	Hotels deleteTable=new Hotels();
                	deleteTable.deleteById();
					break;

					
                case 7:
                	Hotels Activeinput=new Hotels();
                	Activeinput.makeIsActiveFalseById( );
					break;

                case 8:
                	Room_Type roomType=new Room_Type();
                	roomType.RoomTypeFunction();
                	break;
                case 9:
                	Rooms rooms=new Rooms();
                	rooms.createRoomsTable();
                	break;
                case 10:
                	Guests guestsTable=new Guests();
                	guestsTable.GuestsTable();
                	break;
                case 11:
                	Employee_Type employeeType=new Employee_Type();
                	employeeType.EmployeeTypeFunction();
                	break;
                case 12:
                	Employees employees=new Employees();
                	employees.employeesTable();
                	break;
//                case 13:
//                	Employees employeeInsert=new Employees();
//                	employeeInsert.insertIntoTable2();
//                	break;
                case 13:
                	Room_Type roomTypeInsert=new Room_Type();
                	roomTypeInsert.insertIntoTable3();
                case 14:
                	Rooms roomsInsert=new Rooms();
                	roomsInsert.insertIntoTable4();
                case 15:
                	Guests guestsInsert=new Guests();
                	guestsInsert.insertIntoTable5();
                case 16:
                	Employee_Type employeeTypeInsert=new Employee_Type ();
                	employeeTypeInsert.insertIntoTable6();
			}
				}while(true);

		}
			 MenuExit =false;
	}}
