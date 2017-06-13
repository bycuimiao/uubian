package com.uubian.api.repository.postgres;


import java.util.List;

import com.uubian.api.domain.postgres.UserBase;
public interface UseBaseRepository{

	
	public List<UserBase> getUserList(UserBase userBase);
	public int save(UserBase userBase);
	public int delete(long id);
	public int update(UserBase user);
	public UserBase getUserBaseByUsername(String username);
	public UserBase getUserBaseById(long id);
	public UserBase getUserBaseByMail(String mail);
}
