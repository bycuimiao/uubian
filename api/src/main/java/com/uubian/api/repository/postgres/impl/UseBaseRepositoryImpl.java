package com.uubian.api.repository.postgres.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uubian.api.domain.postgres.UserBase;
import com.uubian.api.repository.postgres.UseBaseRepository;
@Repository
public class UseBaseRepositoryImpl implements UseBaseRepository{
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public List<UserBase> getUserList(UserBase userBase){
		NamedParameterJdbcTemplate namedParameterJdbcTemplate =   
			    new NamedParameterJdbcTemplate(jdbcTemplate);
        String sql = "SELECT * FROM user_base WHERE 1=1";
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        if(userBase!=null){
        	if(userBase.getUsername()!=null){
        		sql+=" AND username = :username";
        		parameters.addValue("username", userBase.getUsername());
        	}
        	if(userBase.getNickname()!=null){
        		sql+=" AND nickname = :nickname";
        		parameters.addValue("nickname", userBase.getNickname());
        	}
        	if(userBase.getMail()!=null){
        		sql+=" AND mail = :mail";
        		parameters.addValue("mail", userBase.getMail());
        	}
        }
        List<Map<String,Object>> list = namedParameterJdbcTemplate.queryForList(sql,parameters);
        Iterator<Map<String,Object>> iterator = list.iterator();
        List<UserBase> users= new ArrayList<UserBase>();
        while (iterator.hasNext()) {
            Map<String,Object> map4dept = iterator.next();
            UserBase user = new UserBase();
            user.setId((int)map4dept.get("id"));
            user.setUsername((String)map4dept.get("username"));
            user.setPassword((String)map4dept.get("password"));
            user.setNickname((String)map4dept.get("nickname"));
            user.setMail((String)map4dept.get("mail"));
            user.setRegistertime((Date)map4dept.get("registertime"));
            users.add(user);
        }
		return users;
	}
	public int count(UserBase userBase){
		String sql = "select count(*) from user_base where　1=1";
		NamedParameterJdbcTemplate namedParameterJdbcTemplate =   
			    new NamedParameterJdbcTemplate(jdbcTemplate);
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        if(userBase!=null){
        	if(userBase.getUsername()!=null){
        		sql+=" AND username = :username";
        		parameters.addValue("username", userBase.getUsername());
        	}
        	if(userBase.getNickname()!=null){
        		sql+=" AND nickname = :nickname";
        		parameters.addValue("nickname", userBase.getNickname());
        	}
        }
        
        
        List<Map<String,Object>> list = namedParameterJdbcTemplate.queryForList(sql,parameters);
        Iterator<Map<String,Object>> iterator = list.iterator();

        int sum=0;
        if (iterator.hasNext()) {
            Map<String,Object> map4dept = iterator.next();
            sum=(int)map4dept.get("count(*)");
        }
        return sum;
	}
	public int delete(long id){
		String sql = "DELETE FROM user_base where id=?";
		return jdbcTemplate.update(sql, id);
	}
	
	public int save(UserBase userBase){
		String sql = "INSERT INTO user_base (username,password,nickname,mail,registertime) VALUES (?,?,?,?,?)";
		return jdbcTemplate.update(sql, userBase.getUsername(),userBase.getPassword(),userBase.getNickname(),userBase.getMail(),userBase.getRegistertime());
	}

	public int update(UserBase userBase) {
		String sql = "UPDATE user_base SET username=?, password=?,nickname=?,mail=? WHERE id=?";
		return jdbcTemplate.update(sql,userBase.getUsername(),userBase.getPassword(),userBase.getNickname(),userBase.getMail(),userBase.getId());
	}
	
	public UserBase getUserBaseByUsername(String username){
		String sql = "SELECT * FROM user_base WHERE username=?";
		RowMapper<UserBase> rowMapper=new BeanPropertyRowMapper<UserBase>(UserBase.class);
		return jdbcTemplate.queryForObject(sql, rowMapper,username);
	}
	public UserBase getUserBaseByMail(String mail){
		String sql = "SELECT * FROM user_base WHERE mail=?";
		RowMapper<UserBase> rowMapper=new BeanPropertyRowMapper<UserBase>(UserBase.class);
		return jdbcTemplate.queryForObject(sql, rowMapper,mail);
	}
	public UserBase getUserBaseById(long id){
		String sql = "SELECT * FROM user_base WHERE id=?";
		RowMapper<UserBase> rowMapper=new BeanPropertyRowMapper<UserBase>(UserBase.class);
		return jdbcTemplate.queryForObject(sql, rowMapper,id);
	}
}
