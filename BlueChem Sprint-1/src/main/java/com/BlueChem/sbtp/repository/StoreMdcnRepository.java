package com.BlueChem.sbtp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.BlueChem.sbtp.entity.StoreMdcn;

//Repository to get predefined method of JpaRepository for Entity HotelList 
public interface StoreMdcnRepository  extends JpaRepository<StoreMdcn, Integer>{
	
	
	

}
