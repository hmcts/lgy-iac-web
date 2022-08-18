package com.MOJICT.IACFee.Util;


import java.io.ByteArrayOutputStream;
import java.security.Security;
import java.util.Properties;
import javax.activation.DataHandler;

import javax.mail.*;
import javax.mail.internet.*;



import com.sun.istack.*;

public class MailService {
	/**
	 * log4j logging solution
	 */
	

	public static synchronized void sendMail(ByteArrayOutputStream pdf, String recipients, String filename)
			throws Exception {

		String mailhost = "64.69.177.84";
		String sender = "@justice.gsi.gov.uk";

		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.host", mailhost);
		props.put("mail.smtp.port", "25");

		// Define message
		MimeMessage message = new MimeMessage(Session.getDefaultInstance(props));
		message.setFrom(new InternetAddress(sender));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipients));
		message.setSubject(filename.substring(0, filename.indexOf("_")));
		message.setText("");

		String applicationType = "application/pdf";

		MimeBodyPart bp = new MimeBodyPart();
		bp.setDataHandler(new DataHandler(new ByteArrayDataSource(pdf.toByteArray(), applicationType)));
		bp.setFileName(filename);

		String bodyMessage = "<p>Thank you for submitting your request, copy attached for your information. </p>"
				+ "<p>Your request is awaiting approval by your line manager. Once approved the request will be sent to the Atos Origin Request Desk who will advise you of your request ticket reference.</p>"
				+ "<p>  For any further updates to this call please contact the Service Desk as below or via e-mail on ITOrderingDesk@justice.gsi.gov.uk </p>"
				+ "<p>Kind Regards </p>" + "<p>MoJ Request Desk</p>" + "<p>Rail House</p>" + "<p>Crewe</p> "
				+ "<p>Email: itorderingdesk@justice.gsi.gov.uk</p>" + "<p>Web: www.atosorigin.com </p>"
				+ "<p>Atos Origin is the Official IT Partner for the London 2012 Olympic Games</p> <br />"
				+ "<p>LOCCS: 0500 20 87 87 | Libra: 0845 143 0101 | DOM1: 0800 783 0162 | ETS: 0845 371 2474</p>";

		MimeBodyPart msgBody = new MimeBodyPart();
		msgBody.setText(bodyMessage);
		msgBody.setContent(bodyMessage, "text/html");
		// use a MimeMultipart as we need to handle the file attachments
		MimeMultipart wholeEmail = new MimeMultipart();
		// Add your other MimeBodyParts (covering email etc)
		wholeEmail.addBodyPart(bp);
		wholeEmail.addBodyPart(msgBody);
		// Actual JavaMail setup stuff skipped
		message.setContent(wholeEmail);
		Transport.send(message);

	}

	public static synchronized void sendSecurity(String security, String recipients) throws Exception {

		String mailhost = "64.69.177.84";
		String sender = "mojstandardorder-noreply@justice.gsi.gov.uk";

		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.host", mailhost);
		props.put("mail.smtp.port", "25");

		String bodyMessage = null;
		String url = "http://intranet-applications.dca.gsi.gov.uk/MoJOrderForm/pages/security.do";
		// url=url+security;

		bodyMessage = "<p>Dear Sir/Madam</p>" + "<p>Your security token is<strong> " + security + " </strong></p>"
				+ "<p>Please click on following link copy and paste the security code provided above.</p>"
				+ "<p> <a href=" + url
				+ ">http://intranet-applications.dca.gsi.gov.uk/MoJOrderForm/pages/security.do</a></p>"
				+ "<br> <p>Thank you<br></p>";

		// Define message
		MimeMessage message = new MimeMessage(Session.getDefaultInstance(props));
		message.setFrom(new InternetAddress(sender));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipients));
		message.setSubject("Service Catalogue - Security Token");

		MimeBodyPart msgBody = new MimeBodyPart();
		msgBody.setText(bodyMessage);
		msgBody.setContent(bodyMessage, "text/html");

		// use a MimeMultipart as we need to handle the file attachments
		Multipart multipart = new MimeMultipart();
		// add the message body to the mime message
		multipart.addBodyPart(msgBody);

		String mimeType = "text/html";
		// Actual JavaMail setup stuff skipped
		message.setContent(multipart);
		Transport.send(message);

	}

	public static synchronized void sendTestMail(ByteArrayOutputStream pdf, String recipients, String filename)
			throws Exception {

		String mailhost = "smtp.gmail.com";
		String sender = "catalogueorderform@googlemail.com";

		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", mailhost);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.quitwait", "false");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("catalogueorderform", "hellohai88");
			}
		});

		// Define message
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(sender));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipients));
		message.setSubject(filename.substring(0, filename.indexOf("_")));
		message.setText("");

		String applicationType = "application/pdf";

		MimeBodyPart bp = new MimeBodyPart();
		bp.setDataHandler(new DataHandler(new ByteArrayDataSource(pdf.toByteArray(), applicationType)));
		bp.setFileName(filename);

		String bodyMessage = "<p>Thank you for submitting your request, copy attached for your information. </p>"
				+ "<p>Your request is awaiting approval by your line manager. Once approved the request will be sent to the Atos Origin Request Desk who will advise you of your request ticket reference.</p>"
				+ "<p>  For any further updates to this call please contact the Service Desk as below or via e-mail on ITOrderingDesk@justice.gsi.gov.uk </p>"
				+ "<p></p>" + "<p>Kind Regards <br/>" + "MoJ Request Desk<br/>" + "Rail House<br/>" + "Crewe<br/> "
				+ "Email: itorderingdesk@justice.gsi.gov.uk<br/>" + "Web: www.atosorigin.com <br/>"
				+ "Atos Origin is the Official IT Partner for the London 2012 Olympic Games<br />"
				+ "LOCCS: 0500 20 87 87 | Libra: 0845 143 0101 | DOM1: 0800 783 0162 | ETS: 0845 371 2474</p>";

		MimeBodyPart msgBody = new MimeBodyPart();
		msgBody.setText(bodyMessage);
		msgBody.setContent(bodyMessage, "text/html");

		// use a MimeMultipart as we need to handle the file attachments

		MimeMultipart wholeEmail = new MimeMultipart();
		// Add your other MimeBodyParts (covering email etc)
		wholeEmail.addBodyPart(bp);
		wholeEmail.addBodyPart(msgBody);

		// Actual JavaMail setup stuff skipped
		message.setContent(wholeEmail);
		Transport.send(message);

	}

	public static synchronized void sendTestSecurity(String security, String recipients) throws Exception {

		String mailhost = "smtp.gmail.com";
		String sender = "catalogueorderform@googlemail.com";

		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", mailhost);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.quitwait", "false");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("catalogueorderform", "hellohai88");
			}
		});

		String bodyMessage = null;

		String url = "http://intranet-applications.dca.gsi.gov.uk/MoJOrderForm/pages/security.do";
		// url=url+security;

		bodyMessage = "<p>Dear Sir/Madam</p>" + "<p>Your security token is<strong> " + security + " </strong></p>"
				+ "<p>Please click on following link copy and paste the security code provided above.</p>"
				+ "<p> <a href=" + url
				+ ">http://intranet-applications.dca.gsi.gov.uk/MoJOrderForm/pages/security.do</a></p>"
				+ "<br> <p>Thank you<br></p>";

		// Define message
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(sender));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipients));
		message.setSubject("Service Catalogue - Security Token");

		MimeBodyPart msgBody = new MimeBodyPart();
		msgBody.setText(bodyMessage);
		msgBody.setContent(bodyMessage, "text/html");

		// use a MimeMultipart as we need to handle the file attachments
		Multipart multipart = new MimeMultipart();
		// add the message body to the mime message
		multipart.addBodyPart(msgBody);

		String mimeType = "text/html";
		// Actual JavaMail setup stuff skipped
		message.setContent(multipart);
		Transport.send(message);

	}
}