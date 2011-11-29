package org.oregami.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import org.oregami.keyobjects.Schluessel.LanguageKey;


@Entity
public class Title extends BaseEntity {

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
