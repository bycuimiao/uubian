package com.uubian.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uubian.api.annotation.Privilege;
import com.uubian.api.common.BCrypt;
import com.uubian.api.domain.dto.Message;
import com.uubian.api.domain.mongodb.Subject;
import com.uubian.api.domain.postgres.UserBase;
import com.uubian.api.repository.mongodb.SubjectRepository;
import com.uubian.api.repository.postgres.UseBaseRepository;


@RestController()
@RequestMapping("/subject")
public class SubjectController {
	@Autowired
	private SubjectRepository subjectRepository;
	
	@PostMapping("/save")
	public Map<String,Object> save(@RequestBody Subject subject){
		Map<String,Object> map = new HashMap<String, Object>();

		Subject result=subjectRepository.save(subject);
		
		if(result!=null){
			map.put("msg", Message.init(200,"sucess"));
			map.put("subject", result);
		}else{
			map.put("msg", Message.init(202));
		}
		
		return map;
	}
}
