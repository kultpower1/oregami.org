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