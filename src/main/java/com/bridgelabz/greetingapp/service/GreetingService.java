package com.bridgelabz.greetingapp.service;
import java.util.List;
import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.repository.GreetingRepository;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    private final GreetingRepository repository;
    public List<Greeting> getAllGreetings() {
        return repository.findAll();
    }
    public GreetingService(GreetingRepository repository) {
        this.repository = repository;
    }

    public Greeting saveGreeting(String message) {
        Greeting greeting = new Greeting(message);
        return repository.save(greeting);
    }

    public Greeting getGreetingById(Long id) {
        return repository.findById(id).orElse(null);
    }
}