package com.example.consumingrest;

import com.example.consumingrest.GreetingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Controller
public class NumberFactController {
    private final GreetingService greetingService;

    public NumberFactController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/numberfact2")
    public String numberfact(Model model) throws IOException {
        NumberFact  numberFact = greetingService.getNumberFact();
        model.addAttribute("fact", numberFact);
        model.addAttribute("img_url", "https://source.unsplash.com/random");
        return "numberfact";
    }
}
