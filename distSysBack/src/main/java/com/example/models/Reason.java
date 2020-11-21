package com.example.models;

import java.math.BigDecimal;
import java.sql.Time;

public class Reason {

    private BigDecimal id;
    private String description;
    private Time duration;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }
}
