package com.alexeypro.samples.testildo.services.impl;

import com.alexeypro.samples.testildo.dao.ITestJavaRecordsDAO;
import com.alexeypro.samples.testildo.services.ITestJavaRecords;
import com.alexeypro.samples.testildo.vo.TestJavaRecord;

import java.util.List;

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
    public String saveRandom(int myIndex) {
        long timeStamp = System.currentTimeMillis();
        String body = "random body " + myIndex + " @ " + timeStamp;
        String title = "random title " + myIndex + " @ " + timeStamp;
        return getDao().save(body, title);
    }

    @Override
    public List<TestJavaRecord> find(int limit) {
        return getDao().find(limit);
    }

}
