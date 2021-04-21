package defaultPackage;

import java.util.Scanner;


//class containing the functions for user inputs
public class UserInput {
	static Scanner sc = new Scanner(System.in);

	public static String[] getInputs() {
		String[] inputs = new String[5];
		System.out.println("Please provide the following deatils for your filght : ");
		inputs[0] = getDepLoc();
		inputs[1] = getArrLoc();
		inputs[2] = getDate();
		inputs[3] = getClas();
		inputs[4] = getPref();
		return inputs;
	}

	public static String getDepLoc() {
		System.out.println("Departure location code(Ex-DEL) : ");
		String input = sc.next();
		while (input.length() != 3) {
			System.out.println("Wrong input -- Departure location code should be 3 letters code : ");
			input = sc.next();
		}
		return input;
	}

	public static String getArrLoc() {
		System.out.println("Arrival location code(Ex-MUB) : ");
		String input = sc.next();
		while (input.length() != 3) {
			System.out.println("Wrong input -- Arrival location code should be 3 letters code : ");
			input = sc.next();
		}
		return input;
	}

	public static String getDate() {
		System.out.println("\nDate Input \n");
		System.out.println("Enter Day(Ex-05) : ");
		int day = getInt();
		while(day>31 || day<1) {
			System.out.println("\nNOT A VALID DAY\nENTER AGAIN : ");
			day=getInt();
		}
		System.out.println("Enter Month(Ex-05) : ");
		int month=getInt();
		while(month>12 || month<1) {
			System.out.println("\nNOT A VALID MONTH \nENTER AGAIN : ");
			month=getInt();
		}
		System.out.println("Enter Year(Ex-2013) : ");
		int year=getInt();
		while(year>2021 || year<2000) {
			System.out.println("Year should be between 2000-2021");
			year=sc.nextInt();
		}
		String input=String.format("%02d-%02d-%d",day,month,year);
		return input;
	}

	public static String getClas() {
		System.out.println("\nEnter the Flight class(B/E) : ");
		String input = sc.next();
		while (!input.equalsIgnoreCase("b") && !input.equalsIgnoreCase("e")) {
			System.out.println("Wrong Input -- Enter B or E : ");
			input = sc.next();
		}
		return input;
	}

	public static String getPref() {
		System.out.println("\nSort output by Fare(F) or both fare and duration(D)  (F/D) : ");
		String input = sc.next();
		while (!input.equalsIgnoreCase("f") && !input.equalsIgnoreCase("d")) {
			System.out.println("Wrong Input -- Enter F or D) : ");
			input = sc.next();
		}
		return input;
	}

	private static int getInt() {
		while (true) {
			try {
				int i = sc.nextInt();
				return i;
			} catch (Exception e) {
				System.out.println("Enter an integer\n");
				sc.next();
			}
		}
	}
	
	
}
