package gr.hua.dit.service;

import java.util.List;

import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import gr.hua.dit.dao.CarsDAO;
import gr.hua.dit.entity.Cars;

@Service
public class CarsServiceImpl implements CarsService {

	@Autowired
	private CarsDAO carsDAO;
	
	
	@Override
	@Transactional
	public List<Cars> getCars() {
		return carsDAO.getCars();
	}

	@Override
	@Transactional
	public void saveCar(Cars cars) {
		carsDAO.saveCar(cars);
	}

	@Override
	@Transactional
	public Cars getCar(String plates) {
		return carsDAO.getCar(plates);
	}

	@Override
	@Transactional
	public void deleteCar(String plates) {
		carsDAO.deleteCar(plates);
	}

}
