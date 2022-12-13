package com.pharmaco.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "utilisateur")
@Builder
@RequiredArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Utilisateur implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utilisateur", nullable = false)
    private Long id;


    @Column(name = "nom_util", nullable = false)
    private String nomUtil;


    @Column(name = "prenom_util", nullable = false)
    private String prenomUtil;


    @Column(name = "Adresse_util", nullable = false)
    private String adresseUtil;


    @Column(name = "email_util", nullable = false)
    private String emailUtil;


    @Column(name = "codepostal_util",nullable = false)
    private int codePostalUtil;

    @Column(name = "tel_util",nullable = false)
    private int telUtil;

    @Column(name = "password_util",nullable = false)
    private String passwordUtil;


    @Column(name = "datenaisaance_util", nullable = true)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateNaisaanceUtil;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "pp_x_user",
            joinColumns = @JoinColumn(name = "id_prd"),
            inverseJoinColumns = @JoinColumn(name = "id_utilisateur"))
    @ToString.Exclude
    @Nullable
    private List<PharmaceuticProduct> pharmaceuticProductsList;

    @JsonIgnore

    @OneToMany (mappedBy="utilisateur", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @ToString.Exclude
    private List<Fournisseur> fournisseurList;


    @Column(name = "priveledge",nullable = false)
    private int priveldege;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_naissance", nullable = false)
    private Date dateNaissance;

}
