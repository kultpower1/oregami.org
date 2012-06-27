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
