package com.example.doni.produit;

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
    private String nomProd;
    private String description;
    private long prix;
    private String photo;
    private Long quantite;
    @ManyToOne
    private Categorie categorie;
     @JsonIgnore
    @OneToMany(mappedBy = "produit")
    private List<Panier> paniers;

}
