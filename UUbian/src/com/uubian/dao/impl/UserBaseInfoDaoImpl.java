package com.uubian.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.uubian.dao.UserBaseInfoDao;
import com.uubian.model.UserBaseInfo;
@Service
public class UserBaseInfoDaoImpl implements UserBaseInfoDao{
    public JdbcTemplate jdbcTemplate;
    

    public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public  List<UserBaseInfo> findALL() {
        String sql = "select * from user_base_info";
        List<Map<String,Object>> list = jdbcTemplate.queryForList(sql);
        Iterator<Map<String,Object>> iterator = list.iterator();
        List<UserBaseInfo> users= new ArrayList<UserBaseInfo>();
        while (iterator.hasNext()) {
            Map<String,Object> map4dept = iterator.next();
            UserBaseInfo user = new UserBaseInfo();
            user.setId((int)map4dept.get("id"));
            user.setUsername((String)map4dept.get("username"));
            user.setPassword((String)map4dept.get("password"));
            users.add(user);
        }
		return users;
    }
	public int delete(int id){
		String sql = "delete from user_base_info where id=?";
		return jdbcTemplate.update(sql, id);
	}

	public UserBaseInfo findOneByUsernameAndPassword(String username,String password) {
		// TODO Auto-generated method stub
		String sql = "select * from user_base_info where username=? and password=?";
        List<Map<String,Object>> list = jdbcTemplate.queryForList(sql,username,password);
        Iterator<Map<String,Object>> iterator = list.iterator();
        List<UserBaseInfo> users= new ArrayList<UserBaseInfo>();
        while (iterator.hasNext()) {
            Map<String,Object> map4dept = iterator.next();
            UserBaseInfo user = new UserBaseInfo();
            user.setId((int)map4dept.get("id"));
            user.setUsername((String)map4dept.get("username"));
            user.setPassword((String)map4dept.get("password"));
            users.add(user);
        }
        if(users!=null&&users.size()>0){
        	return users.get(0);
        }else{
        	return null;
        }
		
	}


    
}
