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
import javax.persistence.Table;

import org.oregami.keyobjects.KeyObjects.DistributionKey;


@Entity
@Table(name="GameRelease")
public class Release extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Enumerated(EnumType.STRING)
	private DistributionKey distribution;
	
	@ManyToOne
	private ReleaseGroup releaseGroup;
	
	private String description;

	@OneToMany(mappedBy = "release", cascade = CascadeType.ALL)
	@OrderBy("yearOfRelease")
	private Set<CountryRelease> countryReleaseList = new HashSet<CountryRelease>();
	
	public Release() {};
	
	public Release(String description, DistributionKey distribution) {
		this.description = description;
		this.distribution = distribution;
	}
	
	public void setReleaseGroup(
			ReleaseGroup releaseGroup) {
		this.releaseGroup = releaseGroup;
	}

	public void addCountryRelease(CountryRelease countryRelease) {
		this.countryReleaseList.add(countryRelease);
		countryRelease.setRelease(this);
	}

	public DistributionKey getDistribution() {
		return distribution;
	}

	public String getDescription() {
		return description;
	}

	public Set<CountryRelease> getCountryReleaseList() {
		return countryReleaseList;
	}
	
}
