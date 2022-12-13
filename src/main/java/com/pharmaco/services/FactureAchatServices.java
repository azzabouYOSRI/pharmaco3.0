package com.pharmaco.services;

import com.pharmaco.entities.FactureAchat;
import com.pharmaco.entities.PharmaceuticProduct;
import com.pharmaco.repository.FactureAchatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class FactureAchatServices
{

    private final FactureAchatRepository factureAchatRepository;

    @Autowired
    public FactureAchatServices(FactureAchatRepository factureAchatRepository) {
        this.factureAchatRepository = factureAchatRepository;
    }

    @Transactional
    public FactureAchat saveFactureAchat(FactureAchat factureAchat)
    {
        factureAchatRepository.save(factureAchat);
        return factureAchat;
    }

    @Transactional
    public String deleteFactureAchat(FactureAchat factureAchat)
    {
        factureAchatRepository.delete(factureAchat);
        return "sucessfully deleted";
    }

    @Transactional
    public FactureAchat findFactureAchatById(Long idFactAchat)
    {
        return factureAchatRepository.findByIdFactAchat(idFactAchat).get(0);
    }

    @Transactional
    public List<FactureAchat> findFactureAchatByFournisseurId(Long idFournisseur)
    {
        return factureAchatRepository.findByFournisseurIdFournisseur(idFournisseur);
    }

    @Transactional
    public List<FactureAchat> findFactureAchatByDateFactAchat(Date dateFactAchat)
    {
        return factureAchatRepository.findByDateFactAchat(dateFactAchat);
    }

    @Transactional
    public List<FactureAchat> findFactureAchatByTotalHtFactAchat(double totalHtFactAchat)
    {
        return factureAchatRepository.findByTotalHtFactAchat(totalHtFactAchat);
    }

    @Transactional
    public List<FactureAchat> findFactureAchatByTotalTtcFactAchat(double totalTtcFactAchat)
    {
        return factureAchatRepository.findByTotalTtcFactAchat(totalTtcFactAchat);
    }

    @Transactional
    public List<FactureAchat> findFactureAchatByTva(double tva)
    {
        return factureAchatRepository.findByTva(tva);
    }

    @Transactional
    public List<FactureAchat> findAllFactureAchat()
    {
        return factureAchatRepository.findAll();
    }

    @Transactional
    public List<List<PharmaceuticProduct>> findprdbyfacture(Long id){

        return         factureAchatRepository
                .findAll()
                .stream()
                .filter(x-> Objects.equals(x.getIdFactAchat(), id))
                .map(FactureAchat::getPharmaceuticProductsList)
                .collect(Collectors.toList());
    }


}
