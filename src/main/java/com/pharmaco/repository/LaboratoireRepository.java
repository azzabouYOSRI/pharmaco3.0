package com.pharmaco.repository;


import com.pharmaco.entities.Laboratoire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LaboratoireRepository extends JpaRepository<Laboratoire, Long> {

    List<Laboratoire> findByLibelleLabo(String nomLaboratoire);

}
