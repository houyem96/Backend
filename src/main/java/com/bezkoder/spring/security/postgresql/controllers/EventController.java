package com.bezkoder.spring.security.postgresql.controllers;

import com.bezkoder.spring.security.postgresql.models.Evenement;
import com.bezkoder.spring.security.postgresql.repository.EventRepo;
import com.bezkoder.spring.security.postgresql.security.services.EvenementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Slf4j

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/api/event/")
public class EventController {
    @Autowired
    EvenementService evenementService;

    @GetMapping("all")
    public ResponseEntity<List<Evenement>> getall()
    {return ResponseEntity.status(200).body(evenementService.getall());}

    @PostMapping("add")
    public ResponseEntity<String> add(@RequestBody Evenement event){
        log.info("data   "+event);
        evenementService.add(event);
        return ResponseEntity.ok().body("it's created");
    }
@PutMapping("edit")
public ResponseEntity<String> edit(@RequestBody Evenement event){
    evenementService.edit(event);
    return ResponseEntity.ok().body("it's updated");
}
@DeleteMapping("{id}")
public ResponseEntity<String> delate(@PathVariable long id) {
    evenementService.delete(id);
    return ResponseEntity.ok().body("it's deleted");
}
@GetMapping("{id}")
public ResponseEntity<Evenement> getById(@PathVariable long id) {
    return ResponseEntity.ok().body(evenementService.getById(id));
}
}