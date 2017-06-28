package com.uubian.userbase.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uubian.userbase.domain.UserBase;
import com.uubian.userbase.repository.UseBaseRepository;




@RestController()
@RequestMapping("/userbase")
public class UserBaseController {
	@Autowired
	private UseBaseRepository useBaseRepository;
	@GetMapping("/getAllList")
	public List<UserBase> getAll(){
		
		return useBaseRepository.findAll();
	}
	
}
