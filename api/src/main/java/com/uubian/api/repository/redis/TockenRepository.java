package com.uubian.api.repository.redis;

public interface TockenRepository {
	public int setTocken(String key,String value);
	public String getTocken(String key);
	public void test();
}
