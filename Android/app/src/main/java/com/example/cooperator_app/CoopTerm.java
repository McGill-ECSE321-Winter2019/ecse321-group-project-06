package com.example.cooperator_app;

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
        String yearMonthDateOnly ="";
        yearMonthDateOnly=this.endDate.substring(0,10);
        return yearMonthDateOnly;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        String yearMonthDateOnly ="";
        yearMonthDateOnly=this.startDate.substring(0,10);
        return yearMonthDateOnly;
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
