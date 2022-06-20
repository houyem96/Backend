package com.bezkoder.spring.security.postgresql.controllers;

import com.bezkoder.spring.security.postgresql.models.Evenement;
import com.bezkoder.spring.security.postgresql.models.Reclamation;
import com.bezkoder.spring.security.postgresql.security.services.ReclamService;
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
@RequestMapping("/api/reclam/")
public class ReclamationController {

    @Autowired
    ReclamService reclamService;

    @GetMapping("all")
    public ResponseEntity<List<Reclamation>> getall()
    {return ResponseEntity.status(200).body(reclamService.getall());}

    @PostMapping("add")
    public ResponseEntity<String> add(@RequestBody Reclamation reclam){
        log.info("data   "+reclam);
        reclamService.add(reclam);
        return ResponseEntity.ok().body("it's created");
    }
    @PutMapping("edit")
    public ResponseEntity<String> edit(@RequestBody Reclamation reclam){
        reclamService.edit(reclam);
        return ResponseEntity.ok().body("it's updated");
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delate(@PathVariable long id) {
        reclamService.delete(id);
        return ResponseEntity.ok().body("it's deleted");
    }
    @GetMapping("{id}")
    public ResponseEntity<Reclamation> getById(@PathVariable long id) {
        return ResponseEntity.ok().body(reclamService.getById(id));
    }

    @PostMapping("reponse")
    public ResponseEntity<String> reponse(@RequestParam("email") String email,@RequestParam("reponse" )String reponse)
    {
        reclamService.send_RepReclamation(email,reponse);
        return ResponseEntity.ok().body("reponse envoyée");
    }
}
