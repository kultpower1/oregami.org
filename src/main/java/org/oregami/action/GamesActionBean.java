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

import java.util.List;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

import org.oregami.data.App;
import org.oregami.data.GameDAO;
import org.oregami.entities.Game;
import org.oregami.util.BaseActionBean;

@UrlBinding("/games")
public class GamesActionBean extends BaseActionBean implements ActionBean {

	private List<Game> gameList = null;
	
	public Resolution defaultHandler() {
		
		App.ensureDatabaseIsFilled();
		
		gameList = GameDAO.getAllGames();
		return new ForwardResolution("/jsp/gameslist.jsp");

		//return new RedirectResolution("/game");
	}

	public List<Game> getGameList() {
		return gameList;
	}
	
}
