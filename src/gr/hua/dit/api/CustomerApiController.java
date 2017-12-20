package gr.hua.dit.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gr.hua.dit.entity.Customer;
import gr.hua.dit.entity.CustomerList;
import gr.hua.dit.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerApiController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CustomerList customerList;

	@RequestMapping(value = "/{IdentityNumber}", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public Customer getCustomer(@PathVariable("IdentityNumber") int IdentityNumber) {

		Customer customer = customerService.getCustomer(IdentityNumber);
		System.out.println("customer :" + customer);

		return customer;
	}

	@RequestMapping(value="/delete/{IdentityNumber}", method= RequestMethod.DELETE, produces = { "application/json", "application/xml" })
	public ResponseEntity deleteCustomer(@PathVariable("IdentityNumber") int IdentityNumber) {
		customerService.deleteCustomer(IdentityNumber);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public CustomerList getCustomers() {

		List<Customer> customers = customerService.getCustomers();
		System.out.println("customers :" + customers);
		this.customerList.setCustomerList(customers);
		return this.customerList;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = { "application/json", "application/xml" })
	public Customer createCustomer(@RequestParam("IdentityNumber") String IdentityNumber,
			@RequestParam("Name") String Name, @RequestParam("Surname") String Surname,@RequestParam("TaxNumber") String TaxNumber, @RequestParam("DateCarLicence") String DateCarLicence, @RequestParam("History") String History) {
		int TaxNumber1=Integer.parseInt(TaxNumber);
		Customer customer = new Customer(IdentityNumber, Name, Surname, TaxNumber1,DateCarLicence, History);
		
		customerService.saveCustomer(customer);
		return customer;

	}

	@RequestMapping(value = "/jsonadd", method = RequestMethod.POST,  produces = { "application/json", "application/xml" })
	public Customer createCustomerfromJson(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		return customer;
	}
	
	

}
