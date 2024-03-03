package com.BlueChem.sbtp.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BlueChem.sbtp.entity.Cart;
import com.BlueChem.sbtp.entity.Customer;
import com.BlueChem.sbtp.entity.StoreMdcn;
import com.BlueChem.sbtp.entity.mdcnProducts;
import com.BlueChem.sbtp.exception.ProductException;
import com.BlueChem.sbtp.repository.CartRepository;
import com.BlueChem.sbtp.repository.CustomerRepository;
import com.BlueChem.sbtp.repository.ProductsRepository;
import com.BlueChem.sbtp.repository.StoreMdcnRepository;
import com.BlueChem.sbtp.service.ProductService;

@Service
public class ProductsServiceImpl  implements ProductService {

	@Autowired
	ProductsRepository productRepository;
	
	@Autowired
	StoreMdcnRepository storeRepository;
	
	
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired 
	CustomerRepository customerRepository;

	@Override
	public mdcnProducts createProduct(mdcnProducts product) {   //adding recording into our table
	
		return	productRepository.save(product);
	
	}

	@Override
	public List<mdcnProducts> getAll() {
		return productRepository.findAll();
	}

	@Override
	public mdcnProducts findProductById(int mdcnid) {
		return productRepository.findById(mdcnid).get();
	}

	@Override
	public mdcnProducts updateProduct(int mdcnid, mdcnProducts product) {
		mdcnProducts p=productRepository.findById(mdcnid).get();
		p.setMdcnName(product.getMdcnName());
		p.setMdcnType(product.getMdcnType());
		p.setCmpnyOfmdcn(product.getCmpnyOfmdcn());
		p.setMdcnCost(product.getMdcnCost());
		p.setMdcnDose(product.getMdcnDose());
		p.setMdcnStock(product.getMdcnStock());
		return productRepository.save(p);
	}

	@Override
	public String deleteProduct(int mdcnid) {
		
		mdcnProducts p=productRepository.findById(mdcnid).get();
		
		
		productRepository.deleteById(mdcnid);
		return "Your record has been deleted!";
		
	
		}

	@Override
	public String assignStoreToProduct(int sid, int mdcnid) {
	
		StoreMdcn store=storeRepository.findById(sid).get();
		mdcnProducts p=productRepository.findById(mdcnid).get();
		p.setStore(store);
		productRepository.save(p);
		
		
	
		
		return "store is assigned";
		
	}

	@Override
	public String orderProduct(Customer customer) {
		List<Cart> cart=customer.getCart();
		Double sum=0.00;
		
		for(Cart i:cart)
		{
			mdcnProducts p=productRepository.findById(i.getMdcnProductsid()).get();
		    System.out.println(i.getMdcnProductsid());		try
			{
				if(i.getQuantity()>p.getMdcnStock())
					throw new ProductException("Out of stock");
			}
			catch(ProductException e)
			{
				return p.getMdcnName()+" is "+e.getMessage();
			}
			i.setTotal(i.getQuantity()*p.getMdcnCost());
			i.setOrderno(customer);
		
			cartRepository.save(i);
			sum=sum+i.getTotal();  
			p.setMdcnStock(p.getMdcnStock()-i.getQuantity());
			productRepository.save(p);
		
		}

		
		customer.setTotalPrice(sum);
		customerRepository.save(customer);
	
		return "your order has been placed successfully";
		
	}
	
	@Override
	public List<Cart> orderDetails(Long orderno)
	{
		Customer customer=customerRepository.findById(orderno).get();
	List<Cart> cart=customer.getCart();		
		return cart;
	}

}


























