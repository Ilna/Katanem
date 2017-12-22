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
import gr.hua.dit.service.CarsService;

@Controller
@RequestMapping("/cars")
public class CarsController {
	
		// inject the customer service
		@Autowired
		private CarsService carsService;
		
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
		
		@GetMapping("/{plates}")
		public String getCar(Model model, @PathVariable("plates") String plates) {
			// get the customer
			Cars cars = carsService.getCar(plates);
			
			model.addAttribute("cars", cars);
			
			return "cars-form";
		}
		
		@GetMapping("/showAddCarForm")
		public String showAddCarForm(Model model) {
			// create model attribute to get form data
			Cars cars = new Cars();
			model.addAttribute("cars", cars);
			
			// add page title
			model.addAttribute("pageTitle", "Add Car");
			return "cars-form";
		}
		
		@PostMapping("/saveCar")
		public String saveCar(@ModelAttribute("cars") Cars cars) {
			// save the customer using the service+
			System.out.println("in save cars :" + cars);
			carsService.saveCar(cars);
			
			return "redirect:/cars/list";
		}

	}


