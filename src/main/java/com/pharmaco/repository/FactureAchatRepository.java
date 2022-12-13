package com.pharmaco.repository;


import com.pharmaco.entities.FactureAchat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;


public interface FactureAchatRepository extends JpaRepository<FactureAchat, Long> {

   List<FactureAchat> findByIdFactAchat(Long idFactAchat);


   //tobe tested
    List<FactureAchat> findByFournisseurIdFournisseur(Long idFournisseur);
    List<FactureAchat> findByDateFactAchat(Date dateFactAchat);
    List<FactureAchat> findByTotalHtFactAchat(double totalHtFactAchat);
    List<FactureAchat> findByTotalTtcFactAchat(double totalTtcFactAchat);
    List<FactureAchat> findByTva(double tva);
    //to be tested





}
