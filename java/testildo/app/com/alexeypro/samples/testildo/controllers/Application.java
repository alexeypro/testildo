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
		ITestJavaRecords x = Global.getTestJavaRecordsService();
		Logger.info("Here what it is " + x.getDao().getName());
		return ok("Hello World");
	}

}