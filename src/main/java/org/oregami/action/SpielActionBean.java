package org.oregami.action;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

import org.oregami.data.App;
import org.oregami.data.SpielDAO;
import org.oregami.entities.Game;
import org.oregami.util.BaseActionBean;


@UrlBinding("/game/{gameId=2}")
public class SpielActionBean extends BaseActionBean implements ActionBean {

	private Game loadedGame = null;
	private String gameId;
	
	public Resolution defaultHandler() {
		
		loadedGame = SpielDAO.ladeSpiel(1);
		if (loadedGame==null) {
			App.initMonkeyIsland();
			App.initResidentEvil();
			App.initUser();
		}
		
		loadedGame = SpielDAO.ladeSpiel(Integer.parseInt(gameId));
		System.out.println("Geladen: " + loadedGame.getMainTitle() + " (" + loadedGame.getDescription() + ")");
		return new ForwardResolution("/jsp/spiel.jsp");
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
}
