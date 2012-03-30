package com.alexeypro.samples.testildo.actors.messages;

// -> Master
// sent to Master actor to initiate (start) the execution
public class SaveRun {
    private final int count;

    public SaveRun(int count) {
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }
}
