package com.faith.demo.service;

import com.faith.demo.entity.Staff;
import com.faith.demo.repository.IStaffDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImple implements IStaffService {

    private final IStaffDao staffDao;

    @Autowired
    public StaffServiceImple(IStaffDao staffDao) {
        this.staffDao = staffDao;
    }

    @Override
    public List<Staff> getAllStaff() {
        return staffDao.getAllStaff();
    }

    @Override
    public Staff getStaffById(int id) {
        return staffDao.getStaffById(id);
    }

    @Override
    public void addStaff(Staff staff) {
        staffDao.addStaff(staff);
    }

    @Override
    public void updateStaff(Staff staff) {
        staffDao.updateStaff(staff);
    }

    @Override
    public void deleteStaff(int id) {
        staffDao.deleteStaff(id);
    }
    
    public void disableStaff(int staffId) {
		staffDao.disableStaff(staffId);
	}

	@Override
	public int getUserIdFromDb() {
		// TODO Auto-generated method stub
		return staffDao.getUserIdFromDb();
	}
}
