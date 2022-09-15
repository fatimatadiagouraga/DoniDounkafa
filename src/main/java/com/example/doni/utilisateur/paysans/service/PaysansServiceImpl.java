package com.example.doni.utilisateur.paysans.service;

import com.example.doni.exception.ErrorCode;
import com.example.doni.exception.InvalidEntityException;
import com.example.doni.utilisateur.paysans.Paysans;
import com.example.doni.utilisateur.paysans.repository.PaysansRepository;
import com.example.doni.validators.PaysansValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaysansServiceImpl implements PaysansService{
    @Autowired
    PaysansRepository paysansRepository;
    @Override
    public List<Paysans> AllPaysans() {
        return paysansRepository.findAll();
    }

    @Override
    public Paysans AddPaysans(Paysans paysans) {
        List<String> errors = PaysansValidator.validate(paysans);
        if (!errors.isEmpty()){
            throw new InvalidEntityException("Veillez remplir tous les champs!", ErrorCode.PAYSANS_NOT_VALID, errors);
        }


        List<Paysans> apprenantLogin = paysansRepository.findPaysansByLogin(paysans.getLogin());
        if (!apprenantLogin.isEmpty()){
            throw new InvalidEntityException("Un autre paysans existe avec ce login", ErrorCode.PAYSANS_ALREADY_EXISTE, errors);
        }

        List<Paysans> apprenantTelephone = paysansRepository.findPaysansByTelephone(paysans.getTelephone());
        if (!apprenantTelephone.isEmpty()){
            throw new InvalidEntityException("Un autre paysans existe avec ce numéro de téléphone", ErrorCode.PAYSANS_ALREADY_EXISTE, errors);
        }
        return paysansRepository.save(paysans);
    }

    @Override
    public Paysans UpdatePaysans(Paysans paysans, Long id) {
        Paysans existant = paysansRepository.findById(id).get();
        existant.setNom(paysans.getNom());
        existant.setPrenom(paysans.getPrenom());
        existant.setDateNaissance(paysans.getDateNaissance());
        existant.setSexe(paysans.getSexe());
        existant.setStatut(paysans.getStatut());
        existant.setNbrPersonneCharge(paysans.getNbrPersonneCharge());

        existant.setLogin(paysans.getLogin());
        existant.setPassword(paysans.getPassword());
        return paysansRepository.save(existant);
    }

    @Override
    public Paysans PaysansById(Long id) {
        return paysansRepository.findById(id).get();
    }

    @Override
    public void DeletePaysans(Long id) {
       paysansRepository.deleteById(id);
    }

    @Override
    public Paysans authentification(String login, String password) {
        Optional<Paysans> connexion = paysansRepository.findApprenantByLoginAndPassword(login, password);

        if(connexion.isEmpty()){
            return null;
            //throw new InvalidEntityException("Login ou mot de passe incorrect", ErrorCode.APPRENANT_AUTHENTIFICATION_INVALID);
        }
        /*if(connexion.get().getEtat() == Etat.Desactiver || connexion.get().isSupprimer()){
            throw new InvalidEntityException("Votre compte a été supprimé", ErrorCode.APPRENANT_DESACTIVE_ACCOUNT);
        }
         */
        return connexion.get();
    }
}
