package com.example.dbcache.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.example.dbcache.entity.Student;
import com.example.dbcache.repository.StudentRepository;

@Component
public class StudentsCache {

	@Autowired
	StudentRepository studentRepository;
	
	@Cacheable(value = "studentsCache", key="#name")
	public Student getStudent(String name)
	{
		System.out.println("Retrieveing from Database for name :"+name);
		return studentRepository.findByName(name);
	}
	
}
