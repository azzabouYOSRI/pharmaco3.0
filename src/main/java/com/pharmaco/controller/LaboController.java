package com.pharmaco.controller;

import com.pharmaco.dto.LaboratoireDTO;
import com.pharmaco.entities.Laboratoire;
import com.pharmaco.services.LaboratoireServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/labo")
public class LaboController {


    private final LaboratoireServices laboratoireServices;

    @Autowired
    public LaboController(LaboratoireServices laboratoireServices) {
        this.laboratoireServices = laboratoireServices;
    }

    @GetMapping("/all")
    public Iterable<Laboratoire> findAllLaboratoire(){
        return laboratoireServices.findAllLaboratoire();
    }

    @PostMapping(value = "/add",
            consumes = "application/json")
    public Laboratoire addLaboratoire(@RequestBody @Validated LaboratoireDTO laboratoire){
        Laboratoire persistantLaboratoire = new Laboratoire();
        persistantLaboratoire.setLibelleLabo(laboratoire.getLibLabo());


         laboratoireServices.saveLaboratoire(persistantLaboratoire);
        return persistantLaboratoire;
    }

    @DeleteMapping("/delete")
    public void deleteLaboratoire(Long id){
        laboratoireServices.deleteLaboratoire(id);
    }

    @GetMapping("/find/{id}")
    public Laboratoire findLaboratoireById( @PathVariable Long id){
        return laboratoireServices.findLaboratoireById(id);
    }

    @PutMapping("/update/{id}")
    public Laboratoire updateLaboratoire(@PathVariable Long id, @RequestBody LaboratoireDTO laboratoire){
        Laboratoire persistantLaboratoire = new Laboratoire();
        persistantLaboratoire.setLibelleLabo(laboratoire.getLibLabo());
         laboratoireServices.saveLaboratoire(persistantLaboratoire);
        return persistantLaboratoire;
    }

    @GetMapping("/findByName/{nomLaboratoire}")
    public Iterable<Laboratoire> findLaboratoireByNomLaboratoire(@PathVariable String nomLaboratoire){
        return laboratoireServices.findLaboratoireByNomLaboratoire(nomLaboratoire);
    }

}
