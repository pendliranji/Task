package com.tyss.demo.controller;

import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tyss.demo.model.Email;



@Controller
@RequestMapping("emailcontroller")
public class EmailController {
/*
	@Autowired
   private JavaMailSender javaMailSender;*/
	
	@RequestMapping("/go")
	public String goToEmail(Map<String, Object> map) {
		map.put("email", new Email());
		return "Email";
	}

	@RequestMapping(value = "/goooo", method = RequestMethod.POST)
	public String sendEmails( @ModelAttribute("email") Email email) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		// get Session
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email.getFrom(), email.getPassword());
			}
		});
		// compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getTo()));
			message.setSubject(email.getSubject());
			message.setText(email.getMessage());
			// send message
			Transport.send(message);
			System.out.println("email sent successfully");
		} catch (MessagingException e) {
			e.printStackTrace();
			System.out.println("problem");
		}

		return "Email";
	}
	/*@RequestMapping(value = "/email", method = RequestMethod.POST)b 
	public String mess2(@ModelAttribute("email") Email email)
	{


	      SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
	      simpleMailMessage.setSubject(email.getSubject());
	      simpleMailMessage.setFrom(email.getFrom());
	      simpleMailMessage.setTo(email.getTo());
	      simpleMailMessage.setText(email.getMessage());
	      javaMailSender.send(simpleMailMessage);
	    return"";
	}*/
}
