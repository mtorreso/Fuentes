/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author torre
 */
public class SendMail {

    public static void send(String m, String sub, String messg) {

       // final String user = "alejandro.torresolivos@gmail.com";
        final String user = "turismorealduoc@gmail.com";

       // final String pass = "21101992";
        final String pass = "portafolio";

        Properties props = new Properties();

        props.put("mail.transport.protocol", "smtp");

        props.put("mail.smtp.host", "smtp.gmail.com");

        props.put("mail.smtp.auth", "true");

        props.put("mail.smtp.starttls.enable", "true");

        props.put("mail.host", "gmail");

        props.put("mail.user", "turismorealduoc@gmail.com");

        props.put("mail.password", "portafolio");

        props.put("mail.port", "465");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {

            @Override

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(user, pass);

            }

        });

        try {

            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(user));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(m));

            message.setSubject(sub);

            message.setText(messg);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {

            throw new RuntimeException(e);

        }

    }

}
