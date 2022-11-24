package com.pharmaco.pharaco101.controller;

import com.pharmaco.pharaco101.entities.Utilisateur;
import com.pharmaco.pharaco101.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/User")
public class UtilisateurController {

    private final UserServices userServices;

    @Autowired
    public UtilisateurController(UserServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping(
            value = "/addUser",
            consumes = "application/json")
    public Utilisateur saveUser(@Validated @RequestBody Utilisateur utilisateur) {

        userServices.saveUser(utilisateur);
        //return the dep we just inserted
        return utilisateur;
    }

    @GetMapping("/getUser/{id}")
    public Utilisateur getUser(@PathVariable Long id) {
        return userServices.findUserById(id);
    }


    @GetMapping("/getUsersByNom/{nom}")
    public List<Utilisateur> userlist(@PathVariable String nom) {
        return userServices.findUtilisateurByNomUtil(nom);

    }

    @GetMapping("/getUsersByPrenom/{prenom}")
    public List<Utilisateur> userlistByPrenom(@PathVariable String prenom) {
        return userServices.findUtilisateurByPrenomUtil(prenom);

    }

    @GetMapping("/getUsersByNomAndPrenom/{nom}/{prenom}")
    public List<Utilisateur> userlistByNomAndPrenom(@PathVariable String nom, @PathVariable String prenom) {
        return userServices.findUtilisateurByNomUtilAndPrenomUtil(nom, prenom);

    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable Long id) {
        userServices.deleteUser(id);
    }

    @GetMapping("/getAllUsers")
    public List<Utilisateur> getAllUsers() {
        return userServices.findAllUtilisateur();
    }

    @GetMapping("/getUsersByTel/{tel}")
    public List<Utilisateur> userlistByTel(@PathVariable String tel) {
        return userServices.findUtilisateurByTelUtil(tel);
    }

    @GetMapping("/getUsersByAdresse/{adresse}")
    public List<Utilisateur> userlistByAdresse(@PathVariable String adresse) {
        return userServices.findUtilisateurByAdresseUtil(adresse);
    }

    @GetMapping("/getUsersByDateNaissance/{dateNaissance}")
    public List<Utilisateur> userlistByDateNaissance(@PathVariable Date dateNaissance) {
        return userServices.findUtilisateurBydateNaisaanceUtil(dateNaissance);
    }

    @GetMapping("/getUsersByCodePostal/{codePostal}")
    public List<Utilisateur> userlistByCodePostal(@PathVariable int codePostal) {
        return userServices.findUtilisateurByCodePostalUtil(codePostal);
    }

    @GetMapping("/getUsersByPrivilege/{privilege}")
    public List<Utilisateur> userlistByPrivilege(@PathVariable int privilege) {
        return userServices.findUtilisateurByPriveldege(privilege);
    }

    @PutMapping("/updateUser/{id}/1")
    public Utilisateur updateUserNom(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
        Utilisateur utilisateurExist = userServices.findUserById(id);
        utilisateurExist.setNomUtil(utilisateur.getNomUtil());
        userServices.saveUser(utilisateurExist);
        return utilisateurExist;
    }

    @PutMapping("/updateUser/{id}/2")
    public Utilisateur updateUserPrenom(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
        Utilisateur utilisateurExist = userServices.findUserById(id);
        utilisateurExist.setPrenomUtil(utilisateur.getPrenomUtil());
        userServices.saveUser(utilisateurExist);
        return utilisateurExist;

    }

    @PutMapping("/updateUser/{id}/3")
    public Utilisateur updateUserEmail(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
        Utilisateur utilisateurExist = userServices.findUserById(id);
        utilisateurExist.setEmailUtil(utilisateur.getEmailUtil());
        userServices.saveUser(utilisateurExist);
        return utilisateurExist;

    }
    
    @PutMapping("/updateUser/{id}/4")
    public Utilisateur updateUserTel(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
        Utilisateur utilisateurExist = userServices.findUserById(id);
        utilisateurExist.setTelUtil(utilisateur.getTelUtil());
        userServices.saveUser(utilisateurExist);
        return utilisateurExist;

    }
    
    @PutMapping("/updateUser/{id}/5")
    public Utilisateur updateUserAdresse(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
        Utilisateur utilisateurExist = userServices.findUserById(id);
        utilisateurExist.setAdresseUtil(utilisateur.getAdresseUtil());
        userServices.saveUser(utilisateurExist);
        return utilisateurExist;

    }
    
    @PutMapping("/updateUser/{id}/6")
    public Utilisateur updateUserDateNaissance(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
        Utilisateur utilisateurExist = userServices.findUserById(id);
        utilisateurExist.setDateNaisaanceUtil(utilisateur.getDateNaisaanceUtil());
        userServices.saveUser(utilisateurExist);
        return utilisateurExist;

    }
    
    @PutMapping("/updateUser/{id}/7")
    public Utilisateur updateUserCodePostal(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
        Utilisateur utilisateurExist = userServices.findUserById(id);
        utilisateurExist.setCodePostalUtil(utilisateur.getCodePostalUtil());
        userServices.saveUser(utilisateurExist);
        return utilisateurExist;

    }
    
    @PutMapping("/updateUser/{id}/8")
    public Utilisateur updateUserPrivilege(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
        Utilisateur utilisateurExist = userServices.findUserById(id);
        utilisateurExist.setPriveldege(utilisateur.getPriveldege());
        userServices.saveUser(utilisateurExist);
        return utilisateurExist;

    }
    
    @PutMapping("/updateUser/{id}/9")
    public Utilisateur updateUserPassword(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
        Utilisateur utilisateurExist = userServices.findUserById(id);
        utilisateurExist.setPasswordUtil(utilisateur.getPasswordUtil());
        userServices.saveUser(utilisateurExist);
        return utilisateurExist;

    }

    @GetMapping("/getUsersByEmail/{email}")
    public List<Utilisateur> findUserByEmail(@PathVariable String email) {
        return userServices.findUtilisateurByEmailUtil(email);
    }
    
    
}
