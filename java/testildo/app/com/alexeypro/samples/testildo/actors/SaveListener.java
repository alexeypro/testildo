package com.alexeypro.samples.testildo.actors;

import akka.actor.UntypedActor;
import com.alexeypro.samples.testildo.actors.messages.SaveFinal;
import play.Logger;

// listener actor
public class SaveListener extends UntypedActor {

    public void onReceive(Object message) {
        Logger.debug("SaveListener.onReceive");
        if (message instanceof SaveFinal) {
            SaveFinal result = (SaveFinal) message;
            Logger.info("Job is done with result: " + result.getResult() + " and it took: " + result.getDuration());
            getContext().system().shutdown();
        } else {
            unhandled(message);
        }
    }

}
