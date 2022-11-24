package com.pharmaco.demo1.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
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
    private String telUtil;

    @Column(name = "password_util",nullable = false)
    private String passwordUtil;


    @Column(name = "datenaisaance_util", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaisaanceUtil;

    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToMany
    @JoinTable(
            name = "pp_x_user",
            joinColumns = @JoinColumn(name = "id_prd"),
            inverseJoinColumns = @JoinColumn(name = "id_utilisateur"))
    @ToString.Exclude
    @Nullable
    private List<PharmaceuticProduct> pharmaceuticProductsList;

    @NotFound(action = NotFoundAction.IGNORE)
    @OneToMany (mappedBy="utilisateur", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @ToString.Exclude
    private List<Fournisseur> fournisseurList;


    @Column(name = "priveledge",nullable = false)
    private int priveldege;
}
