package com.flightapp.adminservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.flightapp.adminservice.entity.Airline;
import com.flightapp.adminservice.entity.Discount;
import com.flightapp.adminservice.entity.Flights;
import com.flightapp.adminservice.service.AirlineService;
import com.flightapp.adminservice.service.DiscountService;
import com.flightapp.adminservice.service.FlightService;

@RestController
@RequestMapping("/api/v1.0/flight")
@CrossOrigin

public class Controller {
	
	@Autowired 
	AirlineService airlineService;
	@Autowired 
	FlightService flightService;
	
	@Autowired 
	DiscountService discountService;
	
	  @GetMapping("/airlines")
	  public ResponseEntity<List<Airline>> getAllAirlines() {
	  List<Airline> list = airlineService.getAllAirlines();
	 
	  return new ResponseEntity<List<Airline>>(list,HttpStatus.OK); }
	 
	 @GetMapping("/airline/{id}")
	    public ResponseEntity<Airline> getAirline(@PathVariable("id") int id) {
	       Airline list = airlineService.getAirlineById(id);
	 
	        return new ResponseEntity<Airline>(list,HttpStatus.OK);
	    }
	 
	 @PostMapping("/addairline")
	    public ResponseEntity<Airline> addAirline(@RequestBody Airline airline)
	                                                    {
		 System.out.println("entered airlines");
		 Airline added =  airlineService.saveAirline(airline);
	        return new ResponseEntity<Airline>(added, new HttpHeaders(), HttpStatus.OK);
	    }
	 
	 @DeleteMapping("/deleteairline/{id}")
	    public HttpStatus deleteAirlineById(@PathVariable("id") int id) 
	                                                   {
		 airlineService.deleteAirlineById(id);
	        return HttpStatus.FORBIDDEN;
	    }
	
	 
	 /* flight service*/
	  
	 @GetMapping("/manageSchedule")
	    public ResponseEntity<List<Flights>> getAllFlights() {
	        List<Flights> list = flightService.getAllFlights();
	 
	        return new ResponseEntity<List<Flights>>(list,HttpStatus.OK);
	    }
	 @GetMapping("/flight/{id}")
	    public ResponseEntity<Flights> getFlight(@PathVariable("id") int id) {
		 Flights list = flightService.getFlightById(id);
	 
	        return new ResponseEntity<Flights>(list,HttpStatus.OK);
	    }
	 
	 /*get flight details by date*/
	 
	 @GetMapping("/result/{depature}/{arrival}/{date}")
	    public ResponseEntity<List<Flights>> getFlightByDate(@PathVariable("depature") String depature,@PathVariable("arrival") String arrival,@PathVariable("date") String date) {
		 List<Flights> list = flightService.getFlightsByDate(depature,arrival,date);
	 
	        return new ResponseEntity<List<Flights>>(list,HttpStatus.OK);
	    }
	 @GetMapping("/result/{depature}/{arrival}")
	    public ResponseEntity<List<Flights>> getFlightByLocation(@PathVariable("depature") String depature,@PathVariable("arrival") String arrival) {
		 List<Flights> list = flightService.getFlightsByData(depature,arrival);
	 
	        return new ResponseEntity<List<Flights>>(list,HttpStatus.OK);
	    }
	 
	 @DeleteMapping("/manageSchedule/{id}")
	    public HttpStatus deleteFlightById(@PathVariable("id") int id) 
	                                                   {
		 flightService.deleteFlightById(id);
	        return HttpStatus.FORBIDDEN;
	    }
	 
	 
	 /*delete flight by airline*/
	 
	 @DeleteMapping("/flights/{flightNumber}/{airlineName}")
	    public HttpStatus deleteFlightByNum(@PathVariable("flightNumber") String flightNumber
	    		,@PathVariable("airlineName") String airlineName) 
	     {
		 System.out.println("entered service");  
		 flightService.deleteFlightByNum(flightNumber,airlineName);
		 System.out.println("closed service"); 
	        return HttpStatus.FORBIDDEN;
	    }
	 
	
	 @PostMapping("/addflight")
	    public ResponseEntity<Flights> addFlight(@RequestBody Flights flight)
	                                                    {
		 Flights added =  flightService.addFlight(flight);
	        return new ResponseEntity<Flights>(added, new HttpHeaders(), HttpStatus.OK);
	    }
	 @PutMapping("/update/{flightId}")
	 public ResponseEntity<Flights> updateFlight(@PathVariable("flightId") int flightId,@RequestBody Flights flight)
	 {
		 Flights flightRes = flightService.updateFlight(flight,flightId);
		 System.out.println("entered update");
		 ResponseEntity<Flights> response =
					new ResponseEntity<Flights>(flightRes, HttpStatus.OK);
			return response;
			 
		 }

	 
	/*discount service
	 * */
	 
	 
	 @GetMapping("/discount")
	  public ResponseEntity<List<Discount>> getAllDiscounts() {
	  List<Discount> list = discountService.getAllDiscounts();
	 
	  return new ResponseEntity<List<Discount>>(list,HttpStatus.OK); }
	 
	 
	 @PostMapping("/adddiscount")
	    public ResponseEntity<Discount> addDiscount(@RequestBody Discount discount)
	                                                    {
		 Discount added =  discountService.addDiscount(discount);
	        return new ResponseEntity<Discount>(added, new HttpHeaders(), HttpStatus.OK);
	    }
	 
	 @DeleteMapping("/discount/{id}")
	    public HttpStatus deleteDeleteById(@PathVariable("id") int id) 
	                                                   {
		 discountService.deletediscountById(id);;
	        return HttpStatus.FORBIDDEN;
	    }
	 
	 @GetMapping("/discount/{promoCode}")
	  public ResponseEntity<Discount> getDiscountByPromo(@PathVariable("id") String promoCode) {
		 Discount discountPrice = discountService.getdiscountByPromo(promoCode);
	   return new ResponseEntity<Discount>(discountPrice,HttpStatus.OK); } 
	 
	
	 
}

