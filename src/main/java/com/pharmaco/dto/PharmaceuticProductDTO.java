
package com.pharmaco.pojos;

import lombok.*;

import java.util.List;

/**
 * @author yosriazabou
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class PharmaceuticProductModel  {
//    @ManyToMany(mappedBy = "pharmaceuticProductsListModel")
//    @ToString.Exclude
//   private List<UtilisateurModel> utilisateurList;


    private List<FactureAchatModel> factureAchatModelList;



    private String libPrd;

    private double prixPrd;

    private String descriptionPrd;

    private String dateAjoutPrd;

    private double prixLivraison;



    private FamilleModel familleModel;


    private CommandeProdModel commandeProd;

    private LaboratoireModel laboratoireModel;

}
