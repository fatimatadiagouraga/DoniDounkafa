package com.example.doni.validators;

import com.example.doni.utilisateur.paysans.Paysans;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class PaysansValidator {
    public static List<String> validate(Paysans paysans){
        List<String> errors = new ArrayList<>();

        //Si tous les champs sont null
        if (paysans == null){
            errors.add("Veillez saisir un nom");
            errors.add("Veillez saisir un prenom");
            errors.add("Veillez saisir une adresse email");
            errors.add("Veillez saisir un login");
            errors.add("Veillez saisir un mot de passe");
            return errors;
        }

        //Pour les champs obligatoirs
        if (!StringUtils.hasLength(paysans.getNom())){
            errors.add("Veillez saisir un nom");
        }
        if (!StringUtils.hasLength(paysans.getPrenom())){
            errors.add("Veillez saisir un prenom");
        }

        if (!StringUtils.hasLength(paysans.getLogin())){
            errors.add("Veillez saisir un login");
        }
        if (!StringUtils.hasLength(paysans.getPassword())){
            errors.add("Veillez saisir un mot de passe");
        }
        return errors;
    }
}
