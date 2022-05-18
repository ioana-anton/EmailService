package com.example.emailservice.controller;

import com.example.emailservice.DTO.EmailDTO;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class EmailSender {

    private final String PORT = "587";
    private final String HOST = "smtp.mailtrap.io";
    private final String USERNAME = "6c5d93bb2fd516";
    private final String PASSWORD = "c985025e3562fb";
    private final String EMAIL = "8c24c44aaf-c0746c@inbox.mailtrap.io";

    private final boolean AUTH = true;
    private final boolean STARTTLS = true;

    public void send(EmailDTO email) throws AddressException, MessagingException, IOException {
        Message msg = new MimeMessage(setSession(setProperties()));
        HtmlEditor editor = new HtmlEditor();

        msg.setSentDate(new Date());
        msg.setSubject("You're subscribed on newsletter");

        msg.setFrom(new InternetAddress(EMAIL, false));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getEmail()));

        String newEmailContent = editor.readHtml(email.Email);

       // msg.setContent(email.getText().concat(", you're very welcome here!"), "text/html");
        msg.setContent(newEmailContent,"text/html");

        Transport.send(msg);
    }

    private Session setSession(Properties props) {
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });
        return session;
    }

    private Properties setProperties() {
        Properties props = new Properties();

        props.put("mail.smtp.port", PORT);
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.auth", AUTH);
        props.put("mail.smtp.starttls.enable", STARTTLS);
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        return props;
    }

}
