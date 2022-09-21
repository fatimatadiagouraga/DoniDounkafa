package com.example.doni.cooperative.service;

import com.example.doni.cooperative.Cooperative;
import com.example.doni.cooperative.repository.CooperativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CooperativeServiceImpl implements CooperativeService{
    @Autowired
    CooperativeRepository cooperativeRepository;
    @Override
    public List<Cooperative> AllCooperative() {
        return cooperativeRepository.findAll();
    }

    @Override
    public Cooperative AddCooperative(Cooperative cooperative) {
        return cooperativeRepository.save(cooperative);
    }


    @Override
    public Cooperative UpdateCooperative(Cooperative cooperative, Long id) {
        Cooperative existant =cooperativeRepository.findById(id).get();
        existant.setAdresse(cooperative.getAdresse());
        existant.setDescription(cooperative.getDescription());
        existant.setTelephone(cooperative.getTelephone());
        existant.setNomCoperative(cooperative.getNomCoperative());
        return cooperativeRepository.save(existant);
    }

    @Override
    public Cooperative CooprativeById(Long id) {
        return cooperativeRepository.findById(id).get();
    }

    @Override
    public void DeleteCooperative(Long id) {
     cooperativeRepository.deleteById(id);
    }
}
