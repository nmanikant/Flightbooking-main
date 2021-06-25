package com.flightapp.adminservice.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Airline {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int airlineId;
	@Column
	String airlineName;
	
	@Column()
	String contactAddress;
	@Column()
	int contactNumber;
	@Column
	String flightNumber;
	 
	
	
	
	
	  public String getFlightNumber() { return flightNumber; }
	  
	  public void setFlightNumber(String flightNumber) { this.flightNumber =
	  flightNumber; }
	 
	

	/*flight details*/
	public Airline() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(int airlineId) {
		this.airlineId = airlineId;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	
	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public int getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}

	
	
	
	
	

}
