package org.oregami.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.oregami.keyobjects.KeyObjects.ScreenshotType;

@Generated(value="Dali", date="2011-12-01T13:05:52.967+0100")
@StaticMetamodel(Screenshot.class)
public class Screenshot_ extends BaseEntity_ {
	public static volatile SingularAttribute<Screenshot, String> description;
	public static volatile SingularAttribute<Screenshot, String> fileName;
	public static volatile SingularAttribute<Screenshot, ScreenshotType> screenshotType;
	public static volatile SingularAttribute<Screenshot, Game> game;
}
