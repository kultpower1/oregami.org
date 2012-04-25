package org.oregami.data;

import org.oregami.entities.Game;
import org.oregami.util.WebGuiService;

public class WebApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		App.ensureDatabaseIsFilled();
		
		Game monkeyIsland = GameDAO.loadGameById(1);
		
		WebGuiService service = new WebGuiService();
		
		String webGui = service.getWebGui(monkeyIsland);
		
		System.out.println(webGui);

	}

}
