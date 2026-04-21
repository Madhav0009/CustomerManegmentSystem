package com.example.CMS.service;

import com.example.CMS.entity.Customer;

public interface CustomerService {

	boolean validate(Customer cus);
	String addUser(Customer cus);
}
