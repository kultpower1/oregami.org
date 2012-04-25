package org.oregami.data;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.oregami.entities.CountryRelease;
import org.oregami.entities.Game;
import org.oregami.entities.Release;
import org.oregami.entities.ReleaseGroup;
import org.oregami.entities.Screenshot;
import org.oregami.entities.Title;
import org.oregami.entities.User;
import org.oregami.keyobjects.KeyObjects.CountryKey;
import org.oregami.keyobjects.KeyObjects.DistributionKey;
import org.oregami.keyobjects.KeyObjects.LanguageKey;
import org.oregami.keyobjects.KeyObjects.ReleaseGroupType;
import org.oregami.keyobjects.KeyObjects.RoleKey;
import org.oregami.keyobjects.KeyObjects.ScreenshotType;
import org.oregami.keyobjects.KeyObjects.SystemKey;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;


/**
 * Hello world!
 *
 */
public class App 
{
	
	public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
	
	public static String now() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		return sdf.format(cal.getTime());
	}

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        initUser();
        MonkeyIsland.init();
        ResidentEvil.init();
        XWing.init();
        
//        initResidentEvil();
        
        
    }
    
    
    public static void initUser() {
    	EntityManagerFactory entityManagerFactory = HibernateJpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        
        User userAdmin = new User();
        userAdmin.setUsername("admin");
        userAdmin.setEmail("gene@kultpower.de");
        userAdmin.setPassword("admin");
        userAdmin.setRegistrationTime(new Timestamp(System.currentTimeMillis()));
        userAdmin.getRollList().add(RoleKey.Admin);
        userAdmin.getRollList().add(RoleKey.User);
        
        User user = new User();
        user.setUsername("user");
        user.setEmail("gene@kultpower.de");
        user.setPassword("user");
        user.setRegistrationTime(new Timestamp(System.currentTimeMillis())); 
        user.getRollList().add(RoleKey.User);
        
        entityManager.persist(userAdmin);
        entityManager.persist(user);
        
        tx.commit();
        entityManager.close();
        
    }
    
    public static void ensureDatabaseIsFilled() {
		if (GameDAO.getAllGames().size()==0) {
			MonkeyIsland.init();
			ResidentEvil.init();
			XWing.init();
			App.initUser();
		}
    }
    
}
