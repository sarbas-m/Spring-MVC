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
public class MedCompanyDaoImple implements ICompanyDao {
	
	@Autowired
	private SessionFactory sessionFactory;


	@Transactional
	public void saveCompany(MedicineCompany theCompany) {
		Session currentSession = sessionFactory.getCurrentSession();		
		currentSession.saveOrUpdate(theCompany);
		
	}


	@Transactional
	public List<MedicineCompany> getCompany() {
		// get the current hibernate session
					Session currentSession = sessionFactory.getCurrentSession();

					Query<MedicineCompany> theQuery = currentSession.createQuery("FROM MedicineCompany order by companyName", MedicineCompany.class);

					// execute query and get result set

					List<MedicineCompany> company = theQuery.getResultList();

					return company;
	}

	
	

}
