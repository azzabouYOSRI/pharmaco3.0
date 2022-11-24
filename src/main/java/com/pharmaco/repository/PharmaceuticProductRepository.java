package com.pharmaco.demo1.repository;


import com.pharmaco.pharaco101.entities.PharmaceuticProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PharmaceuticProductRepository extends JpaRepository<PharmaceuticProduct, Long> {

    List<PharmaceuticProduct> findAllByLibPrdContains(String nomPrd);
    List<PharmaceuticProduct> findAllByPrixLivraisonContains(double prixPrd);
    List<PharmaceuticProduct> findAllByPrixPrdContains(double prixPrd);
    List<PharmaceuticProduct> findAllByDateAjoutPrdContains(String d);

}
