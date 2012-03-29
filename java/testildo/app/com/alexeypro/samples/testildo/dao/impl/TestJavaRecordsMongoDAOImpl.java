package com.alexeypro.samples.testildo.dao.impl;

import java.util.List;

import com.alexeypro.samples.testildo.dao.ITestJavaRecordsDAO;
import com.alexeypro.samples.testildo.vo.TestJavaRecord;

public class TestJavaRecordsMongoDAOImpl implements ITestJavaRecordsDAO {
	private final static String DAO_NAME = "TestJavaRecordsMongo";
	
	public String getName() {
		return DAO_NAME;
	}

	@Override
	public String save(String body, String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TestJavaRecord> find(int limit) {
		// TODO Auto-generated method stub
		return null;
	}
	
}