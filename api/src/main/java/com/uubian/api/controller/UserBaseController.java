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
import com.uubian.api.domain.postgres.UserBase;
import com.uubian.api.repository.postgres.UseBaseRepository;


@RestController()
@RequestMapping("/userbase")
public class UserBaseController {
	@Autowired
	private UseBaseRepository useBaseRepository;
	@GetMapping("/getAllList")
	public Map<String,Object> getAll(){
		List<UserBase> users = useBaseRepository.getUserList(null);
		Map<String,Object> map = new HashMap<String, Object>();
		if(users!=null){
			map.put("msg", Message.init(200));
			map.put("userbases", users);
		}else{
			map.put("msg", Message.init(202));
		}
		return map;
	}
	@GetMapping("/deleteById/{id}")
	public Map<String,Object> getAll(@PathVariable long id){
		int num = useBaseRepository.delete(id);
		Map<String,Object> map = new HashMap<String, Object>();
		if(num==1){
			map.put("msg", Message.init(200));
		}else{
			map.put("msg", Message.init(202));
		}
		return map;
	}
	@GetMapping("/getOneById/{id}")
	public Map<String,Object> getOneById(@PathVariable long id){
		UserBase userBase = useBaseRepository.getUserBaseById(id);
		Map<String,Object> map = new HashMap<String, Object>();
		if(userBase!=null){
			map.put("msg", Message.init(200));
			map.put("userbase", userBase);
		}else{
			map.put("msg", Message.init(202));
		}
		return map;
	}
	@GetMapping("/getOneByPhone/{phone}")
	public Map<String,Object> getOneByPhone(@PathVariable String phone){
		UserBase userBase = useBaseRepository.getUserBaseByPhone(phone);
		Map<String,Object> map = new HashMap<String, Object>();
		if(userBase!=null){
			map.put("msg", Message.init(200));
			map.put("userbase", userBase);
		}else{
			map.put("msg", Message.init(202));
		}
		return map;
	}
	@PostMapping("/save")
	public Map<String,Object> save(@RequestBody UserBase userBase){
		userBase.setPassword(BCrypt.hashpw(userBase.getPassword(), BCrypt.gensalt()));
		Map<String,Object> map = new HashMap<String, Object>();
		UserBase temp1 = useBaseRepository.getUserBaseByUsername(userBase.getUsername());
		UserBase temp2 = useBaseRepository.getUserBaseByMail(userBase.getMail());
		if(temp1==null&&temp2==null){
			int num = useBaseRepository.save(userBase);
			if(num==1){
				map.put("msg", Message.init(200));
				UserBase finalUserBase = useBaseRepository.getUserBaseByUsername(userBase.getUsername());
				map.put("userBase", finalUserBase);
			}else{
				map.put("msg", Message.init(202));
			}
		}else if(temp1!=null){
			map.put("msg", Message.init(202,"用户名已被注册"));
		}else if(temp2!=null){
			map.put("msg", Message.init(202,"邮箱已被注册"));
		}
		
		return map;
	}
	@PostMapping("/update")
	public Map<String,Object> update(@PathVariable UserBase userBase){
		userBase.setPassword(BCrypt.hashpw(userBase.getPassword(), BCrypt.gensalt()));
		int num = useBaseRepository.update(userBase);
		Map<String,Object> map = new HashMap<String, Object>();
		if(num==1){
			map.put("msg", Message.init(200));
		}else{
			map.put("msg", Message.init(202));
		}
		return map;
		
	}
}
