package com.fdorigo.igadmin.app;

import org.apache.log4j.Logger;
import org.apache.wicket.DefaultPageManagerProvider;
import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.page.DefaultPageManagerContext;
import org.apache.wicket.pageStore.IDataStore;
import org.apache.wicket.pageStore.memory.HttpSessionDataStore;
import org.apache.wicket.pageStore.memory.PageNumberEvictionStrategy;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.session.HttpSessionStore;
import org.apache.wicket.session.ISessionStore;
import org.apache.wicket.util.IProvider;

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

	public WicketApplication()
	{
		LOG.trace("New Wicket Application");
	}

	@Override
	protected void onUnauthorizedPage(Page page)
	{
		LOG.debug("Unauthorized page requested");
		super.onUnauthorizedPage(page);
	}

	@Override
	public void restartResponseAtSignInPage()
	{
		LOG.debug("Restart at sign in...");
		super.restartResponseAtSignInPage();
	}

	@Override
	public Session newSession(Request request, Response response)
	{
		return new AppSession(request);
	}

	@Override
	protected void init()
	{
		LOG.debug("Init Wicket Application");
		super.init();

		this.setSessionStoreProvider(new IProvider() {

			public ISessionStore get()
			{
				// TODO Auto-generated method stub

				return new HttpSessionStore();
			}
		});

		this.setPageManagerProvider(new DefaultPageManagerProvider(this) {

			@Override
			protected IDataStore newDataStore()
			{
				// TODO Auto-generated method stub
				return new HttpSessionDataStore(new DefaultPageManagerContext(), new PageNumberEvictionStrategy(20));
			}

		});
	}

	@Override
	public Class<? extends Page> getHomePage()
	{
		return HomePage.class;
	}

	@Override
	protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass()
	{
		return AppSession.class;
	}

	@Override
	protected Class<? extends WebPage> getSignInPageClass()
	{
		return LoginPage.class;
	}
}
