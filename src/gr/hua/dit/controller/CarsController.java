package gr.hua.dit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.entity.Cars;

import gr.hua.dit.entity.Customer;

import gr.hua.dit.service.CarsService;
import gr.hua.dit.service.CustomerService;


@Controller
@RequestMapping("/cars")
public class CarsController {
	
		// inject the customer service
		@Autowired
		private CarsService carsService;
		
		@Autowired
		private CustomerService customerService;
		
		@GetMapping("/list")
		public String listCars(Model model) {
			
			// get customers from the service
			List<Cars> cars = carsService.getCars();
			System.out.println("Cars : " + cars);
			// add the customers to the model
			model.addAttribute("cars",cars);
			
			// add page title
			model.addAttribute("pageTitle", "List Cars");
			return "list-cars";
		}
		
		@GetMapping("/customer/{plates}/list")
		public String listTeacherCourses(Model model, @PathVariable("plates") String plates) {
			
			// get courses from the service
			List<Cars> cars = carsService.getCustomerCars(plates);
			
			// add the courses to the model
			model.addAttribute("cars",cars);
			
			// add page title
			model.addAttribute("pageTitle", "Customer List Cars");
			return "list-cars";
		}
		
		
		@GetMapping("/{plates}")
		public String getCar(Model model, @PathVariable("plates") String plates) {
			// get the customer
			Cars cars = carsService.getCar(plates);
			
			model.addAttribute("cars", cars);
			
			return "cars-form";
		}
		
		@GetMapping("/showAddCarForm/{ownerId}")
		public String showAddForm(Model model, @PathVariable("ownerId") String ownerId) {
			// create model attribute to get form data
			Cars cars = new Cars();
			Customer customer = customerService.getCustomer(ownerId);
			cars.setCustomer(customer);
			System.out.println("Customer in show form -- > " + cars.getCustomer());

			model.addAttribute("cars", cars);

			// add page title
			model.addAttribute("pageTitle", "Add Car");
			return "cars-form";
		}
		
		@PostMapping("/saveCar/{ownerId}")
		public String saveCourse(@ModelAttribute("cars") Cars cars, @PathVariable("ownerId") String ownerId) {
			// save the course using the service
			Customer customer = customerService.getCustomer(ownerId);
			cars.setCustomer(customer);
			System.out.println("customer -- > " + cars.getCustomer());
			carsService.saveCar(cars);
			
			return "redirect:/cars/list";
		}

	}


