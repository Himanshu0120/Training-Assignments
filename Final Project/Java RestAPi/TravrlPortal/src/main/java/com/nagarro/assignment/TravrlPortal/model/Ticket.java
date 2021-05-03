package com.nagarro.assignment.TravrlPortal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int tid;
	
	String requesttype;
	String priority;
	String travelcity;
	String fromcity;
	String startdate;
	String enddate;
	String passportnumber;
	String projectname;
	String expenseby;
	String travelapprovername;
	String duration;
	String upperbound;
	String otherdetails;
	String ticketdate;
	String comments;
	String status;
	
	int uid;
	public Ticket(int id, String requesttype, String priority, String travelcity, String fromcity, String startdate,
			String enddate, String passportnumber, String projectname, String expenseby, String travelapprovername,
			String duration, int uid,String upperbound, String otherdetails, String comments, String status,String ticketdate) {
		super();
		this.tid = id;
		this.requesttype = requesttype;
		this.priority = priority;
		this.travelcity = travelcity;
		this.fromcity = fromcity;
		this.startdate = startdate;
		this.enddate = enddate;
		this.passportnumber = passportnumber;
		this.projectname = projectname;
		this.expenseby = expenseby;
		this.travelapprovername = travelapprovername;
		this.duration = duration;
		this.upperbound = upperbound;
		this.otherdetails = otherdetails;
		this.comments = comments;
		this.status = status;
		this.uid=uid;
		this.ticketdate=ticketdate;
		
	}
	public String getTicketdate() {
		return ticketdate;
	}
	public void setTicketdate(String ticketdate) {
		this.ticketdate = ticketdate;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public Ticket() {
		super();
	}

	public String getRequesttype() {
		return requesttype;
	}
	public void setRequesttype(String requesttype) {
		this.requesttype = requesttype;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getTravelcity() {
		return travelcity;
	}
	public void setTravelcity(String travelcity) {
		this.travelcity = travelcity;
	}
	public String getFromcity() {
		return fromcity;
	}
	public void setFromcity(String fromcity) {
		this.fromcity = fromcity;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getPassportnumber() {
		return passportnumber;
	}
	public void setPassportnumber(String passportnumber) {
		this.passportnumber = passportnumber;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public String getExpenseby() {
		return expenseby;
	}
	public void setExpenseby(String expenseby) {
		this.expenseby = expenseby;
	}
	public String getTravelapprovername() {
		return travelapprovername;
	}
	public void setTravelapprovername(String travelapprovername) {
		this.travelapprovername = travelapprovername;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getUpperbound() {
		return upperbound;
	}
	public void setUpperbound(String upperbound) {
		this.upperbound = upperbound;
	}
	public String getOtherdetails() {
		return otherdetails;
	}
	public void setOtherdetails(String otherdetails) {
		this.otherdetails = otherdetails;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
