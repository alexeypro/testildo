package com.alexeypro.samples.testildo.connections;

public interface IConnection {

    /**
     * Connects to datastore
     *
     * @param username
     * @param password
     * @param hostname
     * @param port
     * @param datastore
     * @return
     */
    public void connect(String username, String password, String hostname, int port, String datastore);

    /**
     * Returns DB/Datastore object.
     *
     * @return
     */
    public Object getDb();
}
