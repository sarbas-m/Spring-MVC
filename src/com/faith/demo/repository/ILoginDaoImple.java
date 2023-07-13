package com.faith.demo.repository;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateQueryException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.faith.demo.entity.Doctor;
import com.faith.demo.entity.Staff;
import com.faith.demo.entity.User;
import com.faith.demo.service.ILoginService;

@Repository
public class ILoginDaoImple implements ILoginDao {
	
    @Autowired
    private SessionFactory sessionFactory;
    
	@Override
	@Transactional
	public User getRoleFromLogin(String username, String password) {
		
		User user = null;

		Session currentSession = sessionFactory.getCurrentSession();
		try {
		String hql = "FROM User WHERE username = :username AND password = :password";
		Query query = currentSession.createQuery(hql);
		query.setParameter("username", username);
		query.setParameter("password",password);
		
		
		user=(User) query.getSingleResult();
		System.out.println(user.getUserId());
		System.out.println(user.getRole().getRoleId());
		}
		catch(NoResultException e) {
			System.out.println("wrong username and password");
		}
		

		
		//return user.getRole().getRoleId() ;
		return user;
	}

	@Override
	@Transactional
	public Doctor getStaffName(int userId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Doctor> query = currentSession.createQuery("from Doctor where userId=:a",Doctor.class);
		
		Doctor staff=query.setParameter("a", userId).getSingleResult();
		return staff;
	}

	@Override
	@Transactional
	public Staff getStaffNameStaff(int userId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Staff> query = currentSession.createQuery("from Staff where userId=:a",Staff.class);
		Staff staff=query.setParameter("a", userId).getSingleResult();
		return staff;
	}

}
