package com.cms.springhibernatedemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cms.springhibernatedemo.entity.Customer;
import com.cms.springhibernatedemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService service;

	@GetMapping("/list")
	public String listCustomer(Model theModel) {

		List<Customer> theCustomer = service.getCustomers();

		if (theCustomer != null) {
			theCustomer.forEach(item -> System.out.println(item));
		}

		theModel.addAttribute("customers", theCustomer);

		return "list-customer";
	}

	@GetMapping("/showFormForAdd")
	public String addCustomer(Model theModel) {
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "customer-add";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

		System.out.println("The Custmore IS:" + theCustomer);

		service.saveOrUpdateCustomer(theCustomer);

		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String updateCustomer(@RequestParam("customerId") int custId, Model theModel) {

		Customer theCustomer = service.getCustomer(custId);

		theModel.addAttribute("customer", theCustomer);

		return "customer-add";
	}
	
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("customerId") int custId) {
		
		Customer theCustomer = service.getCustomer(custId);
		
		service.deleteCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}

}
