import java.util.Scanner;



public class MainFunction {

	public static void MainFunction() {
		System.out.println("Select one of the options:");
		System.out.println("1.Create Hotels");
		System.out.println("2.Insert hotel Table");
		System.out.println("3.Make N numbers of hotels");
		System.out.println("4.Read rows From Table ");
		System.out.println("5.Read rows From Table by Id");
		System.out.println("6.Updat table by Id");
		System.out.println("7.delete row from table by id");
		System.out.println("8.Make hotel Active is false");
		
		 }
		public static void main(String[] args) {
			
			 
			   
			// TODO Auto-generated method stub
			
			boolean MenuExit = true;
			
			
			while( MenuExit ) {
				Scanner sc = new Scanner(System.in);
				MainFunction();
			
			do {
				

				int studentSubMenue = sc.nextInt();
				switch(studentSubMenue) {
				case 1:
					
					Hotels hotelTable1=new Hotels();
					hotelTable1.HotelTable();
					
					 break;
				case 2:
					Hotels hotelTable3=new Hotels();
					hotelTable3.insertIntoTable();	
					
					break;
				case 3:
					
					Scanner scanner = new Scanner(System.in);
                	System.out.println("Enter the number of Hotels:");
            		int numberN = scanner.nextInt();
            		
                	//Hotels insertNhotels1=new Hotels();
            		Hotels.insertNIntoTable1( numberN);
            		break;
                case 4:
					
                	Hotels hotelTable2=new Hotels();
					hotelTable2.readFromTable();
					break;	
					
                case 5:
					
					Hotels readId=new Hotels();
					readId.getById();
					break;	
                case 6:
					
                	Hotels updateTable=new Hotels();
                	updateTable.updateById();
					break;	
					
                case 7:
                	Hotels deleteTable=new Hotels();
                	deleteTable.deleteById();
					break;

                case 8:	
                	Hotels Activeinput=new Hotels();
                	Activeinput.makeIsActiveFalseById( );
					break;
                
                	
               
			}
				}while(true);

		}
			 MenuExit =false;
	}}
