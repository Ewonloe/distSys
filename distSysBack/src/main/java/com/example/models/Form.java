package com.example.models;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Form {

    private BigDecimal id;
    private String run;
    private String first_name;
    private String last_name;
    private String last_name2;
    private BigDecimal reason_id;
    private String email;
    private Timestamp emitted_at;
    private Timestamp expired_at;



    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getLast_name2() {
        return last_name2;
    }

    public void setLast_name2(String last_name2) {
        this.last_name2 = last_name2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getReason_id() {
        return reason_id;
    }

    public void setReason_id(BigDecimal reason_id) {
        this.reason_id = reason_id;
    }

    public Timestamp getEmitted_at() {
        return emitted_at;
    }

    public void setEmitted_at(Timestamp emitted_at) {
        this.emitted_at = emitted_at;
    }

    public Timestamp getExpired_at() {
        return expired_at;
    }

    public void setExpired_at(Timestamp expired_at) {
        this.expired_at = expired_at;
    }

}
