package com.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.DAOImplement.CustomerDAOImplement;
import com.spring.DAOImplement.UserDAOImplement;
import com.spring.configuration.AppConfiguration;
import com.spring.entity.Customer;
import com.spring.entity.User;
@Controller
public class UserController {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfiguration.class);
    UserDAOImplement udi = (UserDAOImplement) ac.getBean("userDAOImplement");
    CustomerDAOImplement cdi = (CustomerDAOImplement) ac.getBean("customerDAOImplement");
  
    @RequestMapping("/signupServlet")
	    public String signupServlet(@RequestParam("name") String name,
	    							@RequestParam("email") String email,
	    							@RequestParam("password") String password,
	    							@RequestParam("confirmPassword") String confirmPassword,
	    							Model model) {
	    	
	    	if(password.equals(confirmPassword)) {
	    	User user = new User(name,password,email);
	    	udi.addUser(user);
	    	
	    	System.out.println("signUp");
	    	
	    	}else {
	    		return "signUp";
	    	}
	    	
	    	return "index";
	    }
    
    
    @RequestMapping("/loginServletr")
    public String loginServletr( @RequestParam("email") String email, @RequestParam("password")String password, Model model, HttpSession session) {
    	User user = udi.getUser(email);
    	System.out.println(user.getPassword()+", "+password);
    	if(user.getPassword().equals(password)) {
    	 
            List<Customer> customerList = cdi.getALLCustomer();
            model.addAttribute("list", customerList);
            session.setAttribute("user", user);
            return "getCustomer"; 
     }
     else {
    	 return "index";
     }
    	
    }
	
}
