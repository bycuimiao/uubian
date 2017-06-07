package com.uubian.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uubian.api.domain.dto.Message;
import com.uubian.api.domain.postgres.UserBase;
import com.uubian.api.repository.jdbc.UseBaseRepository;
import com.uubian.api.tool.BCrypt;


@RestController()
@RequestMapping("/UserBase")
public class UserBaseController {
	@Autowired
	private UseBaseRepository useBaseRepository;
	
	@GetMapping("/getListUser")
	public List<UserBase> getAll(){
		List<UserBase> users = useBaseRepository.getUserList(null);
		return users;
	}
	@GetMapping("/deleteUserById/{id}")
	public Message getAll(@PathVariable int id){
		int num = useBaseRepository.delete(id);
		if(num==1){
			return Message.init(200);
		}else{
			return Message.init(202);
		}
	}
	@PostMapping("/save")
	public Message save(@RequestBody UserBase userBase){
		userBase.setPassword(BCrypt.hashpw(userBase.getPassword(), BCrypt.gensalt()));
		int num = useBaseRepository.save(userBase);
		if(num==1){
			return Message.init(200);
		}else{
			return Message.init(202);
		}
	}
	@PostMapping("/update")
	public Message update(@PathVariable UserBase userBase){
		userBase.setPassword(BCrypt.hashpw(userBase.getPassword(), BCrypt.gensalt()));
		int num = useBaseRepository.update(userBase);
		if(num==1){
			return Message.init(200);
		}else{
			return Message.init(202);
		}
		
	}
}
