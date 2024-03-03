package com.BlueChem.sbtp.service;

import com.BlueChem.sbtp.entity.UserLogin;


public interface UserLoginService {
	
  String signup(UserLogin userLogin);
  String login(String email, String password);
}
