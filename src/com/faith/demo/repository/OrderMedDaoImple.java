package com.faith.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.faith.demo.entity.MedicineCompany;
import com.faith.demo.entity.MedicineOrder;


@Repository
public class OrderMedDaoImple implements IOrderMedDao {
	
	
	
	@Autowired 
	private SessionFactory sessionFactory;
	
	@Transactional
	public void saveOrder(MedicineOrder theOrder) {
		Session currentSession = sessionFactory.getCurrentSession();		
		currentSession.saveOrUpdate(theOrder);
	}
	@Transactional
	public List<MedicineOrder> getCompany() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<MedicineOrder> theQuery = currentSession.createQuery("FROM MedicineOrder order by orderId", MedicineOrder.class);

		// execute query and get result set

		List<MedicineOrder> order = theQuery.getResultList();

		return order;
	}

}
