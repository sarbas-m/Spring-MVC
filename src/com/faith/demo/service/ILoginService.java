package com.faith.demo.service;

import com.faith.demo.entity.Doctor;
import com.faith.demo.entity.Staff;
import com.faith.demo.entity.User;

public interface ILoginService {

	User getRoleFromLogin(String username, String password);
	
	public Doctor getStaffName(int userId);
	
	public Staff getStaffNameStaff(int userId);
	

}
