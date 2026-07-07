package com.shoptony.nyano;

import com.shoptony.nyano.util.EmailSenderUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailSenderTest {

    @Autowired
    private EmailSenderUtil emailSenderUtil;

    private static final String EMAIL_HOST = "thangvo5969@gmail.com";

    @Test
    void testSendEmailText(){
        String to = "wjncm1993@gmail.com";
        String subject = "Subject Test Email Text";
        String content = "Content Text Plain";
        emailSenderUtil.sendMailWithText(to, subject, content);
    }
}
