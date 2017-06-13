package com.uubian.api.domain.postgres;

import java.util.Date;

public class UserBase {
	private String username;
	private long id;
	private String password;
	private String nickname;
	private String mail;
	private Date registertime;
	
	
	public UserBase() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public Date getRegistertime() {
		return registertime;
	}


	public void setRegistertime(Date registertime) {
		this.registertime = registertime;
	}


	
	
}
