package com.softgraf.security;

import jakarta.annotation.security.DeclareRoles;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.security.enterprise.authentication.mechanism.http.FormAuthenticationMechanismDefinition;
import jakarta.security.enterprise.authentication.mechanism.http.LoginToContinue;

//@FormAuthenticationMechanismDefinition(
//		loginToContinue = @LoginToContinue(
//				loginPage = "/login.html",
//				errorPage = "/login-error.html"
//		)
//)
//
//@DeclareRoles({"admin", "user"})
//@FacesConfig  // version default = 2.3
//@ApplicationScoped
public class FormConfig {

}
