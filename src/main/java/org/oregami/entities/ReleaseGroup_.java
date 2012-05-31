/*******************************************************************************
 * Copyright (C) 2012  Oregami.org, Germany http://www.oregami.org
 * 
 * 	This program is free software: you can redistribute it and/or modify
 * 	it under the terms of version 3 or any later version of the
 * 	GNU Affero General Public License as published by the Free Software 
 * 	Foundation.
 * 	
 * 	This program is distributed in the hope that it will be useful,
 * 	but WITHOUT ANY WARRANTY; without even the implied warranty of
 * 	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * 	GNU Affero General Public License for more details.	
 * 	
 * 	You should have received a copy of the GNU Affero General Public License
 * 	along with this program. If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package org.oregami.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.oregami.keyobjects.KeyObjects.ReleaseGroupType;
import org.oregami.keyobjects.KeyObjects.SystemKey;

@Generated(value="Dali", date="2012-04-02T22:38:49.090+0200")
@StaticMetamodel(ReleaseGroup.class)
public class ReleaseGroup_ extends BaseEntity_ {
	public static volatile SingularAttribute<ReleaseGroup, SystemKey> system;
	public static volatile SingularAttribute<ReleaseGroup, ReleaseGroupType> releaseGroupType;
	public static volatile SingularAttribute<ReleaseGroup, String> name;
	public static volatile SingularAttribute<ReleaseGroup, Game> game;
	public static volatile SetAttribute<ReleaseGroup, Release> releaseList;
	public static volatile CollectionAttribute<ReleaseGroup, Screenshot> screenshotList;
}
