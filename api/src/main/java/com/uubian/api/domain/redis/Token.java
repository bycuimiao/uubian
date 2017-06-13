package com.uubian.api.domain.redis;

import com.uubian.api.domain.postgres.UserBase;

public class Token {
	private String access_token;
	private UserBase userBase;

	public UserBase getUserBase() {
		return userBase;
	}
	public void setUserBase(UserBase userBase) {
		this.userBase = userBase;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	
}
