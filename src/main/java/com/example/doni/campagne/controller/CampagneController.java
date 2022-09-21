package com.example.doni.campagne.controller;

import com.example.doni.campagne.Campagne;
import com.example.doni.campagne.service.CampagneService;
import com.example.doni.categorie.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class CampagneController {
    @Autowired
    CampagneService campagneService;
    @GetMapping("AllCampagne")
    public List<Campagne> AllCampagne(){
        return campagneService.AllCampagne();
    }
    @GetMapping("CampagneById/{id}")
    public Campagne CampagneById(@PathVariable("id") Long id){
        return  campagneService.CampagneById(id);
    }
    @PutMapping("UpdateCampagne/{id}")
    public Campagne UpdateCampagne(@RequestBody Campagne campagne,@PathVariable("id") Long id){
        return campagneService.UpdateCampagne(campagne,id);
    }
    @PostMapping("AddCampagne")
    public Campagne AddCampagne(@RequestBody Campagne campagne){
        return campagneService.AddCampagne(campagne);
    }
    @DeleteMapping("DeleteCampagne/{id}")
    public void DeleteCampagne(Long id){
        campagneService.DeleteCampagne(id);
    }
}
