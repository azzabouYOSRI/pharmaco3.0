package com.pharmaco.services;

import com.pharmaco.entities.CommandeProd;
import com.pharmaco.entities.Utilisateur;
import com.pharmaco.repository.CommandeProdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CommandServices {

    private final CommandeProdRepository commandRepository;

    @Autowired
    public CommandServices(CommandeProdRepository commandRepository) {
        this.commandRepository = commandRepository;
    }

    @Transactional
    public CommandeProd saveCommand(CommandeProd command){
        commandRepository.save(command);
        return command;
    }
    @Transactional
    public String deleteCommand(CommandeProd command){
        commandRepository.delete(command);
        return "sucessfully deleted";
    }
     @Transactional
    public CommandeProd findCommandeProdById(Long id) {
        Optional<CommandeProd> optionalCommandeProd = commandRepository.findById(id);
        return optionalCommandeProd.orElse(new CommandeProd());
    }


    @Transactional
    public List<CommandeProd> findAllCommand(){
        return commandRepository.findAll();
    }

}
