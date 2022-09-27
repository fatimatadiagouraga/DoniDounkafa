package com.example.doni.produit.service;

import com.example.doni.produit.Produit;
import com.example.doni.produit.repository.ProduitRepository;
import com.example.doni.uploadFile.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
@Service
public class ProduitServiceImpl implements ProduitService {
    @Autowired
    ProduitRepository produitRepository;
    @Override
    public List<Produit> AllProduit() {
        return produitRepository.findAll();
    }

    @Override
    public Produit Addproduit(Produit produit, MultipartFile file) throws IOException {
        produit.setPrixSac50Kg(produit.getPrixKg()*50);
        produit.setPrixSac100kg(produit.getPrixKg()*100);
        String fileNamne = StringUtils.cleanPath(file.getOriginalFilename());
        produit.setPhoto(fileNamne);
        Produit mat = produitRepository.save(produit);
        String uploadDir = "src/main/resources/files/"+produit.getId();
        UploadFile.saveFile(uploadDir, fileNamne, file);
        return mat;
    }


    @Override
    public Produit UpdateProduit(Produit produit, Long id) {
        Produit existant = produitRepository.findById(id).get();
        existant.setNomProduit(produit.getNomProduit());
        existant.setDescription(produit.getDescription());
        existant.setPrixKg(produit.getPrixKg());
        existant.setPrixSac50Kg(produit.getPrixKg()*50);
        existant.setPrixSac100kg(produit.getPrixSac100kg());
        existant.setPhoto(produit.getPhoto());
        existant.setQuantite(produit.getQuantite());
        return produitRepository.save(existant);
    }

    @Override
    public Produit ProduitById(Long id) {
        return produitRepository.findById(id).get();
    }

    @Override
    public void DeleteProduit(Long id) {
        produitRepository.deleteById(id);
    }

    @Override
    public byte[] getPhoto(Long id) throws IOException {
        Produit produit = produitRepository.getById(id);
        String icoPhoto = produit.getPhoto();
        File file = new File("src/main/resources/files/" + produit.getId()+"/"+icoPhoto);
        Path path = Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }


}
