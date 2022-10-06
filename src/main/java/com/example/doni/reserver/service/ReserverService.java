package com.example.doni.reserver.service;

import com.example.doni.activite.Activite;
import com.example.doni.reserver.Reserver;

import java.util.List;

public interface ReserverService {
    List<Reserver> AllReserver();
    Reserver AddReserver(Reserver reserver);
    Reserver UpdateReserver(Reserver reserver,Long id);
    Reserver ReserverById (Long id);
    void DeleteReserver(Long id);
}
