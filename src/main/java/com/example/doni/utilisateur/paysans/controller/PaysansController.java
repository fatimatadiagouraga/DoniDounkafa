package com.example.doni.utilisateur.paysans.controller;

import com.example.doni.utilisateur.paysans.Paysans;
import com.example.doni.utilisateur.paysans.service.PaysansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api/")
public class PaysansController {
    @Autowired
    PaysansService paysansService;

    @GetMapping("AllPaysans")
    public List<Paysans> AllPaysans(){
        return paysansService.AllPaysans();
    }
    @PostMapping("AddPaysans")
    public Paysans AddPaysans(@RequestBody Paysans paysans){
        return paysansService.AddPaysans(paysans);
    }
    @GetMapping("PaysansById/{id}")
    public Paysans PaysansById(@PathVariable("id") Long id){
        return paysansService.PaysansById(id);
    }
    @PutMapping("UpdatePaysans/{id}")
    public Paysans UpdatePaysans(@RequestBody Paysans paysans,@PathVariable("id") Long id){
        return paysansService.UpdatePaysans(paysans,id);
    }
    @DeleteMapping("DeletePaysans/{id}")
    public void DeletePaysans(@PathVariable("id") Long id){
        paysansService.DeletePaysans(id);
    }
    @GetMapping("login/{login}&{password}")
    Paysans connexion(@PathVariable("login") String login, @PathVariable("password") String password){
        return paysansService.authentification(login, password);
    }
}
