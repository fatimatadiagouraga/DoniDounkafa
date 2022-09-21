package com.example.doni.activite.controller;

import com.example.doni.activite.Activite;
import com.example.doni.activite.service.ActiviteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class ActiviteController {
    @Autowired
    ActiviteService activiteService;

    @GetMapping("AllActivite")
    public List<Activite> AllActivite(){
        return activiteService.AllActivite();
    }
    @GetMapping("ActiviteById/{id}")
    public Activite ActiviteById(@PathVariable("id") Long id){
        return  activiteService.ActiviteById(id);
    }
    @PutMapping("UpdateActivite/{id}")
    public Activite UpdateActivite(@RequestBody Activite activite,@PathVariable("id") Long id){
        return activiteService.UpdateActivite(activite,id);
    }
    @PostMapping("AddActivite")
    public Activite AddActivite(@RequestBody Activite activite){
        return activiteService.AddActivite(activite);
    }
    @DeleteMapping("DeleteActivite/{id}")
    public void DeleteActivite(Long id){
        activiteService.DeleteActivite(id);
    }
}
