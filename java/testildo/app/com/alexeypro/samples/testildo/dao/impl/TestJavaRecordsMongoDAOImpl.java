package com.alexeypro.samples.testildo.dao.impl;

import com.alexeypro.samples.testildo.connections.IConnection;
import com.alexeypro.samples.testildo.connections.impl.ConnectionMongoImpl;
import com.alexeypro.samples.testildo.dao.ITestJavaRecordsDAO;
import com.alexeypro.samples.testildo.vo.TestJavaRecord;
import com.alexeypro.samples.testildo.vo.mongo.TestJavaRecordModel;
import com.google.code.morphia.Datastore;
import org.bson.types.ObjectId;
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
        TestJavaRecordModel m = new TestJavaRecordModel();
        m.setBody(body);
        m.setTitle(title);
        Datastore ds = (Datastore) getConnection().getDb();
        if (ds == null) {
           Logger.error("Datastore was not properly initialized!");
        } else {
            ds.save(m);
        }
        return (m.getId() == null ? null : m.getId().toString());
    }

    @Override
    public List<TestJavaRecord> find(int limit) {
        Logger.info(getName() + ": find(" + limit + ")");
        Datastore ds = (Datastore) getConnection().getDb();
        if (ds == null) {
            Logger.error("Datastore was not properly initialized!");
        } else {
            List<TestJavaRecordModel> result = ds.find(TestJavaRecordModel.class).limit(limit).asList();
            Logger.debug(result.toString());
        }
        return null;
    }

}