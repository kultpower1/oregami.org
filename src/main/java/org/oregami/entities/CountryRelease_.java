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
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.oregami.keyobjects.KeyObjects.CountryKey;

@Generated(value="Dali", date="2012-04-02T23:11:33.116+0200")
@StaticMetamodel(CountryRelease.class)
public class CountryRelease_ extends BaseEntity_ {
	public static volatile SingularAttribute<CountryRelease, Release> release;
	public static volatile SingularAttribute<CountryRelease, CountryKey> country;
	public static volatile SingularAttribute<CountryRelease, Integer> yearOfRelease;
	public static volatile CollectionAttribute<CountryRelease, Screenshot> screenshotList;
	public static volatile CollectionAttribute<CountryRelease, Photo> photoList;
}
