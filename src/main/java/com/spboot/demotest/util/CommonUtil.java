package com.spboot.demotest.util;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class CommonUtil {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public JavaMailSenderImpl javaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setProtocol("SMTP");
        javaMailSender.setHost("localhost");
        javaMailSender.setPort(25);

        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "false");
        javaMailSender.setJavaMailProperties(properties);

        return javaMailSender;
    }
}
