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

import org.oregami.keyobjects.Schluessel.DistributionKey;


@Entity
@Table(name="GameRelease")
public class Release extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Enumerated(EnumType.STRING)
	private DistributionKey distributionKey;
	
	@ManyToOne
	private ReleaseGroup releaseGroup;
	
	private String description;

	@OneToMany(mappedBy = "release", cascade = CascadeType.ALL)
	@OrderBy("yearOfRelease")
	private Set<CountryRelease> countryRelease = new HashSet<CountryRelease>();
	
	public Release() {};
	
	public Release(String description, DistributionKey distributionKey) {
		this.description = description;
		this.distributionKey = distributionKey;
	}
	
	public void setReleaseGroup(
			ReleaseGroup releaseGroup) {
		this.releaseGroup = releaseGroup;
	}

	public void addCountryRelease(CountryRelease countryRelease) {
		this.countryRelease.add(countryRelease);
		countryRelease.setRelease(this);
	}

	public DistributionKey getChannelOfDistributionKey() {
		return distributionKey;
	}

	public String getDescription() {
		return description;
	}

	public Set<CountryRelease> getCountryReleaseList() {
		return countryRelease;
	}
	
}
