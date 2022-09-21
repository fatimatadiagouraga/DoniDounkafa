package com.example.doni.produit.controller;

import com.example.doni.produit.Produit;
import com.example.doni.produit.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class ProduitController {
    @Autowired
    ProduitService produitService;

    @GetMapping("AllPraduit")
    public List<Produit> AllProduit(){
        return produitService.AllProduit();
    }
    @GetMapping("ProduitById/{id}")
    public Produit ProduitById(@PathVariable("id") Long id){
        return produitService.ProduitById(id);
    }
    @PostMapping("addProduit")
    Produit addMatiere(Produit produit, @RequestParam("file") MultipartFile file) throws IOException {
        return produitService.Addproduit(produit, file);
    }
    @PutMapping("UpdateProduit/{id}")
    public Produit UpdateProduit(@RequestBody Produit produit,@PathVariable("id") Long id ){
        return produitService.UpdateProduit(produit,id);
    }
    @GetMapping(value = "findProduitPhoto/{id}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    byte[] findPhoto(@PathVariable("id") Long id) throws IOException {
        return produitService.getPhoto(id);
    }
    @DeleteMapping("DeleteProduit/{id}")
    public void DeleteProduit(@PathVariable("id") Long id ){
        produitService.DeleteProduit(id);
    }

}
