package com.pharmaco.controller;

import com.pharmaco.dto.FactureAchatDTO;
import com.pharmaco.entities.FactureAchat;
import com.pharmaco.entities.Utilisateur;
import com.pharmaco.services.FactureAchatServices;
import com.pharmaco.services.PharmaceuticProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/factureAchat")
public class FactureAchatController {

    private final FactureAchatServices factureAchatServices;
    private final PharmaceuticProductServices pharmaceuticProductServices;

    @Autowired
    public FactureAchatController(FactureAchatServices factureAchatServices, PharmaceuticProductServices pharmaceuticProductServices) {
        this.factureAchatServices = factureAchatServices;
        this.pharmaceuticProductServices = pharmaceuticProductServices;
    }

    @GetMapping("/all")
    public List<FactureAchat> getAllFactureAchat() {
        return factureAchatServices.findAllFactureAchat();
    }

    @GetMapping("/findFactureAchatById/{id}")
    public FactureAchat findFactureAchatById(@PathVariable Long id) {
        return factureAchatServices.findFactureAchatById(id);
    }

    @GetMapping("/findFactureAchatByDateFacture/{dateFacture}")
    public List<FactureAchat> findFactureAchatByDateFacture(@PathVariable Date dateFacture) {
        return factureAchatServices.findFactureAchatByDateFactAchat(dateFacture);
    }

    @GetMapping("/findFactureAchatByTtcFacture/{ttcFacture}")
    public List<FactureAchat> findFactureAchatByTotalFacture(@PathVariable double ttcFacture) {
        return factureAchatServices.findFactureAchatByTotalTtcFactAchat(ttcFacture);
    }

    @GetMapping("/findFactureAchatByFournisseur/{fournisseurID}")
    public List<FactureAchat> findFactureAchatByFournisseur(@PathVariable Long fournisseurID) {
        return factureAchatServices.findFactureAchatByFournisseurId(fournisseurID);
    }

    @PutMapping("/updateFactureAchat/{id}/{dateFacture})")
    public FactureAchat updateFactureAchat(@PathVariable Long id, @PathVariable Date dateFacture) {
        FactureAchat factureAchat = factureAchatServices.findFactureAchatById(id);
        factureAchat.setDateFactAchat(dateFacture);
        return factureAchatServices.saveFactureAchat(factureAchat);
    }

    @PostMapping("/addFactureAchat")
    public FactureAchat addFactureAchat(@RequestBody @Validated FactureAchatDTO factureAchat) {
        FactureAchat persistantFactureAchat = new FactureAchat();
        persistantFactureAchat.setDateFactAchat(factureAchat.getDateFactAchat());
        persistantFactureAchat.setTotalTtcFactAchat(factureAchat.getTotalTtcFactAchat());
        persistantFactureAchat.setTotalHtFactAchat(factureAchat.getTotalHtFactAchat());
        persistantFactureAchat.setTva(factureAchat.getTva());
        persistantFactureAchat.setFournisseur(factureAchat.getFournisseur());
         factureAchatServices.saveFactureAchat(persistantFactureAchat);
        return persistantFactureAchat;
    }

    @DeleteMapping("/deleteFactureAchat/{id}")
    public String deleteFactureAchat(@PathVariable Long id) {
        FactureAchat factureAchat = factureAchatServices.findFactureAchatById(id);
        return factureAchatServices.deleteFactureAchat(factureAchat);
    }

    @PutMapping("/updateFactureAchat/{id}/ttc)")
    public FactureAchat updateFactureAchatTotalttc(@PathVariable Long id,@RequestBody FactureAchatDTO factureAchat) {
        FactureAchat factureAchatExist = factureAchatServices.findFactureAchatById(id);
        factureAchat.setTotalTtcFactAchat(factureAchat.getTotalHtFactAchat() * factureAchat.getTva());
        factureAchatServices.saveFactureAchat(factureAchatExist);
        return factureAchatExist;
    }

    @PutMapping("/updateFactureAchat/{id}/date)")
    public FactureAchat updateFactureAchatDate(@PathVariable Long id,@RequestBody FactureAchatDTO factureAchat) {
        FactureAchat factureAchatExist = factureAchatServices.findFactureAchatById(id);
        factureAchat.setDateFactAchat(factureAchat.getDateFactAchat());
        factureAchatServices.saveFactureAchat(factureAchatExist);
        return factureAchatExist;
    }

    @PutMapping("/updateFactureAchat/{id}/fournisseur)")
    public FactureAchat updateFactureAchatFournisseur(@PathVariable Long id,@RequestBody FactureAchatDTO factureAchat) {
        FactureAchat factureAchatExist = factureAchatServices.findFactureAchatById(id);
        factureAchat.setFournisseur(factureAchat.getFournisseur());
        factureAchatServices.saveFactureAchat(factureAchatExist);
        return factureAchatExist;
    }

    @PutMapping("/updateFactureAchat/{id}/tva)")
    public FactureAchat updateFactureAchatTva(@PathVariable Long id,@RequestBody FactureAchatDTO factureAchat) {
        FactureAchat factureAchatExist = factureAchatServices.findFactureAchatById(id);
        factureAchat.setTva(factureAchat.getTva());
        factureAchatServices.saveFactureAchat(factureAchatExist);
        return factureAchatExist;
    }

    @GetMapping("/findFactureByTva/{tva}")
    public List<FactureAchat> findFactureByTva(@PathVariable double tva) {
        return factureAchatServices.findFactureAchatByTva(tva);
    }

    @GetMapping("/findFactureByTotalHt/{totalHt}")
    public List<FactureAchat> findFactureByTotalHt(@PathVariable double totalHt) {
        return factureAchatServices.findFactureAchatByTotalHtFactAchat(totalHt);
    }

    @GetMapping("/findFacturebyproduct/{idprd}")
    public List<List<Utilisateur>> findFactureByProduct(@PathVariable Long idprd) {
        return pharmaceuticProductServices.finduserbyproduct(idprd);
    }













}
