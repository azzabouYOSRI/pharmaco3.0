package com.pharmaco.services;

import com.pharmaco.entities.Famille;
import com.pharmaco.repository.FamilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FamilleServices {

    private final FamilleRepository familleRepository;

    @Autowired
    public FamilleServices(FamilleRepository familleRepository) {
        this.familleRepository = familleRepository;
    }

    @Transactional
    public void deleteFamille(Long id) {
        familleRepository.deleteById(id);
    }

    @Transactional
    public void saveFamille(Famille famille) {
         familleRepository.save(famille);
    }

    @Transactional
    public Famille findFamilleById(Long id) {

        Optional<Famille> optionalFamille = familleRepository.findById(id);
        return optionalFamille.orElseGet(Famille::new);}

    @Transactional
    public List<Famille> findAllFamille() {
        return familleRepository.findAll();
    }

    @Transactional
    public List<Famille> findFamilleByLibelle(String libelle) {
        return familleRepository.findByLibFamille(libelle);
    }
}
