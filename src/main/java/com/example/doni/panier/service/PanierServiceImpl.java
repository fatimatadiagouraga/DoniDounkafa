package com.example.doni.panier.service;

import com.example.doni.exception.ErrorCode;
import com.example.doni.exception.InvalidEntityException;
import com.example.doni.panier.Panier;
import com.example.doni.panier.repository.PanierRepository;
import com.example.doni.produit.NomProduit;
import com.example.doni.produit.Produit;
import com.example.doni.produit.Unite;
import com.example.doni.produit.repository.ProduitRepository;
import com.example.doni.validators.PanierValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PanierServiceImpl implements PanierService{

    @Autowired
    PanierRepository panierRepository;

    @Autowired
    ProduitRepository produitRepository;

    @Override
    public List<Panier> AllPanier() {
        return panierRepository.findAll();
    }

    @Override
    public Panier AddPanier(Panier panier, Long id) {
        Produit existant = produitRepository.findById(id).get();
        List<String> errors = PanierValidator.validate(panier);
        if (!errors.isEmpty()){
            throw new InvalidEntityException("Veillez remplir tous les champs!", ErrorCode.PAYSANS_NOT_VALID, errors);
        }

        if(panier.getUnite() == Unite.Kg) {
            if(existant.getQuantite()> panier.getQuantiteAchete()) {
                existant.setQuantite(existant.getQuantite() - panier.getQuantiteAchete());
                panier.setMontant(existant.getPrixKg() * panier.getQuantiteAchete());
            }else{
                throw new InvalidEntityException("La Quantite est superieur au quantité Stocker");
            }

        }
        if(panier.getUnite() == Unite.Sac50Kg) {
            Long qua = panier.getQuantiteAchete() *50;
            if(existant.getQuantite()> qua) {
                existant.setQuantite(existant.getQuantite() - panier.getQuantiteAchete());
                panier.setMontant(panier.getQuantiteAchete()*existant.getPrixSac50Kg());
            }else{
                throw new InvalidEntityException("La Quantite est superieur au quantité Stocker");
            }

        }
        if(panier.getUnite() == Unite.Sac100Kg) {
            Long qua = panier.getQuantiteAchete() *100;
            if(existant.getQuantite()> qua) {
                existant.setQuantite(existant.getQuantite() - panier.getQuantiteAchete());
                panier.setMontant(panier.getQuantiteAchete()*existant.getPrixSac100kg());
            }else{
                throw new InvalidEntityException("La Quantite est superieur au quantité Stocker");
            }

        }

        return panierRepository.save(panier);
    }



    @Override
    public Panier UpdatePanier(Panier panier, Long id) {
        Panier existant = panierRepository.findById(id).get();
        existant.setPaysans(panier.getPaysans());
        existant.setProduit(panier.getProduit());
        return panierRepository.save(existant);
    }

    @Override
    public List<Panier> findPanierByPaysans(Long id) {

        return panierRepository.findPanierByPaysans(id);
    }

    @Override
    public Panier PanierById(Long id) {
        return panierRepository.findById(id).get();
    }

    @Override
    public void DeletePanier(Long id) {
        panierRepository.deleteById(id);
    }
}
