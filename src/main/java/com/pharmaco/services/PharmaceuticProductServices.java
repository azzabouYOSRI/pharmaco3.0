package com.pharmaco.services;

import com.pharmaco.entities.FactureAchat;
import com.pharmaco.entities.Fournisseur;
import com.pharmaco.entities.PharmaceuticProduct;
import com.pharmaco.entities.Utilisateur;
import com.pharmaco.repository.FactureAchatRepository;
import com.pharmaco.repository.PharmaceuticProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PharmaceuticProductServices {

    private final PharmaceuticProductRepository pharmaceuticProductRepository;
    private final FactureAchatRepository factureAchatRepository;

    @Autowired
    public PharmaceuticProductServices(PharmaceuticProductRepository pharmaceuticProductRepository, FactureAchatRepository factureAchatRepository) {
        this.pharmaceuticProductRepository = pharmaceuticProductRepository;
        this.factureAchatRepository = factureAchatRepository;
    }

    @Transactional
    public void deleteProduit(Long id) {
        pharmaceuticProductRepository.deleteById(id);
    }

    @Transactional
    public void saveProduit(PharmaceuticProduct pharmaceuticProduct) {
        pharmaceuticProductRepository.save(pharmaceuticProduct);
    }

    @Transactional
    public PharmaceuticProduct findProduitById(Long id) {

        Optional<PharmaceuticProduct> optionalPharmaceuticProduct = pharmaceuticProductRepository.findById(id);
        return optionalPharmaceuticProduct.orElseGet(PharmaceuticProduct::new);
    }

    @Transactional
    public List<PharmaceuticProduct> findProduitByNomProd(String nomProd) {
        return pharmaceuticProductRepository.findByLibPrd(nomProd);
    }

    @Transactional
    public List<PharmaceuticProduct> findfindByDateAjoutPrd(@DateTimeFormat(pattern="yyyy-MM-dd")  Date dateAjoutPrd) {
        return pharmaceuticProductRepository.findByDateAjoutPrd(dateAjoutPrd);
    }

    @Transactional
    public List<PharmaceuticProduct> findProduitByPrixPrd(double prixPrd) {
        return pharmaceuticProductRepository.findByPrixPrd(prixPrd);
    }

    @Transactional
    public List<PharmaceuticProduct> findProduitByDescriptionPrd(String descriptionPrd) {
        return pharmaceuticProductRepository.findByDescriptionPrd(descriptionPrd);
    }

    @Transactional
    public List<PharmaceuticProduct> findProduitByPrixLivraison(double prixLivraison) {
        return pharmaceuticProductRepository.findByPrixLivraison(prixLivraison);
    }

    @Transactional
    public List<PharmaceuticProduct> findProduitByCommande(Long idCommande) {
        return pharmaceuticProductRepository.findProduitByCommande(idCommande);
    }

    @Transactional
    public List<PharmaceuticProduct> findProduitByFamille(Long idFamille) {
        return pharmaceuticProductRepository.findProduitByFamille(idFamille);
    }

    @Transactional
    public List<PharmaceuticProduct> findProduitByLabo(Long idLabo) {
        return pharmaceuticProductRepository.findProduitByLaboratoire(idLabo);
    }

    @Transactional
    public List<PharmaceuticProduct> findAllProduit() {
        return pharmaceuticProductRepository.findAll();
    }

    @Transactional
    public List<List<Utilisateur>> finduserbyproduct(Long id){

        return         pharmaceuticProductRepository
                .findAll()
                .stream()
                .filter(x-> Objects.equals(x.getIdPrd(), id))
                .map(PharmaceuticProduct::getUtilisateurList)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<List<FactureAchat>> findfacturebyprd(Long id){

        return         pharmaceuticProductRepository
                .findAll()
                .stream()
                .filter(x-> Objects.equals(x.getIdPrd(), id))
                .map(PharmaceuticProduct::getFactureAchatList)
                .collect(Collectors.toList());
    }


}
