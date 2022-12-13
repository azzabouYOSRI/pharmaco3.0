package com.pharmaco.dto;

import com.pharmaco.entities.Fournisseur;
import com.pharmaco.entities.PharmaceuticProduct;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class CommandeProdDTO {

    private Long idCommandeProd;

    private Integer quantityFourn;

    private Date dateFourni;
    private List<PharmaceuticProduct> pharmaceuticProductsList;


    private List<Fournisseur> fournisseurList;

}
