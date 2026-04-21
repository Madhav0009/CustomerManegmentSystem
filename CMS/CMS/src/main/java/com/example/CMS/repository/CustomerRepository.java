package com.example.CMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CMS.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	Customer findByUsername(String uName);
}
