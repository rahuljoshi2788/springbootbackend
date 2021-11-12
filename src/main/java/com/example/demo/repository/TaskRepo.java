package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Tasks;

public interface TaskRepo extends JpaRepository<Tasks,Integer> {

	
	

}
