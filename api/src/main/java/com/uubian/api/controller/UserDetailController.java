package com.uubian.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uubian.api.annotation.Privilege;
import com.uubian.api.domain.dto.Message;
import com.uubian.api.domain.postgres.UserDetail;
import com.uubian.api.repository.postgres.UseDetailRepository;


@RestController()
@RequestMapping("/userdetail")
public class UserDetailController {
	@Autowired
	private UseDetailRepository useDetailRepository;


	@Privilege
	@GetMapping("/getOneById/{id}")
	public Map<String,Object> getOneById(@PathVariable long id){
		UserDetail useDetail = useDetailRepository.getUserDetailById(id);
		Map<String,Object> map = new HashMap<String, Object>();
		if(useDetail!=null){
			map.put("msg", Message.init(200));
			map.put("userbase", useDetail);
		}else{
			map.put("msg", Message.init(202));
		}
		return map;
	}
	@Privilege
	@PostMapping("/save")
	public Map<String,Object> save(@RequestBody UserDetail useDetail){

		int num = useDetailRepository.save(useDetail);
		Map<String,Object> map = new HashMap<String, Object>();
		if(num==1){
			map.put("msg", Message.init(200));
		}else{
			map.put("msg", Message.init(202));
		}
		return map;
	}
	@Privilege
	@PostMapping("/update")
	public Map<String,Object> update(@PathVariable UserDetail useDetail){
		int num = useDetailRepository.update(useDetail);
		Map<String,Object> map = new HashMap<String, Object>();
		if(num==1){
			map.put("msg", Message.init(200));
		}else{
			map.put("msg", Message.init(202));
		}
		return map;
		
	}
}
