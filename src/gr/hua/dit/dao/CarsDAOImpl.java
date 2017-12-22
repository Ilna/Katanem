package gr.hua.dit.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Cars;


@Repository
public class CarsDAOImpl implements CarsDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Cars> getCars() {
		// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				// create a query
				Query<Cars> query = currentSession.createQuery("from Cars order by plates", 
						Cars.class);
				
				
				// execute the query and get the results list
				List<Cars> cars = query.getResultList();
						
				//return the results
				return cars;
	}

	@Override
	public void saveCar(Cars cars) {
		// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				// save the customer
				currentSession.save(cars);

	}

	@Override
	public Cars getCar(String plates) {
		// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				//get and return Customer
				Cars cars = currentSession.get(Cars.class, plates);
				return cars;
	}

	@Override
	public void deleteCar(String plates) {
		// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				// find the customer
				Cars cars = currentSession.get(Cars.class, plates);

				
				// delete customer
				currentSession.delete(cars);
	}

}
