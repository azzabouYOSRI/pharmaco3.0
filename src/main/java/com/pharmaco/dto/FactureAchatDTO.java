package com.pharmaco.pojos;

import lombok.*;
import org.hibernate.Hibernate;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class FactureAchatModel  {

    private Long idFactAchat;

    private Date dateFactAchat;

    private double totalHtFactAchat;

    private double totalTtcFactAchat;

    private double tva;

    private FournisseurModel fournisseurModel2;


    private FournisseurModel fournisseurModel;


    private List<PharmaceuticProductModel> pharmaceuticProductsListModel;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FactureAchatModel that = (FactureAchatModel) o;
        return idFactAchat != null && Objects.equals(idFactAchat, that.idFactAchat);
    }


    public int hashCode() {
        return getClass().hashCode();
    }

    }
