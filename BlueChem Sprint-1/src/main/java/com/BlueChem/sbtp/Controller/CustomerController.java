package com.BlueChem.sbtp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.BlueChem.sbtp.entity.Customer;
import com.BlueChem.sbtp.service.CustomerService;
import jakarta.validation.Valid;



	//handle all incoming request for entity customer
	@RestController
	@CrossOrigin(origins="http://localhost:4200")
	public class CustomerController {
		
		@Autowired 
		CustomerService customerService;
		
		
		//using get mapping to fetch customer based in id with http status OK & code 200
		@GetMapping("/fetchCustomer/{orderno}")
		//pathVariable - indicates that a method parameter should be bound to a URI template variable
		public ResponseEntity<Customer> fetchCustomer(@PathVariable("orderno") long orderno){
			return new ResponseEntity<Customer>(customerService.fetchCustomerDetail(orderno), HttpStatus.OK);	
		}
		
		//using delete mapping to remove customer based on id with 
		@DeleteMapping("/deleteCustomer/{orderno}")
		public ResponseEntity<String> deleteCustomer(@PathVariable("orderno") long orderno){
			customerService.removeCustomer(orderno);
			return new ResponseEntity<String>("Deleted Customer Record", HttpStatus.OK);
		}
		
		@PutMapping("/editCustomer/{orderno}")
		public ResponseEntity<Customer> editCustomer(@Valid @PathVariable("orderno") long orderno,
				@RequestBody Customer customer){
			return new ResponseEntity<Customer>(customerService.editCustomer(customer, orderno), HttpStatus.OK);
		}
	    
		

		@PostMapping("/register")
		public Customer createCustomer(@RequestBody Customer customer)
		{
			return customerService.createCustomer(customer);
		}
		
		
  }
	

