package com.uubian.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uubian.api.annotation.Privilege;
import com.uubian.api.common.BCrypt;
import com.uubian.api.domain.dto.Message;
import com.uubian.api.domain.postgres.UserBase;
import com.uubian.api.factory.TokenFactory;
import com.uubian.api.repository.postgres.UseBaseRepository;
import com.uubian.api.repository.redis.TockenRepository;


@RestController()
@RequestMapping("/Login")
public class LoginController {
	@Autowired
	private UseBaseRepository useBaseRepository;
	
    @Autowired
	public TockenRepository tockenRepository;
    
    @Privilege
	@GetMapping("/login/{username}/{password}")
	public Message save(@PathVariable String username,@PathVariable String password){
		UserBase userBase = useBaseRepository.getUserBaseByUsername(username);
		if(userBase!=null&&BCrypt.checkpw(password, userBase.getPassword())){
			String tocken = TokenFactory.productionToken();
			tockenRepository.setTocken(tocken, userBase.getId()+"");
			return Message.init(200,tocken);
		}else{
			return Message.init(202);
		}
		
		
	}
	@GetMapping("/logout")
	public Message update(){
		
		return Message.init(203);
	}
}
