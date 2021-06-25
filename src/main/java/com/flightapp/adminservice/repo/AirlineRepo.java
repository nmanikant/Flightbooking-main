package com.flightapp.adminservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.adminservice.entity.Airline;


@Repository
public interface AirlineRepo extends JpaRepository<Airline, Integer>  {
	

}
