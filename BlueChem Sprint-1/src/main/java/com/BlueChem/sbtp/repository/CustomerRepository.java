package com.BlueChem.sbtp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.BlueChem.sbtp.entity.Customer;

//Repository to get predefined method of JpaRepository for Customer Entity
public interface CustomerRepository  extends JpaRepository<Customer, Long>{
	
	
}
