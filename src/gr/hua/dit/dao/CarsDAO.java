package gr.hua.dit.dao;

import java.util.List;

import gr.hua.dit.entity.Cars;

public interface CarsDAO {

	public List<Cars> getCars();

	public void saveCar(Cars customer);
	
	public Cars getCar(String Plates);

	public void deleteCar(String Plates);
	
}
