package com.alexeypro.samples.testildo.actors.messages;

// -> Master
// sent to Master actor to initiate (start) the execution
public class SaveRun {
    private final int index;

    public SaveRun(int index) {
        this.index = index; // passing it here just to make it as a starting point
    }

    public int getIndex() {
        return this.index;
    }
}
