package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Model.Cars;

public interface CarRepo extends JpaRepository<Cars,Integer> {

	@Query(value="select * from cars where madein=?",nativeQuery=true)
	public List<Cars> returnCars(String madein);
	
//	List<Cars> findCarsbyCountry(String madein);
	
	
}
