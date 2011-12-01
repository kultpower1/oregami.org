package org.oregami.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.oregami.keyobjects.KeyObjects.SystemKey;


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
	private Collection<ReleaseGroup> releaseGroupList = new ArrayList<ReleaseGroup>();

	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
	@OrderBy("name ASC")
	private Collection<Title> titleList = new ArrayList<Title>();

	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
	private Collection<Screenshot> screenshotList = new ArrayList<Screenshot>();

	
	public void addReleaseGroup(ReleaseGroup vog) {
		this.releaseGroupList.add(vog);
		vog.setGame(this);
	}

	public void addTitle(Title t) {
		this.titleList.add(t);
		t.setGame(this);
	}

	public Collection<Title> getTitleList() {
		return titleList;
	}

	public Collection<ReleaseGroup> getReleaseGroupList() {
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

	public Collection<Screenshot> getScreenshotList() {
		return screenshotList;
	}

	public void addScreenshot(Screenshot screenshot) {
		this.screenshotList.add(screenshot);
		screenshot.setGame(this);
	}
	
	
	public Map<SystemKey, Collection<ReleaseGroup>> getSystemToReleaseGroupMap() {
		Map<SystemKey, Collection<ReleaseGroup>> map = new TreeMap<SystemKey, Collection<ReleaseGroup>>();
		
		Iterator<ReleaseGroup> rgIterator = getReleaseGroupList().iterator();
		while (rgIterator.hasNext()) {
			ReleaseGroup releaseGroup = (ReleaseGroup) rgIterator.next();
			if (map.get(releaseGroup.getSystem())==null) {
				map.put(releaseGroup.getSystem(), new ArrayList<ReleaseGroup>());
			}
			map.get(releaseGroup.getSystem()).add(releaseGroup);
		}
		
		return map;
		
	}
	
}
