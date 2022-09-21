package com.example.doni.cooperative.service;

import com.example.doni.cooperative.Cooperative;

import java.util.List;

public interface CooperativeService {
    List<Cooperative> AllCooperative();
    Cooperative AddCooperative(Cooperative cooperative);
    Cooperative UpdateCooperative(Cooperative cooperative, Long id);
    Cooperative CooprativeById(Long id);
    void DeleteCooperative(Long id );
}
