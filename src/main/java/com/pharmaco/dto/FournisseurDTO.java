package com.pharmaco.dto;

import com.pharmaco.entities.CommandeProd;
import com.pharmaco.entities.FactureAchat;
import com.pharmaco.entities.Utilisateur;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class FournisseurDTO {

    private Long idFournisseur;


    private String nomFournisseur;

    private String adresseFournisseur;

    private String emailFournisseur;

    private int telFournisseur;


    private List<FactureAchat> factureAchatList;


    private List <CommandeProd> commandeProdList;



    private Utilisateur utilisateur;

}
