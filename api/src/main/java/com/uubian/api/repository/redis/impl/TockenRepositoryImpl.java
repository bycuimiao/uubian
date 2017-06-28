package com.uubian.api.repository.redis.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import com.uubian.api.repository.redis.TockenRepository;
@Repository
public class TockenRepositoryImpl implements TockenRepository{
	@Autowired
	private StringRedisTemplate template;

	@Override
	public int setTocken(String key, String value) {
		ValueOperations<String, String> ops = this.template.opsForValue();
		try {
			ops.set(key, value, 1800, TimeUnit.SECONDS);
		} catch (Exception e) {
			return 0;
		}
		
		return 1;
	}

	@Override
	public String getTocken(String key) {
		ValueOperations<String, String> ops = this.template.opsForValue();
		return ops.get(key);
	}
	public void test(){
		
	}

}
