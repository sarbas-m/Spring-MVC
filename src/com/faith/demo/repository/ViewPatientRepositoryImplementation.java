package com.faith.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.faith.demo.entity.TestReport;
import com.faith.demo.example.ViewPatientForTest;



@Repository
public class ViewPatientRepositoryImplementation implements IViewPatientRepository {
	
	@Autowired
	SessionFactory sessionfactory;
	
	
    @Transactional
	public List<ViewPatientForTest> patientForTest() {
		
		Session currentsession= sessionfactory.getCurrentSession();
		String hqlQuery="SELECT NEW com.faith.demo.example.ViewPatientForTest(tr,a,t,p,d)FROM TestPrescription tr JOIN tr.test t JOIN tr.appointment a JOIN a.patient p JOIN a.doctor d where tr.testPresIsActive=:condition";
	   
		Query query= currentsession.createQuery(hqlQuery);
		query.setParameter("condition", "true");
		List<ViewPatientForTest>viewAllPatientTest=query.getResultList();
		
		for(ViewPatientForTest viewtes:viewAllPatientTest) {
			System.out.println(viewtes.getDoctor().getDoctorName());
		}
		
		
		return viewAllPatientTest;
	}


    @Transactional
	public List<ViewPatientForTest> detailsOfEachTest(int appointId) {
    	
		Session currentsession= sessionfactory.getCurrentSession();
		String hqlQuery="SELECT NEW com.faith.demo.example.ViewPatientForTest(tr,a,t,p,d)FROM TestPrescription tr JOIN tr.test t JOIN tr.appointment a JOIN a.patient p JOIN a.doctor d where a.appointmentId=:num and testPresIsActive='true'";
		Query query =currentsession.createQuery(hqlQuery);
		query.setParameter("num", appointId);
		List<ViewPatientForTest>eachTest=query.getResultList();
		
		for(ViewPatientForTest each:eachTest) {
			System.out.println(each.getTest().getTestName());
		}

		return eachTest;
	}


    @Transactional
	public List<ViewPatientForTest> tsetDetailWithPrescription(int preId) {
    	
		Session currentsession= sessionfactory.getCurrentSession();
		String hqlQuery="SELECT NEW com.faith.demo.example.ViewPatientForTest(tr,a,t,p,d)FROM TestPrescription tr JOIN tr.test t JOIN tr.appointment a JOIN a.patient p JOIN a.doctor d where tr.testPrescriptionId=:number";
         Query query=currentsession.createQuery(hqlQuery);
         query.setParameter("number", preId);
         List<ViewPatientForTest>detalisOfTestWithPres=query.getResultList();
    	
		return detalisOfTestWithPres;
	}


    @Transactional
	public void saveActual(TestReport tes) {
    	
		Session currentsession= sessionfactory.getCurrentSession();
		currentsession.saveOrUpdate(tes);

    	
		
	}


    @Transactional
	public TestReport editingResult(int pId) {
    	
    	
		Session currentsession= sessionfactory.getCurrentSession();
		Query query=currentsession.createQuery(" from TestReport where testPrescriptionId=:nums");
		query.setParameter("nums", pId);
		TestReport testr=(TestReport) query.getSingleResult();
		

		return testr;
	}

}
