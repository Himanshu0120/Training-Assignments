package defaultPackage;

import java.util.List;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws InterruptedException, ExecutionException, ParseException {
		// TODO Auto-generated method stub
		System.out.println("***************************************************"
				            + "*******************************************");
		System.out.println("                                   Flight Search");
		System.out.println("*************************************************"
				           + "*********************************************");
		
		String inputs[]=UserInput.getInputs();
		
//		after getting the inputs calling the go function to continue with the rest of the execution 
		go(inputs);
		
		
		
		System.out.println("***************************************************"
	            + "*******************************************");
		System.out.println("                                   Thank You");
		System.out.println("*************************************************"
	           + "*********************************************");
		
	}
	
//	Function to get input if user want to search more or not 
	
	
//	Function to all other helper functions after getting the input
	public static void go(String inputs[]) throws InterruptedException, ExecutionException, ParseException {
		
//		Getting the path of all the available csv files
		String[] files=FilesList.getFilesPath();
		
//		
		
//	    Using multithreading with each thread reading a specific file
		ExecutorService es=Executors.newFixedThreadPool(3);
		
       
		for(int i=0;i<files.length;i++) {
			
//			
			Search search=new Search(files[i]);
			es.submit(search);
		}
		
//		Waiting for threads to execute
		Thread.sleep(5000);
		
//		Calling helper function to get flight details from database
		List<Flight> res=HibUtils.getFlights(inputs[0],inputs[1],inputs[2]);
		
//		Filtering them on basis of class
		res=filter(res,inputs[3],inputs[2]);
		
//		Sorting the final result
		flightSort(inputs[4],res);
		
		displayAll(res);

	}
	
//	function to sort the flights list
	public static void flightSort(String input,List<Flight> finalRes) {
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
	public static void displayAll(List<Flight> list){
		
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
	
	
public static List<Flight> filter(List<Flight> list,String cls,String date) throws ParseException{
	List<Flight> res=new ArrayList<Flight>();
	for(Flight f:list) {
		if(f.getFClass().toLowerCase().contains(cls.toLowerCase()) && f.isAvailable() && f.dateValid(date)) {
			if(cls.equalsIgnoreCase("B")) {
				f.changePrice();
			}
			res.add(f);

		}
	}
	return res;
}

	
	
}
