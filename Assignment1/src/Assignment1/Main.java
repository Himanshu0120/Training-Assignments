package Assignment1;
import java.util.*;
public class Main {
	
	public static void main(String[] args) {
	
		
		//ArrayList to store all the items
		ArrayList<HashMap> inputs=new ArrayList<HashMap>();
		
		//Condition variable for the loop
		int n;
		
		do{
			// HashMap to store individual items 
			HashMap item=new HashMap();
			
			//Getting input for the item details
			System.out.println("Enter the name");
			String name=getString();
			
			System.out.println("Enter the price");		
			float price=getFloat();
			
			System.out.println("Enter the quantity");
			int q=getInt();
			
			System.out.println("Enter the type(Raw-R/Manufactured-M/Imported-I)");
			String type=getString();
			while(!type.equals("R") &&  !type.equals("I") && !type.equals("M")) {
				System.out.println("Enter the type(Raw-R/Manufactured-M/Imported-I)");
				type=getString();
			}
			
			//Asking the user if he wants to enter more items
			System.out.println("Do you want to enter more items : (yes-1/ no-0)");
			n=getInt();
			
			while(n!=1 && n!=0) {
				System.out.println("Enter 0 or 1");
				n=getInt();
			}
		
			// Adding all the item details in the HashMap
			item.put("name", name);
			item.put("price",price );
			item.put("type",type );
			item.put("quantity",q );
			
			// Inserting the HashMap to the ArrayList
			inputs.add(item);
		
		}while(n==1);
		
		
		CostCalc.displayResult(inputs);
		}
	
	//Helper method for string input
	public static String getString() {
		Scanner S =new Scanner(System.in);
		String s=S.nextLine();
		return s;
	}
	
	
	//Helper method for float input
	public static float getFloat() {
		
		Scanner S=new Scanner(System.in);
		while(true) {
		try {
			return S.nextFloat(); 
		}
		catch(Exception e) {
			S.next();
			System.out.println("Enter a numeric value");
		}
		}
	}
	
	//Helper method for Integer input
	public static int getInt() {
		Scanner S =new Scanner(System.in);
		while(true) {
			try {
				return S.nextInt();
			}
			catch(Exception e) {
				S.next();
				System.out.println("Enter a integer value");
			}
		}
	}
	
	
}
