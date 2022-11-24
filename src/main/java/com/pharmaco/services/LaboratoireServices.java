package com.pharmaco.pharaco101.services;

import com.pharmaco.pharaco101.entities.Laboratoire;
import com.pharmaco.pharaco101.repository.LaboratoireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class LaboratoireServices

{

    private final LaboratoireRepository laboratoireRepository;

    @Autowired
    public LaboratoireServices(LaboratoireRepository laboratoireRepository) {
        this.laboratoireRepository = laboratoireRepository;
    }

    @Transactional
    public void deleteLaboratoire(Long id) {
        laboratoireRepository.deleteById(id);
    }

    @Transactional
    public Laboratoire saveLaboratoire(Laboratoire laboratoire) {
        laboratoireRepository.save(laboratoire);
        return laboratoire;
    }

    @Transactional
    public Laboratoire findLaboratoireById(Long id) {
        Optional<Laboratoire> optionalFournisseur = laboratoireRepository.findById(id);
        return optionalFournisseur.orElseGet(Laboratoire::new);    }

    @Transactional
    public Iterable<Laboratoire> findAllLaboratoire() {
        return laboratoireRepository.findAll();
    }
}
