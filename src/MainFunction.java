import java.util.Scanner;



public class MainFunction {

	public static void MainFunction() {
		System.out.println("Select one of the options:");
		System.out.println("1.Create Hotels");
		System.out.println("2.Insert Tables");
		System.out.println("3.Read rows From Table ");
		System.out.println("4.Read rows From Table by Id");
		System.out.println("5.Updat table by Id");
		System.out.println("7.Make hotel Active is false");
		
		
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
					
					Hotels hotelTable2=new Hotels();
					hotelTable2.readFromTable();
					break;
                case 4:
					
					Hotels readId=new Hotels();
					readId.getById();
					break;	
					
                case 5:
					
					Hotels deleteTable=new Hotels();
					deleteTable.updateById();
					break;	
                case 6:
					
					Hotels updateTable=new Hotels();
					updateTable.deleteById();
					break;	
					
                case 7:	
                	Hotels updateisActive=new Hotels();
                	updateisActive.makeIsActiveFalseById();
					break;
                
                	
               
			}
				}while(true);

		}
			 MenuExit =false;
	}}
