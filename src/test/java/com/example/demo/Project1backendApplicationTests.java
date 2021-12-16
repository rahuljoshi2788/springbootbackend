package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.Model.User;
import com.example.demo.repository.CarRepo;
import com.example.demo.repository.UserLogin;


@SpringBootTest
class Project1backendApplicationTests {

	
	@Autowired
	Calculator calc;
	
	@Autowired
	UserLogin ul;
	
	@Autowired
	CarRepo cr;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void testsum() {
		
		int actualresult=50;
		
			int sum=calc.sum(45, 5);
			assertThat(actualresult).isEqualTo(sum);
			System.out.println("Testing");
		
	}
	
	@Test
	void testrepo() {
		
		System.out.println(cr.findAll().size());
		
		assertThat(4).isEqualTo(cr.findAll().size());
	}
	
	@Test 
	void testusers() {
		
			System.out.println(ul.findAll().size());
			assertThat(12).isEqualTo(ul.findAll().size());
		
	}
	

}
