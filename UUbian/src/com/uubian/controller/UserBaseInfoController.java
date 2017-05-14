package com.uubian.controller;





import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uubian.model.Message;
import com.uubian.model.UserBaseInfo;
import com.uubian.service.UserBaseInfoService;





@Controller
@RequestMapping("/UserBaseInfo")
public class UserBaseInfoController {
	@Autowired
	public UserBaseInfoService userBaseInfoService;
	
    
    
    @ResponseBody
    @RequestMapping(value="/checkUserBaseInfo",method=RequestMethod.POST)
    public Map<String,Object> checkUserBaseInfo(@RequestBody UserBaseInfo userBaseInfo){
        
    	UserBaseInfo tempUserBaseInfo = userBaseInfoService.checkUserBaseInfo(userBaseInfo.getUsername(), userBaseInfo.getPassword());
    	Map<String,Object> map = new HashMap<String,Object>();
    	if(tempUserBaseInfo!=null){
    		map.put("msg", Message.init(200, "查询成功"));
    		map.put("userbaseinfo", tempUserBaseInfo);
    	}else{
    		map.put("msg", Message.init(202, "查询失败"));
    	}
    	return map;
    }
    
}
