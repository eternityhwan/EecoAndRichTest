package com.assignment.ecoandrichtest;

public class Study {

    private int limit;

    private StudyStatus status = StudyStatus.DRAFT;

    public Study(int limit) {
        this.limit = limit;
    }

    public StudyStatus getStatus() {
        return this.status;
    }

    public int getLimit() {
        return limit;
    }
}
