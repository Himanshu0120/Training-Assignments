package Assignment1;
import java.util.*;
public class CostCalc {
	public static void displayResult(ArrayList<HashMap> input) {
		
		//Displaying the result for each item
		input.forEach((item)->{
			System.out.println("Item name : "+item.get("name"));
			float price=Float.parseFloat(String.valueOf(item.get("price")));
			System.out.println("Item Price : "+price);
			double tax=getTax(String.valueOf(item.get("type")),price);
			System.out.println("Tax per item is : "+tax);
			System.out.println("Final price per item(Original price + tax) :"+(tax+price)+"\n\n");
			
		});
	}
	
	//Helper method for calculating tax
	public static double getTax(String type,float price) {
		double tax=0;
		switch(type) {
		case "R":
			tax=12.5*price/100;
			break;
		case "M":
			tax=(12.5/100.0*price)+(2.0/100.0*(price+12.5/100.0*price));
			break;
		
		case "I":
			tax=(0.1*price);
			if((tax+price)<101) {
				tax+=5;
				break;
			}
			else if((tax+price) <201) {
				tax+=10;
				break;
			}
			else {
				tax=5/100*(tax+price);
			}
		}
		return tax;
	}
}
