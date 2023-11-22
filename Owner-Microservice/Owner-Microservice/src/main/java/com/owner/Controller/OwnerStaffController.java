package com.owner.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.owner.Models.Staff;
import com.owner.Models.StaffList;

@RestController
@RequestMapping("/Owner/Staff")
public class OwnerStaffController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/getAllEmp")
	public StaffList getAllEmp() 
	{
		return restTemplate.getForObject("http://Staff-Microservice/Staff/getAllEmp/", StaffList.class);
	}
	
	@GetMapping("/getByEmp/{id}")
	public Staff getEmp(@PathVariable("id") String id) 
	{
		return restTemplate.getForObject("http://Staff-Microservice/Staff/getByEmp/"+id, Staff.class);
	}
	
	
	

	

}
