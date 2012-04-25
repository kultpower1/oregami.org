package org.oregami.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.oregami.entities.CountryRelease;
import org.oregami.entities.Game;
import org.oregami.entities.Release;
import org.oregami.entities.ReleaseGroup;
import org.oregami.entities.Screenshot;
import org.oregami.entities.Title;
import org.oregami.keyobjects.KeyObjects.CountryKey;
import org.oregami.keyobjects.KeyObjects.DistributionKey;
import org.oregami.keyobjects.KeyObjects.LanguageKey;
import org.oregami.keyobjects.KeyObjects.ReleaseGroupType;
import org.oregami.keyobjects.KeyObjects.ScreenshotType;
import org.oregami.keyobjects.KeyObjects.SystemKey;

public class ResidentEvil {

	public static void init() {

    	
        EntityManagerFactory entityManagerFactory = HibernateJpaUtil.getEntityManagerFactory();
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        
        Game gameResidentEvil = new Game();
        //gameResidentEvil.setId(2l);
        
        gameResidentEvil.setMainTitle("Resident Evil");
        gameResidentEvil.setDescription("Horror-Shooter (" + App.now() + ")");
        

        ReleaseGroup releaseGroupPlaystation = new ReleaseGroup(
        		"Playstation", 
        		SystemKey.SonyPlaystation, 
        		ReleaseGroupType.Original);
        
        releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470632_PSOGL2_01.jpg", ScreenshotType.unknown, "description not available"));
        releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470633_PSOGL2_02.jpg", ScreenshotType.unknown, "description not available"));
        releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470635_PSOGL2_04.jpg", ScreenshotType.unknown, "description not available"));
        releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470635_PSOGL2_05.jpg", ScreenshotType.unknown, "description not available"));
        releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470636_PSOGL2_06.jpg", ScreenshotType.unknown, "description not available"));
        releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470636_PSOGL2_07.jpg", ScreenshotType.unknown, "description not available"));
        releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470637_PSOGL2_08.jpg", ScreenshotType.unknown, "description not available"));
        releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470638_PSOGL2_09.jpg", ScreenshotType.unknown, "description not available"));
        releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470638_PSOGL2_10.jpg", ScreenshotType.unknown, "description not available"));
        releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470638_PSOGL2_11.jpg", ScreenshotType.unknown, "description not available"));
        releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470639_PSOGL2_12.jpg", ScreenshotType.unknown, "description not available"));
        releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470639_PSOGL2_13.jpg", ScreenshotType.unknown, "description not available"));
        releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470640_PSOGL2_14.jpg", ScreenshotType.unknown, "description not available"));
        releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470641_PSOGL2_15.jpg", ScreenshotType.unknown, "description not available"));
        releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470641_PSOGL2_16.jpg", ScreenshotType.unknown, "description not available"));
        releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470642_PSOGL2_17.jpg", ScreenshotType.unknown, "description not available"));
        releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470643_PSOGL2_18.jpg", ScreenshotType.unknown, "description not available"));
        releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470645_PSOGL2_19.jpg", ScreenshotType.unknown, "description not available"));
        releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470646_PSOGL2_20.jpg", ScreenshotType.unknown, "description not available"));
        releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470648_PSOGL2_21.jpg", ScreenshotType.unknown, "description not available"));
        releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470649_PSOGL2_22.jpg", ScreenshotType.unknown, "description not available"));
        releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470649_PSOGL2_23.jpg", ScreenshotType.unknown, "description not available"));

        
        Release releasePs1_1 = new Release("Veröffentlichung 1-1 (PSX, CD, DV)", DistributionKey.RegularBox);
        releasePs1_1.addCountryRelease(new CountryRelease(CountryKey.Deutschland, 1986));
        releasePs1_1.addCountryRelease(new CountryRelease(CountryKey.Oesterreich, 1986));
        releaseGroupPlaystation.addRelease(releasePs1_1);
        
        Release releasePs1_2 = new Release("Veröffentlichung 1-2 (PSX, CD, DV, White Label)", DistributionKey.RegularBox);
        releasePs1_2.addCountryRelease(new CountryRelease(CountryKey.Deutschland, 9999));
        releaseGroupPlaystation.addRelease(releasePs1_2);
        
        Release releasePs1_3 = new Release("Veröffentlichung 1-3 (PSX, CD, DV, Platinum Edition)", DistributionKey.RegularBox);
        releasePs1_3.addCountryRelease(new CountryRelease(CountryKey.Deutschland, 9999));
        releaseGroupPlaystation.addRelease(releasePs1_3);
        //
        //
        gameResidentEvil.addReleaseGroup(releaseGroupPlaystation);
        
        
        ReleaseGroup releaseGroupWindows = new ReleaseGroup(
        		"Windows", 
        		SystemKey.Windows, 
        		ReleaseGroupType.Original);
        
        releaseGroupWindows.addScreenshot(new Screenshot("residentevil/windows/R_6737_1194880847_ResidentEvil-Screen2800729.jpg", ScreenshotType.unknown, "description not available"));
        releaseGroupWindows.addScreenshot(new Screenshot("residentevil/windows/R_6737_1194880848_ResidentEvil-Screen2800829.jpg", ScreenshotType.unknown, "description not available"));
        releaseGroupWindows.addScreenshot(new Screenshot("residentevil/windows/R_6737_1194880850_ResidentEvil-Screen2801129.jpg", ScreenshotType.unknown, "description not available"));
        releaseGroupWindows.addScreenshot(new Screenshot("residentevil/windows/R_6737_1194880851_ResidentEvil-Screen2801329.jpg", ScreenshotType.unknown, "description not available"));
        releaseGroupWindows.addScreenshot(new Screenshot("residentevil/windows/R_6737_1194880851_ResidentEvil-Screen2801529.jpg", ScreenshotType.unknown, "description not available"));
        releaseGroupWindows.addScreenshot(new Screenshot("residentevil/windows/R_6737_1194880852_ResidentEvil-Screen2801829.jpg", ScreenshotType.unknown, "description not available"));
        releaseGroupWindows.addScreenshot(new Screenshot("residentevil/windows/R_6737_1194880852_ResidentEvil-Screen2802529.jpg", ScreenshotType.unknown, "description not available"));
        releaseGroupWindows.addScreenshot(new Screenshot("residentevil/windows/R_6737_1194880853_ResidentEvil-Screen2802629.jpg", ScreenshotType.unknown, "description not available"));
        releaseGroupWindows.addScreenshot(new Screenshot("residentevil/windows/R_6737_1194880854_ResidentEvil-Screen2803129.jpg", ScreenshotType.unknown, "description not available"));
        releaseGroupWindows.addScreenshot(new Screenshot("residentevil/windows/R_6737_1194880854_ResidentEvil-Screen2803429.jpg", ScreenshotType.unknown, "description not available"));
        releaseGroupWindows.addScreenshot(new Screenshot("residentevil/windows/R_6737_1194880855_ResidentEvil-Screen2803829.jpg", ScreenshotType.unknown, "description not available"));
        releaseGroupWindows.addScreenshot(new Screenshot("residentevil/windows/R_6737_1194880856_ResidentEvil-Screen2804029.jpg", ScreenshotType.unknown, "description not available"));
        releaseGroupWindows.addScreenshot(new Screenshot("residentevil/windows/R_6737_1194880856_ResidentEvil-Screen2804129.jpg", ScreenshotType.unknown, "description not available"));
        releaseGroupWindows.addScreenshot(new Screenshot("residentevil/windows/R_6737_1194880857_ResidentEvil-Screen2804429.jpg", ScreenshotType.unknown, "description not available"));
        releaseGroupWindows.addScreenshot(new Screenshot("residentevil/windows/R_6737_1194880857_ResidentEvil-Screen2805129.jpg", ScreenshotType.unknown, "description not available"));
        releaseGroupWindows.addScreenshot(new Screenshot("residentevil/windows/R_6737_1194880858_ResidentEvil-Screen2805229.jpg", ScreenshotType.unknown, "description not available"));

        
        gameResidentEvil.addReleaseGroup(releaseGroupWindows);
        
        gameResidentEvil.addTitle(new Title("Resident Evil", LanguageKey.DE));
        gameResidentEvil.addTitle(new Title("Biohazard", LanguageKey.EN));
        gameResidentEvil.addTitle(new Title("RE", LanguageKey.EN));
        
        
        entityManager.persist(gameResidentEvil);

        tx.commit();
        entityManager.close();

        
    		
	}

}
