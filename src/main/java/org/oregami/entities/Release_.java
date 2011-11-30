package org.oregami.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.oregami.keyobjects.KeyObjects.DistributionKey;

@Generated(value="Dali", date="2011-11-30T09:47:18.794+0100")
@StaticMetamodel(Release.class)
public class Release_ extends BaseEntity_ {
	public static volatile SingularAttribute<Release, DistributionKey> distribution;
	public static volatile SingularAttribute<Release, ReleaseGroup> releaseGroup;
	public static volatile SingularAttribute<Release, String> description;
	public static volatile SetAttribute<Release, CountryRelease> countryReleaseList;
}
