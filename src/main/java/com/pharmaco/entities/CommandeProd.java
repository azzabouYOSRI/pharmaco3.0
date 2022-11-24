package com.pharmaco.demo1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "commande_prod")
public class CommandeProd implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_commande_prod", nullable = false)
    private Long idCommandeProd;

    @Column(name ="quantite_fourni", nullable = false)
    private Integer quantityFourn;

    @Column(name = "date_fourni", nullable = false)
    private Date dateFourni;

    @JsonIgnore
    @OneToMany (mappedBy="commandeProd", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @ToString.Exclude
    private List<PharmaceuticProduct> pharmaceuticProductsList;

    @JsonIgnore
    @OneToMany(mappedBy = "commandeProd", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Fournisseur> fournisseurList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CommandeProd that = (CommandeProd) o;
        return idCommandeProd != null && Objects.equals(idCommandeProd, that.idCommandeProd);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
