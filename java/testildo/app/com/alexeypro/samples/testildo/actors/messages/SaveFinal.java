package com.alexeypro.samples.testildo.actors.messages;

import akka.util.Duration;

// Master -> Listener
// sent from Master actor to Listener actor; contains result and how long did the work take
public class SaveFinal {
    private final String result;
    private final Duration duration;

    public SaveFinal(String result, Duration duration) {
        this.result = result;
        this.duration = duration;
    }

    public String getResult() {
        return this.result;
    }

    public Duration getDuration() {
        return this.duration;
    }
}
