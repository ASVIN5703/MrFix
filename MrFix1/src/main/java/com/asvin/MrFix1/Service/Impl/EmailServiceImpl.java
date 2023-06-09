package com.asvin.MrFix1.Service.Impl;

import java.io.File;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.asvin.MrFix1.Model.EmailDetails;
import com.asvin.MrFix1.Service.EmailService;
import com.asvin.MrFix1.repository.AdminRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
 
// Annotation
@Service
// Class
// Implementing EmailService interface
public class EmailServiceImpl implements EmailService {
 
    @Autowired private JavaMailSender javaMailSender;
    @Autowired 
    private AdminRepository adminrepo;
 
    @Value("${spring.mail.username}") private String sender;
 
    // Method 1
    // To send a simple email
    public String sendSimpleMail(EmailDetails details)
    {
 
        // Try block to check for exceptions
        try {
        	Random rand = new Random();
        	String token = String.format("%04d", rand.nextInt(10000));
        //  String token="1999";
            // Creating a simple mail message
            SimpleMailMessage mailMessage
                = new SimpleMailMessage();
           String  body = "Dear " + details.getRecipient() + ",\n \t To Activate Your Account Click below  \n "+"'http://localhost:8080/adminaccount/verify?token="+token;
            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(body);
            mailMessage.setSubject(details.getSubject());
           
            // Sending the mail
            System.out.println("everververv"+mailMessage);
            javaMailSender.send(mailMessage);
          //  return "Mail Sent Successfully...";
            return token;
        }
 
        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }
 
    // Method 2
    // To send an email with attachment
    public String
    sendMailWithAttachment(EmailDetails details)
    {
        // Creating a mime message
        MimeMessage mimeMessage
            = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
 
        try {
 
            // Setting multipart as true for attachments to
            // be send
            mimeMessageHelper
                = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(details.getRecipient());
            mimeMessageHelper.setText(details.getMsgBody());
            mimeMessageHelper.setSubject(
                details.getSubject());
 
            // Adding the attachment
            FileSystemResource file
                = new FileSystemResource(
                    new File(details.getAttachment()));
 
            mimeMessageHelper.addAttachment(
                file.getFilename(), file);
 
            // Sending the mail
            javaMailSender.send(mimeMessage);
            return "Mail sent Successfully";
        }
 
        // Catch block to handle MessagingException
        catch (MessagingException e) {
 
            // Display message when exception occurred
            return "Error while sending mail!!!";
        }
    }
}