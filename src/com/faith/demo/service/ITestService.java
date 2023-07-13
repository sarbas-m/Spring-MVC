package com.faith.demo.service;

import java.util.List;

import com.faith.demo.entity.Test;

public interface ITestService {
	
	public void saveTest(Test tested);
	
	public List<Test>getListTest();
	
	public Test updateTests(int upId);
	
	public void deletingTest(int delId);
	
	public List<Test> searchingTest(String serchname);

}
