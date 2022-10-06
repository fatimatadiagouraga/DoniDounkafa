package com.example.doni.panier.repository;

import com.example.doni.panier.Panier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PanierRepository extends JpaRepository<Panier,Long> {
    @Query(value = "SELECT id FROM Panier id WHERE id.etat=false and id.paysans.id = :id")
    List<Panier> findPanierByPaysans(@Param("id") Long id);
}
