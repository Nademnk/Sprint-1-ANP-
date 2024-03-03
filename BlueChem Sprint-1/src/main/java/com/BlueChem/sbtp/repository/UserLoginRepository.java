package com.BlueChem.sbtp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.BlueChem.sbtp.entity.UserLogin;

public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {


	@Query(value="select * from User_login ul where ul.email =(:query)", nativeQuery=true)
	
	UserLogin findbyemailid(String query);
	
	

}
