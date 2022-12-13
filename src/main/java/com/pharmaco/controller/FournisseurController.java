package com.pharmaco.controller;

import com.pharmaco.dto.FournisseurDTO;
import com.pharmaco.entities.Fournisseur;
import com.pharmaco.services.FournisseurServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Fournisseur")
public class FournisseurController {

    private final FournisseurServices fournisseurServices;
    @Autowired
    public FournisseurController(FournisseurServices fournisseurServices) {
        this.fournisseurServices = fournisseurServices;
    }

    @PostMapping(value = "/addFournisseur", consumes = "application/json")
    public Fournisseur addFournisseur(@Validated @RequestBody FournisseurDTO fournisseur) {
        Fournisseur persistantFournisseur = new Fournisseur();
        persistantFournisseur.setNomFournisseur(fournisseur.getNomFournisseur());
        persistantFournisseur.setAdresseFournisseur(fournisseur.getAdresseFournisseur());
        persistantFournisseur.setTelFournisseur(fournisseur.getTelFournisseur());
        persistantFournisseur.setEmailFournisseur(fournisseur.getEmailFournisseur());
        persistantFournisseur.setUtilisateur(fournisseur.getUtilisateur());

        fournisseurServices.addNewFournisseur(persistantFournisseur);
        return  persistantFournisseur;
    }

    @GetMapping("/getFournisseur/{id}")
    public Fournisseur getFournisseur(@PathVariable Long id) {
        return fournisseurServices.findFournisseurById(id);
    }

    @DeleteMapping("/deleteFournisseur/{id}")
    public String deleteFournisseur(@PathVariable Long id) {
        fournisseurServices.deleteFournisseur(id);
        return "Fournisseur deleted";
    }

    @GetMapping("/getFournisseurByNom/{nom}")
    public List<Fournisseur> getFournisseurByNom(@PathVariable String nom) {
        return fournisseurServices.findFournisseurByNomFournisseur(nom);
    }



    @GetMapping("/getFournisseurByAdresse/{adresse}")
    public List<Fournisseur> getFournisseurByAdresse(@PathVariable String adresse) {
        return fournisseurServices.findFournisseurByAdresseFournisseur(adresse);
    }

    @GetMapping("/getFournisseurByTelephone/{telephone}")
    public List<Fournisseur> getFournisseurByTelephone(@PathVariable int telephone ) {
        return fournisseurServices.findFournisseurByTelFournisseur(telephone);
    }

    @GetMapping("/getFournisseurByEmail/{email}")
    public List<Fournisseur> getFournisseurByEmail(@PathVariable String email) {
        return fournisseurServices.findFournisseurByEmailFournisseur(email);
    }

    @GetMapping("/getFournisseurByUtilisateur/{idUtilisateur}")
    public List<Fournisseur> getFournisseurByUtilisateur(@PathVariable Long idUtilisateur) {
        return fournisseurServices.findFournisseurByUtilisateur(idUtilisateur);
    }

    @PutMapping("/updateFournisseur/{id}/nom")
    public Fournisseur updateFournisseurNom(@PathVariable Long id, @RequestBody FournisseurDTO fournisseur) {

    Fournisseur fournisseurExist = fournisseurServices.findFournisseurById(id);
    fournisseurExist.setNomFournisseur(fournisseur.getNomFournisseur());
    fournisseurServices.addNewFournisseur(fournisseurExist);
    return fournisseurExist;
    }
    @PutMapping("/updateFournisseur/{id}/telephone")
    public Fournisseur updateFournisseurTelephone(@PathVariable Long id, @RequestBody FournisseurDTO fournisseur) {

        Fournisseur fournisseurExist = fournisseurServices.findFournisseurById(id);
        fournisseurExist.setTelFournisseur(fournisseur.getTelFournisseur());
        fournisseurServices.addNewFournisseur(fournisseurExist);
        return fournisseurExist;
    }

    @PutMapping("/updateFournisseur/{id}/adresse")
    public Fournisseur updateFournisseurAdresse(@PathVariable Long id, @RequestBody FournisseurDTO fournisseur) {

        Fournisseur fournisseurExist = fournisseurServices.findFournisseurById(id);
        fournisseurExist.setAdresseFournisseur(fournisseur.getAdresseFournisseur());
        fournisseurServices.addNewFournisseur(fournisseurExist);
        return fournisseurExist;
    }

    @PutMapping("/updateFournisseur/{id}/email")
    public Fournisseur updateFournisseurEmail(@PathVariable Long id, @RequestBody FournisseurDTO fournisseur) {

        Fournisseur fournisseurExist = fournisseurServices.findFournisseurById(id);
        fournisseurExist.setEmailFournisseur(fournisseur.getEmailFournisseur());
        fournisseurServices.addNewFournisseur(fournisseurExist);
        return fournisseurExist;
    }




    @GetMapping("/all")
    public Iterable<Fournisseur> getAllFournisseur() {
        return fournisseurServices.findAllFournisseur();
    }

}
