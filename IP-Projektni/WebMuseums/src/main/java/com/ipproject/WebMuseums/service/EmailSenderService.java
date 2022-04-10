package com.ipproject.WebMuseums.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ipproject.WebMuseums.dto.EmailRequestDto;

@Service
public class EmailSenderService {
	
	@Autowired
    private JavaMailSender mailSender;

    public void sendSimpleEmail(EmailRequestDto emailRequestDto) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("sigurnostnainternetu3@gmail.com");
        message.setTo(emailRequestDto.getReceiverEmail());
        message.setText(emailRequestDto.getMailBody());
        message.setSubject(emailRequestDto.getMailSubject());

        mailSender.send(message);
        System.out.println("Mail Send...");
    }

}
