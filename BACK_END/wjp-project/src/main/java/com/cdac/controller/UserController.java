//package com.cdac.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.cdac.entity.User;
//import com.cdac.repository.UserRepository;
//
//@CrossOrigin
//@RestController
//public class UserController {
//	@Autowired
//	public UserRepository rr;
//	@PostMapping("/Registration")
//	public String add(@RequestBody User user) {
//		rr.save(user);
//		return null;
//	}
//	@PostMapping("/login")
//	public ResponseEntity<User> login(@RequestBody User user){
//		try {
//			User ruser= rr.findByFirstName(user.getFirstName());
//			if(ruser.getPassword().equals(user.getPassword())){
//				return new ResponseEntity<User>(HttpStatus.OK);
//			}
//			else return new ResponseEntity<User>(HttpStatus.ACCEPTED);	
//		}catch(Exception e) {
//			return new ResponseEntity<User>(HttpStatus.ACCEPTED);			
//		}
//	}
//}
