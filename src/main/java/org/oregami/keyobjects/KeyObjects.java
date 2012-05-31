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
package org.oregami.keyobjects;

public class KeyObjects {
	
	public enum SystemKey {Amiga, C64, MSDOS, AtariST, AppleMacintosh, SonyPlaystation, NintendoWii, NintendoGamecube, SegaSaturn, Windows};
	public enum DistributionKey {RegularBox};
	public enum LanguageKey {DE, EN};
	
	public enum CountryKey {
		Deutschland, USA, Australien, HongKong, Taiwan, Frankreich, Italien, Spanien, UK, Japan, Oesterreich
	};
	
	public enum ReleaseGroupType {
		Original, Enhanced, Demo, Remake
	};
	
	public enum x {a, b};
	
	public enum RoleKey {Admin, User};
	
	public enum ScreenshotType {unknown, title, intro, outro, companylogo, gameplayBeginningOfGame, gameplayMiddleOfGame, gameplayEndOfGame};
	
	public enum PhotoType {unknown, BoxFront, BoxBack, CompactDisc, Disc, Poster, Goodie};
	
 
}
