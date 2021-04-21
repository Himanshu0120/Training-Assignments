package defaultPackage;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.concurrent.Callable;

import com.opencsv.exceptions.CsvValidationException;

//class for implementing  multi threading 
public class Search implements Callable {
	private String depLoc;
	private String  arrLoc;
	private String date;
	private String flightClass;
	private String OutputPreference;
	private String file;
	
//	Constructing the thread object providng the file path and user inputs
	public Search(String[] inputs,String file){
		depLoc=inputs[0];
		arrLoc=inputs[1];
		date=inputs[2];
		this.file=file;
		flightClass=inputs[3];
	}
//	Call function to return the filtered list of flights for each thread
	 public ArrayList<Flight> call() throws ParseException {
		try {
			return(FilterCsv.filter(file,depLoc,arrLoc,date,flightClass));
		} catch (CsvValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
