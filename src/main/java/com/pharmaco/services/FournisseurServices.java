package com.pharmaco.pharaco101.services;

import com.pharmaco.pharaco101.entities.Fournisseur;
import com.pharmaco.pharaco101.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FournisseurServices {

    private final FournisseurRepository fournisseurRepository;

    @Autowired
    public FournisseurServices(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }


    public void addNewFournisseur(Fournisseur fournisseur){
        fournisseurRepository.save(fournisseur);
    }

    public Fournisseur  findFournisseurById(Long id) {


        Optional<Fournisseur> optionalFournisseur = fournisseurRepository.findById(id);
        return optionalFournisseur.orElseGet(Fournisseur::new);
    }

    public Iterable<Fournisseur> findAllFournisseur(){
        return fournisseurRepository.findAll();
    }

    public void deleteFournisseur(Long id){
        fournisseurRepository.deleteById(id);
    }

    public List <Fournisseur> findFournisseurByNomFournisseur(String nomFour){
        return fournisseurRepository.findFournisseurByNomFournisseur(nomFour);
    }

    public List <Fournisseur> findFournisseurByAdresseFournisseur(String adresseFour){
        return fournisseurRepository.findFournisseurByAdresseFournisseur(adresseFour);
    }

    public List <Fournisseur> findFournisseurByEmailFournisseur(String emailFour){
        return fournisseurRepository.findFournisseurByEmailFournisseur(emailFour);
    }

    public List <Fournisseur> findFournisseurByTelFournisseur(int telFour){
        return fournisseurRepository.findFournisseurByTelFournisseur(telFour);
    }

    public List <Fournisseur> findFournisseurByUtilisateur(Long id){
        return fournisseurRepository.findEnseignantByUtilisateur(id);
    }
}
