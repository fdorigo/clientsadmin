package com.fdorigo.igadmin.app.auth;

import org.apache.log4j.Logger;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

public class AppSession extends AuthenticatedWebSession
{
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(AppSession.class);
	private static final long serialVersionUID = 1878540573259244794L;
	private User loggedInUser;

	public AppSession(final Request request)
	{
		super(request);
	}

	@Override
	public Roles getRoles()
	{
		Roles roles = new Roles();

		if (isSignedIn())
			roles.add("USER");

		return roles;
	}

	@Override
	public boolean authenticate(String username, String password)
	{
		boolean success = username.equals("guest") && password.equals("guest");

		if (success)
		{
			loggedInUser = new User(username, password);
		}

		return success;
	}
	
	public boolean isUserLoggedIn()
	{
		if (loggedInUser != null)
		{
			return true;
		}
		
		return false;
	}

	public User getLoggedInUser()
	{
		return loggedInUser;
	}

	public void setLoggedInUser(User loggedInUser)
	{
		this.loggedInUser = loggedInUser;
	}
}
