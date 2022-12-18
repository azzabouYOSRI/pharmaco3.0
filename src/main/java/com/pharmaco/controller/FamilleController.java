package com.pharmaco.controller;

import com.pharmaco.dto.FamilleDTO;
import com.pharmaco.entities.Famille;
import com.pharmaco.services.FamilleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/famille")
public class FamilleController {

    private final FamilleServices familleServices;

    @Autowired
    public FamilleController(FamilleServices familleServices) {
        this.familleServices = familleServices;
    }

    @GetMapping("/all")
    public List<Famille> getAllFamille(){
        return familleServices.findAllFamille();
    }

    @GetMapping("/libelle/{libelle}")
    public List<Famille> getFamilleByLibelle(@PathVariable String libelle){
        return familleServices.findFamilleByLibelle(libelle);
    }

    @GetMapping("/id/{id}")
    public Famille getFamilleById( @PathVariable Long id){
        return familleServices.findFamilleById(id);
    }

    @PostMapping("/add")
    public Famille addFamille(@Validated @RequestBody Famille famille){
        familleServices.saveFamille(famille);
        return famille;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFamille(@PathVariable Long id){
        familleServices.deleteFamille(id);
        return "Famille deleted";
    }

    @PutMapping("/update/{id}/libelle")
    public Famille updateFamille(@PathVariable Long id,  @RequestBody FamilleDTO famille){
        Famille familleExistant = familleServices.findFamilleById(id);
        familleExistant.setLibFamille(famille.getLibFamille());
        familleServices.saveFamille(familleExistant);
        return familleExistant;
    }

}
