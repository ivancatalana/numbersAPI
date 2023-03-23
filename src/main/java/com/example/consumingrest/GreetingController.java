package com.example.consumingrest;

import com.example.consumingrest.GreetingService;
import com.example.consumingrest.NumberFact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
    @GetMapping("/numberfact")
    public String greeting(Model model) {
        NumberFact numberFact = greetingService.getNumberFact();
        model.addAttribute("fact", numberFact);
        return "greeting";
    }
}
