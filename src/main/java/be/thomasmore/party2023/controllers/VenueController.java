package be.thomasmore.party2023.controllers;

import be.thomasmore.party2023.model.Venue;
import be.thomasmore.party2023.repositories.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

@Controller
public class VenueController {
    @Autowired
    private VenueRepository venueRepository;

    @GetMapping({"/venuedetails/{id}","/venuedetails"})
    public String venueDetails(Model model, @PathVariable(required = false) Integer id) {
        if (id == null){
            return "venuedetails";
        }

        Optional<Venue> optionalVenue = venueRepository.findById(id);
        if (optionalVenue.isPresent()) {
            model.addAttribute("venue", optionalVenue.get());
        }
        return "venuedetails";

    }

//    @GetMapping("/venuelist")
//    public String venueDetails(Model model){
//        //Iterator<Venue> allVenues = venueRepository.findAll();
//        ArrayList<Venue> someVenues = new ArrayList<>();
//        Optional<Venue> optional = venueRepository.findById(2);
//        someVenues.add(optional.get());
//        optional = venueRepository.findById(5);
//        someVenues.add(optional.get());
//        for (int i=1; i<= someVenues.size(); i++){
//            model.addAttribute("venue"+1,someVenues.get(i-1));
//        }
//        return "venuelist";
//
//    }

    @GetMapping({"/venuelist","/venuelist/outdoor/all"})
    public String venueDetails(Model model){
        Iterable<Venue> allVenues = venueRepository.findAll();
        model.addAttribute("venues",allVenues);
        return "venuelist";
        }

//        @GetMapping("venuelist/outdoor/yes")
//        public String venueListOutdoorYes(Model model){
//        Iterable<Venue> venues = venueRepository.findByOutdoor(true);
//        model.addAttribute("venues", venues);
//        return "venuelist";
//        }

    @GetMapping("venuelist/outdoor/{outdoor}")
    public String venueListOutdoorYes(Model model,@PathVariable (required = false)String outdoor){
        Iterable<Venue> venues = null;
        if (outdoor != null && outdoor.equals("all")){
            venues = venueRepository.findAll();
            model.addAttribute("filter","all");

        }else {
            boolean isOutdoor = true;
            if ( outdoor.equals("no") || outdoor.equals("false")){
                isOutdoor = false;
                venues = venueRepository.findByOutdoor(isOutdoor);
                model.addAttribute("filter",isOutdoor ? "yes" : "no");
            }
        }
        model.addAttribute("venues",venues);
        return "venuelist";
    }



    @GetMapping("/venuelist/outdoor/no")
    public String venueListOutdoorNo(Model model){
        Iterable<Venue> venues = venueRepository.findByOutdoor(false);
        model.addAttribute("venues",venues);
        return "venuelist";
    }

//    @GetMapping({"venuelist/outdoor/no","venuelist/outdoor/{outdoor}"})
//    public String venueListOutdoorNo(Model model,@PathVariable(required = false)String outdoor){
//        boolean isOutdoor = true;
//        if (outdoor.equals("no") || outdoor.equals("false")) isOutdoor = false;
//
//        Iterable<Venue> venues = venueRepository.findByOutdoor(isOutdoor);
//        model.addAttribute("venues", venues);
//        return "venuelist";
//    }






    }







