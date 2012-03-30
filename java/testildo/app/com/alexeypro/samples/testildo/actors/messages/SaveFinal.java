package com.alexeypro.samples.testildo.actors.messages;

import akka.util.Duration;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

// Master -> Listener
// sent from Master actor to Listener actor; contains result and how long did the work take
public class SaveFinal {
    private final List<String> results;
    private final Duration duration;

    public SaveFinal(List<String> results, Duration duration) {
        this.results = results;
        this.duration = duration;
    }

    public List<String> getResults() {
        return Collections.unmodifiableList(this.results);
    }

    public Duration getDuration() {
        return this.duration;
    }
}
