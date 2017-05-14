package com.uubian.dao;



import java.util.List;


import com.uubian.model.UserBaseInfo;
public interface UserBaseInfoDao {

	public  List<UserBaseInfo> findALL();
	public int delete(int id);
	public UserBaseInfo findOneByUsernameAndPassword(String username,String password);
    
}
