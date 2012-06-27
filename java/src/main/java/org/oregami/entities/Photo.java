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
import javax.persistence.Table;

import org.oregami.keyobjects.KeyObjects.PhotoType;

@Entity
@Table(name = "Photo")
public class Photo extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	private String fileName;
	
	private String description;

	private PhotoType type;

	public Photo() {
		
	}
	
	public Photo(String fileName, PhotoType type, String description) {
		this.fileName = fileName;
		this.type = type;
		this.description = description;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PhotoType getType() {
		return type;
	}

	public void setType(PhotoType type) {
		this.type = type;
	}

}
