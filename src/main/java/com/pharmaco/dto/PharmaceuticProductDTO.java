
package com.pharmaco.dto;

import com.pharmaco.entities.CommandeProd;
import com.pharmaco.entities.FactureAchat;
import com.pharmaco.entities.Famille;
import com.pharmaco.entities.Laboratoire;
import lombok.*;

import java.util.Date;
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
@Data
public class PharmaceuticProductDTO {


    private List<FactureAchat> factureAchatDTOList;



    private String libPrd;

    private double prixPrd;

    private String descriptionPrd;

    private Date dateAjoutPrd;

    private double prixLivraison;



    private Famille famille;


    private  CommandeProd commandeProd;

    private Laboratoire laboratoire;

}
