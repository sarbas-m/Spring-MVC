package com.faith.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.faith.demo.entity.Test;

@Repository
public class TestRepositoryImplementation implements ITestRepository {
	
	
	
	@Autowired
	private SessionFactory sessionfactory;

	@Transactional
	public void saveTest(Test tested) {
		
		Session currentsession= sessionfactory.getCurrentSession();
		currentsession.saveOrUpdate(tested);
	}

	@Transactional
	public List<Test> getListTest() {
		
		Session currentsession= sessionfactory.getCurrentSession();
		Query query=currentsession.createQuery("from Test", Test.class);
		List<Test>listedTest=query.getResultList();

		return listedTest;
	}

	@Transactional
	public Test updateTests(int upId) {
		
		Session currentsession= sessionfactory.getCurrentSession();
		Test updaterTest=currentsession.get(Test.class, upId);

		return updaterTest;
	}

	@Transactional
	public void deletingTest(int delId) {
		
		Session currentsession= sessionfactory.getCurrentSession();
		Test deleTest=currentsession.get(Test.class, delId);
		currentsession.remove(deleTest);

	}

	@Transactional
	public List<Test> searchingTest(String serchname) {
		
		Session currentsession= sessionfactory.getCurrentSession();
		Query query=currentsession.createQuery("from Test where testName=:name");
		query.setParameter("name", serchname);
		List<Test>searchedTests=query.getResultList();
		

		return searchedTests;
	}

}
