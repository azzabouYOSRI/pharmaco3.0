package com.pharmaco.pojos;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class CommandeProdModel  {

    private Long idCommandeProd;

    private Integer quantityFourn;

    private Date dateFourni;
    private List<PharmaceuticProductModel> pharmaceuticProductsListModel;


    private List<FournisseurModel> fournisseurModelList;

}
