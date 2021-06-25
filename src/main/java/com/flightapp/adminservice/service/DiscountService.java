package com.flightapp.adminservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.adminservice.entity.Discount;

import com.flightapp.adminservice.repo.DiscountRepo;


@Service
public class DiscountService {
	@Autowired
    private DiscountRepo repo;
	
	public List<Discount> getAllDiscounts() {
        return repo.findAll();
    }
	
	public Discount addDiscount(Discount discount) {
	       return repo.save(discount);
	    }
	public void deletediscountById(int id) {
        repo.deleteById(id);   
    }

	public Discount getdiscountByPromo(String promoCode) {
		Discount discount=repo.getDiscountByPromo(promoCode);
		return discount;
	}    
	
}
