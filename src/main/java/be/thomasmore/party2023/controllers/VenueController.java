package be.thomasmore.party2023.controllers;
import be.thomasmore.party2023.model.Venue;
import be.thomasmore.party2023.repositories.VenueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

@Controller
public class VenueController {
    @Autowired
    private VenueRepository venueRepository;
    private Logger logger = LoggerFactory.getLogger(VenueController.class);

    @GetMapping({"/venuedetails/{id}","/venuedetails"})
    public String venueDetails(Model model, @PathVariable(required = false) Integer id) {
        if (id==null) return "venuedetails";
        Optional<Venue> optionalVenue = venueRepository.findById(id);
        Optional<Venue> optionalPrev = venueRepository.findFirstByIdLessThanOrderByIdDesc(id);
        Optional<Venue> optionalNext = venueRepository.findFirstByIdGreaterThanOrderById(id);
        if (optionalVenue.isPresent()) {
            model.addAttribute("venue", optionalVenue.get());
        }
        if (optionalPrev.isPresent()) {
            model.addAttribute("prev", optionalPrev.get().getId());
        } else {
            model.addAttribute("prev", venueRepository.findFirstByOrderByIdDesc().get().getId());
        }
        if (optionalNext.isPresent()) {
            model.addAttribute("next", optionalNext.get().getId());
        } else {
            model.addAttribute("next", venueRepository.findFirstByOrderByIdAsc().get().getId());
        }
        return "venuedetails";

    }

    @GetMapping({"/venuelist", "/venuelist/{something}"})
    public String venueList(Model model) {
        Iterable<Venue> allVenues = venueRepository.findAll();
        model.addAttribute("venues", allVenues);
        model.addAttribute("nrvenues",venueRepository.count());

        return "venuelist";
    }



    @GetMapping("/venuelist/filter")
    public String venueListWithFilter(Model model, @RequestParam(required = false) Integer minimumCapacity) {

        logger.info("venueListWithFilter");
        logger.info("minimumCapacity = " + minimumCapacity);
        Iterable<Venue> venues;
        if (minimumCapacity != null && minimumCapacity > 0){
            venues = venueRepository.findByCapacityIsGreaterThan(minimumCapacity);
            model.addAttribute("nrvenues",venueRepository.count());
        }
        else{
            venues = venueRepository.findAll();
            model.addAttribute("nrvenues",venueRepository.count());

        }
        model.addAttribute("venues",venues);
        model.addAttribute("showFilter", true);
        return "venuelist";
    }





    }







