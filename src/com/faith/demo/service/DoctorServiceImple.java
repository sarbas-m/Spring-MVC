package com.faith.demo.service;

import com.faith.demo.entity.Doctor;
import com.faith.demo.repository.IDoctorDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImple implements IDoctorService {

    private final IDoctorDao doctorDao;

    @Autowired
    public DoctorServiceImple(IDoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorDao.getAllDoctors();
    }

    @Override
    public Doctor getDoctorById(int id) {
        return doctorDao.getDoctorById(id);
    }

    @Override
    public void addDoctor(Doctor doctor) {
        doctorDao.addDoctor(doctor);
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        doctorDao.updateDoctor(doctor);
    }

    @Override
    public void deleteDoctor(int id) {
        doctorDao.deleteDoctor(id);
    }

	public void disableDoctor(int doctorId) {
		doctorDao.disableDoctor(doctorId);
	}
}
