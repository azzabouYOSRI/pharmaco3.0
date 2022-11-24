package com.pharmaco.demo1.repository;


import com.pharmaco.pharaco101.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Date;
import java.util.List;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

      public List<Utilisateur> findUtilisateurByNomUtil( String nom);
      public List<Utilisateur> findUtilisateurByPrenomUtil( String prenom);
        public List<Utilisateur> findUtilisateurByNomUtilAndPrenomUtil( String nom, String prenom);
        public List <Utilisateur> findUtilisateurByEmailUtil( String email);
        public List <Utilisateur> findUtilisateurByTelUtil( String tel);
       public  List <Utilisateur> findUtilisateurByCodePostalUtil(int codepostal);
       public List <Utilisateur> findUtilisateurByAdresseUtil(String adresse);
         public List <Utilisateur> findUtilisateurBydateNaisaanceUtil(Date dateNaisaance);
        public List <Utilisateur> findUtilisateurByPriveldege(int priveldege);






      Utilisateur findUserById(Long id);

}
