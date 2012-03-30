package com.alexeypro.samples.testildo.dao.impl;

import com.alexeypro.samples.testildo.connections.IConnection;
import com.alexeypro.samples.testildo.dao.ITestJavaRecordsDAO;
import com.alexeypro.samples.testildo.vo.TestJavaRecord;
import play.Logger;

import java.util.List;

public class TestJavaRecordsMongoDAOImpl implements ITestJavaRecordsDAO {
    private final static String DAO_NAME = "TestJavaRecordsMongo";
    private IConnection connection;
    
    public void setConnection(IConnection conn) {
        this.connection = conn;
    }

    @Override
    public IConnection getConnection() {
        return this.connection;
    }

    public String getName() {
        return DAO_NAME;
    }

    @Override
    public String save(String body, String title) {
        Logger.info(getName() + ": save('" + body + "', '" + title + "')");

        return null;
    }

    @Override
    public List<TestJavaRecord> find(int limit) {
        Logger.info(getName() + ": find(" + limit + ")");
        return null;
    }

}