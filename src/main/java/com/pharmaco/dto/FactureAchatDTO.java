package com.pharmaco.dto;

import com.pharmaco.entities.Fournisseur;
import com.pharmaco.entities.PharmaceuticProduct;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class FactureAchatDTO {

    private Long idFactAchat;

    private Date dateFactAchat;

    private double totalHtFactAchat;

    private double totalTtcFactAchat;

    private double tva;

    private Fournisseur fournisseur;


    private List<PharmaceuticProduct> pharmaceuticProductsList;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FactureAchatDTO that = (FactureAchatDTO) o;
        return idFactAchat != null && Objects.equals(idFactAchat, that.idFactAchat);
    }


    public int hashCode() {
        return getClass().hashCode();
    }

    }
