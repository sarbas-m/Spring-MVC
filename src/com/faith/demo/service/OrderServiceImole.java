package com.faith.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.demo.entity.MedicineOrder;
import com.faith.demo.repository.ICompanyDao;
import com.faith.demo.repository.IOrderMedDao;



@Service
public class OrderServiceImole implements IOrderService {
	
	
	@Autowired
	private IOrderMedDao orderDao;

	public void saveOrder(MedicineOrder theOrder) {
		orderDao.saveOrder(theOrder);
		
	}

	public List<MedicineOrder> getCompany() {
		return orderDao.getCompany();
	}

}
