package repository.customer;

import java.util.List;

import model.Customer;

public interface CustomerDAO  {

	void createCustomer(Customer username);
	void deleteCustomer(int customerId);
	void updateCustomer(Customer username);
	Customer readCustomer(String username);
	List<Customer> listAllCustomers();	
}

