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
package org.oregami.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.oregami.entities.CountryRelease;
import org.oregami.entities.Game;
import org.oregami.entities.Photo;
import org.oregami.entities.Release;
import org.oregami.entities.ReleaseGroup;
import org.oregami.entities.Screenshot;
import org.oregami.entities.Title;
import org.oregami.keyobjects.KeyObjects.CountryKey;
import org.oregami.keyobjects.KeyObjects.DistributionKey;
import org.oregami.keyobjects.KeyObjects.LanguageKey;
import org.oregami.keyobjects.KeyObjects.PhotoType;
import org.oregami.keyobjects.KeyObjects.ReleaseGroupType;
import org.oregami.keyobjects.KeyObjects.ScreenshotType;
import org.oregami.keyobjects.KeyObjects.SystemKey;

public abstract class MonkeyIsland {

	
	public static void init() {
        EntityManagerFactory entityManagerFactory = HibernateJpaUtil.getEntityManagerFactory();
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        
        Game gameMonkeyIsland = new Game();
        //gameMonkeyIsland.setId(1l);
        
        gameMonkeyIsland.setMainTitle("Monkey Island");
        gameMonkeyIsland.setDescription("Tolles Spiel mit viel Humor! (" + App.now() + ")");
        

        ReleaseGroup releaseGroupDos = new ReleaseGroup(
        		"DOS", 
        		SystemKey.MSDOS, 
        		ReleaseGroupType.Original);
        Release releaseMsdos1_1 = new Release("Veröffentlichung 1-1 (PC, 5,25, DV, 256 Farben)", DistributionKey.RegularBox);
        releaseMsdos1_1.addCountryRelease(new CountryRelease(CountryKey.Deutschland, 1990));
        releaseGroupDos.addRelease(releaseMsdos1_1);
        
        //vogDos.addScreenshot(new Screenshot("M_5630_1127336939_monkeyisland1_1.png", ScreenshotType.unknown, "description"));
        releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336939_monkeyisland1_1.png", ScreenshotType.unknown, "description not available"));
        releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336939_monkeyisland1_2.png", ScreenshotType.unknown, "description not available"));
        releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336940_monkeyisland1_3.png", ScreenshotType.unknown, "description not available"));
        releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336940_monkeyisland1_4.png", ScreenshotType.unknown, "description not available"));
        releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336940_monkeyisland1_5.png", ScreenshotType.unknown, "description not available"));
        releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336941_monkeyisland1_6.png", ScreenshotType.unknown, "description not available"));
        releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336941_monkeyisland1_7.png", ScreenshotType.unknown, "description not available"));
        releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336942_monkeyisland1_10.png", ScreenshotType.unknown, "description not available"));
        releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336942_monkeyisland1_8.png", ScreenshotType.unknown, "description not available"));
        releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336942_monkeyisland1_9.png", ScreenshotType.unknown, "description not available"));
        releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336943_monkeyisland1_11.png", ScreenshotType.unknown, "description not available"));
        releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336943_monkeyisland1_12.png", ScreenshotType.unknown, "description not available"));
        releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336944_monkeyisland1_13.png", ScreenshotType.unknown, "description not available"));
        releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336944_monkeyisland1_14.png", ScreenshotType.unknown, "description not available"));
        releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336945_monkeyisland1_15.png", ScreenshotType.unknown, "description not available"));
        releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336945_monkeyisland1_16.png", ScreenshotType.unknown, "description not available"));
        releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336945_monkeyisland1_17.png", ScreenshotType.unknown, "description not available"));
        releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336946_monkeyisland1_18.png", ScreenshotType.unknown, "description not available"));
        releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336946_monkeyisland1_19.png", ScreenshotType.unknown, "description not available"));
        releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336946_monkeyisland1_20.png", ScreenshotType.unknown, "description not available"));
        releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336947_monkeyisland1_21.png", ScreenshotType.unknown, "description not available"));
        releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336947_monkeyisland1_22.png", ScreenshotType.unknown, "description not available"));
        releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336947_monkeyisland1_23.png", ScreenshotType.unknown, "description not available"));
        releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336948_monkeyisland1_24.png", ScreenshotType.unknown, "description not available"));
        releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336948_monkeyisland1_25.png", ScreenshotType.unknown, "description not available"));
        releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336948_monkeyisland1_26.png", ScreenshotType.unknown, "description not available"));
        releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336949_monkeyisland1_27.png", ScreenshotType.unknown, "description not available"));
        releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336949_monkeyisland1_28.png", ScreenshotType.unknown, "description not available"));
        releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336949_monkeyisland1_29.png", ScreenshotType.unknown, "description not available"));
        releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336950_monkeyisland1_30.png", ScreenshotType.unknown, "description not available"));
        releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336950_monkeyisland1_31.png", ScreenshotType.unknown, "description not available"));
        releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/megacd/M_5630_1133382714_MONKEYISLAND000.png", ScreenshotType.unknown, "description not available"));
        releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/megacd/M_5630_1133382715_MONKEYISLAND005.png", ScreenshotType.unknown, "description not available"));
        releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/megacd/M_5630_1133382716_MONKEYISLAND010.png", ScreenshotType.unknown, "description not available"));
        releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/megacd/M_5630_1133382716_MONKEYISLAND011.png", ScreenshotType.unknown, "description not available"));
        releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/megacd/M_5630_1133382717_MONKEYISLAND012.png", ScreenshotType.unknown, "description not available"));
        releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/megacd/M_5630_1133382717_MONKEYISLAND013.png", ScreenshotType.unknown, "description not available"));
        releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/megacd/M_5630_1133382718_MONKEYISLAND014.png", ScreenshotType.unknown, "description not available"));

        
        Release releaseMsdos1_11 = new Release("Veröffentlichung 1-11 (PC, CD, EU, 256 Farben)", DistributionKey.RegularBox);
        releaseMsdos1_11.addCountryRelease(new CountryRelease(CountryKey.Deutschland, 9999));
        releaseMsdos1_11.addCountryRelease(new CountryRelease(CountryKey.Frankreich, 9999));
        releaseMsdos1_11.addCountryRelease(new CountryRelease(CountryKey.Italien, 9999));
        releaseMsdos1_11.addCountryRelease(new CountryRelease(CountryKey.Spanien, 9999));
        releaseMsdos1_11.addCountryRelease(new CountryRelease(CountryKey.UK, 9999));
        releaseGroupDos.addRelease(releaseMsdos1_11);
        
        releaseMsdos1_11.addPhoto(new Photo("M_5630_1101395547_monkey_island_1_9.jpg", PhotoType.unknown, "description not available"));
        releaseMsdos1_11.addPhoto(new Photo("M_5630_1107353849_monkey_island_1_12.jpg", PhotoType.unknown, "description not available"));
        releaseMsdos1_11.addPhoto(new Photo("M_5630_1115992608_monkeyisland1us.JPG", PhotoType.unknown, "description not available"));
        releaseMsdos1_11.addPhoto(new Photo("M_5630_1115992625_monkeyisland1ger.JPG", PhotoType.unknown, "description not available"));
        releaseMsdos1_11.addPhoto(new Photo("S_5630_1162420631_monkey_island_1_18.jpg", PhotoType.unknown, "description not available"));
        releaseMsdos1_11.addPhoto(new Photo("S_5630_1240255705_MonkeyIsland1-Goodies28legacy29.jpg", PhotoType.unknown, "description not available"));
        releaseMsdos1_11.addPhoto(new Photo("S_5630_1255013946_mits.jpg", PhotoType.unknown, "description not available"));
        
        
        
        ReleaseGroup releaseGroupDosDemo = new ReleaseGroup(
        		"DOS", 
        		SystemKey.MSDOS, 
        		ReleaseGroupType.Demo); 
        
        ReleaseGroup releaseGroupDosEnhanced = new ReleaseGroup(
        		"DOS (Verbesserte CD-Version)", 
        		SystemKey.MSDOS, 
        		ReleaseGroupType.Enhanced);         
        
        gameMonkeyIsland.addReleaseGroup(releaseGroupDos);
        gameMonkeyIsland.addReleaseGroup(releaseGroupDosDemo);
        gameMonkeyIsland.addReleaseGroup(releaseGroupDosEnhanced);

        
        //########### Amiga
        ReleaseGroup releaseGroupAmiga = new ReleaseGroup(
        		"Amiga 500/600 (OCS/ECS)",
        		SystemKey.Amiga, 
        		ReleaseGroupType.Original);
        
        Release releaseAmiga4_1 = new Release("Veröffentlichung 4-1 (Amiga, 3,5, DV)", DistributionKey.RegularBox);
        releaseAmiga4_1.addCountryRelease(new CountryRelease(CountryKey.Deutschland, 1991));
        Release releaseAmiga4_2 = new Release("Veröffentlichung 4-2 (Amiga, 3,5, UK)", DistributionKey.RegularBox);
        releaseAmiga4_2.addCountryRelease(new CountryRelease(CountryKey.UK, 1991));
        Release releaseAmiga4_3 = new Release("Veröffentlichung 4-3 (Amiga, 3,5, UK Kixx)", DistributionKey.RegularBox);
        releaseAmiga4_3.addCountryRelease(new CountryRelease(CountryKey.UK, 1994));
        
        releaseAmiga4_1.addPhoto(new Photo("S_5630_1271668192_MonkeyIslandAmigaedit.jpg", PhotoType.unknown, "description not available"));

        releaseGroupAmiga.addRelease(releaseAmiga4_1);
        releaseGroupAmiga.addRelease(releaseAmiga4_2);
        releaseGroupAmiga.addRelease(releaseAmiga4_3);
        
        ReleaseGroup releaseGroupAmigaDemo = new ReleaseGroup(
        		"Amiga 500/600 (OCS/ECS)",
        		SystemKey.Amiga, 
        		ReleaseGroupType.Demo);
       
        gameMonkeyIsland.addReleaseGroup(releaseGroupAmiga);
        gameMonkeyIsland.addReleaseGroup(releaseGroupAmigaDemo);
        
        
        
        //########### Atari ST
        ReleaseGroup releaseGroupAtariST = new ReleaseGroup(
        		"Atari ST",
        		SystemKey.AtariST, 
        		ReleaseGroupType.Original);
        
        Release releaseSt6_1 = new Release("Veröffentlichung 6-1 (Atari ST, 3,5, DV)", DistributionKey.RegularBox);
        releaseSt6_1.addCountryRelease(new CountryRelease(CountryKey.Deutschland, 1991));
        Release releaseSt6_2 = new Release("Veröffentlichung 6-2 (Atari ST, 3,5, US)", DistributionKey.RegularBox);
        releaseSt6_2.addCountryRelease(new CountryRelease(CountryKey.USA, 1991));
        Release releaseSt6_3 = new Release("Veröffentlichung 6-3 (Atari ST, 3,5, UK)", DistributionKey.RegularBox);
        releaseSt6_3.addCountryRelease(new CountryRelease(CountryKey.UK, 1991));

        releaseGroupAtariST.addRelease(releaseSt6_1);
        releaseGroupAtariST.addRelease(releaseSt6_2);
        releaseGroupAtariST.addRelease(releaseSt6_3);
        
        releaseSt6_1.addPhoto(new Photo("S_5630_1155913776_monkey_island_1_16.jpg", PhotoType.unknown, "description not available"));

        
        gameMonkeyIsland.addReleaseGroup(releaseGroupAtariST);

        //########### Apple
        ReleaseGroup releaseGroupApple = new ReleaseGroup(
        		"Apple Macintosh",
        		SystemKey.AppleMacintosh, 
        		ReleaseGroupType.Original);
        
        Release releaseApple7_1 = new Release("Veröffentlichung 7-1 (Apple Macintosh, 3,5, US)", DistributionKey.RegularBox);
        releaseApple7_1.addCountryRelease(new CountryRelease(CountryKey.USA, 1991));
        
        releaseApple7_1.addPhoto(new Photo("S_5630_1198436013_monkey_island_1_27.jpg", PhotoType.unknown, "description not available"));

        releaseGroupApple.addRelease(releaseApple7_1);


        ReleaseGroup vogAppleSpecial = new ReleaseGroup(
        		"Apple Macintosh",
        		SystemKey.AppleMacintosh, 
        		ReleaseGroupType.Enhanced);
        
        gameMonkeyIsland.addReleaseGroup(releaseGroupApple);
        gameMonkeyIsland.addReleaseGroup(vogAppleSpecial);
        
        
        
        gameMonkeyIsland.addTitle(new Title("The Secret of Monkey Island 2", LanguageKey.DE));
        gameMonkeyIsland.addTitle(new Title("The Secret of Monkey Island 2: Le Chuck's Revenge", LanguageKey.EN));
        
        
        entityManager.persist(gameMonkeyIsland);

        tx.commit();
        entityManager.close();
        
        
        //XStream xstream = new XStream();
        //xstream.alias("game", Game.class);
        // turn it into XML and display it - this is how it should be my friends, this easy      
        //String xml = xstream.toXML(spielMonkeyIsland);
        //System.out.println(xml);
        
        

	}
	
}
