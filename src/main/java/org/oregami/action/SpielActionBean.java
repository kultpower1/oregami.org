package org.oregami.action;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

import org.oregami.data.App;
import org.oregami.data.SpielDAO;
import org.oregami.entities.Game;
import org.oregami.util.BaseActionBean;


@UrlBinding("/Spiel/{spielId=2}")
public class SpielActionBean extends BaseActionBean implements ActionBean {

	private Game geladenesSpiel = null;
	private String spielId;
	
	public Resolution defaultHandler() {
		
		geladenesSpiel = SpielDAO.ladeSpiel(1);
		if (geladenesSpiel==null) {
			App.initMonkeyIsland();
			App.initResidentEvil();
			App.initUser();
		}
		
		geladenesSpiel = SpielDAO.ladeSpiel(Integer.parseInt(spielId));
		System.out.println("Geladen: " + geladenesSpiel.getMainTitle() + " (" + geladenesSpiel.getDescription() + ")");
		return new ForwardResolution("/jsp/spiel.jsp");
	}


	public String getSpielId() {
		return spielId;
	}

	public void setSpielId(String spielId) {
		this.spielId = spielId;
	}

	public Game getGeladenesSpiel() {
		return geladenesSpiel;
	}
}
