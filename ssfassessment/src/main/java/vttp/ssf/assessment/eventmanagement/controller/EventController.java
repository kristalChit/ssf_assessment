package vttp.ssf.assessment.eventmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vttp.ssf.assessment.eventmanagement.repositories.RedisRepo;

@Controller
@RequestMapping("listing")
public class EventController {

    @GetMapping("/eventListing")
   
    @Autowired
	DatabaseService pizzaService;
    
    @GetMapping
    public String EventLists(Model model) {
        model.addAttribute("register", new register());
        return "listing";
    }
}

//Task5
// Write function named displayEvents request handler to process the HTTP GET request made by view0.html from Task4 to display the list of events
