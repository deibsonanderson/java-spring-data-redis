package com.spring.data.redis.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.data.redis.entity.People;
import com.spring.data.redis.service.RedisService;

@RestController
public class RedisController {
	
	@Autowired
	private RedisService redisService;

	@PostMapping(value = "/spring", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<People> create(@Valid @RequestBody People people) {
		return ResponseEntity.status(HttpStatus.CREATED).body(redisService.create(people));
	}
	
	@GetMapping(value = "/spring/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<People> findById(@PathVariable("id") String id) {
		return ResponseEntity.status(HttpStatus.OK).body(redisService.findById(id));
	}
	
	@GetMapping(value = "/spring", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<People>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(redisService.findAll());
	}
		
	@PostMapping(value = "/template", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<People> putOnCache(@Valid @RequestBody People people) {
		return ResponseEntity.status(HttpStatus.CREATED).body(redisService.putOnCache(people));
	}
	
	@GetMapping(value = "/template/{id}/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<People> getFromCache(@PathVariable("id") String id,@PathVariable("name") String name) {
		return ResponseEntity.status(HttpStatus.OK).body((People) redisService.getFromCache(id, name));
	}
	
}
