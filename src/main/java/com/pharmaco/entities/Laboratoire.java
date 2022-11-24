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
@Table(name = "laboratoire")
public class Laboratoire implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_labo", nullable = false)
    private Long idLabo;

    @Column(name = "lib_labo", nullable = false)
    private String libLabo;

    @JsonIgnore
    @OneToMany (mappedBy="laboratoire", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @ToString.Exclude
    private List<PharmaceuticProduct> pharmaceuticProductsList;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Laboratoire that = (Laboratoire) o;
        return idLabo != null && Objects.equals(idLabo, that.idLabo);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
