package com.uubian.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uubian.api.domain.People;
import com.uubian.api.repository.PeopleRepository;


@RestController()
@RequestMapping("/People")
public class PeopleController {
	@Autowired
	private PeopleRepository peopleRepository;
	
	@Primary
	@GetMapping("/getListPeople")
	public List<People> getAll(){
		List<People> peoples = peopleRepository.findAll();
		return peoples;
	}
	@Primary
	@GetMapping("/getListPeopleByName/{name}")
	public People getPeopleByName(@PathVariable String name){
		People people = peopleRepository.findByName(name);
		return people;
	}
	@Primary
	@GetMapping("/save/{name}/{age}")
	public People save(@PathVariable String name){
		People people = new People();
		people.setName("lihua");
		people.setAge(30);
		People backPeople = peopleRepository.save(people);
		return backPeople;
	}
}
