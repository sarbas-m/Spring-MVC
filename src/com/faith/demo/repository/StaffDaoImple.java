package com.faith.demo.repository;

import org.springframework.transaction.annotation.Transactional;

import com.faith.demo.entity.Staff;
import com.faith.demo.entity.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StaffDaoImple implements IStaffDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Staff> getAllStaff() {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.createQuery("SELECT s FROM Staff s where isActive='yes'", Staff.class).getResultList();
	}

	@Override
	@Transactional
	public Staff getStaffById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Staff.class, id);
	}

	@Override
	@Transactional
	public void addStaff(Staff staff) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(staff);
	}

	@Override
	@Transactional
	public void updateStaff(Staff staff) {
		Session session = sessionFactory.getCurrentSession();
		session.update(staff);
	}

	@Override
	@Transactional
	public void deleteStaff(int id) {
		Session session = sessionFactory.getCurrentSession();
		Staff staff = session.get(Staff.class, id);
		staff.setIsActive("false");
		session.saveOrUpdate(staff);
		
	}
	@Override
	   @Transactional
	   public void disableStaff(int id) {
	       Session currentSession = sessionFactory.getCurrentSession();
	      
		Query query = currentSession.createQuery("UPDATE Staff SET isActive = 'no' WHERE staffId = :id");
	       query.setParameter("id", id);
	       query.executeUpdate();
	   }

	@Override
	@Transactional
	public int getUserIdFromDb() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query query = currentSession.createQuery("SELECT MAX(userId) FROM User");
		Object result = query.uniqueResult();
		int lastPrimaryKey = (Integer) result;
		
		return lastPrimaryKey;
	}
}
