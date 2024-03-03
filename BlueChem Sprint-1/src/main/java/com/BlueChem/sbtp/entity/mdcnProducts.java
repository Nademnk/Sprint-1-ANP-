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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
public class mdcnProducts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mdcnid;
	
	@Column(length = 25, nullable = false, unique = true)
	@NotBlank(message="Name is mandotory to provide")
	private String mdcnName;
	
	@NotBlank(message="Type is mandotory to mention")
	@Column(length=40, nullable = false)
	private String mdcnType;
	
	@NotBlank(message="medicines company  is mandatory to provide")
	@Column(length=40, nullable = false)
	private String cmpnyOfmdcn;
	
	@NotNull(message="costOf medicine is mandatory to enter")
	@Column(length=15, nullable = false)
	private int mdcnCost;
	
	
	@NotBlank(message="Dose is mandatory")
	@Column(length=50, nullable = false)
	private String  mdcnDose ;
	
	@NotNull(message="Stock is mandatory to enter")
	@Column(length=60, nullable = false)
	private int mdcnStock;
	
	
	
	public int getMdcnid() {
		return mdcnid;
	}



	public void setMdcnid(int mdcnid) {
		this.mdcnid = mdcnid;
	}



	public String getMdcnName() {
		return mdcnName;
	}



	public void setMdcnName(String mdcnName) {
		this.mdcnName = mdcnName;
	}



	public String getMdcnType() {
		return mdcnType;
	}



	public void setMdcnType(String mdcnType) {
		this.mdcnType = mdcnType;
	}



	public String getCmpnyOfmdcn() {
		return cmpnyOfmdcn;
	}



	public void setCmpnyOfmdcn(String cmpnyOfmdcn) {
		this.cmpnyOfmdcn = cmpnyOfmdcn;
	}



	public int getMdcnCost() {
		return mdcnCost;
	}



	public void setMdcnCost(int mdcnCost) {
		this.mdcnCost = mdcnCost;
	}



	public String getMdcnDose() {
		return mdcnDose;
	}



	public void setMdcnDose(String mdcnDose) {
		this.mdcnDose = mdcnDose;
	}



	public int getMdcnStock() {
		return mdcnStock;
	}



	public void setMdcnStock(int mdcnStock) {
		this.mdcnStock = mdcnStock;
	}



	public StoreMdcn getStore() {
		return store;
	}



	public void setStore(StoreMdcn store) {
		this.store = store;
	}



	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JsonBackReference
	private StoreMdcn store;
}
