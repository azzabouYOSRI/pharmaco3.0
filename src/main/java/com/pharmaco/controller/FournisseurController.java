package com.pharmaco.pharaco101.controller;

import com.pharmaco.pharaco101.entities.Fournisseur;
import com.pharmaco.pharaco101.services.FournisseurServices;
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
    public void addFournisseur(@Validated @RequestBody Fournisseur fournisseur) {
        fournisseurServices.addNewFournisseur(fournisseur);
    }

    @GetMapping("/getFournisseur/{id}")
    public Fournisseur getFournisseur(@PathVariable Long id) {
        return fournisseurServices.findFournisseurById(id);
    }

    @DeleteMapping("/deleteFournisseur/{id}")
    public void deleteFournisseur(@PathVariable Long id) {
        fournisseurServices.deleteFournisseur(id);
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

    @PutMapping("/updateFournisseur/{id}/1")
    public Fournisseur updateFournisseurNom(@PathVariable Long id, @RequestBody Fournisseur fournisseur) {

    Fournisseur fournisseurExist = fournisseurServices.findFournisseurById(id);
    fournisseurExist.setNomFournisseur(fournisseur.getNomFournisseur());
    fournisseurServices.addNewFournisseur(fournisseurExist);
    return fournisseurExist;
    }
    @PutMapping("/updateFournisseur/{id}/1")
    public Fournisseur updateFournisseurTelephone(@PathVariable Long id, @RequestBody Fournisseur fournisseur) {

        Fournisseur fournisseurExist = fournisseurServices.findFournisseurById(id);
        fournisseurExist.setTelFournisseur(fournisseur.getTelFournisseur());
        fournisseurServices.addNewFournisseur(fournisseurExist);
        return fournisseurExist;
    }

    @PutMapping("/updateFournisseur/{id}/3")
    public Fournisseur updateFournisseurAdresse(@PathVariable Long id, @RequestBody Fournisseur fournisseur) {

        Fournisseur fournisseurExist = fournisseurServices.findFournisseurById(id);
        fournisseurExist.setAdresseFournisseur(fournisseur.getAdresseFournisseur());
        fournisseurServices.addNewFournisseur(fournisseurExist);
        return fournisseurExist;
    }

    @PutMapping("/updateFournisseur/{id}/4")
    public Fournisseur updateFournisseurEmail(@PathVariable Long id, @RequestBody Fournisseur fournisseur) {

        Fournisseur fournisseurExist = fournisseurServices.findFournisseurById(id);
        fournisseurExist.setEmailFournisseur(fournisseur.getEmailFournisseur());
        fournisseurServices.addNewFournisseur(fournisseurExist);
        return fournisseurExist;
    }

}
