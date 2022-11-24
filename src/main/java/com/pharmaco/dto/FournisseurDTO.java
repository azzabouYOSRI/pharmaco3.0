package com.pharmaco.pojos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class FournisseurModel {

    private Long idFournisseur;


    private String nomFournisseur;

    private String adresseFournisseur;

    private String emailFournisseur;

    private int telFournisseur;


    private List<FactureAchatModel> factureAchatModelList;


    private CommandeProdModel commandeProd;



    private UtilisateurModel utilisateurModel;

}
