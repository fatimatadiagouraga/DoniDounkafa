package com.example.doni.produit.service;

import com.example.doni.produit.Produit;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface ProduitService {
    List<Produit> AllProduit();
    Produit Addproduit(Produit produit, MultipartFile file) throws IOException;
    Produit UpdateProduit(Produit produit,Long id);
    Produit ProduitById(Long id);
    void DeleteProduit(Long id);
    byte[] getPhoto(Long id) throws IOException;
}
