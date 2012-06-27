/*******************************************************************************
 * Copyright (C) 2012  Oregami.org, Germany http://www.oregami.org
 * 
 * 	This program is free software: you can redistribute it and/or modify
 * 	it under the terms of version 3 or any later version of the
 * 	GNU Affero General Public License as published by the Free Software 
 * 	Foundation.
 * 	
 * 	This program is distributed in the hope that it will be useful,
 * 	but WITHOUT ANY WARRANTY; without even the implied warranty of
 * 	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * 	GNU Affero General Public License for more details.	
 * 	
 * 	You should have received a copy of the GNU Affero General Public License
 * 	along with this program. If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
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
