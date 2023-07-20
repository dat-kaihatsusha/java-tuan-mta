package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@SpringBootApplication
@EnableScheduling
public class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
    /*String senderEmail = "nguyendatmta@gmail.com";
    String senderPassword = "";

    String recipientEmail = "dat.kaihatsusha@gmail.com";

    Properties properties = new Properties();
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.starttls.enable", "true");
    properties.put("mail.smtp.host", "smtp.freesmtpservers.com");
    properties.put("mail.smtp.port", "25");

    Session session = Session.getInstance(properties, new Authenticator() {
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(senderEmail, senderPassword);
      }
    });

    try {
      Message message = new MimeMessage(session);

      message.setFrom(new InternetAddress(senderEmail));
      message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));

      message.setSubject("Test email from JavaMail");
      message.setText("This is a test email sent from JavaMail");

      Transport.send(message);
      System.out.println("Email sent successfully!");
    }catch (Exception e){
      e.printStackTrace();
    }*/

  }

}
