package com.citibridge.arbitragerecommendation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citibridge.arbitragerecommendation.login_entities.User;
import com.citibridge.arbitragerecommendation.repositories.UserRepository;
@Service
public class LoginService {
@Autowired
UserRepository userRepository;
	public boolean authenticate(String emailId,String pwd)
	{
		System.out.println(emailId+" "+pwd);
		User user=userRepository.findByEmail(emailId);
		if (user!=null && user.getPassword().compareTo(pwd)==0) {
			return true;
		}
		return false;
	}
}
