package com.alexeypro.samples.testildo.dao;

import java.util.List;

import com.alexeypro.samples.testildo.vo.TestJavaRecord;

public interface ITestJavaRecordsDAO {
	
	/**
	 * Returns the name of the implementation.
	 * 
	 * @return
	 */
	public String getName();
	
	/**
	 * Saves new {@see TestJavaRecord} into data storage with specified properties.
	 * 
	 * @param body
	 * @param title
	 * @return
	 */
	public String save(String body, String title);
	
	/**
	 * Retrieves {@see TestJavaRecord} from data storage by limit.
	 * 
	 * @param limit
	 * @return
	 */
	public List<TestJavaRecord> find(int limit);
}