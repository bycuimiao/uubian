package com.uubian.api.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.uubian.api.domain.People;
public interface  PeopleRepository extends MongoRepository<People, String> {
	People findByAge(int age);
	People findByName(String name);
}