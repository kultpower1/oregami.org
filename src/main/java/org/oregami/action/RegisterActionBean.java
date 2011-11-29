package org.oregami.action;

import java.sql.Timestamp;

import javax.mail.Message.RecipientType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

import org.codemonkey.simplejavamail.Email;
import org.codemonkey.simplejavamail.Mailer;
import org.oregami.data.HibernateJpaUtil;
import org.oregami.entities.User;
import org.oregami.util.BaseActionBean;
import org.oregami.util.MailConfig;


@UrlBinding("/Register")
public class RegisterActionBean extends BaseActionBean implements ActionBean {

	private String username;
	private String email;
	
	@DefaultHandler
	public Resolution defaultHandler() {
		return new ForwardResolution("/jsp/register.jsp");
	}
	
	
	public Resolution register() {
		final Email mail = new Email();
		mail.setFromAddress("gamedb", "gamedb@supermariokart.de");
		mail.setSubject("Registrierung");
		mail.addRecipient(username, email, RecipientType.TO);
		mail.setText("Hallo " + username + "!\n\n");
		new Mailer(
			MailConfig.smtpServer, 
			MailConfig.port, 
			MailConfig.mailAddress , 
			MailConfig.password
		).sendMail(mail);
		
    	EntityManagerFactory entityManagerFactory = HibernateJpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        
		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setRegistrationTime(new Timestamp(System.currentTimeMillis()));
		
        entityManager.persist(user);
        
        tx.commit();
        entityManager.close();
		
		return new ForwardResolution("/Login");
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
}
