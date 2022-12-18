package com.pharmaco.controller;

import com.pharmaco.dto.PharmaceuticProductDTO;
import com.pharmaco.entities.PharmaceuticProduct;
import com.pharmaco.services.FactureAchatServices;
import com.pharmaco.services.PharmaceuticProductServices;
import com.pharmaco.services.UserServices;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
   private final PharmaceuticProductServices pharmaceuticProductServices;
   private final UserServices userServices;

   private final FactureAchatServices factureAchatServices;

    @Autowired
    public ProductController(PharmaceuticProductServices pharmaceuticProductServices, UserServices userServices, FactureAchatServices factureAchatServices) {
        this.pharmaceuticProductServices = pharmaceuticProductServices;
        this.userServices = userServices;
        this.factureAchatServices = factureAchatServices;
    }
    @DeleteMapping("/deleteProduit/{id}")
    public void deleteProduit( @PathVariable Long id) {
        pharmaceuticProductServices.deleteProduit(id);
    }

    @PostMapping(value = "/add",
            consumes = "application/json")
    public PharmaceuticProduct saveProduit(@RequestBody @Validated PharmaceuticProduct pharmaceuticProduct) {
        pharmaceuticProductServices.saveProduit(pharmaceuticProduct);
        return pharmaceuticProduct;
    }

    @GetMapping("/findProduitById/{id}")
    public PharmaceuticProduct findProduitById(@PathVariable Long id) {
        return pharmaceuticProductServices.findProduitById(id);
    }

    @GetMapping("/findProduitByNomProd/{nomProd}")
    public List<PharmaceuticProduct> findProduitByNomProd(@PathVariable String nomProd) {
        return pharmaceuticProductServices.findProduitByNomProd(nomProd);
    }

    @GetMapping("/findProduitByDateAjoutPrd/{dateAjoutPrd}")
    public @ResponseBody List<PharmaceuticProduct> findProduitByDateAjoutPrd (  @DateTimeFormat(pattern="yyyy-MM-dd") Date dateAjoutPrd){
        return pharmaceuticProductServices.findfindByDateAjoutPrd(dateAjoutPrd);
    }

    @GetMapping("/findProduitByPrixPrd/{prixPrd}")
    public List<PharmaceuticProduct> findProduitByPrixPrd(@PathVariable double prixPrd) {
        return pharmaceuticProductServices.findProduitByPrixPrd(prixPrd);
    }

    @GetMapping("/findProduitByDescriptionPrd/{descriptionPrd}")
    public List<PharmaceuticProduct> findProduitByDescriptionPrd(@PathVariable String descriptionPrd) {
        return pharmaceuticProductServices.findProduitByDescriptionPrd(descriptionPrd);
    }

    @GetMapping("/findProduitByPrixLivraison/{prixLivraison}")
    public List<PharmaceuticProduct> findProduitByPrixLivraison(@PathVariable double prixLivraison) {
        return pharmaceuticProductServices.findProduitByPrixLivraison(prixLivraison);
    }


    @GetMapping("/findProduitByLaboratoire/{idLab}")
    public List<PharmaceuticProduct> findProduitByLaboratoire(@PathVariable Long idLab) {
        return pharmaceuticProductServices.findProduitByLabo(idLab);
    }

    @GetMapping("/findProduitByCommande/{idCmd}")
    public List<PharmaceuticProduct> findProduitByCommande(@PathVariable Long idCmd) {
        return pharmaceuticProductServices.findProduitByCommande(idCmd);
    }


    @GetMapping("/findProduitByFamille/{idFam}")
    public List<PharmaceuticProduct> findProduitByFamille(@PathVariable Long idFam) {
        return pharmaceuticProductServices.findProduitByFamille(idFam);
    }


    @PutMapping("/updateproduct/{id}/lib")
    public PharmaceuticProduct updateLibPrd(@PathVariable Long id, @RequestBody @NotNull PharmaceuticProductDTO pharmaceuticProduct) {
        PharmaceuticProduct  pharmaceuticProductExist = pharmaceuticProductServices.findProduitById(id);
        pharmaceuticProductExist.setLibPrd(pharmaceuticProduct.getLibPrd());
        pharmaceuticProductServices.saveProduit(pharmaceuticProductExist);
        return pharmaceuticProductExist;

    }

    @PutMapping("/updateproduct/{id}/dateajout")
    public PharmaceuticProduct  updateDateAjoutPrd(@PathVariable Long id, @RequestBody @NotNull PharmaceuticProductDTO pharmaceuticProduct) {
        PharmaceuticProduct  pharmaceuticProductExist = pharmaceuticProductServices.findProduitById(id);
        pharmaceuticProductExist.setDateAjoutPrd(pharmaceuticProduct.getDateAjoutPrd());
        pharmaceuticProductServices.saveProduit(pharmaceuticProductExist);
        return pharmaceuticProductExist;

    }

    @PutMapping("/updateproduct/{id}/prixprd")
    public PharmaceuticProduct  updatePrixPrd(@PathVariable Long id, @RequestBody @NotNull PharmaceuticProductDTO pharmaceuticProduct) {
        PharmaceuticProduct  pharmaceuticProductExist = pharmaceuticProductServices.findProduitById(id);
        pharmaceuticProductExist.setPrixPrd(pharmaceuticProduct.getPrixPrd());
        pharmaceuticProductServices.saveProduit(pharmaceuticProductExist);
        return pharmaceuticProductExist;

    }

    @PutMapping("/updateproduct/{id}/familleprd")
    public PharmaceuticProduct  updateFamillePrd(@PathVariable Long id, @RequestBody @NotNull PharmaceuticProductDTO pharmaceuticProduct) {
        PharmaceuticProduct  pharmaceuticProductExist = pharmaceuticProductServices.findProduitById(id);
        pharmaceuticProductExist.setFamille(pharmaceuticProduct.getFamille());
        pharmaceuticProductServices.saveProduit(pharmaceuticProductExist);
        return pharmaceuticProductExist;

    }

    @PutMapping("/updateproduct/{id}/descprd")
    public PharmaceuticProduct updateDescriptionPrd(@PathVariable Long id, @RequestBody @NotNull PharmaceuticProductDTO pharmaceuticProduct) {
        PharmaceuticProduct  pharmaceuticProductExist = pharmaceuticProductServices.findProduitById(id);
        pharmaceuticProductExist.setDescriptionPrd(pharmaceuticProduct.getDescriptionPrd());
        pharmaceuticProductServices.saveProduit(pharmaceuticProductExist);
        return pharmaceuticProductExist;

    }

    @PutMapping("/updateproduct/{id}/cmdprd")
    public PharmaceuticProduct  updateCmdPrd(@PathVariable Long id, @RequestBody @NotNull PharmaceuticProductDTO pharmaceuticProduct) {
        PharmaceuticProduct  pharmaceuticProductExist = pharmaceuticProductServices.findProduitById(id);
        pharmaceuticProductServices.saveProduit(pharmaceuticProductExist);
        return pharmaceuticProductExist;
    }

    @PutMapping("/updateproduct/{id}/labprd")
    public PharmaceuticProduct  updateLabPrd(@PathVariable Long id, @RequestBody @NotNull PharmaceuticProductDTO pharmaceuticProduct) {
        PharmaceuticProduct  pharmaceuticProductExist = pharmaceuticProductServices.findProduitById(id);
        pharmaceuticProductExist.setLaboratoire(pharmaceuticProduct.getLaboratoire());
        pharmaceuticProductServices.saveProduit(pharmaceuticProductExist);
        return pharmaceuticProductExist;
    }

    @PutMapping("/updateproduct/{id}/PrixLivraison")
    public PharmaceuticProduct  updatePrixLivraison(@PathVariable Long id, @RequestBody @NotNull PharmaceuticProductDTO pharmaceuticProduct) {
        PharmaceuticProduct  pharmaceuticProductExist = pharmaceuticProductServices.findProduitById(id);
        pharmaceuticProductExist.setPrixLivraison(pharmaceuticProduct.getPrixLivraison());
        pharmaceuticProductServices.saveProduit(pharmaceuticProductExist);
        return pharmaceuticProductExist;
    }

    @GetMapping("/findallproduct")
    public List<PharmaceuticProduct> findAllProduct() {
        return pharmaceuticProductServices.findAllProduit();
    }

    @GetMapping("/findbyuser/{iduser}")
    public List<List<PharmaceuticProduct>> findProduitByUser(@PathVariable Long iduser) {
        return userServices.findproductbyuser(iduser);
    }

    @GetMapping("/findbyfacture/{idfacture}")
    public List<List<PharmaceuticProduct>> findProduitByFacture(@PathVariable Long idfacture) {
        return factureAchatServices.findprdbyfacture(idfacture);
    }

}
