package com.faith.demo.service;

import com.faith.demo.entity.Doctor;

import java.util.List;

public interface IDoctorService {
    List<Doctor> getAllDoctors();
    Doctor getDoctorById(int id);
    void addDoctor(Doctor doctor);
    void updateDoctor(Doctor doctor);
    void deleteDoctor(int id);
}
