package com.example.doni.utilisateur.paysans;

import com.example.doni.panier.Panier;
import com.example.doni.produit.Produit;
import com.example.doni.produitAchete.ProduitAchete;
import com.example.doni.utilisateur.Sexe;
import com.example.doni.utilisateur.Statut;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Paysans{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private Date DateNaissance;
    private Long telephone;
    @Enumerated(value = EnumType.STRING)
    private Sexe sexe;
    @Enumerated(value = EnumType.STRING)
    private Statut statut;
    private LocalDate date = LocalDate.now();
    private String login;
    private String password;

    private Integer nbrPersonneCharge;

    @JsonIgnore
    @OneToMany(mappedBy = "paysans")
    private  List<Panier> paniers ;

}
