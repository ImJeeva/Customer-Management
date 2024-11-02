package com.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.DAOImplement.CustomerDAOImplement;
import com.spring.DAOImplement.UserDAOImplement;
import com.spring.configuration.AppConfiguration;
import com.spring.entity.Customer;

@Controller
public class CustomerController {
    // Initializing the application context and DAO implementation
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfiguration.class);
    CustomerDAOImplement cdi = (CustomerDAOImplement) ac.getBean("customerDAOImplement");
    UserDAOImplement udi = (UserDAOImplement) ac.getBean("userDAOImplement");
   
    @RequestMapping("/addcustomer")
    public String register() {
        return "addcustomer";
    }

    @RequestMapping("/addcustomerdata")
    public String addCustomer(@RequestParam("name") String name, 
                              @RequestParam("email") String email, @RequestParam("department") String department,
                              @RequestParam("salary") int salary, Model model) {
        
        // Creating a new customer
        Customer customer = new Customer( name, email, department, salary);
        cdi.addCustomer(customer); // Adding customer to the database
        
        // Displaying updated customer list
        List<Customer> list = getCustomer(cdi);
        model.addAttribute("list", list); // Adding the list to the model
        
        return "getCustomer"; // Returning the view that displays the customer list
    }

    // Method to get the list of all customers
    public List<Customer> getCustomer(CustomerDAOImplement cdi) {
        List<Customer> list = cdi.getALLCustomer();
        for (Object c : list) {
            System.out.println(c);
        }
        return list;
    }

    
    @RequestMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("id") int id, Model model) {
        // Deleting the customer with the given id
        cdi.deleteCustomer(id);
        System.out.println(id + " is deleted");

        // Retrieving and displaying the updated customer list
        List<Customer> list = getCustomer(cdi);
        model.addAttribute("list", list); // Adding updated list to the model
        
        return "getCustomer"; // Returning the view to display the updated list
    }
    
    
    
    @RequestMapping("/updateCustomer")
    public String updateCustomerForm(@RequestParam("id") int id, Model model) {
        // Fetch the customer from the database using the DAO
        Customer customer = cdi.getCustomerById(id);
        
        if (customer != null) {
            // Add the customer data to the model to populate the form
            model.addAttribute("customer", customer);
            return "updateCustomer";  // Return the JSP page with the form
        } else {
            model.addAttribute("error", "Customer not found");
            return "errorPage";  // In case customer is not found
        }
    }
    
    @RequestMapping("/saveUpdatedCustomer")
    public String saveUpdatedCustomer(@RequestParam("id") int id, 
                                      @RequestParam("name") String name,
                                      @RequestParam("email") String email, 
                                      @RequestParam("department") String department, 
                                      @RequestParam("salary") int salary, 
                                      Model model) {

        // Call the DAO method to update the customer
        cdi.updateCustomer(id, name, email, department, salary);

        // Fetch the updated customer list and add it to the model
        List<Customer> customerList = cdi.getALLCustomer();
        model.addAttribute("list", customerList);

        return "getCustomer";  // Return the updated customer list view
    }
    
    @RequestMapping("/customerdata")
    public String customerdata(Model model) {
        List<Customer> customerList = cdi.getALLCustomer();
        model.addAttribute("list", customerList);
        return "getCustomer"; 
    }
    

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // Invalidate the session
        }
        return "index"; // Redirect to login page
    }

    



}
