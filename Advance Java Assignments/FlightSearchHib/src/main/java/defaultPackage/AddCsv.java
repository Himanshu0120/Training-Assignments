package defaultPackage;

import java.io.*;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
import java.util.ArrayList;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

public class AddCsv {
	
//	method to read a csv file and add all data to the database
	public static void Add(String path) throws CsvValidationException, IOException, ParseException {
		FileReader filereader = new FileReader(path);
		CSVParser parser = new CSVParserBuilder().withSeparator('|').build();

		CSVReader csvReader = new CSVReaderBuilder(filereader).withCSVParser(parser).build();
		String[] nextRecord;
		int count = 0;
		ArrayList<Flight> result=new ArrayList<Flight>();
		
//		reading each line
		while ((nextRecord = csvReader.readNext()) != null) {
			if (count == 0) {
//				first line to be skipped
				count++;
				continue;
			}
//			Storing the values from each line
			String flight_no = nextRecord[0];
			String dep_loc = nextRecord[1];
			String arr_loc = nextRecord[2];
			String valid_till = nextRecord[3];
			String flight_time = nextRecord[4];
			String flight_dur = nextRecord[5];
			String fare = nextRecord[6];
			String seat_availability = nextRecord[7];
			String flight_class = nextRecord[8];
			
//			Creating a new flight object
			Flight flight = new Flight(flight_no, dep_loc, arr_loc, valid_till, flight_time, flight_dur, fare,
					seat_availability, flight_class);
			
//			Storing the object
			HibUtils.addToDb(flight);
			
			
			
			count++;
			
		}
		
	}
	
}
