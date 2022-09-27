package com.example.doni.validators;

import com.example.doni.panier.Panier;
import com.example.doni.utilisateur.paysans.Paysans;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class PanierValidator {
    public static List<String> validate(Panier panier){
        List<String> errors = new ArrayList<>();

        //Si tous les champs sont null
        if (panier == null){
            errors.add("Veillez choisir unité");
            errors.add("Veillez saisir une quantité");

            return errors;
        }


        return errors;
    }
}
