package com.example.doni.reserver.service;

import com.example.doni.reserver.Reserver;
import com.example.doni.reserver.repository.ReserverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReserverServiceImpl implements ReserverService{
    @Autowired
    ReserverRepository reserverRepository;

    @Override
    public List<Reserver> AllReserver() {
        return reserverRepository.findAll();
    }

    @Override
    public Reserver AddReserver(Reserver reserver) {
        return reserverRepository.save(reserver);
    }

    @Override
    public Reserver UpdateReserver(Reserver reserver, Long id) {
        Reserver existant = reserverRepository.findById(id).get();
        return reserverRepository.save(existant);
    }

    @Override
    public Reserver ReserverById(Long id) {
        return reserverRepository.findById(id).get();
    }

    @Override
    public void DeleteReserver(Long id) {
        reserverRepository.deleteById(id);
    }
}
