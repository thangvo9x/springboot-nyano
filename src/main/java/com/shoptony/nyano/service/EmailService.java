package com.shoptony.nyano.service;

import com.shoptony.nyano.entity.email.EmailEntity;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {

    void sendEmailWithText(EmailEntity emailEntity);
    void sendEmailByTemplate(EmailEntity emailEntity) throws MessagingException;
    void sendEmailByAttachment(EmailEntity emailEntity);
}
