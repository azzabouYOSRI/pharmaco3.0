package com.pharmaco.demo1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
@Table(name = "fournisseur")
public class Fournisseur  implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fournisseur", nullable = false)
    private Long idFournisseur;


    @Column(name = "nom_fournisseur", nullable = false)
    private String nomFournisseur;

    @Column(name="Adresse_fournisseur", nullable = false)
    private String adresseFournisseur;

    @Column(name = "email_fournisseur", nullable = false)
    private String emailFournisseur;

    @Column(name = "tel_fournisseur", nullable = false)
    private int telFournisseur;

    @JsonIgnore
    @OneToMany(mappedBy = "fournisseur", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<FactureAchat> factureAchatList;




    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY,optional = true)
    @JoinColumn(name = "id_commande_prod", referencedColumnName = "id_commande_prod")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CommandeProd commandeProd;

//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id_utilisateur")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Utilisateur utilisateur;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Fournisseur that = (Fournisseur) o;
        return idFournisseur != null && Objects.equals(idFournisseur, that.idFournisseur);
    }



    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
