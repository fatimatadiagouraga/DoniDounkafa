package com.example.doni.utilisateur.paysans.service;

import com.example.doni.utilisateur.paysans.Paysans;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PaysansService {
    List<Paysans> AllPaysans();
    Paysans AddPaysans(Paysans paysans);
    Paysans UpdatePaysans(Paysans paysans, Long id);
    Paysans PaysansById(Long id);
    void DeletePaysans(Long id);
    Paysans authentification(String login, String password);
}
