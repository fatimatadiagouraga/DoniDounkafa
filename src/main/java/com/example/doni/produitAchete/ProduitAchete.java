package com.example.doni.produitAchete;

import com.example.doni.panier.Panier;
import com.example.doni.produit.Produit;
import com.example.doni.utilisateur.paysans.Paysans;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProduitAchete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate Date =LocalDate.now();
    private Long quantiteAchetee;
    private boolean achete = false;
    @ManyToOne
    private Panier panier;
}
