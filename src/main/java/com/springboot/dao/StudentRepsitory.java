package com.springboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.entry.Student;
import com.springboot.entry.User;

public interface StudentRepsitory extends JpaRepository<Student,Long> {

		User findByName(String name);
	
		List<Student> findAll();
		
		@Query("from Student where age < 10")
		User findChildren();
}
