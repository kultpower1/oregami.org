package org.oregami.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.oregami.keyobjects.KeyObjects.CountryKey;

@Entity
public class CountryRelease extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Release release;
	
	private CountryKey country;
	
	private int yearOfRelease;
	
	
	public CountryRelease() {
	}
	
	public CountryRelease(CountryKey country, int year) {
		this.country = country;
		this.yearOfRelease = year;
	}
	
	
	public void setRelease(Release release) {
		this.release = release;
	}

	public int getYearOfRelease() {
		return yearOfRelease;
	}

	public CountryKey getCountry() {
		return country;
	}

	public void setCountry(CountryKey country) {
		this.country = country;
	}

	public Release getRelease() {
		return release;
	}

	public void setYearOfRelease(int year) {
		this.yearOfRelease = year;
	}


}
