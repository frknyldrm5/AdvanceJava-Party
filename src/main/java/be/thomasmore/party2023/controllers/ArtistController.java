package be.thomasmore.party2023.controllers;

import be.thomasmore.party2023.model.Artist;
import be.thomasmore.party2023.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class ArtistController {
    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping("/artistlist")
    public String venueDetails(Model model){
        Iterable<Artist> allArtist = artistRepository.findAll();
        model.addAttribute("artist",allArtist);
        return "artistlist";
    }

    @GetMapping({"/artistdetails/{id}","/artistdetails"})
    public String artistDetails(Model model, @PathVariable(required = false) Integer id) {
        if (id == null){
            return "artistdetails";
        }

        Optional<Artist> optionalArtist = artistRepository.findById(id);
        if (optionalArtist.isPresent()) {
            model.addAttribute("artist", optionalArtist.get());
        }
        return "artistdetails";

    }
}
