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
        return "venuelist";
    }







//        @GetMapping("venuelist/outdoor/yes")
//        public String venueListOutdoorYes(Model model){
//        Iterable<Venue> venues = venueRepository.findByOutdoor(true);
//        model.addAttribute("venues", venues);
//        return "venuelist";
//        }
//
//    @GetMapping("/venuelist/outdoor/no")
//    public String venueListOutdoorNo(Model model){
//        Iterable<Venue> venues = venueRepository.findByOutdoor(false);
//        model.addAttribute("venues",venues);
//        return "venuelist";
//    }

    @GetMapping({"/venuelist/outdoor/{outdoor}","/venuelist/outdoor"})
    public String venueListOutdoorYes(Model model,@PathVariable (required = false)String outdoor){
        Iterable<Venue> venues ;
        if (outdoor != null && outdoor.equals("all")){
            venues = venueRepository.findAll();
            model.addAttribute("filter","all");

        }else {
            boolean isOutdoor = true;
            if (outdoor!=null && (outdoor.equals("no") || outdoor.equals("false"))) {
                isOutdoor = false;
            }
                venues = venueRepository.findByOutdoor(isOutdoor);
                model.addAttribute("filter",isOutdoor ? "yes" : "no");
        }
        model.addAttribute("venues",venues);
        return "venuelist";
    }

    @GetMapping({"/venuelist/indoor/{indoor}","/venuelist/indoor"})
    public String venueListIndoor(Model model,@PathVariable (required = false) String indoor){
        Iterable<Venue> venues ;
        if (indoor != null && indoor.equals("all")){
            venues = venueRepository.findAll();
            model.addAttribute("filter","all");
        }
        else {
            boolean isIndoor = true;
            if (indoor != null && (indoor.equals("no") || indoor.equals("false"))) {
                isIndoor =false;
            }
            venues = venueRepository.findByIndoor(isIndoor);
            model.addAttribute("filter",isIndoor ? "yes" : "no");
        }
        model.addAttribute("venues",venues);
        return "venuelist";
    }


    @GetMapping({"venuelist/size/{filter}","venuelist/size"})
    public String venueListSize(Model model,@PathVariable(required = false) String filter){
        if(filter == null){
            filter = "all";
        }

        if (filter.equals("s")) {
            filter = "S"; }

        if (filter.equals("m")) {
            filter = "M"; }

        if (filter.equals("l")) {
            filter = "L"; }

        if (!filter.equals("S") && !filter.equals("M") && !filter.equals("L")){
            filter = "all";}

        Iterable<Venue> venues;
        if (filter.equals("all")) {
            venues = venueRepository.findAll();
        } else if (filter.equals("S")) {
            venues = venueRepository.findByCapacityLessThanEqual(200);
        } else if (filter.equals("M")) {
            venues = venueRepository.findByCapacityIsBetween(200, 500);
        } else {
            venues = venueRepository.findByCapacityIsGreaterThan(500);
        }
        model.addAttribute("sizeFilter", filter);
        model.addAttribute("venues", venues);
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

//    @GetMapping({"/venuelist","/venuelist/{word}","/venuelist/{word}"})
//    public String venueDetails(Model model,@PathVariable(required = false)String word){
//        Iterable<Venue> allVenues = venueRepository.findAll();
//        model.addAttribute("venues",allVenues);
//        return "venuelist";
//    }
















    }







