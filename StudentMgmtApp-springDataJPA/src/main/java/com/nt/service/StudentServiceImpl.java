package com.nt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nt.entity.Student;
import com.nt.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository repo;
	
	   public StudentServiceImpl(StudentRepository repo) {
	        this.repo = repo;
	    }

	@Override
	public List<Student>getAllStudents(){
		return repo.findAll();
		
	}

	
	@Override
	public Student getStudentsById(Long id) {
		
		return repo.findById(id).orElse(null);
	}

	@Override
	public Student saveStudent(Student student) {
		
		return repo.save(student);
	}

	@Override
	public Student updateStudent(Long id, Student student) {
			
		Student existing=repo.findById(id).orElse(null);
		if(existing != null) {
			existing.setName(student.getName());
			existing.setEmail(student.getEmail());
			existing.setCourse(student.getCourse());
			return repo.save(existing);
			
		}
		return null;
	}

	@Override
	public void deleteStudent(Long id) {
		repo.deleteById(id);
		
	}
	
	
	
}
