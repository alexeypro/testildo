package com.alexeypro.samples.testildo.actors;

import akka.actor.UntypedActor;
import com.alexeypro.samples.testildo.actors.messages.SaveResult;
import com.alexeypro.samples.testildo.actors.messages.SaveWork;
import com.alexeypro.samples.testildo.services.ITestJavaRecords;
import play.Logger;

// worker actor
public class SaveWorker extends UntypedActor {

    private String run(ITestJavaRecords service, int myIndex) {
        Logger.debug("SaveWorker.run");
        return service.saveRandom(myIndex);
    }

    @Override
    public void onReceive(Object message) throws Exception {
        Logger.debug("SaveWorker.onReceive");
        if (message instanceof SaveWork) {
            SaveWork work = (SaveWork) message;
            String result = run(work.getService(), work.getIndex());
            getSender().tell(new SaveResult(result), getSelf());
        } else {
            unhandled(message);
        }
    }
}
