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
