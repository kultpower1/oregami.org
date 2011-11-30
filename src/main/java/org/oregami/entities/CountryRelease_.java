package org.oregami.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.oregami.keyobjects.KeyObjects.CountryKey;

@Generated(value="Dali", date="2011-11-29T20:35:42.319+0100")
@StaticMetamodel(CountryRelease.class)
public class CountryRelease_ extends BaseEntity_ {
	public static volatile SingularAttribute<CountryRelease, Release> release;
	public static volatile SingularAttribute<CountryRelease, CountryKey> country;
	public static volatile SingularAttribute<CountryRelease, Integer> yearOfRelease;
}
