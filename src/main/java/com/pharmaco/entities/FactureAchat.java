package com.pharmaco.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
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
@Table(name = "facture_achat")
public class FactureAchat  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fact_achat", nullable = false)
    private Long idFactAchat;

    @Column(name = "date_fact_achat", nullable = false)
    private Date dateFactAchat;

    @Column(name = "total_ht", nullable = false)
    private double totalHtFactAchat;

    @Column(name = "total_ttc", nullable = false)
    private double totalTtcFactAchat;

    @Column(name = "tva", nullable = false)
    private double tva;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_fournisseur", referencedColumnName = "id_fournisseur")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    private Fournisseur fournisseur;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToMany
    @JoinTable(
            name = "facture_achat_x_produitpharma",
            joinColumns = @JoinColumn(name = "id_prd"),
            inverseJoinColumns = @JoinColumn(name = "id_fact_achat"))
    @ToString.Exclude
    private List<PharmaceuticProduct> pharmaceuticProductsList;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FactureAchat that = (FactureAchat) o;
        return idFactAchat != null && Objects.equals(idFactAchat, that.idFactAchat);
    }


    public int hashCode() {
        return getClass().hashCode();
    }

    }
