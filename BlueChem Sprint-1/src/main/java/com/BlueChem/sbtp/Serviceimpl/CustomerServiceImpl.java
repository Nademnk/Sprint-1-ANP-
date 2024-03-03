package com.BlueChem.sbtp.Serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BlueChem.sbtp.entity.Customer;
import com.BlueChem.sbtp.exception.CustomerIDNotFoundException;
import com.BlueChem.sbtp.repository.CustomerRepository;
import com.BlueChem.sbtp.service.CustomerService;

@Service
public class CustomerServiceImpl  implements CustomerService{

	//using spring dependency injection which marks constructor, getter-setter

	//Registering customer into db table using save of jpaRepository

	@Autowired
	CustomerRepository custRepo;
	//editing customer details using findById() & save() of JpaRepository 
	@Override
	public Customer editCustomer(Customer customer, long orderno) {
		//fetch customer data based on id, if not found throw exception 
		Customer updatedCustomerdetails = custRepo.findById(orderno).orElseThrow(() -> new CustomerIDNotFoundException("Entered Customer id is not proper / Invalid"));

		//set new values to customer entity
		updatedCustomerdetails.setMobile(customer.getMobile());
		updatedCustomerdetails.setAddr(customer.getAddr());

		custRepo.save(updatedCustomerdetails); //saving updated info in Customer Entity
		return updatedCustomerdetails;
	}

	//removing an customer record from db table using deleteById() of JpaRepository
	@Override
	public void removeCustomer(long orderno) {
		//fetch customer data based on id, if not found throw exception 
		custRepo.findById(orderno).orElseThrow(() -> new CustomerIDNotFoundException("Entered Customer id is not proper / Invalid"));

		//if id found then delete data of customer 
		custRepo.deleteById(orderno);

	}
	//fetch an customer record from db table using findById() of JpaRepository
	@Override
	public Customer fetchCustomerDetail(long orderno) {
		//fetch customer data based on id, if not found throw exception 
		return custRepo.findById(orderno).orElseThrow(() -> new CustomerIDNotFoundException("Entered Customer id is not proper / Invalid"));
	}



	@Override
	public Customer createCustomer(Customer customer) {
		return custRepo.save(customer);
	}
	
	
}
