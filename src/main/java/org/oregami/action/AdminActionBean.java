package org.oregami.action;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

import org.oregami.util.BaseActionBean;

@UrlBinding("/Admin")
public class AdminActionBean extends BaseActionBean implements ActionBean {

	public Resolution defaultHandler() {
		
		return new ForwardResolution("/jsp/admin/index.jsp");
	}
	
}
