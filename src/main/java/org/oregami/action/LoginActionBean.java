package org.oregami.action;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.oregami.util.BaseActionBean;

@UrlBinding("/Login")
public class LoginActionBean extends BaseActionBean implements ActionBean {

	public Resolution defaultHandler() {
		
		Subject currentUser = SecurityUtils.getSubject();
		System.out.println("Username: " + currentUser.getPrincipal());
		
		return new ForwardResolution("/jsp/login.jsp");
	}
	
}
