package com.alexeypro.samples.testildo.services.impl;

import java.util.List;

import com.alexeypro.samples.testildo.dao.ITestJavaRecordsDAO;
import com.alexeypro.samples.testildo.services.ITestJavaRecords;
import com.alexeypro.samples.testildo.vo.TestJavaRecord;

public class TestJavaRecordsImpl implements ITestJavaRecords {	
	private ITestJavaRecordsDAO testJavaRecordsDAO;
	
	public void setDao(ITestJavaRecordsDAO dao) {
		this.testJavaRecordsDAO = dao;
	}

	@Override
	public ITestJavaRecordsDAO getDao() {
		return testJavaRecordsDAO;
	}

	@Override
	public String saveRandom(int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TestJavaRecord> find(int limit) {
		// TODO Auto-generated method stub
		return null;
	}

}
