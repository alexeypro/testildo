package com.alexeypro.samples.testildo.controllers;

import com.alexeypro.samples.testildo.vo.TestJavaRecord;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;

import com.alexeypro.samples.testildo.Global;
import com.alexeypro.samples.testildo.services.ITestJavaRecords;

import java.util.List;

public class Application extends Controller {
//	public static Result index() {
//		return ok(index.render("Your new application is ready."));
//	}
	
	public static Result index() {
		return ok("Hello World");
	}

    //TODO: change it to be async
    public static Result save() {
        ITestJavaRecords service = Global.getTestJavaRecordsService();
        for (int i = 0; i != Global.INSERT_COUNT; i++) {
            service.saveRandom(i);
        }
        return ok("Inserting random records");
    }

    //TODO: make sure we actually show something :-)
    public static Result find() {
        ITestJavaRecords service = Global.getTestJavaRecordsService();
        List<TestJavaRecord> result = service.find(Global.SELECT_COUNT);
        Logger.info(result.toString());
        return ok("N/A");
    }

}