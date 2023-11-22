package com.owner.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.owner.Models.Department;
import com.owner.Models.DepartmentList;





@RestController
@RequestMapping("/owner/department")
public class OwnerDepartmentController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@PostMapping("/add")
	public Department addDept(@RequestBody Department dept) {
		return restTemplate.postForObject("http://Department-Microservice/department/add/",dept,Department.class);
	
	}
	
	
	
	@GetMapping("/findAll")
	public DepartmentList getAlldept(){
		return restTemplate.getForObject("http://Department-Microservice/department/findAll/", DepartmentList.class);
	}
	
	@GetMapping("/findById/{id}")
	public Department getEmp(@PathVariable("id") String id) 
	{
		return restTemplate.getForObject("http://Department-Microservice/department/findById/"+id, Department.class);
		
	}
	@PutMapping("/update")
	public Department updateRoom(@RequestBody Department dept)
	{
		restTemplate.put("http://Department-Microservice/department/update",dept, Department.class);
		return dept;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteDepartment(@PathVariable("id") String id) 
	{
		restTemplate.delete("http://Department-Microservice/department/delete/"+id);
		return "Deleted room "+id;
	}
		
	
}