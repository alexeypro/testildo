package com.alexeypro.samples.testildo.dao;

import java.util.List;

import com.alexeypro.samples.testildo.connections.IConnection;
import com.alexeypro.samples.testildo.vo.TestJavaRecord;

public interface ITestJavaRecordsDAO {

    /**
     * Returns the connection which this DAO is using.
     *
     * @return
     */
    public IConnection getConnection();

    /**
     * Returns the name of the implementation.
     *
     * @return
     */
    public String getName();

    /**
     * Saves new {@see TestJavaRecordModel} into data storage with specified properties.
     *
     * @param body
     * @param title
     * @return Id
     */
    public String save(String body, String title);

    /**
     * Retrieves {@see TestJavaRecordModel} from data storage by limit.
     *
     * @param limit
     * @return
     */
    public List<TestJavaRecord> find(int limit);
}