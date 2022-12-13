
package com.pharmaco.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author yosriazabou
 */
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "pharmaceutic_product")
public class PharmaceuticProduct implements Serializable {


 @JsonIgnore
 @ManyToMany(mappedBy = "pharmaceuticProductsList")
  @ToString.Exclude
   private List<Utilisateur> utilisateurList;

    @JsonIgnore
    @ManyToMany(mappedBy = "pharmaceuticProductsList")
    @ToString.Exclude
    private List<FactureAchat> factureAchatList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prd", nullable = false)
    private Long idPrd;

    @Column(name ="lib_prd", nullable = false)
    private String libPrd;

    @Column(name = "prix_prd", nullable = false)
    private double prixPrd;

    @Column(name = "description_prd", nullable = false)
    private String descriptionPrd;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_ajout_prd", nullable = false)
    private Date dateAjoutPrd;

    @Column(name = "prix_livraison", nullable = false)
    private double prixLivraison;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "id_famille", referencedColumnName = "id_famille")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    private Famille famille;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = CommandeProd.class)
    @JoinColumn(name = "id_commande_prod", referencedColumnName = "id_commande_prod")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    private CommandeProd commandeProd;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "id_labo", referencedColumnName = "id_labo")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    private Laboratoire laboratoire;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PharmaceuticProduct that = (PharmaceuticProduct) o;
        return idPrd != null && Objects.equals(idPrd, that.idPrd);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
