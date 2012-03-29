package com.alexeypro.samples.testildo.controllers;

import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;

import com.alexeypro.samples.testildo.Global;
import com.alexeypro.samples.testildo.services.ITestJavaRecords;

public class Application extends Controller {
//	public static Result index() {
//		return ok(index.render("Your new application is ready."));
//	}
	
	public static Result index() {
		return ok("Hello World");
	}
    
    public static Result save() {
        ITestJavaRecords service = Global.getTestJavaRecordsService();
        service.saveRandom(1);
        service.saveRandom(2);
        service.saveRandom(3);
        service.saveRandom(4);
        service.saveRandom(5);
        return ok("Inserting random records");
    }
    
    public static Result find() {
        return ok("N/A");
    }

}