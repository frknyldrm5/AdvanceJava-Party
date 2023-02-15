package be.thomasmore.party2023.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller

public class HomeController {
    @GetMapping({"/","/home"})
    public String home(Model model) {
        final int calculatedValue=45*34;
        model.addAttribute("myCalculatedValue", calculatedValue);
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        final String name ="Furkan";
        final String street ="Smedenstraat";
        final String city ="Wilrijk";
        model.addAttribute("street",street);
        model.addAttribute("name",name);
        model.addAttribute("city",city);
        return "about";
    }

    @GetMapping("/pay")
    public String pay(Model model) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formatDateTime = now.format(format);
        LocalDateTime after=now.plusDays(30);
        String formatDateTimeAfter=after.format(format);
        model.addAttribute("formatDateTime",formatDateTime);
        model.addAttribute("formatDateTimiAfter",formatDateTimeAfter);
        return "pay";
    }








}
