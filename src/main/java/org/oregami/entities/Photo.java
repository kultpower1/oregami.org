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