package com.company.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.project.entity.Greeting;
import com.company.project.repository.GreetingRepository;

@RestController
public class HomeController {

    @Autowired
    private GreetingRepository repository;

    @PostMapping("/greetings")
    public ResponseEntity<Greeting> insertGreeting(@RequestBody Greeting g) {
        return new ResponseEntity<>(repository.save(g), HttpStatus.CREATED);
    }

    /**
     * @param id
     * @return
     */
    @GetMapping("/greetings/{id}")
    public ResponseEntity<Greeting> readGreeting(@PathVariable int id) {
        return ResponseEntity.of(repository.findById(id));
    }

    @GetMapping("/greetings")
    public ResponseEntity<List<Greeting>> readGreetings() {
        List<Greeting> list = (List<Greeting>) repository.findAll();
        return new ResponseEntity<List<Greeting>>(list, HttpStatus.OK);
    }
}
