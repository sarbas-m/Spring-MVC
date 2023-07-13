package com.faith.demo.repository;

import com.faith.demo.entity.Staff;

import java.util.List;

public interface IStaffDao {
	
    List<Staff> getAllStaff();
    
    Staff getStaffById(int id);
    
    void addStaff(Staff staff);
    
    void updateStaff(Staff staff);
    
    void deleteStaff(int id);
    void disableStaff(int staffId);
    
    public int getUserIdFromDb();
}
