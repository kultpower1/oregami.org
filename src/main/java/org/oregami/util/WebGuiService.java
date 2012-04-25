package org.oregami.util;

import org.oregami.entities.Game;

public class WebGuiService {

	
	public String getWebGui(Game game) {
		String ret = "";
		ret+= "<ul>\n";
		
		ret += game.toWebString();
		
		ret += "</ul>";
		return ret;
	}
	
	
}
