package com.example.doni.produit.repository;

import com.example.doni.produit.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
}
