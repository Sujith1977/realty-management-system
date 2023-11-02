/**
 * 
 */
package com.realtycare.realtymanagementsystem.repository;

import java.util.List;

import com.realtycare.realtymanagementsystem.model.Customer;

/**
 * @author Sujith1977
 *
 */
public interface ICustomerRepository {
	
	List<Customer> findAllCustomers();

	Customer findCustomerById(Long id);

	Customer saveCustomer(Customer customer);

	void deleteCustomerById(Long id);

	Customer updateCustomerById(Long id, Customer customer);

}
