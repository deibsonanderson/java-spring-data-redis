package com.spring.data.redis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.data.redis.entity.People;

@Repository
public interface PeopleRepository extends CrudRepository<People, String> {
}