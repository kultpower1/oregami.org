package org.oregami.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.oregami.keyobjects.KeyObjects.CountryKey;

@Generated(value="Dali", date="2012-06-25T22:10:28.917+0200")
@StaticMetamodel(CountryRelease.class)
public class CountryRelease_ extends BaseEntity_ {
	public static volatile SingularAttribute<CountryRelease, Release> release;
	public static volatile SingularAttribute<CountryRelease, CountryKey> country;
	public static volatile SingularAttribute<CountryRelease, Integer> yearOfRelease;
	public static volatile CollectionAttribute<CountryRelease, Screenshot> screenshotList;
	public static volatile CollectionAttribute<CountryRelease, Photo> photoList;
}
