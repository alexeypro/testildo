package com.alexeypro.samples.testildo.connections.impl;

import com.alexeypro.samples.testildo.connections.IConnection;
import com.alexeypro.samples.testildo.vo.mongo.TestJavaRecordModel;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import play.Logger;

import java.net.UnknownHostException;

public class ConnectionMongoImpl implements IConnection {
    private Datastore db;

    @Override
    public void connect(String username, String password, String hostname, int port, String datastore) {
        try {
            Mongo mongo = new Mongo(hostname, port);
            this.db = new Morphia().map(TestJavaRecordModel.class).createDatastore(mongo, datastore);
            this.db.ensureIndexes();
        } catch (UnknownHostException ex) {
            Logger.error("Exception: " + ex);
        }
        Logger.debug("Connected to " + hostname + ":" + port +
                " using username '" + username + "' and password '" + password + "' to datastore '" + datastore + "'");
    }

    @Override
    public Object getDb() {
        return this.db;
    }

    @Override
    public boolean isConnected() {
        return this.db != null;
    }

}
