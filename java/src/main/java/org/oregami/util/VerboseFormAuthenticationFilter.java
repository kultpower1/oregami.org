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
package org.oregami.util;

import javax.servlet.ServletRequest;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class VerboseFormAuthenticationFilter extends FormAuthenticationFilter {

@Override
protected void setFailureAttribute(ServletRequest request, AuthenticationException ae) {
	if (ae instanceof IncorrectCredentialsException) {
		System.out.println("Falsches Passwort.");
	} else 	if (ae instanceof UnknownAccountException) {
		System.out.println("Unbekannter User.");
	}
		
	String message = ae.getMessage();
	System.out.println("Login-Failure: " + message);
	request.setAttribute(getFailureKeyAttribute(), message);
}

}
