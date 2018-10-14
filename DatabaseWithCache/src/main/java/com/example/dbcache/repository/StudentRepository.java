package com.example.dbcache.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dbcache.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	Student findByName(String name);
}
