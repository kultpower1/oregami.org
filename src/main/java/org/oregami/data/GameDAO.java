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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import javax.persistence.Query;

import org.oregami.entities.Game;
import org.oregami.entities.User;


public class GameDAO {

	
	public static Game loadGameById(int id) {
		Game s = null;
		
        EntityManagerFactory entityManagerFactory = HibernateJpaUtil.getEntityManagerFactory();
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        
        s = entityManager.find(Game.class, new Long("" + id));
		
        tx.commit();
        
        //hier *nicht* schließen, sonst können andere Entities nicht mehr "lazy" nachgeladen werden
        //entityManager.close();
        
		return s;
	}
	
	public static List<Game> getAllGames() {
		
		List<Game> list = new ArrayList<Game>();
		
		EntityManagerFactory entityManagerFactory = HibernateJpaUtil.getEntityManagerFactory();
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        
		Query query = entityManager.createQuery("SELECT s FROM Game s");
		List lst = query.getResultList();
		Iterator it = lst.iterator();
		while (it.hasNext()){
			Game s = (Game) it.next();
			list.add(s);
			System.out.println(" Name:"+s.getMainTitle());
			
		}
		
		entityManager.close();
		
		return list;
		
	}
	
	public static void deleteAllGames() {
		
//		if (true) {
			EntityManagerFactory entityManagerFactory = HibernateJpaUtil.getEntityManagerFactory();
	        
	        EntityManager entityManager = entityManagerFactory.createEntityManager();
	        EntityTransaction tx = entityManager.getTransaction();
	        tx.begin();
	        
			Query query = entityManager.createQuery("SELECT s FROM Game s").setLockMode(LockModeType.NONE);
			List lst = query.getResultList();
			Iterator it = lst.iterator();
			while (it.hasNext()){
				Game s = (Game) it.next();
				s = entityManager.merge(s);
				entityManager.remove(s);
				entityManager.flush();
			}
			tx.commit();
			entityManager.close();
			System.out.println(query.getLockMode());
//		}
		
//		if (true) {
			EntityManager entityManager3 = HibernateJpaUtil.getEntityManagerFactory().createEntityManager();
			EntityTransaction tx3 = entityManager3.getTransaction();
			tx3.begin();
			Query query2=entityManager3.createNativeQuery("ALTER TABLE Game AUTO_INCREMENT=1");
			query2.executeUpdate();
			tx3.commit();
			entityManager3.close();
//		}
		
		EntityManager entityManager2 = HibernateJpaUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx2 = entityManager2.getTransaction();
		tx2.begin();
		Query query3=entityManager2.createNativeQuery("FLUSH TABLE Game");
		query3.executeUpdate();
		tx2.commit();
		entityManager2.close();
		
	}
	
	
	public static void deleteAllUsers() {
		
		EntityManagerFactory entityManagerFactory = HibernateJpaUtil.getEntityManagerFactory();
        
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        
		Query query = entityManager.createQuery("SELECT s FROM User s");
		List lst = query.getResultList();
		Iterator it = lst.iterator();
		while (it.hasNext()){
			User s = (User) it.next();
			s = entityManager.merge(s);
			entityManager.remove(s);
			entityManager.flush();
		}
		tx.commit();
		entityManager.close();
		
	}
}
