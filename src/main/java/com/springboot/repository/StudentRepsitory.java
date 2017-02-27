package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.entity.Student;

public interface StudentRepsitory extends JpaRepository<Student, Long> {

	Student findByName(String name);

	List<Student> findAll();

	@Query("from Student where age < 10")
	Student findChildren();
}
