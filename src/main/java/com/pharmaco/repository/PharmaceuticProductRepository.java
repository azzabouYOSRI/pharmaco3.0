package com.pharmaco.repository;


import com.pharmaco.entities.Fournisseur;
import com.pharmaco.entities.PharmaceuticProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


public interface PharmaceuticProductRepository extends JpaRepository<PharmaceuticProduct, Long> {

    List<PharmaceuticProduct> findByLibPrd(String nomProduit);


    List<PharmaceuticProduct> findByDateAjoutPrd(@DateTimeFormat(pattern="yyyy-MM-dd") Date dateAjout);
    List<PharmaceuticProduct> findByPrixPrd(double prixProduit);
    List<PharmaceuticProduct> findByDescriptionPrd(String descriptionProduit);
    List<PharmaceuticProduct> findByPrixLivraison(double prixLivraison);

    @Query(value = "select * from pharmaceutic_product  where id_commande_prod =:idcmd",nativeQuery = true)
    public List<PharmaceuticProduct> findProduitByCommande(@Param(value = "idcmd") Long id);

    @Query(value = "select * from pharmaceutic_product  where id_famille =:idf",nativeQuery = true)
    public List<PharmaceuticProduct> findProduitByFamille(@Param(value = "idf") Long id);

    @Query(value = "select * from pharmaceutic_product  where id_labo =:idl",nativeQuery = true)
    public List<PharmaceuticProduct> findProduitByLaboratoire(@Param(value = "idl") Long id);




}
