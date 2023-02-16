package be.thomasmore.party2023.controllers;

import be.thomasmore.party2023.model.Venue;
import be.thomasmore.party2023.repositories.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class VenueController {
    @Autowired
    private VenueRepository venueRepository;

    @GetMapping("/venuedetails")
    public String venueDetails(Model model) {
        //        Venue venue = new Venue("De Roma", "http://www.deroma.be");
        //        venue.setCapacity(2000);
       //        venue.setFoodProvided(true);
       //        venue.setIndoor(true);
      //        venue.setOutdoor(false);
      //        venue.setFreeParkingAvailable(false);
      //        venue.setDistanceFromPublicTransportInKm(1.0);
       //        venue.setCity("Antwerpen");

        Optional<Venue> optionalVenue = venueRepository.findById(1);
        if (optionalVenue.isPresent()) {
            model.addAttribute("venue", optionalVenue.get());
        }
        return "venuedetails";

    }


}


