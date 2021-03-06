package com.green.utility;

import java.io.File;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class Email {

	@Autowired
	private JavaMailSender mailSender;

	public void sendSimpleMessage(String to, String subject, String text) {

		SimpleMailMessage message = new SimpleMailMessage();

		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);

		mailSender.send(message);

	}
	
	public void sendSimpleHtml(String to, String subject, String text) throws MessagingException {

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setTo(to);		
		helper.setSubject(subject);
		helper.setText(text,true);
		
		mailSender.send(message);

	}

	public void sendMessageWithAttachment(String to, String subject, String text, List<File> documentos)
			throws MessagingException {

		MimeMessage message = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(text);

		for (File documento : documentos) {
			FileSystemResource file = new FileSystemResource(documento);
			helper.addAttachment(documento.getName(), file);
		}

		mailSender.send(message);

	}
	
	public void sendMessageWithAttachmentHtml(String to, String subject, String text, List<File> documentos)
			throws MessagingException {

		MimeMessage message = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(text,true);

		for (File documento : documentos) {
			FileSystemResource file = new FileSystemResource(documento);
			helper.addAttachment(documento.getName(), file);
		}

		mailSender.send(message);

	}
}
