package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeOperationsController {
   @Autowired
	private IEmployeeMgmtService empService;
  @GetMapping("/")
  public String showHome() {
	  return "home";
  }
  @GetMapping("/report")
  public String showEmployeeReport( @PageableDefault(page=0,size=3,sort="job",direction=Sort.Direction.ASC ) Pageable pageable,Map<String,Object>map) {
	 //use service
	  Iterable<Employee>itEmps=empService.getAllEmployees(pageable);
	 //put result in model attribute
	  map.put("pageData", itEmps);
	  //return LVN
	  return "show_employee_report";
	  
  }
 
}
