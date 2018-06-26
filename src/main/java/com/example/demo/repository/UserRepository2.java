package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.example.demo.entity.User;


/**
 *
 */
public interface UserRepository2 extends JpaRepository<User, Long>, QuerydslPredicateExecutor<User>{
	
	//NamedQuery
	 //List<User> findByPhone(String phone); //query method
     //List<User> findByName(String name);

    

     //Querydsl 처리용
     //List<User> selectNameOrderByIdDesc(String name);

     //Long deleteByName(String name);

     //Long updateByUserId(Long userId, String newName);

     //List<Tuple> selectIdByName(String name);

     //List<Tuple> selectIdNamePhoneJoinDepartment(Long deptno);  //Join
/*
     List<User> selectEmpMaxSal();         //subquery

     List<User> selectEmpMaxSalOfDept();   //subquery

     List<User> selectEmpGreaterThanAvgSal();  //subquery

     List<User> selectEmpEqualsEmpno(Long empno);  //subquery

     List<User> selectEmpMaxSalTop3();  //subquery

     List<String> selectDeptExistsEmp();  //subquery
*/}
