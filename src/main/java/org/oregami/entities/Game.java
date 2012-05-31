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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.oregami.keyobjects.KeyObjects.SystemKey;


@Entity
public class Game extends BaseEntity implements WebGui {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2362683596950421365L;
	
	private String mainTitle;
	
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
	@OrderBy("system ASC")
	@JoinColumn
	private Collection<ReleaseGroup> releaseGroupList = new ArrayList<ReleaseGroup>();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
	@OrderBy("name ASC")
	@JoinColumn
	private Collection<Title> titleList = new ArrayList<Title>();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
	@JoinColumn
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
	
	public String toJson() {
		StringBuffer json = new StringBuffer("");
		json.append("{\n");
		json.append("attributes: { id : 'node_1' , rel : 'drive' },\n");
		json.append("data: 'game: " + this.getMainTitle() + "',\n");
		json.append("}");
		/*
{ 
	attributes: { id : "node_1" , rel : "drive" }, 
	data: "C:", 
	icons: "images/hd.png",
	state: "open",
	children: [
		 */
		return json.toString();
	}

	@Override
	public String toWebString() {
		
		String ret = "";
		ret += "<li>" + this.getMainTitle() + "</li>\n";
		ret += "<li class='folder'>ReleaseGroups (" + releaseGroupList.size() + ")\n";
		ret += "<ul>\n";
		for (ReleaseGroup releaseGroup : this.getReleaseGroupList()) {
			ret += releaseGroup.toWebString();
		}
		ret += "</ul>\n";
		ret += "</li>\n";
		
		
		if (this.getScreenshotList().size()>0) {
			ret += "<li class='folder'>Screenshots (" + this.getScreenshotList().size() + ")\n";
			ret += "<ul>\n";
			ret += "<li><span>";
			for (Screenshot screen : this.getScreenshotList()) {
				ret += "<img style='padding:2px;' src=\"/web/images/screenshots/" + screen.getFileName() + "\">";
			}
			ret += "</span>";
			ret += "</ul>\n";
			ret += "</li>\n";		
		}
		
		return ret;
		
	}
	
}
