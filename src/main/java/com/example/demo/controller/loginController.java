package com.example.demo.controller;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Tasks;
import com.example.demo.Model.User;
import com.example.demo.repository.TaskRepo;
import com.example.demo.repository.UserLogin;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class loginController {
	



@Autowired
UserLogin ulogin;

@Autowired
TaskRepo trepo;

void m1() {
	
	
	ArrayList<Integer> arr1=new ArrayList<Integer>();
	
	arr1.add(1);
	arr1.add(4);
	arr1.add(5);
	arr1.add(6);
	arr1.add(9);
	arr1.add(19);
	
	Collections.sort(arr1);
	
	System.out.println(arr1);
	
	
}
	
@PostMapping(value="/login")
public String confirmation(@RequestBody User user) {
	
	System.out.println("In Web Service");
	String uname=user.getUsername();
	String pword=user.getPassword();
	
	User checkuser=ulogin.findByUsernameAndPassword(uname, pword);
	

	
	
	if(checkuser == null)
	{
		return "Failed";
	}
	
	String s1=checkuser.getName();
	
		return s1;
	
	
}


@PostMapping(value="/register")
public String register(@RequestBody User user) {
	
	ulogin.save(user);
	
	return "Success";
	
	
}



@GetMapping(value="/users")
public List<Map<String,Object>> returnUsers() {
	
//	List<Map<String,Object>> objs=ulogin.searchUsers();
//
//	objs.forEach(obj->{
//		
//		 obj.forEach((k, v) -> System.out.println((k + ":" + v)));
//	});

	
//	for(Map.Entry<String, Object> m: ((Map<String, Object>) objs).entrySet()) {
//		
//		System.out.println(m.getKey() + " " + m.getValue());
//		
//	
//		
//	}
	
//	m1();
	
	//Hello
	
	return ulogin.searchUsers();
	
}

@PostMapping(value="savetasks")
public Map<String,Object> saveTasks(@RequestBody List<Tasks> task)
{
	
	task.forEach(t->System.out.println(t.getTaskDescription()));
	
	
	trepo.saveAll(task);
	
	Map<String,Object> map=new HashMap<String,Object>();
	
	map.put("status", 201);
	map.put("message","Data Saved");

	return map;
	
}

@GetMapping(value="/gettasks")
public List<Tasks> getTasks(){
	
	
	
	
	return trepo.findAll(Sort.by(Sort.Direction.ASC, "taskDescription"));
	
}

@DeleteMapping(value = "/tasks/{id}")
public List<Tasks> deleteTask(@PathVariable Integer id) {
	
	trepo.deleteById(id);
	
	return trepo.findAll();
	
}





}
