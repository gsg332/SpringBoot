package com.example.demo.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	/*
	@Autowired
	private UserRepository2 userRepository2;
	 */
	
	
	@RequestMapping(value = "/reactTest")
    public ModelAndView reactTest() {
        ModelAndView view = new ModelAndView("reactTest");
        view.addObject("text", "world");
        return view;
    }
	
	
	/**
	 * http://localhost:8080/add?name=源��삎吏�&phone=01076041440
	 * @param user
	 * @return
	 */
	@RequestMapping(path = "/add", method = RequestMethod.GET)
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
		
		 User userResult = userRepository.findById(user.getUserId()).get();
		 userResult.setName(user.getName());
		 userResult.setPhone(user.getPhone());
		 userRepository.save(userResult);
		
		return userResult;
	}
	
	@RequestMapping("/")
	public String index() {
		return "User JPA Test!";
	}
	
	@PersistenceContext 
	EntityManager em;
	
	@RequestMapping("/jpaTest")
	public Page<User> jpaTest(User user, Pageable pageRequest) {
		
		
		//http://localhost:8080/jpaTest
		//http://localhost:8080/jpaTest?userId=1
		Page<User> userPage = userService.search(user.getUserId(), user.getName(), pageRequest);
		
		/*
		
		switch (user.getTestType()) {
		case "0" :
			//userList = userRepository2.findByName(user.getName());
			break;
		case "1" :
			//userList = userRepository2.findByPhone(user.getPhone());
			break;
		case "2" :
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("user");
			EntityManager em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			try {
				tx.begin();
				tx.commit();
			}catch(Exception e) {
				e.printStackTrace();
				tx.rollback();
			}finally {
				em.close();
			}
			emf.close();
			
			TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
			userList = query.getResultList();
			break;
		case "3" :
			//userList = userRepository2.findByName(user.getName());
			break;
		default:
			break;
		}*/
		
		
		return userPage;
	}
}
