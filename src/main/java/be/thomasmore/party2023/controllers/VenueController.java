package be.thomasmore.party2023.controllers;

import be.thomasmore.party2023.model.Venue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VenueController {
    @GetMapping("/venuedetails")
    public String venueDetails( Model model){
        Venue venue = new Venue("De Roma","http://www.deroma.be");
        model.addAttribute("venue",venue);
        return "venuedetails";
    }

}


