package org.oregami.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;


@Entity
public class Game extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2362683596950421365L;

	private String mainTitle;
	
	private String description;
	
	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
	@OrderBy("system ASC")
	private Set<ReleaseGroup> releaseGroupList = new HashSet<ReleaseGroup>();

	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
	@OrderBy("name ASC")
	private Set<Title> titleList = new HashSet<Title>();

	
	public void addReleaseGroup(ReleaseGroup vog) {
		this.releaseGroupList.add(vog);
		vog.setGame(this);
	}

	public void addTitle(Title t) {
		this.titleList.add(t);
		t.setGame(this);
	}

	public Set<Title> getTitleList() {
		return titleList;
	}

	public Set<ReleaseGroup> getReleaseGroupList() {
		return releaseGroupList;
	}

	public String getMainTitle() {
		return mainTitle;
	}

	public void setMainTitle(String mainTitle) {
		this.mainTitle = mainTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
