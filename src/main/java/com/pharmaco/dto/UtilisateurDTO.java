package com.pharmaco.pojos;

import lombok.*;

import java.util.Date;
import java.util.List;


@Builder
@RequiredArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class UtilisateurModel  {

    private Long id;


    private String nomUtil;


    private String prenomUtil;


    private String adresseUtil;


    private String emailUtil;


    private int codePostalUtil;

    private String telUtil;

    private String passwordUtil;



    private Date dateNaisaanceUtil;


    private List<PharmaceuticProductModel> pharmaceuticProductsListModel;


    private List<FournisseurModel> fournisseurModelList;
    private int priveldege;
}
