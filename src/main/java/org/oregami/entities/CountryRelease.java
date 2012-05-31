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
import javax.persistence.ManyToOne;

import org.oregami.keyobjects.KeyObjects.CountryKey;
import org.oregami.entities.Screenshot;
import java.util.Collection;
import javax.persistence.OneToMany;
import org.oregami.entities.Photo;

@Entity
public class CountryRelease extends BaseEntity implements WebGui {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Release release;
	
	private CountryKey country;
	
	private int yearOfRelease;

	@OneToMany
	private Collection<Screenshot> screenshotList;

	@OneToMany
	private Collection<Photo> photoList;
	
	
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

	@Override
	public String toWebString() {
		String ret = "";
		
		ret += "<li>" + this.getCountry().toString() + ": (" + this.getYearOfRelease() + ")\n";
		
		ret += "</li>\n";
		
		return ret;
	}

	public Collection<Screenshot> getScreenshotList() {
	    return screenshotList;
	}

	public void setScreenshotList(Collection<Screenshot> param) {
	    this.screenshotList = param;
	}

	public Collection<Photo> getPhotoList() {
	    return photoList;
	}

	public void setPhotoList(Collection<Photo> param) {
	    this.photoList = param;
	}


}
