package com.asvin.MrFix1.Service;

import com.asvin.MrFix1.Model.EmailDetails;

public interface EmailService {
	 String sendSimpleMail(EmailDetails details);
	 
	    // Method
	    // To send an email with attachment
	    String sendMailWithAttachment(EmailDetails details);
}
