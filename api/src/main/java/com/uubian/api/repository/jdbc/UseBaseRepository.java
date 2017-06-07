package com.uubian.api.repository.jdbc;


import java.util.List;

import com.uubian.api.domain.postgres.UserBase;
public interface UseBaseRepository{

	
	public List<UserBase> getUserList(UserBase userBase);
	public int save(UserBase userBase);
	public int delete(int id);
	public int update(UserBase user);
	public UserBase getUserBaseByUsername(String username);
}
