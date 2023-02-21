package be.thomasmore.party2023.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.DayOfWeek;
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
        now = now.plusDays(5);
        if (now.getDayOfWeek()==DayOfWeek.SATURDAY || now.getDayOfWeek()== DayOfWeek.SUNDAY) {
            model.addAttribute("weekend", true);
        } else {
            model.addAttribute("weekend", false);
        }
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        model.addAttribute("now", now.format(format));
        model.addAttribute("paydate", now.plusDays(30).format(format));
        return "pay";
    }








}
