package com.pharmaco.demo1.repository;


import com.pharmaco.pharaco101.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {

    List<Fournisseur> findFournisseurByNomFournisseur(String nomFour);
    List<Fournisseur> findFournisseurByAdresseFournisseur(String adresseFour);
    List<Fournisseur> findFournisseurByEmailFournisseur(String emailFour);
    List<Fournisseur> findFournisseurByTelFournisseur(int telFour);

    @Query(value = "select * from fournisseur where id_utilisateur =:idU",nativeQuery = true)
    public List<Fournisseur> findEnseignantByUtilisateur(@Param(value = "idU") Long id);
}
