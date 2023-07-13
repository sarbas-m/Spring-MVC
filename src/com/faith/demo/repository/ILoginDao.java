package com.faith.demo.repository;

import com.faith.demo.entity.Doctor;
import com.faith.demo.entity.Staff;
import com.faith.demo.entity.User;

public interface ILoginDao {
	
	User getRoleFromLogin(String username, String password);
	public Doctor getStaffName(int userId);
	
	public Staff getStaffNameStaff(int userId);

}
