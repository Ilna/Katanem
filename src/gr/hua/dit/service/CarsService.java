package gr.hua.dit.service;
import java.util.List;

import gr.hua.dit.entity.Cars;


public interface CarsService {
	public List<Cars> getCars();

	public void saveCar(Cars cars);
	
	public Cars getCar(String plates);

	public void deleteCar(String plates);
	
	public List<Cars> getNotCustomerCars(String OwnerId);
	
	public List<Cars> getCustomerCars(String OwnerId);
}