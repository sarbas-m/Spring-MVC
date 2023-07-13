package com.faith.demo.repository;

import java.util.List;

import com.faith.demo.entity.Medicine;
import com.faith.demo.entity.MedicineCompany;
import com.faith.demo.entity.MedicineOrder;

public interface IOrderMedDao {
	
	
	//insert /update
			public void saveOrder(MedicineOrder theOrder);
			
			 public List<MedicineOrder> getCompany();

}
