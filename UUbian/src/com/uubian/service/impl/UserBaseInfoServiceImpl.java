package com.uubian.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uubian.dao.UserBaseInfoDao;
import com.uubian.model.UserBaseInfo;
import com.uubian.service.UserBaseInfoService;
@Service
public class UserBaseInfoServiceImpl implements UserBaseInfoService{
	@Autowired
	public UserBaseInfoDao userBaseInfoDao;

	@Override
	public UserBaseInfo checkUserBaseInfo(String username,String password) {
		// TODO Auto-generated method stub
		if(username!=null&&password!=null){
			UserBaseInfo userBaseInfo = userBaseInfoDao.findOneByUsernameAndPassword(username, password);
			return userBaseInfo;
		}
		return null;
	}
}
