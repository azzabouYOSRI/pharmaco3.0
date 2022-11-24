package com.pharmaco.demo1.repository;


import com.pharmaco.pharaco101.entities.FactureAchat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FactureAchatRepository extends JpaRepository<FactureAchat, Long> {

    List<FactureAchat> findAllByIdFactAchatContains(String numFacture);
    List<FactureAchat> findAllByDateFactAchatContains(String dateFacture);
    List<FactureAchat> findByFournisseurContains(String fournisseur);

}
