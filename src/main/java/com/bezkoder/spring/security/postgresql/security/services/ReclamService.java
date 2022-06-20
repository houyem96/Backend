package com.bezkoder.spring.security.postgresql.security.services;

import com.bezkoder.spring.security.postgresql.models.Evenement;
import com.bezkoder.spring.security.postgresql.models.Reclamation;
import com.bezkoder.spring.security.postgresql.repository.ReclamationRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ReclamService {
  @Autowired
  service_email service_email;
    private final ReclamationRepo reclamationRepo;

    public List<Reclamation> getall(){ return reclamationRepo.findAll();}

    public void add(Reclamation reclam){
        reclamationRepo.save(reclam);}

    public void edit(Reclamation reclam){

        reclamationRepo.save(reclam);}

    public void delete(long id){reclamationRepo.deleteById(id);}

    public Reclamation getById (long id)
    {
        return
                reclamationRepo.getOne(id);
    }
    public void  send_RepReclamation(String email,String reponse)
    {
        service_email.send_repReclam_mail(email,reponse);
    }


}
