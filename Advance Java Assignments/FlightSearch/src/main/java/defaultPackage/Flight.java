package defaultPackage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//A flight object will be created for each line in the csv file so this class contains all the getter,setters , validations and object related functions
public class Flight {
	private String flight_no;
	private String dep_loc;
	private String arr_loc;
	private String valid_till;
	private String flight_time;
	private String flight_dur;
	private String fare;
	private String seat_availability;
	private String flight_class;
	
	Flight(String flight_no,String dep_loc,String arr_loc,String valid_till,String flight_time,
		   String flight_dur,String fare,String seat_availability,String flight_class)
	{
		this.flight_no=flight_no;
		this.dep_loc=dep_loc;
		this.arr_loc=arr_loc;
		this.valid_till=valid_till;
		this.flight_time=flight_time;
		this.flight_dur=flight_dur;
		this.fare=fare;
		this.seat_availability=seat_availability;
		this.flight_class=flight_class;
		
	}
	
	public void display() {
		System.out.println("Flight No : "+this.flight_no);
		System.out.println("Departure Location Code : "+this.dep_loc);
		System.out.println("Arrival Location Code : "+this.arr_loc);
		System.out.println("Flight Valid till : "+this.valid_till);
		System.out.println("Flight Time : "+this.flight_time);
		System.out.println("Flight Duration : "+this.flight_dur);
		System.out.println("Fare : "+this.fare);
	}
	
	public boolean checkFlight(String dep,String arr,String date,String cls) throws ParseException {
		if(this.flight_class.contains(cls.toUpperCase()) && this.dep_loc.equalsIgnoreCase(dep) && this.arr_loc.equalsIgnoreCase(arr) && dateValid(date)  && this.seat_availability.equals("Y")) {
			return true;
		}
		return false;
	}
	
	public void changePrice() {
		float f=Integer.parseInt(this.fare);
		f+=0.4*f;
		this.fare=String.valueOf(f);
	}
	
	public String getFare() {
		return this.fare;
	}
	
	public String getDur() {
		return this.flight_dur;
	}
	
	public boolean dateValid(String date) throws ParseException {
		SimpleDateFormat sdfo = new SimpleDateFormat("dd-MM-yyyy"); 
		Date d1 = sdfo.parse(this.valid_till); 
        Date d2 = sdfo.parse(date);
        if (d1.compareTo(d2) > 0) { 
        	  
            return true; 
        } 
        return false;
	}
	

}
