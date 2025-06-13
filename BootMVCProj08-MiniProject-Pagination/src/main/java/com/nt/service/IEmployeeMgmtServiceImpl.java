package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repo.IEmployeeRepository;
@Service
public class IEmployeeMgmtServiceImpl implements IEmployeeMgmtService {
    @Autowired
	private IEmployeeRepository empRepo;
	@Override
	public Page<Employee> getAllEmployees(Pageable pageable) {
		
		return empRepo.findAll(pageable);
	}
	
}
