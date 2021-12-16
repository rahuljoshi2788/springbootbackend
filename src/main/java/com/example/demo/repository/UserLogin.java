package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.User;

@Repository
public interface UserLogin extends JpaRepository<User,Integer> {
	
	
	
//	@Query(value="select * from user where username=? and password=?",nativeQuery=true)
//	User checkUser(String username,String password);
//	
	
	//custom method
	User findByUsernameAndPassword(String uname,String pword);
	
//	@Query(value="select * from user",nativeQuery = true)
//	List<User> isPersonExistById();

	
	
	
	//String is key and object is value...
	@Query(value="select password as value,username as label from user",nativeQuery=true)
	List<Map<String,Object>> searchUsers();
	
}
