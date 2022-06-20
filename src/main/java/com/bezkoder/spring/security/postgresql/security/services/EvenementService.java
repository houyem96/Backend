package com.bezkoder.spring.security.postgresql.security.services;

import com.bezkoder.spring.security.postgresql.models.Evenement;
import com.bezkoder.spring.security.postgresql.repository.EventRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class EvenementService {
    private final EventRepo eventRepo;

    public List<Evenement> getall(){ return eventRepo.findAll();}

    public void add(Evenement event)
    {event.setCreatedOn(Instant.now());
        event.setUpdatedOn(Instant.now());
        eventRepo.save(event);}

    public void edit(Evenement event){
        event.setUpdatedOn(Instant.now());
        eventRepo.save(event);}
    public void delete(long id){eventRepo.deleteById(id);}

    public Evenement getById (long id)
    {
        return
        eventRepo.getOne(id);
    }

}
