package defaultPackage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		System.out.println("***************************************************"
				            + "*******************************************");
		System.out.println("                                   Flight Search");
		System.out.println("*************************************************"
				           + "*********************************************");
		do{
//			calling the getInput function to get input details from the user
		String inputs[]=UserInput.getInputs();
		
//		after getting the inputs calling the go function to continue with the rest of the execution 
		go(inputs);
		
		}while(getCont().equalsIgnoreCase("y"));
		
		System.out.println("***************************************************"
	            + "*******************************************");
		System.out.println("                                   Thank You");
		System.out.println("*************************************************"
	           + "*********************************************");
		
	}
	
//	Function to get input if user want to search more or not 
	static String getCont() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Do you want to search for more flights (Y/N)");
		String input=sc.next();
		while(!input.equalsIgnoreCase("n") &&  !input.equalsIgnoreCase("y")) {
			System.out.println("Enter Y or N");
			input=sc.next();
		}
		return input;
	}
	
//	Function to all other helper functions after getting the input
	public static void go(String inputs[]) throws InterruptedException, ExecutionException {
		
//		Getting the path of all the available csv files
		String[] files=FilesList.getFilesPath();
		
//		Array list for storing the flights matching the user inputs
		ArrayList<Flight> finalRes=new ArrayList<Flight>();
		
//	    Using multithreading with each thread searching in a specific file
		ExecutorService es=Executors.newFixedThreadPool(3);
		
//		array to store the resluts from all the threads
        Future<ArrayList<Flight>>[] results = new Future[3];
		for(int i=0;i<files.length;i++) {
			
//			giving the path of each file to a new thread to search in a file and providing the user inputs as well
			Search search=new Search(inputs,files[i]);
			results[i]=es.submit(search);
		}
		
//		merging the results of all the threads to a single list and changing the price if user gave calass as B
		for(Future<ArrayList<Flight>> result:results) {
			ArrayList<Flight> res=result.get();
			for(Flight f:res) {
				if(inputs[3].equalsIgnoreCase("B")){
					f.changePrice();
					
				}
				finalRes.add(f);
			}
		}
		
//		sorting the result based on the input by the user
		flightSort(inputs[4],finalRes);
//		displaying the resluts
		displayAll(finalRes);

	}
	
//	function to sort the flights list
	public static void flightSort(String input,ArrayList<Flight> finalRes) {
		if (input.equalsIgnoreCase("F")) {
			finalRes.sort((Flight f1, Flight f2) -> f1.getFare().compareTo(f2.getFare()));
		} else {
			finalRes.sort(new Comparator<Flight>() {

				@Override
				public int compare(Flight f1, Flight f2) {
					// TODO Auto-generated method stub
					int comp=0;
					comp=f1.getFare().compareTo(f2.getFare());
					if(comp==0) {
						comp=f1.getDur().compareTo(f2.getDur());
					}
					return comp;
				}
				
			});
		}
	}

//	function to diaplay the result
	public static void displayAll(ArrayList<Flight> list){
		if(list.size()==0) {
			System.out.println("\nNo flights matcing your input details Please make sure your input matches the available flights details");
			return;
		}
		System.out.println("\nThese are the flights according your input details\n");
		for(int i=0;i<list.size();i++) {
			int count=i+1;
			System.out.println("Flight "+count+" :");
			list.get(i).display();
			System.out.println("--------------------------------------------------------------------------------------------");
		}
	}

	
	
}
