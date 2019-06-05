package com.example.mailexmpl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
public class MailController {


    @Autowired
    JavaMailSender javaMailSender;

    private final Logger LOGGER = LoggerFactory.getLogger(MailController.class);


    @GetMapping("mail/send")
    public String sendMail(){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("zied.ayedi22@gmail.com");
        mailMessage.setSubject("BLA BLA BLA");
        mailMessage.setText("bla bla bla");

        Boolean isSent = false;
        try
        {
            javaMailSender.send(mailMessage);
            isSent = true;
        }
        catch (Exception e) {
            LOGGER.error("Sending e-mail error: {}", e.getMessage());
        }
        return "Email sent";
    }
}
