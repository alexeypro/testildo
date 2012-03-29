package com.alexeypro.samples.testildo.services;

import java.util.List;

import com.alexeypro.samples.testildo.dao.ITestJavaRecordsDAO;
import com.alexeypro.samples.testildo.vo.TestJavaRecord;

public interface ITestJavaRecords {
	
	/**
	 * Just a convenience method for now.
	 * 
	 * @return
	 */
	public ITestJavaRecordsDAO getDao();
	
	/**
	 * Saves randomly generated {@see TestJavaRecord} objects into data storage.
	 * 
	 * @param count
	 * @return
	 */
	public String saveRandom(int count);
	
	/**
	 * Returns all {@see TestJavaRecord} objects fetched from the data storage by limit.
	 * 
	 * @param limit
	 * @return
	 */
	public List<TestJavaRecord> find(int limit);
	
}
