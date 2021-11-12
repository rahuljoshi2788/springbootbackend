package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Cars;
import com.example.demo.repository.CarRepo;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class CarController {
	
	
	@Autowired
	CarRepo cr;
	
	
	@GetMapping(value="checkcars/{madein}")
	public List<Cars> getCars(@PathVariable String madein){
		
		return cr.returnCars(madein);
		
		
		
	}
	
	@GetMapping(value="allcars")
	public List<Cars> getAllCars(){
			System.out.println("Get Called");
			return cr.findAll();
		
	}
	
	@PostMapping(value="addcars")
	public String addCars(@RequestBody Cars car)
	{
		
		cr.save(car);
		
		return "Added";
		
	}
	
	@GetMapping(value="getcar/{id}")
	public Optional<Cars> getCar(@PathVariable Integer id)
	
	{
		return cr.findById(id);
			
		
	}
	

}
