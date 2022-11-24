package com.pharmaco.demo1.repository;


import com.pharmaco.pharaco101.entities.Famille;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FamilleRepository extends JpaRepository<Famille, Long> {
    List<Famille> findAllByLibFamilleContains(String libelleFamille);
}
