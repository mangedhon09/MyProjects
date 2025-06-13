package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/employee")
public class EmployeeOperationsController {
   @Autowired
	private IEmployeeMgmtService empService;
  @GetMapping("/")
  public String showHome() {
	  return "home";
  }
  @GetMapping("/report")
  public String showEmployeeReport(Map<String,Object>map) {
	 //use service
	  Iterable<Employee>itEmps=empService.getAllEmployees();
	 //put result in model attribute
	  map.put("empsList", itEmps);
	  //return LVN
	  return "show_employee_report";
	  
  }
  @GetMapping("/emp_add")
  public String showFormForsaveEmployee(@ModelAttribute("emp") Employee emp) {
	  //return LVN
	  return "register_employee";
  }
	/*@PostMapping("/emp_add")
	public String saveEmployee(@ModelAttribute("emp") Employee emp,RedirectAttributes attrs) {
	//use service
	 System.out.println("EmployeeOperationsController.saveEmployee()");
	 String msg=empService.registerEmployee(emp);
	 //keep the result as flashAttribute
	 attrs.addFlashAttribute("resultMsg",msg);
	 
	 return "redirect:report";
	}*/
  @PostMapping("/emp_add")
  public String saveEmployee(@ModelAttribute("emp") Employee emp,HttpSession ses) {
	//use service
	 System.out.println("EmployeeOperationsController.saveEmployee()");
	 String msg=empService.registerEmployee(emp);
	 //keep the result as flashAttribute
	 ses.setAttribute("resultMsg",msg);
	 
	 return "redirect:report";
  }
  @GetMapping("/edit")
  public String ShowEditEmployeeFormPage(@RequestParam("no")int no,
		                                  @ModelAttribute("emp") Employee emp ) {
	//use service
	  Employee emp1=empService.getEmployeeByNo(no);
	  //copy data 
	  BeanUtils.copyProperties(emp1, emp);
     return "update_employee";	  
  }
  @PostMapping("/edit")
  public String editEmployee(RedirectAttributes attrs,@ModelAttribute("emp") Employee emp) {
	   //use service
	  String msg=empService.updateEmployee(emp);
	  //add the result message as Flash Attribute
	  attrs.addFlashAttribute("resultMsg",msg);
	  //redirect the 
	  return "redirect:report";
  }
  @GetMapping("/delete")
  public String deleteEmployee(RedirectAttributes attrs,@RequestParam int no) {
	  //use service
	  String msg=empService.deleteEmployeeById(no);
	  //keep the result in FlashAttribute
	  attrs.addFlashAttribute("resultMsg",msg);
	  return "redirect:report";
  }
}
