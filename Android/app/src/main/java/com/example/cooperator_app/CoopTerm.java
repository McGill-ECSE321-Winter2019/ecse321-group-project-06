package com.example.cooperator_app;
import java.util.Date;

public class CoopTerm {
    private String endDate;
    private String startDate;
    private String state;

    public CoopTerm(String startDate, String endDate, String state){
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setState(state);
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
