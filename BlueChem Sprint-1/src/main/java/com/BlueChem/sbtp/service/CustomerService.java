package com.BlueChem.sbtp.service;

import com.BlueChem.sbtp.entity.Customer;

//abstract method for performing CRUD on entity Customer

public interface CustomerService {
	
	//register an new customer in db table
	Customer createCustomer(Customer customer);
	
	//edit existing customer detail based on id from db table
	Customer editCustomer(Customer customer, long orderno);
	
	//remove existing customer record based on id from db table
	void removeCustomer(long orderno);
	
	//fetch customer details based on from db table
	Customer fetchCustomerDetail(long orderno);
}
