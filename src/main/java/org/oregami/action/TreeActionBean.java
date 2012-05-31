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
package org.oregami.action;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.controller.LifecycleStage;

import org.oregami.data.App;
import org.oregami.data.GameDAO;
import org.oregami.data.HibernateJpaUtil;
import org.oregami.entities.Game;
import org.oregami.util.BaseActionBean;
import org.oregami.util.WebGuiService;


@UrlBinding("/tree/{gameId=2}")
public class TreeActionBean extends BaseActionBean implements ActionBean {

	private Game loadedGame = null;
	private String gameId;
	
	EntityTransaction txLocal;
	EntityManager entityManagerLocal;
	
	public Resolution defaultHandler() {
		
		App.ensureDatabaseIsFilled();
		
		loadedGame = GameDAO.loadGameById(Integer.parseInt(gameId));
		System.out.println("Geladen: " + loadedGame.getMainTitle() + " (" + loadedGame.getDescription() + ")");
		return new ForwardResolution("/jsp/tree.jsp");
	}

	@net.sourceforge.stripes.action.Before
	public void before() {
        EntityManagerFactory entityManagerFactory = HibernateJpaUtil.getEntityManagerFactory();
        entityManagerLocal = entityManagerFactory.createEntityManager();
        txLocal = entityManagerLocal.getTransaction();
        txLocal.begin();
	}
	
	@net.sourceforge.stripes.action.After(stages=LifecycleStage.ResolutionExecution)
	public void after() {
		txLocal.commit();
		entityManagerLocal.close();
	}	
	
	
	
	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public Game getLoadedGame() {
		return loadedGame;
	}
	
	public String getTreeString() {
		return new WebGuiService().getWebGui(loadedGame);
	}
}
