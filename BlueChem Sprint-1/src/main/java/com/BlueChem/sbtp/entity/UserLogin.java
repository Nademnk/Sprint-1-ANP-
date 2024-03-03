package com.BlueChem.sbtp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity   //for creating table
@Table(name="UserLogin")   //specify the name of table in database

public class UserLogin {
	@Id //primary key
	 @GeneratedValue(strategy=GenerationType.IDENTITY)  
	private Long id;
	
	private String email;
	private String password;
}

