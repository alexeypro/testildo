package com.alexeypro.samples.testildo.actors.messages;

import com.alexeypro.samples.testildo.services.ITestJavaRecords;

// Master -> Worker
// sent from Master actor to Worker actor; contains the work assignment
public class SaveWork {
    private final ITestJavaRecords service;
    private final int index;

    public SaveWork(ITestJavaRecords service, int index) {
        this.service = service;
        this.index = index;
    }

    public ITestJavaRecords getService() {
        return this.service;
    }

    public int getIndex() {
        return this.index;
    }
}
