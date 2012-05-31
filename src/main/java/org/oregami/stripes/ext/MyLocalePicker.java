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
package org.oregami.stripes.ext;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sourceforge.stripes.localization.DefaultLocalePicker;

public class MyLocalePicker extends DefaultLocalePicker {
	
	public static final String LOCALE = "locale";
	
	@Override
	public Locale pickLocale(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		String locale = request.getParameter(LOCALE);
		if (locale!=null) {
			session.setAttribute(LOCALE, locale);
		}
		else {
			locale = (String) session.getAttribute(LOCALE);
		}
		
		if (locale!=null) {
			return new Locale(locale);
		}
		
		//sonst: super-Wert zurückgeben
		return super.pickLocale(request);
	}

}
