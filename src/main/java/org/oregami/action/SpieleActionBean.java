package org.oregami.action;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

import org.oregami.util.BaseActionBean;

@UrlBinding("/games")
public class SpieleActionBean extends BaseActionBean implements ActionBean {

	public Resolution defaultHandler() {
		
		return new RedirectResolution("/game");
	}
	
}
