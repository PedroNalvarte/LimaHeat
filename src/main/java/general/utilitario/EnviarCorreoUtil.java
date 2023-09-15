package general.utilitario;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EnviarCorreoUtil {

	public static String enviarCorreo(String destino, String conCopia, String asunto, String mensaje, String adicional) {

		final String mailUserProviderReset = "des_sw@usmp.pe";
		final String passwordProviderReset = "Des@2021fia09data";
		// String destino="administracion_fia@usmp.pe";

		
		String html = "<html><head>" + "<p>Estimado(a) , </p>";

		String tfinal = "<b>FIA-DATA</b><br/>"
				+ "</body></html>";

		mensaje = "<p>" + mensaje + "</p><br/>";
		
		if(adicional.length() != 0 || adicional != null) {
			mensaje = mensaje + "<p>"+adicional+"</p>";	
		}
		
		mensaje = mensaje + "<br/><p>Gracias</p><br/>" + "<p><b>FIA-DATA</b></p>";
		
		String tbody = "<p>" + mensaje + "</p>";

		String msgHtml = html + tbody + tfinal;
		// String destino = correo;
		//System.out.println(destino);
		Session session;

		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.office365.com");
		// properties.put("mail.smtp.host", "outlook.office365.com");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
		properties.put("mail.smtp.mail.sender", mailUserProviderReset);
		properties.put("mail.smtp,password", passwordProviderReset);
		properties.put("mail.smtp.user", mailUserProviderReset);

		session = Session.getDefaultInstance(properties);

		try {
			MimeMessage message = new MimeMessage(session);
			MimeMultipart mimeMultipart = new MimeMultipart();
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(mensaje, "text/html; charset=UTF-8");
			mimeMultipart.addBodyPart(messageBodyPart);

			// MimeBodyPart attachmentBodyPart = new MimeBodyPart();
			// ByteArrayDataSource ds = new ByteArrayDataSource(aAttachment,
			// "application/pdf");
			// attachmentBodyPart.setDataHandler(new DataHandler(ds));
			// attachmentBodyPart.setFileName("RegistroTramite.pdf");
			// mimeMultipart.addBodyPart(attachmentBodyPart);
			message.setFrom(new InternetAddress((String) properties.get("mail.smtp.mail.sender")));

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
			
			if(conCopia.length() > 0 || conCopia != null) {
				message.addRecipient(Message.RecipientType.CC, new InternetAddress(conCopia));
			}
			// message.addRecipient(Message.RecipientType.CC, new
			// InternetAddress("ltoledoc@usmp.pe"));
			// message.addRecipient(Message.RecipientType.CC, new
			// InternetAddress("gradosytitulos_fia@usmp.pe"));
			message.setSubject(asunto);
			message.setContent(mimeMultipart);
			Transport t = session.getTransport("smtp");
			t.connect((String) properties.get("mail.smtp.user"), passwordProviderReset);
			t.sendMessage(message, message.getAllRecipients());
			t.close();
			//System.out.println("Se ha enviado el correo :{" + destino + "}");
			return "1";

		} catch (MessagingException me) {
			System.out.print(me.getMessage());
			System.out.println("No se envio el correo " + me.getMessage());
		}
		
		return "0";
	}

}
