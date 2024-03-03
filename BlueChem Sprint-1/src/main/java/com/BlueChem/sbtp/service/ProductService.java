package com.BlueChem.sbtp.service;

import java.util.List;

import com.BlueChem.sbtp.entity.Cart;
import com.BlueChem.sbtp.entity.Customer;
import com.BlueChem.sbtp.entity.mdcnProducts;

public  interface ProductService {

        
	mdcnProducts createProduct( mdcnProducts product);
	List< mdcnProducts> getAll();
	mdcnProducts findProductById(int mdcnid);
	mdcnProducts updateProduct(int mdcnid, mdcnProducts product);
	String deleteProduct(int mdcnid);
	String assignStoreToProduct(int sid, int mdcnid);
	String orderProduct(Customer customer);
	List<Cart> orderDetails(Long orderno);
}
