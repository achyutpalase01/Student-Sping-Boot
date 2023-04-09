package com.springboot.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Repository.StudentRepository;
import com.springboot.dto.Student;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student s) {
		studentRepository.save(s);
		return s;
	}
	
	@GetMapping("/get")
	public Student get(@RequestParam int id){
		Optional<Student> s = studentRepository.findById(id);
		if(s.isPresent())
			return s.get();
		else 
			return null;
	}
	
	@GetMapping("/fetchByName")
	public List<Student> getByName(@RequestParam String name)
	{
		List<Student> s =  studentRepository.findByName(name);
		return s;
	}
	
	@GetMapping("/fetchByEmail")
	public List<Student> findByAge(@RequestParam String email)
	{
		List<Student> s =  studentRepository.findByEmail(email);
		return s;
	}
	
	@GetMapping("/getAll")
	public List<Student> fetchAllData()
	{
		List<Student> s = studentRepository.findAll();
		return s;
	}
	
	@PutMapping("/update")
	public Student update(@RequestBody Student s){
		studentRepository.save(s);
		return s;
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id){
		studentRepository.deleteById(id); 
		return "Delete";
	}
	
	@GetMapping("/login")
	public Student findByEmailAndPassword(@RequestBody Student s)
	{
		return studentRepository.findByEmailAndPassword(s.getEmail(), s.getPassword());		
	}
}
