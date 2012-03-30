package com.alexeypro.samples.testildo.actors;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.util.Duration;
import com.alexeypro.samples.testildo.actors.messages.SaveFinal;
import com.alexeypro.samples.testildo.actors.messages.SaveResult;
import com.alexeypro.samples.testildo.actors.messages.SaveRun;
import com.alexeypro.samples.testildo.actors.messages.SaveWork;
import com.alexeypro.samples.testildo.services.ITestJavaRecords;
import play.Logger;

import java.util.concurrent.TimeUnit;

// master actor
public class SaveMaster extends UntypedActor {
    private final ITestJavaRecords service;
    private final long start = System.currentTimeMillis();
    private final ActorRef listener;
    private final ActorRef workerRouter;

    public SaveMaster(ITestJavaRecords service, ActorRef listener) {
        Logger.debug("SaveMaster.constructor");
        this.service = service;     // have it here 'cause it's kinda shared
        this.listener = listener;
        Props props = new Props(SaveWorker.class);
        this.workerRouter = this.getContext().actorOf(props, "saveWorker");
    }

    @Override
    public void onReceive(Object message) throws Exception {
        Logger.debug("SaveMaster.onReceive");
        if (message instanceof SaveRun) {
            SaveRun run = (SaveRun) message;
            this.workerRouter.tell(new SaveWork(this.service, run.getIndex()), getSelf());
        } else if (message instanceof SaveResult) {
            SaveResult res = (SaveResult) message;
            Duration duration = Duration.create(System.currentTimeMillis() - this.start, TimeUnit.MILLISECONDS);
            this.listener.tell(new SaveFinal(res.getResult(), duration), getSelf());
            getContext().stop(getSelf());
        } else {
            unhandled(message);
        }
    }
}
