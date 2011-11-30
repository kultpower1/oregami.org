package org.oregami.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2011-11-30T08:33:15.726+0100")
@StaticMetamodel(Game.class)
public class Game_ extends BaseEntity_ {
	public static volatile SingularAttribute<Game, String> mainTitle;
	public static volatile SingularAttribute<Game, String> description;
	public static volatile SetAttribute<Game, Title> title;
	public static volatile SetAttribute<Game, ReleaseGroup> releaseGroupList;
}
