package com.faith.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.faith.demo.example.MedPres;
import com.faith.demo.example.ViewPatientForOp;

@Repository
public class PrescriptionDaoImple implements IPrescription {

	private SessionFactory sessionFactory;

	@Autowired
	public PrescriptionDaoImple(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<MedPres> medPresImp() {
		Session currentsession = sessionFactory.getCurrentSession();
		System.out.println("dsada");
		String hqlQuery = "SELECT NEW com.faith.demo.example.MedPres(p,mr,d,m,f,a)FROM MedicinePrescription mr JOIN mr.medicine m JOIN mr.appointment a JOIN mr.dosage f JOIN a.patient p JOIN a.doctor d where mr.medPresIsActive=:con";

		Query query = currentsession.createQuery(hqlQuery);
		query.setParameter("con", "yes");

		List<MedPres> viewAllPatient = query.getResultList();


		return viewAllPatient;
	}

	@Transactional
	public List<ViewPatientForOp> detailsOfEachOp(int appointId) {
		Session currentsession = sessionFactory.getCurrentSession();
		String hqlQuery = "SELECT NEW com.faith.demo.example.ViewPatientForOp(mr,a,p,d,m,f)FROM MedicinePrescription mr JOIN mr.medicine m JOIN mr.appointment a JOIN mr.dosage f JOIN a.patient p JOIN a.doctor d where a.appointmentId=:num";
		Query query = currentsession.createQuery(hqlQuery);
		query.setParameter("num", appointId);
		List<ViewPatientForOp> eachTest = query.getResultList();

		for (ViewPatientForOp each : eachTest) {
			System.out.println(each.getDoctor());
		}

		return eachTest;
	}

	@Transactional
	public void removePv(int apId) {
		Session currentsession = sessionFactory.getCurrentSession();
		Query query = currentsession.createQuery(
				"UPDATE MedicinePrescription mr SET medPresIsActive=:state where mr.appointment.appointmentId=:nubb");
		query.setParameter("state", "false");
		query.setParameter("nubb", apId);
		int status = query.executeUpdate();

	}

}
