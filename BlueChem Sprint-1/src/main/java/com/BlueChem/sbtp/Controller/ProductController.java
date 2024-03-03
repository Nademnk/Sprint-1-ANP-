package com.BlueChem.sbtp.Controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BlueChem.sbtp.entity.Cart;
import com.BlueChem.sbtp.entity.Customer;
import com.BlueChem.sbtp.entity.mdcnProducts;
import com.BlueChem.sbtp.service.ProductService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/mdcnProducts")

public class ProductController {

	
	
	@Autowired
	ProductService productService;           
	
	@PostMapping("/createmdcn")  //adding record in table
	public mdcnProducts createProduct(@RequestBody  mdcnProducts  mdcnProducts)
	{
		return productService.createProduct(mdcnProducts);
	}
	
	@GetMapping("/show")
	public List<mdcnProducts> getALL()
	{
		return productService.getAll();
	}
	
   @GetMapping("/find/{mdcnid}")
   public mdcnProducts findById(@PathVariable int mdcnid)
   {
	   return productService.findProductById(mdcnid);
   }
   
   @PutMapping("/update/{mdcnid}")
   public  mdcnProducts updateProduct(@PathVariable int mdcnid, @RequestBody  mdcnProducts mdcnProducts)
   {
	   return productService.updateProduct(mdcnid, mdcnProducts);
   }
   
   @DeleteMapping("/delete/{mdcnid}")
   public String deleteProduct(@PathVariable int mdcnid)
   {
	   return productService.deleteProduct(mdcnid);
   }
   
   @PostMapping("/assign/{sid}/{mdcnid}")
   public String assignStoreToProduct(@PathVariable int sid, @PathVariable int mdcnid)
   {
	   return productService.assignStoreToProduct(sid, mdcnid);
   }
   
   @PostMapping("/orderproduct")
   public String orderProduct(@RequestBody Customer customer)
   {
	   return productService.orderProduct(customer);
   }
   
   @GetMapping("/displayorder/{orderno}")
   public List<Cart> orderDetails(@PathVariable Long orderno)
   {
	   return productService.orderDetails(orderno);
   }
}
