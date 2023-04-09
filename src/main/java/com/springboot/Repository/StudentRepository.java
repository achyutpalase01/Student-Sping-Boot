package com.springboot.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.dto.Student;


public interface StudentRepository extends JpaRepository<Student, Integer>  {
	public List<Student> findByName(String name); 
	public List<Student> findByEmail(String email); 
	public Student findByEmailAndPassword(String email, String password);
}
