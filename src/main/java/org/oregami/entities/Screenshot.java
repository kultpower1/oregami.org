package org.oregami.entities;

import javax.persistence.Entity;

import org.oregami.keyobjects.KeyObjects.ScreenshotType;


@Entity
public class Screenshot extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String fileName;
	
	private String description;

	private ScreenshotType screenshotType;
	
	public Screenshot() { };
	
	public Screenshot(String fileName, ScreenshotType screenshotType, String description) {
		this.fileName = fileName;
		this.screenshotType = screenshotType;
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

	public ScreenshotType getScreenshotType() {
		return screenshotType;
	}

	public void setScreenshotType(ScreenshotType screenshotType) {
		this.screenshotType = screenshotType;
	}
	
	
}
