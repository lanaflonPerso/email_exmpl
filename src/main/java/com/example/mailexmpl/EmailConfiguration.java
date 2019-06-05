package com.example.mailexmpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailConfiguration {


    @Autowired
    private Environment env;

    @Bean
    public JavaMailSender mailSender()


    {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(env.getProperty("email.host"));
        javaMailSender.setPort(Integer.parseInt(env.getProperty("email.port")));


        javaMailSender.setUsername(env.getProperty("email.username"));
        javaMailSender.setPassword(env.getProperty("email.password"));

        Properties properties = javaMailSender.getJavaMailProperties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.debug", true);
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        return javaMailSender;
    }
}
