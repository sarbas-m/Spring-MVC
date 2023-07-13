package com.faith.demo.repository;

import java.util.List;

import com.faith.demo.entity.Test;

public interface ITestRepository {

	public void saveTest(Test tested);
	
	public List<Test>getListTest();

	public Test updateTests(int upId);

	public void deletingTest(int delId);

	public List<Test> searchingTest(String serchname);


}
