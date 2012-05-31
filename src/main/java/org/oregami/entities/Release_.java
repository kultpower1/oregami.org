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
import org.oregami.keyobjects.KeyObjects.DistributionKey;

@Generated(value="Dali", date="2012-04-04T19:08:14.876+0200")
@StaticMetamodel(Release.class)
public class Release_ extends BaseEntity_ {
	public static volatile SingularAttribute<Release, DistributionKey> distribution;
	public static volatile SingularAttribute<Release, ReleaseGroup> releaseGroup;
	public static volatile SingularAttribute<Release, String> description;
	public static volatile SetAttribute<Release, CountryRelease> countryReleaseList;
	public static volatile CollectionAttribute<Release, Photo> photoList;
	public static volatile CollectionAttribute<Release, Screenshot> screenshotList;
}
