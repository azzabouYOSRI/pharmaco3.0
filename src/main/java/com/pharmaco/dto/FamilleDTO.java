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
public class FamilleDTO {

    private Long idFamille;

    private String libFamille;

    private List<PharmaceuticProduct> pharmaceuticProductsListModel;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FamilleDTO familleDTO = (FamilleDTO) o;
        return idFamille != null && Objects.equals(idFamille, familleDTO.idFamille);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
