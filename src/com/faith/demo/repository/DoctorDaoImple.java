package com.faith.demo.repository;

import com.faith.demo.entity.Doctor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DoctorDaoImple implements IDoctorDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Doctor> getAllDoctors() {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("SELECT d FROM Doctor d where isActive='yes'", Doctor.class)
                .getResultList();
    }

    @Override
    @Transactional
    public Doctor getDoctorById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Doctor.class, id);
    }

    @Override
    @Transactional
    public void addDoctor(Doctor doctor) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(doctor);
    }

    @Override
    @Transactional
    public void updateDoctor(Doctor doctor) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(doctor);
    }
   @Override
    @Transactional
    public void deleteDoctor(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Doctor doctor = currentSession.get(Doctor.class, id);
        doctor.setIsActive("false");
        currentSession.save(doctor);
        
    }
   
   @Override
   @Transactional
   public void disableDoctor(int id) {
       Session currentSession = sessionFactory.getCurrentSession();
      
	Query query = currentSession.createQuery("UPDATE Doctor SET isActive = 'no' WHERE doctorId = :id");
       query.setParameter("id", id);
       query.executeUpdate();
   }



}
    
