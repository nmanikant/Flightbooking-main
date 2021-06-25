package com.flightapp.adminservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.adminservice.entity.Flights;
import com.flightapp.adminservice.repo.FlightRepo;

@Service
public class FlightService {

	@Autowired
    private FlightRepo repo;
	
	public List<Flights> getAllFlights() {
        return repo.findAll();
    }
	
	public Flights addFlight(Flights flight) {
       return repo.save(flight);
    }
     
    public Flights getFlightById(int id) {
        return repo.findById(id).get();
    }
     
    public void deleteFlightById(int id) {
        repo.deleteById(id);   
    }
    
    public Flights updateFlight(Flights flights, int flightId) {
    	Optional<Flights> flight=repo.findById(flightId);
    	if(flight.isPresent()) {
    		Flights updateFlight=flight.get();
    		if(flights.getArrival() != null && !flights.getArrival().isEmpty()) {
    			updateFlight.setArrival(flights.getArrival());
    		}
    		if(flights.getDepature() !=null && !flights.getDepature().isEmpty()) {
    			updateFlight.setDepature(flights.getDepature());
    		}
    		
    		if(flights.getStartTime() !=null && !flights.getStartTime().isEmpty()) {
    			updateFlight.setStartTime(flights.getStartTime());	
    		}
    		
    		if(flights.getEndTime() != null && !flights.getEndTime().isEmpty()) {
    			updateFlight.setEndTime(flights.getEndTime());	
    		}
    		
    		if(flights.getDuration() !=null && !flights.getDuration().isEmpty()) {
    			updateFlight.setDuration(flights.getDuration());
    			
    		}
    		
    		if(flights.getPrice() >0) {
    			updateFlight.setPrice(flights.getPrice());	
    		}
    		
    		return repo.save(updateFlight);
    	}
    	else {
    		return	repo.save(flights); 
    	}	         
    }
       
    public List<Flights> getFlightsByData(String depature,String arrival) {
        return repo.getFlightsByData(depature, arrival);
    }

	public int deleteFlightByNum(String flightNumber,String airlineName) {
		// TODO Auto-generated method stub
		return repo.deleteFlightByNum(flightNumber,airlineName);
	}

	public List<Flights> getFlightsByDate(String depature, String arrival, String date) {
		// TODO Auto-generated method stub
		return repo.getFlightByDate(depature,arrival,date);
	}

	
    
	
}
