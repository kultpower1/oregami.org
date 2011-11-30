package org.oregami.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.oregami.keyobjects.Schluessel.SystemKey;
import org.oregami.keyobjects.Schluessel.ReleaseGroupType;


@Entity
public class ReleaseGroup extends BaseEntity {


	@Enumerated(EnumType.STRING)
	private SystemKey system;

	@Enumerated(EnumType.STRING)
	private ReleaseGroupType releaseGroupType;
	
	private String name;
	
	@ManyToOne
	private Game game;

	@OneToMany(mappedBy = "releaseGroup", cascade = CascadeType.ALL)
	@OrderBy("description ASC")
	private Set<Release> releaseList = new HashSet<Release>();

	
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
	
}
