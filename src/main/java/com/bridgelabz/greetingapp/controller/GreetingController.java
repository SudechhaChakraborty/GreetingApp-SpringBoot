package com.bridgelabz.greetingapp.controller;
import java.util.*;
import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.service.GreetingService;
import org.springframework.web.bind.annotation.*;
@RestController
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @PostMapping("/greeting")
    public Greeting saveGreeting(@RequestBody Greeting greeting) {
        return greetingService.saveGreeting(greeting.getMessage());
    }

    @GetMapping("/greeting/{id}")
    public Greeting getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }
    @GetMapping("/greetings")
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }
    @PutMapping("/greeting/{id}")
    public Greeting updateGreeting(@PathVariable Long id, @RequestBody Greeting greeting) {

        return greetingService.updateGreeting(id, greeting.getMessage());
    }
}