package com.uubian.api.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uubian.api.annotation.Privilege;
import com.uubian.api.common.BCrypt;
import com.uubian.api.domain.dto.Message;
import com.uubian.api.domain.postgres.UserBase;
import com.uubian.api.domain.redis.Token;
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
	public Map<String,Object> login(@PathVariable String username,@PathVariable String password){
		UserBase userBase = useBaseRepository.getUserBaseByUsername(username);
		Map<String,Object> map = new HashMap<String, Object>();
		if(userBase!=null&&BCrypt.checkpw(password, userBase.getPassword())){
			String access_token = TokenFactory.productionToken();
			Token token = new Token();
			token.setAccess_token(access_token);
			token.setUserBase(userBase);
			tockenRepository.setTocken(access_token, userBase.getId()+"");
			map.put("msg", Message.init(200));
			map.put("token", token);
		}else{
			map.put("msg", Message.init(202,"用户名或者密码错误"));
		}
		return map;
		
	}
	@GetMapping("/logout")
	public Message update(){
		
		return Message.init(203);
	}
}
