package com.faith.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.demo.entity.Doctor;
import com.faith.demo.entity.Staff;
import com.faith.demo.entity.User;
import com.faith.demo.repository.ILoginDao;

@Service
public class LoginServiceImplementation implements ILoginService {
	
	@Autowired
	private ILoginDao LoginDao;

	@Override
	public User getRoleFromLogin(String username, String password) {
		System.out.println("sasdfgnda");
		
		return LoginDao.getRoleFromLogin(username, password);
	}

	@Override
	public Doctor getStaffName(int userId) {
		// TODO Auto-generated method stub
		return LoginDao.getStaffName(userId);
	}

	@Override
	public Staff getStaffNameStaff(int userId) {
		// TODO Auto-generated method stub
		return LoginDao.getStaffNameStaff(userId);
	}

}
