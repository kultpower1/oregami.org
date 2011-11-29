package org.oregami.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.oregami.keyobjects.Schluessel.ReleaseGroupType;
import org.oregami.keyobjects.Schluessel.SystemKey;

@Generated(value="Dali", date="2011-11-29T20:41:51.565+0100")
@StaticMetamodel(ReleaseGroup.class)
public class ReleaseGroup_ extends BaseEntity_ {
	public static volatile SingularAttribute<ReleaseGroup, SystemKey> system;
	public static volatile SingularAttribute<ReleaseGroup, ReleaseGroupType> releaseGroupType;
	public static volatile SingularAttribute<ReleaseGroup, String> name;
	public static volatile SingularAttribute<ReleaseGroup, Game> game;
	public static volatile SetAttribute<ReleaseGroup, Release> releaseList;
}
