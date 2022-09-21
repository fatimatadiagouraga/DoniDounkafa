package com.example.doni.prestataire.controller;

import com.example.doni.categorie.Categorie;
import com.example.doni.prestataire.Prestataire;
import com.example.doni.prestataire.repository.PrestataireRepository;
import com.example.doni.prestataire.service.PrestataireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class PrestataireController {
    @Autowired
    PrestataireService prestataireService;

    @GetMapping("AllPrestataire")
    public List<Prestataire> AllPrestataire(){
        return prestataireService.AllPrestataire();
    }
    @GetMapping("PrestataireById/{id}")
    public Prestataire PrestataireById(@PathVariable("id") Long id){
        return  prestataireService.PrestataireById(id);
    }
    @PutMapping("UpdatePrestataire/{id}")
    public Prestataire UpdatePrestataire(@RequestBody Prestataire prestataire,@PathVariable("id") Long id){
        return prestataireService.UpdatePrestataire(prestataire,id);
    }
    @PostMapping("AddPrestataire")
    public Prestataire AddPrestataire(@RequestBody Prestataire prestataire){
        return prestataireService.AddPrestataire(prestataire);
    }
    @DeleteMapping("DeletePrestataire/{id}")
    public void DeletePrestataire(Long id){
        prestataireService.DeletePrestataire(id);
    }
}
