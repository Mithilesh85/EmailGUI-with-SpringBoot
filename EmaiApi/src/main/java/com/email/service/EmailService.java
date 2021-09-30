package com.email.service;

import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



import java.util.Properties;

@Service
public class EmailService {

    public boolean sendEmail(String message,String subject ,String to)
    {
        boolean f=false;
//        char a[]={'m','e','r','i','c','h','k','i'};
        String from="smpilusm@gmail.com";
        String host="smtp.gmail.com";
        Properties properties=System.getProperties();
        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("smpilusm@gmail.com","merichiki");

            }
        });
        session.setDebug(true);

        MimeMessage m = new MimeMessage(session);
        try {
            m.setFrom(from);
            m.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            m.setSubject(subject);
            m.setText(message);
            Transport.send(m);
            System.out.println("successfully sent");
            f=true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
      return f;


    }
    }

