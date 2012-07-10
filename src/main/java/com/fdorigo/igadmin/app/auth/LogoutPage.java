package com.fdorigo.igadmin.app.auth;

import com.fdorigo.igadmin.app.BasePage;

public class LogoutPage extends BasePage
{
	private static final long serialVersionUID = 2926990292274187038L;

	public LogoutPage()
	{
		if (((AppSession) getSession()).isUserLoggedIn())
		{
			((AppSession) getSession()).setLoggedInUser(null);
			setResponsePage(LoginPage.class);
		}
	}
}
