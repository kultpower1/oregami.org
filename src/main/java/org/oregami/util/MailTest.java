package org.oregami.util;

import javax.mail.Message.RecipientType;

import org.codemonkey.simplejavamail.Email;
import org.codemonkey.simplejavamail.Mailer;

public class MailTest {

	public static void main(String[] args) {
		email();
	}
	public static void email() {

		final Email email = new Email();

		email.setFromAddress("gamedb", "gamedb@supermariokart.de");
		email.setSubject("Test-Mail");
		email.addRecipient("Sebastian Eichholz", "gene@kultpower.de", RecipientType.TO);
		email.setText("We should meet up! ;)");
//		email.setTextHTML("<img src='cid:wink1'><b>We should meet up!</b><img src='cid:wink2'>");

		// embed images and include downloadable attachments
//		email.addEmbeddedImage("wink1", imageByteArray, "image/png");
//		email.addEmbeddedImage("wink2", imageDatesource);
//		email.addAttachment("invitation", pdfByteArray, "application/pdf");
//		email.addAttachment("dresscode", odfDatasource);

		new Mailer(MailConfig.smtpServer, 25, MailConfig.mailAddress , MailConfig.password).sendMail(email);
		//new Mailer("localhost", 25, "gamedb", "gamedb").sendMail(email);

	}
	
}
