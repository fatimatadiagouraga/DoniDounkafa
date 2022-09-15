package com.example.doni.utilisateur.paysans;

import com.example.doni.utilisateur.Sexe;
import com.example.doni.utilisateur.Statut;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

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
    private Sexe sexe;
    private Statut statut;
    private LocalDate date = LocalDate.now();
    private String login;
    private String password;

    private Integer nbrPersonneCharge;



}
