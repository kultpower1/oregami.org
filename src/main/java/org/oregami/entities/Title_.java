package org.oregami.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.oregami.keyobjects.KeyObjects.LanguageKey;

@Generated(value="Dali", date="2012-04-02T22:11:44.709+0200")
@StaticMetamodel(Title.class)
public class Title_ extends BaseEntity_ {
	public static volatile SingularAttribute<Title, String> name;
	public static volatile SingularAttribute<Title, LanguageKey> language;
	public static volatile SingularAttribute<Title, Game> game;
}
