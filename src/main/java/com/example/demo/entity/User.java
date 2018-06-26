package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 */
@Entity
@ToString
@Setter
@Getter
//@Data //Getter, Setter, ToString, EqualsAndHashCode 모두 구현되는 것 같음.
@Table(name = "user", schema = "")
//@NamedQuery(name = "User.findByEmailAddress", query = "select u from User u where u.emailAddress = ?1")
/*@NamedQueries({
    @NamedQuery(name="User.findAll",
                query="SELECT u FROM User u"),
    @NamedQuery(name="User.findByName",
                query="SELECT u FROM User u WHERE u.name = :name"),
    @NamedQuery(name="User.findByPhone",
    query="SELECT u FROM User u WHERE u.phone = ?1"),
})*/ 
public class User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId", updatable = false, nullable = false)
	private Long userId;

	@Column(length = 20, nullable = false)
	private String name;

	@Column(length = 20, nullable = false, unique = true)
	private String phone;
	
	private String testType;

	// @OneToOne
	// @JoinColumn(name = "userId")
	// private Detail detail;


}