package com.pharmaco.pharaco101.controller;

import com.pharmaco.pharaco101.entities.Laboratoire;
import com.pharmaco.pharaco101.services.LaboratoireServices;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/add")
    public Laboratoire addLaboratoire(Laboratoire laboratoire){
        return laboratoireServices.saveLaboratoire(laboratoire);
    }

    @PostMapping("/delete")
    public void deleteLaboratoire(Long id){
        laboratoireServices.deleteLaboratoire(id);
    }

    @PostMapping("/find")
    public Laboratoire findLaboratoireById(Long id){
        return laboratoireServices.findLaboratoireById(id);
    }

    @PutMapping("/update")
    public Laboratoire updateLaboratoire(Laboratoire laboratoire){
        return laboratoireServices.saveLaboratoire(laboratoire);
    }

}
