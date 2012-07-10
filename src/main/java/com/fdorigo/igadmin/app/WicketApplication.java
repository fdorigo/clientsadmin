package com.fdorigo.igadmin.app;

import org.apache.cayenne.BaseContext;
import org.apache.cayenne.access.DataContext;
import org.apache.log4j.Logger;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.markup.html.WebPage;

import com.fdorigo.igadmin.app.auth.AppSession;
import com.fdorigo.igadmin.app.auth.LoginPage;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 * 
 * @see com.fdorigo.igadmin.Start#main(String[])
 */
public class WicketApplication extends AuthenticatedWebApplication
{
	private static final Logger LOG = Logger.getLogger(WicketApplication.class);

	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<HomePage> getHomePage()
	{
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();
		BaseContext.bindThreadObjectContext(DataContext.createDataContext());
		LOG.debug("Here we go...");
	}

	@Override
	protected Class<? extends WebPage> getSignInPageClass()
	{
		return LoginPage.class;
	}

	@Override
	protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass()
	{
		return AppSession.class;
	}
}
