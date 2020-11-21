package com.example.repositories;

import com.example.models.Reason;

import java.util.List;

public interface ReasonRepo {

    public List<Reason> getAllReason();
    public String createReason(Reason reason);
    public Reason getReason(Integer id);
    public String updateReason(Reason reason);
    public String deleteReason(Reason reason);
}
