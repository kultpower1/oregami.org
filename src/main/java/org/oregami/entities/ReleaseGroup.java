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
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.oregami.keyobjects.KeyObjects.ReleaseGroupType;
import org.oregami.keyobjects.KeyObjects.SystemKey;


@Entity
public class ReleaseGroup extends BaseEntity implements WebGui {

	private static final long serialVersionUID = 1L;

	@Enumerated(EnumType.STRING)
	private SystemKey system;

	@Enumerated(EnumType.STRING)
	private ReleaseGroupType releaseGroupType;
	
	private String name;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Game game;

	@OneToMany(mappedBy = "releaseGroup", cascade = CascadeType.ALL, orphanRemoval=true)
	@OrderBy("description ASC")
	private Set<Release> releaseList = new HashSet<Release>();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
	private Collection<Screenshot> screenshotList = new ArrayList<Screenshot>();

	
	public ReleaseGroup() {
	}
	
	public ReleaseGroup(String name, SystemKey system, ReleaseGroupType releaseGroupType) {
		this.name = name;
		this.system=system;
		this.releaseGroupType = releaseGroupType;
	}
	
	
	public SystemKey getSystem() {
		return system;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	public void addRelease(Release vo) {
		this.releaseList.add(vo);
		vo.setReleaseGroup(this);
	}

	public ReleaseGroupType getReleaseGroupType() {
		return releaseGroupType;
	}

	public String getName() {
		return name;
	}

	public Set<Release> getReleaseList() {
		return releaseList;
	}

	@Override
	public String toWebString() {
		String ret = "";
		
		ret += "<li>" + this.getSystem().toString() + " (" + this.getReleaseGroupType().toString() + ")\n";
		
		ret += "<ul>\n";
		ret += "<li class='folder'>Releases (" + getReleaseList().size() + ")\n"
				;
		Set<Release> releaseList = this.getReleaseList();
		ret += "<ul>\n";
		for (Release release : releaseList) {
			ret += release.toWebString();
		}
		ret += "</ul>\n";
		ret += "</li>";
		ret += "</ul>";
		
		ret += "</li>\n";
		
		return ret;
	}

	public Collection<Screenshot> getScreenshotList() {
	    return screenshotList;
	}

	public void setScreenshotList(Collection<Screenshot> param) {
	    this.screenshotList = param;
	}
	
	public void addScreenshot(Screenshot screenshot) {
		this.screenshotList.add(screenshot);
		//screenshot.set(this);
	}
	
}
