package com.example.consumingrest;

import com.example.consumingrest.NumberFact;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;


@Service
    public class GreetingService {
        private final RestTemplate restTemplate;

        public GreetingService(RestTemplateBuilder restTemplateBuilder) {
            this.restTemplate = restTemplateBuilder.build();
        }

        public NumberFact getNumberFact() {
            int random = ThreadLocalRandom.current().nextInt(1900, 2023);
            HttpHeaders headers = new HttpHeaders();
            headers.set("X-RapidAPI-Key", "34cdaaf2d4msh08a679703742c37p1a73a2jsn998b670a21ab");
            headers.set("X-RapidAPI-Host", "numbersapi.p.rapidapi.com");
            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<NumberFact> responseEntity = restTemplate.exchange(
                    "https://numbersapi.p.rapidapi.com/"+random+"/year?fragment=true&json=true",
                    HttpMethod.GET,
                    entity,
                    NumberFact.class
            );
            NumberFact numberFact = responseEntity.getBody();
            return numberFact;

    }

}
