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
import org.oregami.entities.Title;
import org.oregami.entities.User;
import org.oregami.keyobjects.Schluessel.CountryKey;
import org.oregami.keyobjects.Schluessel.DistributionKey;
import org.oregami.keyobjects.Schluessel.LanguageKey;
import org.oregami.keyobjects.Schluessel.ReleaseGroupType;
import org.oregami.keyobjects.Schluessel.RoleKey;
import org.oregami.keyobjects.Schluessel.SystemKey;


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
        initMonkeyIsland();
        initResidentEvil();
        
        
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
    
    public static void initMonkeyIsland() {
        EntityManagerFactory entityManagerFactory = HibernateJpaUtil.getEntityManagerFactory();
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        
        Game spielMonkeyIsland = new Game();
        spielMonkeyIsland.setMainTitle("Monkey Island");
        spielMonkeyIsland.setDescription("Tolles Spiel mit viel Humor! (" + now() + ")");
        

        ReleaseGroup vogDos = new ReleaseGroup(
        		"DOS (Original)", 
        		SystemKey.MSDOS, 
        		ReleaseGroupType.Original);
        Release voMsdos1_1 = new Release("Veröffentlichung 1-1 (PC, 5,25, DV, 256 Farben)", DistributionKey.RegularBox);
        voMsdos1_1.addCountryRelease(new CountryRelease(CountryKey.Deutschland, 1990));
        vogDos.addRelease(voMsdos1_1);
        
        Release voMsdos1_11 = new Release("Veröffentlichung 1-11 (PC, CD, EU, 256 Farben)", DistributionKey.RegularBox);
        voMsdos1_11.addCountryRelease(new CountryRelease(CountryKey.Deutschland, 9999));
        voMsdos1_11.addCountryRelease(new CountryRelease(CountryKey.Frankreich, 9999));
        voMsdos1_11.addCountryRelease(new CountryRelease(CountryKey.Italien, 9999));
        voMsdos1_11.addCountryRelease(new CountryRelease(CountryKey.Spanien, 9999));
        voMsdos1_11.addCountryRelease(new CountryRelease(CountryKey.UK, 9999));
        vogDos.addRelease(voMsdos1_11);
        
        
        
        ReleaseGroup vogDosDemo = new ReleaseGroup(
        		"DOS (Demoversion)", 
        		SystemKey.MSDOS, 
        		ReleaseGroupType.Demo); 
        
        ReleaseGroup vogDosEnhanced = new ReleaseGroup(
        		"DOS (Verbesserte CD-Version)", 
        		SystemKey.MSDOS, 
        		ReleaseGroupType.Enhanced);         
        
        spielMonkeyIsland.addReleaseGroup(vogDos);
        spielMonkeyIsland.addReleaseGroup(vogDosDemo);
        spielMonkeyIsland.addReleaseGroup(vogDosEnhanced);

        
        //########### Amiga
        ReleaseGroup vogAmiga = new ReleaseGroup(
        		"Amiga 500/600 (OCS/ECS) (Original)",
        		SystemKey.Amiga, 
        		ReleaseGroupType.Original);
        
        Release voAmiga4_1 = new Release("Veröffentlichung 4-1 (Amiga, 3,5, DV)", DistributionKey.RegularBox);
        voAmiga4_1.addCountryRelease(new CountryRelease(CountryKey.Deutschland, 1991));
        Release voAmiga4_2 = new Release("Veröffentlichung 4-2 (Amiga, 3,5, UK)", DistributionKey.RegularBox);
        voAmiga4_2.addCountryRelease(new CountryRelease(CountryKey.UK, 1991));
        Release voAmiga4_3 = new Release("Veröffentlichung 4-3 (Amiga, 3,5, UK Kixx)", DistributionKey.RegularBox);
        voAmiga4_3.addCountryRelease(new CountryRelease(CountryKey.UK, 1994));
        
        vogAmiga.addRelease(voAmiga4_1);
        vogAmiga.addRelease(voAmiga4_2);
        vogAmiga.addRelease(voAmiga4_3);
        
        ReleaseGroup vogAmigaDemo = new ReleaseGroup(
        		"Amiga 500/600 (OCS/ECS) (Demoversion)",
        		SystemKey.Amiga, 
        		ReleaseGroupType.Demo);
       
        spielMonkeyIsland.addReleaseGroup(vogAmiga);
        spielMonkeyIsland.addReleaseGroup(vogAmigaDemo);
        
        
        
        //########### Atari ST
        ReleaseGroup vogAtariST = new ReleaseGroup(
        		"Atari ST (Original)",
        		SystemKey.AtariST, 
        		ReleaseGroupType.Original);
        
        Release voSt6_1 = new Release("Veröffentlichung 6-1 (Atari ST, 3,5, DV)", DistributionKey.RegularBox);
        voSt6_1.addCountryRelease(new CountryRelease(CountryKey.Deutschland, 1991));
        Release voSt6_2 = new Release("Veröffentlichung 6-2 (Atari ST, 3,5, US)", DistributionKey.RegularBox);
        voSt6_2.addCountryRelease(new CountryRelease(CountryKey.USA, 1991));
        Release voSt6_3 = new Release("Veröffentlichung 6-3 (Atari ST, 3,5, UK)", DistributionKey.RegularBox);
        voSt6_3.addCountryRelease(new CountryRelease(CountryKey.UK, 1991));

        vogAtariST.addRelease(voSt6_1);
        vogAtariST.addRelease(voSt6_2);
        vogAtariST.addRelease(voSt6_3);
        
        spielMonkeyIsland.addReleaseGroup(vogAtariST);

        //########### Apple
        ReleaseGroup vogApple = new ReleaseGroup(
        		"Apple Macintosh (Original)",
        		SystemKey.AppleMacintosh, 
        		ReleaseGroupType.Original);
        
        Release voApple7_1 = new Release("Veröffentlichung 7-1 (Apple Macintosh, 3,5, US)", DistributionKey.RegularBox);
        voApple7_1.addCountryRelease(new CountryRelease(CountryKey.USA, 1991));
        
        vogApple.addRelease(voApple7_1);


        ReleaseGroup vogAppleSpecial = new ReleaseGroup(
        		"Apple Macintosh (Special Edition)",
        		SystemKey.AppleMacintosh, 
        		ReleaseGroupType.Remake);
        
        spielMonkeyIsland.addReleaseGroup(vogApple);
        spielMonkeyIsland.addReleaseGroup(vogAppleSpecial);
        
        
        
        spielMonkeyIsland.addTitle(new Title("The Secret of Monkey Island 2", LanguageKey.DE));
        spielMonkeyIsland.addTitle(new Title("The Secret of Monkey Island 2: Le Chuck's Revenge", LanguageKey.EN));
        
        
        entityManager.persist(spielMonkeyIsland);

        tx.commit();
        entityManager.close();
        
        
//        XStream xstream = new XStream();
//        xstream.alias("spiel", Spiel.class);
//        // turn it into XML and display it - this is how it should be my friends, this easy      
//        String xml = xstream.toXML(spiel);
//        System.out.println(xml);
    }
    
    
    public static void initResidentEvil() {
    	
        EntityManagerFactory entityManagerFactory = HibernateJpaUtil.getEntityManagerFactory();
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        
        Game spielResidentEvil = new Game();
        spielResidentEvil.setMainTitle("Resident Evil");
        spielResidentEvil.setDescription("Horror-Shooter (" + now() + ")");
        

        ReleaseGroup vogPlaystation = new ReleaseGroup(
        		"Playstation Original", 
        		SystemKey.SonyPlaystation, 
        		ReleaseGroupType.Original);
        
        Release voPs1_1 = new Release("Veröffentlichung 1-1 (PSX, CD, DV)", DistributionKey.RegularBox);
        voPs1_1.addCountryRelease(new CountryRelease(CountryKey.Deutschland, 1986));
        voPs1_1.addCountryRelease(new CountryRelease(CountryKey.Oesterreich, 1986));
        vogPlaystation.addRelease(voPs1_1);
        
        Release voPs1_2 = new Release("Veröffentlichung 1-2 (PSX, CD, DV, White Label)", DistributionKey.RegularBox);
        voPs1_2.addCountryRelease(new CountryRelease(CountryKey.Deutschland, 9999));
        vogPlaystation.addRelease(voPs1_2);
        
        Release voPs1_3 = new Release("Veröffentlichung 1-3 (PSX, CD, DV, Platinum Edition)", DistributionKey.RegularBox);
        voPs1_3.addCountryRelease(new CountryRelease(CountryKey.Deutschland, 9999));
        vogPlaystation.addRelease(voPs1_3);
        //
        //
        spielResidentEvil.addReleaseGroup(vogPlaystation);
        
        
        spielResidentEvil.addTitle(new Title("Resident Evil", LanguageKey.DE));
        spielResidentEvil.addTitle(new Title("Biohazard", LanguageKey.EN));
        spielResidentEvil.addTitle(new Title("RE", LanguageKey.EN));
        
        
        entityManager.persist(spielResidentEvil);

        tx.commit();
        entityManager.close();

        
    }
}
