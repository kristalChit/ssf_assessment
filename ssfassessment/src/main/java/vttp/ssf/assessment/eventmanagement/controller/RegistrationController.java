package vttp.ssf.assessment.eventmanagement.controller;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import sg.edu.nus.iss.ssfassessment.service.DatabaseService;

@Controller
@RequestMapping("/register")

public class RegistrationController {

	@Autowired
	DatabaseService pizzaService;
    
    @GetMapping
    public String getRegsiterForm(Model model) {
        model.addAttribute("register", new register());
        return "listing";
    }

    @PostMapping(path = "/register", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String postRegistration(@Valid (@Valid Event event, BindingResult result, HttpSession sess, Model model) {
        if (result.hasErrors()){
			System.out.println("Error Found");
			return "register";
		}

		sess.setAttribute("event", event);
		
        model.addAttribute("RegisterDetails", new RegisterDetails());
		return "register";

	}
    
    @PostMapping(path = "/success", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE })
    public String registerSuccess(@Valid registerDetails details, BindingResult result, HttpSession sess, Model model) {
        System.out.println(event.getRegister().toString());
        System.out.println(event.toString());
    
        if (result.hasErrors()){
			System.out.println("Error found");
			return "register";
		}

		Event thisEvent = (Event) sess.getAttribute("event");
		Double totalTickets=eventService.calculateNum(thisEvent, details);
		String uuid=databaseService.generateUUID();
		EventRepo.addRegisterinJson(thisEvent, details, uuid, totalTickets);


		model.addAttribute("fullName", fullName);
		model.addAttribute("birthdate", birthdate);
		model.addAttribute("email", email);
		model.addAttribute("mobileNo", mobileNo);
		model.addAttribute("ticketsNum", ticketsNum);
        model.addAttribute("Controlleruuid", uuid);
		
		return "success";

	}
}

//Task6
//Write function named register request handler to process HTTP GET request made by view0.html from Task5 to display view1.html

//Task7
//Write function named processRegisteration request handler to process the HTTP POST request made by view1.html from Task6
//Should check for form validation in Task6
//serverside validation: 1. can only register if above 21y.o 2. Registeration fails when the sum of total tickets requested 
//and participants count (participants attribute) exceeded the max event size can hold (eventSize attribute). 
//On successful registeration, partipants attribute should increment for the registered event acct to number of tickets requested