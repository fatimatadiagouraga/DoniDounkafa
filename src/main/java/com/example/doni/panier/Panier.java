package com.example.doni.panier;

import com.example.doni.commande.Commande;
import com.example.doni.produit.Produit;
import com.example.doni.produit.Unite;
import com.example.doni.produitAchete.ProduitAchete;
import com.example.doni.utilisateur.paysans.Paysans;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Panier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Unite unite;
    private Long quantiteAchete;
    private Long montant;
    private boolean etat= false;
    @ManyToOne
    private Paysans paysans;
    @ManyToOne
    private Produit produit;
    @JsonIgnore
    @OneToMany(mappedBy = "panier")
    private List<Commande> commandes;
}
