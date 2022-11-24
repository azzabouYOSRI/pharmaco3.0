package com.pharmaco.pojos;

import lombok.*;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class LaboratoireModel  {
    private Long idLabo;

    private String libLabo;


    private List<PharmaceuticProductModel> pharmaceuticProductsListModel;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        LaboratoireModel that = (LaboratoireModel) o;
        return idLabo != null && Objects.equals(idLabo, that.idLabo);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
