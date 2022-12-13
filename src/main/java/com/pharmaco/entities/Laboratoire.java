package com.pharmaco.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "laboratoire")
public class Laboratoire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_labo", nullable = false)
    private Long idLabo;

    @Column(name ="libelle_labo", nullable = false)
    private String libelleLabo;


    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnore
    @OneToMany (mappedBy="laboratoire", fetch=FetchType.LAZY)
    @ToString.Exclude
    private List<PharmaceuticProduct> pharmaceuticProductsList;


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
//        Laboratoire that = (Laboratoire) o;
//        return idLabo != null && Objects.equals(idLabo, that.idLabo);
//    }
//
//    @Override
//    public int hashCode() {
//        return getClass().hashCode();
//    }
}
