package be.thomasmore.party2023.controllers;

import be.thomasmore.party2023.model.Client;
import be.thomasmore.party2023.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/greetings")
    public String greetingNewClient(Model model) {

        Optional<Client> optionalClient = clientRepository.findById(1);

        if (optionalClient.isPresent()) {
            model.addAttribute("client", optionalClient.get());

        }

        String dateTime;
        LocalDateTime date = LocalDateTime.now();

        if (date.getHour() < 12) {
            dateTime = "Goedemorgen";
        } else if (date.getHour() >= 12 && date.getHour() < 17) {
            dateTime = "Goedemiddag";
        } else {
            dateTime = "Goedenavond";
        }
        model.addAttribute("dateTime", dateTime);


        return "client";


    }

    }
