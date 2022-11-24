package com.pharmaco.demo1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "famille")
public class Famille implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_famille", nullable = false)
    private java.lang.Long idFamille;

    @Column(name = "lib_famille", nullable = false)
    private java.lang.String libFamille;

    @JsonIgnore
    @OneToMany (mappedBy="famille", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @ToString.Exclude
    private List<PharmaceuticProduct> pharmaceuticProductsList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Famille famille = (Famille) o;
        return idFamille != null && Objects.equals(idFamille, famille.idFamille);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
