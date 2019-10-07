package com.spring.data.redis.entity;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.redis.core.RedisHash;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@RedisHash("People")
@Data
public class People implements Serializable {

	public enum Gender {
		MALE, FEMALE
	}

	@JsonProperty(required=true)
	@Valid
	@NotNull
	@NotBlank
	private String id;
	
	@JsonProperty(required=true)
	@Valid
	@NotNull
	@NotBlank
	private String name;
	
	private Gender gender;
	
	private int age;
	
	public People(){
		super();
	}

	public People(String id, String name, Gender gender, int age) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

}