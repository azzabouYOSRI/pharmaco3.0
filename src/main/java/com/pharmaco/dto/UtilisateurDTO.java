package com.pharmaco.dto;

import com.pharmaco.entities.Fournisseur;
import com.pharmaco.entities.PharmaceuticProduct;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;
import java.util.List;


@RequiredArgsConstructor
@Getter
@Setter
@Data
public class UtilisateurDTO  {
        private Long id;
        private String nomUtil;
        private String prenomUtil;
        private String adresseUtil;
        private String emailUtil;
        private int codePostalUtil;
        private int telUtil;
        private String passwordUtil;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Date dateNaisaanceUtil;
        private List<PharmaceuticProduct> pharmaceuticProductsList;
        private List<Fournisseur> fournisseurList;
        private int priveldege;


    }
