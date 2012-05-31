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
import org.oregami.entities.Release;
import org.oregami.entities.ReleaseGroup;
import org.oregami.entities.Title;
import org.oregami.keyobjects.KeyObjects.CountryKey;
import org.oregami.keyobjects.KeyObjects.DistributionKey;
import org.oregami.keyobjects.KeyObjects.LanguageKey;
import org.oregami.keyobjects.KeyObjects.ReleaseGroupType;
import org.oregami.keyobjects.KeyObjects.SystemKey;

public abstract class XWing {

	
	public static void init() {
        EntityManagerFactory entityManagerFactory = HibernateJpaUtil.getEntityManagerFactory();
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        
        Game gameXWing = new Game();
        //gameXWing.setId(3l);
        
        gameXWing.setMainTitle("X-Wing");
        gameXWing.addTitle(new Title("Star Wars - X-Wing: Space Combat Simulator", LanguageKey.EN));
        gameXWing.addTitle(new Title("Star Wars - X-Wing", LanguageKey.EN));
        

        ReleaseGroup rgDos = new ReleaseGroup(
        		"DOS", 
        		SystemKey.MSDOS, 
        		ReleaseGroupType.Original);
        gameXWing.addReleaseGroup(rgDos);
        
        Release rgDos1_1 = new Release("Release 1-1 (PC, 3,5, EV mit dt. Handbuch))", DistributionKey.RegularBox);
        rgDos1_1.addCountryRelease(new CountryRelease(CountryKey.Deutschland, 1993));
        rgDos.addRelease(rgDos1_1);

        Release rgDos1_2 = new Release("Release 1-2 (PC, 3,5, DV)", DistributionKey.RegularBox);
        rgDos1_2.addCountryRelease(new CountryRelease(CountryKey.Deutschland, 1993));
        rgDos.addRelease(rgDos1_2);

        Release rgDos1_3 = new Release("Release 1-3 (PC, 3,5, US)", DistributionKey.RegularBox);
        rgDos1_3.addCountryRelease(new CountryRelease(CountryKey.USA, 1993));
        rgDos.addRelease(rgDos1_3);
        
        Release rgDos1_4 = new Release("Release 1-4 (PC, 3,5, UK)", DistributionKey.RegularBox);
        rgDos1_4.addCountryRelease(new CountryRelease(CountryKey.UK, 1993));
        rgDos.addRelease(rgDos1_4);
        
        
        
        ReleaseGroup rgDosEnhanced = new ReleaseGroup(
        		"DOS", 
        		SystemKey.MSDOS, 
        		ReleaseGroupType.Enhanced);
        gameXWing.addReleaseGroup(rgDosEnhanced);
        
        
        ReleaseGroup rgWinEnhanced = new ReleaseGroup(
        		"Windows", 
        		SystemKey.Windows, 
        		ReleaseGroupType.Enhanced);
        gameXWing.addReleaseGroup(rgWinEnhanced);        
        
        
        ReleaseGroup rgMacEnhanced = new ReleaseGroup(
        		"Apple Macintosh", 
        		SystemKey.AppleMacintosh, 
        		ReleaseGroupType.Enhanced);
        gameXWing.addReleaseGroup(rgMacEnhanced);         
        
        entityManager.persist(gameXWing);

        tx.commit();
        entityManager.close();
        

	}
	
}
