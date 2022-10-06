package com.example.doni.commande.repository;

import com.example.doni.commande.Commande;
import com.example.doni.panier.Panier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande,Long> {
    @Query(value = "SELECT id FROM Commande id WHERE id.panier.paysans.id= :id")
    List<Commande> findCommandeByPaysans(@Param("id") Long id);

    @Query(value = "SELECT id FROM Commande id WHERE id.etatCommande =:cours and id.etatCommande =:annuler")
    List<Commande> findCommandeByEtatCommande();

}
