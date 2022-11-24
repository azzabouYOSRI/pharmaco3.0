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
public class FamilleModel  {

    private Long idFamille;

    private String libFamille;

    private List<PharmaceuticProductModel> pharmaceuticProductsListModel;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FamilleModel familleModel = (FamilleModel) o;
        return idFamille != null && Objects.equals(idFamille, familleModel.idFamille);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
