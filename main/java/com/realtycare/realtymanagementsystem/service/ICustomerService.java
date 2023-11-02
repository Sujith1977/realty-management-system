package com.realtycare.realtymanagementsystem.service;

import java.util.List;

import com.realtycare.realtymanagementsystem.model.Customer;

/**
 * @author Sujith1977
 *
 */

public interface ICustomerService {

	List<Customer> getAllCustomers();

	Customer getCustomerById(Long customerId);

	Customer addCustomer(Customer customer);

	Customer updateCustomerById(Long customerId, Customer updatedCustomer);

	void deleteCustomerById(Long customerId);
}
