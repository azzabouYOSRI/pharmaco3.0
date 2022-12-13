package com.pharmaco.services;

import com.pharmaco.entities.Laboratoire;
import com.pharmaco.repository.LaboratoireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
    public void saveLaboratoire(Laboratoire laboratoire) {
        laboratoireRepository.save(laboratoire);
    }

    @Transactional
    public Laboratoire findLaboratoireById(Long id) {
        Optional<Laboratoire> optionalFournisseur = laboratoireRepository.findById(id);
        return optionalFournisseur.orElseGet(Laboratoire::new);    }

    @Transactional
    public List<Laboratoire> findAllLaboratoire() {
        return laboratoireRepository.findAll();
    }

    @Transactional
    public List<Laboratoire> findLaboratoireByNomLaboratoire(String nomLaboratoire) {
        return laboratoireRepository.findByLibelleLabo(nomLaboratoire);
    }
}
