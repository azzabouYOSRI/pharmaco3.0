package com.pharmaco.dto;

import com.pharmaco.entities.PharmaceuticProduct;
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
public class LaboratoireDTO {
    private Long idLabo;

    private String libLabo;


    private List<PharmaceuticProduct> pharmaceuticProductsListModel;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        LaboratoireDTO that = (LaboratoireDTO) o;
        return idLabo != null && Objects.equals(idLabo, that.idLabo);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
