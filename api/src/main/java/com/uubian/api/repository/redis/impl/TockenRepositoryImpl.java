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
		// TODO Auto-generated method stub
		ValueOperations<String, String> ops = this.template.opsForValue();
		//if (!this.template.hasKey(key)) {
			ops.set(key, value, 1800, TimeUnit.SECONDS);
			return 1;
		//}else{
		//	return 0;
		//}
	}

	@Override
	public String getTocken(String key) {
		ValueOperations<String, String> ops = this.template.opsForValue();
		return ops.get(key);
	}
	public void test(){
		
	}

}
