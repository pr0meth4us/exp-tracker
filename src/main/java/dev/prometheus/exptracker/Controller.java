package dev.prometheus.exptracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class Controller {
    private Repository repository;
    private static List<Model> DB = new ArrayList<>();

    @Autowired
    public Controller(Repository repository) {
        this.repository = repository;
    }

    @PostMapping(value = "/exp", consumes = "application/json")
    public ResponseEntity<String> addExp(@RequestBody Model model) {
        repository.save(model);
        return new ResponseEntity<>("Added", HttpStatus.CREATED);
    }


    @GetMapping("/exp")
    public ResponseEntity<?> getAllExp() {

        List<Model> models = repository.findAll();

        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @GetMapping(path = "/exp/{date}")
    public ResponseEntity<?> getExpInfoByDate(@PathVariable("date") String date) {
        Optional<Model> model = repository.findById(date);
        if (model.isPresent()) {
            return new ResponseEntity<>(model.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Person not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/inc")
    public String addIncome ( @RequestBody Model model) {
        repository.save(model);
        return "Added";
    }

    @GetMapping("/inc")
    public ResponseEntity<?> getIncInfo() {

        List<Model> models = repository.findAll();

        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    @GetMapping(path = "/inc/{date}")
    public ResponseEntity<?> getIncInfoByDate(@PathVariable("date") String date) {
        Optional<Model> model = repository.findById(date);
        if (model.isPresent()) {
            return new ResponseEntity<>(model.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Person not found", HttpStatus.NOT_FOUND);
        }
    }



}