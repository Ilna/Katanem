package gr.hua.dit.dao;

import java.util.List;

import gr.hua.dit.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);
	
	public Customer getCustomer(String IdentityNumber);

	public void deleteCustomer(String identityNumber);
	
}
