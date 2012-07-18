package com.fdorigo.igadmin.app.auth;

import com.fdorigo.igadmin.app.BasePage;
import com.fdorigo.igadmin.app.HomePage;

public class LogoutPage extends BasePage
{
	private static final long serialVersionUID = 2926990292274187038L;

	public LogoutPage()
	{
		((AppSession) getSession()).invalidate();
		setResponsePage(HomePage.class);
	}
}
