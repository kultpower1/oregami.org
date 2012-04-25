package org.oregami.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.oregami.keyobjects.KeyObjects.PhotoType;

@Generated(value="Dali", date="2012-04-02T22:29:20.474+0200")
@StaticMetamodel(Photo.class)
public class Photo_ extends BaseEntity_ {
	public static volatile SingularAttribute<Photo, String> fileName;
	public static volatile SingularAttribute<Photo, String> description;
	public static volatile SingularAttribute<Photo, PhotoType> type;
}
