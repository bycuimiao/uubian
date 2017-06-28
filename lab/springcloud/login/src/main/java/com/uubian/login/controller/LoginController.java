package com.uubian.login.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.uubian.login.domain.UserBase;





@RestController()
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/login")
	public List<UserBase> getAll(){
		
		return restTemplate.getForObject("http://localhost:2001/userbase/getAllList", List.class);
		
	}
	
}
