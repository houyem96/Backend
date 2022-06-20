package com.bezkoder.spring.security.postgresql.security.services;

import org.springframework.mail.javamail.JavaMailSenderImpl;
        import org.springframework.mail.javamail.MimeMessageHelper;
        import org.springframework.stereotype.Service;
        import javax.mail.MessagingException;
        import javax.mail.internet.MimeMessage;
        import java.util.Properties;

@Service
public class service_email {
    public void send_user_mail(String email,String sujet) {
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable","true");
        String host = "smtp.gmail.com";
        int port = 587;
        String userName = "reseaunationaluniversitaire@gmail.com";

        String password = "waivaudnqkufaxgz";
        String mailTo = email;
        String subject = "code verification Notification RNU";
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setJavaMailProperties(props);
        sender.setHost(host);
        sender.setPort(port);
        sender.setUsername(userName);
        sender.setPassword(password);
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper;
        try
        {
            helper = new MimeMessageHelper(message, true);
            helper.setTo(mailTo);
            helper.setSubject(subject);
            helper.setText("<i> Bonjour, </i> ,<br> <i> Merci d'avoir consulté RNU </i> <br> <h2> Ceci votre code de vérification  :  "+sujet+"</h2> <br> cordialement", true);
        } catch(
                MessagingException e)

        {
            throw new RuntimeException(e);

        }

        sender.send(message);
    }
    public void send_repReclam_mail(String email,String sujet) {
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable","true");
        String host = "smtp.gmail.com";
        int port = 587;
        String userName = "reseaunationaluniversitaire@gmail.com";

        String password = "waivaudnqkufaxgz";
        String mailTo = email;
        String subject = "Réponse de réclamation RNU";
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setJavaMailProperties(props);
        sender.setHost(host);
        sender.setPort(port);
        sender.setUsername(userName);
        sender.setPassword(password);
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper;
        try
        {
            helper = new MimeMessageHelper(message, true);
            helper.setTo(mailTo);
            helper.setSubject(subject);
            helper.setText("<i> Bonjour, </i> ,<br> <i> Merci d'avoir consulté RNU </i> <br> <h2> Votre réclamation est bien réçu et nous allons la pris en considération :  "+sujet+"</h2> <br> cordialement", true);
        } catch(
                MessagingException e)

        {
            throw new RuntimeException(e);

        }

        sender.send(message);
    }
}