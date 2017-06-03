package com.test.dao;

import com.test.pojo.Customer;

public interface CustomerDao {
	public void insert(Customer customer);
	public Customer findByCustomerId(int cusId);
}
