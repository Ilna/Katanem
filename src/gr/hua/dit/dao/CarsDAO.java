package gr.hua.dit.dao;

import java.util.List;

import gr.hua.dit.entity.Cars;

public interface CarsDAO {

	public List<Cars> getCars();

	public void saveCar(Cars cars);
	
	public Cars getCar(String plates);

	public void deleteCar(String plates);

	public List<Cars> getNotCustomerCars(String ownerId);

	public List<Cars> getCustomerCars(String ownerId);
	
}
