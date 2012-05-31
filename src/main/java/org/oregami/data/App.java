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

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.oregami.entities.User;
import org.oregami.keyobjects.KeyObjects.RoleKey;


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
