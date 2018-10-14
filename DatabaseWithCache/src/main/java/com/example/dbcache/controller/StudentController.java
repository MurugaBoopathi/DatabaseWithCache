package com.example.dbcache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dbcache.cache.StudentsCache;
import com.example.dbcache.entity.Student;

@RestController
@RequestMapping(value = "/college/students")
public class StudentController {

	@Autowired
	private StudentsCache studentsCache;
	

	@GetMapping(value = "/{name}")
	public Student getStudent(@PathVariable final String name)
	{
		return studentsCache.getStudent(name);
	}
	
}
