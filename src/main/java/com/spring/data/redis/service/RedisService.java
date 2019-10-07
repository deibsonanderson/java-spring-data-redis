package com.spring.data.redis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.data.redis.entity.People;
import com.spring.data.redis.repository.PeopleRedisTemplateRepository;
import com.spring.data.redis.repository.PeopleRepository;

@Service
public class RedisService {

	@Autowired
	private PeopleRepository repository;

	@Autowired
	private PeopleRedisTemplateRepository redisTemplateRepository;

	public People create(People people) {
		return repository.save(people);
	}

	public People findById(String id) {
		Optional<People> result = repository.findById(id);
		return (result.isPresent())?result.get():null;
	}
	
	public Iterable<People> findAll() {
		return repository.findAll();
	}

	public People putOnCache(People people) {
		redisTemplateRepository.putOnCache(people.getId(), people.getName(), people);
		return people;
	}

	public Object getFromCache(String id, String name) {
		return redisTemplateRepository.getFromCache(id, name);
	}

}
