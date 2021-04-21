package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.protobuf.TextFormat.ParseException;
import com.hib.FlightUtils;
import com.models.Flight;

@Controller
public class SearchController {

	@RequestMapping("search")
	public ModelAndView search(HttpServletRequest request, HttpServletResponse response) throws java.text.ParseException {
		String dep=request.getParameter("dep");
		String arr=request.getParameter("arr");
		String date=request.getParameter("date");
		date=dateFormat(date);
		String sort=request.getParameter("sort");
		String cls=request.getParameter("class");
		ArrayList<Flight> res=go(dep,arr,date,sort,cls);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("display.jsp");
		mv.addObject("result", res);
		return mv;
	}
	
	public ArrayList<Flight> go(String dep,String arr,String date,String sort,String cls) throws java.text.ParseException{
		ArrayList<Flight> res=FlightUtils.searchFlight(dep, arr);
		res=filter(res,date,cls);
		flightSort(sort,res);
		return res;
	}
	public ArrayList<Flight> filter(ArrayList<Flight> res,String date,String cls) throws java.text.ParseException{
		ArrayList<Flight> fres=new ArrayList<>();
		for(Flight f:res) {
			if(f.getFClass().contains(cls) && f.isAvailable() && f.dateValid(date)) {
				
				if(cls.equalsIgnoreCase("b")){
					f.changePrice();
				}
				fres.add(f);
				System.out.println(f.getFlightNo());
			}
		}
		return fres;
	}
	
	
	public static void flightSort(String input,ArrayList<Flight> finalRes) {
		if (input.equalsIgnoreCase("F")) {
			finalRes.sort((Flight f1, Flight f2) -> f1.getFare().compareTo(f2.getFare()));
		} else {
			finalRes.sort((Comparator<? super Flight>) new Comparator<Flight>() {

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
	
	public String dateFormat(String strDate) throws java.text.ParseException {
		//create SimpleDateFormat object with source string date format
	      SimpleDateFormat sdfSource = new SimpleDateFormat("yyyy-mm-dd");
	      
	      //parse the string into Date object
	      Date date = sdfSource.parse(strDate);
	      
	      //create SimpleDateFormat object with desired date format
	      SimpleDateFormat sdfDestination = new SimpleDateFormat("dd-mm-yyyy");
	      
	      //parse the date into another format
	      strDate = sdfDestination.format(date);
	      
	      System.out.println(strDate);
	      return strDate;
		
	  }
	}

