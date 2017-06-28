package com.uubian.api.repository.mongodb;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.uubian.api.domain.mongodb.Subject;
public interface  SubjectRepository extends MongoRepository<Subject, String> {
	
}