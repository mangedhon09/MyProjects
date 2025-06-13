package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repo.IEmployeeRepository;
@Service
public class IEmployeeMgmtServiceImpl implements IEmployeeMgmtService {
    @Autowired
	private IEmployeeRepository empRepo;
	@Override
	public Iterable<Employee> getAllEmployees() {
		
		return empRepo.findAll();
	}
	@Override
	public String registerEmployee(Employee emp) {
		
		return "employee is saved withd id value::"+empRepo.save(emp).getEmpno();
	}
@Override
public String saveEmployee(Employee emp) {
	// TODO Auto-generated method stub
	return  "employee is save with id value"+empRepo.save(emp);
}
@Override
public Employee getEmployeeByNo(int eno) {
	Employee emp=empRepo.findById(eno).orElseThrow(()->new IllegalArgumentException());
	
	return emp;
}
@Override
public String updateEmployee(Employee emp) {
	
	return "Employee is Updated with Having id Value::"+empRepo.save(emp).getEmpno();
}
@Override
public String deleteEmployeeById(int eno) {
	empRepo.deleteById(eno);
	return eno+"Employee id Employee is Deleted";
}
}
