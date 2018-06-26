package com.example.demo.predicate;

import com.example.demo.entity.QUser;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

public class UserPredicate {
	
	public static Predicate search(Long userId, String name) {
		
		QUser user = QUser.user;
		
		BooleanBuilder builder = new BooleanBuilder();
		
		if(userId != null) {
			builder.and(user.userId.eq(userId));
		}
		if(name != null) {
			builder.and(user.name.eq(name));
		}
		
		return builder;
	}

}
