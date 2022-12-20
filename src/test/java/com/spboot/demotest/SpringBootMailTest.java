package com.spboot.demotest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.subethamail.wiser.Wiser;
import org.subethamail.wiser.WiserMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

@SpringBootTest
public class SpringBootMailTest {

    private JavaMailSender javaMailSender;
    private Wiser wiser;

    private final String userTo = "user2@localhost";
    private final String userFrom = "user1@localhost";
    private final String subject = "Test subject";
    private final String textMail = "Text subject mail";

    @BeforeEach
    public void setUp() throws Exception {
        JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
        javaMailSenderImpl.setHost("localhost");
        javaMailSenderImpl.setPort(25);

        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "false");
        javaMailSenderImpl.setJavaMailProperties(properties);
        javaMailSender = javaMailSenderImpl;

        final int TEST_MAIL_PORT = 25;
        wiser = new Wiser(TEST_MAIL_PORT);
        wiser.start();
    }

    @AfterEach
    public void tearDown() throws Exception {
        wiser.stop();
    }

    @Test
    public void givenMail_whenSendAndReceived_thenCorrect() throws Exception {
        SimpleMailMessage message = composeEmailMessage();
        javaMailSender.send(message);
        List<WiserMessage> messages = wiser.getMessages();

        assertThat(messages, hasSize(1));
//        WiserMessage wiserMessage = messages.get(0);
//        assertEquals(userFrom, wiserMessage.getEnvelopeSender());
//        assertEquals(userTo, wiserMessage.getEnvelopeReceiver());
//        assertEquals(subject, getSubject(wiserMessage));
//        assertEquals(textMail, getMessage(wiserMessage));
    }

    private SimpleMailMessage composeEmailMessage() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(userTo);
        mailMessage.setReplyTo(userFrom);
        mailMessage.setFrom(userFrom);
        mailMessage.setSubject(subject);
        mailMessage.setText(textMail);
        return mailMessage;
    }

    private String getMessage(WiserMessage wiserMessage)
            throws MessagingException, IOException {
        return wiserMessage.getMimeMessage().getContent().toString().trim();
    }

    private String getSubject(WiserMessage wiserMessage) throws MessagingException {
        return wiserMessage.getMimeMessage().getSubject();
    }
}
