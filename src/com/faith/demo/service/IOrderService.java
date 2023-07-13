package com.faith.demo.service;

import java.util.List;

import com.faith.demo.entity.MedicineOrder;

public interface IOrderService {

	
	
	public void saveOrder(MedicineOrder theOrder);
	
	 public List<MedicineOrder> getCompany();

}
