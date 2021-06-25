package com.flightapp.adminservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flightapp.adminservice.entity.Flights;




@Repository
public interface FlightRepo  extends JpaRepository<Flights, Integer>  {

	
	@Query("SELECT f FROM Flights f  WHERE f.depature=?1 and f.arrival=?2")
	List<Flights> getFlightsByData(String depature,String arrival);
	
	@Query("SELECT f FROM Flights f  WHERE f.flightNumber=?1 ")
	Flights getFlightsByNum(String flightNumber);
	
	@Modifying
	@Query("DELETE  FROM Flights f  WHERE f.flightNumber=?1 and airlineName=?2 ")
	int deleteFlightByNum(String flightNumber,String airlineName);

	
	@Query("SELECT f FROM Flights f  WHERE f.depature=?1 and f.arrival=?2 and travelDate=?3")
	List<Flights> getFlightByDate(String depature, String arrival, String date);
	
	
}
