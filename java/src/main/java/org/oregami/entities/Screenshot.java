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
package org.oregami.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.oregami.keyobjects.KeyObjects.ScreenshotType;


@Entity
public class Screenshot extends BaseEntity implements WebGui {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String fileName;
	
	private String description;

	private ScreenshotType screenshotType;
	
	@ManyToOne
	private Game game;
	
	public Screenshot() { };
	
	public Screenshot(String fileName, ScreenshotType screenshotType, String description) {
		this.fileName = fileName;
		this.screenshotType = screenshotType;
		this.description = description;
	}
	
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ScreenshotType getScreenshotType() {
		return screenshotType;
	}

	public void setScreenshotType(ScreenshotType screenshotType) {
		this.screenshotType = screenshotType;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	@Override
	public String toWebString() {
		String ret = "";
		
		ret += "<li data=\"pic: 'images/screenshots/" + this.getFileName()  + "'\">" + this.getFileName() + " (" + this.getScreenshotType() + ")</li>\n";
		
		return ret;
	}
	
	
}
