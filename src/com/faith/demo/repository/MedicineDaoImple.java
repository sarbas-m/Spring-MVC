package com.faith.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.faith.demo.entity.Medicine;
import com.faith.demo.entity.MedicineCompany;





@Repository
public class MedicineDaoImple implements IMedicineDao {
	
	    @Autowired 
		private SessionFactory sessionFactory;


	@Transactional
	public List<Medicine> getMedicine() {
			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();

			Query<Medicine> theQuery = currentSession.createQuery("FROM Medicine where medicineIsActive='yes' order by medicineName", Medicine.class);

			// execute query and get result set

			List<Medicine> medicines = theQuery.getResultList();

			return medicines;
	}


	@Transactional
	public Medicine searchById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Transactional
	public List<Medicine> searchByName(String sName) {
	
		
		 Session currentSession = sessionFactory.getCurrentSession();
		  
		  Query<Medicine> theQuery =
		  currentSession.createQuery("FROM Medicine WHERE medicineName=:name",
		  Medicine.class); theQuery.setParameter("name", sName);
		  
		  // execute query and get result set
		  
		  List<Medicine> customersSearch = theQuery.getResultList();
		  
		  return customersSearch;
		 
	}
	@Override
	@Transactional
	public void saveMedicine(Medicine theMedicine) {
		
				Session currentSession = sessionFactory.getCurrentSession();

				
				currentSession.saveOrUpdate(theMedicine);

		
	}
	@Override
	@Transactional
	public void deleteMedicine(Medicine theMedicine) {
		Session currentSession = sessionFactory.getCurrentSession();

		// delete the customer
		currentSession.remove(theMedicine);
	}
	
	
	
	@Transactional
	public Medicine getmedicine(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Medicine theMedicine=currentSession.get(Medicine.class,theId);
		
		return theMedicine;
	}
	
	
	
	
	
	
	@Transactional
	public Medicine searchMedicine(int medicineId) {
		
		  Session currentSession= sessionFactory.getCurrentSession();
		  Medicine theQuery=currentSession.get(Medicine.class,medicineId);
		   
		   return theQuery;

	}   

	@Transactional	   
	public void disableMedicine(Medicine theMed) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theMed);
		
	}
	/*
	 * @Override
	 * 
	 * @Transactional public List<MedicineCompany> medCompanyList() { Session
	 * currentSession = sessionFactory.getCurrentSession(); Query<MedicineCompany>
	 * theQuery = currentSession.createQuery("FROM MedicineCompany",
	 * MedicineCompany.class); List<MedicineCompany>
	 * listComp=theQuery.getResultList();
	 * 
	 * return listComp; }
	 */


	@Override
	public List<MedicineCompany> medCompanyList() {
		// TODO Auto-generated method stub
		return null;
	}

}
