package com.example.doni.commande;

import com.example.doni.panier.Panier;
import com.example.doni.reserver.Reserver;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private EtatCommande etatCommande=EtatCommande.cours;
    private LocalDate date = LocalDate.now();
    @ManyToOne
    private Panier panier;
    @JsonIgnore
    @OneToMany(mappedBy = "commande")
    private List<Reserver> reservers;
}
