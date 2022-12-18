package com.pharmaco.controller;

import com.pharmaco.entities.CommandeProd;
import com.pharmaco.entities.FactureAchat;
import com.pharmaco.services.CommandServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/commande")
public class CommandController {
    private final CommandServices commandServices;

    @Autowired
    public CommandController(CommandServices commandServices) {
        this.commandServices = commandServices;
    }

      @GetMapping("/all")
    public List<CommandeProd> getAllCommandeProd() {
        return commandServices.findAllCommand();
    }

    @GetMapping("/findCommandeProdById/{id}")
    public CommandeProd findFactureAchatById(@PathVariable Long id) {
        return commandServices.findCommandeProdById(id);
    }

}
