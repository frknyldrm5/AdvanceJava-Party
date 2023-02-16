package be.thomasmore.party2023.controllers;

import be.thomasmore.party2023.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public abstract class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping({"/client"})
    public String client(Model model) {
        return "client";
    }

    public abstract String generateClientCode();





}
