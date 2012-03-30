package com.alexeypro.samples.testildo.controllers;

import akka.actor.*;
import com.alexeypro.samples.testildo.Global;
import com.alexeypro.samples.testildo.actors.SaveListener;
import com.alexeypro.samples.testildo.actors.SaveMaster;
import com.alexeypro.samples.testildo.actors.messages.SaveRun;
import com.alexeypro.samples.testildo.services.ITestJavaRecords;
import com.alexeypro.samples.testildo.vo.TestJavaRecord;
import play.Logger;
import play.libs.Akka;
import play.libs.F;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Application extends Controller {

    public static Result index() {
        Logger.debug("index - default return");
        return ok("Hello World");
    }

    public static Result save() {
        ITestJavaRecords service = Global.getTestJavaRecordsService();

        for (int i = 0; i != Global.INSERT_COUNT; i++) {
            service.saveRandom(i);
        }
        Logger.debug("save - default return");
        return ok("Inserted random records!");
    }

    public static Result saveAsync() {
        final ITestJavaRecords service = Global.getTestJavaRecordsService();
        F.Promise<List<String>> promiseOfList = Akka.future(
                new Callable<List<String>>() {
                    public List<String> call() {
                        Logger.debug("call()");
                        List<String> list = new ArrayList<String>(1);
                        for (int i = 0; i != Global.INSERT_COUNT; i++) {
                            list.add(service.saveRandom(i));
                        }
                        return list;
                    }

                    ;
                }
        );
        async(
                promiseOfList.map(
                        new F.Function<List<String>, Result>() {
                            public Result apply(List<String> l) {
                                Logger.debug("Inserted the following IDs: " + l);
                                return ok("Inserting random records: " + l);
                            }
                        }
                )
        );
        Logger.debug("saveAsync - default return");
        return ok("Inserting random records!");
    }

    public static Result find() {
        ITestJavaRecords service = Global.getTestJavaRecordsService();
        List<TestJavaRecord> result = service.find(Global.SELECT_COUNT);
        Logger.debug("find - default return");
        return ok(Json.toJson(result));
    }

    public static Result saveActors() {
        ITestJavaRecords service = Global.getTestJavaRecordsService();
        executeSaveActors(service);
        Logger.debug("saveActors - default return");
        return ok("Inserting random records!");
    }

    private static void executeSaveActors(final ITestJavaRecords service) {
        Logger.debug("Application.saveAsync");
        ActorSystem system = ActorSystem.create("SaveAsyncSystem");

        // create the result listener, which will print the result and shutdown the system
        final ActorRef listener = system.actorOf(new Props(SaveListener.class), "saveListener");

        // create the master
        ActorRef master = system.actorOf(new Props(new UntypedActorFactory() {
            public UntypedActor create() {
                return new SaveMaster(service, listener);
            }
        }), "saveMaster");

        // start the calculation
        master.tell(new SaveRun(Global.INSERT_COUNT));
    }


}
