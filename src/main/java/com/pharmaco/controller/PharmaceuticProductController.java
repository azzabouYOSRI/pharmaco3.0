//package com.pharmaco.controller;
//
//import com.pharmaco.dto.PharmaceuticProductDTO;
//import com.pharmaco.entities.PharmaceuticProduct;
//import com.pharmaco.services.PharmaceuticProductServices;
//import org.jetbrains.annotations.NotNull;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Date;
//import java.util.List;
//
//@Controller
//@RequestMapping{"/product"}
//public class PharmaceuticProductController {
//
//    private final PharmaceuticProductServices pharmaceuticProductServices;
//
//    @Autowired
//    public PharmaceuticProductController(PharmaceuticProductServices pharmaceuticProductServices) {
//        this.pharmaceuticProductServices = pharmaceuticProductServices;
//    }
//    public String deleteProduit(Long id) {
//        return pharmaceuticProductServices.deleteProduit(id);
//    }
//
//    @PostMapping(value = "/add",
//            consumes = "application/json")
//    public PharmaceuticProduct saveProduit(@RequestBody @Validated PharmaceuticProductDTO pharmaceuticProduct) {
//        PharmaceuticProduct persistantPharmaceuticProduct = new PharmaceuticProduct();
//        persistantPharmaceuticProduct.setLaboratoire(pharmaceuticProduct.getLaboratoire());
//        persistantPharmaceuticProduct.setCommandeProd(pharmaceuticProduct.getCommandeProd());
//        persistantPharmaceuticProduct.setFamille(pharmaceuticProduct.getFamille());
//        persistantPharmaceuticProduct.setPrixPrd(pharmaceuticProduct.getPrixPrd());
//        persistantPharmaceuticProduct.setDateAjoutPrd(pharmaceuticProduct.getDateAjoutPrd());
//        persistantPharmaceuticProduct.setDescriptionPrd(pharmaceuticProduct.getDescriptionPrd());
//        persistantPharmaceuticProduct.setLibPrd(pharmaceuticProduct.getLibPrd());
//        persistantPharmaceuticProduct.setPrixLivraison(pharmaceuticProduct.getPrixLivraison());
//         pharmaceuticProductServices.saveProduit(persistantPharmaceuticProduct);
//        return persistantPharmaceuticProduct;
//    }
//
//    @GetMapping("/findProduitById/{id}")
//    public PharmaceuticProduct findProduitById(@PathVariable Long id) {
//        return pharmaceuticProductServices.findProduitById(id);
//    }
//
//    @GetMapping("/findProduitByNomProd/{nomProd}")
//    public List<PharmaceuticProduct> findProduitByNomProd(@PathVariable String nomProd) {
//        return pharmaceuticProductServices.findProduitByNomProd(nomProd);
//    }
//
//    @GetMapping("/findProduitByDateAjoutPrd/{dateAjoutPrd}")
//    public List<PharmaceuticProduct> findProduitByDateAjoutPrd(@PathVariable Date dateAjoutPrd) {
//        return pharmaceuticProductServices.findfindByDateAjoutPrd(dateAjoutPrd);
//    }
//
//    @GetMapping("/findProduitByPrixPrd/{prixPrd}")
//    public List<PharmaceuticProduct> findProduitByPrixPrd(@PathVariable double prixPrd) {
//        return pharmaceuticProductServices.findProduitByPrixPrd(prixPrd);
//    }
//
//    @GetMapping("/findProduitByDescriptionPrd/{descriptionPrd}")
//    public List<PharmaceuticProduct> findProduitByDescriptionPrd(@PathVariable String descriptionPrd) {
//        return pharmaceuticProductServices.findProduitByDescriptionPrd(descriptionPrd);
//    }
//
//    @GetMapping("/findProduitByPrixLivraison/{prixLivraison}")
//    public List<PharmaceuticProduct> findProduitByPrixLivraison(@PathVariable double prixLivraison) {
//        return pharmaceuticProductServices.findProduitByPrixLivraison(prixLivraison);
//    }
//
////    @GetMapping("/findProduitByUtilisateur/{utilisateur}")
////    public List<PharmaceuticProduct> findProduitByUtilisateur(@PathVariable String utilisateur) {//        return pharmaceuticProductServices.f(utilisateur);
////    }
//
//    @GetMapping("/findProduitByLaboratoire/{idLab}")
//    public List<PharmaceuticProduct> findProduitByLaboratoire(@PathVariable Long idLab) {
//        return pharmaceuticProductServices.findProduitByLabo(idLab);
//    }
//
//    @GetMapping("/findProduitByCommande/{idCmd}")
//    public List<PharmaceuticProduct> findProduitByCommande(@PathVariable Long idCmd) {
//        return pharmaceuticProductServices.findProduitByCommande(idCmd);
//    }
//
//
//    @GetMapping("/findProduitByFamille/{idFam}")
//    public List<PharmaceuticProduct> findProduitByFamille(@PathVariable Long idFam) {
//        return pharmaceuticProductServices.findProduitByFamille(idFam);
//    }
//
//
//    @PutMapping("/updateproduct/{id}/1")
//    public PharmaceuticProduct updateLibPrd(@PathVariable Long id, @RequestBody @NotNull PharmaceuticProductDTO pharmaceuticProduct) {
//       PharmaceuticProduct  pharmaceuticProductExist = pharmaceuticProductServices.findProduitById(id);
//        pharmaceuticProductExist.setLibPrd(pharmaceuticProduct.getLibPrd());
//        pharmaceuticProductServices.saveProduit(pharmaceuticProductExist);
//        return pharmaceuticProductExist;
//
//    }
//
//    @PutMapping("/updateproduct/{id}/2")
//    public PharmaceuticProduct  updateDateAjoutPrd(@PathVariable Long id, @RequestBody @NotNull PharmaceuticProductDTO pharmaceuticProduct) {
//        PharmaceuticProduct  pharmaceuticProductExist = pharmaceuticProductServices.findProduitById(id);
//        pharmaceuticProductExist.setDateAjoutPrd(pharmaceuticProduct.getDateAjoutPrd());
//        pharmaceuticProductServices.saveProduit(pharmaceuticProductExist);
//        return pharmaceuticProductExist;
//
//    }
//
//    @PutMapping("/updateproduct/{id}/3")
//    public PharmaceuticProduct  updatePrixPrd(@PathVariable Long id, @RequestBody @NotNull PharmaceuticProductDTO pharmaceuticProduct) {
//        PharmaceuticProduct  pharmaceuticProductExist = pharmaceuticProductServices.findProduitById(id);
//        pharmaceuticProductExist.setPrixPrd(pharmaceuticProduct.getPrixPrd());
//        pharmaceuticProductServices.saveProduit(pharmaceuticProductExist);
//        return pharmaceuticProductExist;
//
//    }
//
//    @PutMapping("/updateproduct/{id}/4")
//    public PharmaceuticProduct  updateFamillePrd(@PathVariable Long id, @RequestBody @NotNull PharmaceuticProductDTO pharmaceuticProduct) {
//        PharmaceuticProduct  pharmaceuticProductExist = pharmaceuticProductServices.findProduitById(id);
//        pharmaceuticProductExist.setFamille(pharmaceuticProduct.getFamille());
//        pharmaceuticProductServices.saveProduit(pharmaceuticProductExist);
//        return pharmaceuticProductExist;
//
//    }
//
//    @PutMapping("/updateproduct/{id}/5")
//    public PharmaceuticProduct updateDescriptionPrd(@PathVariable Long id, @RequestBody @NotNull PharmaceuticProductDTO pharmaceuticProduct) {
//        PharmaceuticProduct  pharmaceuticProductExist = pharmaceuticProductServices.findProduitById(id);
//        pharmaceuticProductExist.setDescriptionPrd(pharmaceuticProduct.getDescriptionPrd());
//        pharmaceuticProductServices.saveProduit(pharmaceuticProductExist);
//        return pharmaceuticProductExist;
//
//    }
//
//    @PutMapping("/updateproduct/{id}/6")
//    public PharmaceuticProduct  updateCmdPrd(@PathVariable Long id, @RequestBody @NotNull PharmaceuticProductDTO pharmaceuticProduct) {
//        PharmaceuticProduct  pharmaceuticProductExist = pharmaceuticProductServices.findProduitById(id);
//        pharmaceuticProductExist.setCommandeProd(pharmaceuticProduct.getCommandeProd());
//        pharmaceuticProductServices.saveProduit(pharmaceuticProductExist);
//        return pharmaceuticProductExist;
//    }
//
//    @PutMapping("/updateproduct/{id}/7")
//    public PharmaceuticProduct  updateLabPrd(@PathVariable Long id, @RequestBody @NotNull PharmaceuticProductDTO pharmaceuticProduct) {
//        PharmaceuticProduct  pharmaceuticProductExist = pharmaceuticProductServices.findProduitById(id);
//        pharmaceuticProductExist.setLaboratoire(pharmaceuticProduct.getLaboratoire());
//        pharmaceuticProductServices.saveProduit(pharmaceuticProductExist);
//        return pharmaceuticProductExist;
//    }
//
//    @PutMapping("/updateproduct/{id}/8")
//    public PharmaceuticProduct  updatePrixLivraison(@PathVariable Long id, @RequestBody @NotNull PharmaceuticProductDTO pharmaceuticProduct) {
//        PharmaceuticProduct  pharmaceuticProductExist = pharmaceuticProductServices.findProduitById(id);
//        pharmaceuticProductExist.setPrixLivraison(pharmaceuticProduct.getPrixLivraison());
//        pharmaceuticProductServices.saveProduit(pharmaceuticProductExist);
//        return pharmaceuticProductExist;
//    }
//
//    @GetMapping("/findall")
//    public List<PharmaceuticProduct> findAllProduct() {
//        return pharmaceuticProductServices.findAllProduit();
//    }
//
////    @GetMapping("/findProductByUser/{id}")
////    public List<PharmaceuticProduct> findProductByUser(int id) {
////        return (id);
////    }
//
//
//
//
//
//
//
//
//}
