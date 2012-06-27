package org.oregami.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.oregami.keyobjects.KeyObjects.ReleaseGroupType;
import org.oregami.keyobjects.KeyObjects.SystemKey;

@Generated(value="Dali", date="2012-06-25T22:10:28.983+0200")
@StaticMetamodel(ReleaseGroup.class)
public class ReleaseGroup_ extends BaseEntity_ {
	public static volatile SingularAttribute<ReleaseGroup, SystemKey> system;
	public static volatile SingularAttribute<ReleaseGroup, ReleaseGroupType> releaseGroupType;
	public static volatile SingularAttribute<ReleaseGroup, String> name;
	public static volatile SingularAttribute<ReleaseGroup, Game> game;
	public static volatile SetAttribute<ReleaseGroup, Release> releaseList;
	public static volatile CollectionAttribute<ReleaseGroup, Screenshot> screenshotList;
}
