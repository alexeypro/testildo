package com.alexeypro.samples.testildo.actors.messages;

// Worker -> Master
// sent from Worker actors to Master actor; contains result from worker execution
public class SaveResult {
    private final String result;

    public SaveResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return this.result;
    }
}
