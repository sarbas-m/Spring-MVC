package com.faith.demo.service;

import com.faith.demo.entity.Staff;
import java.util.List;

public interface IStaffService {

   List<Staff> getAllStaff();

   Staff getStaffById(int id);

   public void addStaff(Staff staff);

   public void updateStaff(Staff staff);

   public void deleteStaff(int id);
   
   public void disableStaff(int staffId);
   
   public int getUserIdFromDb();
   
}
