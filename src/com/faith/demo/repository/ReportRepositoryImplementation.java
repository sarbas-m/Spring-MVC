package com.faith.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.faith.demo.entity.Appointment;
import com.faith.demo.entity.TestBill;
import com.faith.demo.example.ReportNeeds;

@Repository
public class ReportRepositoryImplementation implements IReportRepository{
	
	@Autowired
	private SessionFactory sessionfactory;

	@Transactional
	public List<ReportNeeds> reportList() {
		
		Session currentsession=sessionfactory.getCurrentSession();
		String hqlQuery="SELECT NEW com.faith.demo.example.ReportNeeds(r,tp,a,t,p,d) FROM TestReport r JOIN r.testPrescription tp JOIN tp.test t JOIN tp.appointment a JOIN a.patient p JOIN a.doctor d where tp.testPresIsActive=:cond ";
		Query query = currentsession.createQuery(hqlQuery);
		query.setParameter("cond", "true");
		List<ReportNeeds>allReports=query.getResultList();
		for(ReportNeeds rep:allReports) {
			System.out.println(rep.getTest().getTestName());
		}
		return allReports;
	}

	@Transactional

	public List<ReportNeeds> listOfReportGen(int appoId) {
		
		Session currentsession=sessionfactory.getCurrentSession();
		String hqlQuery="SELECT  NEW com.faith.demo.example.ReportNeeds(r,tp, a,t,p,d) FROM TestReport r JOIN r.testPrescription tp JOIN tp.test t JOIN tp.appointment a JOIN a.patient p JOIN a.doctor d  where a.appointmentId=:numb ";
        Query query=currentsession.createQuery(hqlQuery);
        query.setParameter("numb", appoId);
        List<ReportNeeds>repogenerationbefore=query.getResultList();

		
		return repogenerationbefore;
	}

	@Transactional
	public void removePrescription(int apppId) {

		Session currentsession=sessionfactory.getCurrentSession();
		Query query=currentsession.createQuery("UPDATE TestPrescription tr SET testPresIsActive=:state where tr.appointment.appointmentId=:numm");
		query.setParameter("state", "false");
		query.setParameter("numm", apppId);
		int status=query.executeUpdate();
		
	}

	@Transactional
	public void insertBil(TestBill tes) {
		
		Session currentsession=sessionfactory.getCurrentSession();
		currentsession.saveOrUpdate(tes);
		
	}

	@Transactional
	public Appointment gettingApObj(int appoinId) {
		
		Session currentsession=sessionfactory.getCurrentSession();
		Appointment app=currentsession.get(Appointment.class, appoinId);
		
		return app;
	}

	@Transactional
	public TestBill gettingBillNumber(int appoiId) {
		
		Session currentsession=sessionfactory.getCurrentSession();
		Query query=currentsession.createQuery("from TestBill where appointmentId=:idnum");
		query.setParameter("idnum", appoiId);
		TestBill billnumbers=(TestBill) query.getSingleResult();
		

		return billnumbers;
	}
	
	

}
