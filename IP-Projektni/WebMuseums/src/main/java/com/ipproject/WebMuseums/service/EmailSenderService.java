package com.ipproject.WebMuseums.service;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.ipproject.WebMuseums.dto.EmailRequestDto;
import com.ipproject.WebMuseums.model.Museum;
import com.ipproject.WebMuseums.model.VirtualTour;
import com.ipproject.WebMuseums.model.VirtualTourTicket;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

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
  

   
	public void sendEmailWithAttachment(VirtualTourTicket savedTicket) {
		 ByteArrayOutputStream outputStream = null;
		try {
	    MimeMessage message = mailSender.createMimeMessage();
	     
	    MimeMessageHelper helper = new MimeMessageHelper(message, true);
	    
	    helper.setFrom("sigurnostnainternetu3@gmail.com");
	    helper.setTo(savedTicket.getUserPerson().getEmail());
	    helper.setSubject(savedTicket.getVirtualTour().getMuseum().getName());
	    helper.setText("Your ticket for "+savedTicket.getVirtualTour().getName()+" is here. Thank you");

	    
	  //now write the PDF content to the output stream
        outputStream = new ByteArrayOutputStream();
        writePdf(outputStream,savedTicket);
        byte[] bytes = outputStream.toByteArray();
        

        //construct the pdf body part
        DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
	    	
    	helper.addAttachment(savedTicket.getVirtualTour().getName()+"_TICKET", dataSource);

	    mailSender.send(message);
	    System.out.println("Mail Send...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	    
		
	}
	 private void writePdf(OutputStream outputStream,VirtualTourTicket savedTicket) throws Exception {
	        Document document = new Document();
	        PdfWriter.getInstance(document, outputStream);
	        document.open();
	        Museum museum=savedTicket.getVirtualTour().getMuseum();
	        Paragraph paragraph = new Paragraph();
	        paragraph.add(new Chunk("Museum: "+museum.getName()+"\n"));
	        paragraph.add(new Chunk("Museum location: "+museum.getAddress()+","+museum.getCityName()+","+museum.getCountryName()+"\n"));
	        paragraph.add(new Chunk("Museum phone: "+museum.getPhoneNumber()+"\n"));
	        VirtualTour virtualTour=savedTicket.getVirtualTour();
	        paragraph.add(new Chunk("Virtual tour name: "+virtualTour.getName()+"\n"));
	        paragraph.add(new Chunk("Virtual tour start: "+virtualTour.getStartDateTime().format(DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy"))+"\n"));
	        paragraph.add(new Chunk("Virtual tour duration: "+virtualTour.getDuration()+"h"+"\n"));
	        paragraph.add(new Chunk("Virtual tour ticket number: "+savedTicket.getTicketNumber()+"\n"));
	        document.add(paragraph);
	        document.close();
	    }
}
