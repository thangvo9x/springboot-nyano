package com.shoptony.nyano.service.impl;

import com.shoptony.nyano.entity.email.EmailEntity;
import com.shoptony.nyano.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    private static final String EMAIL_HOST = "thangvo5969@gmail.com";

    @Override
    public void sendEmailWithText(EmailEntity email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email.getEmailTo());
        message.setSubject(email.getEmailSubject());
        message.setText(email.getEmailContent());
        message.setFrom(EMAIL_HOST);

        try {
            javaMailSender.send(message);
            System.out.println("Email sent with Text Successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendEmailByTemplate(EmailEntity email) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        helper.setTo(email.getEmailTo());
        helper.setSubject(email.getEmailSubject());
        helper.setText(email.getEmailContent(), true);
        helper.setFrom(EMAIL_HOST);

        try {
            javaMailSender.send(message);
            System.out.println("Email sent by Template Successfully");
        } catch (MailException e) {
            // Handle SMTP connectivity or authentication errors
            throw new RuntimeException("SMTP delivery failed for: " + email.getEmailTo(), e);
        }
    }

    @Override
    public void sendEmailByAttachment(EmailEntity email) {

    }
}
