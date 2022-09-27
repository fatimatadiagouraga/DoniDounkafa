package com.example.doni.produit.repository;

import com.example.doni.produit.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProduitRepository extends JpaRepository<Produit,Long> {

}
