package com.example.doni.categorie.controller;

import com.example.doni.categorie.Categorie;
import com.example.doni.categorie.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class CategorieController {
    @Autowired
    CategorieService categorieService;

    @GetMapping("AllCategorie")
    public List<Categorie> AllCategorie(){
        return categorieService.AllCategorie();
    }
    @GetMapping("CategorieById/{id}")
    public Categorie CategorieById(@PathVariable("id") Long id){
        return  categorieService.CategorieById(id);
    }
    @PutMapping("UpdateCategorie/{id}")
    public Categorie UpdateCategorie(@RequestBody Categorie categorie,@PathVariable("id") Long id){
        return categorieService.UpdateCategorie(categorie,id);
    }
    @PostMapping("AddCategorie")
    public Categorie AddCategorie(@RequestBody Categorie categorie){
        return categorieService.AddCategorie(categorie);
    }
    @DeleteMapping("DeleteCategorie/{id}")
    public void DeleteCategorie(Long id){
        categorieService.DeleteCategorie(id);
    }
}
