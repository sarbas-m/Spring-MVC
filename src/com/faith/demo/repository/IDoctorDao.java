package com.faith.demo.repository;

import com.faith.demo.entity.Doctor;

import java.util.List;

public interface IDoctorDao {

    List<Doctor> getAllDoctors();

    Doctor getDoctorById(int id);

    void addDoctor(Doctor doctor);

    void updateDoctor(Doctor doctor);

    void deleteDoctor(int id);
    
    void disableDoctor(int doctorId);
}
