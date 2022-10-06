package com.example.doni.produit;

import com.example.doni.activite.Activite;
import com.example.doni.categorie.Categorie;
import com.example.doni.panier.Panier;
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
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomProduit;
    private String description;
    private long prixKg;
    private long prixSac50Kg;
    private Long prixSac100kg;
    private String photo;
    private Long quantite;
    private boolean etat = true;
    @ManyToOne
    private Activite activite;
    @ManyToOne
    private Categorie categorie;
     @JsonIgnore
    @OneToMany(mappedBy = "produit")
    private List<Panier> paniers;

}
