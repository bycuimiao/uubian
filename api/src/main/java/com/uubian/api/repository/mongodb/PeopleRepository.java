package com.uubian.api.repository.mongodb;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.uubian.api.domain.mongodb.People;
public interface  PeopleRepository extends MongoRepository<People, String> {
	People findByAge(int age);
	People findByName(String name);
}