package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;

@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;

	/**
	 * http://localhost:8080/add?name=김형진&phone=01076041440
	 * @param user
	 * @return
	 */
	@RequestMapping("/add")
	public User add(User user) {

		User userResult = userRepository.save(user);

		return userResult;
	}

	/**
	 * http://localhost:8080/list
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public List<User> list(Model model) {

		List<User> userList = (List<User>) userRepository.findAll();

		return userList;
	}
	
	@RequestMapping("/delete")
	public String delete(User user) {

		userRepository.delete(user);

		return "User Delete!";
	}
	
	@RequestMapping("/update")
	public User update(User user) {
		
		 User userResult = userRepository.findById(user.getId()).get();
		 userResult.setName(user.getName());
		 userResult.setPhone(user.getPhone());
		 userRepository.save(userResult);
		
		return userResult;
	}

	@RequestMapping("/")
	public String index() {
		return "User JPA Test!";
	}
}
