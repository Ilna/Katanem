package gr.hua.dit.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Cars;

import gr.hua.dit.entity.Customer;



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
				
				//get and return Car
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

	@Override
	public List<Cars> getNotCustomerCars(String ownerId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		List<Cars> cars = currentSession.createQuery("from cars c where c.customer!="+ownerId).getResultList();
		System.out.println("not customer car " + cars);
		return cars;
	}

	@Override
	public List<Cars> getCustomerCars(String ownerId) {
      
		Session currentSession = sessionFactory.getCurrentSession();
		
		Customer customer = (Customer) currentSession.createQuery("from  Customer where identityNumber = " +ownerId).getSingleResult();
		System.out.println("Customer car " + customer.getCars());

		return customer.getCars();
	}

}
