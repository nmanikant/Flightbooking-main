package com.flightapp.adminservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flightapp.adminservice.entity.Discount;

@Repository
public interface DiscountRepo  extends JpaRepository<Discount, Integer> {

	@Query("SELECT d from Discount d where promoCode=?1")
	Discount getDiscountByPromo(String promoCode);

}
