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
     * Saves randomly generated {@see TestJavaRecordModel} object into data storage.
     *
     * @param myIndex basically order of when this item scheduled to be saved
     * @return
     */
    public String saveRandom(int myIndex);

    /**
     * Returns all {@see TestJavaRecordModel} objects fetched from the data storage by limit.
     *
     * @param limit
     * @return
     */
    public List<TestJavaRecord> find(int limit);

}
