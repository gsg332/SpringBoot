package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.User;
import com.example.demo.predicate.UserPredicate;
import com.example.demo.repository.UserRepository2;

@Service
public class UserService {
	
	@Autowired
	UserRepository2 userRepository2;
	
	@Transactional(readOnly=true)
	public Page<User> search(Long userId, String name, Pageable pageable){
		return userRepository2.findAll(UserPredicate.search(userId, name), pageable);
	}

}
