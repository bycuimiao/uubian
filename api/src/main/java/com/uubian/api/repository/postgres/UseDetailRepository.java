package com.uubian.api.repository.postgres;



import com.uubian.api.domain.postgres.UserDetail;
public interface UseDetailRepository{

	

	public int save(UserDetail userDetail);
	
	public int update(UserDetail userDetail);
	
	public UserDetail getUserDetailById(long id);
	
}
