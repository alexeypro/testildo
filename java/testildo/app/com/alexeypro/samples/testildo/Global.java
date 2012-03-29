package com.alexeypro.samples.testildo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import play.Application;
import play.GlobalSettings;
import play.Logger;

import com.alexeypro.samples.testildo.services.ITestJavaRecords;
import com.google.code.morphia.logging.MorphiaLoggerFactory;
import com.google.code.morphia.logging.slf4j.SLF4JLogrImplFactory;

public class Global extends GlobalSettings {
    private final static String APPLICATION_CONTEXT_XML = "application-context.xml";
    private final static String DEFAULT_PORT = "9000";
    public final static int INSERT_COUNT = 5;
    public final static int SELECT_COUNT = 5;

    private static ApplicationContext context;

    @Override
    public void onStart(Application app) {
        MorphiaLoggerFactory.registerLogger(SLF4JLogrImplFactory.class);
        Global.context = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_XML);
        Logger.info("onStart(..)");

        String portNumber = (app.configuration().getString("http.port") == null) ? DEFAULT_PORT : app.configuration().getString("http.port");
        // TODO: not sure where do we get the port :-(
        Logger.info(app.configuration().keys().toString());
        Logger.info("http://localhost:" + portNumber + "/      - Hello World");
        Logger.info("http://localhost:" + portNumber + "/save  - async save " + INSERT_COUNT + " record(s) into database");
        Logger.info("http://localhost:" + portNumber + "/find  - find " + SELECT_COUNT + " record(s) in database");
    }

    @Override
    public void onStop(Application app) {
        Logger.info("onStop(..)");
    }

    public static ApplicationContext getApplicationContext() {
        return Global.context;
    }

    // Dumb helpers

    public static ITestJavaRecords getTestJavaRecordsService() {
        return (ITestJavaRecords) Global.getApplicationContext().getBean("testJavaRecordsService");
    }

}
