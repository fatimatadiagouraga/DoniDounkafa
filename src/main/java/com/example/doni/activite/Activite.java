package com.example.doni.activite;

import com.example.doni.produit.Produit;
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
public class Activite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    TypeActivite typeActivite;
    private String description;
    @OneToMany(mappedBy = "activite")
    private List<Produit> produits;
}
