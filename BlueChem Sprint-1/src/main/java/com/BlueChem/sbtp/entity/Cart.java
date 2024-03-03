package com.BlueChem.sbtp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
   
	
	
	public int getCartId() {
		return cartId;
	}



	public void setCartId(int cartId) {
		this.cartId = cartId;
	}



	public int getMdcnProductsid() {
		return mdcnProductsid;
	}



	public void setMdcnProductsid(int mdcnProductsid) {
		this.mdcnProductsid = mdcnProductsid;
	}



	public int getQuantity() {
		return Quantity;
	}



	public void setQuantity(int quantity) {
		Quantity = quantity;
	}



	public int getTotal() {
		return total;
	}



	public void setTotal(int total) {
		this.total = total;
	}



	public Customer getOrderno() {
		return orderno;
	}



	public void setOrderno(Customer orderno) {
		this.orderno = orderno;
	}



	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int cartId;
	
	@Column(length=25, nullable=false)
	private int mdcnProductsid;
	
	@Column(length=34, nullable=false)
	private int Quantity;
	
	@Column(length=100, nullable=false)
	private int total;
	
	
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JsonBackReference
	private Customer orderno;



	
	
}










