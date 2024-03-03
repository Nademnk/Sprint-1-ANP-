package com.BlueChem.sbtp.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoreMdcn {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sid;
	
	@Column(name="mdcnName", length=30, nullable = false, unique = true)
	private String smName;
	
	@Column(name="contactNo", nullable = false, unique = true)
	private long contactNo;
	
	@Column(name="city", length=30, nullable = false)
	private String city ;
	
	@Column(name="addr", length=40, nullable = false)
	private String addr;
	
	@Column(name="avaliability", length=40, nullable = false)
	private String avaliability;
	
	@OneToMany(mappedBy="store")
	@JsonManagedReference
    List<mdcnProducts> mdcnProduct;
}









