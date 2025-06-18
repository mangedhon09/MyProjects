package com.nt.service;
import java.util.List;

import com.nt.entity.Student;

public interface StudentService {
  List<Student> getAllStudents();
  Student getStudentsById(Long id);
  Student saveStudent(Student student);
  Student updateStudent(Long id,Student student);
  void deleteStudent(Long id);
	
}
