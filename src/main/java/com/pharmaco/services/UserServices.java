package com.pharmaco.pharaco101.services;


import com.pharmaco.pharaco101.entities.Utilisateur;
import com.pharmaco.pharaco101.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public UserServices(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Transactional
    public void deleteUser(Long id) {
        utilisateurRepository.deleteById(id);
    }

    @Transactional
    public void saveUser(Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
    }


    @Transactional
    public Utilisateur findUserById(Long id) {
        Optional<Utilisateur> optionalUtilisateur = Optional.ofNullable(utilisateurRepository.findUserById(id));
        return optionalUtilisateur.orElse(new Utilisateur());
    }

    @Transactional
    public List<Utilisateur> findUtilisateurByNomUtil(String nom) {
        Optional<List<Utilisateur>> optionalUtilisateur = Optional.ofNullable(utilisateurRepository.findUtilisateurByNomUtil(nom));
      return optionalUtilisateur.orElse( new ArrayList<>());
    }

    @Transactional
    public List<Utilisateur> findUtilisateurByPrenomUtil(String prenom) {
        return utilisateurRepository.findUtilisateurByPrenomUtil(prenom);
    }

    @Transactional
    public List<Utilisateur> findUtilisateurByNomUtilAndPrenomUtil(String nom, String prenom) {
        return utilisateurRepository.findUtilisateurByNomUtilAndPrenomUtil(nom, prenom);
    }

    @Transactional
    public List<Utilisateur> findUtilisateurByTelUtil(String tel) {
        return utilisateurRepository.findUtilisateurByTelUtil(tel);
    }

    @Transactional
    public List<Utilisateur> findUtilisateurByAdresseUtil(String adresse) {
        return utilisateurRepository.findUtilisateurByAdresseUtil(adresse);
    }

    @Transactional
    public List<Utilisateur> findUtilisateurByCodePostalUtil(int codepostal) {
        return utilisateurRepository.findUtilisateurByCodePostalUtil(codepostal);
    }

    @Transactional
    public List<Utilisateur> findUtilisateurBydateNaisaanceUtil(Date dateNaisaance) {
        return utilisateurRepository.findUtilisateurBydateNaisaanceUtil(dateNaisaance);
    }

    @Transactional
    public List<Utilisateur> findUtilisateurByPriveldege(int priveldege) {
        return utilisateurRepository.findUtilisateurByPriveldege(priveldege);
    }

    @Transactional
    public List<Utilisateur> findAllUtilisateur() {
        return utilisateurRepository.findAll();
    }

    @Transactional
    public List <Utilisateur> findUtilisateurByEmailUtil(String email){
        return utilisateurRepository.findUtilisateurByEmailUtil(email);
    }


}
