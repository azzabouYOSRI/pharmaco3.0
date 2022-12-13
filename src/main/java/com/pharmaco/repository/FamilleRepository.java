package com.pharmaco.repository;


import com.pharmaco.entities.Famille;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FamilleRepository extends JpaRepository<Famille, Long> {

        List<Famille> findByLibFamille(String libelleFamille);

}
