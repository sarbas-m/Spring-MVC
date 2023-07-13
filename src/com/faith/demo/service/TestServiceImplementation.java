package com.faith.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.demo.entity.Test;
import com.faith.demo.repository.ITestRepository;

@Service
public class TestServiceImplementation implements ITestService{
	
	@Autowired
	private ITestRepository testrepository;

	@Override
	public void saveTest(Test tested) {
		
		testrepository.saveTest(tested);
	}

	@Override
	public List<Test> getListTest() {
		// TODO Auto-generated method stub
		return testrepository.getListTest();
	}

	@Override
	public Test updateTests(int upId) {
		// TODO Auto-generated method stub
		return testrepository.updateTests(upId);
	}

	@Override
	public void deletingTest(int delId) {
		// TODO Auto-generated method stub
		testrepository.deletingTest(delId);
	}

	@Override
	public List<Test> searchingTest(String serchname) {
		// TODO Auto-generated method stub
		return testrepository.searchingTest(serchname);
	}

}
