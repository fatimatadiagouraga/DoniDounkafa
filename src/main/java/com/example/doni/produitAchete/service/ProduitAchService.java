package com.example.doni.produitAchete.service;

import com.example.doni.categorie.Categorie;
import com.example.doni.produitAchete.ProduitAchete;

import java.util.List;

public interface ProduitAchService {
    List<ProduitAchete> AllProduitAchete();
    ProduitAchete AddProduitAchete(ProduitAchete produitAchete);
    ProduitAchete UpdateProduitAchete(ProduitAchete produitAchete,Long id);
    ProduitAchete ProduitAcheteById (Long id);
    void DeleteProduitAchete(Long id);
    String AddProduitAcheterList(List<ProduitAchete> produitAchetes);

}
