package com.example.doni.campagne.service;

import com.example.doni.campagne.Campagne;
import com.example.doni.campagne.repository.CampagneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampagneServiceImpl implements CampagneService {
    @Autowired
    CampagneRepository campagneRepository;

    @Override
    public List<Campagne> AllCampagne() {
        return campagneRepository.findAll();
    }

    @Override
    public Campagne AddCampagne(Campagne campagne) {
        return campagneRepository.save(campagne);
    }

    @Override
    public Campagne UpdateCampagne(Campagne campagne, Long id) {
        Campagne existant = campagneRepository.findById(id).get();
        existant.setAnnee(campagne.getAnnee());
        existant.setDescription(campagne.getDescription());

        return campagneRepository.save(existant);
    }

    @Override
    public Campagne CampagneById(Long id) {
        return campagneRepository.findById(id).get();
    }

    @Override
    public void DeleteCampagne(Long id) {
     campagneRepository.deleteById(id);
    }
}
