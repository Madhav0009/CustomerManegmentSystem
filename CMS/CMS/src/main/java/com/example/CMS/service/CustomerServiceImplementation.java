package com.example.CMS.service;

import org.springframework.stereotype.Service;

import com.example.CMS.entity.Customer;
import com.example.CMS.repository.CustomerRepository;

@Service
public class CustomerServiceImplementation 
					implements CustomerService{

	CustomerRepository cusRepo;
	   
	public CustomerServiceImplementation(CustomerRepository cusRepo) {
		this.cusRepo = cusRepo;
	}

	@Override
	public boolean validate(Customer cus) {
		String dbPass = cusRepo.findById(cus.getId()).get().getPassword();
		return cus.getPassword().equals(dbPass);
	}

	@Override
	public String addUser(Customer cus) {
		//check username exists or not
		String uName = cus.getUsername();
		Customer dbCus = cusRepo.findByUsername(uName);
		boolean exists = (dbCus != null);
		
		if(exists == true)
			return "username already exists!";
		else {
			cusRepo.save(cus);
			return "user added successfully!";
		}
	}

}