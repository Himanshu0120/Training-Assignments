package com.models;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//A flight object will be created for each line in the csv file so this class contains all the getter,setters , validations and object related functions
@javax.persistence.Entity(name = "Flight")
@Table
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int flightId;
	private String flight_no;
	private String dep_loc;
	private String arr_loc;
	private String valid_till;
	private String flight_time;
	private String flight_dur;
	private String fare;

	private String seat_availability;
	private String flight_class;
	
	public Flight() {}
	public Flight(String flight_no,String dep_loc,String arr_loc,String valid_till,String flight_time,
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
	
	public String getValid_till() {
		return valid_till;
	}
	public void setValid_till(String valid_till) {
		this.valid_till = valid_till;
	}
	public String getFlight_time() {
		return flight_time;
	}
	public void setFlight_time(String flight_time) {
		this.flight_time = flight_time;
	}
	public String getFlight_dur() {
		return flight_dur;
	}
	public void setFlight_dur(String flight_dur) {
		this.flight_dur = flight_dur;
	}
	public String getDep_loc() {
		return dep_loc;
	}
	public void setDep_loc(String dep_loc) {
		this.dep_loc = dep_loc;
	}
	public String getArr_loc() {
		return arr_loc;
	}
	public void setArr_loc(String arr_loc) {
		this.arr_loc = arr_loc;
	}
	public String getFlightNo() {
		return this.flight_no;
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
//        System.out.println(this.valid_till+"  "+date);
        return false;
	}
	public String getFClass() {
		return this.flight_class;
	}
	public boolean isAvailable() {
		if(this.seat_availability.equalsIgnoreCase("y"))
			return true;
		return false;
	} 

}
