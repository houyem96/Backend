package com.bezkoder.spring.security.postgresql.security.services;

import com.bezkoder.spring.security.postgresql.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class service_logic {
    private final UserRepository userRepository;
    private final service_email service_email;

    public boolean Verif_user_byemail(String email){
        log.info("email     "+email);
        return userRepository.existsByEmail(email);
    }
    public String code_verification(String email)
    {
        String code ="user not found";

        if(Verif_user_byemail (email)){
            code= UUID.randomUUID().toString().substring(0,6);
            service_email.send_user_mail(email,code);
        }
        return  code;
    }


}
