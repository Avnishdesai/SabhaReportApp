package com.sabha.report.Models;

import java.util.Date;

public class NewAttendee {

    private String mandal;
    private String center;
    private Long person;
    private Date sabhaDate;

    public String getMandal(){
        return mandal;
    }

    public void setMandal(String mandal){
        this.mandal = mandal;
    }

    public String getCenter(){
        return center;
    }

    public void setCenter(String center){
        this.center = center;
    }

    public Long getPerson(){
        return person;
    }

    public void setPerson(Long person){
        this.person = person;
    }

    public Date getSabhaDate(){
        return sabhaDate;
    }

    public void setSabhaDate(Date sabhaDate){
        this.sabhaDate = sabhaDate;
    }
}
