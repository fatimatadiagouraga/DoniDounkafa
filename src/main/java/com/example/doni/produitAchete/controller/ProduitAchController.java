package com.example.doni.produitAchete.controller;

import com.example.doni.categorie.Categorie;
import com.example.doni.produitAchete.ProduitAchete;
import com.example.doni.produitAchete.service.ProduitAchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class ProduitAchController {
    @Autowired
    ProduitAchService produitAchService;




    @GetMapping("AllProduitAchete")
    public List<ProduitAchete> AllProduitAchete(){
        return produitAchService.AllProduitAchete();
    }
    @GetMapping("ProduitAcheteById/{id}")
    public ProduitAchete ProduitAcheteById(@PathVariable("id") Long id){
        return  produitAchService.ProduitAcheteById(id);
    }
    @PutMapping("UpdateProduitAchete/{id}")
    public ProduitAchete UpdateProduitAchete(@RequestBody ProduitAchete produitAchete,@PathVariable("id") Long id){

        return produitAchService.UpdateProduitAchete(produitAchete,id);
    }
    @PostMapping("AddProduitAchete")
    public ProduitAchete AddProduitAchete(@RequestBody ProduitAchete produitAchete){
        return produitAchService.AddProduitAchete(produitAchete);
    }
    @PostMapping("AddAllProduitAchete")
    public String AddAllProduitAchete(@RequestBody List<ProduitAchete> listProduitAchete){
        return produitAchService.AddProduitAcheterList(listProduitAchete);
    }
    @DeleteMapping("DeleteProduitAchete/{id}")
    public void DeleteProduitAchete(Long id){
        produitAchService.DeleteProduitAchete(id);
    }

}
