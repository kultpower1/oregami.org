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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import org.oregami.keyobjects.KeyObjects.LanguageKey;


@Entity
public class Title extends BaseEntity {

	private static final long serialVersionUID = 1L;

	public Title () {
	}

	public Title (String name, LanguageKey language) {
		this.name = name;
		this.language = language;
	}
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private LanguageKey language;
	
	@ManyToOne
	private Game game;
	
	public void setGame(Game game) {
		this.game = game;
	}

	public String getName() {
		return name;
	}

	public LanguageKey getLanguage() {
		return language;
	}

}
