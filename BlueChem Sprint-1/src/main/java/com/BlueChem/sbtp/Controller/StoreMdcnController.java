package com.BlueChem.sbtp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BlueChem.sbtp.entity.StoreMdcn;
import com.BlueChem.sbtp.service.StoreMdcnService;

import jakarta.validation.Valid;

//Controller for all incoming request on StoreMdcn entity 
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class StoreMdcnController {

	@Autowired
	StoreMdcnService sms;
	
	
	@GetMapping("/show")
	public List<StoreMdcn> getAll()
	{
		return sms.getAll();
	}
	
	@PostMapping("/createstore")
	public StoreMdcn createStore(@RequestBody StoreMdcn store)
	{
		return sms.createStore(store);
	}
}
